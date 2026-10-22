package com.ss.android.ugc.route_monitor.impl.route_out.control;

import android.view.View;

/* JADX INFO: loaded from: classes40.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f454632a;

    public g(f r100) {
        this.f454632a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f r101 = this.f454632a;
        f.b r102 = r101.f454630i;
        if (r102 == null) goto L6;
        r102.a(r101);
        return;
    }
}
