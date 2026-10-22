package com.ss.mediakit.net;

import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes40.dex */
public class IPCache {
    private static final String TAG = "AVMDLIPCache";
    private static volatile IPCache mInstance = null;
    private static String mNetExtraInfo = null;
    private static int mNetType = -1;
    private Lock backUplock;
    private Lock lock;
    private ConcurrentHashMap<String, AVMDLDNSInfo> mBackUps;
    private ConcurrentHashMap<String, AVMDLDNSInfo> mDNSRecord;

    public static /* synthetic */ String a(AVMDLDNSInfo r100) {
        return lambda$get$1(r100);
    }

    public static /* synthetic */ String b(AVMDLDNSInfo r100) {
        return lambda$put$3(r100);
    }

    public static /* synthetic */ String c(String r100, AVMDLDNSInfo r101, AVMDLDNSInfo r102) {
        return lambda$put$2(r100, r101, r102);
    }

    public static /* synthetic */ String d(AVMDLDNSInfo r100) {
        return lambda$putBackUpIp$4(r100);
    }

    public static /* synthetic */ String e(String r100) {
        return lambda$get$0(r100);
    }

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
        ConcurrentHashMap<String, AVMDLDNSInfo> r100 = this.mDNSRecord;     // Catch: Throwable -> L8
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
        ConcurrentHashMap<String, AVMDLDNSInfo> r100 = this.mDNSRecord;     // Catch: Throwable -> L10
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
        this.mBackUps = new ConcurrentHashMap();
        this.lock = new ReentrantLock();
        this.backUplock = new ReentrantLock();
    }

    public String getCurNetExtraInfo() {
        return mNetExtraInfo;
    }

    public int getCurNetType() {
        return mNetType;
    }

    private static /* synthetic */ String lambda$get$0(String r100) {
        return String.format(Locale.US, "enable backup try get backup ip for:%s", new Object[]{r100});
    }

    private static /* synthetic */ String lambda$get$1(AVMDLDNSInfo r100) {
        return String.format(Locale.US, "succ get backup ip:%s", new Object[]{r100.mIpList});
    }

    private static /* synthetic */ String lambda$put$3(AVMDLDNSInfo r100) {
        return String.format(Locale.US, "put for host:%s type:%d ip:%s", new Object[]{r100.mHost, Integer.valueOf(r100.mType), r100.mIpList});
    }

    private static /* synthetic */ String lambda$putBackUpIp$4(AVMDLDNSInfo r100) {
        return String.format(Locale.US, "put backupip for host:%s type:%d ip:%s", new Object[]{r100.mHost, Integer.valueOf(r100.mType), r100.mIpList});
    }

    public static void setCurNetExtraInfo(String r100) {
        mNetExtraInfo = r100;
    }

    public AVMDLDNSInfo get(final String r100) {
        AVMDLDNSInfo r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        this.lock.lock();
        ConcurrentHashMap<String, AVMDLDNSInfo> r102 = this.mDNSRecord;     // Catch: Throwable -> L21
        if (r102 == null) goto L9;
        r101 = r102.get(r100);     // Catch: Throwable -> L21
    L9:
        if (r101 != null) goto L11;
    L19:
        this.lock.unlock();
        return r101;
    L11:
        if (TextUtils.isEmpty(r101.mIpList) == true) goto L19;
        if (AVMDLDNSParser.mGlobalEnableBackUpIp <= 0) goto L19;
        AVMDLLog.d(TAG, new g3(r100));     // Catch: Throwable -> L21
        final AVMDLDNSInfo r103 = getBackUpIp(r100);     // Catch: Throwable -> L21
        if (r103 == null) goto L19;
        if (TextUtils.isEmpty(r103.mIpList) == true) goto L19;
        AVMDLLog.d(TAG, new h3(r103));     // Catch: Throwable -> L21
        r101.mIpList += "," + r103.mIpList;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public AVMDLDNSInfo getBackUpIp(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        this.backUplock.lock();
        AVMDLDNSInfo r101 = this.mBackUps.get(r100);     // Catch: Throwable -> L10
        this.backUplock.unlock();
        return r101;
    L10:
        th = move-exception;
        this.backUplock.unlock();
        throw th;
    }

    public void setCurNetType(int r100) {
        mNetType = r100;
    }

    public void put(final String r110, final AVMDLDNSInfo r111) {
        if (r111 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r110) == true) goto L30;
        this.lock.lock();
        ConcurrentHashMap<String, AVMDLDNSInfo> r100 = this.mDNSRecord;     // Catch: Throwable -> L25
        if (r100 == null) goto L23;
        final AVMDLDNSInfo r101 = r100.get(r110);     // Catch: Throwable -> L25
        if (AVMDLDNSParser.mGlobalEnableParallel <= 0) goto L22;
        if (r101 == null) goto L22;
        int r102 = r111.mType;     // Catch: Throwable -> L25
        if (r102 != 0) goto L22;
        if (r101.mType <= r102) goto L22;
        if (r101.mExpiredTime <= System.currentTimeMillis()) goto L22;
        AVMDLLog.d(TAG, new j3(r110, r111, r101));     // Catch: Throwable -> L25
        this.lock.unlock();
        return;
    L22:
        AVMDLLog.d(TAG, new k3(r111));     // Catch: Throwable -> L25
        this.mDNSRecord.put(r110, r111);     // Catch: Throwable -> L25
    L23:
        this.lock.unlock();
        AVMDLLog.d(TAG, "update dns info to native");
        AVMDLDataLoader.getInstance().updateDNSInfo(r110, r111.mIpList, r111.mExpiredTime, r111.mExtraInfo, r111.mType);
        return;
    L25:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void putBackUpIp(String r100, final AVMDLDNSInfo r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L16;
        this.backUplock.lock();
        AVMDLLog.d(TAG, new i3(r101));     // Catch: Throwable -> L10
        this.mBackUps.put(r100, r101);     // Catch: Throwable -> L10
        this.backUplock.unlock();
        return;
    L10:
        th = move-exception;
        this.backUplock.unlock();
        throw th;
    }

    private static /* synthetic */ String lambda$put$2(String r100, AVMDLDNSInfo r101, AVMDLDNSInfo r102) {
        return String.format(Locale.US, "put for host:%s enable parallel info.type:%d info.expiredT:%d cache.type:%d cache.expiredT:%d curT:%d info can not replace cache", new Object[]{r100, Integer.valueOf(r101.mType), Long.valueOf(r101.mExpiredTime), Integer.valueOf(r102.mType), Long.valueOf(r102.mExpiredTime), Long.valueOf(System.currentTimeMillis())});
    }
}
