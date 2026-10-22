package com.obric.oui.lisitem;

import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.layout.OUIFrameLayout;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f401390h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f401391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GradientDrawable f401392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f401393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f401394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f401395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f401396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public fja.d f401397g;

    public static final class a {
    }

    static {
    }

    public final void a(boolean r210, int r211, boolean r212) {
        if (this.f401393c == r210) goto L5;
    L7:
        fja.d r100 = this.f401397g;
        if (r100 == null) goto L12;
        int r101 = fja.d.f477533d;
        r100.a(false);
    L12:
        if (r212 == true) goto L14;
    L18:
        boolean r102 = false;
    L19:
        float[] r103 = this.f401396f;
        final float[] r104 = Arrays.copyOf(r103, r103.length);
        final int r105 = this.f401391a.getPaddingTop();
        final int r106 = this.f401391a.getPaddingBottom();
        this.f401393c = r210;
        this.f401395e = r211;
        final float[] r107 = new float[8];
        if (r210 == false) goto L35;
        float r108 = pla.d.q(this.f401391a, 20);
        this.f401392b.setColor(this.f401394d);
        int r109 = this.f401395e;
        if (r109 == 1) goto L28;
        if (r109 == 2) goto L27;
        if (r109 == 3) goto L26;
        r107 = new float[]{r108, r108, r108, r108, r108, r108, r108, r108};
    L29:
        if (r102 == false) goto L31;
        float[] r110 = Arrays.copyOf(r104, r104.length);
    L32:
        this.f401396f = r110;
        this.f401392b.setCornerRadii(r110);
        this.f401391a.setBackground(this.f401392b);
        FrameLayout r111 = this.f401391a;
        if ((r111 instanceof OUIFrameLayout) == false) goto L36;
        ((OUIFrameLayout) r111).setShadowCornerRadius((int) r108);
    L36:
        int r112 = pla.d.n(this.f401391a, 12);
        int r113 = pla.d.n(this.f401391a, 8);
        int r114 = pla.d.n(this.f401391a, 8);
        int r115 = pla.d.n(this.f401391a, 8);
        final int r116 = pla.d.n(this.f401391a, 2);
        final int r117 = pla.d.n(this.f401391a, 2);
        int r118 = pla.d.n(this.f401391a, 2);
        int r119 = pla.d.n(this.f401391a, 2);
        int r120 = pla.d.n(this.f401391a, 8);
        int r121 = pla.d.n(this.f401391a, 2);
        int r122 = pla.d.n(this.f401391a, 8);
        int r123 = pla.d.n(this.f401391a, 8);
        int r124 = pla.d.n(this.f401391a, 2);
        ViewGroup.LayoutParams r125 = this.f401391a.getLayoutParams();
        if ((r125 instanceof ViewGroup.MarginLayoutParams) == false) goto L39;
        ViewGroup.MarginLayoutParams r126 = (ViewGroup.MarginLayoutParams) r125;
    L40:
        if (r126 == null) goto L51;
        if (this.f401393c == false) goto L45;
        int r127 = r112;
    L46:
        r126.setMarginStart(r127);
        if (this.f401393c == false) goto L49;
        r113 = r112;
    L49:
        r126.setMarginEnd(r113);
        goto L51
    L45:
        r127 = r113;
    L51:
        if (this.f401393c == false) goto L53;
        this.f401391a.setClipChildren(true);
        this.f401391a.setClipToPadding(true);
    L55:
        if (this.f401393c == true) goto L58;
        r114 = 0;
    L58:
        this.f401391a.getPaddingTop();
        this.f401391a.getPaddingBottom();
        int r128 = this.f401395e;
        if (r128 == 1) goto L79;
        if (r128 != 2) goto L63;
        r116 = r118;
    L83:
        if (r102 == false) goto L85;
        com.obric.common.oea.foundation.animation.builder.d.a r129 = new com.obric.common.oea.foundation.animation.builder.d.a();
        r129.b(0.0f, 1.0f, gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2), null);
        final float[] r130 = r107;
        final int r131 = r117;
        final int r132 = r116;
        Function3<String, Object, Object, Unit> r133 = new OCardListItemPositionHelper$animatePositionChange$1(this, r104, r130, r105, r131, r106, r132);
        Intrinsics.checkNotNullParameter(r133, "callback");
        r129.f396382d = r133;
        Function2<Boolean, Throwable, Unit> r134 = new OCardListItemPositionHelper$animatePositionChange$2(this, r107, r117, r116);
        Intrinsics.checkNotNullParameter(r134, "callback");
        r129.f396383e = r134;
        this.f401397g = r129.a().a();
    L86:
        this.f401391a.requestLayout();
        return;
    L85:
        this.f401391a.setPadding(r114, r117, r114, r116);
        goto L86
    L63:
        if (r128 == 3) goto L73;
        boolean r135 = this.f401393c;
        if (r135 == false) goto L67;
        int r136 = r122;
    L68:
        r117 = r136;
        if (r135 == false) goto L71;
        r116 = r123;
        goto L83
    L71:
        r116 = r124;
        goto L83
    L67:
        r136 = 0;
        goto L68
    L73:
        if (this.f401393c == false) goto L75;
        r116 = r120;
    L76:
        r117 = r119;
        goto L83
    L75:
        r116 = r121;
        goto L76
    L79:
        if (this.f401393c == false) goto L81;
        int r137 = r115;
    L82:
        r117 = r137;
        goto L83
    L81:
        r137 = 0;
        goto L82
    L53:
        this.f401391a.setClipChildren(false);
        this.f401391a.setClipToPadding(false);
        goto L55
    L39:
        r126 = null;
        goto L40
    L31:
        r110 = Arrays.copyOf(r107, r107.length);
        goto L32
    L26:
        r107 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r108, r108, r108, r108};
        goto L29
    L27:
        r107 = new float[8];
        goto L29
    L28:
        r107 = new float[]{r108, r108, r108, r108, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L29
    L35:
        this.f401396f = Arrays.copyOf(r107, 8);
        this.f401391a.setBackground(null);
        goto L36
    L14:
        if (this.f401393c != r210) goto L18;
        if (this.f401395e == (-1)) goto L18;
        r102 = true;
        goto L19
    L5:
        if (this.f401395e != r211) goto L7;
    }

    public d(OUIFrameLayout r100, boolean r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "cardContainer");
        this.f401391a = r100;
        this.f401392b = new GradientDrawable();
        this.f401393c = true;
        this.f401395e = -1;
        this.f401396f = new float[8];
        this.f401394d = r102;
        a(r101, r103, false);
    }
}
