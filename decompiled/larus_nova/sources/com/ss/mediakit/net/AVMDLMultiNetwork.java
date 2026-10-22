package com.ss.mediakit.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.Locale;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLMultiNetwork {
    public static final int MSG_IS_NETWORK_AVAILABLE = 0;
    public static final int MSG_IS_NETWORK_CHANGED = 3;
    public static final int MSG_IS_SWITCH_TO_CELLULAR_NETWORK = 1;
    public static final int MSG_IS_SWITCH_TO_DEFAULT_NETWORK = 2;
    private static final String TAG = "AVMDLMultiNetwork";
    static Runnable loopRefreshRunnable = null;
    private static Network mCellularNetwork = null;
    private static ConnectivityManager mCm = null;
    private static long mCurNetId = 0;
    private static Network mCurNetwork = null;
    protected static Handler mHandler = null;
    private static boolean mIsIPv4Reachable = true;
    private static boolean mIsIPv6Reachable = true;
    public static final int mLoopIpRefreshInterval = 60000;
    private static HandlerThread mThread;

    /* JADX INFO: renamed from: com.ss.mediakit.net.AVMDLMultiNetwork$4, reason: invalid class name */
    public static class AnonymousClass4 extends Handler {
        public static /* synthetic */ String a(int r100, Network r101) {
            return lambda$handleMessage$1(r100, r101);
        }

        public static /* synthetic */ String b(int r100, Network r101) {
            return lambda$handleMessage$0(r100, r101);
        }

        public AnonymousClass4(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            Object r101 = r100.obj;
            if (r101 == null) goto L5;
            final Network r102 = (Network) r101;
        L7:
            if (AVMDLLog.isLogLevelEnabled(1) == false) goto L9;
            final int r103 = r100.what;
            AVMDLLog.d(AVMDLMultiNetwork.TAG, new g2(r103, r102));
        L9:
            int r104 = r100.what;
            if (r104 == 0) goto L20;
            if (r104 != 1) goto L13;
            AVMDLMultiNetwork.access$200();
        L22:
            if (AVMDLLog.isLogLevelEnabled(1) == false) goto L25;
            final int r105 = r100.what;
            AVMDLLog.d(AVMDLMultiNetwork.TAG, new h2(r105, r102));
            return;
        L25:
            return;
        L13:
            if (r104 != 2) goto L15;
            AVMDLMultiNetwork.access$300();
            goto L22
        L15:
            if (r104 != 3) goto L22;
            AVMDLMultiNetwork.refreshIpReachable();
            goto L22
        L20:
            AVMDLMultiNetwork.access$100(r102);
            goto L22
        L5:
            r102 = null;
            goto L7
        }

        private static /* synthetic */ String lambda$handleMessage$0(int r100, Network r101) {
            return String.format(Locale.US, "----receive msg what:%d info:%s", new Object[]{Integer.valueOf(r100), r101});
        }

        private static /* synthetic */ String lambda$handleMessage$1(int r100, Network r101) {
            return String.format(Locale.US, "****end proc msg what:%d info:%s", new Object[]{Integer.valueOf(r100), r101});
        }
    }

    public AVMDLMultiNetwork() {
    }

    public static void refreshIpReachable() {
    }

    static {
        loopRefreshRunnable = new AnonymousClass1();
    }

    public static Network getCellularNetwork() {
        monitor-enter(AVMDLMultiNetwork.class);
        Network r100 = mCellularNetwork;     // Catch: Throwable -> L7
        monitor-exit(AVMDLMultiNetwork.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static Network getCurNetwork() {
        monitor-enter(AVMDLMultiNetwork.class);
        Network r100 = mCurNetwork;     // Catch: Throwable -> L7
        monitor-exit(AVMDLMultiNetwork.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean isIPv4Reachable() {
        monitor-enter(AVMDLMultiNetwork.class);
        boolean r100 = mIsIPv4Reachable;     // Catch: Throwable -> L7
        monitor-exit(AVMDLMultiNetwork.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean isIPv6Reachable() {
        monitor-enter(AVMDLMultiNetwork.class);
        boolean r100 = mIsIPv6Reachable;     // Catch: Throwable -> L7
        monitor-exit(AVMDLMultiNetwork.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static void switchToCellularNetwork() {
        if (mHandler == null) goto L6;
        Message r100 = new Message();
        r100.what = 1;
        mHandler.sendMessage(r100);
        AVMDLLog.d(TAG, "send msg of switch to cellular network");
        return;
    }

    public static void switchToDefaultNetwork() {
        if (mHandler == null) goto L6;
        Message r100 = new Message();
        r100.what = 2;
        mHandler.sendMessage(r100);
        AVMDLLog.d(TAG, "send msg of switch to default network");
        return;
    }

    private static void switchToCellularNetworkInternal() {
        Network r100 = getCellularNetwork();
        if (r100 != null) goto L5;
        return;
    L5:
        long r101 = getNetId(r100);
        AVMDLLog.d(TAG, "try switch to cellular curNetId: " + mCurNetId + " netId:" + r101);
        if (mCurNetId == r101) goto L8;
        AVMDLLog.d(TAG, "do switch");
        IPCache.getInstance().clear();
        int r102 = AVMDLDataLoader.getInstance().onCellularAlwaysUp(NetUtils.getNetId(r100));
        mCurNetId = r101;
        setCurNetwork(r100);
    L9:
        AVMDLLog.d(TAG, "end switch to cellular, ret:" + r102);
        return;
    L8:
        AVMDLLog.d(TAG, "cur is cellular, not need switch");
        r102 = 0;
        goto L9
    }

    private static void switchToDefaultNetworkInternal() {
        AVMDLLog.d(TAG, "try switch to default network");
        if (mCurNetId == 0) goto L5;
        AVMDLLog.d(TAG, "do switch");
        IPCache.getInstance().clear();
        AVMDLDataLoader.getInstance().onCellularAlwaysUp(0);
        mCurNetId = 0;
        setCurNetwork(null);
    L5:
        AVMDLLog.d(TAG, "end try switch to default network");
    }

    public static /* synthetic */ ConnectivityManager access$000() {
        return mCm;
    }

    public static /* synthetic */ void access$200() {
        switchToCellularNetworkInternal();
    }

    public static /* synthetic */ void access$300() {
        switchToDefaultNetworkInternal();
    }

    public static /* synthetic */ void access$100(Network r100) {
        onAvailableInternal(r100);
    }

    public static boolean alwayUpCellular(Context r100) {
        initHandler(r100);
        if (mCm != null) goto L6;
        AVMDLLog.d(TAG, "cm is null");
        return false;
    L6:
        NetworkRequest r101 = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        mCm.requestNetwork(r101, new AnonymousClass3());     // Catch: Exception -> L10
        return true;
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static long getNetId(Network r100) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return r100.getNetworkHandle();
    L7:
        return CastIntegerProtector.parseInt(r100.toString());
    }

    private static void initHandler(Context r100) {
        monitor-enter(AVMDLMultiNetwork.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (mThread != null) goto L7;
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2(TAG);     // Catch: Throwable -> L13
        mThread = r101;     // Catch: Throwable -> L13
        ThreadMethodProxy.start(r101);     // Catch: Throwable -> L13
        mHandler = new AnonymousClass4(mThread.getLooper());     // Catch: Throwable -> L13
    L7:
        if (r100 != null) goto L9;
    L11:
        monitor-exit(AVMDLMultiNetwork.class);     // Catch: Throwable -> L13
        return;
    L9:
        if (mCm != null) goto L11;
        mCm = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L13
        goto L11
    }

    private static void onAvailableInternal(Network r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (mCm != null) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT >= 29) goto L9;
        NetworkInfo r101 = mCm.getNetworkInfo(r100);
    L10:
        AVMDLLog.d(TAG, "start on available");
        if (r101 == null) goto L13;
        AVMDLLog.d(TAG, "network name: " + r101.getTypeName() + "[" + r101.getSubtypeName() + "], state: " + r101.getDetailedState() + " netid:" + getNetId(r100));
    L13:
        NetworkCapabilities r102 = mCm.getNetworkCapabilities(r100);
        if (r102 != null) goto L16;
    L20:
        AVMDLDataLoader.getInstance().onCellularAlwaysUp(0);
    L21:
        AVMDLLog.d(TAG, "end on available");
        return;
    L16:
        if (r102.hasTransport(0) == false) goto L20;
        if (r102.hasCapability(12) == false) goto L20;
        onCellularNetwork(r100);
        AVMDLDataLoader.getInstance().onInitMultiNetworkEnv();
        goto L21
    L9:
        r101 = null;
        goto L10
    }

    public static void onCellularNetwork(Network r100) {
        monitor-enter(AVMDLMultiNetwork.class);
        mCellularNetwork = r100;     // Catch: Throwable -> L7
        monitor-exit(AVMDLMultiNetwork.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean registerNetworkChangeCallback(Context r100) {
        initHandler(r100);
        if (mCm != null) goto L6;
        AVMDLLog.d(TAG, "cm is null");
        return false;
    L6:
        NetworkRequest r101 = new NetworkRequest.Builder().build();
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    L8:
        if (AVMDLDataLoader.getInstance().getConfig().mEnableNetworkChangeNotify != 1) goto L10;
        mCm.registerNetworkCallback(r101, new AnonymousClass2());     // Catch: Exception -> L11
    L10:
        return true;
    }

    public static void setCurNetwork(Network r100) {
        monitor-enter(AVMDLMultiNetwork.class);
        mCurNetwork = r100;     // Catch: Throwable -> L7
        monitor-exit(AVMDLMultiNetwork.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setIPv4Reachable(boolean r100) {
        monitor-enter(AVMDLMultiNetwork.class);
        mIsIPv4Reachable = r100;     // Catch: Throwable -> L7
        monitor-exit(AVMDLMultiNetwork.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setIPv6Reachable(boolean r100) {
        monitor-enter(AVMDLMultiNetwork.class);
        mIsIPv6Reachable = r100;     // Catch: Throwable -> L7
        monitor-exit(AVMDLMultiNetwork.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
