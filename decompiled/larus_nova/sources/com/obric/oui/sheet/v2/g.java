package com.obric.oui.sheet.v2;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements ComponentCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OSheetModal f402967a;

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    public g(OSheetModal r100) {
        this.f402967a = r100;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        OSheetModal r101 = this.f402967a;
        r101.getClass();
        OSheetBase.DefaultImpls.t(r101);
        this.f402967a.getScaffoldController().b(this.f402967a.getFullWindowSize());
        this.f402967a.getClass();
    }
}
