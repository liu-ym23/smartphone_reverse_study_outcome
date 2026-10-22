package com.bytedance.ee.bear.document.sharewords.view;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Drawable f221826a;

    public a(Drawable r100) {
        this.f221826a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        this.f221826a.setBounds(0, 0, r103 - r101, r104 - r102);
    }
}
