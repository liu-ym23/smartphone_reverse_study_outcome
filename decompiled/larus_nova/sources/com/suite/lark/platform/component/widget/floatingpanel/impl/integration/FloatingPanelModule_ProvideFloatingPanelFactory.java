package com.suite.lark.platform.component.widget.floatingpanel.impl.integration;

import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import yoc.h;
import zoc.a;
import zoc.c;

/* JADX INFO: loaded from: classes36.dex */
public final class FloatingPanelModule_ProvideFloatingPanelFactory implements Factory<h> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public h get() {
        return provideFloatingPanel(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FloatingPanelModule_ProvideFloatingPanelFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static FloatingPanelModule_ProvideFloatingPanelFactory create(Provider<j> r100, Provider<v> r101) {
        return new FloatingPanelModule_ProvideFloatingPanelFactory(r100, r101);
    }

    public static h provideFloatingPanel(j r100, v r101) {
        int r102 = c.f573172a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        a r103 = new a(r100, r101);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (h) Preconditions.checkNotNullFromProvides(r103);
    }
}
