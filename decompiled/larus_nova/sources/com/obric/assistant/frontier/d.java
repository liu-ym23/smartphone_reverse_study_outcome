package com.obric.assistant.frontier;

import com.larus.common.apphost.AppHost;
import com.larus.platform.api.j2;
import com.larus.utils.logger.FLogger;
import hm9.j;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f389296a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f389297b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f389298c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f389299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f389300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Job f389301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Job f389302g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f389303h = null;

    /* JADX INFO: loaded from: classes5.dex */
    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            FLogger.f375446a.i("ObricFrontierStatusMonitor", "reconnect Frontier after login, scene=" + r100.f364879e);
            Lazy r101 = d.f389296a;
            com.larus.im.f r102 = d.c();
            if (r102 == null) goto L6;
            r102.l(null, "onUserDidOnline");
            return;
        }
    }

    public d() {
    }

    static {
        f389296a = LazyKt.lazy(new com.obric.assistant.frontier.a());
        f389297b = LazyKt.lazy(new b());
        f389298c = LazyKt.lazy(new c());
        f389299d = true;
        f389303h = new a();
    }

    public static boolean b() {
        boolean r100 = false;
        if (f389299d == true) goto L5;
    L21:
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("canDisconnectForObric res = ");
        r102.append(r100);
        r102.append(", obricAssistantDeactive = ");
        r102.append(f389299d);
        r102.append(", mode = ");
        r102.append(j.f485966h.f485995y);
        r102.append(", screenOff = ");
        r102.append(f389300e);
        r102.append(", dora wakeState = ");
        j2 r103 = (j2) f389297b.getValue();
        if (r103 == null) goto L24;
        Integer r104 = r103.h();
    L25:
        r102.append(r104);
        r102.append(", appBackground = ");
        r102.append(AppHost.f326268a.a().isAppBackground());
        r102.append(", canDisableOnBackground = true");
        r101.i("ObricFrontierStatusMonitor", r102.toString());
        return r100;
    L24:
        r104 = null;
        goto L25
    L5:
        if (j.f485966h.f485995y == 2) goto L9;
        if (f389300e == false) goto L21;
    L9:
        if (AppHost.f326268a.a().isAppBackground() == false) goto L21;
        j2 r105 = (j2) f389297b.getValue();
        if (r105 == null) goto L18;
        Integer r106 = r105.h();
        if (r106 == null) goto L18;
        if (r106.intValue() != 2) goto L18;
        boolean r107 = true;
    L19:
        if (r107 == true) goto L21;
        r100 = true;
    L18:
        r107 = false;
        goto L19
    }

    public static com.larus.im.f c() {
        return (com.larus.im.f) f389296a.getValue();
    }

    public static final void a(String r100) {
        com.larus.im.f r101 = c();
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.c());
    L6:
        if (r102 != null) goto L9;
    L13:
        FLogger.f375446a.i("ObricFrontierStatusMonitor", "ensureConnected skip, state=" + r102 + ", reason=" + r100);
        return;
    L9:
        if (r102.intValue() != 0) goto L13;
        com.larus.im.f r103 = c();
        if (r103 == null) goto L15;
        r103.l(null, r100);
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
