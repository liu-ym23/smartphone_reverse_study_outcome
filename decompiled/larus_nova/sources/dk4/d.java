package dk4;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import pk4.j;
import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<dk4.a> f468995a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f468996b;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            String r102 = r101.getAction();
            if ("android.intent.action.SCREEN_ON".equals(r102) == false) goto L9;
            j.d("ScreenStateUtils", LiveCommonConstants.REASON_SCREEN_ON);
            d.f468996b = 1;
            Iterator r103 = ((CopyOnWriteArraySet) d.f468995a).iterator();
        L6:
            if (r103.hasNext() == false) goto L24;
            ((dk4.a) r103.next()).onScreenOn();
            goto L6
        L24:
            return;
        L9:
            if ("android.intent.action.SCREEN_OFF".equals(r102) == false) goto L15;
            j.d("ScreenStateUtils", "screen off");
            d.f468996b = 2;
            Iterator r104 = ((CopyOnWriteArraySet) d.f468995a).iterator();
        L12:
            if (r104.hasNext() == false) goto L25;
            ((dk4.a) r104.next()).onScreenOff();
            goto L12
        L25:
            return;
        L15:
            if ("android.intent.action.USER_PRESENT".equals(r102) == false) goto L20;
            j.d("ScreenStateUtils", "user present");
            Iterator r105 = ((CopyOnWriteArraySet) d.f468995a).iterator();
        L18:
            if (r105.hasNext() == false) goto L26;
            ((dk4.a) r105.next()).a();
            goto L18
        L26:
            return;
        }
    }

    static {
        f468995a = new CopyOnWriteArraySet();
        if (((PowerManager) n.f529659c.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).isScreenOn() == false) goto L5;
        int r100 = 1;
    L6:
        f468996b = r100;
        a r101 = new a();
        IntentFilter r110 = new IntentFilter();
        r110.addAction("android.intent.action.SCREEN_ON");
        r110.addAction("android.intent.action.SCREEN_OFF");
        r110.addAction("android.intent.action.USER_PRESENT");
        Application r111 = n.f529659c;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L37;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L37:
    L31:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L36;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L36:
        throw e;
    L10:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r111).result;     // Catch: Exception -> L31
        if (r102 == 1) goto L20;
        if (r102 != 2) goto L17;
        new Intent();     // Catch: Exception -> L31
        return;
    L17:
        if (r102 == 3) goto L38;
        r111.registerReceiver(r101, r110);     // Catch: Exception -> L31
        return;
    L38:
        return;
    L20:
        r111.registerReceiver(r101, r110);     // Catch: Exception -> L31
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L25;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L31
        r111.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L31
        return;
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L27;
    L29:
        r111.registerReceiver(r101, r110);     // Catch: Exception -> L31
        return;
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L29;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L31
        ContextCompat.registerReceiver(r111, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L31
        return;
    L5:
        r100 = 2;
        goto L6
    }
}
