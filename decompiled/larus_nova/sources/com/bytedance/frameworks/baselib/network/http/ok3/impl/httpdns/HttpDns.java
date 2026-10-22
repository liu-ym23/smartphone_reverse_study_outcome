package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3AppMonitor;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.HttpDnsUtil;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.IPAddressUtils;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ttnet.BuildConfig;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class HttpDns implements WeakHandler.IHandler {
    private static final int CORE_POOL_SIZE = 6;
    public static final String HTTPDNS_HARDCODEIP_SP_KEY = "httpdns_hardcodeips";
    public static final String HTTPDNS_HARDCODEIP_SP_NAME = "dispatchersdk_httpdns_hardcodeips";
    private static final String MSG_CALLBACK_DNSRESULT_JOB_KEY = "callback_dnsresult_job_key";
    public static final String MSG_CALLBACK_DNSRESULT_KEY = "callback_dnsresult_key";
    private static final int MSG_CALLBACK_DNS_RESULT = 1;
    private static final String MSG_DNS_TIMEOUT_JOB_KEY = "dns_timeout_job_key";
    private static final int MSG_HTTPDNS_PREFER_TIMEOUT = 2;
    private static final String MSG_HTTPDNS_PREFER_TIMEOUT_JOB_KEY = "httpdns_timeout_job_key";
    private static final int MSG_HTTPDNS_REQUEST_TIMEOUT = 4;
    private static final int MSG_LOAD_LOCAL_HARDCODEIPS = 5;
    private static final int MSG_LOCALDNS_REQUEST_TIMEOUT = 3;
    private static final int MSG_ON_NETWORK_CHANGED = 6;
    private static final int MSG_ON_RESUME = 7;
    private static String TAG;
    private static WeakHandler mHttpDnsHandler;
    private static HandlerThread mHttpDnsHandlerThread;
    private static volatile HttpDns mInstance;
    private static String mSdkVersion;
    private static ExecutorService mThreadPool;
    private AtomicInteger mEnableCompareLocalDnsHttpDns;
    private AtomicBoolean mEnableHttpDns;
    private ConcurrentMap<String, CopyOnWriteArrayList<String>> mHardCodeIps;
    private boolean mHasSetHttpDnsDepend;
    private final HostResolveManager mHostResolveManager;
    private volatile IHttpDnsDepend mHttpDnsDepend;
    private volatile String mHttpDnsDomain;
    private AtomicInteger mHttpDnsPreferInterval;
    private AtomicInteger mHttpDnsRefreshStaleCacheInterval;
    private AtomicInteger mHttpDnsTimeout;
    private ConcurrentSkipListSet<String> mHttpdnsDomainHardCodeIps;
    private AtomicBoolean mIsHttpDnsPrefer;
    private AtomicInteger mLocalDnsCacheTTL;
    private AtomicInteger mLocalDnsTimeout;
    private Handler mMainThreadHandler;
    private final OkHttp3AppMonitor mOkHttp3AppMonitor;
    private ConcurrentSkipListSet<String> mPreResolveHosts;

    static {
        TAG = "HttpDns";
        mThreadPool = PThreadExecutorsUtils.newFixedThreadPool(6, new DefaultThreadFactory("tpdns/HttpDns"));
    }

    public static HttpDns getService() {
        if (mInstance != null) goto L15;
        monitor-enter(HttpDns.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new HttpDns();     // Catch: Throwable -> L11
    L9:
        monitor-exit(HttpDns.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public void submitIpv6Detect() {
        mThreadPool.submit(new Ipv6DetectCall());     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private HttpDns() {
        this.mEnableHttpDns = new AtomicBoolean(true);
        this.mIsHttpDnsPrefer = new AtomicBoolean(false);
        this.mHttpdnsDomainHardCodeIps = new ConcurrentSkipListSet();
        this.mHardCodeIps = new ConcurrentHashMap();
        this.mPreResolveHosts = new ConcurrentSkipListSet();
        this.mLocalDnsCacheTTL = new AtomicInteger(30);
        this.mHttpDnsPreferInterval = new AtomicInteger(2000);
        this.mHttpDnsRefreshStaleCacheInterval = new AtomicInteger(60);
        this.mEnableCompareLocalDnsHttpDns = new AtomicInteger(0);
        this.mHttpDnsTimeout = new AtomicInteger(5);
        this.mLocalDnsTimeout = new AtomicInteger(5);
        this.mOkHttp3AppMonitor = new OkHttp3AppMonitor();
        this.mHasSetHttpDnsDepend = false;
        final Looper r100 = Looper.getMainLooper();
        this.mMainThreadHandler = new AnonymousClass1(this, r100);
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "HttpDns constructor");
    L5:
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("TTOK-HTTPDNS");
        mHttpDnsHandlerThread = r101;
        ThreadMethodProxy.start(r101);
        mHttpDnsHandler = new WeakHandler(mHttpDnsHandlerThread.getLooper(), this);
        mSdkVersion = BuildConfig.VERSION_NAME;
        this.mHostResolveManager = new HostResolveManager(mHttpDnsHandler);
    }

    public void onNetworkChanged() {
        Message r100 = Message.obtain();
        r100.obj = this;
        r100.what = 6;
        mHttpDnsHandler.sendMessage(r100);
    }

    public void onResume() {
        Message r100 = Message.obtain();
        r100.obj = this;
        r100.what = 7;
        mHttpDnsHandler.sendMessage(r100);
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public IHttpDnsDepend getHttpDnsDepend() {
        return this.mHttpDnsDepend;
    }

    public String getHttpDnsDomain() {
        return this.mHttpDnsDomain;
    }

    public ConcurrentSkipListSet<String> getHttpDnsDomainHardCodeIps() {
        return this.mHttpdnsDomainHardCodeIps;
    }

    public HandlerThread getHttpDnsHandlerThread() {
        return mHttpDnsHandlerThread;
    }

    public AtomicInteger getHttpDnsPreferInterval() {
        return this.mHttpDnsPreferInterval;
    }

    public AtomicInteger getHttpDnsRefreshStaleCacheInterval() {
        return this.mHttpDnsRefreshStaleCacheInterval;
    }

    public AtomicInteger getLocalDnsCacheTTL() {
        return this.mLocalDnsCacheTTL;
    }

    public AtomicBoolean isHttpDnsPrefer() {
        return this.mIsHttpDnsPrefer;
    }

    private DnsResult getHardCodeIpResult(String r100) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "try to look up hardcode ips");
    L6:
        if (this.mHardCodeIps.containsKey(r100) == false) goto L21;
        DnsResult r101 = new DnsResult();
        Iterator<String> r102 = this.mHardCodeIps.get(r100).iterator();
    L9:
        if (r102.hasNext() == false) goto L19;
        String r103 = r102.next();
        if (IPAddressUtils.isValidIpv6(r103) == true) goto L12;
        if (IPAddressUtils.isValidIpv4(r103) == true) goto L15;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "find a invalid hardcode ip: " + r103);
        goto L9
    L15:
        r101.ipv4List.add(r103);
        goto L9
    L12:
        r101.ipv6List.add(r103);
        goto L9
    L19:
        r101.source = DnsResult.Source.HARDCODE_IPS;
        return r101;
    L21:
        return null;
    }

    private boolean invalidConfigure(String r100) {
        if (this.mHasSetHttpDnsDepend == true) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "you have not set httpdns depend");
    L7:
        return true;
    L9:
        if (this.mEnableHttpDns.get() == true) goto L15;
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "httpdns was unabled by tnc");
    L13:
        return true;
    L15:
        if (HttpDnsUtil.isValidHost(r100) == true) goto L21;
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "illegal host");
    L19:
        return true;
    L21:
        if (IPAddressUtils.isValidIpv4(r100) == true) goto L28;
        if (IPAddressUtils.isValidIpv6(r100) == true) goto L28;
        return false;
    L28:
        if (Logger.debug() == false) goto L30;
        Logger.d(TAG, "host is ipaddress");
    L30:
        return true;
    }

    private void submitHttpDnsTaskForLocalDnsPreferReq(HostResolveJob r100) {
        ArrayList r101 = new ArrayList();
        r101.add(r100.getHost());
        submitHttpDnsResolve(r101, DnsRecord.CacheStaleReason.CACHE_UNSET, false);
        Message r102 = Message.obtain();
        r102.what = 4;
        r102.obj = this;
        Bundle r103 = new Bundle();
        r103.putSerializable(MSG_DNS_TIMEOUT_JOB_KEY, r100);
        r102.setData(r103);
        mHttpDnsHandler.sendMessageDelayed(r102, ((long) this.mHttpDnsTimeout.get()) * 1000);
    }

    private synchronized Future<Void> submitLocalDnsResolve(String r100) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.mHostResolveManager.isLocalDnsResolving(r100) == false) goto L13;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "localdns is resolving for host : " + r100);     // Catch: Throwable -> L22
    L9:
        Future<Void> r101 = this.mHostResolveManager.getLocalDnsResolvingFuture(r100);     // Catch: Throwable -> L22
        monitor-exit(this);
        return r101;
    L13:
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "submit localdns resolve host : " + r100);     // Catch: Throwable -> L22
    L15:
        Future<Void> r102 = null;
        r102 = mThreadPool.submit(new LocalDnsResolveCall(r100, this.mHostResolveManager, mHttpDnsHandler));     // Catch: RejectedExecutionException -> L18 Throwable -> L22
        this.mHostResolveManager.addLocalDnsResolvingFuture(r100, r102);     // Catch: RejectedExecutionException -> L18 Throwable -> L22
    L20:
        monitor-exit(this);
        return r102;
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L20
    }

    public void addHttpDnsStaleCacheHost(String r100) {
        this.mHostResolveManager.addHttpDnsStaleCacheHost(r100);
    }

    public void batchRefreshHttpDnsStaleCache(List<String> r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "batchRefreshHttpDnsStaleCache for host " + r100);
    L5:
        submitHttpDnsResolve(r100, DnsRecord.CacheStaleReason.REFRESH_BATCH, false);
    }

    public synchronized void doHttpDnsPreload(DnsRecord.CacheStaleReason r100) {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L4:
        if (this.mHttpDnsDepend != null) goto L6;
    L34:
        monitor-exit(this);
        return;
    L6:
        if (i.d(this.mHttpDnsDepend.getContext()) == false) goto L34;
        ConcurrentSkipListSet<String> r101 = this.mPreResolveHosts;     // Catch: Throwable -> L36
        if (r101 == null) goto L34;
        if (r101.size() == 0) goto L34;
        if (this.mPreResolveHosts.size() > 10) goto L34;
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "do httpdns preload");     // Catch: Throwable -> L36
    L17:
        Iterator<String> r102 = this.mPreResolveHosts.iterator();     // Catch: Throwable -> L36
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L36
    L19:
        if (r102.hasNext() == false) goto L25;
        String r104 = r102.next();     // Catch: Throwable -> L36
        if (this.mHostResolveManager.isHttpDnsResolving(r104) == true) goto L19;
        r103.add(r104);     // Catch: Throwable -> L36
        goto L19
    L25:
        if (r103.size() != 0) goto L29;
        monitor-exit(this);
        return;
    L29:
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "httpdns batch preload for : " + r103);     // Catch: Throwable -> L36
    L31:
        submitHttpDnsResolve(r103, r100, false);     // Catch: Throwable -> L36
        monitor-exit(this);
    }

    public DnsResult getHttpDnsResultForHostSyncBlock(String r100) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "getHttpDnsResultForHostSyncBlock for host : " + r100);
    L6:
        if (invalidConfigure(r100) == false) goto L9;
        return null;
    L9:
        boolean r101 = r100.equals(this.mHttpDnsDomain);
        if (this.mIsHttpDnsPrefer.get() == false) goto L16;
        if (r101 == true) goto L16;
        DnsResult r102 = lookupHttpDnsCache(r100, false);
        if (r102 == null) goto L15;
        return r102;
    L15:
        ArrayList r103 = new ArrayList();
        ListProtector.add(r103, 0, Boolean.FALSE);
        DnsResult r104 = getDnsResultInHttpDnsPreferTime(submitHttpDnsAndLocalDnsResolve(r100, r103, true), r100, ((Boolean) ListProtector.get(r103, 0)).booleanValue());
    L39:
        if (r104 == null) goto L41;
        return r104;
    L41:
        return getHardCodeIpResult(r100);
    L16:
        DnsResult r105 = lookupLocalDnsCache(r100, false);
        if (r105 == null) goto L20;
        return r105;
    L20:
        if (this.mHostResolveManager.isLocalDnsResolving(r100) == false) goto L22;
        Future<Void> r106 = this.mHostResolveManager.getLocalDnsResolvingFuture(r100);
    L23:
        if (r106 != null) goto L29;
        DnsResult r107 = getHttpDnsResultForLocalDnsPreferRequest(r100, r101);
        if (r107 == null) goto L27;
        return r107;
    L27:
        return getHardCodeIpResult(r100);
    L29:
        if (r106.isDone() == false) goto L42;
        DnsResult r108 = lookupLocalDnsCache(r100, true);
        if (r108 != null) goto L33;
        r104 = getHttpDnsResultForLocalDnsPreferRequest(r100, r101);
    L33:
        r104 = r108;
        goto L39
    L42:
        r106.get(((long) this.mLocalDnsTimeout.get()) * 1000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L38
        r108 = lookupLocalDnsCache(r100, true);     // Catch: Exception -> L38
        if (r108 != null) goto L33;
        r104 = getHttpDnsResultForLocalDnsPreferRequest(r100, r101);     // Catch: Exception -> L38
    L38:
        r104 = getHttpDnsResultForLocalDnsPreferRequest(r100, r101);
        goto L39
    L22:
        r106 = submitLocalDnsResolve(r100);
        goto L23
    }

    public DnsResult getHttpDnsResultForHostSyncNonBlock(String r100) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "getHttpDnsResultForHostSyncNonBlock for host : " + r100);
    L6:
        if (invalidConfigure(r100) == false) goto L10;
        return null;
    L10:
        if (isHttpDnsPrefer().get() == false) goto L27;
        DnsResult r101 = lookupHttpDnsCache(r100, false);
        if (r101 == null) goto L15;
        return r101;
    L15:
        if (this.mHostResolveManager.isHttpDnsResolving(r100) == true) goto L26;
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L18:
        if (this.mHostResolveManager.isHttpDnsResolving(r100) == true) goto L20;
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L22
        r102.add(r100);     // Catch: Throwable -> L22
        submitHttpDnsResolve(r102, DnsRecord.CacheStaleReason.CACHE_UNSET, false);     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);     // Catch: Throwable -> L22
    L26:
        return lookupLocalDnsCache(r100, false);
    L27:
        DnsResult r103 = lookupLocalDnsCache(r100, false);
        if (r103 == null) goto L31;
        return r103;
    L31:
        if (this.mHostResolveManager.isLocalDnsResolving(r100) == true) goto L42;
        monitor-enter(this);
    L38:
        th = move-exception;
        throw th;
    L34:
        if (this.mHostResolveManager.isLocalDnsResolving(r100) == true) goto L36;
        submitLocalDnsResolve(r100);     // Catch: Throwable -> L38
    L36:
        monitor-exit(this);     // Catch: Throwable -> L38
    L42:
        return lookupHttpDnsCache(r100, false);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r110) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "httpdns handler handle msg in " + ThreadMethodProxy.currentThread().getName());
    L5:
        if (r110 == null) goto L252;
        Object r100 = r110.obj;
        if ((r100 instanceof HttpDns) == false) goto L9;
    L230:
    L225:
        th = move-exception;
        th.printStackTrace();
        return;
    L19:
        if ((r100 instanceof HttpDns) == false) goto L38;
        if (r110.what != 2) goto L38;
        if (Logger.debug() == false) goto L25;
        Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT");     // Catch: Throwable -> L225
    L25:
        HostResolveJob r111 = (HostResolveJob) r110.getData().getSerializable(MSG_HTTPDNS_PREFER_TIMEOUT_JOB_KEY);     // Catch: Throwable -> L225
        if (r111 != null) goto L32;
        if (Logger.debug() == false) goto L246;
        Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L225
        return;
    L246:
        return;
    L32:
        if (this.mHostResolveManager.shouldHttpDnsTimeoutCallback(r111) == true) goto L34;
        return;
    L34:
        if (Logger.debug() == false) goto L36;
        Logger.d(TAG, "httpdns request not return in httpdns prefer time for host : " + r111.getHost());     // Catch: Throwable -> L225
    L36:
        callbackDnsResultInMainthread(r111, lookupLocalDnsCache(r111.getHost(), r111.isLocalDnsExpired()));     // Catch: Throwable -> L225
        this.mHostResolveManager.removeHttpDnsJob(r111);     // Catch: Throwable -> L225
        return;
    L38:
        if ((r100 instanceof HttpDnsResolveCall) == true) goto L40;
    L70:
        int r112 = 0;
        if ((r100 instanceof LocalDnsResolveCall) == false) goto L104;
        if (r110.what != 1) goto L104;
        if (Logger.debug() == false) goto L77;
        Logger.d(TAG, "MSG_LOCALDNS_COMPLETED");     // Catch: Throwable -> L225
    L77:
        String r113 = r110.getData().getString(LocalDnsResolveCall.MSG_LOCALDNS_COMPLETED_HOST_KEY);     // Catch: Throwable -> L225
        if (r113 != null) goto L84;
        if (Logger.debug() == false) goto L248;
        Logger.d(TAG, "MSG_HTTPDNS_COMPLETED host is null");     // Catch: Throwable -> L225
        return;
    L248:
        return;
    L84:
        if (this.mHostResolveManager.shouldLocalDnsCallback(r113) == true) goto L86;
        return;
    L86:
        if (Logger.debug() == false) goto L88;
        Logger.d(TAG, "localdns returned in localdns timeout for host : ".concat(r113));     // Catch: Throwable -> L225
    L88:
        Iterator<HostResolveJob> r101 = this.mHostResolveManager.getLocalDnsJobs(r113).iterator();     // Catch: Throwable -> L225
    L90:
        if (r101.hasNext() == false) goto L277;
        HostResolveJob r102 = r101.next();     // Catch: Throwable -> L225
        DnsResult r103 = lookupLocalDnsCache(r113, true);     // Catch: Throwable -> L225
        if (r103 != null) goto L98;
        DnsResult r104 = lookupHttpDnsCache(r113, false);     // Catch: Throwable -> L225
        if (r104 != null) goto L96;
        submitHttpDnsTaskForLocalDnsPreferReq(r102);     // Catch: Throwable -> L225
        this.mHostResolveManager.addHttpDnsJob(r102.getHost(), r102);     // Catch: Throwable -> L225
    L101:
        this.mHostResolveManager.removeLocalDnsJob(r102);     // Catch: Throwable -> L225
        goto L90
    L96:
        callbackDnsResultInMainthread(r102, r104);     // Catch: Throwable -> L225
        goto L101
    L98:
        if (Logger.debug() == false) goto L100;
        Logger.d(TAG, "localdns request is returned in timeout for " + r113);     // Catch: Throwable -> L225
    L100:
        callbackDnsResultInMainthread(r102, r103);     // Catch: Throwable -> L225
        goto L101
    L277:
        return;
    L104:
        if ((r100 instanceof HttpDns) == false) goto L130;
        if (r110.what != 3) goto L130;
        if (Logger.debug() == false) goto L110;
        Logger.d(TAG, "MSG_LOCALDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L225
    L110:
        HostResolveJob r114 = (HostResolveJob) r110.getData().getSerializable(MSG_DNS_TIMEOUT_JOB_KEY);     // Catch: Throwable -> L225
        if (r114 != null) goto L117;
        if (Logger.debug() == false) goto L249;
        Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L225
        return;
    L249:
        return;
    L117:
        if (this.mHostResolveManager.shouldLocalDnsTimeoutCallback(r114) == true) goto L119;
        return;
    L119:
        if (Logger.debug() == false) goto L121;
        Logger.d(TAG, "local request not return in localdns timeout for host : " + r114.getHost());     // Catch: Throwable -> L225
    L121:
        DnsResult r105 = lookupHttpDnsCache(r114.getHost(), false);     // Catch: Throwable -> L225
        if (r105 == null) goto L125;
        callbackDnsResultInMainthread(r114, r105);     // Catch: Throwable -> L225
    L128:
        this.mHostResolveManager.removeLocalDnsJob(r114);     // Catch: Throwable -> L225
        return;
    L125:
        if (this.mHostResolveManager.isHttpDnsResolving(r114.getHost()) == true) goto L127;
        submitHttpDnsTaskForLocalDnsPreferReq(r114);     // Catch: Throwable -> L225
    L127:
        this.mHostResolveManager.addHttpDnsJob(r114.getHost(), r114);     // Catch: Throwable -> L225
    L130:
        if ((r100 instanceof HttpDns) == false) goto L146;
        if (r110.what != 4) goto L146;
        if (Logger.debug() == false) goto L136;
        Logger.d(TAG, "MSG_HTTPDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L225
    L136:
        HostResolveJob r115 = (HostResolveJob) r110.getData().getSerializable(MSG_DNS_TIMEOUT_JOB_KEY);     // Catch: Throwable -> L225
        if (r115 != null) goto L143;
        if (Logger.debug() == false) goto L250;
        Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L225
        return;
    L250:
        return;
    L143:
        if (this.mHostResolveManager.shouldHttpDnsTimeoutCallback(r115) == false) goto L258;
        callbackDnsResultInMainthread(r115, null);     // Catch: Throwable -> L225
        this.mHostResolveManager.removeHttpDnsJob(r115);     // Catch: Throwable -> L225
        return;
    L258:
        return;
    L146:
        if ((r100 instanceof HttpDns) == false) goto L171;
        if (r110.what != 5) goto L171;
        if (Logger.debug() == false) goto L152;
        Logger.d(TAG, "MSG_LOAD_LOCAL_HARDCODEIPS");     // Catch: Throwable -> L225
    L152:
        String r116 = this.mHttpDnsDepend.getContext().getSharedPreferences(HTTPDNS_HARDCODEIP_SP_NAME, 0).getString(HTTPDNS_HARDCODEIP_SP_KEY, "");     // Catch: Throwable -> L225
        if (TextUtils.isEmpty(r116) == true) goto L166;
        this.mHttpdnsDomainHardCodeIps.clear();     // Catch: Throwable -> L225
        JSONArray r106 = new JSONArray(r116);     // Catch: JSONException -> L162 Throwable -> L225
    L157:
        if (r112 >= r106.length()) goto L278;
        String r117 = r106.optString(r112);     // Catch: JSONException -> L162 Throwable -> L225
        if (TextUtils.isEmpty(r117) == true) goto L161;
        this.mHttpdnsDomainHardCodeIps.add(r117);     // Catch: JSONException -> L162 Throwable -> L225
    L161:
        r112 = r112 + 1;
        goto L157
    L278:
        return;
    L163:
        if (Logger.debug() == false) goto L260;
        Logger.d(TAG, "local httpdns hardcode ips not exists, use default");     // Catch: Throwable -> L225
        return;
    L260:
        return;
    L166:
        if (this.mHttpDnsDepend.getHardCodeIps() != null) goto L168;
        return;
    L168:
        if (this.mHttpdnsDomainHardCodeIps.size() != 0) goto L263;
        this.mHttpdnsDomainHardCodeIps.addAll(Arrays.asList(this.mHttpDnsDepend.getHardCodeIps()));     // Catch: Throwable -> L225
        return;
    L263:
        return;
    L171:
        if ((r100 instanceof HttpDns) == false) goto L179;
        if (r110.what != 6) goto L179;
        if (Logger.debug() == false) goto L177;
        Logger.d(TAG, "network changed");     // Catch: Throwable -> L225
    L177:
        this.mHostResolveManager.onNetworkChanged(getService().getHttpDnsDepend().getContext());     // Catch: Throwable -> L225
        return;
    L179:
        if ((r100 instanceof HttpDns) == false) goto L187;
        if (r110.what != 7) goto L187;
        if (Logger.debug() == false) goto L185;
        Logger.d(TAG, "activity resume, detect ipv6 reachable");     // Catch: Throwable -> L225
    L185:
        submitIpv6Detect();     // Catch: Throwable -> L225
        return;
    L187:
        if ((r100 instanceof DnsRecord) == false) goto L214;
        String r107 = r110.getData().getString(DnsRecord.MSG_DNSRECORD_HOST);     // Catch: Throwable -> L225
        if (TextUtils.isEmpty(r107) == false) goto L195;
        if (Logger.debug() == false) goto L251;
        Logger.d(TAG, "DnsRecord refresh host is null");     // Catch: Throwable -> L225
        return;
    L251:
        return;
    L195:
        switch(r110.what) {
            case 10: goto L210;
            case 11: goto L206;
            case 12: goto L202;
            case 13: goto L198;
            default: goto L267;
        };     // Catch: Throwable -> L225
    L267:
        return;
    L198:
        if (Logger.debug() == false) goto L200;
        Logger.d(TAG, "remove httpdns cache for host : " + r107);     // Catch: Throwable -> L225
    L200:
        getService().removeHttpDnsCache(r107);     // Catch: Throwable -> L225
        return;
    L202:
        if (Logger.debug() == false) goto L204;
        Logger.d(TAG, "add host : " + r107 + " to stale cache host list");     // Catch: Throwable -> L225
    L204:
        getService().addHttpDnsStaleCacheHost(r107);     // Catch: Throwable -> L225
        return;
    L206:
        if (Logger.debug() == false) goto L208;
        Logger.d(TAG, "remove localdns cache for host : " + r107);     // Catch: Throwable -> L225
    L208:
        getService().removeLocalDnsStaleCache(r107);     // Catch: Throwable -> L225
        return;
    L210:
        if (Logger.debug() == false) goto L212;
        Logger.d(TAG, "refresh httpdns cache for host : " + r107);     // Catch: Throwable -> L225
    L212:
        getService().refreshHttpDnsCache(r107);     // Catch: Throwable -> L225
        return;
    L214:
        if ((r100 instanceof HostResolveManager) == false) goto L222;
        if (r110.what != 20) goto L222;
        if (Logger.debug() == false) goto L220;
        Logger.d(TAG, "reset httpdns domain failed count");     // Catch: Throwable -> L225
    L220:
        this.mHostResolveManager.resetHttpDnsDomainFailedCnt();     // Catch: Throwable -> L225
        return;
    L222:
        if (Logger.debug() == false) goto L273;
        Logger.d(TAG, "HTTPDNS-CollectResult handler thread receive a unknown message : " + r110);     // Catch: Throwable -> L225
        return;
    L273:
        return;
    L40:
        if (r110.what != 3) goto L70;
        if (Logger.debug() == false) goto L44;
        Logger.d(TAG, "MSG_HTTPDNS_COMPLETED");     // Catch: Throwable -> L225
    L44:
        ArrayList<String> r118 = r110.getData().getStringArrayList(HttpDnsResolveCall.MSG_HTTPDDNS_COMPLETED_HOSTS_KEY);     // Catch: Throwable -> L225
        if (r118 == null) goto L47;
        Iterator<String> r108 = r118.iterator();     // Catch: Throwable -> L225
    L52:
        if (r108.hasNext() == false) goto L276;
        String r109 = r108.next();     // Catch: Throwable -> L225
        if (this.mHostResolveManager.shouldHttpDnsCallback(r109) == false) goto L52;
        if (Logger.debug() == false) goto L59;
        Logger.d(TAG, "httpdns returned in httpdns prefer time for host : " + r118);     // Catch: Throwable -> L225
    L59:
        Iterator<HostResolveJob> r119 = this.mHostResolveManager.getHttpDnsJobs(r109).iterator();     // Catch: Throwable -> L225
    L61:
        if (r119.hasNext() == false) goto L52;
        HostResolveJob r120 = r119.next();     // Catch: Throwable -> L225
        DnsResult r121 = lookupHttpDnsCache(r109, true);     // Catch: Throwable -> L225
        if (getService().isHttpDnsPrefer().get() == false) goto L67;
        if (r121 != null) goto L67;
        r121 = lookupLocalDnsCache(r109, r120.isLocalDnsExpired());     // Catch: Throwable -> L225
    L67:
        if (Logger.debug() == false) goto L69;
        Logger.d(TAG, "httpdns request is returned in prefer time for " + r109);     // Catch: Throwable -> L225
    L69:
        callbackDnsResultInMainthread(r120, r121);     // Catch: Throwable -> L225
        this.mHostResolveManager.removeHttpDnsJob(r120);     // Catch: Throwable -> L225
        goto L61
    L276:
        return;
    L47:
        if (Logger.debug() == false) goto L247;
        Logger.d(TAG, "MSG_HTTPDNS_COMPLETED hostlist is null");     // Catch: Throwable -> L225
        return;
    L247:
        return;
    L9:
        if ((r100 instanceof HttpDnsResolveCall) == true) goto L230;
        if ((r100 instanceof LocalDnsResolveCall) == true) goto L230;
        if ((r100 instanceof DnsRecord) == true) goto L230;
        if ((r100 instanceof HostResolveManager) == true) goto L230;
        return;
    }

    public void onServerConfigChanged(JSONObject r100) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onServerConfigChanged");
    L6:
        if (this.mHttpDnsDepend == null) goto L65;
        if (r100 == null) goto L80;
        int r101 = r100.optInt("ttnet_http_dns_enabled", -1);
        boolean r102 = false;
        if (r101 < 0) goto L16;
        AtomicBoolean r103 = this.mEnableHttpDns;
        if (r101 != 1) goto L14;
        boolean r104 = true;
    L15:
        r103.set(r104);
        goto L16
    L14:
        r104 = false;
    L16:
        String r105 = r100.optString("ttnet_tt_http_dns_domain");
        if (TextUtils.isEmpty(r105) == true) goto L19;
        this.mHttpDnsDomain = r105;
    L19:
        JSONArray r106 = r100.optJSONArray("ttnet_tt_http_dns_preload_batch_host");
        if (r106 == null) goto L28;
        this.mPreResolveHosts.clear();
        int r107 = 0;
    L23:
        if (r107 >= r106.length()) goto L28;
        String r108 = r106.optString(r107);
        if (TextUtils.isEmpty(r108) == true) goto L27;
        this.mPreResolveHosts.add(r108);
    L27:
        r107 = r107 + 1;
    L28:
        int r109 = r100.optInt("localdns_cache_ttl", -1);
        if (r109 < 0) goto L31;
        this.mLocalDnsCacheTTL.set(r109);
    L31:
        int r110 = r100.optInt("httpdns_prefer_time_ms", -1);
        if (r110 < 0) goto L34;
        this.mHttpDnsPreferInterval.set(r110);
    L34:
        int r111 = r100.optInt("httpdns_stale_cache_interval", -1);
        if (r111 < 0) goto L37;
        this.mHttpDnsRefreshStaleCacheInterval.set(r111);
    L37:
        int r112 = r100.optInt("enable_compare_localdns_httpdns", -1);
        if (r112 < 0) goto L40;
        this.mEnableCompareLocalDnsHttpDns.set(r112);
    L40:
        int r113 = r100.optInt("ttnet_http_dns_prefer", -1);
        if (r113 < 0) goto L46;
        AtomicBoolean r114 = this.mIsHttpDnsPrefer;
        if (r113 != 1) goto L45;
        r102 = true;
    L45:
        r114.set(r102);
    L46:
        int r115 = r100.optInt("ttnet_http_dns_timeout", -1);
        if (r115 < 0) goto L49;
        this.mHttpDnsTimeout.set(r115);
    L49:
        int r116 = r100.optInt("ttnet_local_dns_time_out", -1);
        if (r116 < 0) goto L52;
        this.mLocalDnsTimeout.set(r116);
    L52:
        JSONObject r117 = r100.optJSONObject("ttnet_http_dns_addr");
        if (r117 == null) goto L79;
        this.mHardCodeIps.clear();
        Iterator<String> r118 = r117.keys();
    L56:
        if (r118.hasNext() == false) goto L81;
        String r119 = r118.next();
        String r120 = r117.optString(r119);
        if (TextUtils.isEmpty(r119) == true) goto L56;
        if (TextUtils.isEmpty(r120) == true) goto L56;
        String[] r121 = r120.split(",");
        if (r119.equals(this.mHttpDnsDomain) == true) goto L63;
        CopyOnWriteArrayList<String> r122 = new CopyOnWriteArrayList(Arrays.asList(r121));
        this.mHardCodeIps.put(r119, r122);
        goto L56
    L63:
        this.mHttpdnsDomainHardCodeIps.clear();
        this.mHttpdnsDomainHardCodeIps.addAll(Arrays.asList(r121));
        goto L56
    L81:
        return;
    L79:
        return;
    L80:
        return;
    }

    public void refreshHttpDnsCache(String r100) {
        if (HttpDnsUtil.isValidHost(r100) == true) goto L5;
        return;
    L5:
        if (this.mHostResolveManager.isHttpDnsResolving(r100) == false) goto L7;
        return;
    L7:
        if (this.mIsHttpDnsPrefer.get() == false) goto L12;
        ArrayList r101 = new ArrayList();
        r101.add(r100);
        submitHttpDnsResolve(r101, DnsRecord.CacheStaleReason.CACHE_STALE_EXPIRED, false);
        return;
    }

    public void removeHttpDnsCache(String r100) {
        if (HttpDnsUtil.isValidHost(r100) == true) goto L5;
        return;
    L5:
        if (this.mHostResolveManager.isHttpDnsResolving(r100) == true) goto L9;
        this.mHostResolveManager.removeHttpDnsCache(r100);
        return;
    }

    public void removeLocalDnsStaleCache(String r100) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "removeLocalDnsStaleCache");
    L6:
        if (HttpDnsUtil.isValidHost(r100) == false) goto L9;
        this.mHostResolveManager.removeLocalDnsCache(r100);
        return;
    }

    public void setHttpDnsDepend(IHttpDnsDepend r100) {
        if (this.mHasSetHttpDnsDepend == true) goto L5;
        if (r100 != null) goto L10;
    L33:
        this.mHttpDnsDepend = null;
        throw new IllegalArgumentException("you must set correct httpdns depend");
    L10:
        if (r100.getContext() == null) goto L33;
        if (TextUtils.isEmpty(r100.getHttpDnsDomain()) == true) goto L33;
        if (r100.getAppId() == null) goto L33;
        this.mHttpDnsDepend = r100;
        if (TextUtils.isEmpty(this.mHttpDnsDomain) == false) goto L18;
        this.mHttpDnsDomain = r100.getHttpDnsDomain();
    L18:
        this.mHasSetHttpDnsDepend = true;
        submitIpv6Detect();
        this.mOkHttp3AppMonitor.registerAppMonitorListener(r100.getContext());
        if (this.mPreResolveHosts.size() < 1) goto L21;
        doHttpDnsPreload(DnsRecord.CacheStaleReason.PRELOAD_BATCH);
    L31:
        Message r101 = Message.obtain();
        r101.what = 5;
        r101.obj = this;
        mHttpDnsHandler.sendMessage(r101);
        return;
    L21:
        if (this.mHttpDnsDepend.getPreloadDomains() == null) goto L28;
        if (this.mHttpDnsDepend.getPreloadDomains().length <= 0) goto L28;
        if (this.mHttpDnsDepend.getPreloadDomains().length > 10) goto L28;
        this.mPreResolveHosts.addAll(Arrays.asList(this.mHttpDnsDepend.getPreloadDomains()));
        doHttpDnsPreload(DnsRecord.CacheStaleReason.PRELOAD_BATCH);
    L28:
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "httpdns preload domains's number must less than 10, httpdns preload is skipped.");
        goto L31
    L5:
        if (Logger.debug() == false) goto L35;
        Logger.d(TAG, "you have set httpdns depend before.");
        return;
    }

    public void setHttpDnsHardCodeIps(JSONArray r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() <= 0) goto L18;
        this.mHttpdnsDomainHardCodeIps.clear();
        int r101 = 0;
    L7:
        if (r101 >= r100.length()) goto L12;
        String r102 = r100.optString(r101);
        if (TextUtils.isEmpty(r102) == true) goto L11;
        this.mHttpdnsDomainHardCodeIps.add(r102);
    L11:
        r101 = r101 + 1;
        goto L7
    L12:
        SharedPreferences.Editor r103 = this.mHttpDnsDepend.getContext().getSharedPreferences(HTTPDNS_HARDCODEIP_SP_NAME, 0).edit();
        r103.putString(HTTPDNS_HARDCODEIP_SP_KEY, String.valueOf(r100));
        r103.apply();
        return;
    }

    private void callbackDnsResultInMainthread(HostResolveJob r100, DnsResult r101) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "doDnsResultCallback for host " + r100.getHost());
    L5:
        Message r102 = Message.obtain();
        r102.obj = this;
        r102.what = 1;
        Bundle r103 = new Bundle();
        r103.putSerializable(MSG_CALLBACK_DNSRESULT_JOB_KEY, r100);
        r103.putSerializable(MSG_CALLBACK_DNSRESULT_KEY, r101);
        r102.setData(r103);
        this.mMainThreadHandler.sendMessage(r102);
    }

    private DnsResult getHttpDnsResultForLocalDnsPreferRequest(String r100, boolean r101) {
        if (r101 == false) goto L6;
        return null;
    L6:
        if (this.mHostResolveManager.isHttpDnsResolving(r100) == false) goto L8;
        Future<Void> r102 = this.mHostResolveManager.getHttpDnsResolvingFuture(r100);
    L9:
        if (r102 != null) goto L12;
        return null;
    L12:
        if (r102.isDone() == true) goto L19;
        r102.get(((long) this.mHttpDnsTimeout.get()) * 1000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L16
        return lookupHttpDnsCache(r100, true);
    L20:
        return null;
    L19:
        return lookupHttpDnsCache(r100, true);
    L8:
        ArrayList r103 = new ArrayList();
        r103.add(r100);
        r102 = submitHttpDnsResolve(r103, DnsRecord.CacheStaleReason.CACHE_UNSET, true);
        goto L9
    }

    private DnsResult lookupHttpDnsCache(String r100, boolean r101) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "look up httpdns cache for host " + r100);
    L5:
        DnsRecord r102 = this.mHostResolveManager.getHttpDnsCache(r100);
        if (r102 != null) goto L8;
        return null;
    L8:
        DnsResult r103 = new DnsResult();
        r103.ipv4List = r102.getIpv4List();
        r103.ipv6List = r102.getIpv6List();
        if (r101 == false) goto L16;
        if (((r102.getTTL() * 1000) + r102.getFetchTime()) <= System.currentTimeMillis()) goto L14;
        r103.source = DnsResult.Source.HTTPDNS_REQUEST;
        return r103;
    L14:
        return null;
    L16:
        if (((r102.getTTL() * 1000) + r102.getFetchTime()) <= System.currentTimeMillis()) goto L18;
        r103.source = DnsResult.Source.HTTPDNS_CACHE;
    L19:
        return r103;
    L18:
        r103.source = DnsResult.Source.HTTPDNS_STALE_CACHE;
        goto L19
    }

    private DnsResult lookupLocalDnsCache(String r100, boolean r101) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "lookup localdns cache for host " + r100);
    L5:
        DnsResult r102 = new DnsResult();
        DnsRecord r103 = this.mHostResolveManager.getLocalDnsCache(r100);
        if (r103 != null) goto L9;
        return null;
    L9:
        r102.ipv4List = r103.getIpv4List();
        r102.ipv6List = r103.getIpv6List();
        if (r101 == false) goto L12;
        r102.source = DnsResult.Source.LOCALDNS_REQUEST;
    L13:
        return r102;
    L12:
        r102.source = DnsResult.Source.LOCALDNS_CACHE;
        goto L13
    }

    public DnsResult getHttpDnsResultForHostAsync(String r100, IHttpDnsCallback r101) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "HttpDns::getHttpDnsResultForHostAsync for host " + r100);
    L6:
        if (invalidConfigure(r100) == false) goto L9;
        return null;
    L9:
        if (isHttpDnsPrefer().get() == false) goto L17;
        DnsResult r102 = lookupHttpDnsCache(r100, false);
        if (r102 != null) goto L13;
        ArrayList r103 = new ArrayList();
        ListProtector.add(r103, 0, Boolean.FALSE);
        submitHttpDnsAndLocalDnsResolve(r100, r103, false);
        HostResolveJob r104 = new HostResolveJob(r100, r101, ((Boolean) ListProtector.get(r103, 0)).booleanValue());
        this.mHostResolveManager.addHttpDnsJob(r100, r104);
        Message r105 = Message.obtain();
        r105.what = 2;
        r105.obj = this;
        Bundle r106 = new Bundle();
        r106.putSerializable(MSG_HTTPDNS_PREFER_TIMEOUT_JOB_KEY, r104);
        r105.setData(r106);
        mHttpDnsHandler.sendMessageDelayed(r105, this.mHttpDnsPreferInterval.get());
    L24:
        return null;
    L13:
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "returned httpdns cache, wouldn't callback");
    L15:
        return r102;
    L17:
        DnsResult r107 = lookupLocalDnsCache(r100, false);
        if (r107 == null) goto L21;
        return r107;
    L21:
        if (this.mHostResolveManager.isLocalDnsResolving(r100) == true) goto L23;
        submitLocalDnsResolve(r100);
    L23:
        HostResolveJob r108 = new HostResolveJob(r100, r101, true);
        this.mHostResolveManager.addLocalDnsJob(r100, r108);
        Message r109 = Message.obtain();
        r109.what = 3;
        r109.obj = this;
        Bundle r110 = new Bundle();
        r110.putSerializable(MSG_DNS_TIMEOUT_JOB_KEY, r108);
        r109.setData(r110);
        mHttpDnsHandler.sendMessageDelayed(r109, ((long) this.mLocalDnsTimeout.get()) * 1000);
        goto L24
    }

    private DnsResult getDnsResultInHttpDnsPreferTime(Future<Void> r100, String r101, boolean r102) {
        if (Logger.debug() == false) goto L36;
        Logger.d(TAG, "getDnsResultInHttpDnsPreferTime");
    L36:
        if (r100 != null) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "httpdns future is null");     // Catch: TimeoutException -> L23 ExecutionException -> L27 InterruptedException -> L31
    L10:
        return lookupLocalDnsCache(r101, r102);
    L12:
        if (r100.isDone() == true) goto L14;
        r100.get(getService().getHttpDnsPreferInterval().get(), TimeUnit.MILLISECONDS);     // Catch: TimeoutException -> L23 ExecutionException -> L27 InterruptedException -> L31
        DnsResult r103 = lookupHttpDnsCache(r101, true);     // Catch: TimeoutException -> L23 ExecutionException -> L27 InterruptedException -> L31
        if (r103 == null) goto L42;
        return r103;
    L42:
        return lookupLocalDnsCache(r101, r102);
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "httpdns future is done");     // Catch: TimeoutException -> L23 ExecutionException -> L27 InterruptedException -> L31
    L16:
        DnsResult r104 = lookupHttpDnsCache(r101, true);     // Catch: TimeoutException -> L23 ExecutionException -> L27 InterruptedException -> L31
        if (r104 == null) goto L38;
        return r104;
    L38:
        return lookupLocalDnsCache(r101, r102);
    L32:
        if (Logger.debug() == false) goto L35;
        Logger.d(TAG, "httpdns InterruptedException, look up localdns");
    L35:
        return lookupLocalDnsCache(r101, r102);
    L28:
        if (Logger.debug() == false) goto L41;
        Logger.d(TAG, "httpdns ExecutionException, look up localdns");
    L41:
        return lookupLocalDnsCache(r101, r102);
    L24:
        if (Logger.debug() == false) goto L40;
        Logger.d(TAG, "httpdns timeout in httpdns prefer time, look up localdns");
    L40:
        return lookupLocalDnsCache(r101, r102);
    }

    private Future<Void> submitHttpDnsAndLocalDnsResolve(String r100, List<Boolean> r101, boolean r110) {
        DnsRecord r102 = this.mHostResolveManager.getLocalDnsCache(r100);
        if (r102 != null) goto L5;
    L6:
        ListProtector.set(r101, 0, Boolean.TRUE);
        if (this.mHostResolveManager.isLocalDnsResolving(r100) == true) goto L10;
        submitLocalDnsResolve(r100);
    L10:
        if (this.mHostResolveManager.isHttpDnsResolving(r100) == true) goto L12;
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L17:
        if (this.mHostResolveManager.isHttpDnsResolving(r100) == false) goto L19;
        Future<Void> r103 = this.mHostResolveManager.getHttpDnsResolvingFuture(r100);     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);     // Catch: Throwable -> L22
        return r103;
    L19:
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L22
        r104.add(r100);     // Catch: Throwable -> L22
        r103 = submitHttpDnsResolve(r104, DnsRecord.CacheStaleReason.CACHE_UNSET, r110);     // Catch: Throwable -> L22
        goto L20
    L12:
        if (Logger.debug() == false) goto L27;
        Logger.d(TAG, "httpdns is resolving for host " + r100);
    L27:
        return this.mHostResolveManager.getHttpDnsResolvingFuture(r100);
    L5:
        if ((r102.getFetchTime() + (r102.getTTL() * 1000)) > (System.currentTimeMillis() + ((long) this.mHttpDnsPreferInterval.get()))) goto L10;
        goto L6
    }

    public synchronized Future<Void> submitHttpDnsResolve(List<String> r100, DnsRecord.CacheStaleReason r110, boolean r111) {
        monitor-enter(this);
        Future<Void> r101 = null;
        if (r100 == null) goto L43;
    L47:
        th = move-exception;
        throw th;
    L6:
        if (r100.size() == 0) goto L43;
        int r102 = 0;
    L10:
        if (r102 >= r100.size()) goto L23;
        if (this.mHostResolveManager.isHttpDnsResolving((String) ListProtector.get(r100, r102)) == false) goto L21;
        if (r111 == true) goto L15;
    L20:
        r100.remove(ListProtector.get(r100, r102));     // Catch: Throwable -> L47
        goto L21
    L15:
        if (r100.size() != 1) goto L20;
        if (r102 != 0) goto L20;
        r101 = this.mHostResolveManager.getHttpDnsResolvingFuture((String) ListProtector.get(r100, r102));     // Catch: Throwable -> L47
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, "sync block request for " + ((String) ListProtector.get(r100, r102)) + " is resolving");     // Catch: Throwable -> L47
    L21:
        r102 = r102 + 1;     // Catch: Throwable -> L47
        goto L10
    L23:
        if (r100.size() != 0) goto L27;
        monitor-exit(this);
        return r101;
    L27:
        if (Logger.debug() == false) goto L50;
        Logger.d(TAG, "submit httpdns resolve for host : " + r100);     // Catch: Throwable -> L47
    L50:
        r101 = mThreadPool.submit(new HttpDnsResolveCall(HttpDnsUtil.transHostList2String(r100), mSdkVersion, this.mHostResolveManager, r110, mHttpDnsHandler));     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        Iterator<String> r112 = r100.iterator();     // Catch: RejectedExecutionException -> L36 Throwable -> L47
    L31:
        if (r112.hasNext() == false) goto L40;
        String r113 = r112.next();     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        this.mHostResolveManager.addHttpDnsResolvingFuture(r113, r101);     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        if (this.mIsHttpDnsPrefer.get() == false) goto L31;
        this.mHostResolveManager.removeHttpDnsStaleCacheHost(r113);     // Catch: RejectedExecutionException -> L36 Throwable -> L47
    L40:
        monitor-exit(this);
        return r101;
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L47
        if (Logger.debug() == false) goto L40;
        Logger.d(TAG, "submit httpdns resolve for host : " + r100 + " was rejected");     // Catch: Throwable -> L47
    L43:
        if (Logger.debug() == false) goto L45;
        Logger.d(TAG, "httpdns resolve hostlist is null.");     // Catch: Throwable -> L47
    L45:
        monitor-exit(this);
        return null;
    }
}
