package com.bytedance.navigation.kmp.capability.navigation;

import com.bytedance.bdnavigationsdk.z;
import com.bytedance.navigation.kmp.NavigationController;
import com.bytedance.navigation.kmp.listener.p;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f265765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<com.bytedance.bdnavigationsdk.network.route.j> f265766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f265767c;

    @Override // com.bytedance.bdnavigationsdk.z
    public final void a(com.bytedance.bdnavigationsdk.network.route.p r100) {
        Intrinsics.checkNotNullParameter(r100, "routeResponse");
        d.w(this.f265765a, r100, this.f265766b.element, this.f265767c);
    }

    @Override // com.bytedance.bdnavigationsdk.z
    public final void b(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        d37.i r101 = d37.i.f466749a;
        d37.i.g("onRoutePlanFailed: " + r100.getMessage());
        d r102 = this.f265765a;
        String r103 = r100.getMessage();
        Object r104 = r102.f265758k;
        monitor-enter(r104);
        r102.f265753f = false;     // Catch: Throwable -> L11
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r104);
        p r106 = r102.f265749b;
        if (r106 == null) goto L16;
        r106.a(r102.f265759l, 106, r103);
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public g(d r100, Ref.ObjectRef r101, NavigationController.b r102) {
        this.f265765a = r100;
        this.f265766b = r101;
        this.f265767c = r102;
    }
}
