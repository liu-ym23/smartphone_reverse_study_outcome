package com.bytedance.navigation.kmp.capability.navigation;

import com.bytedance.bdnavigationsdk.x;
import com.bytedance.bdnavigationsdk.y;
import com.bytedance.navigation.kmp.NavigationController;
import com.bytedance.navigation.kmp.listener.p;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ouc.w;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f265761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<com.bytedance.bdnavigationsdk.network.route.j> f265762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f265763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f265764d;

    public final void a(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        d37.i r101 = d37.i.f466749a;
        d37.i.g("customProvider onRoutePlanFailed, falling back to default: " + r100.getMessage());
        d r102 = this.f265761a;
        x.f200381a.getClass();
        r102.f265751d = new y();
        d r103 = this.f265761a;
        com.bytedance.bdnavigationsdk.network.route.j r104 = this.f265762b.element;
        g r105 = this.f265764d;
        x r106 = r103.f265751d;
        if (r106 == null) goto L5;
        r106.b(r105);
    L5:
        x r107 = r103.f265751d;
        if (r107 == null) goto L9;
        r107.d(r104);
        return;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "routeResponseJson");
        com.bytedance.bdnavigationsdk.network.route.p r101 = (com.bytedance.bdnavigationsdk.network.route.p) w.a(new e()).c(com.bytedance.bdnavigationsdk.network.route.p.Companion.serializer(), r100);     // Catch: Exception -> L9
        d37.i r102 = d37.i.f466749a;     // Catch: Exception -> L9
        com.bytedance.bdnavigationsdk.network.route.d r103 = r101.f200260d;     // Catch: Exception -> L9
        if (r103 == null) goto L6;
        String r104 = r103.f200214c;     // Catch: Exception -> L9
    L7:
        d37.i.g("customProvider: parsed RouteResponse, sessionId=" + r104);     // Catch: Exception -> L9
        d.w(this.f265761a, r101, this.f265762b.element, this.f265763c);     // Catch: Exception -> L9
        return;
    L6:
        r104 = null;
    L9:
        e = move-exception;
        d37.i r105 = d37.i.f466749a;
        d37.i.g("customProvider: JSON parse error: " + e.getMessage());
        d r106 = this.f265761a;
        String r107 = "Route JSON parse error: " + e.getMessage();
        monitor-enter(r106.f265758k);
        r106.f265753f = false;     // Catch: Throwable -> L19
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L19
        p r109 = r106.f265749b;
        if (r109 == null) goto L26;
        r109.a(r106.f265759l, 106, r107);
        return;
    L26:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public f(d r100, Ref.ObjectRef r101, NavigationController.b r102, g r103) {
        this.f265761a = r100;
        this.f265762b = r101;
        this.f265763c = r102;
        this.f265764d = r103;
    }
}
