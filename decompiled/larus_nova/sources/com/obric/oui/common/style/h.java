package com.obric.oui.common.style;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h implements com.obric.oui.common.style.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<View> f399507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f399508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f399509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f399510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f399511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f399512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f399513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f399514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f399515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f399516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f399517k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f399518l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f399519m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AttributeSet f399520n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f399521o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f399522p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f399523q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f399524r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ObjectAnimator f399525s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ObjectAnimator f399526t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f399527u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f399528v;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f399529a;

        public a(h r100) {
            this.f399529a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f399529a.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f399529a.a();
        }
    }

    @Override // com.obric.oui.common.style.a
    public final void setChangeAlphaWhenEnabledChanged(boolean r100) {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        View r100 = this.f399507a.get();
        if (r100 != 0) goto L6;
        return;
    L6:
        if (this.f399508b == false) goto L15;
        if (r100.isPressed() == false) goto L10;
    L13:
        r100.setForeground(this.f399523q);
        return;
    L10:
        if ((r100 instanceof b) == false) goto L15;
        if (((b) r100).Z2() == true) goto L13;
    L15:
        if (this.f399508b == false) goto L22;
        if ((r100 instanceof b) == false) goto L22;
        if (((b) r100).R4() == false) goto L22;
        r100.setForeground(this.f399523q);
        return;
    L22:
        if (this.f399512f == true) goto L24;
    L26:
        r100.setForeground(null);
        return;
    L24:
        if (r100.isSelected() == false) goto L26;
        r100.setForeground(this.f399524r);
    }

    public final void i() {
        this.f399525s.cancel();
        this.f399526t.cancel();
        this.f399523q.setAlpha(0);
        View r100 = this.f399507a.get();
        if (r100 == null) goto L6;
        r100.setForeground(null);
        return;
    }

    public final void b(MotionEvent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.getAction();
        if (r101 == 1) goto L10;
        if (r101 == 3) goto L10;
        return;
    L10:
        if (this.f399513g == false) goto L13;
        i();
        return;
    }

    public final void c(View r110) {
        int r100 = this.f399517k;
        if (r100 != (-1)) goto L5;
        r100 = ContextCompat.getColor(r110.getContext(), R.color.oui_fill_element_2);
    L5:
        int r101 = 0;
        int[] r102 = {ContextCompat.getColor(r110.getContext(), R.color.oui_accent_bg), ContextCompat.getColor(r110.getContext(), R.color.oui_functional_red_6)};
        this.f399516j = r100;
        TypedArray r103 = this.f399519m.obtainStyledAttributes(this.f399520n, new int[]{R.attr.OUI_alpha_disabled, R.attr.OUI_alpha_pressed, R.attr.oui_alpha_disabled, R.attr.oui_alpha_pressed}, this.f399521o, this.f399522p);
        if (this.f399520n == null) goto L8;
    L11:
        int r104 = r103.getIndexCount();
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L20;
        int r106 = r103.getIndex(r105);
        if (r106 != 1) goto L16;
        this.f399516j = r103.getColor(r106, r100);
    L18:
        r105 = r105 + 1;
        goto L12
    L16:
        if (r106 != 0) goto L18;
        this.f399518l = r103.getFloat(r106, -1.0f);
    L20:
        if (this.f399516j != r100) goto L28;
        Drawable r107 = r110.getBackground();
        if ((r107 instanceof ColorDrawable) == false) goto L28;
    L23:
        if (r101 >= 2) goto L28;
        if (((ColorDrawable) r107).getColor() != r102[r101]) goto L27;
        this.f399516j = ContextCompat.getColor(r110.getContext(), R.color.oui_pressed_on_color);
    L27:
        r101 = r101 + 1;
    L28:
        d(r110);
        return;
    L8:
        if (this.f399521o != 0) goto L11;
        if (this.f399522p == 0) goto L20;
        goto L11
    }

    public final void d(View r100) {
        if (this.f399528v <= 0) goto L5;
        GradientDrawable r101 = new GradientDrawable();
        this.f399523q = r101;
        r101.setCornerRadius(this.f399528v);
        ((GradientDrawable) this.f399523q).setColor(this.f399516j);
        GradientDrawable r102 = new GradientDrawable();
        this.f399524r = r102;
        r102.setCornerRadius(this.f399528v);
        ((GradientDrawable) this.f399524r).setColor(this.f399516j);
    L6:
        boolean r103 = true;
        if (this.f399514h != null) goto L14;
        if (this.f399516j <= 0) goto L11;
        boolean r104 = true;
    L12:
        this.f399508b = r104;
        goto L14
    L11:
        r104 = false;
    L14:
        if (this.f399515i == null) goto L16;
    L20:
        e(r100, r100.isEnabled());
        if (Build.VERSION.SDK_INT < 23) goto L24;
        ObjectAnimator r105 = ObjectAnimator.ofInt(this.f399523q, "alpha", new int[]{255, 255});
        this.f399525s = r105;
        r105.setDuration(1);
        this.f399525s.setInterpolator(null);
        this.f399525s.addUpdateListener(new f(this));
        ObjectAnimator r106 = ObjectAnimator.ofInt(this.f399523q, "alpha", new int[]{255, 0});
        this.f399526t = r106;
        r106.setDuration(this.f399527u);
        this.f399526t.setInterpolator(null);
        this.f399526t.addListener(new a(this));
        this.f399526t.addUpdateListener(new g(this));
        return;
    L24:
        return;
    L16:
        if (this.f399518l > 0.0f) goto L19;
        r103 = false;
    L19:
        this.f399510d = r103;
        goto L20
    L5:
        this.f399523q = new ColorDrawable(this.f399516j);
        this.f399524r = new ColorDrawable(this.f399516j);
        goto L6
    }

    public final void f(boolean r100) {
        View r101 = this.f399507a.get();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f399525s.cancel();
        this.f399526t.cancel();
        if (r101.isEnabled() == true) goto L9;
        return;
    L9:
        if (this.f399508b == true) goto L11;
        return;
    L11:
        if (this.f399509c == true) goto L20;
        if (r100 == false) goto L15;
        a();
        this.f399525s.start();
        return;
    L15:
        if (this.f399513g == false) goto L17;
        i();
        return;
    L17:
        this.f399526t.start();
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void f1(boolean r100) {
        this.f399513g = r100;
    }

    public final void h(int r100) {
        if (this.f399528v == r100) goto L10;
        this.f399528v = r100;
        View r101 = this.f399507a.get();
        if (r101 != null) goto L8;
        wma.b.b("OUIAlphaHelper", "setRadius: owner is null");
        return;
    L8:
        d(r101);
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void m1(String r100) {
        View r101 = this.f399507a.get();
        if (r101 != null) goto L6;
        wma.b.b("OUIAlphaHelper", "refreshColors: owner is null");
        return;
    L6:
        c(r101);
    }

    @Override // com.obric.oui.common.style.a
    public final void setChangeAlphaWhenDisable(boolean r100) {
        this.f399515i = Boolean.valueOf(r100);
        this.f399510d = r100;
        View r101 = this.f399507a.get();
        if (r101 == null) goto L6;
        e(r101, r101.isEnabled());
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void setChangeAlphaWhenPress(boolean r100) {
        this.f399514h = Boolean.valueOf(r100);
        this.f399508b = r100;
        View r101 = this.f399507a.get();
    }

    @Override // com.obric.oui.common.style.a
    public final void setKeepPressAlpha(final boolean r100) {
        wma.b.g("OUIAlphaHelper", "setKeepPressAlpha, " + r100 + ", target: " + this.f399507a.get());
        int r101 = 0;
        if (this.f399509c == r100) goto L7;
        this.f399509c = r100;
        if (r100 == true) goto L7;
        View r102 = this.f399507a.get();
        f(false);
    L7:
        View r103 = this.f399507a.get();
        Function1 r104 = new e(r100);
        int r105 = vma.h.f556353a;
        Intrinsics.checkNotNullParameter(r104, "visitor");
        if (r103 != null) goto L11;
        return;
    L11:
        if ((r103 instanceof ViewGroup) == false) goto L19;
        ViewGroup r106 = (ViewGroup) r103;
        int r107 = r106.getChildCount();
    L13:
        if (r101 >= r107) goto L24;
        int r108 = r101 + 1;
        View r109 = r106.getChildAt(r101);
        if (r109 == null) goto L18;
        r104.invoke(r109);
    L18:
        r101 = r108;
        goto L13
    L24:
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void setOverridePressColor(int r100) {
        if (this.f399517k == r100) goto L6;
        this.f399517k = r100;
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void Y4(View r100, boolean r101) {
        if (this.f399512f == false) goto L6;
        a();
        return;
    }

    public final void e(View r100, boolean r101) {
        View r102 = this.f399507a.get();
        if (r102 != null) goto L5;
        return;
    L5:
        float r103 = 1.0f;
        if (this.f399510d == false) goto L10;
        if (r101 == true) goto L10;
        r103 = this.f399518l;
    L10:
        if (r100 == r102) goto L15;
        if (r102.isEnabled() == r101) goto L15;
        r102.setEnabled(r101);
    L15:
        if (this.f399511e == true) goto L17;
        return;
    L17:
        r102.setAlpha(r103);
    }

    public final void g(ValueAnimator r100, String r101) {
        KeyEvent.Callback r102 = (View) this.f399507a.get();
        if ((r102 instanceof b) == true) goto L5;
        return;
    L5:
        b r103 = (b) r102;
        Object r104 = r100.getAnimatedValue("alpha");
        if (r103.S() == false) goto L16;
        if ((r104 instanceof Integer) == false) goto L16;
        int r105 = ((Integer) r104).intValue();
        if (r105 >= 0) goto L12;
    L14:
        wma.b.b("OUIAlphaHelper", "pressColorAnimSideEffect, invalid alpha: " + r105 + ", scene: " + r101);
        goto L16
    L12:
        if (r105 > 255) goto L14;
        r103.T0((255 - r105) / 255.0f);
    L16:
        if ((r104 instanceof Integer) == false) goto L19;
        r103.Q5(((Integer) r104).intValue());
        return;
    }

    public h(Context r100, AttributeSet r101, int r102, int r103) {
        this.f399508b = true;
        this.f399509c = false;
        this.f399510d = true;
        this.f399511e = true;
        this.f399512f = false;
        this.f399513g = false;
        this.f399514h = null;
        this.f399515i = null;
        this.f399516j = 0;
        this.f399517k = -1;
        this.f399518l = 0.3f;
        this.f399527u = Token$Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration();
        this.f399528v = 0;
        this.f399519m = r100;
        this.f399520n = r101;
        this.f399521o = r102;
        this.f399522p = r103;
    }
}
