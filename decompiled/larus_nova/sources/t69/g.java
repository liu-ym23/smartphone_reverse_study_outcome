package t69;

import android.content.Context;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<h49.m> f544683a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f544684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f544685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f544686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f544687e;

    public g() {
    }

    static {
        f544683a = new CopyOnWriteArraySet();
        f544684b = true;
        f544685c = true;
    }

    public static boolean b() {
        if (f544684b == false) goto L5;
    L8:
        return true;
    L5:
        if (f544685c == true) goto L8;
        return false;
    }

    public static Triple a() {
        DoraDevice r100 = kj4.a.g().c();
        Integer r101 = null;
        if (r100 == null) goto L47;
        boolean r102 = false;
        String r103 = "";
        if (o59.a.p(r100) == false) goto L7;
        int r104 = o59.a.a(r100)[0];
    L12:
        if (o59.a.p(r100) == false) goto L14;
        int r105 = o59.a.a(r100)[1];
    L20:
        if (o59.a.p(r100) == false) goto L22;
        Integer r106 = Integer.valueOf(o59.a.a(r100)[2]);
    L24:
        if (r104 < 0) goto L27;
        if (r104 >= 101) goto L27;
        boolean r107 = true;
    L28:
        if (r107 == false) goto L30;
        Integer r108 = Integer.valueOf(r104);
    L31:
        if (r105 < 0) goto L34;
        if (r105 >= 101) goto L34;
        boolean r109 = true;
    L35:
        if (r109 == false) goto L37;
        Integer r110 = Integer.valueOf(r105);
    L38:
        IntRange r111 = new IntRange(0, 100);
        if (r106 != null) goto L41;
    L43:
        if (r102 == false) goto L48;
        r101 = r106;
    L48:
        return new Triple(r108, r110, r101);
    L41:
        if (r111.contains(r106.intValue()) == false) goto L43;
        r102 = true;
        goto L43
    L37:
        r110 = null;
    L34:
        r109 = false;
        goto L35
    L30:
        r108 = null;
    L27:
        r107 = false;
        goto L28
    L22:
        r106 = null;
        goto L24
    L14:
        Lazy r112 = com.larus.dora.impl.device.battery.k.f333616a;
        String r113 = r100.f204390sn;
        if (r113 == null) goto L18;
        r103 = r113;
    L18:
        r105 = RangesKt.coerceAtMost(com.larus.dora.impl.device.battery.k.f(r103, o59.a.a(r100), o59.a.b(r100), "UI"), 100);
        goto L20
    L7:
        Lazy r114 = com.larus.dora.impl.device.battery.k.f333616a;
        String r115 = r100.f204390sn;
        if (r115 != null) goto L10;
        r115 = "";
    L10:
        r104 = RangesKt.coerceAtMost(com.larus.dora.impl.device.battery.k.d(r115, o59.a.a(r100), o59.a.b(r100), "UI"), 100);
        goto L12
    L47:
        return new Triple(null, null, null);
    }

    public static void c(final Triple r100, boolean r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = a();
    L6:
        if ((r111 & 2) == 0) goto L9;
        r110 = false;
    L9:
        if (ObricFeatureServiceDelegate.f387839b.b() == false) goto L12;
        FLogger.f375446a.i("DoraWearStatusManager", "showBatteryToast return, suppress battery popup on Obric OS");
        return;
    L12:
        if (com.larus.dora.impl.onboarding.d.f336616a == false) goto L14;
        FLogger.f375446a.i("DoraWearStatusManager", "showBatteryToast return,  onboarding");
        return;
    L14:
        long r101 = System.currentTimeMillis();
        if (r110 == true) goto L17;
    L19:
        final DoraDevice r112 = kj4.a.g().c();
        if (r112 != null) goto L23;
        FLogger.f375446a.i("DoraWearStatusManager", "showBatteryToast return,  null device");
        return;
    L23:
        if (o59.a.l(r112) == true) goto L26;
        FLogger.f375446a.i("DoraWearStatusManager", "showBatteryToast return,  not Dora G device : " + r112.productId);
        return;
    L26:
        if ((r101 - f544686d) >= 3000) goto L28;
        FLogger.f375446a.i("DoraWearStatusManager", "showBatteryToast return,  is showing toast");
        return;
    L28:
        f544686d = r101;
        FLogger.f375446a.i("DoraWearStatusManager", "showBatteryToast leftBattery: " + r100.getFirst() + ", rightBattery: " + r100.getSecond() + ", boxBattery: " + r100.getThird());
        AppHost.Companion r113 = AppHost.f326268a;
        final Context r102 = r113.a().getCurrentActivity();
        if (r102 != null) goto L31;
        r102 = r113.getApplication();
    L31:
        r69.i r114 = r69.i.f536382a;
        DoraDevice r115 = kj4.a.g().c();
        Integer r103 = null;
        if (r115 != null) goto L34;
        final Triple r116 = new Triple(null, null, null);
    L46:
        Intrinsics.checkNotNullParameter(r112, "device");
        Intrinsics.checkNotNullParameter(r100, Scraps.BATTERY);
        Intrinsics.checkNotNullParameter(r116, "charger");
        if (r102 == null) goto L57;
        t0.e(new r69.f(r112, r100, r116, r102));
        return;
    L57:
        return;
    L34:
        if (o59.a.p(r115) == false) goto L36;
        Integer r104 = Integer.valueOf(o59.a.b(r115)[0]);
    L38:
        if (o59.a.p(r115) == false) goto L40;
        Integer r105 = Integer.valueOf(o59.a.b(r115)[1]);
    L42:
        if (o59.a.p(r115) == false) goto L44;
        r103 = Integer.valueOf(o59.a.b(r115)[2]);
    L44:
        r116 = new Triple(r104, r105, r103);
        goto L46
    L40:
        r105 = null;
        goto L42
    L36:
        r104 = null;
        goto L38
    L17:
        if ((r101 - f544686d) >= 600000) goto L19;
        FLogger.f375446a.i("DoraWearStatusManager", "showBatteryToast return,  frequency control");
    }
}
