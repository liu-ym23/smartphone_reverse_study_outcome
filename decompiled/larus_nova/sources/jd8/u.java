package jd8;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.alibaba.gaiax.render.view.GXViewKey;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class u extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f498745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f498746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f498747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f498748d;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f498745a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f498745a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f498745a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.f498745a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.f498745a.getMinimumWidth();
    }

    public u(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, GXViewKey.VIEW_TYPE_SHADOW_LAYOUT);
        this.f498745a = r100;
        this.f498747c = 255;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f498746b == false) goto L5;
        return;
    L5:
        this.f498745a.setBounds(getBounds());
        if (this.f498747c >= 255) goto L8;
        int r101 = this.f498745a.getAlpha();
        this.f498745a.setAlpha((this.f498747c * r101) / 255);
        this.f498745a.draw(r100);
        this.f498745a.setAlpha(r101);
        return;
    L8:
        this.f498745a.draw(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f498745a.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f498745a.setColorFilter(r100);
    }
}
