package com.bytedance.locallife.live.view;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes21.dex */
public final class n extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f260834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f260835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f260836c;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        r101.setRoundRect(new Rect(0, 0, this.f260835b, this.f260836c), this.f260834a);
    }

    public n(float r100, int r101, int r102) {
        this.f260834a = r100;
        this.f260835b = r101;
        this.f260836c = r102;
    }
}
