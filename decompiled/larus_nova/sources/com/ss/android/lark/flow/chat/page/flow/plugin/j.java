package com.ss.android.lark.flow.chat.page.flow.plugin;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowRelationshipBanner f422788a;

    public j(FlowRelationshipBanner r100) {
        this.f422788a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        wya.d r101 = this.f422788a.f561891e;
        if (r101 == null) goto L6;
        r101.hide();
        return;
    }
}
