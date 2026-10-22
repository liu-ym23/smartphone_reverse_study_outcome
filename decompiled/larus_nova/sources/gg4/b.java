package gg4;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f481116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f481117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f481118c;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        r101.setRoundRect(new Rect(0, 0, this.f481117b, this.f481118c), this.f481116a);
    }

    public b(float r100, int r101, int r102) {
        this.f481116a = r100;
        this.f481117b = r101;
        this.f481118c = r102;
    }
}
