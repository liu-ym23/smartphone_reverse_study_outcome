package com.ss.mediakit.net;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLDNSManager {
    public static Map<Integer, CreateConstructor> dnsMap;
    private static volatile AVMDLDNSManager mInstance;

    public static AVMDLDNSManager getInstance() {
        if (mInstance != null) goto L18;
        monitor-enter(AVMDLDNSManager.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (mInstance == null) goto L21;
    L12:
        monitor-exit(AVMDLDNSManager.class);     // Catch: Throwable -> L14
        goto L18
    L21:
        mInstance = new AVMDLDNSManager();     // Catch: Exception -> L10 Throwable -> L14
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        mInstance = null;     // Catch: Throwable -> L14
    L18:
        return mInstance;
    }

    private void initDnsMap() throws Exception {
        DefaultConstructor r100 = new DefaultConstructor();
        dnsMap.put(1, r100);
        dnsMap.put(2, r100);
        dnsMap.put(3, r100);
        dnsMap.put(5, r100);
    }

    private AVMDLDNSManager() throws Exception {
        dnsMap = new HashMap();
        initDnsMap();
    }

    public synchronized CreateConstructor getCreateConstructor(int r100) throws Exception {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (dnsMap.containsKey(Integer.valueOf(r100)) == false) goto L8;
        CreateConstructor r101 = dnsMap.get(Integer.valueOf(r100));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        monitor-exit(this);
        return null;
    }

    public synchronized void registerDnsConstructor(int r100, CreateConstructor r101) {
        monitor-enter(this);
        dnsMap.put(Integer.valueOf(r100), r101);     // Catch: Throwable -> L5 Exception -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }
}
