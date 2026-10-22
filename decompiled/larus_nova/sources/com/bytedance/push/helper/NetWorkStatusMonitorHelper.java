package com.bytedance.push.helper;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.push.utils.f;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.message.AppProvider;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public class NetWorkStatusMonitorHelper extends BroadcastReceiver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile NetWorkStatusMonitorHelper f266877c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f266878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<a> f266879b;

    public interface a {
        void a(String r100, String r101);
    }

    public static NetWorkStatusMonitorHelper b() {
        if (f266877c != null) goto L15;
        monitor-enter(NetWorkStatusMonitorHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f266877c != null) goto L9;
        f266877c = new NetWorkStatusMonitorHelper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetWorkStatusMonitorHelper.class);     // Catch: Throwable -> L11
    L15:
        return f266877c;
    }

    public final void c() {
        f.g("NetWorkStatusMonitorHelper", "[register]");
        NetworkInfo r100 = ((ConnectivityManager) AppProvider.getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        if (r100 == null) goto L5;
        this.f266878a = r100.getTypeName();
    L5:
        IntentFilter r101 = new IntentFilter();
        r101.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        Application r102 = AppProvider.getApp();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L38:
    L31:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L37;
        ReceiverRegisterCrashOptimizer.registerReceiver(this, r101);
    L35:
        f.g("NetWorkStatusMonitorHelper", "[register]finished register,mLastNetWorkStatus:" + this.f266878a);
        return;
    L37:
        throw e;
    L9:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r101) == false) goto L22;
        int r103 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(this, r101, 0, null, null, 2, r102).result;     // Catch: Exception -> L31
        if (r103 != 1) goto L15;
        r102.registerReceiver(this, r101);     // Catch: Exception -> L31
        goto L35
    L15:
        if (r103 != 2) goto L17;
        new Intent();     // Catch: Exception -> L31
        goto L35
    L17:
        if (r103 == 3) goto L35;
        r102.registerReceiver(this, r101);     // Catch: Exception -> L31
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L25;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L31
        r102.registerReceiver(this, r101, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L31
        goto L35
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L27;
    L29:
        r102.registerReceiver(this, r101);     // Catch: Exception -> L31
        goto L35
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r101) == false) goto L29;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L31
        ContextCompat.registerReceiver(r102, this, r101, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L31
        goto L35
    }

    private NetWorkStatusMonitorHelper() {
        this.f266878a = "";
        this.f266879b = new HashSet();
    }

    public final void a(k87.a.b r100) {
        f.g("NetWorkStatusMonitorHelper", "[addNetworkStatusListener]listener:" + r100);
        Set<a> r101 = this.f266879b;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (((HashSet) this.f266879b).size() != 0) goto L7;
        f.g("NetWorkStatusMonitorHelper", "[addNetworkStatusListener]register BroadcastReceiver");     // Catch: Throwable -> L10
        c();     // Catch: Throwable -> L10
    L7:
        ((HashSet) this.f266879b).add(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 == null) goto L27;
        String r102 = r101.getAction();
        f.b("NetWorkStatusMonitorHelper", "[onReceive]action:" + r102);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r102) == false) goto L28;
        NetworkInfo r103 = (NetworkInfo) r101.getParcelableExtra("networkInfo");
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.isConnected() == true) goto L10;
        f.g("NetWorkStatusMonitorHelper", "[onReceive]find network disconnect:" + this.f266878a);
        this.f266878a = "";
        return;
    L10:
        if (TextUtils.equals(r103.getTypeName(), this.f266878a) == true) goto L30;
        f.g("NetWorkStatusMonitorHelper", "[onReceive]network status chang to " + r103.getTypeName());
        Set<a> r104 = this.f266879b;
        monitor-enter(r104);
        Iterator r105 = ((HashSet) this.f266879b).iterator();     // Catch: Throwable -> L19
    L15:
        if (r105.hasNext() == false) goto L17;
        ((a) r105.next()).a(this.f266878a, r103.getTypeName());     // Catch: Throwable -> L19
        goto L15
    L17:
        monitor-exit(r104);     // Catch: Throwable -> L19
        this.f266878a = r103.getTypeName();
        return;
    L19:
        th = move-exception;
        throw th;
    L30:
        return;
    L28:
        return;
    }
}
