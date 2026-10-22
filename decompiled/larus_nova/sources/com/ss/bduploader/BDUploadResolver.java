package com.ss.bduploader;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.bduploader.net.BDUploadDNSInfo;
import com.ss.bduploader.net.BDUploadDNSParser;
import com.ss.bduploader.net.BDUploadDNSParserListener;
import com.ss.bduploader.net.BDUploadThreadPool;
import com.ss.bduploader.net.HTTPDNS;
import com.ss.bduploader.net.IPCache;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class BDUploadResolver implements BDUploadDNSParserListener {
    public static final int DNS_TYPE_IS_VERSION_1 = 1;
    public static final int DNS_TYPE_IS_VERSION_2 = 2;
    public static int HOST_MAX_CACHE_TIME = 60000;
    private static final int MAX_CACHED = 128;
    private static final String TAG = "BDUploadResolver";
    private static final Hashtable<String, HostInfo> mCacheHosts = null;
    public static volatile int mDNSVersion = 1;
    private static int mEnableThreadPool;
    public static volatile int mIsUseTTnetDNS;
    private String mError;
    private Future mFuture;
    private HostInfo mHostInfo;
    private volatile String mHostName;
    private volatile String[] mIPStr;
    private volatile boolean mRet;
    private Thread mThread;
    private int mUseDNSType;

    public static class HostInfo {

        /* JADX INFO: renamed from: ip, reason: collision with root package name */
        public String f456075ip;
        public long time;

        public HostInfo() {
        }
    }

    public static class ParserHost implements Runnable {
        String mHostName;
        BDUploadResolver mResolver;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_bduploader_BDUploadResolver$ParserHost_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_bduploader_BDUploadResolver$ParserHost__run$___twin___() {
            InetAddress r100 = null;
            if (BDUploadResolver.mIsUseTTnetDNS == 1) goto L24;
        L12:
            boolean r101 = false;
        L13:
            if (r101 == false) goto L22;
        L18:
            if (r100 == null) goto L20;
            String r102 = r100.getHostAddress();
            BDUploadResolver.access$102(this.mResolver, new String[1]);
            BDUploadResolver.access$100(this.mResolver)[0] = r102;
            HostInfo r103 = new HostInfo();
            r103.time = System.currentTimeMillis();
            r103.f456075ip = r102;
            BDUploadResolver.putHostInfo(this.mHostName, r103);
            r103.time = System.currentTimeMillis();
            BDUploadResolver.access$202(this.mResolver, true);
            return;
        L20:
            BDUploadResolver.access$202(this.mResolver, true);
            return;
        L22:
            r100 = InetAddress.getByName(this.mHostName);     // Catch: UnknownHostException -> L16
        L16:
            e = move-exception;
            e.printStackTrace();
            BDUploadResolver.access$002(this.mResolver, e.getMessage());
            goto L18
        L24:
            List<InetAddress> r104 = TTNetWrapper.dnsLookup(this.mHostName);     // Catch: Throwable -> L10
            if (r104 == null) goto L12;
            if (ListProtector.get(r104, 0) == null) goto L12;
            r100 = (InetAddress) ListProtector.get(r104, 0);     // Catch: Throwable -> L10
            r101 = true;
        L10:
            th = move-exception;
            th.printStackTrace();
            goto L12
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_bduploader_BDUploadResolver$ParserHost_com_larus_apm_impl_protector_RunnableLancet_run(ParserHost r100) {
            r100.com_ss_bduploader_BDUploadResolver$ParserHost__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public ParserHost(BDUploadResolver r100, String r101) {
            this.mResolver = r100;
            this.mHostName = r101;
        }
    }

    private native void _notifyParserResult(String r100, String r101, long r102, String r103);

    static {
        mCacheHosts = new Hashtable();
        mEnableThreadPool = 1;
    }

    public void freeAddress() {
        if (this.mUseDNSType != 1) goto L17;
        Future r100 = this.mFuture;
        if (r100 != null) goto L23;
    L10:
        Thread r101 = this.mThread;
        if (r101 == null) goto L17;
        r101.interrupt();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L23:
        r100.cancel(true);     // Catch: Exception -> L8
        this.mFuture = null;     // Catch: Exception -> L8
        BDUploadLog.d(TAG, "----cancel parser thread");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    L17:
        if (this.mUseDNSType != 2) goto L29;
        BDUploadDNSParser.getInstance().removeHost(this.mHostName, this);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public String getAddress() {
        if (this.mRet == true) goto L5;
    L9:
        return null;
    L5:
        if (this.mIPStr == null) goto L9;
        if (this.mIPStr[0] == null) goto L9;
        return this.mIPStr[0];
    }

    public int isSuccess() {
        if (this.mRet == true) goto L5;
        return 0;
    L5:
        if (this.mIPStr != null) goto L7;
    L9:
        return -1;
    L7:
        if (this.mIPStr[0] == null) goto L9;
        return 1;
    }

    public BDUploadResolver() {
        this.mRet = false;
        this.mThread = null;
        this.mFuture = null;
        this.mUseDNSType = mDNSVersion;
    }

    public static /* synthetic */ String[] access$100(BDUploadResolver r100) {
        return r100.mIPStr;
    }

    private void getAddressInfoVersion_1(String r100) {
        this.mHostName = r100;
        if (r100 != null) goto L5;
    L28:
        this.mRet = true;
        return;
    L5:
        if (r100.length() < 1) goto L28;
        if ("".equals(r100) == true) goto L28;
        if (isIP(this.mHostName) == false) goto L11;
        this.mIPStr = new String[1];
        this.mIPStr[0] = this.mHostName;
        this.mRet = true;
        return;
    L11:
        Hashtable<String, HostInfo> r101 = mCacheHosts;
        HostInfo r102 = r101.get(r100);
        this.mHostInfo = r102;
        if (r102 != null) goto L14;
    L31:
    L26:
        e = move-exception;
        this.mRet = true;
        this.mError = e.getMessage();
        return;
    L22:
        if (mEnableThreadPool <= 0) goto L24;
        BDUploadLog.d(TAG, "----enable dns parser thread pool");     // Catch: Exception -> L26
        this.mFuture = BDUploadThreadPool.addExecuteTask(new ParserHost(this, this.mHostName));     // Catch: Exception -> L26
    L30:
        return;
    L24:
        BDUploadLog.d(TAG, "----disable dns parser thread pool");     // Catch: Exception -> L26
        PthreadThreadV2 r103 = new PthreadThreadV2(new ParserHost(this, this.mHostName), TAG);     // Catch: Exception -> L26
        this.mThread = r103;     // Catch: Exception -> L26
        ThreadMethodProxy.start(r103);     // Catch: Exception -> L26
        goto L30
    L14:
        if (r102.f456075ip != null) goto L16;
    L19:
        r101.remove(r100);
        this.mHostInfo = null;
        goto L31
    L16:
        if ((System.currentTimeMillis() - this.mHostInfo.time) >= HOST_MAX_CACHE_TIME) goto L19;
        this.mIPStr = new String[1];
        this.mIPStr[0] = this.mHostInfo.f456075ip;
        this.mRet = true;
    }

    private void getAddressInfoVersion_2(String r110) {
        BDUploadLog.d(TAG, "----add host to parser");
        this.mHostName = r110;
        BDUploadDNSInfo r100 = IPCache.getInstance().get(r110);
        if (r100 == null) goto L15;
        if (r100.mIpList == null) goto L15;
        long r101 = System.currentTimeMillis();
        BDUploadLog.d(TAG, String.format("get result from cache expiredT:%d curT:%d ", new Object[]{Long.valueOf(r100.mExpiredTime), Long.valueOf(r101)}));
        if (r100.mExpiredTime > r101) goto L9;
        BDUploadLog.d(TAG, String.format("has expired try call parse:", new Object[0]));
        BDUploadDNSParser.getInstance().addHost(r110, null);
    L9:
        String[] r102 = r100.mIpList.split(",");
        if (r102 == null) goto L15;
        if (r102.length <= 0) goto L15;
        this.mIPStr = new String[1];
        this.mIPStr[0] = r102[0];
        this.mRet = true;
        BDUploadLog.d(TAG, String.format("get result from cache suc, ip:%s ", new Object[]{r102[0]}));
    L15:
        if (this.mRet == true) goto L18;
        BDUploadLog.d(TAG, "****add host to parser");
        BDUploadDNSParser.getInstance().addHost(r110, this);
        return;
    }

    public static final boolean isIP(String r100) {
    L16:
        e = move-exception;
        e.printStackTrace();
        return false;
    L4:
        if (r100.length() < 7) goto L10;
        if (r100.length() > 15) goto L10;
        return PatternProtector.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(r100).find();
    L10:
        if (r100.charAt(0) == '[') goto L13;
        return false;
    L13:
        if (r100.charAt(r100.length() - 1) != ']') goto L21;
        return true;
    L21:
        return false;
    }

    public static void setEnableDNSParserThreadPool(int r100) {
        mEnableThreadPool = r100;
    }

    public static void setEnableTTNetDNS(int r100) {
        mIsUseTTnetDNS = r100;
    }

    public void getAddressInfo(String r100) {
        int r101 = this.mUseDNSType;
        if (r101 != 1) goto L5;
        getAddressInfoVersion_1(r100);
        return;
    L5:
        if (r101 == 2) goto L7;
        getAddressInfoVersion_1(r100);
        return;
    L7:
        getAddressInfoVersion_2(r100);
    }

    public static /* synthetic */ String access$002(BDUploadResolver r100, String r101) {
        r100.mError = r101;
        return r101;
    }

    public static /* synthetic */ String[] access$102(BDUploadResolver r100, String[] r101) {
        r100.mIPStr = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(BDUploadResolver r100, boolean r101) {
        r100.mRet = r101;
        return r101;
    }

    public static synchronized void putHostInfo(String r110, HostInfo r111) {
        monitor-enter(BDUploadResolver.class);
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L22
        Hashtable<String, HostInfo> r101 = mCacheHosts;     // Catch: Throwable -> L22
        Object r102 = null;
        if (r101.size() <= 128) goto L15;
        Iterator<Map.Entry<String, HostInfo>> r103 = r101.entrySet().iterator();     // Catch: Throwable -> L22
        Object r104 = null;
    L8:
        if (r103.hasNext() == false) goto L14;
        HostInfo r105 = r103.next().getValue();     // Catch: Throwable -> L22
        r102 = (String) r103.next().getKey();     // Catch: Throwable -> L22
        if (r105 == null) goto L8;
        long r106 = r105.time;     // Catch: Throwable -> L22
        if (r106 >= r100) goto L8;
        r104 = r105;
        r100 = r106;
        goto L8
    L14:
        Object r107 = r102;
        r102 = r104;
    L16:
        if (r102 == null) goto L19;
        if (r107 == null) goto L19;
        mCacheHosts.remove(r107);     // Catch: Throwable -> L22
    L19:
        mCacheHosts.put(r110, r111);     // Catch: Throwable -> L22
        monitor-exit(BDUploadResolver.class);
        return;
    L15:
        r107 = null;
    L22:
        th = move-exception;
        throw th;
    }

    public static void setDNSServer(String r100, String r101) {
        HTTPDNS.setDNSServerHost(r100, r101);
    }

    public static void setDNSType(int r100, int r101, int r102, int r103, int r104) {
        if (r100 == 1) goto L6;
        if (r100 == 2) goto L6;
        return;
    L6:
        BDUploadDNSParser.setIntValue(0, r101);
        BDUploadDNSParser.setIntValue(1, r102);
        BDUploadDNSParser.setIntValue(3, r103);
        BDUploadDNSParser.setIntValue(2, r104);
        mDNSVersion = r100;
    }

    @Override // com.ss.bduploader.net.BDUploadDNSParserListener
    public void onCompletion(int r100, String r101, String r102, long r103, String r104) {
        BDUploadLog.d(TAG, String.format("notify result host:%s iplist:%s ", new Object[]{r101, r102}));
        if (this.mRet == true) goto L15;
        if (r102 == null) goto L13;
        if (r101 == null) goto L13;
        if (r101.equals(this.mHostName) == false) goto L13;
        String[] r105 = r102.split(",");
        if (r105 == null) goto L13;
        if (r105.length <= 0) goto L13;
        this.mIPStr = new String[1];
        this.mIPStr[0] = r105[0];
    L13:
        this.mRet = true;
        return;
    }
}
