package com.suite.lark.component.navroute.fragment;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class c implements a<d<?>, Fragment> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f460359a;

    @Override // com.suite.lark.component.navroute.fragment.a
    public final b b() {
        return new b(this);
    }

    public final String c() {
        return this.f460359a.getClass().getName();
    }

    @Override // com.suite.lark.component.navroute.fragment.a
    public final Fragment a() {
        return this.f460359a;
    }

    public c(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f460359a = r100;
    }
}
