package ds3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<InterfaceC5704a> f469859a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f469860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f469861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f469862d;

    /* JADX INFO: renamed from: ds3.a$a, reason: collision with other inner class name */
    public interface InterfaceC5704a {
        void onChange(boolean r100);
    }

    public static class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            String r102 = r101.getAction();
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(r102) == false) goto L9;
            a.f469861c = true;
            Iterator r103 = ((ArrayList) a.f469859a).iterator();
        L6:
            if (r103.hasNext() == false) goto L17;
            ((InterfaceC5704a) r103.next()).onChange(a.f469861c);
            goto L6
        L17:
            return;
        L9:
            if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(r102) == false) goto L14;
            a.f469861c = false;
            Iterator r104 = ((ArrayList) a.f469859a).iterator();
        L12:
            if (r104.hasNext() == false) goto L18;
            ((InterfaceC5704a) r104.next()).onChange(a.f469861c);
            goto L12
        L18:
            return;
        }
    }

    static {
        f469859a = new ArrayList();
        f469860b = false;
    }

    public static boolean c(Context r100) {
        if (f469860b == true) goto L5;
        Intent r101 = a(r100, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r101 == null) goto L14;
        int r102 = r101.getIntExtra("status", -1);
        if (r102 == 2) goto L14;
        if (r102 == 5) goto L14;
        return false;
    L14:
        return true;
    L5:
        return f469861c;
    }

    public static boolean b(Context r100, InterfaceC5704a r101) {
        if (r101 == null) goto L13;
        ((ArrayList) f469859a).add(r101);
        if (f469860b == true) goto L11;
        IntentFilter r102 = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");     // Catch: Throwable -> L8
        r102.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");     // Catch: Throwable -> L8
        b r103 = new b();     // Catch: Throwable -> L8
        f469862d = r103;     // Catch: Throwable -> L8
        a(r100, r103, r102);     // Catch: Throwable -> L8
        f469861c = c(r100);     // Catch: Throwable -> L8
    L9:
        f469860b = true;
    L8:
        f469861c = true;
    L11:
        return f469861c;
    L13:
        throw new IllegalArgumentException("chargeListener can't be null");
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent a(Context r100, b r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L41:
    L35:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L39;
        throw e;
    L39:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L24;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L35
        int r103 = r102.result;     // Catch: Exception -> L35
        if (r103 == 1) goto L22;
        if (r103 == 2) goto L20;
        if (r103 == 3) goto L18;
        return r100.registerReceiver(r101, r110);
    L18:
        return r102.intent;
    L20:
        return new Intent();
    L22:
        return r100.registerReceiver(r101, r110);
    L24:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L28;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L35
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L34;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L34;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L35
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L34:
        return r100.registerReceiver(r101, r110);
    }
}
