package com.bytedance.android.shopping.deepfeed.utlis;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public static boolean b;
    public static VolumeBroadcastReceiver c;
    public static Boolean d;
    public final b a;

    public static final class a {
    }

    public static final class b implements i {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.deepfeed.utlis.i
        public final void a(int r2) {
            this.a.invoke(Integer.valueOf(r2));
        }
    }

    static {
        b = true;
    }

    public final void b() {
        VolumeBroadcastReceiver r0 = c;
        if (r0 == null) goto L6;
        final b r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "listener");
        r0.a(new VolumeBroadcastReceiver$removeListener$1(r1));
        return;
    }

    public f(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = new b(r2);
    }

    public final void a(Context r10) {
        if (c == null) goto L5;
    L44:
        VolumeBroadcastReceiver r11 = c;
        if (r11 == null) goto L51;
        final b r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "listener");
        r11.a(new VolumeBroadcastReceiver$addListener$1(r0));
        r11.a.add(new WeakReference(r0));
        return;
    L51:
        return;
    L5:
        if (r10 == null) goto L7;
        Context r2 = r10.getApplicationContext();
    L8:
        VolumeBroadcastReceiver r1 = new VolumeBroadcastReceiver(r2);
        if (r10 == null) goto L43;
        Context r12 = r10.getApplicationContext();
        if (r12 == null) goto L43;
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.media.VOLUME_CHANGED_ACTION");
        Unit r3 = Unit.INSTANCE;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L49;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L49:
    L38:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.registerReceiver(r1, r8);
        goto L43
    L42:
        throw e;
    L16:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L29;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r8) == false) goto L29;
        int r4 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r1, r8, 0, null, null, 2, r12).result;     // Catch: Exception -> L38
        if (r4 != 1) goto L22;
        r12.registerReceiver(r1, r8);     // Catch: Exception -> L38
    L48:
        goto L43
    L22:
        if (r4 != 2) goto L24;
        new Intent();     // Catch: Exception -> L38
        goto L48
    L24:
        if (r4 == 3) goto L48;
        r12.registerReceiver(r1, r8);     // Catch: Exception -> L38
    L29:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L32;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L38
        r12.registerReceiver(r1, r8, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L38
        goto L48
    L32:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L34;
    L36:
        r12.registerReceiver(r1, r8);     // Catch: Exception -> L38
        goto L48
    L34:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r8) == false) goto L36;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L38
        ContextCompat.registerReceiver(r12, r1, r8, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L38
    L43:
        c = r1;
        goto L44
    L7:
        r2 = null;
        goto L8
    }
}
