package com.ss.android.socialbase.downloader.core.module.pcdn;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class PCDNStats {
    private int mCdnConcurrentCount;
    private long mCdnDur;
    private long mCdnSize;
    private long mCdnStartTime;
    private int mChunkRetryCount;
    private DownloadInfo mDownloadInfo;
    private int mPcdnConcurrentCount;
    private long mPcdnDur;
    private long mPcdnSize;
    private long mPcdnStartTime;
    private Map<String, UrlStats> mUrlStats;

    public class UrlStats {
        private int mCode;
        private int mConcurrentCount;
        private long mDuration;
        private String mErr;
        private boolean mIsPcdn;
        private int mProtocol;
        private long mSize;
        private long mStartTime;
        private int mTtfb;
        final /* synthetic */ PCDNStats this$0;

        public UrlStats(PCDNStats r100) {
            this.this$0 = r100;
        }

        public static /* synthetic */ boolean access$000(UrlStats r100) {
            return r100.mIsPcdn;
        }

        public static /* synthetic */ long access$100(UrlStats r100) {
            return r100.mStartTime;
        }

        public static /* synthetic */ int access$200(UrlStats r100) {
            return r100.mConcurrentCount;
        }

        public static /* synthetic */ int access$204(UrlStats r100) {
            int r101 = r100.mConcurrentCount + 1;
            r100.mConcurrentCount = r101;
            return r101;
        }

        public static /* synthetic */ int access$206(UrlStats r100) {
            int r101 = r100.mConcurrentCount - 1;
            r100.mConcurrentCount = r101;
            return r101;
        }

        public static /* synthetic */ int access$300(UrlStats r100) {
            return r100.mProtocol;
        }

        public static /* synthetic */ int access$400(UrlStats r100) {
            return r100.mTtfb;
        }

        public static /* synthetic */ int access$500(UrlStats r100) {
            return r100.mCode;
        }

        public static /* synthetic */ String access$600(UrlStats r100) {
            return r100.mErr;
        }

        public static /* synthetic */ long access$700(UrlStats r100) {
            return r100.mDuration;
        }

        public static /* synthetic */ long access$800(UrlStats r100) {
            return r100.mSize;
        }

        public static /* synthetic */ boolean access$002(UrlStats r100, boolean r101) {
            r100.mIsPcdn = r101;
            return r101;
        }

        public static /* synthetic */ long access$102(UrlStats r100, long r101) {
            r100.mStartTime = r101;
            return r101;
        }

        public static /* synthetic */ int access$302(UrlStats r100, int r101) {
            r100.mProtocol = r101;
            return r101;
        }

        public static /* synthetic */ int access$402(UrlStats r100, int r101) {
            r100.mTtfb = r101;
            return r101;
        }

        public static /* synthetic */ int access$502(UrlStats r100, int r101) {
            r100.mCode = r101;
            return r101;
        }

        public static /* synthetic */ String access$602(UrlStats r100, String r101) {
            r100.mErr = r101;
            return r101;
        }

        public static /* synthetic */ long access$702(UrlStats r100, long r101) {
            r100.mDuration = r101;
            return r101;
        }

        public static /* synthetic */ long access$802(UrlStats r100, long r101) {
            r100.mSize = r101;
            return r101;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void collectPCDNStats() {
        monitor-enter(this);
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L9
        r100.put(MonitorConstants.PCDN_BUSINESSID, this.mDownloadInfo.getMonitorScene());     // Catch: Throwable -> L9
        r100.put(MonitorConstants.PCDN_SIZE, this.mPcdnSize);     // Catch: Throwable -> L9
        r100.put(MonitorConstants.PCDN_DUR, this.mPcdnDur);     // Catch: Throwable -> L9
        r100.put(MonitorConstants.CDN_SIZE, this.mCdnSize);     // Catch: Throwable -> L9
        r100.put(MonitorConstants.CDN_DUR, this.mCdnDur);     // Catch: Throwable -> L9
        r100.put(MonitorConstants.RETRY_TIMES_MAX, this.mChunkRetryCount);     // Catch: Throwable -> L9
        JSONArray r101 = new JSONArray();     // Catch: Throwable -> L9
        Iterator<Map.Entry<String, UrlStats>> r102 = this.mUrlStats.entrySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r102.hasNext() == false) goto L7;
        Map.Entry<String, UrlStats> r103 = r102.next();     // Catch: Throwable -> L9
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L9
        r104.put("url", r103.getKey());     // Catch: Throwable -> L9
        UrlStats r105 = r103.getValue();     // Catch: Throwable -> L9
        r104.put(MonitorConstants.IS_PCDN, UrlStats.access$000(r105));     // Catch: Throwable -> L9
        r104.put("code", UrlStats.access$500(r105));     // Catch: Throwable -> L9
        r104.put("size", UrlStats.access$800(r105));     // Catch: Throwable -> L9
        r104.put("duration", UrlStats.access$700(r105));     // Catch: Throwable -> L9
        r104.put("protocol", UrlStats.access$300(r105));     // Catch: Throwable -> L9
        r104.put(MonitorConstants.TTFB, UrlStats.access$400(r105));     // Catch: Throwable -> L9
        r104.put("err", UrlStats.access$600(r105));     // Catch: Throwable -> L9
        r101.put(r104);     // Catch: Throwable -> L9
        goto L5
    L7:
        r100.put("urls", r101);     // Catch: Throwable -> L9
        this.mDownloadInfo.setPcdnStats(r100);     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void afterTotalStats(boolean r100) {
        if (r100 == false) goto L9;
        if (this.mPcdnStartTime > 0) goto L7;
        this.mPcdnStartTime = System.currentTimeMillis();
    L7:
        this.mPcdnConcurrentCount++;
        return;
    L9:
        if (this.mCdnStartTime > 0) goto L11;
        this.mCdnStartTime = System.currentTimeMillis();
    L11:
        this.mCdnConcurrentCount++;
    }

    public PCDNStats(DownloadInfo r100, int r101) {
        this.mUrlStats = new LinkedHashMap();
        this.mCdnConcurrentCount = 0;
        this.mPcdnConcurrentCount = 0;
        this.mDownloadInfo = r100;
        r100.setPcdnStats(null);
        this.mChunkRetryCount = r101;
    }

    private void beforeUrlStats(String r100, boolean r101) {
        UrlStats r102 = this.mUrlStats.get(r100);
        if (r102 != null) goto L6;
        r102 = new UrlStats(this);
        UrlStats.access$002(r102, r101);
    L6:
        if (UrlStats.access$100(r102) > 0) goto L8;
        UrlStats.access$102(r102, System.currentTimeMillis());
    L8:
        UrlStats.access$204(r102);
        this.mUrlStats.put(r100, r102);
    }

    public void beforeDownload(String r100, boolean r101) {
        monitor-enter(this);
        beforeUrlStats(r100, r101);     // Catch: Throwable -> L6
        afterTotalStats(r101);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void afterTotalStats(long r100, boolean r101, long r102) {
        if (r101 == false) goto L8;
        int r103 = this.mPcdnConcurrentCount - 1;
        this.mPcdnConcurrentCount = r103;
        this.mPcdnSize += r102;
        this.mPcdnDur += r100 - this.mPcdnStartTime;
        if (r103 != 0) goto L7;
        this.mPcdnStartTime = 0;
        return;
    L7:
        this.mPcdnStartTime = r100;
        return;
    L8:
        int r104 = this.mCdnConcurrentCount - 1;
        this.mCdnConcurrentCount = r104;
        this.mCdnSize += r102;
        this.mCdnDur += r100 - this.mCdnStartTime;
        if (r104 != 0) goto L11;
        this.mCdnStartTime = 0;
        return;
    L11:
        this.mCdnStartTime = r100;
    }

    private void afterUrlStats(long r100, String r101, IDownloadHttpConnection r102, Throwable r103, boolean r110, long r111) {
        UrlStats r104 = this.mUrlStats.get(r101);
        if (UrlStats.access$300(r104) != 0) goto L16;
        if (r102 == null) goto L16;
        if ((r102 instanceof AbsDownloadHttpConnection) == false) goto L16;
        AbsDownloadHttpConnection r105 = (AbsDownloadHttpConnection) r102;
        if (r105.isOkhttp() == true) goto L15;
        UrlStats.access$302(r104, 4);
        String r106 = r105.getRequestLog();
        if (TextUtils.isEmpty(r106) == true) goto L16;
        JSONObject r107 = new JSONObject(r106);     // Catch: Throwable -> L13
        UrlStats.access$302(r104, r107.optJSONObject("response").optInt("connection_info"));     // Catch: Throwable -> L13
        UrlStats.access$402(r104, r107.optJSONObject("timing").optJSONObject("detailed_duration").optInt(MonitorConstants.TTFB));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L15:
        UrlStats.access$302(r104, 1);
    L16:
        if (r103 == null) goto L23;
        if (r110 == true) goto L23;
        if ((r103 instanceof BaseException) == false) goto L21;
        UrlStats.access$502(r104, ((BaseException) r103).getErrorCode());
    L22:
        UrlStats.access$602(r104, r103.toString());
    L28:
        UrlStats.access$206(r104);
        UrlStats.access$702(r104, UrlStats.access$700(r104) + (r100 - UrlStats.access$100(r104)));
        if (UrlStats.access$200(r104) != 0) goto L31;
        UrlStats.access$102(r104, 0);
    L32:
        UrlStats.access$802(r104, UrlStats.access$800(r104) + r111);
        this.mUrlStats.put(r101, r104);
        return;
    L31:
        UrlStats.access$102(r104, r100);
        goto L32
    L21:
        UrlStats.access$502(r104, 1000);
    L23:
        if (r102 == null) goto L28;
        UrlStats.access$502(r104, r102.getResponseCode());     // Catch: Throwable -> L26
        UrlStats.access$602(r104, "");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    public void afterDownload(String r110, long r111, boolean r112, boolean r113, IDownloadHttpConnection r210, DownloadSingleResponseHandler r211, Throwable r212) {
        monitor-enter(this);
        if (r211 != null) goto L12;
        long r100 = 0;
    L6:
        long r114 = r100;
        long r115 = System.currentTimeMillis();     // Catch: Throwable -> L9
        afterUrlStats(r115, r110, r210, r212, r113, r114);     // Catch: Throwable -> L9
        afterTotalStats(r115, r112, r114);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        r100 = r211.getCurOffset() - r111;     // Catch: Throwable -> L9
        goto L6
    }
}
