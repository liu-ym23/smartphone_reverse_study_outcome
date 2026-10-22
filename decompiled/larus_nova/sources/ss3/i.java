package ss3;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f543393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IntentFilter f543394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f543395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f543396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f543397e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f543398a = null;

        static {
            f543398a = new i();
        }
    }

    public final synchronized void b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f543395c == false) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.f543395c = true;     // Catch: Exception -> L14 Throwable -> L11
        a(com.bytedance.apm.d.getContext(), this.f543393a, this.f543394b);     // Catch: Exception -> L14 Throwable -> L11
    L9:
        monitor-exit(this);
    }

    public i() {
        this.f543393a = new h(this);
        this.f543394b = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r100, h r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L34:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L39:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (r110 == null) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L23;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L34
        if (r102 != 1) goto L13;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L34
        return;
    L13:
        if (r102 != 2) goto L15;
        new Intent();     // Catch: Exception -> L34
        return;
    L15:
        if (r102 == 3) goto L41;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L34
        return;
    L41:
        return;
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L34
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L34
        return;
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
    L32:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L34
        return;
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L32;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L34
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L34
    }
}
