package com.obric.oui.sheet.v2;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements ComponentCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OSheet f402964a;

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    public c(OSheet r100) {
        this.f402964a = r100;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        OSheet r101 = this.f402964a;
        r101.getClass();
        OSheetBase.DefaultImpls.t(r101);
        this.f402964a.getScaffoldController().b(this.f402964a.f402890q);
        OSheet r102 = this.f402964a;
        xla.a r103 = r102.f402894u;
        if (r103 == null) goto L7;
        r103.a(r102, r100);
        return;
    }
}
