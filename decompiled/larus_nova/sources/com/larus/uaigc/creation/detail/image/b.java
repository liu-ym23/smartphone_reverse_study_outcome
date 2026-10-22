package com.larus.uaigc.creation.detail.image;

import android.view.View;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements l19.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsBigImageDetailFragment f372819a;

    @Override // l19.f
    public final void onTransitionChanged(int r100, float r101) {
    }

    public b(AbsBigImageDetailFragment r100) {
        this.f372819a = r100;
    }

    @Override // l19.f
    public final void onTransitionBegin(int r100) {
        View r101 = this.f372819a.f372800j;
        if (r101 == null) goto L6;
        r101.setVisibility(8);
        return;
    }

    @Override // l19.f
    public final void onTransitionEnd(int r100) {
        View r101 = this.f372819a.f372800j;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
        return;
    }
}
