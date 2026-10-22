package com.bytedance.awemeopen.appserviceimpl.locallife;

import android.app.Activity;
import com.bytedance.awemeopen.common.service.locallife.a;
import com.bytedance.awemeopen.locallife.serviceapi.AoLocalLifeService;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class LocalLifeService implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f198134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f198135b;

    @Override // k24.a
    public final void x0() {
    }

    @Override // com.bytedance.awemeopen.common.service.locallife.a
    public final boolean isAvailable() {
        AoLocalLifeService r100 = ((com.bytedance.awemeopen.domain.locallife.a) this.f198134a.getValue()).f198416a;
        if (r100 == null) goto L5;
        boolean r101 = r100.isAvailable();
    L6:
        if (r101 == true) goto L10;
        AoHostService r102 = (AoHostService) this.f198135b.getValue();
        if (r102 == null) goto L10;
        r102.J1();
    L10:
        return r101;
    L5:
        r101 = false;
        goto L6
    }

    public LocalLifeService() {
        this.f198134a = LazyKt.lazy(LocalLifeService$domain$2.INSTANCE);
        this.f198135b = LazyKt.lazy(LocalLifeService$hostService$2.INSTANCE);
    }

    @Override // com.bytedance.awemeopen.common.service.locallife.a
    public final void B1(Activity r110, String r111, Function0<Unit> r112, Function2<? super Float, ? super Float, Unit> r113, String r114, Map<String, String> r115, Function1<? super Boolean, Unit> r116) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "schema");
        Intrinsics.checkNotNullParameter(r112, "onLocalLifeClose");
        Intrinsics.checkNotNullParameter(r113, "onShowHeightChange");
        Intrinsics.checkNotNullParameter(r116, "onExpandedStateChange");
        com.bytedance.awemeopen.domain.locallife.a r117 = (com.bytedance.awemeopen.domain.locallife.a) this.f198134a.getValue();
        r117.getClass();
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "schema");
        Intrinsics.checkNotNullParameter(r112, "onLocalLifeClose");
        Intrinsics.checkNotNullParameter(r113, "onShowHeightChange");
        Intrinsics.checkNotNullParameter(r116, "onExpandedStateChange");
        AoLocalLifeService r100 = r117.f198416a;
        if (r100 == null) goto L6;
        r100.X0(r110, r111, r112, r113, r115, r116);
        Unit r101 = Unit.INSTANCE;
        return;
    }
}
