package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller;

import android.view.View;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f436280a;

    public b(a r100) {
        this.f436280a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        this.f436280a.b();
        this.f436280a.f436273j.invoke();
    }
}
