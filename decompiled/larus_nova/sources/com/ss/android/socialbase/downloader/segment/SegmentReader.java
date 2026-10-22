package com.ss.android.socialbase.downloader.segment;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy;
import com.ss.android.socialbase.downloader.downloader.NetworkRetryStrategy;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadStenographer;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
class SegmentReader implements Runnable {
    private static final int SEGMENT_APPLY_RETRY_MAX_COUNT = 50;
    private static final int SWITCH_URL_MAX_COUNT = 30;
    private static final String TAG = "SegmentReader";
    private volatile boolean changeSegment;
    private volatile boolean closed;
    volatile long connectEndTime;
    volatile long connectStartTime;
    String curHostIp;
    String curHostRealIp;
    private int curRetryCount;
    volatile Segment curSegment;
    private volatile long curSegmentReadOffset;
    String curUrl;
    private final DownloadInfo downloadInfo;
    private final DownloadTask downloadTask;
    private volatile long endOffsetInConnection;
    private boolean exited;
    private boolean failed;
    private BaseException failedException;
    private NetworkFailoverStrategy failoverStrategy;
    private Future future;
    private final ISegmentCallback host;
    private IDownloadHttpConnection httpConnection;
    private HttpResponse httpResponse;
    private boolean httpsToHttpRetryUsed;
    private long lastConnectStartTime;
    private boolean mCanSleep;
    private final IBufferPool pool;
    private volatile long readBytes;
    volatile long readEndTime;
    volatile long readStartTime;
    private volatile boolean reconnect;
    private int retryCount;
    private NetworkRetryStrategy retryStrategy;
    private int segmentApplyRetryTimes;
    private volatile long segmentNewEndOffset;
    private final DownloadSetting setting;
    private long startOffsetInConnection;
    private DownloadStenographer stenographer;
    private final List<Segment> succeedSegments;
    private int switchUrlTimes;
    private Thread thread;
    private volatile boolean threadDirty;
    final int threadIndex;
    UrlRecord urlRecord;

    private void initParams() {
        this.httpsToHttpRetryUsed = false;
        resetRetryTimes();
    }

    public void reconnect() {
        reconnect(false);
    }

    @Override // java.lang.Runnable
    public void run() {
        com_ss_android_socialbase_downloader_segment_SegmentReader_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    private void closeConnection() {
        IDownloadHttpConnection r100 = this.httpConnection;
        if (r100 == null) goto L12;
        if (Logger.debug() == false) goto L7;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "closeConnection", "Thread: " + this.threadIndex);     // Catch: Throwable -> L9
    L7:
        r100.end();     // Catch: Throwable -> L9
        r100.cancel();     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    private long refreshSegmentEndOffset() {
        long r100 = this.segmentNewEndOffset;
        this.segmentNewEndOffset = 0;
        if (r100 > 0) goto L6;
        return Long.MAX_VALUE;
    L6:
        return r100;
    }

    private void releaseDownload() {
        this.lastConnectStartTime = this.connectStartTime;
        this.connectStartTime = -1;
        this.connectEndTime = -1;
        this.readStartTime = -1;
        this.readEndTime = -1;
        closeConnection();
    }

    private void resetRetryTimes() {
        if (this.urlRecord.isMainUrl == false) goto L5;
        int r100 = this.downloadInfo.getRetryCount();
    L6:
        this.retryCount = r100;
        this.curRetryCount = 0;
        this.retryStrategy.reset();
        return;
    L5:
        r100 = this.downloadInfo.getBackUpUrlRetryCount();
        goto L6
    }

    public void com_ss_android_socialbase_downloader_segment_SegmentReader__run$___twin___() {
        Process.setThreadPriority(10);
        this.thread = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L38
        this.host.onReaderRun(this);     // Catch: Throwable -> L38
        this.urlRecord.recordUse(this);     // Catch: Throwable -> L38
    L4:
        Segment r100 = this.host.obtainSegment(this, this.urlRecord);     // Catch: Throwable -> L38
        if (r100 == null) goto L8;
        this.curSegment = r100;     // Catch: Throwable -> L38
    L23:
        th = move-exception;
        this.curSegment = null;     // Catch: Throwable -> L38
        this.host.unObtainSegment(this, r100);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L25:
        e = move-exception;
        Logger.taskError(TAG, this.downloadInfo.getId(), "run", "SegmentApplyException, Exception = " + e);     // Catch: Throwable -> L23
        int r101 = this.segmentApplyRetryTimes;     // Catch: Throwable -> L23
        if (r101 >= 50) goto L28;
        this.segmentApplyRetryTimes = r101 + 1;     // Catch: Throwable -> L23
        this.curSegment = null;     // Catch: Throwable -> L38
        ISegmentCallback r102 = this.host;     // Catch: Throwable -> L38
    L15:
        r102.unObtainSegment(this, r100);     // Catch: Throwable -> L38
        goto L4
    L28:
        Logger.taskError(TAG, this.downloadInfo.getId(), "run", "Segment apply failed " + this.segmentApplyRetryTimes + "times, thread_index = " + this.threadIndex);     // Catch: Throwable -> L23
        this.curSegment = null;     // Catch: Throwable -> L38
        ISegmentCallback r103 = this.host;     // Catch: Throwable -> L38
    L21:
        r103.unObtainSegment(this, r100);     // Catch: Throwable -> L38
    L31:
        this.urlRecord.recordUnUse(this);     // Catch: Throwable -> L48
        ISegmentCallback r104 = this.host;     // Catch: Throwable -> L48
    L41:
        r104.onReaderExit(this);     // Catch: Throwable -> L48
        goto L42
    L12:
        if (download(r100) == false) goto L18;
        this.succeedSegments.add(r100);     // Catch: Throwable -> L23 SegmentApplyException -> L25
        this.curSegment = null;     // Catch: Throwable -> L38
        r102 = this.host;     // Catch: Throwable -> L38
        goto L15
    L18:
        if (this.closed == true) goto L20;
        Logger.taskError(TAG, this.downloadInfo.getId(), "run", "Download segment failed, segment = " + r100 + ", thread_index = " + this.threadIndex + ", failedException = " + this.failedException);     // Catch: Throwable -> L23 SegmentApplyException -> L25
    L20:
        this.curSegment = null;     // Catch: Throwable -> L38
        r103 = this.host;     // Catch: Throwable -> L38
        goto L21
    L8:
        if (Logger.debug() == false) goto L31;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "run", "No more segment, thread_index: " + this.threadIndex);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L44
        this.urlRecord.recordUnUse(this);     // Catch: Throwable -> L48
        r104 = this.host;     // Catch: Throwable -> L48
    L44:
        th = move-exception;
        this.urlRecord.recordUnUse(this);     // Catch: Throwable -> L49
        this.host.onReaderExit(this);     // Catch: Throwable -> L49
    L46:
        this.thread = null;
        throw th;
    L42:
        this.thread = null;
    }

