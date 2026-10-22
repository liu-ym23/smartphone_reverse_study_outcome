package com.larus.bmhome.chat.component.bottom.core.follow;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.nova.R;
import com.zhpan.bannerview.indicator.DrawableIndicator;
import java.util.WeakHashMap;
import jd8.g;
import jd8.l;
import jd8.q;
import jd8.s;
import jd8.u;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import va8.o;
import ze8.b;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final WeakHashMap<View, a> f298507o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f298508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ICoreInputAbility f298509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f298510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f298511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f298512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f298513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f298514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f298515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g9.c f298516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f298517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f298518k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f298519l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f298520m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final q f298521n;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.follow.a$a, reason: collision with other inner class name */
    public static final class C4032a {
    }

    static {
        f298507o = new WeakHashMap();
    }

    @Override // ze8.b
    public final boolean b() {
        if (this.f298515h == true) goto L19;
        l r100 = this.f298511d;
        if (r100.f498721n == false) goto L7;
    L6:
        boolean r101 = false;
    L16:
        if (r101 == false) goto L20;
        return true;
    L20:
        return false;
    L7:
        int r102 = r100.f498719l + 1;
        if (r102 >= 0) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == false) goto L6;
        r100.f498713f.setCurrentItem(r102, true);
        r101 = true;
        goto L16
    L10:
        if (r102 >= r100.f498708a.getPageCount()) goto L12;
        r103 = true;
        goto L13
    L19:
        return false;
    }

    @Override // ze8.b
    public final boolean c() {
        if (this.f298515h == false) goto L5;
    L10:
        return true;
    L5:
        if (this.f298510c.f498677e == true) goto L10;
        if (this.f298511d.d() == true) goto L10;
        return false;
    }

    @Override // ze8.b
    public final void d() {
        if (this.f298515h == true) goto L6;
        l r100 = this.f298511d;
        r100.f498709b.a(r100.f498708a.c(r100.f498719l));
        return;
    }

    @Override // ze8.b
    public final void dismiss() {
        if (this.f298515h == false) goto L5;
        return;
    L5:
        this.f298515h = true;
        this.f298513f.removeOnAttachStateChangeListener(this.f298521n);
        WeakHashMap<View, a> r100 = f298507o;
        if (r100.get(this.f298513f) != this) goto L8;
        r100.remove(this.f298513f);
    L8:
        l r101 = this.f298511d;
        r101.C = true;
        boolean r102 = false;
        r101.f498721n = false;
        o r103 = this.f298508a;
        if (r103 == null) goto L11;
        r103.F40(r101.getId());
    L11:
        View r104 = this.f298514g;
        if (r104 == null) goto L16;
        o r105 = this.f298508a;
        if (r105 == null) goto L16;
        r105.SA(r104.getId());
    L16:
        g r106 = this.f298510c;
        r106.f498696x = null;
        r106.l();
        r106.o();
        s r107 = r106.I;
        if (r107 == null) goto L19;
        r107.a();
    L19:
        Integer r108 = r106.f498687o;
        if (r108 == null) goto L24;
        int r109 = r108.intValue();
        View r110 = r106.f498678f;
        if (r110 == null) goto L24;
        r110.setVisibility(r109);
    L24:
        r106.f498687o = null;
        Integer r111 = r106.f498685m;
        if (r111 == null) goto L29;
        int r112 = r111.intValue();
        View r113 = r106.f498686n;
        if (r113 == null) goto L29;
        r113.setVisibility(r112);
    L29:
        r106.f498685m = null;
        r106.f498686n = null;
        if (r106.f498689q == false) goto L33;
        r106.f498689q = false;
        r106.f498674b.setBackground(r106.f498688p);
        r106.f498688p = null;
    L33:
        jd8.a r114 = r106.f498679g;
        if (r114 == null) goto L41;
        ViewParent r115 = r114.getParent();
        if ((r115 instanceof ViewGroup) == false) goto L38;
        ViewGroup r116 = (ViewGroup) r115;
    L39:
        if (r116 == null) goto L41;
        r116.removeView(r114);
        goto L41
    L38:
        r116 = null;
    L41:
        jd8.a r117 = r106.f498680h;
        if (r117 == null) goto L49;
        ViewParent r118 = r117.getParent();
        if ((r118 instanceof ViewGroup) == false) goto L46;
        ViewGroup r119 = (ViewGroup) r118;
    L47:
        if (r119 == null) goto L49;
        r119.removeView(r117);
        goto L49
    L46:
        r119 = null;
    L49:
        r106.f498679g = null;
        r106.f498680h = null;
        r106.m();
        ValueAnimator r120 = r106.M;
        if (r120 == null) goto L52;
        r106.M = null;
        r120.removeAllListeners();
        r120.cancel();
    L52:
        u r121 = r106.G;
        if (r121 == null) goto L61;
        ValueAnimator r122 = r121.f498748d;
        if (r122 == null) goto L57;
        r121.f498748d = null;
        r122.cancel();
    L57:
        r121.f498747c = 255;
        if (r121.f498746b == false) goto L60;
        r121.f498746b = false;
    L60:
        r121.invalidateSelf();
    L61:
        s r123 = r106.I;
        if (r123 == null) goto L64;
        r123.e();
    L64:
        r106.I = null;
        r106.f498682j = null;
        r106.f498683k = null;
        r106.f498681i = null;
        r106.f498691s.clear();
        r106.f498692t.clear();
        r106.f498693u.clear();
        if (this.f298512e == true) goto L67;
        return;
    L67:
        if (this.f298520m == false) goto L77;
        View r124 = this.f298513f;
        Intrinsics.checkNotNullParameter(new g9.b(r124), "finder");
        if (r124 == null) goto L71;
        View r125 = r124.findViewById(R.id.input_area);
    L72:
        if (r125 == null) goto L74;
        r125.setBackground(this.f298518k);
    L74:
        View r126 = this.f298513f.findViewById(R.id.voice_visualizer_container);
        if (r126 == null) goto L83;
        r126.setBackground(this.f298519l);
    L83:
        this.f298518k = null;
        this.f298519l = null;
        this.f298520m = false;
        o r127 = this.f298508a;
        if (r127 == null) goto L89;
        Boolean r128 = this.f298517j;
        if (r128 == null) goto L88;
        r102 = r128.booleanValue();
    L88:
        r127.e10(r102);
    L89:
        this.f298517j = null;
        return;
    L71:
        r125 = null;
        goto L72
    L77:
        ICoreInputAbility r129 = this.f298509b;
        if (r129 == null) goto L80;
        r129.zi();
        goto L83
    L80:
        o r130 = this.f298508a;
        if (r130 == null) goto L83;
        r130.p9(c.b(R.attr.larus_bg_input_normal, this.f298511d.getContext(), R.drawable.larus_bg_input_normal));
        goto L83
    }

    @Override // ze8.b
    public final boolean f() {
        return this.f298511d.d();
    }

    @Override // ze8.b
    public final boolean a(int r110) {
        if (this.f298515h == true) goto L15;
        l r100 = this.f298511d;
        if (r100.d() == false) goto L8;
        boolean r111 = false;
    L12:
        if (r111 == false) goto L16;
        return true;
    L16:
        return false;
    L8:
        if (r100.f498720m == r110) goto L11;
        r100.f498720m = r110;
        ArraysKt.fill$default(r100.f498716i, -1, 0, 0, 6, null);
        r100.b(r100.i(r100.f498719l));
        r100.requestLayout();
        r100.invalidate();
    L11:
        r111 = true;
        goto L12
    L15:
        return false;
    }

    @Override // ze8.b
    public final void e(int r100) {
        if (this.f298515h == true) goto L10;
        l r101 = this.f298511d;
        if (r100 == r101.f498719l) goto L7;
        return;
    L7:
        if (r101.f498721n == true) goto L12;
        r101.f498709b.a(r101.f498708a.c(r100));
        return;
    L12:
        return;
    }

    @Override // ze8.b
    public final boolean g(int r100) {
        if (this.f298515h == true) goto L22;
        l r101 = this.f298511d;
        if (r101.f498721n == true) goto L13;
        if (r100 >= 0) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L13;
        if (r100 == r101.f498719l) goto L18;
        r101.f498713f.setCurrentItem(r100, false);
    L18:
        boolean r103 = true;
    L19:
        if (r103 == false) goto L23;
        return true;
    L23:
        return false;
    L9:
        if (r100 >= r101.f498708a.getPageCount()) goto L11;
        r102 = true;
    L13:
        r103 = false;
        goto L19
    L22:
        return false;
    }

    @Override // ze8.b
    public final void h(int r100) {
        if (this.f298515h == true) goto L18;
        l r101 = this.f298511d;
        if (r100 >= 0) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == true) goto L12;
        r101.getClass();
        return;
    L12:
        r101.f498716i[r100] = -1;
        r101.f498714g.notifyItemChanged(r100);
        if (r100 == r101.f498719l) goto L15;
        return;
    L15:
        if (r101.f498721n == true) goto L21;
        r101.b(r101.i(r100));
        return;
    L21:
        return;
    L7:
        if (r100 >= r101.f498708a.getPageCount()) goto L9;
        r102 = true;
        goto L10
    }

    public a(o r100, ICoreInputAbility r101, g r102, l r103, boolean r104, View r105, DrawableIndicator r106) {
        this.f298508a = r100;
        this.f298509b = r101;
        this.f298510c = r102;
        this.f298511d = r103;
        this.f298512e = r104;
        this.f298513f = r105;
        this.f298514g = r106;
        this.f298516i = new g9.c(new g9.b(r105));
        q r107 = new q(this);
        this.f298521n = r107;
        r105.addOnAttachStateChangeListener(r107);
    }
}
