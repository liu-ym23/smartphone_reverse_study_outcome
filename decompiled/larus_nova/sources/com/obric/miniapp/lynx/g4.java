package com.obric.miniapp.lynx;

import com.obric.oui.tab.OTabLayoutBase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g4 implements OTabLayoutBase.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxOUITabLayoutUI f398113a;

    @Override // com.obric.oui.tab.OTabLayoutBase.e
    public final void b(OTabLayoutBase.i r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
    }

    public g4(LynxOUITabLayoutUI r100) {
        this.f398113a = r100;
    }

    @Override // com.obric.oui.tab.OTabLayoutBase.e
    public final void a(OTabLayoutBase.i r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        LynxOUITabLayoutUI r101 = this.f398113a;
        if (r101.f398007c == false) goto L5;
        return;
    L5:
        LynxOUITabLayoutUI.N(r101, "reselect", r100);
    }

    @Override // com.obric.oui.tab.OTabLayoutBase.e
    public final void c(OTabLayoutBase.i r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        LynxOUITabLayoutUI r101 = this.f398113a;
        if (r101.f398007c == false) goto L5;
        return;
    L5:
        LynxOUITabLayoutUI.N(r101, "change", r100);
    }
}