    public long getReadBytes() {
        ISegmentCallback r100 = this.host;
        monitor-enter(r100);
        long r101 = this.readBytes + getReadingBytes();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public long getReadingBytes() {
        ISegmentCallback r100 = this.host;
        monitor-enter(r100);
        long r101 = this.curSegmentReadOffset;     // Catch: Throwable -> L13
        long r102 = this.startOffsetInConnection;     // Catch: Throwable -> L13
        if (r102 >= 0) goto L7;
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return 0;
    L7:
        if (r101 <= r102) goto L11;
        long r103 = r101 - r102;     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L13
        return r103;
    L13:
        th = move-exception;
        throw th;
    }

    public void updateReadBytes() {
        UrlRecord r100 = this.urlRecord;
        ISegmentCallback r101 = this.host;     // Catch: Throwable -> L15
        monitor-enter(r101);     // Catch: Throwable -> L15
        long r102 = getReadingBytes();     // Catch: Throwable -> L11
        if (r102 <= 0) goto L8;
        this.readBytes += r102;     // Catch: Throwable -> L11
        r100.increaseDownloadBytes(r102);     // Catch: Throwable -> L11
    L8:
        this.curSegmentReadOffset = -1;     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        goto L19
    L14:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    }

    public void close() {
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "close", "ThreadIndex: " + this.threadIndex);
    L5:
        monitor-enter(this);
        this.closed = true;     // Catch: Throwable -> L17
        this.threadDirty = true;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        closeConnection();
        Future r100 = this.future;
        if (r100 == null) goto L24;
        this.future = null;
        r100.cancel(true);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L24:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public int getCurRetryCount() {
        return this.curRetryCount;
    }

    public long getCurSegmentReadOffset() {
        return this.curSegmentReadOffset;
    }

    public BaseException getFailedException() {
        return this.failedException;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public long getStartOffsetInConnection() {
        return this.startOffsetInConnection;
    }

    public boolean isExited() {
        return this.exited;
    }

    public boolean isFailed() {
        return this.failed;
    }

    private boolean checkCanUseHttpsToHttpRetry(BaseException r100) {
        if (DownloadHelper.isHttpsError(r100) == true) goto L5;
        return false;
    L5:
        String r101 = this.urlRecord.url;
        if (TextUtils.isEmpty(r101) == false) goto L8;
    L18:
        return false;
    L8:
        if (r101.startsWith("https") == false) goto L18;
        if (this.downloadInfo.isNeedHttpsToHttpRetry() == true) goto L14;
        return false;
    L14:
        if (this.httpsToHttpRetryUsed == false) goto L16;
        return false;
    L16:
        this.httpsToHttpRetryUsed = true;
        resetRetryTimes();
        return true;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ss_android_socialbase_downloader_segment_SegmentReader_com_larus_apm_impl_protector_RunnableLancet_run(SegmentReader r100) {
        r100.com_ss_android_socialbase_downloader_segment_SegmentReader__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x01fd: INVOKE 
      (r8v2 ?? I:java.lang.String)
      (r5 I:com.ss.android.socialbase.downloader.network.IDownloadHttpConnection)
      (r2 I:java.lang.Throwable)
      (r3 I:com.ss.android.socialbase.downloader.depend.IDownloadCdnListener)
     STATIC call: com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadCDN(java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.IDownloadCdnListener):void A[MD:(java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.IDownloadCdnListener):void (m)] (LINE:16777725), block:B:73:0x01f1 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x01fd: INVOKE 
      (r8 I:java.lang.String)
      (r5 I:com.ss.android.socialbase.downloader.network.IDownloadHttpConnection)
      (r2 I:java.lang.Throwable)
      (r3 I:com.ss.android.socialbase.downloader.depend.IDownloadCdnListener)
     STATIC call: com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadCDN(java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.IDownloadCdnListener):void A[MD:(java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.IDownloadCdnListener):void (m)] (LINE:16777725), block:B:73:0x01f1 */
    private void createConnection(Segment r210) throws BaseException {
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L62 BaseException -> L68
        this.connectEndTime = 0;     // Catch: Throwable -> L62 BaseException -> L68
        this.connectStartTime = r100;     // Catch: Throwable -> L62 BaseException -> L68
        this.startOffsetInConnection = r210.getCurrentOffsetRead();     // Catch: Throwable -> L62 BaseException -> L68
        this.endOffsetInConnection = r210.getEndOffset();     // Catch: Throwable -> L62 BaseException -> L68
        if (this.endOffsetInConnection > 0) goto L76;
    L15:
        this.stenographer = new DownloadStenographer();     // Catch: Throwable -> L62 BaseException -> L68
        List<HttpHeader> r101 = DownloadHelper.addRangeHeader(this.downloadInfo.getExtraHeaders(), this.downloadInfo.geteTag(), this.startOffsetInConnection, this.endOffsetInConnection);     // Catch: Throwable -> L62 BaseException -> L68
        r101.add(new HttpHeader("Segment-Index", String.valueOf(r210.getIndex())));     // Catch: Throwable -> L62 BaseException -> L68
        r101.add(new HttpHeader("Thread-Index", String.valueOf(this.threadIndex)));     // Catch: Throwable -> L62 BaseException -> L68
        r101.add(new HttpHeader("extra_download_id", String.valueOf(this.downloadInfo.getId())));     // Catch: Throwable -> L62 BaseException -> L68
        DownloadHelper.addTTNetParam(this.setting, r101, this.downloadInfo);     // Catch: Throwable -> L62 BaseException -> L68
        this.failoverStrategy.handleHeader(r101);     // Catch: Throwable -> L62 BaseException -> L68
        String r102 = this.urlRecord.url;     // Catch: Throwable -> L62 BaseException -> L68
    L82:
    L60:
        e = e;
    L71:
        throw e;     // Catch: Throwable -> L72
    L58:
        th = th;
        IDownloadHttpConnection r103 = null;
    L64:
        Throwable r104 = th;
    L65:
        DownloadHelper.parseException(r104, "createConn");     // Catch: Throwable -> L72
        this.connectEndTime = System.currentTimeMillis();
        DownloadMonitorHelper.monitorDownloadCDN(r102, r103, r104, this.downloadTask.getCdnListener());
        return;
    L17:
        if (this.httpsToHttpRetryUsed == true) goto L80;
    L28:
        String r105 = this.urlRecord.f449588ip;     // Catch: Throwable -> L58 BaseException -> L60
        if (Logger.debug() == false) goto L32;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "createConnection", "Url = " + r102 + ", ip = " + r105 + ", segment = " + r210 + ", threadIndex = " + this.threadIndex);     // Catch: Throwable -> L24 BaseException -> L26
    L32:
        this.curUrl = r102;     // Catch: Throwable -> L58 BaseException -> L60
        this.curHostIp = r105;     // Catch: Throwable -> L58 BaseException -> L60
        boolean r110 = this.downloadInfo.isNeedDefaultHttpServiceBackUp();     // Catch: Throwable -> L58 BaseException -> L60
        int r106 = this.downloadInfo.getMaxBytes();     // Catch: Throwable -> L58 BaseException -> L60
        if ((r100 - this.lastConnectStartTime) <= 3000) goto L38;
        if (this.setting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT) <= 0) goto L38;
        boolean r211 = true;
    L39:
        IDownloadHttpConnection r107 = DownloadComponentManager.downloadWithConnection(r110, r106, r102, r105, r101, 0, r211, this.downloadInfo);     // Catch: Throwable -> L58 BaseException -> L60
        if (r107 == null) goto L57;
        this.httpConnection = r107;     // Catch: Throwable -> L52 BaseException -> L54
        this.httpResponse = new HttpResponse(r102, r107);     // Catch: Throwable -> L52 BaseException -> L54
        if (this.closed == true) goto L51;
        if ((r107 instanceof AbsDownloadHttpConnection) == false) goto L47;
        this.curHostRealIp = ((AbsDownloadHttpConnection) r107).getHostIp();     // Catch: Throwable -> L52 BaseException -> L54
    L47:
        if (Logger.debug() == false) goto L49;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "createConnection", "Url = " + r102 + ", ip = " + r105 + ", hostRealIp = " + this.curHostRealIp + ", threadIndex = " + this.threadIndex);     // Catch: Throwable -> L52 BaseException -> L54
    L49:
        this.connectEndTime = System.currentTimeMillis();
        DownloadMonitorHelper.monitorDownloadCDN(r102, r107, null, this.downloadTask.getCdnListener());
        return;
    L51:
        throw new StreamClosedException("createConn");     // Catch: Throwable -> L52 BaseException -> L54
    L57:
        throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));     // Catch: Throwable -> L52 BaseException -> L54
    L54:
        e = move-exception;
        throw e;     // Catch: Throwable -> L72
    L52:
        th = move-exception;
        r104 = th;
        r103 = r107;
        goto L65
    L26:
        e = move-exception;
        throw e;     // Catch: Throwable -> L72
    L24:
        th = move-exception;
        r104 = th;
        r103 = null;
    L38:
        r211 = false;
        goto L39
    L80:
        if (TextUtils.isEmpty(r102) == true) goto L28;
        if (r102.startsWith("https") == false) goto L28;
        r102 = r102.replaceFirst("https", "http");     // Catch: Throwable -> L24 BaseException -> L26
        goto L28
    L76:
    L13:
        e = move-exception;
        throw e;     // Catch: Throwable -> L72
    L11:
        th = move-exception;
        r104 = th;
        r103 = null;
        r102 = null;
        goto L65
    L7:
        if (this.startOffsetInConnection <= this.endOffsetInConnection) goto L15;
        throw new SegmentApplyException(6, "createConn, " + r210);     // Catch: Throwable -> L11 BaseException -> L13
    L72:
        th = move-exception;
        this.connectEndTime = System.currentTimeMillis();
        DownloadMonitorHelper.monitorDownloadCDN(r8, r5, "https", this.downloadTask.getCdnListener());
        throw th;
    L68:
        e = e;
    L62:
        th = th;
        r103 = null;
        r102 = null;
        goto L64
    }

    private void doConnect(Segment r100) throws BaseException {
        createConnection(r100);
        this.host.onSegmentConnected(this, r100, this.urlRecord, this.httpResponse);
        this.urlRecord.recordSucceed();
    }

    private boolean download(Segment r100) throws BaseException {
        initParams();
    L48:
        doConnect(r100);     // Catch: Throwable -> L6 SegmentApplyException -> L37
        loopAndRead(r100);     // Catch: Throwable -> L6 SegmentApplyException -> L37
    L4:
        releaseDownload();
        return true;
    L37:
        e = move-exception;
        this.failedException = e;     // Catch: Throwable -> L40
        throw e;     // Catch: Throwable -> L40
    L6:
        th = move-exception;
        Logger.taskError(TAG, this.downloadInfo.getId(), "download", "e = " + th + ", threadIndex = " + this.threadIndex + ", reconnect = " + this.reconnect + ", closed = " + this.closed);     // Catch: Throwable -> L40
        if (this.closed == true) goto L10;
        if (this.reconnect == false) goto L25;
        this.reconnect = false;     // Catch: Throwable -> L40
        Thread.interrupted();     // Catch: Throwable -> L17
    L20:
        if (this.changeSegment == false) goto L21;
        this.changeSegment = false;     // Catch: Throwable -> L40
        throw new SegmentApplyException(5, "download");     // Catch: Throwable -> L40
    L21:
        releaseDownload();
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L40
        goto L20
    L25:
        if ((th instanceof BaseException) == false) goto L44;
        e = th;     // Catch: Throwable -> L40
    L31:
        if (e == null) goto L35;
        if (handleFailedAndCheckRetry(r100, e) == true) goto L21;
    L35:
        releaseDownload();
        return false;
    L44:
        DownloadHelper.parseException(th, "download");     // Catch: BaseException -> L30 Throwable -> L40
        e = null;
    L30:
        e = e;
        goto L31
    L10:
        releaseDownload();
        return false;
    L40:
        th = move-exception;
        releaseDownload();
        throw th;
    }

    private void loopAndRead(Segment r410) throws BaseException {
        Segment r100 = r410;
        IBufferPool r101 = this.pool;
        this.readStartTime = System.currentTimeMillis();
        long r102 = r410.getCurrentOffsetRead();
        boolean r103 = false;
        InputStream r110 = this.httpConnection.getInputStream();     // Catch: Throwable -> L211 BaseException -> L240
    L301:
        if (r110 == null) goto L206;
        long r111 = this.httpResponse.getContentLength();     // Catch: Throwable -> L197 BaseException -> L201
        if (r111 == 0) goto L196;
        Buffer r104 = probeFirstBuffer(r101, r110);     // Catch: Throwable -> L197 BaseException -> L201
    L306:
    L191:
        e = e;
        r102 = r102;
    L242:
        this.failedException = e;     // Catch: Throwable -> L244
        throw e;     // Catch: Throwable -> L244
    L188:
        th = th;
        r102 = r102;
    L190:
        long r112 = r102;
        IOutput r105 = null;
    L213:
        Logger.taskError(TAG, this.downloadInfo.getId(), "loopAndRead", "Exception: " + th + " stack: " + Log.getStackTraceString(th));     // Catch: Throwable -> L244
        th.printStackTrace();     // Catch: Throwable -> L244
        DownloadHelper.parseException(th, "loopAndRead");     // Catch: BaseException -> L237 Throwable -> L244
        DownloadUtils.safeClose(new Closeable[]{r110});
        if (r105 == null) goto L222;
        if (r104 == null) goto L274;
    L219:
        r104.size = -1;     // Catch: Throwable -> L221
        r105.write(r104);     // Catch: Throwable -> L221
        r104 = null;
        goto L222
    L274:
        r104 = r101.obtain();     // Catch: Throwable -> L221
    L222:
        if (r104 == null) goto L224;
        r101.recycle(r104);
    L224:
        this.readEndTime = System.currentTimeMillis();
        if (r112 <= r102) goto L234;
        DownloadSetting r106 = this.setting;
        DownloadInfo r107 = this.downloadInfo;
        String r108 = this.curUrl;
        String r109 = this.curHostIp;
        String r113 = this.curHostRealIp;
        if (this.closed == false) goto L229;
    L232:
        boolean r310 = true;
    L233:
        DownloadMonitorHelper.monitorSegmentIO(r106, r107, r108, r109, r113, r310, this.httpConnection, this.failedException, r112 - r102, TimeUnit.MILLISECONDS.toNanos(this.readEndTime - this.readStartTime));
        goto L234
    L229:
        if (this.reconnect == true) goto L232;
        r310 = false;
    L234:
        ISegmentCallback r114 = this.host;
    L235:
        r114.unApplySegment(this, r100);
        return;
    L237:
        e = move-exception;
        this.failedException = e;     // Catch: Throwable -> L244
        DownloadHelper.injectRemoteIp(this.httpConnection, e);     // Catch: Throwable -> L244
        throw e;     // Catch: Throwable -> L244
    L9:
        if (this.reconnect == false) goto L11;
    L181:
        r102 = r102;
    L186:
        e = e;
    L184:
        th = th;
        goto L190
    L183:
        throw new StreamClosedException("probe");     // Catch: Throwable -> L184 BaseException -> L186
    L11:
        if (this.closed == true) goto L181;
        this.retryStrategy.reset();     // Catch: Throwable -> L188 BaseException -> L191
        this.host.applySegment(this, r100);     // Catch: Throwable -> L188 BaseException -> L191
        r105 = this.host.createOutput(this, r100);     // Catch: Throwable -> L188 BaseException -> L191
        long r115 = r410.getEndOffset();     // Catch: Throwable -> L177 BaseException -> L179
        if (r115 > 0) goto L19;
        if (r111 <= 0) goto L18;
        r115 = (r111 + r102) - 1;     // Catch: Throwable -> L177 BaseException -> L179
        goto L19
    L18:
        r115 = Long.MAX_VALUE;
    L19:
        int r116 = r104.size;     // Catch: Throwable -> L177 BaseException -> L179
        long r117 = r116;
        r112 = r102 + r117;
        if (r112 <= r115) goto L50;
        long r118 = r115 + 1;
        if (r112 <= r118) goto L28;
        int r119 = (int) (r117 - (r112 - r118));
        if (r119 <= 0) goto L28;
        if (r119 >= r116) goto L28;
        r104.size = r119;     // Catch: Throwable -> L173 BaseException -> L175
        r112 = r118;
    L28:
        this.curSegmentReadOffset = r112;     // Catch: Throwable -> L173 BaseException -> L175
        r105.write(r104);     // Catch: Throwable -> L173 BaseException -> L175
        DownloadUtils.safeClose(new Closeable[]{r110});
        Buffer r120 = r101.obtain();     // Catch: Throwable -> L35
        r120.size = -1;     // Catch: Throwable -> L34
        r105.write(r120);     // Catch: Throwable -> L34
    L34:
        Buffer r121 = r120;
    L36:
        if (r121 == null) goto L38;
        r101.recycle(r121);
    L38:
        this.readEndTime = System.currentTimeMillis();
        if (r112 <= r102) goto L48;
        DownloadSetting r122 = this.setting;
        DownloadInfo r123 = this.downloadInfo;
        String r124 = this.curUrl;
        String r125 = this.curHostIp;
        String r126 = this.curHostRealIp;
        if (this.closed == false) goto L43;
    L46:
        boolean r210 = true;
    L47:
        DownloadMonitorHelper.monitorSegmentIO(r122, r123, r124, r125, r126, r210, this.httpConnection, this.failedException, r112 - r102, TimeUnit.MILLISECONDS.toNanos(this.readEndTime - this.readStartTime));
        goto L48
    L43:
        if (this.reconnect == true) goto L46;
        r210 = false;
    L48:
        this.host.unApplySegment(this, r100);
        return;
    L33:
        r121 = null;
        goto L36
    L50:
        this.curSegmentReadOffset = r112;     // Catch: Throwable -> L173 BaseException -> L175
        r105.write(r104);     // Catch: Throwable -> L173 BaseException -> L175
        long r127 = r115;
    L294:
        if (this.threadDirty == true) goto L289;
        r102 = r102;
    L304:
        r104 = r101.obtain();     // Catch: Throwable -> L165 BaseException -> L167
        DownloadHelper.trySleepDownloadingTask(this.downloadInfo);     // Catch: Throwable -> L161 BaseException -> L163
        int r128 = r110.read(r104.data);     // Catch: Throwable -> L161 BaseException -> L163
        r104.size = r128;     // Catch: Throwable -> L161 BaseException -> L163
        if (r128 == (-1)) goto L109;
        long r129 = r128;
        r112 = r112 + r129;     // Catch: Throwable -> L161 BaseException -> L163
        if (r112 > r127) goto L112;
        r100 = r410;
        this.curSegmentReadOffset = r112;     // Catch: Throwable -> L157 BaseException -> L159
        r105.write(r104);     // Catch: Throwable -> L157 BaseException -> L159
        r102 = r102;
        r103 = false;
        goto L294
    L159:
        e = e;
    L157:
        th = th;
        goto L213
    L112:
        long r211 = r127 + 1;     // Catch: Throwable -> L161 BaseException -> L163
        if (r112 <= r211) goto L118;
        int r130 = (int) (r129 - (r112 - r211));     // Catch: Throwable -> L161 BaseException -> L163
        if (r130 <= 0) goto L118;
        if (r130 >= r128) goto L118;
        r104.size = r130;     // Catch: Throwable -> L161 BaseException -> L163
        r112 = r211;
    L118:
        this.curSegmentReadOffset = r112;     // Catch: Throwable -> L161 BaseException -> L163
        r105.write(r104);     // Catch: Throwable -> L161 BaseException -> L163
        if (Logger.debug() == false) goto L122;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "loopAndRead", "BytesRead = " + (r112 - r102) + ", url = " + this.urlRecord.url);     // Catch: Throwable -> L165 BaseException -> L167
    L122:
        long r131 = 0;
    L124:
        if (r127 > r131) goto L126;
    L132:
        DownloadUtils.safeClose(new Closeable[]{r110});
        if (r105 != null) goto L270;
    L140:
        Buffer r132 = null;
    L141:
        if (r132 == null) goto L143;
        r101.recycle(r132);
    L143:
        this.readEndTime = System.currentTimeMillis();
        if (r112 <= r102) goto L153;
        DownloadSetting r133 = this.setting;
        DownloadInfo r134 = this.downloadInfo;
        String r135 = this.curUrl;
        String r136 = this.curHostIp;
        String r137 = this.curHostRealIp;
        if (this.closed == false) goto L148;
    L151:
        boolean r311 = true;
    L152:
        DownloadMonitorHelper.monitorSegmentIO(r133, r134, r135, r136, r137, r311, this.httpConnection, this.failedException, r112 - r102, TimeUnit.MILLISECONDS.toNanos(this.readEndTime - this.readStartTime));
        goto L153
    L148:
        if (this.reconnect == true) goto L151;
        r311 = false;
    L153:
        r114 = this.host;
        r100 = r410;
        goto L235
    L270:
        Buffer r138 = r101.obtain();     // Catch: Throwable -> L139
        r138.size = -1;     // Catch: Throwable -> L138
        r105.write(r138);     // Catch: Throwable -> L138
    L138:
        r132 = r138;
        goto L141
    L126:
        if (r127 == Long.MAX_VALUE) goto L132;
        if (r112 > r127) goto L132;
        throw new BaseException(1051, String.format(Locale.US, "range[%d, %d] , but readCurrent[%d] , readStart[%d]", new Object[]{Long.valueOf(r102), Long.valueOf(r127), Long.valueOf(r112), Long.valueOf(r102)}));     // Catch: Throwable -> L165 BaseException -> L167
    L109:
        r105.write(r104);     // Catch: Throwable -> L161 BaseException -> L163
        r131 = 0;
        r105 = null;
    L163:
        e = e;
    L161:
        th = th;
        r100 = r410;
    L167:
        e = e;
    L165:
        th = th;
    L166:
        r100 = r410;
    L200:
        r104 = null;
        goto L213
    L289:
        monitor-enter(this);     // Catch: Throwable -> L101 BaseException -> L103
        this.threadDirty = r103;     // Catch: Throwable -> L95
        if (this.reconnect == true) goto L94;
        if (this.closed == true) goto L94;
        monitor-exit(this);     // Catch: Throwable -> L95
        ISegmentCallback r139 = this.host;     // Catch: Throwable -> L101 BaseException -> L103
        monitor-enter(r139);     // Catch: Throwable -> L101 BaseException -> L103
    L86:
        th = th;
    L88:
        monitor-exit(r139);     // Catch: Throwable -> L90
    L90:
        th = th;
        goto L88
    L89:
        throw th;     // Catch: Throwable -> L165 BaseException -> L167
    L63:
        if (this.segmentNewEndOffset != 0) goto L65;
        r102 = r102;
    L84:
        monitor-exit(r139);     // Catch: Throwable -> L90
        goto L304
    L65:
        if (Logger.debug() == false) goto L70;
        int r140 = this.downloadInfo.getId();     // Catch: Throwable -> L86
        StringBuilder r141 = new StringBuilder();     // Catch: Throwable -> L86
        r141.append("Change readEnd = ");     // Catch: Throwable -> L90
        r141.append(r127);     // Catch: Throwable -> L90
        r141.append(", segmentNewEndOffset = ");     // Catch: Throwable -> L90
        r141.append(this.segmentNewEndOffset);     // Catch: Throwable -> L90
        r141.append(", segment = ");     // Catch: Throwable -> L90
        r141.append(r100);     // Catch: Throwable -> L90
        Logger.taskDebug(TAG, r140, "loopAndRead", r141.toString());     // Catch: Throwable -> L90
        goto L70
    L308:
        th = th;
    L70:
        r127 = refreshSegmentEndOffset();     // Catch: Throwable -> L90
        if (r112 <= r127) goto L84;
        long r142 = r127 + 1;     // Catch: Throwable -> L90
        long r143 = r112 - r142;     // Catch: Throwable -> L90
        if (r143 <= 0) goto L276;
        Logger.taskError(TAG, this.downloadInfo.getId(), "loopAndRead", "redundant: " + r143);     // Catch: Throwable -> L90
    L276:
        this.curSegmentReadOffset = r142;     // Catch: Throwable -> L80
        monitor-exit(r139);     // Catch: Throwable -> L80
        r112 = r142;
        r127 = r127;
    L80:
        th = th;
        goto L88
    L94:
        throw new StreamClosedException("loopAndRead");     // Catch: Throwable -> L99
    L95:
        th = th;
    L97:
        monitor-exit(this);     // Catch: Throwable -> L99
        throw th;     // Catch: Throwable -> L165 BaseException -> L167
    L99:
        th = th;
    L103:
        e = e;
    L101:
        th = th;
        r102 = r102;
        goto L166
    L171:
        e = e;
    L169:
        th = th;
        r102 = r102;
    L175:
        e = e;
    L173:
        th = th;
        r102 = r102;
        goto L213
    L179:
        e = e;
    L177:
        th = th;
        r102 = r102;
        r112 = r102;
        goto L213
    L196:
        throw new DownloadRetryNeedlessException(1004, "the content-length is 0, contentLength = " + r111);     // Catch: Throwable -> L207 BaseException -> L209
    L201:
        e = e;
    L197:
        th = th;
        r102 = r102;
    L199:
        r112 = r102;
        r105 = null;
        goto L200
    L206:
        throw new BaseException(1042, new IOException("inputStream is null"));     // Catch: Throwable -> L207 BaseException -> L209
    L209:
        e = e;
    L207:
        th = th;
    L244:
        th = move-exception;
        DownloadUtils.safeClose(new Closeable[]{r110});
        if (r105 == null) goto L252;
        if (r104 == null) goto L272;
    L249:
        r104.size = -1;     // Catch: Throwable -> L251
        r105.write(r104);     // Catch: Throwable -> L251
        r104 = null;
        goto L252
    L272:
        r104 = r101.obtain();     // Catch: Throwable -> L251
    L252:
        if (r104 == null) goto L254;
        r101.recycle(r104);
    L254:
        this.readEndTime = System.currentTimeMillis();
        if (r112 <= r102) goto L264;
        DownloadSetting r144 = this.setting;
        DownloadInfo r145 = this.downloadInfo;
        String r146 = this.curUrl;
        String r147 = this.curHostIp;
        String r148 = this.curHostRealIp;
        if (this.closed == false) goto L259;
    L262:
        boolean r312 = true;
    L263:
        DownloadMonitorHelper.monitorSegmentIO(r144, r145, r146, r147, r148, r312, this.httpConnection, this.failedException, r112 - r102, TimeUnit.MILLISECONDS.toNanos(this.readEndTime - this.readStartTime));
        goto L264
    L259:
        if (this.reconnect == true) goto L262;
        r312 = false;
    L264:
        this.host.unApplySegment(this, r100);
        throw th;
    L240:
        e = e;
    L211:
        th = th;
        r102 = r102;
        r112 = r102;
        r105 = null;
        r104 = null;
        r110 = null;
        goto L213
    }

    public boolean adjustSegmentEndOffset(long r100) {
        long r101 = this.endOffsetInConnection;
        if (r100 > 0) goto L8;
        if (r101 <= 0) goto L8;
        return false;
    L8:
        if (r100 > r101) goto L10;
    L12:
        this.segmentNewEndOffset = r100;
        this.threadDirty = true;
        return true;
    L10:
        if (r101 <= 0) goto L12;
        return false;
    }

    public long getCurSegmentDownloadSpeed(long r100) {
        long r101 = this.readStartTime;
        if (r101 > 0) goto L5;
        return -1;
    L5:
        long r102 = r100 - r101;
        if (r102 > 0) goto L8;
        return -1;
    L8:
        long r103 = this.curSegmentReadOffset;
        long r104 = this.startOffsetInConnection;
        if (r104 >= 0) goto L11;
    L14:
        return 0;
    L11:
        if (r103 < r104) goto L14;
        return (r103 - r104) / r102;
    }

    public void markProgress(long r100) {
        long r101 = this.curSegmentReadOffset;
        DownloadStenographer r102 = this.stenographer;
        if (r101 < 0) goto L11;
        if (r102 != null) goto L7;
        return;
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "markProgress", "CurSegmentReadOffset = " + r101 + ", threadIndex = " + this.threadIndex);
    L9:
        r102.markProgress(r101, r100);
        return;
    }

    public void reconnect(boolean r100) {
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "reconnect", "ThreadIndex: " + this.threadIndex);
    L5:
        monitor-enter(this);
        this.changeSegment = r100;     // Catch: Throwable -> L15
        this.reconnect = true;     // Catch: Throwable -> L15
        this.threadDirty = true;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        closeConnection();
        Thread r101 = this.thread;
        if (r101 == null) goto L23;
        if (Logger.debug() == false) goto L13;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "reconnect", "Interrupt ThreadIndex: " + this.threadIndex);     // Catch: Throwable -> L18
    L13:
        r101.interrupt();     // Catch: Throwable -> L18
        return;
    L24:
        return;
    L23:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public void setExited(boolean r100) {
        this.exited = r100;
    }

    public void setFailed(boolean r100) {
        this.failed = r100;
    }

    public void setFuture(Future r100) {
        this.future = r100;
    }

    public boolean switchUrlRecord(UrlRecord r100) {
        int r101 = this.switchUrlTimes;
        if (r101 < 30) goto L6;
        return false;
    L6:
        this.switchUrlTimes = r101 + 1;
        UrlRecord r102 = this.urlRecord;
        if (r102 == null) goto L9;
        r102.recordUnUse(this);
    L9:
        r100.recordUse(this);
        this.urlRecord = r100;
        resetRetryTimes();
        return true;
    }

    private boolean handleFailedAndCheckRetry(Segment r100, BaseException r110) {
        Logger.taskError(TAG, this.downloadInfo.getId(), "handleFailedAndCheckRetry", "Exception = " + r110 + ", curRetryCount = " + this.curRetryCount + ", retryCount = " + this.retryCount);
        this.failedException = r110;
        this.urlRecord.recordFailed();
        if (this.host.onSegmentRetry(this, this.urlRecord, r100, r110, this.curRetryCount, this.retryCount) == true) goto L5;
        return false;
    L5:
        int r101 = this.curRetryCount;
        if (r101 >= this.retryCount) goto L9;
        this.curRetryCount = r101 + 1;
        return true;
    L9:
        this.failoverStrategy.handleError(r110);
        if (this.retryStrategy.canRetry(r110) == false) goto L14;
        this.retryStrategy.doRetry();
        this.downloadInfo.setCurNetworkRetryCount(this.retryStrategy.getTotalRetryCount());
        return true;
    L14:
        if (checkCanUseHttpsToHttpRetry(r110) == false) goto L16;
        return true;
    L16:
        this.host.onSegmentFailed(this, this.urlRecord, r100, r110);
        return false;
    }

    private Buffer probeFirstBuffer(IBufferPool r100, InputStream r101) throws InterruptedException, BaseException, IOException {
        Buffer r102 = r100.obtain();
        int r103 = r101.read(r102.data);     // Catch: Throwable -> L13
        if (r103 == (-1)) goto L12;
        r102.size = r103;     // Catch: Throwable -> L9
        if (r103 != (-1)) goto L8;
        r100.recycle(r102);
    L8:
        return r102;
    L12:
        throw new BaseException(1073, "probe");     // Catch: Throwable -> L9
    L9:
        th = th;
    L15:
        if (r103 != (-1)) goto L17;
        r100.recycle(r102);
    L17:
        throw th;
    L13:
        th = th;
        r103 = -1;
        goto L15
    }

    public long getRecentDownloadSpeed(long r100, long r101) {
        DownloadStenographer r102 = this.stenographer;
        if (r102 != null) goto L7;
        return -1;
    L7:
        return r102.getRecentDownloadSpeed(r100, r101);
    }

    public SegmentReader(DownloadTask r100, DownloadInfo r101, SegmentDispatcher r102, IBufferPool r103, UrlRecord r104, int r105) {
        this.succeedSegments = new ArrayList();
        this.curSegmentReadOffset = -1;
        this.downloadTask = r100;
        this.downloadInfo = r101;
        this.host = r102;
        this.pool = r103;
        this.setting = DownloadSetting.obtain(r101.getId());
        this.urlRecord = r104;
        this.threadIndex = r105;
        this.retryStrategy = new NetworkRetryStrategy(r101);
        this.failoverStrategy = new NetworkFailoverStrategy(r101);
    }
}
