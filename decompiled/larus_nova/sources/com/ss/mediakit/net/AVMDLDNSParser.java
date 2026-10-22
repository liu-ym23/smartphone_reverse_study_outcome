package com.ss.mediakit.net;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLDNSParser {
    public static final int AVMDL_DNS_BACKUP_TYPE = 1;
    public static final int AVMDL_DNS_DEFAULT_EXPIRED_TIME = 2;
    public static final int AVMDL_DNS_DISABLE_PARALLEL_FOR_EXPIRED_CACHE = 11;
    public static final int AVMDL_DNS_ENABLE_BACKUP_IP = 5;
    public static final int AVMDL_DNS_ENABLE_DNS_LOG = 7;
    public static final int AVMDL_DNS_ENABLE_PARALLEL = 4;
    public static final int AVMDL_DNS_ENABLE_REFRESH = 6;
    public static final int AVMDL_DNS_FORCE_EXPIRED_TIME = 10;
    public static final int AVMDL_DNS_GOOGLE_PARSE_HOST = 9;
    public static final int AVMDL_DNS_HTTPDNS_NEED_RANK = 16;
    public static final int AVMDL_DNS_HTTPDNS_NEW_CACHE = 18;
    public static final int AVMDL_DNS_MAIN_DELAYED_USE_BACKUP_FOR_EXPIRED_CACHE_TIME = 12;
    public static final int AVMDL_DNS_MAIN_DELAYED_USE_BACKUP_TIME = 3;
    public static final int AVMDL_DNS_MAIN_TYPE = 0;
    public static final int AVMDL_DNS_OWN_PARSE_HOST = 8;
    public static final int AVMDL_HTTPDNS_ACCOUNT_ID = 13;
    public static final int AVMDL_HTTPDNS_DISABLE_AUTHENTICATION = 17;
    public static final int AVMDL_HTTPDNS_ENABLE_AUTHENTICATION = 15;
    public static final int AVMDL_HTTPDNS_SECRET_KEY = 14;
    public static final int DNS_TYPE_BACKUP_IP = 11;
    public static final int DNS_TYPE_FEED_DNS = 12;
    public static final int DNS_TYPE_HTTP_ALI = 1;
    public static final int DNS_TYPE_HTTP_CUSTOM = 4;
    public static final int DNS_TYPE_HTTP_GOOGLE = 3;
    public static final int DNS_TYPE_HTTP_OWN = 2;
    public static final int DNS_TYPE_HTTP_OWN_HASH = 5;
    public static final int DNS_TYPE_HTTP_SERVER = 10;
    public static final int DNS_TYPE_LOCAL = 0;
    public static final int DNS_TYPE_LOCAL_PRIORITY = 6;
    public static final int PARSER_IS_BACKUP = 1;
    public static final int PARSER_IS_MAIN = 0;
    private static final String TAG = "AVMDLDNSParser";
    public static AVMDLCustomHTTPDNSParser mCustomHttpDNSParser = null;
    public static int mGloabalDisableParallelForExpiredCache = 0;
    public static int mGlobalBackType = 2;
    public static int mGlobalBackUpDelayedTime = 0;
    public static int mGlobalBackUpDelayedTimeForExpiredCache = 0;
    public static int mGlobalDefaultExpiredTime = 60;
    public static int mGlobalDisableAuthentication = 0;
    public static int mGlobalEnableAuthentication = 0;
    public static int mGlobalEnableBackUpIp = 0;
    public static int mGlobalEnableDNSLog = 0;
    public static int mGlobalEnableParallel = 0;
    public static int mGlobalEnableRefresh = 0;
    public static int mGlobalForceExpiredTime = 0;
    public static String mGlobalGoogleDNSParseHost = "";
    public static int mGlobalHTTPDNSNeedRank = 0;
    public static int mGlobalHTTPDNSNewCache = 0;
    public static String mGlobalHttpDNSAccountId = "";
    public static String mGlobalHttpDNSSecretKey = "";
    public static String mGlobalHttpDNSTimeStamp = "2524579199000";
    public static int mGlobalMainType = 0;
    public static String mGlobalOwnDNSParseHost = "";
    private static volatile AVMDLDNSParser mInstance;
    public static AVMDLNetClientMaker mNetClientMaker;
    private Handler mHandler;
    private Lock mLock;
    private Map<String, AVMDLHostProcessor> mProcessors;
    private int mRefCount;
    private int mState;
    private HandlerThread mThread;
    private int mTimeOut;
    private int mType;

    /* JADX INFO: renamed from: com.ss.mediakit.net.AVMDLDNSParser$1, reason: invalid class name */
    public class AnonymousClass1 extends Handler {
        final /* synthetic */ AVMDLDNSParser this$0;

        public static /* synthetic */ String a(int r100, AVMDLDNSInfo r101) {
            return lambda$handleMessage$0(r100, r101);
        }

        public static /* synthetic */ String b(int r100, AVMDLDNSInfo r101) {
            return lambda$handleMessage$1(r100, r101);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            Object r101 = r100.obj;
            if (r101 == null) goto L5;
            final AVMDLDNSInfo r102 = (AVMDLDNSInfo) r101;
        L7:
            if (AVMDLLog.isLogLevelEnabled(1) == false) goto L9;
            final int r103 = r100.what;
            AVMDLLog.d(AVMDLDNSParser.TAG, new z0(r103, r102));
        L9:
            int r104 = r100.what;
            if (r104 != 2) goto L12;
            AVMDLDNSParser.access$000(this.this$0, r104, r102);
        L29:
            if (AVMDLLog.isLogLevelEnabled(1) == false) goto L32;
            final int r105 = r100.what;
            AVMDLLog.d(AVMDLDNSParser.TAG, new a1(r105, r102));
            return;
        L32:
            return;
        L12:
            if (r104 != 3) goto L14;
            AVMDLDNSParser.access$100(this.this$0, r104, r102);
            goto L29
        L14:
            if (r104 != 4) goto L16;
            AVMDLDNSParser.access$200(this.this$0, r104, r102);
            goto L29
        L16:
            if (r104 != 6) goto L18;
            AVMDLDNSParser.access$300(this.this$0, r104, r102);
            goto L29
        L18:
            if (r104 != 7) goto L20;
            AVMDLDNSParser.access$400(this.this$0, r104, r102);
            goto L29
        L20:
            if (r104 != 8) goto L29;
            AVMDLDNSParser.access$500(this.this$0, r104, r102);
            goto L29
        L5:
            r102 = null;
            goto L7
        }

        public AnonymousClass1(AVMDLDNSParser r100, Looper r101) {
            this.this$0 = r100;
            super(r101);
        }

        private static /* synthetic */ String lambda$handleMessage$0(int r100, AVMDLDNSInfo r101) {
            return String.format(Locale.US, "----receive msg what:%d info:%s", new Object[]{Integer.valueOf(r100), r101});
        }

        private static /* synthetic */ String lambda$handleMessage$1(int r100, AVMDLDNSInfo r101) {
            return String.format(Locale.US, "****end proc msg what:%d info:%s", new Object[]{Integer.valueOf(r100), r101});
        }
    }

    public static /* synthetic */ String A() {
        return lambda$processHijack$4();
    }

    public static /* synthetic */ String B() {
        return lambda$addListenerInternal$44();
    }

    public static /* synthetic */ String C() {
        return lambda$processBatchParseMsg$15();
    }

    public static /* synthetic */ String D() {
        return lambda$proccessPreParseMsg$25();
    }

    public static /* synthetic */ String E(AVMDLDNSInfo r100, long r101) {
        return lambda$sendPreParseMsg$28(r100, r101);
    }

    public static /* synthetic */ String F(Exception r100) {
        return lambda$processBatchParseMsg$14(r100);
    }

    public static /* synthetic */ String G() {
        return lambda$processBatchParseMsg$12();
    }

    public static /* synthetic */ String H() {
        return lambda$processDNSTypeChangedParseMsg$22();
    }

    public static /* synthetic */ String I(int r100, int r101) {
        return lambda$addListenerInternal$41(r100, r101);
    }

    public static /* synthetic */ String J() {
        return lambda$addListenerInternal$43();
    }

    public static /* synthetic */ String K() {
        return lambda$proccessSucMsg$21();
    }

    public static /* synthetic */ String L() {
        return lambda$addListenerInternal$45();
    }

    public static /* synthetic */ String M(AVMDLDNSParserListener r100, String r101, int r102) {
        return lambda$addListenerInternal$39(r100, r101, r102);
    }

    public static /* synthetic */ String N() {
        return lambda$sendBatchParseMsg$38();
    }

    public static /* synthetic */ String O() {
        return lambda$proccessFailMsg$35();
    }

    public static /* synthetic */ String P() {
        return lambda$removeListenerInternal$48();
    }

    public static /* synthetic */ String Q(AVMDLDNSParserListener r100, String r101) {
        return lambda$removeListenerInternal$46(r100, r101);
    }

    public static /* synthetic */ String R(int r100) {
        return lambda$getIntValue$1(r100);
    }

    public static /* synthetic */ String S(String r100, int r101) {
        return lambda$setStringValue$3(r100, r101);
    }

    public static /* synthetic */ String T(int r100, AVMDLDNSInfo r101) {
        return lambda$proccessPreParseMsg$26(r100, r101);
    }

    public static /* synthetic */ String U() {
        return lambda$removeListenerInternal$49();
    }

    public static /* synthetic */ String V() {
        return lambda$proccessFailMsg$29();
    }

    public static /* synthetic */ String W(AVMDLHostProcessor r100, AVMDLDNSInfo r101) {
        return lambda$proccessFailMsg$31(r100, r101);
    }

    public static /* synthetic */ String X(int r100, AVMDLDNSInfo r101) {
        return lambda$proccessSucMsg$17(r100, r101);
    }

    public static /* synthetic */ String Y() {
        return lambda$proccessSucMsg$16();
    }

    public static /* synthetic */ String a(String r100) {
        return lambda$doParseHosts$37(r100);
    }

    public static /* synthetic */ String b(AVMDLDNSParserListener r100) {
        return lambda$proccessSucMsg$19(r100);
    }

    public static /* synthetic */ String c(AVMDLHostProcessor r100, AVMDLDNSInfo r101) {
        return lambda$proccessSucMsg$18(r100, r101);
    }

    public static /* synthetic */ String d() {
        return lambda$removeListenerInternal$50();
    }

    public static /* synthetic */ String e(AVMDLCustomHTTPDNSParser r100) {
        return lambda$setCustomHttpDNSParser$6(r100);
    }

    public static /* synthetic */ String f() {
        return lambda$processBackupParseMsg$11();
    }

    public static /* synthetic */ String g(int r100) {
        return lambda$processBatchParseMsg$13(r100);
    }

    public static /* synthetic */ String h() {
        return lambda$processDNSTypeChangedParseMsg$24();
    }

    public static /* synthetic */ String i(int r100, AVMDLDNSInfo r101) {
        return lambda$processBackupParseMsg$8(r100, r101);
    }

    public static /* synthetic */ String j() {
        return lambda$processHijack$5();
    }

    public static /* synthetic */ String k(AVMDLDNSInfo r100) {
        return lambda$proccessPreParseMsg$27(r100);
    }

    public static /* synthetic */ String l(AVMDLHostProcessor r100) {
        return lambda$addListenerInternal$42(r100);
    }

    public static /* synthetic */ String m(int r100, AVMDLDNSInfo r101) {
        return lambda$processDNSTypeChangedParseMsg$23(r100, r101);
    }

    public static /* synthetic */ String n(AVMDLHostProcessor r100) {
        return lambda$removeListenerInternal$47(r100);
    }

    public static /* synthetic */ String o(int r100, AVMDLDNSInfo r101) {
        return lambda$proccessFailMsg$30(r100, r101);
    }

    public static /* synthetic */ String p(int r100, int r101) {
        return lambda$setIntValue$0(r100, r101);
    }

    public static /* synthetic */ String q() {
        return lambda$processBackupParseMsg$7();
    }

    public static /* synthetic */ String r(AVMDLHostProcessor r100) {
        return lambda$addListenerInternal$40(r100);
    }

    public static /* synthetic */ String s(AVMDLDNSParserListener r100) {
        return lambda$proccessFailMsg$33(r100);
    }

    public static /* synthetic */ String t() {
        return lambda$proccessFailMsg$32();
    }

    public static /* synthetic */ String u(int r100, int r101) {
        return lambda$getIntValue$2(r100, r101);
    }

    public static /* synthetic */ String v() {
        return lambda$proccessFailMsg$34();
    }

    public static /* synthetic */ String w(AVMDLHostProcessor r100, AVMDLDNSInfo r101) {
        return lambda$processBackupParseMsg$9(r100, r101);
    }

    public static /* synthetic */ String x(AVMDLDNSInfo r100) {
        return lambda$processBackupParseMsg$10(r100);
    }

    public static /* synthetic */ String y() {
        return lambda$proccessSucMsg$20();
    }

    public static /* synthetic */ String z(String r100) {
        return lambda$doParseHosts$36(r100);
    }

    public void release() {
    }

    public static AVMDLDNSParser getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(AVMDLDNSParser.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new AVMDLDNSParser();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AVMDLDNSParser.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public static AVMDLNetClient getNetClient() {
        monitor-enter(AVMDLDNSParser.class);
        AVMDLNetClientMaker r100 = mNetClientMaker;     // Catch: Throwable -> L12
        if (r100 == null) goto L7;
        AVMDLNetClient r101 = r100.getNetClient();     // Catch: Throwable -> L12
    L8:
        monitor-exit(AVMDLDNSParser.class);     // Catch: Throwable -> L12
        if (r101 == null) goto L11;
        return r101;
    L11:
        return new AVMDLHTTPNetwork();
    L7:
        r101 = null;
    L12:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ String lambda$addListenerInternal$43() {
        return String.format(Locale.US, "add listener", new Object[0]);
    }

    private static /* synthetic */ String lambda$addListenerInternal$44() {
        return String.format(Locale.US, "new processor implement parse", new Object[0]);
    }

    private static /* synthetic */ String lambda$addListenerInternal$45() {
        return String.format(Locale.US, "****end add listener", new Object[0]);
    }

    private static /* synthetic */ String lambda$proccessFailMsg$29() {
        return String.format(Locale.US, "proc fail msg  fail, info or host is null", new Object[0]);
    }

    private static /* synthetic */ String lambda$proccessFailMsg$32() {
        return String.format(Locale.US, "processor end, notify result", new Object[0]);
    }

    private static /* synthetic */ String lambda$proccessFailMsg$34() {
        return String.format(Locale.US, "processor is not end", new Object[0]);
    }

    private static /* synthetic */ String lambda$proccessFailMsg$35() {
        return String.format(Locale.US, "****end proc fail msg what", new Object[0]);
    }

    private static /* synthetic */ String lambda$proccessPreParseMsg$25() {
        return String.format(Locale.US, "proc pre msg  fail, info or host is null", new Object[0]);
    }

    private static /* synthetic */ String lambda$proccessSucMsg$16() {
        return String.format(Locale.US, "proc suc msg  fail, info or host is null", new Object[0]);
    }

    private static /* synthetic */ String lambda$proccessSucMsg$20() {
        return String.format(Locale.US, "remove all listeners and remove host", new Object[0]);
    }

    private static /* synthetic */ String lambda$proccessSucMsg$21() {
        return String.format(Locale.US, "****end proc suc msg", new Object[0]);
    }

    private static /* synthetic */ String lambda$processBackupParseMsg$11() {
        return String.format(Locale.US, "****end proc parser msg", new Object[0]);
    }

    private static /* synthetic */ String lambda$processBackupParseMsg$7() {
        return String.format(Locale.US, "proc parser msg  fail, info or host is null", new Object[0]);
    }

    private static /* synthetic */ String lambda$processBatchParseMsg$12() {
        return String.format(Locale.US, "proc parser msg  fail, info or host is null", new Object[0]);
    }

    private static /* synthetic */ String lambda$processBatchParseMsg$15() {
        return String.format(Locale.US, "****end proc batch parser msg", new Object[0]);
    }

    private static /* synthetic */ String lambda$processDNSTypeChangedParseMsg$22() {
        return String.format(Locale.US, "proc main parse msg  fail, info or host is null", new Object[0]);
    }

    private static /* synthetic */ String lambda$processDNSTypeChangedParseMsg$24() {
        return String.format(Locale.US, "****end proc main parse msg", new Object[0]);
    }

    private static /* synthetic */ String lambda$processHijack$4() {
        return String.format(Locale.US, "----process hijack old dnsmain:%d back:%d", new Object[]{Integer.valueOf(mGlobalMainType), Integer.valueOf(mGlobalBackType)});
    }

    private static /* synthetic */ String lambda$processHijack$5() {
        return String.format(Locale.US, "****process hijack new dnsmain:%d back:%d", new Object[]{Integer.valueOf(mGlobalMainType), Integer.valueOf(mGlobalBackType)});
    }

    private static /* synthetic */ String lambda$removeListenerInternal$48() {
        return String.format(Locale.US, "remove listener", new Object[0]);
    }

    private static /* synthetic */ String lambda$removeListenerInternal$49() {
        return String.format(Locale.US, "listeners empty for processors", new Object[0]);
    }

    private static /* synthetic */ String lambda$removeListenerInternal$50() {
        return String.format(Locale.US, "****end remove listener", new Object[0]);
    }

    private static /* synthetic */ String lambda$sendBatchParseMsg$38() {
        return String.format(Locale.US, "send msg for batch parse", new Object[0]);
    }

    public static void processHijack() {
        AVMDLLog.d(TAG, new r0());
        int r100 = mGlobalMainType;
        if (r100 != 0) goto L5;
        mGlobalMainType = mGlobalBackType;
        mGlobalBackType = r100;
    L5:
        AVMDLLog.d(TAG, new t0());
    }

    public AVMDLDNSParser() {
        this.mTimeOut = 5;
        this.mLock = new ReentrantLock();
        this.mProcessors = new HashMap();
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2(TAG);
        this.mThread = r100;
        ThreadMethodProxy.start(r100);
        this.mHandler = new AnonymousClass1(this, this.mThread.getLooper());
    }

    private static String decodeBase64(String r100) {
        return new String(Base64.getDecoder().decode(r100));
    }

    public static int getIntValue(final int r100) {
        AVMDLLog.d(TAG, new u0(r100));
        monitor-enter(AVMDLDNSParser.class);
        switch(r100) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L8;
            case 11: goto L7;
            case 12: goto L6;
            default: goto L5;
        };
    L5:
        final int r101 = Integer.MIN_VALUE;
    L17:
        monitor-exit(AVMDLDNSParser.class);     // Catch: Throwable -> L20
        AVMDLLog.d(TAG, new v0(r101, r100));
        return r101;
    L6:
        r101 = mGlobalBackUpDelayedTimeForExpiredCache;     // Catch: Throwable -> L20
        goto L17
    L7:
        r101 = mGloabalDisableParallelForExpiredCache;     // Catch: Throwable -> L20
        goto L17
    L8:
        r101 = mGlobalForceExpiredTime;     // Catch: Throwable -> L20
        goto L17
    L9:
        r101 = mGlobalEnableDNSLog;     // Catch: Throwable -> L20
        goto L17
    L10:
        r101 = mGlobalEnableRefresh;     // Catch: Throwable -> L20
        goto L17
    L11:
        r101 = mGlobalEnableBackUpIp;     // Catch: Throwable -> L20
        goto L17
    L12:
        r101 = mGlobalEnableParallel;     // Catch: Throwable -> L20
        goto L17
    L13:
        r101 = mGlobalBackUpDelayedTime;     // Catch: Throwable -> L20
        goto L17
    L14:
        r101 = mGlobalDefaultExpiredTime;     // Catch: Throwable -> L20
        goto L17
    L15:
        r101 = mGlobalBackType;     // Catch: Throwable -> L20
        goto L17
    L16:
        r101 = mGlobalMainType;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ String lambda$addListenerInternal$40(AVMDLHostProcessor r100) {
        return String.format(Locale.US, "get processor:%s", new Object[]{r100});
    }

    private static /* synthetic */ String lambda$addListenerInternal$42(AVMDLHostProcessor r100) {
        return String.format(Locale.US, "create processor:%s", new Object[]{r100});
    }

    private static /* synthetic */ String lambda$doParseHosts$36(String r100) {
        return String.format(Locale.US, "for host:%s has dns info not need do batch parse", new Object[]{r100});
    }

    private static /* synthetic */ String lambda$doParseHosts$37(String r100) {
        return String.format(Locale.US, "for host:%s has processor not need do batch parse", new Object[]{r100});
    }

    private static /* synthetic */ String lambda$getIntValue$1(int r100) {
        return String.format(Locale.US, "----get value for key:%d", new Object[]{Integer.valueOf(r100)});
    }

    private static /* synthetic */ String lambda$proccessFailMsg$33(AVMDLDNSParserListener r100) {
        return String.format(Locale.US, "listener:%s oncompletion fail", new Object[]{r100});
    }

    private static /* synthetic */ String lambda$proccessPreParseMsg$27(AVMDLDNSInfo r100) {
        Locale r101 = Locale.US;
        Object[] r102 = new Object[2];
        r102[0] = r100;
        if (r100 != null) goto L5;
        long r103 = -1;
    L6:
        r102[1] = Long.valueOf(r103);
        return String.format(r101, "cache:%s expiredT:%d", r102);
    L5:
        r103 = r100.mExpiredTime;
        goto L6
    }

    private static /* synthetic */ String lambda$proccessSucMsg$19(AVMDLDNSParserListener r100) {
        return String.format(Locale.US, "listener:%s oncompletion suc", new Object[]{r100});
    }

    private static /* synthetic */ String lambda$processBackupParseMsg$10(AVMDLDNSInfo r100) {
        return String.format(Locale.US, "****get processor null for host:%s", new Object[]{r100.mHost});
    }

    private static /* synthetic */ String lambda$processBatchParseMsg$13(int r100) {
        return String.format(Locale.US, "----proc batch parse msg what:%d", new Object[]{Integer.valueOf(r100)});
    }

    private static /* synthetic */ String lambda$processBatchParseMsg$14(Exception r100) {
        return String.format(Locale.US, "parse end create httpdnshosts fail" + r100, new Object[0]);
    }

    private static /* synthetic */ String lambda$removeListenerInternal$47(AVMDLHostProcessor r100) {
        return String.format(Locale.US, "get processor:%s", new Object[]{r100});
    }

    private static /* synthetic */ String lambda$setCustomHttpDNSParser$6(AVMDLCustomHTTPDNSParser r100) {
        Locale r101 = Locale.US;
        int r102 = 1;
        Object[] r103 = new Object[1];
        if (r100 != null) goto L5;
        r102 = 0;
    L5:
        r103[0] = Integer.valueOf(r102);
        return String.format(r101, "set custom http dns parser:%d", r103);
    }

    private void reportLog(AVMDLDNSInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r100.mIpList) == false) goto L7;
        return;
    L7:
        if (mGlobalEnableDNSLog <= 0) goto L15;
        JSONObject r101 = new JSONObject();
        r101.put(FrescoMonitorConst.LOG_TYPE, "mdl_dns_log");     // Catch: Exception -> L11
        r101.put("dns_type", r100.mType);     // Catch: Exception -> L11
        r101.put("ip_list", r100.mIpList);     // Catch: Exception -> L11
        AVMDLDataLoader.getInstance().onLogInfo(15, 0, r101.toString());     // Catch: Exception -> L11
        return;
    L17:
        return;
    }

    private void sendBatchParseMsg(String[] r110) {
        if (r110 != null) goto L5;
    L9:
        AVMDLLog.d(TAG, "hosts null not need do batch parse");
        return;
    L5:
        if (r110.length == 0) goto L9;
        AVMDLDNSInfo r100 = new AVMDLDNSInfo(mGlobalMainType, r110, null, 0, null, -1);
        Message r111 = new Message();
        r111.what = 7;
        r111.obj = r100;
        AVMDLLog.d(TAG, new f0());
        this.mHandler.sendMessage(r111);
    }

    public static void setClientMaker(AVMDLNetClientMaker r100) {
        monitor-enter(AVMDLDNSParser.class);
        if (r100 != null) goto L11;
    L6:
        monitor-exit(AVMDLDNSParser.class);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        mNetClientMaker = r100;     // Catch: Throwable -> L8
        goto L6
    }

    public static void setCustomHttpDNSParser(final AVMDLCustomHTTPDNSParser r100) {
        monitor-enter(AVMDLDNSParser.class);
        AVMDLLog.d(TAG, new n(r100));     // Catch: Throwable -> L9
        if (r100 == null) goto L7;
        mCustomHttpDNSParser = r100;     // Catch: Throwable -> L9
    L7:
        monitor-exit(AVMDLDNSParser.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void doParseHosts(String[] r100) {
        if (r100 != null) goto L5;
    L37:
        AVMDLLog.d(TAG, "hosts is null, not need do batch host parse");
        return;
    L5:
        if (r100.length == 0) goto L37;
        int r101 = r100.length;
        int r102 = 0;
    L9:
        if (r102 >= r100.length) goto L32;
        if (TextUtils.isEmpty(r100[r102]) == true) goto L28;
        if (IPCache.getInstance().get(r100[r102]) != null) goto L16;
        this.mLock.lock();
        if (this.mProcessors.get(r100[r102]) != null) goto L23;
    L27:
        this.mLock.unlock();
        goto L28
    L23:
        if (AVMDLLog.isLogLevelEnabled(1) == false) goto L25;
        final String r103 = r100[r102];     // Catch: Throwable -> L29
        AVMDLLog.d(TAG, new s0(r103));     // Catch: Throwable -> L29
    L25:
        r100[r102] = null;     // Catch: Throwable -> L29
        r101 = r101 - 1;
    L29:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    L16:
        if (AVMDLLog.isLogLevelEnabled(1) == false) goto L18;
        final String r104 = r100[r102];
        AVMDLLog.d(TAG, new h0(r104));
    L18:
        r100[r102] = null;
        r101 = r101 - 1;
    L28:
        r102 = r102 + 1;
        goto L9
    L32:
        if (r101 != 0) goto L35;
        AVMDLLog.d(TAG, "has no hosts need do batch parse");
        return;
    L35:
        sendBatchParseMsg(r100);
    }

    private static /* synthetic */ String lambda$addListenerInternal$41(int r100, int r101) {
        return String.format(Locale.US, "mainType:%d backType:%d", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)});
    }

    private static /* synthetic */ String lambda$getIntValue$2(int r100, int r101) {
        return String.format(Locale.US, "****get value:%d for key:%d", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)});
    }

    private static /* synthetic */ String lambda$proccessFailMsg$30(int r100, AVMDLDNSInfo r101) {
        return String.format(Locale.US, "----proc fail msg what:%d host:%s", new Object[]{Integer.valueOf(r100), r101.mHost});
    }

    private static /* synthetic */ String lambda$proccessFailMsg$31(AVMDLHostProcessor r100, AVMDLDNSInfo r101) {
        return String.format(Locale.US, "get processor:%s host:%s", new Object[]{r100, r101.mHost});
    }

    private static /* synthetic */ String lambda$proccessPreParseMsg$26(int r100, AVMDLDNSInfo r101) {
        return String.format(Locale.US, "----proc pre parse msg what:%d host:%s", new Object[]{Integer.valueOf(r100), r101.mHost});
    }

    private static /* synthetic */ String lambda$proccessSucMsg$17(int r100, AVMDLDNSInfo r101) {
        return String.format(Locale.US, "----proc suc msg what:%d host:%s", new Object[]{Integer.valueOf(r100), r101.mHost});
    }

    private static /* synthetic */ String lambda$proccessSucMsg$18(AVMDLHostProcessor r100, AVMDLDNSInfo r101) {
        return String.format(Locale.US, "get processor:%s host:%s", new Object[]{r100, r101.mHost});
    }

    private static /* synthetic */ String lambda$processBackupParseMsg$8(int r100, AVMDLDNSInfo r101) {
        return String.format(Locale.US, "----proc parser msg what:%d host:%s", new Object[]{Integer.valueOf(r100), r101.mHost});
    }

    private static /* synthetic */ String lambda$processBackupParseMsg$9(AVMDLHostProcessor r100, AVMDLDNSInfo r101) {
        return String.format(Locale.US, "----get processor:%s host:%s", new Object[]{r100, r101.mHost});
    }

    private static /* synthetic */ String lambda$processDNSTypeChangedParseMsg$23(int r100, AVMDLDNSInfo r101) {
        return String.format(Locale.US, "----proc dnstype change parse msg what:%d host:%s", new Object[]{Integer.valueOf(r100), r101.mHost});
    }

    private static /* synthetic */ String lambda$removeListenerInternal$46(AVMDLDNSParserListener r100, String r101) {
        return String.format(Locale.US, "---remove listener:%s for host:%s", new Object[]{r100, r101});
    }

    private static /* synthetic */ String lambda$sendPreParseMsg$28(AVMDLDNSInfo r100, long r101) {
        return String.format(Locale.US, "send preparse for host:%s delayTime:%d", new Object[]{r100.mHost, Long.valueOf(r101 + 3000)});
    }

    private static /* synthetic */ String lambda$setIntValue$0(int r100, int r101) {
        return String.format(Locale.US, "****set value:%d for key:%d", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)});
    }

    private static /* synthetic */ String lambda$setStringValue$3(String r100, int r101) {
        return String.format(Locale.US, "****set value:%s for key:%d", new Object[]{r100, Integer.valueOf(r101)});
    }

    private void proccessFailMsg(final int r110, final AVMDLDNSInfo r111) {
        if (r111 != null) goto L5;
    L27:
        AVMDLLog.d(TAG, new i0());
        return;
    L5:
        if (r111.mHost == null) goto L27;
        AVMDLLog.d(TAG, new j0(r110, r111));
        this.mLock.lock();
        final AVMDLHostProcessor r100 = this.mProcessors.get(r111.mHost);     // Catch: Throwable -> L24
        AVMDLLog.d(TAG, new k0(r100, r111));     // Catch: Throwable -> L24
        if (r100 != null) goto L11;
    L22:
        this.mLock.unlock();
        AVMDLLog.d(TAG, new o0());
        return;
    L11:
        if (r100.isValidSourceId(r111.mId) == false) goto L22;
        r100.processResult(r110, r111);     // Catch: Throwable -> L24
        if (r100.isEnd() == false) goto L21;
        AVMDLLog.d(TAG, new l0());     // Catch: Throwable -> L24
        Iterator<AVMDLDNSParserListener> r112 = r100.mListeners.keySet().iterator();     // Catch: Throwable -> L24
    L16:
        if (r112.hasNext() == false) goto L20;
        final AVMDLDNSParserListener r101 = r112.next();     // Catch: Throwable -> L24
        if (r101 == null) goto L16;
        AVMDLLog.d(TAG, new m0(r101));     // Catch: Throwable -> L24
        r101.onCompletion(0, r111.mHost, null, 0, null, r111.mType);     // Catch: Throwable -> L24
        goto L16
    L20:
        r100.mListeners.clear();     // Catch: Throwable -> L24
        this.mProcessors.remove(r111.mHost);     // Catch: Throwable -> L24
        goto L22
    L21:
        AVMDLLog.d(TAG, new n0());     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void proccessPreParseMsg(final int r100, final AVMDLDNSInfo r101) {
        if (mGlobalEnableRefresh > 0) goto L6;
        AVMDLLog.d(TAG, "not support preparse");
        return;
    L6:
        if (r101 != null) goto L8;
    L17:
        AVMDLLog.d(TAG, new o());
        return;
    L8:
        if (r101.mHost == null) goto L17;
        AVMDLLog.d(TAG, new p(r100, r101));
        final AVMDLDNSInfo r102 = IPCache.getInstance().get(r101.mHost);
        long r103 = System.currentTimeMillis();
        AVMDLLog.d(TAG, new q(r102));
        if (r102 != null) goto L13;
    L14:
        AVMDLLog.d(TAG, "add host for preparse");
        addListenerInternal(r101.mHost, null, r101.mType, r101.mTaskType);
    L15:
        AVMDLLog.d(TAG, "****proc pre parse msg what:%d host:%s");
        return;
    L13:
        if (r102.mExpiredTime >= r103) goto L15;
        goto L14
    }

    private void proccessSucMsg(final int r110, final AVMDLDNSInfo r111) {
        if (r111 != null) goto L5;
    L25:
        AVMDLLog.d(TAG, new z());
        return;
    L5:
        if (r111.mHost == null) goto L25;
        AVMDLLog.d(TAG, new a0(r110, r111));
        this.mLock.lock();
        final AVMDLHostProcessor r112 = this.mProcessors.get(r111.mHost);     // Catch: Throwable -> L22
        AVMDLLog.d(TAG, new b0(r112, r111));     // Catch: Throwable -> L22
        if (r112 == null) goto L19;
        HashMap<AVMDLDNSParserListener, Integer> r100 = r112.mListeners;     // Catch: Throwable -> L22
        if (r100 == null) goto L19;
        Iterator<AVMDLDNSParserListener> r101 = r100.keySet().iterator();     // Catch: Throwable -> L22
    L14:
        if (r101.hasNext() == false) goto L18;
        final AVMDLDNSParserListener r102 = r101.next();     // Catch: Throwable -> L22
        if (r102 == null) goto L14;
        AVMDLLog.d(TAG, new c0(r102));     // Catch: Throwable -> L22
        r102.onCompletion(0, r111.mHost, r111.mIpList, r111.mExpiredTime, r111.mExtraInfo, r111.mType);     // Catch: Throwable -> L22
        goto L14
    L18:
        r112.mListeners.clear();     // Catch: Throwable -> L22
        this.mProcessors.remove(r111.mHost);     // Catch: Throwable -> L22
        AVMDLLog.d(TAG, new d0());     // Catch: Throwable -> L22
    L19:
        sendPreParseMsg(r111.mType, r111.mHost, r111.mExpiredTime - System.currentTimeMillis(), r111.mTaskType);     // Catch: Throwable -> L22
        reportLog(r111);     // Catch: Throwable -> L22
        this.mLock.unlock();
        AVMDLLog.d(TAG, new e0());
        return;
    L22:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void processBackupParseMsg(final int r100, final AVMDLDNSInfo r101) {
        if (r101 != null) goto L5;
    L17:
        AVMDLLog.d(TAG, new w0());
        return;
    L5:
        if (r101.mHost == null) goto L17;
        AVMDLLog.d(TAG, new x0(r100, r101));
        this.mLock.lock();
        final AVMDLHostProcessor r102 = this.mProcessors.get(r101.mHost);     // Catch: Throwable -> L14
        if (r102 == null) goto L11;
        AVMDLLog.d(TAG, new y0(r102, r101));     // Catch: Throwable -> L14
        r102.processMsg(r100, r101);     // Catch: Throwable -> L14
    L12:
        this.mLock.unlock();
        AVMDLLog.d(TAG, new c());
        return;
    L11:
        AVMDLLog.d(TAG, new b(r101));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void processBatchParseMsg(final int r100, AVMDLDNSInfo r101) {
        if (r101 == null) goto L25;
        String[] r102 = r101.mHosts;
        if (r102 == null) goto L25;
        if (r102.length == 0) goto L25;
        AVMDLLog.d(TAG, new e(r100));
        int r103 = 2;
        if (mGlobalEnableParallel > 0) goto L27;
        int r104 = mGlobalMainType;
        if (r104 == 2) goto L27;
        if (r104 == 5) goto L27;
        new LocalDNSHosts(r101.mHosts, this.mHandler).start();
        AVMDLLog.d(TAG, new g());
        return;
    L27:
    L22:
        e = move-exception;
        AVMDLLog.d(TAG, new f(e));
        return;
    L18:
        if (mGlobalMainType != 5) goto L20;
        r103 = 5;
    L20:
        new HTTPDNSHosts(r101.mHosts, null, r103, this.mHandler).start();     // Catch: Exception -> L22
        return;
    L25:
        AVMDLLog.d(TAG, new d());
    }

    private void processDNSTypeChangedParseMsg(final int r100, final AVMDLDNSInfo r101) {
        if (r101 != null) goto L5;
    L14:
        AVMDLLog.d(TAG, new a());
        return;
    L5:
        if (r101.mHost == null) goto L14;
        AVMDLLog.d(TAG, new l(r100, r101));
        this.mLock.lock();
        getInstance().addHost(r101.mHost, null, r101.mType, r101.mTaskType);     // Catch: Throwable -> L11
        this.mLock.unlock();
        AVMDLLog.d(TAG, new w());
        return;
    L11:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void removeListenerInternal(final String r100, final AVMDLDNSParserListener r101) {
        if (TextUtils.isEmpty(r100) == true) goto L19;
        if (r101 == null) goto L22;
        AVMDLLog.d(TAG, new h(r101, r100));
        this.mLock.lock();
        final AVMDLHostProcessor r102 = this.mProcessors.get(r100);     // Catch: Throwable -> L16
        AVMDLLog.d(TAG, new i(r102));     // Catch: Throwable -> L16
        if (r102 == null) goto L10;
        AVMDLLog.d(TAG, new j());     // Catch: Throwable -> L16
        r102.mListeners.remove(r101);     // Catch: Throwable -> L16
    L10:
        if (r102 != null) goto L12;
    L14:
        this.mLock.unlock();
        AVMDLLog.d(TAG, new m());
        return;
    L12:
        if (r102.mListeners.size() != 0) goto L14;
        AVMDLLog.d(TAG, new k());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    L22:
        return;
    }

    public static void setIntValue(final int r100, final int r101) {
        AVMDLLog.d(TAG, new p0(r101, r100));
        monitor-enter(AVMDLDNSParser.class);
        switch(r100) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L21;
            case 9: goto L21;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L21;
            case 14: goto L21;
            case 15: goto L9;
            case 16: goto L8;
            case 17: goto L7;
            case 18: goto L6;
            default: goto L21;
        };
    L6:
        mGlobalHTTPDNSNewCache = r101;     // Catch: Throwable -> L23
        goto L21
    L7:
        mGlobalDisableAuthentication = r101;     // Catch: Throwable -> L23
        goto L21
    L8:
        mGlobalHTTPDNSNeedRank = r101;     // Catch: Throwable -> L23
        goto L21
    L9:
        mGlobalEnableAuthentication = r101;     // Catch: Throwable -> L23
        goto L21
    L10:
        mGlobalBackUpDelayedTimeForExpiredCache = r101;     // Catch: Throwable -> L23
        goto L21
    L11:
        mGloabalDisableParallelForExpiredCache = r101;     // Catch: Throwable -> L23
        goto L21
    L12:
        mGlobalForceExpiredTime = r101;     // Catch: Throwable -> L23
        goto L21
    L13:
        mGlobalEnableDNSLog = r101;     // Catch: Throwable -> L23
        goto L21
    L14:
        mGlobalEnableRefresh = r101;     // Catch: Throwable -> L23
        goto L21
    L15:
        mGlobalEnableBackUpIp = r101;     // Catch: Throwable -> L23
        goto L21
    L16:
        mGlobalEnableParallel = r101;     // Catch: Throwable -> L23
        goto L21
    L17:
        mGlobalBackUpDelayedTime = r101;     // Catch: Throwable -> L23
        goto L21
    L18:
        mGlobalDefaultExpiredTime = r101;     // Catch: Throwable -> L23
        goto L21
    L19:
        mGlobalBackType = r101;     // Catch: Throwable -> L23
        goto L21
    L20:
        mGlobalMainType = r101;     // Catch: Throwable -> L23
    L21:
        monitor-exit(AVMDLDNSParser.class);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static void setStringValue(final int r100, final String r101) {
        AVMDLLog.d(TAG, new g0(r101, r100));
        monitor-enter(AVMDLDNSParser.class);
        if (r100 == 8) goto L23;
        if (r100 == 9) goto L20;
        if (r100 == 13) goto L17;
        if (r100 == 14) goto L14;
    L25:
        monitor-exit(AVMDLDNSParser.class);     // Catch: Throwable -> L27
        return;
    L14:
        if (TextUtils.isEmpty(r101) == true) goto L25;
        mGlobalHttpDNSSecretKey = decodeBase64(r101);     // Catch: Throwable -> L27
        goto L25
    L17:
        if (TextUtils.isEmpty(r101) == true) goto L25;
        mGlobalHttpDNSAccountId = r101;     // Catch: Throwable -> L27
        goto L25
    L20:
        if (TextUtils.isEmpty(r101) == true) goto L25;
        mGlobalGoogleDNSParseHost = r101;     // Catch: Throwable -> L27
        goto L25
    L23:
        if (TextUtils.isEmpty(r101) == true) goto L25;
        mGlobalOwnDNSParseHost = r101;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public void postDNSInfoRefreshMsg(String r110, int r111) {
        AVMDLDNSInfo r100 = new AVMDLDNSInfo(r111, r110, null, 0, null, -1);
        Message r112 = new Message();
        r112.what = 8;
        r112.obj = r100;
        this.mHandler.sendMessage(r112);
    }

    public void removeHost(String r100, AVMDLDNSParserListener r101) {
        removeListenerInternal(r100, r101);
    }

    public void setBackUpIP(String r110, String r111) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L10;
        AVMDLDNSInfo r100 = new AVMDLDNSInfo(11, r110, r111, 0, null, -1);
        IPCache.getInstance().putBackUpIp(r110, r100);
        return;
    }

    public static /* synthetic */ void access$000(AVMDLDNSParser r100, int r101, AVMDLDNSInfo r102) {
        r100.proccessFailMsg(r101, r102);
    }

    public static /* synthetic */ void access$100(AVMDLDNSParser r100, int r101, AVMDLDNSInfo r102) {
        r100.proccessSucMsg(r101, r102);
    }

    public static /* synthetic */ void access$200(AVMDLDNSParser r100, int r101, AVMDLDNSInfo r102) {
        r100.proccessPreParseMsg(r101, r102);
    }

    public static /* synthetic */ void access$300(AVMDLDNSParser r100, int r101, AVMDLDNSInfo r102) {
        r100.processBackupParseMsg(r101, r102);
    }

    public static /* synthetic */ void access$400(AVMDLDNSParser r100, int r101, AVMDLDNSInfo r102) {
        r100.processBatchParseMsg(r101, r102);
    }

    public static /* synthetic */ void access$500(AVMDLDNSParser r100, int r101, AVMDLDNSInfo r102) {
        r100.processDNSTypeChangedParseMsg(r101, r102);
    }

    private static /* synthetic */ String lambda$addListenerInternal$39(AVMDLDNSParserListener r100, String r101, int r102) {
        return String.format(Locale.US, "---add listener:%s for host:%s dnstype:%d", new Object[]{r100, r101, Integer.valueOf(r102)});
    }

    public static void updateDNSInfo(String r110, String r111, long r112) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
    L9:
        AVMDLLog.d(TAG, "ip direct info invalid");
        return;
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L9;
        AVMDLDNSInfo r113 = new AVMDLDNSInfo(10, r110, r111, (r112 + ((long) mGlobalDefaultExpiredTime)) * 1000, null, -1);
        AVMDLLog.d(TAG, "server iplist, host = " + r110 + " type = 10 iplist = " + r111);
        IPCache.getInstance().put(r110, r113);
    }

    public static void updateFeedDNS(String r110, String r111, long r112) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
    L9:
        AVMDLLog.d(TAG, "input host or ipList is empty");
        return;
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L9;
        AVMDLDNSInfo r100 = new AVMDLDNSInfo(12, r110, r111, r112, null, -1);
        AVMDLLog.d(TAG, "feed iplist, host = " + r110 + " type = 12 iplist = " + r111);
        IPCache.getInstance().put(r110, r100);
    }

    public void postParseHostMsg(String r110, int r111, int r112) {
        AVMDLDNSInfo r100 = new AVMDLDNSInfo(r111, r110, null, 0, null, r112);
        Message r113 = new Message();
        r113.what = 5;
        r113.obj = r100;
        this.mHandler.sendMessage(r113);
    }

    private void addListenerInternal(final String r110, final AVMDLDNSParserListener r111, final int r210, int r211) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return;
    L5:
        AVMDLLog.d(TAG, new r(r111, r110, r210));
        this.mLock.lock();
        final AVMDLHostProcessor r100 = this.mProcessors.get(r110);     // Catch: Throwable -> L35
        AVMDLLog.d(TAG, new s(r100));     // Catch: Throwable -> L35
        int r101 = mGlobalMainType;     // Catch: Throwable -> L35
        int r102 = mGlobalBackType;     // Catch: Throwable -> L35
        int r103 = mGlobalEnableParallel;     // Catch: Throwable -> L35
        boolean r104 = false;
        if (r210 != 2) goto L9;
    L16:
        final int r112 = r210;
        int r105 = r103;
        final int r106 = 0;
    L17:
        AVMDLLog.d(TAG, new t(r112, r106));     // Catch: Throwable -> L35
        if (r100 != null) goto L20;
        int r107 = r112;
        int r108 = r105;
        final AVMDLHostProcessor r113 = new AVMDLHostProcessor(r110, this.mHandler, r107, r106, mGlobalBackUpDelayedTime, r108, mGlobalBackUpDelayedTimeForExpiredCache);     // Catch: Throwable -> L35
        AVMDLLog.d(TAG, new u(r113));     // Catch: Throwable -> L35
        r104 = true;
    L21:
        if (r111 != null) goto L23;
    L25:
        this.mProcessors.put(r110, r113);     // Catch: Throwable -> L35
        if (r104 == false) goto L33;
        AVMDLLog.d(TAG, new x());     // Catch: Throwable -> L35
        AVMDLDNSInfo r114 = new AVMDLDNSInfo(r112, r110, null, 0, null, r211);     // Catch: Throwable -> L35
        if (mGloabalDisableParallelForExpiredCache <= 0) goto L32;
        if (r111 != null) goto L31;
        r113.processMsg(9, r114);     // Catch: Throwable -> L35
        goto L33
    L31:
        r113.processMsg(5, r114);     // Catch: Throwable -> L35
        goto L33
    L32:
        r113.processMsg(5, r114);     // Catch: Throwable -> L35
    L33:
        this.mLock.unlock();
        AVMDLLog.d(TAG, new y());
        return;
    L23:
        if (r113.mListeners.containsKey(r111) == true) goto L25;
        AVMDLLog.d(TAG, new v());     // Catch: Throwable -> L35
        r113.mListeners.put(r111, 1);     // Catch: Throwable -> L35
        goto L25
    L20:
        r113 = r100;
        goto L21
    L9:
        if (r210 == 3) goto L16;
        if (r210 == 5) goto L16;
        if (r210 != 6) goto L15;
        r112 = r210;
        r106 = 2;
        r105 = 0;
        goto L17
    L15:
        r112 = r101;
        r105 = r103;
        r106 = r102;
    L35:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void sendPreParseMsg(int r110, String r111, final long r112, int r113) {
        if (TextUtils.isEmpty(r111) == false) goto L5;
    L11:
        AVMDLLog.d(TAG, "host is null or delayTimeMs invalid,not support preparse");
        return;
    L5:
        if (r112 <= 0) goto L11;
        if (mGlobalEnableRefresh <= 0) goto L13;
        final AVMDLDNSInfo r100 = new AVMDLDNSInfo(r110, r111, null, 0, null, r113);
        Message r114 = new Message();
        r114.what = 4;
        r114.obj = r100;
        AVMDLLog.d(TAG, new q0(r100, r112));
        this.mHandler.sendMessageDelayed(r114, r112 + 3000);
        return;
    }

    public void addHost(String r100, AVMDLDNSParserListener r101, int r102, int r103) {
        addListenerInternal(r100, r101, r102, r103);
    }
}
