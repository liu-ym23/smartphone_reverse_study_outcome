package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.util.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes19.dex */
public class HostResolveManager {
    public static final int MSG_REMOVE_HTTPDNSDOMAIN_DARKROME = 20;
    private static final String TAG = null;
    private final int BATCH_REFRESH_CNT;
    private final long TIME_IN_DARKROOM;
    private AtomicInteger mDetectedHardCodeipsCnt;
    private final Handler mHandler;
    private g<String, DnsRecord> mHttpDnsCacheMap;
    private AtomicInteger mHttpDnsDomainFailedCnt;
    private ConcurrentMap<String, ConcurrentSkipListSet<HostResolveJob>> mHttpDnsResolveJobs;
    private ConcurrentMap<String, Future<Void>> mHttpDnsResolvingFutureMap;
    private ConcurrentSkipListSet<String> mHttpDnsStaleCacheHosts;
    private NetworkUtils.NetworkType mLastNetType;
    private ConcurrentMap<String, DnsRecord> mLocalDnsCacheMap;
    private ConcurrentMap<String, ConcurrentSkipListSet<HostResolveJob>> mLocalDnsResolveJobs;
    private ConcurrentMap<String, Future<Void>> mLocalDnsResolvingFutureMap;

    static {
        TAG = "HostResolveManager";
    }

    public void addHttpDnsDomainFailedCnt() {
        this.mHttpDnsDomainFailedCnt.getAndIncrement();
        if (this.mHttpDnsDomainFailedCnt.get() < 2) goto L6;
        Message r100 = Message.obtain();
        r100.what = 20;
        r100.obj = this;
        this.mHandler.sendMessageDelayed(r100, 180000);
        return;
    }

    public void resetHttpDnsDomainFailedCnt() {
        this.mHttpDnsDomainFailedCnt.set(0);
    }

    public void setDetectedHardCodeipsCnt() {
        this.mDetectedHardCodeipsCnt.getAndIncrement();
    }

    public AtomicInteger getDetectedHardCodeipsCnt() {
        return this.mDetectedHardCodeipsCnt;
    }

    public AtomicInteger getHttpDnsDomainFailedCnt() {
        return this.mHttpDnsDomainFailedCnt;
    }

    public HostResolveManager(Handler r100) {
        this.mHttpDnsCacheMap = new g(100);
        this.mLocalDnsCacheMap = new ConcurrentHashMap();
        this.mHttpDnsResolvingFutureMap = new ConcurrentHashMap();
        this.mLocalDnsResolvingFutureMap = new ConcurrentHashMap();
        this.mHttpDnsResolveJobs = new ConcurrentHashMap();
        this.mLocalDnsResolveJobs = new ConcurrentHashMap();
        this.mHttpDnsStaleCacheHosts = new ConcurrentSkipListSet();
        this.mDetectedHardCodeipsCnt = new AtomicInteger(0);
        this.mHttpDnsDomainFailedCnt = new AtomicInteger(0);
        this.mLastNetType = NetworkUtils.NetworkType.NONE;
        this.TIME_IN_DARKROOM = 180000;
        this.BATCH_REFRESH_CNT = 10;
        this.mHandler = r100;
    }

    public void addHttpDnsStaleCacheHost(String r100) {
        this.mHttpDnsStaleCacheHosts.add(r100);
        if (this.mHttpDnsStaleCacheHosts.size() >= 10) goto L5;
        return;
    L5:
        ArrayList r101 = new ArrayList();
        r101.addAll(this.mHttpDnsStaleCacheHosts);
        HttpDns.getService().batchRefreshHttpDnsStaleCache(r101);
    }

