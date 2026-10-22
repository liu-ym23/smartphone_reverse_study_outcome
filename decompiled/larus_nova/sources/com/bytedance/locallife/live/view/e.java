package com.bytedance.locallife.live.view;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes21.dex */
public final class e extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f260818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f260819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f260820c;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        r101.setRoundRect(new Rect(0, 0, (int) (this.f260819b + this.f260818a), this.f260820c), this.f260818a);
    }

    public e(float r100, int r101, int r102) {
        this.f260818a = r100;
        this.f260819b = r101;
        this.f260820c = r102;
    }
}
