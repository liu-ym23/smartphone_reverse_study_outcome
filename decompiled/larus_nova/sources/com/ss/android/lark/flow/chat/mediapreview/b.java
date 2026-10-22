package com.ss.android.lark.flow.chat.mediapreview;

import android.view.View;
import kza.g;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowLargeImageView f422226a;

    public b(FlowLargeImageView r100) {
        this.f422226a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FlowLargeImageView r101 = this.f422226a;
        if (r101.f422203k == false) goto L5;
    L13:
        r101.f422203k = false;
        r101.f422204l = true;
        g r102 = r101.f422202j;
        if (r102 == null) goto L16;
        r102.a(true);
    L16:
        g r103 = this.f422226a.f422202j;
        if (r103 == null) goto L22;
        r103.b(false);
        return;
    L22:
        return;
    L5:
        if (r101.f422204l == false) goto L13;
        r101.f422203k = true;
        r101.f422204l = false;
        g r104 = r101.f422202j;
        if (r104 == null) goto L10;
        r104.a(false);
    L10:
        g r105 = this.f422226a.f422202j;
        if (r105 == null) goto L20;
        r105.b(true);
        return;
    }
}
