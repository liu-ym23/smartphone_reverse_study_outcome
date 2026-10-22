package i84;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile k f488623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile l f488624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile NetworkUtils.NetworkType f488625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicInteger f488626e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f488627a;

    static {
        f488625d = NetworkUtils.NetworkType.MOBILE;
        f488626e = new AtomicInteger(0);
    }

    public l(Context r110) {
        this.f488627a = r110;
        com.bytedance.bdinstall.t.a("NetworkStatusProvider init monitor...");
        f488625d = NetworkUtils.getNetworkType(r110);
        IntentFilter r100 = new IntentFilter();
        r100.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        f488623b = new k(this);
        k r101 = f488623b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L34;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L34:
    L28:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L33;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r100);
        return;
    L33:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L19;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L19;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r100, 0, null, null, 2, r110).result;     // Catch: Exception -> L28
        if (r102 != 1) goto L12;
        r110.registerReceiver(r101, r100);     // Catch: Exception -> L28
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L28
        return;
    L14:
        if (r102 == 3) goto L35;
        r110.registerReceiver(r101, r100);     // Catch: Exception -> L28
        return;
    L35:
        return;
    L19:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L22;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L28
        r110.registerReceiver(r101, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L28
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L24;
    L26:
        r110.registerReceiver(r101, r100);     // Catch: Exception -> L28
        return;
    L24:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L26;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L28
        ContextCompat.registerReceiver(r110, r101, r100, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L28
    }

    public static l a(Context r100) {
        if (f488624c != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f488624c != null) goto L9;
        f488624c = new l(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return f488624c;
    }
}
