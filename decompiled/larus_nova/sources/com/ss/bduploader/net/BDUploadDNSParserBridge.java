package com.ss.bduploader.net;

import android.text.TextUtils;
import com.ss.bduploader.BDUploadLog;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes40.dex */
public class BDUploadDNSParserBridge implements BDUploadDNSParserListener {
    private static final String TAG = "BDUploadDNSParserBridge";
    private long handle;
    public String host;
    String ipList;
    boolean isFinish;
    private Lock lock;

    private static native void _notifyParserResult(long r100, String r101, String r102, long r103, String r104);

    public String getResult() {
        this.lock.lock();
        String r100 = this.ipList;     // Catch: Throwable -> L6
        this.lock.unlock();
        BDUploadLog.d(TAG, "****get result:" + r100);
        return r100;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void release() {
        this.lock.lock();
        this.handle = 0;     // Catch: Throwable -> L6
        BDUploadDNSParser.getInstance().removeHost(this.host, this);     // Catch: Throwable -> L6
        this.lock.unlock();
        return;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public BDUploadDNSParserBridge() {
        this.ipList = null;
        this.isFinish = false;
        this.lock = new ReentrantLock();
        this.handle = 0;
    }

    public boolean isFinish() {
        return this.isFinish;
    }

    public int start(long r110, String r111) {
        BDUploadLog.d(TAG, "----start parse host:" + r111);
        if (TextUtils.isEmpty(r111) == false) goto L6;
        BDUploadLog.d(TAG, "****end parse fail for host:" + r111);
        return -1;
    L6:
        this.lock.lock();
        this.handle = r110;
        this.host = r111;     // Catch: Throwable -> L19
        BDUploadDNSInfo r100 = IPCache.getInstance().get(r111);     // Catch: Throwable -> L19
        int r101 = 0;
        if (r100 == null) goto L16;
        this.ipList = r100.mIpList;     // Catch: Throwable -> L19
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L19
        BDUploadLog.d(TAG, String.format("get result from cache expiredT:%d curT:%d ", new Object[]{Long.valueOf(r100.mExpiredTime), Long.valueOf(r102)}));     // Catch: Throwable -> L19
        if (r100.mExpiredTime > r102) goto L12;
        BDUploadLog.d(TAG, String.format("has expired try call parse:", new Object[0]));     // Catch: Throwable -> L19
        BDUploadDNSParser.getInstance().addHost(r111, null);     // Catch: Throwable -> L19
    L12:
        long r103 = this.handle;     // Catch: Throwable -> L19
        if (r103 == 0) goto L15;
        _notifyParserResult(r103, r111, this.ipList, r100.mExpiredTime, null);     // Catch: Throwable -> L19
    L15:
        r101 = 1;
    L17:
        this.lock.unlock();
        return r101;
    L16:
        BDUploadLog.d(TAG, "****add host to parser");     // Catch: Throwable -> L19
        BDUploadDNSParser.getInstance().addHost(r111, this);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // com.ss.bduploader.net.BDUploadDNSParserListener
    public void onCompletion(int r100, String r110, String r111, long r112, String r113) {
        this.lock.lock();
    L12:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L5:
        if (this.isFinish == true) goto L9;
        BDUploadLog.d(TAG, String.format("receive completion code:%d result:%s", new Object[]{Integer.valueOf(r100), r111}));     // Catch: Throwable -> L12
        this.ipList = r111;     // Catch: Throwable -> L12
        this.isFinish = true;     // Catch: Throwable -> L12
        long r101 = this.handle;     // Catch: Throwable -> L12
        if (r101 == 0) goto L10;
        _notifyParserResult(r101, r110, r111, r112, r113);     // Catch: Throwable -> L12
    L10:
        this.lock.unlock();
        return;
    L9:
        BDUploadLog.d(TAG, String.format("has finished not nedd cur completion code:%d result:%s expiredTime:%lld", new Object[]{Integer.valueOf(r100), r111, Long.valueOf(r112)}));     // Catch: Throwable -> L12
        goto L10
    }
}
