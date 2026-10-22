package com.ss.bduploader.net;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes40.dex */
public class IPCache {
    private static IPCache mInstance = null;
    private static String mNetExtraInfo = null;
    private static int mNetType = -1;
    private Lock lock;
    private ConcurrentHashMap<String, BDUploadDNSInfo> mDNSRecord;

    public static IPCache getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(IPCache.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new IPCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(IPCache.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public void clear() {
        this.lock.lock();
        ConcurrentHashMap<String, BDUploadDNSInfo> r100 = this.mDNSRecord;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.clear();     // Catch: Throwable -> L8
    L6:
        this.lock.unlock();
        return;
    L8:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public int getRecordSize() {
        this.lock.lock();
        ConcurrentHashMap<String, BDUploadDNSInfo> r100 = this.mDNSRecord;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        int r101 = r100.size();     // Catch: Throwable -> L10
    L8:
        this.lock.unlock();
        return r101;
    L7:
        r101 = -1;
    L10:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    private IPCache() {
        this.mDNSRecord = new ConcurrentHashMap();
        this.lock = new ReentrantLock();
    }

    public String getCurNetExtraInfo() {
        return mNetExtraInfo;
    }

    public int getCurNetType() {
        return mNetType;
    }

    public BDUploadDNSInfo get(String r100) {
        this.lock.lock();
        ConcurrentHashMap<String, BDUploadDNSInfo> r101 = this.mDNSRecord;     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        BDUploadDNSInfo r102 = r101.get(r100);     // Catch: Throwable -> L10
    L8:
        this.lock.unlock();
        return r102;
    L7:
        r102 = null;
    L10:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void setCurNetExtraInfo(String r100) {
        mNetExtraInfo = r100;
    }

    public void setCurNetType(int r100) {
        mNetType = r100;
    }

    public void put(String r100, BDUploadDNSInfo r101) {
        this.lock.lock();
        ConcurrentHashMap<String, BDUploadDNSInfo> r102 = this.mDNSRecord;     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r102.put(r100, r101);     // Catch: Throwable -> L8
    L6:
        this.lock.unlock();
        return;
    L8:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }
}
