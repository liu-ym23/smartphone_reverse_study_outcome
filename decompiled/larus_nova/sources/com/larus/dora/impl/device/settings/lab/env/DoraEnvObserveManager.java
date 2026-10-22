package com.larus.dora.impl.device.settings.lab.env;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.settings.lab.env.override.EnvObserveOverrideChangeReason;
import com.larus.dora.impl.device.settings.lab.env.override.EnvObserveWearState;
import com.larus.dora.impl.device.settings.lab.env.timer.TimerJob;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraEnvObserveManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraEnvObserveManager f334593a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f334594b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Function0<p49.a>> f334595c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f334596d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f334597e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Job f334598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f334599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f334600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f334601i = null;

    public DoraEnvObserveManager() {
    }

    static {
        f334593a = new DoraEnvObserveManager();
        f334594b = LazyKt.lazy(new a());
        f334595c = CollectionsKt.listOf(new Function0[]{new e(), new f(), new g(), new h(), new i(), new j()});
        f334596d = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        f334597e = new AtomicBoolean(false);
        f334601i = LazyKt.lazy(new k());
    }

    public static boolean c() {
        IDoraPageConfig r100 = (IDoraPageConfig) o49.b.f522007b.a().f522009a.getValue();
        if (r100 == null) goto L5;
        boolean r101 = r100.d("dora_g_config_key_env_observe_enable", false);
    L6:
        boolean r102 = TimerJob.f334643j.a().e(Calendar.getInstance());
        com.larus.dora.impl.device.settings.lab.env.wifi.c.a r103 = com.larus.dora.impl.device.settings.lab.env.wifi.c.f334702a;
        if (com.larus.dora.impl.device.settings.lab.env.wifi.c.f334703b != null) goto L17;
        monitor-enter(r103);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (com.larus.dora.impl.device.settings.lab.env.wifi.c.f334703b != null) goto L12;
        com.larus.dora.impl.device.settings.lab.env.wifi.c.f334703b = new com.larus.dora.impl.device.settings.lab.env.wifi.c();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r103);
    L17:
        boolean r104 = o59.a.k(kj4.a.g().c());
        q49.a.f531706b.a();
        boolean r105 = NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication());
        DoraDevice r106 = DoraAdapterExtKt.h(kj4.a.g());
        if (r106 == null) goto L24;
        String r107 = r106.f204389mac;
        if (r107 == null) goto L24;
        f334593a.getClass();
        if (f().d(r107) != true) goto L24;
        boolean r108 = true;
    L25:
        int r109 = x.f334704a;
        if (r102 == true) goto L30;
        if (r108 == true) goto L30;
        boolean r110 = false;
    L31:
        if (r106 != null) goto L33;
    L35:
        boolean r111 = false;
    L36:
        g49.d.d("DoraEnvObserveManager", "canEntryEnvObserve: enableCanEntry=" + r101 + ", timeCanEntry=" + r102 + ", temporaryOverrideActive=" + r108 + ", timeGateAvailable=" + r110 + ", wifiCanEntry=true, isLinkConnect=" + r104 + ", networkReady=" + r105 + ", isGDevice=" + r111);
        if (r101 == false) goto L46;
        if (r110 == false) goto L47;
        if (r104 == false) goto L48;
        if (r105 == false) goto L49;
        if (r111 == false) goto L50;
        return true;
    L50:
        return false;
    L49:
        return false;
    L48:
        return false;
    L47:
        return false;
    L46:
        return false;
    L33:
        if (o59.a.l(r106) != true) goto L35;
        r111 = true;
    L30:
        r110 = true;
    L24:
        r108 = false;
        goto L25
    L5:
        r101 = false;
        goto L6
    }

    public static r49.d f() {
        return (r49.d) f334601i.getValue();
    }

    public static String e() {
        DoraDevice r100 = DoraAdapterExtKt.h(kj4.a.g());
        if (r100 == null) goto L6;
        String r101 = r100.f204389mac;
        if (r101 == null) goto L6;
        return r101;
    L6:
        DoraDevice r102 = kj4.a.g().c();
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.f204389mac;
    }

    public static void a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "mac");
        Iterator<T> r100 = kj4.a.g().getDoraBindList().iterator();
    L3:
        Long r101 = null;
        if (r100.hasNext() == false) goto L8;
        Object r102 = r100.next();
        if (Intrinsics.areEqual(((DoraDevice) r102).f204389mac, r110) == false) goto L3;
    L9:
        DoraDevice r103 = (DoraDevice) r102;
        if (r103 == null) goto L15;
        int[] r104 = r103.wearState;
        if (r104 == null) goto L15;
    L18:
        r49.d r105 = f();
        int r106 = r49.d.f536102j;
        if (r104 == null) goto L21;
        Integer r107 = ArraysKt.getOrNull(r104, 0);
    L22:
        if (r104 == null) goto L24;
        Integer r108 = ArraysKt.getOrNull(r104, 1);
    L25:
        EnvObserveWearState r109 = r49.d.a.a(r107, r108);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r110, "mac");
        long r111 = r105.f536103a.invoke().longValue();
        Object r112 = r105.f536108f;
        monitor-enter(r112);
        if (r109 == null) goto L41;
    L31:
        r105.f536110h.put(r110, r109);     // Catch: Throwable -> L38
        long r113 = r111 + RangesKt.coerceAtLeast(r105.f536105c.invoke().longValue(), 1);     // Catch: Throwable -> L38
        if (r109 != EnvObserveWearState.UNWORN) goto L34;
        r101 = Long.valueOf(r111);     // Catch: Throwable -> L38
    L34:
        r49.d.b r114 = new r49.d.b(r113, r101, RangesKt.coerceAtLeast(r105.f536106d.invoke().longValue(), 1), r105.e(r110));     // Catch: Throwable -> L38
        r105.f536109g.put(r110, r114);     // Catch: Throwable -> L38
        monitor-exit(r112);
        r105.f(r110, r114);
        r105.f536107e.invoke(r110, EnvObserveOverrideChangeReason.ACTIVATED);
        return;
    L38:
        th = move-exception;
        throw th;
    L41:
        r109 = (EnvObserveWearState) ((LinkedHashMap) r105.f536110h).get(r110);     // Catch: Throwable -> L38
        if (r109 != null) goto L31;
        r109 = EnvObserveWearState.UNKNOWN;     // Catch: Throwable -> L38
        goto L31
    L24:
        r108 = null;
        goto L25
    L21:
        r107 = null;
    L15:
        if (Intrinsics.areEqual(e(), r110) == false) goto L17;
        r104 = kj4.a.g().C();
        goto L18
    L17:
        r104 = null;
        goto L18
    L8:
        r102 = null;
        goto L9
    }

    public static boolean b(EnvObserveChangeReason r100) {
        boolean r101 = com.larus.dora.impl.onboarding.d.f336616a;
        if (com.larus.dora.impl.onboarding.d.f336617b == false) goto L7;
        g(r100, "ONBOARDING");
        return false;
    L7:
        if (f334599g == true) goto L10;
        g(r100, "LINK_NOT_READY");
        return false;
    L10:
        DoraDevice r102 = DoraAdapterExtKt.h(kj4.a.g());
        if (r102 != null) goto L13;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == false) goto L19;
        g(r100, "NOT_DORA_G");
        return false;
    L19:
        return true;
    L13:
        if (o59.a.l(r102) == true) goto L15;
        r103 = true;
        goto L16
    }

    public static void d(String r100, EnvObserveSettingAction r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        int r102 = x.f334704a;
        Intrinsics.checkNotNullParameter(r101, "action");
        switch(x.a.f334705a[r101.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
        return;
    L10:
        if (r100 == null) goto L13;
        f334593a.getClass();
        f().a(r100, EnvObserveOverrideChangeReason.USER_SETTING);
        return;
    L13:
        return;
    L7:
        r103 = true;
        goto L8
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static void g(EnvObserveChangeReason r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        g49.d.d("DoraEnvObserveManager", "env change ignored, reason=" + p49.b.a(r100) + ", reject=" + r101);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void h(EnvObserveChangeReason r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (b(r100) == true) goto L5;
        return;
    L5:
        g49.d.d("DoraEnvObserveManager", "env change due to: ".concat(p49.b.a(r100)));
        Iterator r102 = ((CopyOnWriteArraySet) f334594b.getValue()).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((u39.b) r102.next()).a(c(), r100, r101);
        goto L7
    }

    public static void i(boolean r100, EnvObserveChangeReason r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        if (b(r101) == true) goto L6;
        return;
    L6:
        if (r101 != EnvObserveChangeReason.DEVICE_CHANGE) goto L8;
        f334600h = r100;
    L8:
        Iterator r103 = ((CopyOnWriteArraySet) f334594b.getValue()).iterator();
    L10:
        if (r103.hasNext() == false) goto L18;
        u39.b r104 = (u39.b) r103.next();
        if (r100 == true) goto L14;
    L16:
        boolean r105 = false;
    L17:
        r104.a(r105, r101, r102);
        goto L10
    L14:
        if (c() == false) goto L16;
        r105 = true;
        goto L17
    }
}
