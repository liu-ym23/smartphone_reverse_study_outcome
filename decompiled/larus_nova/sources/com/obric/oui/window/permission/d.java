package com.obric.oui.window.permission;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrivacyStatementActivity f403791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f403792b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        PrivacyStatementActivity r100 = this.f403791a;
        Map<String, PrivacyStatementActivity.c> r101 = PrivacyStatementActivity.f403762i;
        r100.A1();
        final PrivacyStatementActivity r102 = this.f403791a;
        if (r102.f403772f == false) goto L5;
        return true;
    L5:
        r102.f403772f = true;
        this.f403792b.post(new c(r102));
        return true;
    }

    public d(PrivacyStatementActivity r100, View r101) {
        this.f403791a = r100;
        this.f403792b = r101;
    }
}
