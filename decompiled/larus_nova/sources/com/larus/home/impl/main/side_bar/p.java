package com.larus.home.impl.main.side_bar;

import com.larus.account.base.api.ILoginService;
import com.larus.business.debug.api.IDebugService;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f344760a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Boolean f344761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Integer f344762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f344763d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f344764e = null;

    public static final class a implements n38.j {
        public a() {
        }

        @Override // n38.j
        public final void a(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Object r101 = p.f344760a;
            monitor-enter(r101);
            p.f344761b = null;     // Catch: Throwable -> L8
            p.f344762c = null;     // Catch: Throwable -> L8
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r101);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // n38.j
        public final void b(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Object r101 = p.f344760a;
            monitor-enter(r101);
            p.f344761b = null;     // Catch: Throwable -> L8
            p.f344762c = null;     // Catch: Throwable -> L8
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r101);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        f344760a = new Object();
        f344763d = LazyKt.lazy(new n());
        ILoginService.a.c(ILoginService.f286097a, new a());
        f344764e = LazyKt.lazy(new o());
    }

    public static void a() {
        boolean r100 = false;
        String r101 = null;
        if (f344761b != null) goto L31;
        if (ILoginService.f286097a.getAccountInfo().f531534g == false) goto L10;
        if (((Boolean) f344763d.getValue()).booleanValue() == false) goto L10;
        Boolean r102 = Boolean.TRUE;
    L29:
        f344761b = r102;
        FLogger.f375446a.i("SideBarExp", "initEnable: " + f344761b);
    L10:
        if (AppHost.f326268a.isTestChannel() == false) goto L28;
        IDebugService r103 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r103 == null) goto L14;
        String r104 = r103.v();
    L15:
        if (r104 != null) goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == false) goto L24;
        e10 r106 = e10.f368561a;
        boolean r107 = o0.d(e10.o0().b());
    L27:
        r102 = Boolean.valueOf(r107);
        goto L29
    L24:
        if (Intrinsics.areEqual(r104, "-1") == false) goto L26;
        r107 = false;
        goto L27
    L26:
        r107 = true;
        goto L27
    L17:
        if (r104.length() == 0) goto L20;
        r105 = false;
        goto L21
    L14:
        r104 = null;
        goto L15
    L28:
        e10 r108 = e10.f368561a;
        r102 = Boolean.valueOf(o0.d(e10.o0().b()));
    L31:
        if (f344762c != null) goto L67;
        int r109 = 2;
        if (ILoginService.f286097a.getAccountInfo().f531534g == false) goto L38;
        if (((Boolean) f344763d.getValue()).booleanValue() == false) goto L38;
        int r110 = 2;
    L65:
        f344762c = r110;
        FLogger.f375446a.i("SideBarExp", "initVersion: " + f344762c);
        return;
    L38:
        if (AppHost.f326268a.isTestChannel() == false) goto L59;
        IDebugService r111 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r111 == null) goto L42;
        r101 = r111.v();
    L42:
        if (r101 != null) goto L44;
    L45:
        r100 = true;
    L46:
        if (r100 == false) goto L53;
        e10 r112 = e10.f368561a;
        String r113 = e10.o0().b();
        if (r113 == null) goto L58;
        Integer r114 = StringsKt.toIntOrNull(r113);
        if (r114 == null) goto L58;
        r109 = r114.intValue();
    L58:
        r110 = Integer.valueOf(r109);
        goto L65
    L53:
        if (Intrinsics.areEqual(r101, "-1") == true) goto L58;
        Integer r115 = StringsKt.toIntOrNull(r101);
        if (r115 == null) goto L58;
        r109 = r115.intValue();
        goto L58
    L44:
        if (r101.length() != 0) goto L46;
    L59:
        e10 r116 = e10.f368561a;
        String r117 = e10.o0().b();
        if (r117 == null) goto L64;
        Integer r118 = StringsKt.toIntOrNull(r117);
        if (r118 == null) goto L64;
        r109 = r118.intValue();
    L64:
        r110 = Integer.valueOf(r109);
        goto L65
    }

    public static uu9.a b() {
        e10 r100 = e10.f368561a;
        return e10.I();
    }

    public static int c() {
        Object r100 = f344760a;
        monitor-enter(r100);
        a();     // Catch: Throwable -> L11
        Integer r101 = f344762c;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        int r102 = r101.intValue();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);
        return r102;
    L8:
        r102 = 2;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean d() {
        Object r100 = f344760a;
        monitor-enter(r100);
        a();     // Catch: Throwable -> L11
        Boolean r101 = f344761b;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        boolean r102 = r101.booleanValue();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);
        return r102;
    L8:
        r102 = false;
    L11:
        th = move-exception;
        throw th;
    }
}
