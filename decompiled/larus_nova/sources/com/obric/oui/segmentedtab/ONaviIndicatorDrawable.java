package com.obric.oui.segmentedtab;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.common.style.r;
import kotlin.Deprecated;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class ONaviIndicatorDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f402683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f402684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f402685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f402686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f402687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f402688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f402689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f402690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f402691i;
    private boolean isAnimRunning;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f402692j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f402693k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f402694l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f402695m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f402696n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f402697o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f402698p;
    private fja.d positionAnimator;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f402699q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f402700r;
    private fja.d sizeAnimator;

    public interface a {
        void a();

        void b();

        void c();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f402687e;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (int) this.f402686d;
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        if (this.f402684b != 255) goto L5;
        return -1;
    L5:
        return -3;
    }

    public ONaviIndicatorDrawable() {
        this.f402683a = new Paint();
        this.f402684b = 255;
        new Rect();
        this.f402698p = true;
        this.f402699q = 1.15f;
        this.f402700r = 0.85f;
    }

    public final boolean b() {
        return this.isAnimRunning;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f402684b;
    }

    public final void c(float r100) {
        if (this.f402689g != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.f402689g = r100;
        invalidateSelf();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void d(float r100) {
        boolean r101 = true;
        if (this.f402693k != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        this.f402693k = r100;
    L8:
        float r103 = this.f402697o;
        if (r103 == r100) goto L12;
        r101 = false;
    L12:
        if (r101 == true) goto L15;
        this.f402693k = r103;
        this.f402697o = r100;
        this.f402687e = r100;
        invalidateSelf();
        return;
    L15:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float r100 = this.f402691i;
        float r101 = (r100 + r100) + this.f402693k;
        float r102 = 2;
        float r103 = this.f402687e;
        float r104 = (r101 / r102) - (r103 / r102);
        float r105 = this.f402685c;
        r.d(r110, r105, r104, r105 + this.f402686d, r104 + r103, this.f402689g, this.f402683a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        if (r100 == this.f402684b) goto L6;
        this.f402684b = r100;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public static final void a(ONaviIndicatorDrawable r100, boolean r101) {
        r100.isAnimRunning = r101;
    }

    public final void e(float r100, float r101, float r102, float r103) {
        float r104 = this.f402696n;
        if (r104 <= 0.0f) goto L5;
        this.f402690h = this.f402694l;
        this.f402692j = r104;
        this.f402691i = this.f402695m;
    L5:
        float r105 = this.f402697o;
        if (r105 <= 0.0f) goto L8;
        this.f402693k = r105;
    L8:
        this.f402695m = r101;
        this.f402694l = r100;
        this.f402696n = r102;
        this.f402687e = r103;
        if (this.f402690h != r100) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == true) goto L14;
    L19:
        fja.d r107 = this.positionAnimator;
        if (r107 == null) goto L23;
        int r108 = fja.d.f477533d;
        r107.a(false);
    L23:
        fja.d r109 = this.sizeAnimator;
        if (r109 == null) goto L27;
        int r110 = fja.d.f477533d;
        r109.a(false);
    L27:
        float r111 = this.f402690h + ((this.f402692j * (1 - this.f402699q)) / 2.0f);
        com.obric.common.oea.foundation.animation.builder.d.a r112 = new com.obric.common.oea.foundation.animation.builder.d.a();
        r112.b(r111, this.f402694l, gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2), null);
        Function3<String, Object, Object, Unit> r113 = new ONaviIndicatorDrawable$updateBound$1(this);
        Intrinsics.checkNotNullParameter(r113, "callback");
        r112.f396382d = r113;
        this.positionAnimator = r112.a().a();
        com.obric.common.oea.foundation.animation.builder.d.a r114 = new com.obric.common.oea.foundation.animation.builder.d.a();
        r114.b(0.0f, 1.0f, gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_4, Token$Duration.OUI_ANIMATION_DURATION_VERY_LONG_2), null);
        Function3<String, Object, Object, Unit> r115 = new ONaviIndicatorDrawable$updateBound$2(this);
        Intrinsics.checkNotNullParameter(r115, "callback");
        r114.f396382d = r115;
        Function2<Boolean, Throwable, Unit> r116 = new ONaviIndicatorDrawable$updateBound$3(this);
        Intrinsics.checkNotNullParameter(r116, "callback");
        r114.f396383e = r116;
        this.sizeAnimator = r114.a().a();
        return;
    L14:
        if (this.f402692j != r102) goto L16;
        boolean r117 = true;
    L17:
        if (r117 == false) goto L19;
        invalidateSelf();
        return;
    L16:
        r117 = false;
        goto L17
    L11:
        r106 = false;
        goto L12
    }
}
