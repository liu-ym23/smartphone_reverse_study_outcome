package com.ttnetuploader.uploader.task;

import android.content.Context;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ttnetuploader.uploader.api.Parameters;
import com.ttnetuploader.uploader.api.ResultInfo;
import com.ttnetuploader.uploader.api.ULLog;
import com.ttnetuploader.uploader.api.UploadCode;
import com.ttnetuploader.uploader.api.a;
import com.ttnetuploader.uploader.api.b;
import com.ttnetuploader.uploader.api.c;
import com.ttnetuploader.uploader.api.d;
import com.ttnetuploader.uploader.discovery.DiscoveryManager;
import com.ttnetuploader.uploader.net.INetRequest;
import com.ttnetuploader.uploader.net.INetResponse;
import com.ttnetuploader.uploader.net.RequestFactory;
import com.ttnetuploader.uploader.request_protocol.UploaderRequest;
import com.ttnetuploader.uploader.response_protocol.ServerResponseBase;
import com.ttnetuploader.uploader.slice_task.Range;
import com.ttnetuploader.uploader.slice_task.RangeManager;
import com.ttnetuploader.uploader.slice_task.SliceConfig;
import com.ttnetuploader.uploader.slice_task.SliceTask;
import com.ttnetuploader.uploader.utils.CommonTools;
import com.ttnetuploader.uploader.utils.UploadFileUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class Task implements ITask {
    public static final int DISK_THRESHOLD_MIN = 524288000;
    private static final String TAG = "Task";
    private INetRequest mCompletedMsgRequest;
    private volatile Context mContext;
    private INetRequest mDataRequest;
    private boolean mIsCurrFallback;
    private boolean mIsIgnoreQueryRequest;
    private volatile boolean mIsSuspend;
    private volatile Parameters mParam;
    private int mPortIndex;
    private INetRequest mQueryRequest;
    private RangeManager mRangeManager;
    private volatile Map<Long, SliceTask> mSliceTaskMap;

    private ServerResponseBase getServerInfoInternal() throws Exception {
        monitor-enter(this);
        this.mQueryRequest = RequestFactory.getRequest(this.mParam.getNetLibType(), this.mContext);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        SliceConfig r100 = new SliceConfig(this.mParam, new Range(0, this.mParam.getFileLength() - 1), 1);
        if (this.mParam.getProtocol() != 1) goto L9;
        INetResponse r101 = this.mQueryRequest.httpGetRequest(UploaderRequest.getQueryUrl(this.mParam.getProtocol(), r100), r100, UploaderRequest.getQueryHeaders(this.mParam.getProtocol(), r100, this.mContext), 0);
    L13:
        if (ULLog.debug() == false) goto L16;
        ULLog.taskDebug(TAG, ((Long) CommonTools.getNonnullValue(this.mParam, new a(), 0L)).longValue(), "getServerInfoInternal", "code=" + r101.getCode() + ",bodyJson=" + r101.getBodyJson() + ",requestLog=" + r101.getRequestLog());
    L16:
        return ServerResponseBase.getServerResponse(this.mParam, r101);
    L9:
        if (this.mParam.getProtocol() != 2) goto L11;
        r101 = this.mQueryRequest.httpPostRequest(UploaderRequest.getQueryUrl(this.mParam.getProtocol(), r100), r100, UploaderRequest.getQueryHeaders(this.mParam.getProtocol(), r100, this.mContext), UploaderRequest.getQueryBody(this.mParam.getProtocol(), r100), 0);
        goto L13
    L11:
        r101 = null;
    L17:
        th = move-exception;
        throw th;
    }

    private void startNormal() {
        SliceTask r100 = getSliceTask(new Range(0, this.mParam.getFileLength() - 1));     // Catch: Exception -> L8
        addSliceTaskToMap(r100);     // Catch: Exception -> L8
        ServerResponseBase r101 = r100.startNormal();     // Catch: Exception -> L8
        if (r101.getIsSuccess() == false) goto L6;
        resultReport(1000, r101, "");     // Catch: Exception -> L8
    L11:
        return;
    L6:
        resultReport(1009, null, r101.getErrorLog());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        resultReport(1009, null, e.toString());
    }

    @Override // com.ttnetuploader.uploader.task.ITask
    public ResultInfo delete() {
        ResultInfo r100 = commonGetRequest(3);
        if (r100 == null) goto L8;
        if (r100.code != 1000) goto L8;
        return r100;
    L8:
        if (this.mParam.getIsHttp() == true) goto L16;
        this.mParam.setIsHttp(true);
        String r101 = r100.getUploadLog();
        ResultInfo r102 = commonGetRequest(3);
        if (r102 == null) goto L15;
        if (r102.code == 1000) goto L15;
        r102.addLog(r101);
    L15:
        return r102;
    L16:
        return r100;
    }

    @Override // com.ttnetuploader.uploader.task.ITask
    public String getCurrDevIp() {
        return commonGetRequest(4).clientIpv4;
    }

    @Override // com.ttnetuploader.uploader.task.ITask
    public ResultInfo queryServerDisk() {
        ResultInfo r100 = commonGetRequest(4);
        if (r100 == null) goto L8;
        if (r100.code != 1000) goto L8;
        return r100;
    L8:
        if (this.mParam.getIsHttp() == true) goto L16;
        this.mParam.setIsHttp(true);
        String r101 = r100.getUploadLog();
        ResultInfo r102 = commonGetRequest(4);
        if (r102 == null) goto L15;
        if (r102.code == 1000) goto L15;
        r102.addLog(r101);
    L15:
        return r102;
    L16:
        return r100;
    }

    @Override // com.ttnetuploader.uploader.task.ITask
    public void suspend() {
        this.mIsSuspend = true;
        monitor-enter(this);
        INetRequest r100 = this.mQueryRequest;     // Catch: Throwable -> L19
        if (r100 == null) goto L7;
        r100.suspend();     // Catch: Throwable -> L19
    L7:
        monitor-exit(this);     // Catch: Throwable -> L19
        Map<Long, SliceTask> r101 = this.mSliceTaskMap;
        monitor-enter(r101);
        Iterator<Map.Entry<Long, SliceTask>> r102 = this.mSliceTaskMap.entrySet().iterator();     // Catch: Throwable -> L16
    L12:
        if (r102.hasNext() == false) goto L14;
        r102.next().getValue().suspend();     // Catch: Throwable -> L16
        goto L12
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        throw th;
    }

    private ServerResponseBase sendCompletedMsg() throws Exception {
        SliceConfig r100 = new SliceConfig(this.mParam, new Range(0, this.mParam.getFileLength() - 1), 1);
        INetResponse r101 = RequestFactory.getRequest(this.mParam.getNetLibType(), this.mContext).httpPostRequest(UploaderRequest.getCompletedMsgUrl(this.mParam.getProtocol(), r100), r100, UploaderRequest.getCompletedHeaders(this.mParam.getProtocol(), r100), UploaderRequest.getCompletedMsgBody(this.mParam.getProtocol(), r100), 0);
        return ServerResponseBase.getServerResponse(this.mParam, r101);
    }

    private void startWithRetry() {
        long r100 = 0;
        if (ULLog.debug() == false) goto L5;
        ULLog.taskDebug(TAG, ((Long) CommonTools.getNonnullValue(this.mParam, new a(), 0L)).longValue(), "startWithRetry", "enter startWithRetry");
    L5:
        int r101 = this.mParam.getTaskRetryTimes();
        String r102 = "";
    L65:
        ServerResponseBase r103 = getServerInfo();     // Catch: Exception -> L38
        this.mIsIgnoreQueryRequest = true;     // Catch: Exception -> L38
        if (r103.getIsUploaded() == false) goto L12;
        resultReport(UploadCode.TT_UPLOAD_SERVER_HAD_UPLOAD_DONE, r103, "");     // Catch: Exception -> L38
        return;
    L12:
        if (r103.getIsSuccess() == false) goto L37;
        if (this.mParam.getProtocol() == 1) goto L16;
    L21:
        this.mRangeManager = new RangeManager(r103.getNeedUploadRangeArray(), this.mParam);     // Catch: Exception -> L38
        if (ULLog.debug() == false) goto L25;
        ULLog.taskDebug(TAG, ((Long) CommonTools.getNonnullValue(this.mParam, new a(), 0L)).longValue(), "startWithRetry", "mRangeManager.isCompleted()=" + this.mRangeManager.isCompleted() + "mRangeManager.getInitLen()" + this.mRangeManager.getInitLen());     // Catch: Exception -> L38
    L25:
        if (this.mRangeManager.isCompleted() == true) goto L28;
        SliceTask r104 = getSliceTask(this.mRangeManager.getRange());     // Catch: Exception -> L38
        addSliceTaskToMap(r104);     // Catch: Exception -> L38
        r104.start(this.mIsIgnoreQueryRequest);     // Catch: Exception -> L38
        this.mIsIgnoreQueryRequest = false;     // Catch: Exception -> L38
        deleteSliceTaskFromMap(Long.valueOf(r104.getSliceTaskId()));     // Catch: Exception -> L38
        goto L25
    L28:
        if (this.mParam.getProtocol() != 2) goto L34;
        ServerResponseBase r105 = sendCompletedMsg();     // Catch: Exception -> L38
        if (r105.getIsSuccess() == true) goto L34;
        throw new Exception("sendCompletedMsg error:" + r105.getErrorLog());     // Catch: Exception -> L38
    L34:
        resultReport(1000, null, "");     // Catch: Exception -> L38
        return;
    L16:
        if (r103.getRemainDisk() <= r100) goto L21;
        if ((r103.getUnuploadedLen() + 524288000) <= r103.getRemainDisk()) goto L21;
        resultReport(UploadCode.TT_UPLOAD_SERVER_DISK_NOT_ENOUGH, r103, "remainDisk=" + r103.getRemainDisk() + ",fileLen=" + this.mParam.getFileLength());     // Catch: Exception -> L38
        return;
    L37:
        throw new Exception("error:" + r103.getErrorLog());     // Catch: Exception -> L38
    L38:
        e = move-exception;
        if (ULLog.debug() == false) goto L42;
        ULLog.taskDebug(TAG, ((Long) CommonTools.getNonnullValue(this.mParam, new a(), 0L)).longValue(), "startWithRetry", "in do-while,exception info=" + e);
    L42:
        r102 = r102 + ",{" + e + i.f25855d;
        if (this.mIsSuspend == true) goto L59;
        if (this.mParam.getIsTryFallback() == false) goto L51;
        if (this.mParam.getIsHttp() == true) goto L51;
        this.mIsCurrFallback = true;
        this.mParam.setIsHttp(true);
    L54:
        if (ULLog.debug() == false) goto L56;
        ULLog.taskDebug(TAG, ((Long) CommonTools.getNonnullValue(this.mParam, new a(), 0L)).longValue(), "startWithRetry", "in do-while,retryTimes=" + r101 + ",mIsSuspend=" + this.mIsSuspend + ",mIsIgnoreQueryRequest=" + this.mIsIgnoreQueryRequest);
    L56:
        int r106 = r101 - 1;
        if (r101 <= 0) goto L59;
        r101 = r106;
        r100 = 0;
    L51:
        if (this.mIsCurrFallback == false) goto L54;
        Parameters r107 = this.mParam;
        int r108 = this.mPortIndex + 1;
        this.mPortIndex = r108;
        r107.setServerPort(CommonTools.getPort(r108));
        this.mIsCurrFallback = false;
        this.mParam.setIsHttp(false);
    L59:
        if (this.mIsSuspend == false) goto L61;
        int r109 = 1010;
    L62:
        resultReport(r109, null, r102);
        return;
    L61:
        r109 = 1009;
        goto L62
    }

    public int checkParam() {
        if (this.mParam.getProtocol() != 0) goto L8;
        if (this.mParam.getMultipartBody().isEmpty() == true) goto L8;
        return 1000;
    L8:
        if (this.mParam.getFilePath() != null) goto L10;
        return 1037;
    L10:
        if (this.mParam.getFilePath().isEmpty() == false) goto L13;
        return 1037;
    L13:
        if (this.mParam.getMd5() != null) goto L15;
    L16:
        String r100 = CommonTools.md5HexStr(this.mParam.getFilePath() + this.mParam.getFileName());
        if (r100 != null) goto L20;
        return 1034;
    L20:
        this.mParam.setMd5(r100);
    L22:
        if (this.mParam.getFileLength() > 0) goto L28;
        long r101 = UploadFileUtils.getFileLength(this.mParam.getFilePath(), this.mContext);
        if (r101 > 0) goto L27;
        return 1035;
    L27:
        this.mParam.setFileLength(r101);
    L28:
        return 1000;
    L15:
        if (this.mParam.getMd5().isEmpty() == false) goto L22;
        goto L16
    }

    @Override // com.ttnetuploader.uploader.task.ITask
    public long getUploadId() {
        return this.mParam.getUploadId();
    }

    private ServerResponseBase getServerInfo() throws Exception {
        return getServerInfoInternal();
    L4:
        e = move-exception;
        String r100 = DiscoveryManager.getInstance(this.mContext).getIpv4(this.mParam.getSN());
        if (this.mParam.getProtocol() != 1) goto L14;
        if (r100 == null) goto L14;
        if (r100.contains(".") == false) goto L14;
        if (this.mParam.getUrl().equals(r100) == true) goto L14;
        this.mParam.setUrl(r100);
        return getServerInfoInternal();
    L14:
        throw e;
    }

    private long getServerNextOffset() throws Exception {
        ServerResponseBase r100 = getServerInfo();
        if (r100.getNeedUploadRangeArray().size() != 1) goto L7;
        return ((Range) ListProtector.get(r100.getNeedUploadRangeArray(), 0)).start;
    L7:
        throw new Exception("getServerNextOffset::error rangeArray size=" + r100.getNeedUploadRangeArray().size());
    }

    @Override // com.ttnetuploader.uploader.task.ITask
    public void start() {
        if (ULLog.debug() == false) goto L5;
        ULLog.globalDebug(TAG, "start", "uploadId:=" + CommonTools.getNonnullValue(this.mParam, new a(), 0L) + ",filePath=" + ((String) CommonTools.getNonnullValue(this.mParam, new b(), "")) + ",url=" + ((String) CommonTools.getNonnullValue(this.mParam, new c(), "")) + ",userKey=" + ((String) CommonTools.getNonnullValue(this.mParam, new d(), "")));
    L5:
        int r100 = checkParam();
        if (r100 == 1000) goto L13;
        if (ULLog.debug() == false) goto L10;
        ULLog.globalDebug(TAG, "start", "checkParam failed,ret=" + r100);
    L10:
        resultReport(r100, null, "");
        return;
    L13:
        if (this.mParam.getProtocol() != 0) goto L16;
        startNormal();
        return;
    L16:
        startWithRetry();
    }

    public static /* synthetic */ Parameters access$000(Task r100) {
        return r100.mParam;
    }

    private void addSliceTaskToMap(SliceTask r100) {
        Map<Long, SliceTask> r101 = this.mSliceTaskMap;
        monitor-enter(r101);
        this.mSliceTaskMap.put(Long.valueOf(r100.getSliceTaskId()), r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ResultInfo commonGetRequest(int r210) {
        String r100 = "";
        INetRequest r101 = RequestFactory.getRequest(this.mParam.getNetLibType(), this.mContext);     // Catch: Exception -> L5
        SliceConfig r102 = new SliceConfig(this.mParam, new Range(0, this.mParam.getFileLength() - 1), r210);     // Catch: Exception -> L5
        ServerResponseBase r103 = ServerResponseBase.getServerResponse(this.mParam, r101.httpGetRequest(UploaderRequest.getQueryUrl(this.mParam.getProtocol(), r102), r102, UploaderRequest.getQueryHeaders(this.mParam.getProtocol(), r102, this.mContext), 0));     // Catch: Exception -> L5
        String r110 = "";
    L7:
        if (r103 != null) goto L9;
    L11:
        int r111 = 1009;
    L12:
        long r104 = this.mParam.getUploadId();
        if (r103 == null) goto L16;
        r100 = r103.getClientIpv4();
    L16:
        return new ResultInfo(r104, 0, 0, r111, "", "", r110, 0, 0, r100);
    L9:
        if (r103.getIsSuccess() == false) goto L11;
        r111 = 1000;
    L5:
        e = move-exception;
        r110 = e.toString();
        r103 = null;
        goto L7
    }

    private void deleteSliceTaskFromMap(Long r100) {
        Map<Long, SliceTask> r101 = this.mSliceTaskMap;
        monitor-enter(r101);
        this.mSliceTaskMap.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private SliceTask getSliceTask(Range r100) {
        return new SliceTask(this.mParam, this.mContext, r100, new AnonymousClass1(this));
    }

    public Task(Parameters r100, Context r101) {
        this.mParam = null;
        this.mContext = null;
        this.mIsSuspend = false;
        this.mQueryRequest = null;
        this.mDataRequest = null;
        this.mCompletedMsgRequest = null;
        this.mPortIndex = 0;
        this.mIsCurrFallback = false;
        this.mRangeManager = null;
        this.mSliceTaskMap = new HashMap();
        this.mIsIgnoreQueryRequest = false;
        this.mParam = r100;
        this.mContext = r101;
    }

    private void resultReport(int r310, ServerResponseBase r311, String r312) {
        if (ULLog.debug() == false) goto L6;
        ULLog.taskDebug("task", ((Long) CommonTools.getNonnullValue(this.mParam, new a(), 0L)).longValue(), "resultReport", "code=" + r310 + ",errorLog=" + r312);
    L6:
        if (this.mParam == null) goto L49;
        if (this.mParam.getCallback() == null) goto L49;
        if (r310 == 20202) goto L16;
        if (r310 == 1000) goto L16;
        if (this.mIsSuspend == false) goto L16;
        int r100 = 1010;
    L17:
        long r110 = this.mParam.getUploadId();
        long r111 = this.mParam.getFileLength();
        long r210 = this.mParam.getFileLength();
        String r211 = this.mParam.getUrl();
        String r212 = this.mParam.getFilePath();
        if (r311 == null) goto L20;
        long r213 = r311.getRemainDisk();
    L21:
        if (r311 == null) goto L23;
        long r214 = r311.getTotalDisk();
    L24:
        int r313 = r100;
        ResultInfo r101 = new ResultInfo(r110, r111, r210, r313, r211, r212, r312, r213, r214, "");
        if (r311 == null) goto L27;
        String r102 = r311.getMessage();
    L28:
        r101.setStringBody(CommonTools.getNonnullStringValue(r102));
        if (r313 != 20202) goto L31;
    L38:
        this.mParam.getCallback().onProgress(this.mParam.getUploadId(), this.mParam.getFileLength(), this.mParam.getFileLength(), 0);
        if (this.mParam.getProtocol() != 1) goto L44;
        if (DiscoveryManager.getInstance(this.mContext).getIpv4(this.mParam.getSN()) != null) goto L44;
        DiscoveryManager.getInstance(this.mContext).addNewServerInfo(this.mParam.getSN(), this.mParam.getUrl(), this.mParam.getServerPort());
    L44:
        if (ULLog.debug() == false) goto L46;
        ULLog.taskDebug("task", ((Long) CommonTools.getNonnullValue(this.mParam, new a(), 0L)).longValue(), "resultReport", "onSuccess");
    L46:
        this.mParam.getCallback().onSuccess(r101);
        return;
    L31:
        if (r313 == 1000) goto L38;
        if (ULLog.debug() == false) goto L36;
        Task r103 = this;
        ULLog.taskDebug("task", ((Long) CommonTools.getNonnullValue(r103.mParam, new a(), 0L)).longValue(), "resultReport", "onFailed;errorLog=" + r312 + ",code=" + r313 + ",mIsSuspend=" + r103.mIsSuspend + ",mIsIgnoreQueryRequest=" + r103.mIsIgnoreQueryRequest);
    L37:
        r103.mParam.getCallback().onFailed(r101);
        return;
    L36:
        r103 = this;
        goto L37
    L27:
        r102 = "";
        goto L28
    L23:
        r214 = 0;
        goto L24
    L20:
        r213 = 0;
    L16:
        r100 = r310;
    L49:
        if (ULLog.debug() == false) goto L57;
        long r104 = ((Long) CommonTools.getNonnullValue(this.mParam, new a(), 0L)).longValue();
        StringBuilder r105 = new StringBuilder("(mParam==null)=");
        if (this.mParam != null) goto L53;
        boolean r112 = true;
    L54:
        r105.append(r112);
        ULLog.taskDebug("task", r104, "resultReport", r105.toString());
        return;
    L53:
        r112 = false;
        goto L54
    }
}
