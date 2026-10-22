package com.bytedance.awemeopen.appserviceimpl.ecom;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.ecom.serviceapi.AoEcomService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import s24.a;

/* JADX INFO: loaded from: classes44.dex */
public final class EcomService implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f198095a;

    @Override // k24.a
    public final void x0() {
    }

    public final t34.a f() {
        return (t34.a) this.f198095a.getValue();
    }

    public EcomService() {
        this.f198095a = LazyKt.lazy(EcomService$domain$2.INSTANCE);
    }

    @Override // s24.a
    public final boolean e() {
        AoEcomService r100 = f().f544437a;
        if (r100 == null) goto L7;
        r100.e();
        return true;
    L7:
        return true;
    }

    @Override // s24.a
    public final String g() {
        AoEcomService r100 = f().f544437a;
        if (r100 == null) goto L6;
        String r101 = r100.g();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // s24.a
    public final boolean isAvailable() {
        AoEcomService r100 = f().f544437a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isAvailable();
    }

    @Override // s24.a
    public final void j(FragmentActivity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "schema");
        t34.a r102 = f();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "schema");
        AoEcomService r103 = r102.f544437a;
        if (r103 == null) goto L6;
        r103.j(r100, r101);
        Unit r104 = Unit.INSTANCE;
        return;
    }

    @Override // s24.a
    public final void V2(Activity r110, String r111, Function0<Unit> r112, Function2<? super Float, ? super Float, Unit> r113, Function1<? super Boolean, Unit> r114, Map<String, String> r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "schema");
        Intrinsics.checkNotNullParameter(r112, "onEcomClose");
        Intrinsics.checkNotNullParameter(r113, "onShowHeightChange");
        Intrinsics.checkNotNullParameter(r114, "onPageExpandedStateChange");
        t34.a r117 = f();
        r117.getClass();
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "schema");
        Intrinsics.checkNotNullParameter(r112, "onEcomClose");
        Intrinsics.checkNotNullParameter(r113, "onShowHeightChange");
        Intrinsics.checkNotNullParameter(r114, "onPageExpandedStateChange");
        AoEcomService r100 = r117.f544437a;
        if (r100 == null) goto L6;
        r100.K1(r110, r111, r112, r113, r114);
        Unit r101 = Unit.INSTANCE;
        return;
    }

    @Override // s24.a
    public final void c1(Activity r110, String r111, Function0<Unit> r112, Function2<? super Float, ? super Float, Unit> r113, Function1<? super Boolean, Unit> r114, Map<String, String> r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "schema");
        Intrinsics.checkNotNullParameter(r112, "onEcomClose");
        Intrinsics.checkNotNullParameter(r113, "onShowHeightChange");
        Intrinsics.checkNotNullParameter(r114, "onPageExpandedStateChange");
        t34.a r117 = f();
        r117.getClass();
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "schema");
        Intrinsics.checkNotNullParameter(r112, "onEcomClose");
        Intrinsics.checkNotNullParameter(r113, "onShowHeightChange");
        Intrinsics.checkNotNullParameter(r114, "onPageExpandedStateChange");
        AoEcomService r100 = r117.f544437a;
        if (r100 == null) goto L6;
        r100.w(r110, r111, r112, r113, r114);
        Unit r101 = Unit.INSTANCE;
        return;
    }
}
