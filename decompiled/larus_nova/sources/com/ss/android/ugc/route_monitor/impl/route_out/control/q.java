package com.ss.android.ugc.route_monitor.impl.route_out.control;

import android.view.View;

/* JADX INFO: loaded from: classes40.dex */
public final class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RouteOutInterceptDialog f454668a;

    public q(RouteOutInterceptDialog r100) {
        this.f454668a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        RouteOutInterceptDialog r101 = this.f454668a;
        RouteOutInterceptDialog.b r102 = r101.f454608j;
        if (r102 == null) goto L6;
        r102.a(r101);
        return;
    }
}
