package com.ss.mediakit.net;

import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLDNSParserBridge implements AVMDLDNSParserListener {
    private static final String TAG = "AVMDLDNSParserBridge";
    private static boolean v2Usable = true;
    private long handle;
    public String host;
    String ipList;
    boolean isFinish;
    private Lock lock;

    private static native void _notifyParserResult(long r100, String r101, String r102, long r103, String r104);

    private static native void _notifyParserResultV2(long r100, String r101, String r102, long r103, String r104, int r105);

    public static /* synthetic */ String a() {
        return lambda$parserResult$1();
    }

    public static /* synthetic */ String b(AVMDLDNSParserListener r100) {
        return lambda$parserResult$2(r100);
    }

    public static /* synthetic */ String c(AVMDLDNSParserListener r100) {
        return lambda$parserResult$3(r100);
    }

    public static /* synthetic */ String d(AVMDLDNSParserBridge r100) {
        return r100.lambda$release$5();
    }

    public static /* synthetic */ String e(AVMDLDNSParserBridge r100) {
        return r100.lambda$release$4();
    }

    public static /* synthetic */ String f(AVMDLDNSInfo r100, long r101) {
        return lambda$parserResult$0(r100, r101);
    }

    public static /* synthetic */ String g(String r100, int r101) {
        return lambda$parserResult$8(r100, r101);
    }

    public static /* synthetic */ String h(int r100, boolean r101, String r102, int r103) {
        return lambda$parserResult$7(r100, r101, r102, r103);
    }

    public static /* synthetic */ String i(int r100, String r101, long r102) {
        return lambda$parserResult$9(r100, r101, r102);
    }

    public static /* synthetic */ String j(AVMDLDNSParserBridge r100) {
        return r100.lambda$release$6();
    }

    private static /* synthetic */ String lambda$parserResult$1() {
        return String.format(Locale.US, "cache has expired need try call but not need listener", new Object[0]);
    }

    private /* synthetic */ String lambda$release$4() {
        return String.format(Locale.US, "----start release:%s", new Object[]{this});
    }

    private /* synthetic */ String lambda$release$5() {
        return String.format(Locale.US, "remove host:%s", new Object[]{this.host});
    }

    private /* synthetic */ String lambda$release$6() {
        return String.format(Locale.US, "****end call release:%s", new Object[]{this});
    }

    public String getResult() {
        this.lock.lock();
        String r100 = this.ipList;     // Catch: Throwable -> L6
        this.lock.unlock();
        AVMDLLog.d(TAG, "****get result:" + r100);
        return r100;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void release() {
        AVMDLLog.d(TAG, new i1(this));
        this.lock.lock();
        this.handle = 0;     // Catch: Throwable -> L6
        this.lock.unlock();
        AVMDLLog.d(TAG, new j1(this));
        AVMDLDNSParser.getInstance().removeHost(this.host, this);
        AVMDLLog.d(TAG, new k1(this));
        return;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public AVMDLDNSParserBridge() {
        this.ipList = null;
        this.isFinish = false;
        this.lock = new ReentrantLock();
        this.handle = 0;
    }

    public boolean isFinish() {
        return this.isFinish;
    }

    private static /* synthetic */ String lambda$parserResult$2(AVMDLDNSParserListener r100) {
        return String.format(Locale.US, "call add host to parser listener:%s", new Object[]{r100});
    }

    private static /* synthetic */ String lambda$parserResult$3(AVMDLDNSParserListener r100) {
        return String.format(Locale.US, "****call start end, listener:%s", new Object[]{r100});
    }

    public String getBackUp(String r100) {
        if (AVMDLDNSParser.getIntValue(5) != 1) goto L7;
        AVMDLDNSInfo r101 = IPCache.getInstance().getBackUpIp(r100);
        if (r101 == null) goto L7;
        String r102 = r101.mIpList;
    L8:
        AVMDLLog.d(TAG, "****get backup ip result:" + r102);
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    private static /* synthetic */ String lambda$parserResult$0(AVMDLDNSInfo r100, long r101) {
        return String.format(Locale.US, "get result from cache expiredT:%d curT:%d ", new Object[]{Long.valueOf(r100.mExpiredTime), Long.valueOf(r101)});
    }

    private static /* synthetic */ String lambda$parserResult$8(String r100, int r101) {
        return String.format(Locale.US, "get backup ip, result:%s type:%d", new Object[]{r100, Integer.valueOf(r101)});
    }

    public int start(long r100, String r110) {
        if (v2Usable == false) goto L5;
        int r101 = parserResult(r100, r110, 2, -1, -1);
    L6:
        if (r101 <= 0) goto L8;
        return r101;
    L8:
        return parserResult(r100, r110, 1, -1, -1);
    L5:
        r101 = 0;
        goto L6
    }

    private static /* synthetic */ String lambda$parserResult$9(int r100, String r101, long r102) {
        return String.format(Locale.US, "has finished not nedd cur completion code:%d result:%s expiredTime:%d", new Object[]{Integer.valueOf(r100), r101, Long.valueOf(r102)});
    }

    public int start(long r100, String r110, int r111) {
        if (v2Usable == false) goto L5;
        int r101 = parserResult(r100, r110, 2, r111, -1);
    L6:
        if (r101 <= 0) goto L8;
        return r101;
    L8:
        return parserResult(r100, r110, 1, r111, -1);
    L5:
        r101 = 0;
        goto L6
    }

    public void triggerRefresh(long r100, String r101, int r102) {
        AVMDLDNSParser.getInstance().postDNSInfoRefreshMsg(r101, r102);
    }

    private static /* synthetic */ String lambda$parserResult$7(int r100, boolean r101, String r102, int r103) {
        Locale r104 = Locale.US;
        Object[] r105 = new Object[3];
        r105[0] = Integer.valueOf(r100);
        if (r101 == false) goto L5;
        r102 = "null";
    L5:
        r105[1] = r102;
        r105[2] = Integer.valueOf(r103);
        return String.format(r104, "receive completion code:%d result:%s type:%d", r105);
    }

    public int start(long r100, String r110, int r111, int r112) {
        if (v2Usable == false) goto L5;
        int r101 = parserResult(r100, r110, 2, r111, r112);
    L6:
        if (r101 <= 0) goto L8;
        return r101;
    L8:
        return parserResult(r100, r110, 1, r111, r112);
    L5:
        r101 = 0;
        goto L6
    }

    private int parserResult(long r110, String r210, int r211, int r212, int r213) {
        AVMDLLog.d(TAG, "----start parse host:" + r210 + ",preferDNSType:" + r212 + ",taskType:" + r213);
        if (TextUtils.isEmpty(r210) == false) goto L6;
        AVMDLLog.d(TAG, "****end parse fail for host:" + r210);
        return -1;
    L6:
        this.lock.lock();
        this.handle = r110;
        int r111 = 0;
        boolean r112 = true;
        this.host = r210;     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
        final AVMDLDNSInfo r100 = IPCache.getInstance().get(r210);     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
        if (r100 == null) goto L28;
        this.ipList = r100.mIpList;     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
        final long r101 = System.currentTimeMillis();     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
        AVMDLLog.d(TAG, new b1(r100, r101));     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
        if (r100.mExpiredTime > r101) goto L12;
        AVMDLLog.d(TAG, new c1());     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
    L17:
        boolean r113 = true;
    L46:
    L26:
        e = e;
        r112 = r113;
    L33:
        AVMDLLog.e(TAG, e.toString());     // Catch: Throwable -> L30
        if (v2Usable == false) goto L36;
        v2Usable = false;     // Catch: Throwable -> L30
    L36:
        final AVMDLDNSParserBridge r102 = null;
    L37:
        this.lock.unlock();
        if (r112 == false) goto L40;
        AVMDLLog.d(TAG, new d1(r102));
        AVMDLDNSParser.getInstance().addHost(r210, r102, r212, r213);
    L41:
        AVMDLLog.d(TAG, new e1(r102));
        return r111;
    L40:
        AVMDLLog.d(TAG, "not need call add host to parser");
        goto L41
    L20:
        if (this.handle == 0) goto L25;
        AVMDLLog.d(TAG, "get cache iplist, host = " + r100.mHost + " type = " + r100.mType + " iplist = " + r100.mIpList);     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L30
        if (r211 != 1) goto L24;
        v2Usable = false;     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L30
        _notifyParserResult(this.handle, r210, this.ipList, r100.mExpiredTime, r100.mExtraInfo);     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L30
        goto L25
    L24:
        v2Usable = true;     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L30
        _notifyParserResultV2(this.handle, r210, this.ipList, r100.mExpiredTime, r100.mExtraInfo, r100.mType);     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L30
    L25:
        r102 = null;
        r112 = r113;
        r111 = 1;
        goto L37
    L12:
        if (r212 < 0) goto L18;
        if (r212 < 0) goto L17;
        if (r100.mType != r212) goto L17;
    L18:
        r113 = false;
        goto L46
    L28:
        AVMDLLog.d(TAG, "not get result from cache, need this listener");     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
        r102 = this;
    L30:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L32:
        e = e;
        goto L33
    }

    @Override // com.ss.mediakit.net.AVMDLDNSParserListener
    public void onCompletion(int r110, String r111, String r112, long r113, String r114, int r115) {
        if (this.isFinish == true) goto L8;
        if (v2Usable == false) goto L8;
        parserResult(r110, r111, r112, r113, r114, r115, 2);
    L8:
        if (this.isFinish == true) goto L11;
        parserResult(r110, r111, r112, r113, r114, r115, 1);
        return;
    }

    private void parserResult(final int r210, String r211, final String r212, final long r213, String r214, int r215, int r216) {
        this.lock.lock();
    L31:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L33:
        e = move-exception;
        AVMDLLog.d(TAG, e.toString());     // Catch: Throwable -> L31
        if (v2Usable == false) goto L37;
        v2Usable = false;     // Catch: Throwable -> L31
    L37:
        this.isFinish = false;     // Catch: Throwable -> L31
    L30:
        this.lock.unlock();
        return;
    L4:
        if (this.isFinish == true) goto L28;
        if (AVMDLLog.isLogLevelEnabled(1) == false) goto L8;
        final boolean r100 = TextUtils.isEmpty(r212);     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
        final int r101 = r215;
        AVMDLLog.d(TAG, new f1(r210, r100, r212, r101));     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
    L10:
        if (TextUtils.isEmpty(r212) == false) goto L20;
        if (AVMDLDNSParser.getIntValue(5) != 1) goto L20;
        AVMDLLog.d(TAG, "pare result is null, try get backupip");     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
        AVMDLDNSInfo r102 = IPCache.getInstance().getBackUpIp(r211);     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
        if (r102 == null) goto L20;
        final String r103 = r102.mIpList;     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
        final int r104 = r102.mType;     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
        if (AVMDLLog.isLogLevelEnabled(1) == false) goto L18;
        AVMDLLog.d(TAG, new g1(r103, r104));     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
    L18:
        int r110 = r104;
        String r111 = r103;
        long r112 = 0;
    L21:
        this.ipList = r111;     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
        this.isFinish = true;     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
        long r113 = this.handle;     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
        if (r113 == 0) goto L30;
        if (r216 != 2) goto L26;
        v2Usable = true;     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
        _notifyParserResultV2(r113, r211, r111, r112, r214, r110);     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
        goto L30
    L26:
        v2Usable = false;     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
        _notifyParserResult(r113, r211, r111, r112, r214);     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
    L20:
        r112 = r213;
        r111 = r212;
        r110 = r101;
        goto L21
    L8:
        r101 = r215;
        goto L10
    L28:
        if (AVMDLLog.isLogLevelEnabled(1) == false) goto L30;
        AVMDLLog.d(TAG, new h1(r210, r212, r213));     // Catch: Throwable -> L31 UnsatisfiedLinkError -> L33
        goto L30
    }
}
