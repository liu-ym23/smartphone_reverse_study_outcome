package com.bytedance.caijing.sdk.infra.base.api.plugin.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
public final class PlugInReceiverManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PlugInReceiverManager f202242a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<a, HostReceiver> f202243b = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/receiver/PlugInReceiverManager$HostReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
    public static final class HostReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f202244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f202245b;

        public final Context getContext() {
            return this.f202245b;
        }

        public HostReceiver(a r100, Context r101) {
            this.f202244a = r100;
            this.f202245b = r101;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            a r102 = this.f202244a;
            if (r102 == null) goto L6;
            r102.onReceive(r100, r101);
            return;
        }
    }

    public interface a {
        void onReceive(Context r100, Intent r101);
    }

    public PlugInReceiverManager() {
    }

    static {
        f202242a = new PlugInReceiverManager();
        f202243b = new HashMap();
    }

    public final void unregisterReceiver(a r100) {
        HostReceiver r101 = f202243b.remove(r100);
        if (r101 == null) goto L18;
        Context r102 = r101.getContext();
        if (r102 == null) goto L19;
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L16;
        r102.unregisterReceiver(r101);
        return;
    L16:
    L12:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r101.toString());
        e.printStackTrace();
        return;
    L9:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r102) == false) goto L20;
        r102.unregisterReceiver(r101);     // Catch: Exception -> L12
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void registerReceiver(Context r110, a r111, IntentFilter r112, String r113, Handler r210) {
        HostReceiver r114 = new HostReceiver(r111, r110);
        f202243b.put(r111, r114);
        if (Build.VERSION.SDK_INT < 34) goto L27;
        if (r110 != null) goto L6;
        return;
    L6:
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L55;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L55:
    L22:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L26;
        ReceiverRegisterCrashOptimizer.registerReceiver(r114, r112, r113, r210, 4);
        return;
    L26:
        throw e;
    L9:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (r112 == null) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r112) == false) goto L20;
        int r100 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r114, r112, 4, r113, r210, 5, r110).result;     // Catch: Exception -> L22
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L54;
        r110.registerReceiver(r114, r112, r113, r210, 4);     // Catch: Exception -> L22
    L54:
        return;
    L18:
        new Intent();     // Catch: Exception -> L22
        goto L54
    L19:
        r110.registerReceiver(r114, r112, r113, r210, 4);     // Catch: Exception -> L22
    L20:
        r110.registerReceiver(r114, r112, r113, r210, 4);     // Catch: Exception -> L22
        goto L54
    L27:
        if (r110 != null) goto L29;
        return;
    L29:
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L52;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L52:
    L45:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L49;
        ReceiverRegisterCrashOptimizer.registerReceiver(r114, r112, r113, r210);
        return;
    L49:
        throw e;
    L32:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L43;
        if (r112 == null) goto L43;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r112) == false) goto L43;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r114, r112, 0, r113, r210, 4, r110).result;     // Catch: Exception -> L45
        if (r101 == 1) goto L42;
        if (r101 == 2) goto L41;
        if (r101 == 3) goto L51;
        r110.registerReceiver(r114, r112, r113, r210);     // Catch: Exception -> L45
    L51:
        return;
    L41:
        new Intent();     // Catch: Exception -> L45
        goto L51
    L42:
        r110.registerReceiver(r114, r112, r113, r210);     // Catch: Exception -> L45
    L43:
        r110.registerReceiver(r114, r112, r113, r210);     // Catch: Exception -> L45
        goto L51
    }
}
