package q36;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.ies.bullet.service.receiver.headset.HeadSetReceiver;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f531514a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HeadSetReceiver f531515b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f531516c;

    public a() {
    }

    static {
        f531514a = new a();
        f531515b = new HeadSetReceiver();
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r100, HeadSetReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
