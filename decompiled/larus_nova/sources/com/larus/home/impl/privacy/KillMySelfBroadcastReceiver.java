package com.larus.home.impl.privacy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Process;
import com.bytedance.apm.d;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/home/impl/privacy/KillMySelfBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KillMySelfBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f346002a = null;

    public static final class a {
        public a() {
        }

        public static String a(Context r100) {
            return r100.getPackageName() + ".permission.PRIVACY_BROADCAST";
        }

        public final void registerReceiver(Context r110) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            KillMySelfBroadcastReceiver r100 = new KillMySelfBroadcastReceiver();
            IntentFilter r101 = new IntentFilter("com.larus.nova.kill_process");
            if (Build.VERSION.SDK_INT < 34) goto L25;
            String r111 = a(r110);
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L48;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L48:
        L20:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L24;
            ReceiverRegisterCrashOptimizer.registerReceiver(r100, r101, r111, null, 4);
            return;
        L24:
            throw e;
        L8:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L10;
        L18:
            r110.registerReceiver(r100, r101, r111, null, 4);     // Catch: Exception -> L20
        L47:
            return;
        L10:
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r101) == false) goto L18;
            int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r100, r101, 4, r111, null, 5, r110).result;     // Catch: Exception -> L20
            if (r102 == 1) goto L17;
            if (r102 == 2) goto L16;
            if (r102 == 3) goto L47;
            r110.registerReceiver(r100, r101, r111, null, 4);     // Catch: Exception -> L20
            goto L47
        L16:
            new Intent();     // Catch: Exception -> L20
            goto L47
        L17:
            r110.registerReceiver(r100, r101, r111, null, 4);     // Catch: Exception -> L20
            goto L47
        L25:
            String r112 = a(r110);
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L51;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L51:
        L41:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L46;
            ReceiverRegisterCrashOptimizer.registerReceiver(r100, r101, r112, null);
            return;
        L46:
            throw e;
        L29:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L31;
        L39:
            r110.registerReceiver(r100, r101, r112, null);     // Catch: Exception -> L41
        L50:
            return;
        L31:
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r101) == false) goto L39;
            int r103 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r100, r101, 0, r112, null, 4, r110).result;     // Catch: Exception -> L41
            if (r103 == 1) goto L38;
            if (r103 == 2) goto L37;
            if (r103 == 3) goto L50;
            r110.registerReceiver(r100, r101, r112, null);     // Catch: Exception -> L41
            goto L50
        L37:
            new Intent();     // Catch: Exception -> L41
            goto L50
        L38:
            r110.registerReceiver(r100, r101, r112, null);     // Catch: Exception -> L41
            goto L50
        }
    }

    static {
        f346002a = new a();
    }

    public KillMySelfBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        d.c();
        Process.killProcess(Process.myPid());
    }
}