    public DnsRecord getHttpDnsCache(String r100) {
        Map<String, DnsRecord> r101 = this.mHttpDnsCacheMap.c();
        monitor-enter(r101);
        DnsRecord r102 = this.mHttpDnsCacheMap.b(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public ConcurrentSkipListSet<HostResolveJob> getHttpDnsJobs(String r100) {
        return this.mHttpDnsResolveJobs.get(r100);
    }

    public Future<Void> getHttpDnsResolvingFuture(String r100) {
        if (this.mHttpDnsResolvingFutureMap.containsKey(r100) == true) goto L5;
        return null;
    L5:
        return this.mHttpDnsResolvingFutureMap.get(r100);
    }

    public DnsRecord getLocalDnsCache(String r100) {
        if (this.mLocalDnsCacheMap.containsKey(r100) == true) goto L5;
        return null;
    L5:
        return this.mLocalDnsCacheMap.get(r100);
    }

    public ConcurrentSkipListSet<HostResolveJob> getLocalDnsJobs(String r100) {
        return this.mLocalDnsResolveJobs.get(r100);
    }

    public Future<Void> getLocalDnsResolvingFuture(String r100) {
        if (this.mLocalDnsResolvingFutureMap.containsKey(r100) == true) goto L5;
        return null;
    L5:
        return this.mLocalDnsResolvingFutureMap.get(r100);
    }

    public boolean isHttpDnsResolving(String r100) {
        return this.mHttpDnsResolvingFutureMap.containsKey(r100);
    }

    public boolean isLocalDnsResolving(String r100) {
        return this.mLocalDnsResolvingFutureMap.containsKey(r100);
    }

    public void onNetworkChanged(Context r100) {
        NetworkUtils.NetworkType r101 = NetworkUtils.getNetworkType(r100);
        if (r101 != this.mLastNetType) goto L5;
    L32:
        this.mLastNetType = r101;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "network changed, clear cache and re-batch-preload preload hosts, current net type is " + r101);
    L7:
        Map<String, DnsRecord> r102 = this.mHttpDnsCacheMap.c();
        monitor-enter(r102);
        Iterator<Map.Entry<String, DnsRecord>> r103 = this.mHttpDnsCacheMap.c().entrySet().iterator();     // Catch: Throwable -> L29
    L11:
        if (r103.hasNext() == false) goto L18;
        Map.Entry<String, DnsRecord> r104 = r103.next();     // Catch: Throwable -> L29
        if (r104 == null) goto L11;
        if (HttpDns.getService().isHttpDnsPrefer().get() == true) goto L16;
        r104.getValue().removeHttpDnsRemoveTask();     // Catch: Throwable -> L29
        goto L11
    L16:
        r104.getValue().removeHttpDnsRefreshTask();     // Catch: Throwable -> L29
        goto L11
    L18:
        this.mHttpDnsCacheMap.a();     // Catch: Throwable -> L29
        monitor-exit(r102);     // Catch: Throwable -> L29
        Iterator<Map.Entry<String, DnsRecord>> r105 = this.mLocalDnsCacheMap.entrySet().iterator();
    L22:
        if (r105.hasNext() == false) goto L26;
        Map.Entry<String, DnsRecord> r106 = r105.next();
        if (r106 == null) goto L22;
        r106.getValue().removeLocalDnsRemoveTask();
        goto L22
    L26:
        this.mLocalDnsCacheMap.clear();
        if (r101 == NetworkUtils.NetworkType.NONE) goto L32;
        HttpDns.getService().doHttpDnsPreload(DnsRecord.CacheStaleReason.CACHE_STALE_NETCHANGED);
        HttpDns.getService().submitIpv6Detect();
    L29:
        th = move-exception;
        throw th;
    }

    public void removeHttpDnsCache(String r100) {
        DnsRecord r101 = getHttpDnsCache(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (HttpDns.getService().isHttpDnsPrefer().get() == false) goto L7;
        r101.removeHttpDnsRefreshTask();
    L8:
        Map<String, DnsRecord> r102 = this.mHttpDnsCacheMap.c();
        monitor-enter(r102);
        this.mHttpDnsCacheMap.e(r100);     // Catch: Throwable -> L13
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L7:
        r101.removeHttpDnsRemoveTask();
        goto L8
    }

    public void removeHttpDnsJob(HostResolveJob r100) {
        String r101 = r100.getHost();
        if (this.mHttpDnsResolveJobs.containsKey(r101) == false) goto L8;
        this.mHttpDnsResolveJobs.get(r101).remove(r100);
        if (this.mHttpDnsResolveJobs.get(r101).isEmpty() == false) goto L9;
        this.mHttpDnsResolveJobs.remove(r101);
        return;
    L9:
        return;
    }

    public void removeHttpDnsResolvingFuture(String r100) {
        this.mHttpDnsResolvingFutureMap.remove(r100);
    }

    public void removeHttpDnsStaleCacheHost(String r100) {
        if (this.mHttpDnsStaleCacheHosts.contains(r100) == false) goto L6;
        this.mHttpDnsStaleCacheHosts.remove(r100);
        return;
    }

    public void removeLocalDnsCache(String r100) {
        DnsRecord r101 = getLocalDnsCache(r100);
        if (r101 == null) goto L6;
        r101.removeLocalDnsRemoveTask();
        this.mLocalDnsCacheMap.remove(r100);
        return;
    }

    public void removeLocalDnsJob(HostResolveJob r100) {
        String r101 = r100.getHost();
        if (this.mLocalDnsResolveJobs.containsKey(r101) == false) goto L8;
        this.mLocalDnsResolveJobs.get(r101).remove(r100);
        if (this.mLocalDnsResolveJobs.get(r101).isEmpty() == false) goto L9;
        this.mLocalDnsResolveJobs.remove(r101);
        return;
    L9:
        return;
    }

    public void removeLocalDnsResolvingFuture(String r100) {
        this.mLocalDnsResolvingFutureMap.remove(r100);
    }

    public boolean shouldHttpDnsCallback(String r100) {
        return this.mHttpDnsResolveJobs.containsKey(r100);
    }

    public boolean shouldHttpDnsTimeoutCallback(HostResolveJob r100) {
        if (this.mHttpDnsResolveJobs.containsKey(r100.getHost()) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mHttpDnsResolveJobs.get(r100.getHost()).contains(r100) == false) goto L7;
        return true;
    }

    public boolean shouldLocalDnsCallback(String r100) {
        return this.mLocalDnsResolveJobs.containsKey(r100);
    }

    public boolean shouldLocalDnsTimeoutCallback(HostResolveJob r100) {
        if (this.mLocalDnsResolveJobs.containsKey(r100.getHost()) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mLocalDnsResolveJobs.get(r100.getHost()).contains(r100) == false) goto L7;
        return true;
    }

    public void addHttpDnsCache(String r100, DnsRecord r101) {
        DnsRecord r102 = getHttpDnsCache(r100);
        if (r102 == null) goto L9;
        if (HttpDns.getService().isHttpDnsPrefer().get() == false) goto L7;
        r102.removeHttpDnsRefreshTask();
        goto L9
    L7:
        r102.removeHttpDnsRemoveTask();
    L9:
        if (HttpDns.getService().isHttpDnsPrefer().get() == false) goto L11;
        r101.addHttpDnsRefreshTask();
    L12:
        Map<String, DnsRecord> r103 = this.mHttpDnsCacheMap.c();
        monitor-enter(r103);
        this.mHttpDnsCacheMap.d(r100, r101);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L11:
        r101.addHttpDnsRemoveTask();
        goto L12
    }

    public synchronized void addHttpDnsJob(String r100, HostResolveJob r101) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mHttpDnsResolveJobs.containsKey(r100) == false) goto L6;
        this.mHttpDnsResolveJobs.get(r100).add(r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        ConcurrentSkipListSet<HostResolveJob> r102 = new ConcurrentSkipListSet();     // Catch: Throwable -> L9
        r102.add(r101);     // Catch: Throwable -> L9
        this.mHttpDnsResolveJobs.put(r100, r102);     // Catch: Throwable -> L9
        goto L7
    }

    public void addHttpDnsResolvingFuture(String r100, Future<Void> r101) {
        this.mHttpDnsResolvingFutureMap.put(r100, r101);
    }

    public void addLocalDnsCache(String r100, DnsRecord r101) {
        DnsRecord r102 = getLocalDnsCache(r100);
        if (r102 == null) goto L5;
        r102.removeLocalDnsRemoveTask();
    L5:
        r101.addLocalDnsRemoveTask();
        this.mLocalDnsCacheMap.put(r100, r101);
    }

    public synchronized void addLocalDnsJob(String r100, HostResolveJob r101) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mLocalDnsResolveJobs.containsKey(r100) == false) goto L6;
        this.mLocalDnsResolveJobs.get(r100).add(r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        ConcurrentSkipListSet<HostResolveJob> r102 = new ConcurrentSkipListSet();     // Catch: Throwable -> L9
        r102.add(r101);     // Catch: Throwable -> L9
        this.mLocalDnsResolveJobs.put(r100, r102);     // Catch: Throwable -> L9
        goto L7
    }

    public void addLocalDnsResolvingFuture(String r100, Future<Void> r101) {
        this.mLocalDnsResolvingFutureMap.put(r100, r101);
    }
}
