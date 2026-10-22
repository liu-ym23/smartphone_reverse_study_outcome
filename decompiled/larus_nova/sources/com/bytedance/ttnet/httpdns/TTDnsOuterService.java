package com.bytedance.ttnet.httpdns;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public class TTDnsOuterService {
    private static TTDnsOuterService sInstance;
    private Map<String, TTDnsQuery> queryMap;

    public static synchronized TTDnsOuterService getInstance() {
        monitor-enter(TTDnsOuterService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new TTDnsOuterService();     // Catch: Throwable -> L10
    L7:
        TTDnsOuterService r100 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(TTDnsOuterService.class);
        return r100;
    }

    public TTDnsOuterService() {
        this.queryMap = new ConcurrentHashMap();
    }

    public TTDnsResult TTDnsResolve(String r100, int r101, Map<String, String> r102) throws Exception {
        TTDnsQuery r103 = new TTDnsQuery(r100, r101, r102);
        this.queryMap.put(r103.uuid(), r103);
        r103.doQuery();
        r103.await();
        this.queryMap.remove(r103.uuid());
        return r103.result();
    }

    public void HandleHttpdnsResult(String r100, String r101, int r110, int r111, int r112, List<String> r113, String r114) {
        TTDnsQuery r102 = this.queryMap.get(r100);
        if (r102 == null) goto L6;
        r102.setResult(new TTDnsResult(r110, r111, r112, r113, r114));
        r102.resume();
        this.queryMap.remove(r100);
        return;
    }
}
