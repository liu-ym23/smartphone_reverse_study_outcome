package com.obric.oui.dialog.base;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class o implements ComponentCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractDialogModal f400728a;

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    public o(r r100) {
        this.f400728a = r100;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        final AbstractDialogModal r101 = this.f400728a;
        if (r101.f400692r == false) goto L6;
        r101.getDialogRootView().post(new l(r101));
        this.f400728a.requestApplyInsets();
        return;
    }
}
