package com.facebook.battery.metrics.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
class TrafficStatsNetworkBytesCollector extends NetworkBytesCollector {
    private static final int TYPE_NONE = -1;
    private static final int UID = 0;
    final ConnectivityManager mConnectivityManager;
    int mCurrentNetworkType;
    private boolean mIsValid;
    BroadcastReceiver mReceiver;
    private final long[] mTotalBytes;

    @Override // com.facebook.battery.metrics.network.NetworkBytesCollector
    public boolean supportsBgDistinction() {
        return false;
    }

    public synchronized void updateTotalBytes() {
        monitor-enter(this);
        int r100 = UID;     // Catch: Throwable -> L18
        long r101 = TrafficStats.getUidTxBytes(r100);     // Catch: Throwable -> L18
        long r102 = TrafficStats.getUidRxBytes(r100);     // Catch: Throwable -> L18
        if (r102 != (-1)) goto L6;
    L15:
        this.mIsValid = false;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L6:
        if (r101 == (-1)) goto L15;
        if (this.mCurrentNetworkType != 1) goto L11;
        char r103 = 0;
    L12:
        long[] r104 = this.mTotalBytes;     // Catch: Throwable -> L18
        long r105 = r104[3] + r104[1];     // Catch: Throwable -> L18
        long r106 = r104[2] + r104[0];     // Catch: Throwable -> L18
        int r110 = r103 | 1;     // Catch: Throwable -> L18
        r104[r110] = r104[r110] + (r101 - r105);     // Catch: Throwable -> L18
        int r107 = 0 | r103;     // Catch: Throwable -> L18
        r104[r107] = r104[r107] + (r102 - r106);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L11:
        r103 = 2;
    L18:
        th = move-exception;
        throw th;
    }

    static {
        UID = Process.myUid();
    }

    public TrafficStatsNetworkBytesCollector(Context r100) {
        this.mTotalBytes = new long[8];
        this.mIsValid = true;
        this.mReceiver = new AnonymousClass1(this);
        Context r101 = r100.getApplicationContext();
        if (r101 == null) goto L5;
        r100 = r101;
    L5:
        ConnectivityManager r102 = (ConnectivityManager) r100.getSystemService("connectivity");
        this.mConnectivityManager = r102;
        NetworkInfo r103 = r102.getActiveNetworkInfo();
        if (r103 != null) goto L8;
        int r104 = -1;
    L9:
        this.mCurrentNetworkType = r104;
        INVOKEVIRTUAL_com_facebook_battery_metrics_network_TrafficStatsNetworkBytesCollector_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, this.mReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        updateTotalBytes();
        return;
    L8:
        r104 = r103.getType();
        goto L9
    }

    @Override // com.facebook.battery.metrics.network.NetworkBytesCollector
    public synchronized boolean getTotalBytes(long[] r100) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsValid == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        updateTotalBytes();     // Catch: Throwable -> L12
        System.arraycopy(this.mTotalBytes, 0, r100, 0, r100.length);     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_facebook_battery_metrics_network_TrafficStatsNetworkBytesCollector_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
