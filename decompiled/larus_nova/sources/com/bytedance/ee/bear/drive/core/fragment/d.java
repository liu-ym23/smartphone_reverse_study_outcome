package com.bytedance.ee.bear.drive.core.fragment;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.DrivePreviewViewPager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f224168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f224169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f224170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewPager f224171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DriveMediaImmersiveVM f224172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f224173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<Integer, Boolean> f224174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Integer, Boolean> f224175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f224176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f224177j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f224178k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f224179l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f224180m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f224181n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f224182o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<View, c> f224183p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public f f224184q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f224185r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f224186s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f224187t;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f224188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f224189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f224190c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Boolean f224191d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Drawable f224192e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Drawable f224193f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Drawable f224194g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Drawable f224195h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Drawable f224196i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Drawable f224197j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final RelativeLayout.LayoutParams f224198k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f224199l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f224200m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f224201n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f224202o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final float f224203p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final List<C3217d> f224204q;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f224188a == r101.f224188a) goto L12;
            return false;
        L12:
            if (this.f224189b == r101.f224189b) goto L15;
            return false;
        L15:
            if (this.f224190c == r101.f224190c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f224191d, r101.f224191d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f224192e, r101.f224192e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f224193f, r101.f224193f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f224194g, r101.f224194g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f224195h, r101.f224195h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f224196i, r101.f224196i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f224197j, r101.f224197j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f224198k, r101.f224198k) == true) goto L42;
            return false;
        L42:
            if (this.f224199l == r101.f224199l) goto L45;
            return false;
        L45:
            if (this.f224200m == r101.f224200m) goto L48;
            return false;
        L48:
            if (this.f224201n == r101.f224201n) goto L51;
            return false;
        L51:
            if (this.f224202o == r101.f224202o) goto L54;
            return false;
        L54:
            if (Float.compare(this.f224203p, r101.f224203p) == 0) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.f224204q, r101.f224204q) == true) goto L59;
            return false;
        L59:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f224188a * 31) + this.f224189b) * 31) + this.f224190c) * 31;
            Boolean r101 = this.f224191d;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Drawable r105 = this.f224192e;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            Drawable r108 = this.f224193f;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            Drawable r111 = this.f224194g;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            Drawable r114 = this.f224195h;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            Drawable r117 = this.f224196i;
            if (r117 != null) goto L25;
            int r118 = 0;
        L26:
            int r119 = (r116 + r118) * 31;
            Drawable r120 = this.f224197j;
            if (r120 != null) goto L29;
            int r121 = 0;
        L30:
            int r122 = (r119 + r121) * 31;
            RelativeLayout.LayoutParams r123 = this.f224198k;
            if (r123 == null) goto L35;
            r102 = r123.hashCode();
        L35:
            return ((((((((((((r122 + r102) * 31) + this.f224199l) * 31) + this.f224200m) * 31) + this.f224201n) * 31) + this.f224202o) * 31) + Float.floatToIntBits(this.f224203p)) * 31) + this.f224204q.hashCode();
        L29:
            r121 = r120.hashCode();
            goto L30
        L25:
            r118 = r117.hashCode();
            goto L26
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "MediaOriginalState(statusBarColor=" + this.f224188a + ", navigationBarColor=" + this.f224189b + ", systemUiVisibility=" + this.f224190c + ", navigationBarContrastEnforced=" + this.f224191d + ", decorViewBackground=" + this.f224192e + ", mainRootBackground=" + this.f224193f + ", holderContainerBackground=" + this.f224194g + ", holderBackground=" + this.f224195h + ", titleBarRootBackground=" + this.f224196i + ", viewPagerBackground=" + this.f224197j + ", viewPagerLayoutParams=" + this.f224198k + ", viewPagerPaddingLeft=" + this.f224199l + ", viewPagerPaddingTop=" + this.f224200m + ", viewPagerPaddingRight=" + this.f224201n + ", viewPagerPaddingBottom=" + this.f224202o + ", viewPagerTranslationY=" + this.f224203p + ", ancestorClipStates=" + this.f224204q + ')';
        }

        public b(int r100, int r101, int r102, Boolean r103, Drawable r104, Drawable r105, Drawable r110, Drawable r111, Drawable r112, Drawable r113, RelativeLayout.LayoutParams r114, int r115, int r116, int r117, int r118, float r119, List<C3217d> r210) {
            Intrinsics.checkNotNullParameter(r210, "ancestorClipStates");
            this.f224188a = r100;
            this.f224189b = r101;
            this.f224190c = r102;
            this.f224191d = r103;
            this.f224192e = r104;
            this.f224193f = r105;
            this.f224194g = r110;
            this.f224195h = r111;
            this.f224196i = r112;
            this.f224197j = r113;
            this.f224198k = r114;
            this.f224199l = r115;
            this.f224200m = r116;
            this.f224201n = r117;
            this.f224202o = r118;
            this.f224203p = r119;
            this.f224204q = r210;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f224205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f224206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ColorStateList f224207c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f224205a, r101.f224205a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f224206b, r101.f224206b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f224207c, r101.f224207c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Drawable r100 = this.f224205a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.f224206b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            ColorStateList r107 = this.f224207c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "TitleBarVisualState(background=" + this.f224205a + ", textColor=" + this.f224206b + ", imageTintList=" + this.f224207c + ')';
        }

        public c(Drawable r100, Integer r101, ColorStateList r102) {
            this.f224205a = r100;
            this.f224206b = r101;
            this.f224207c = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.core.fragment.d$d, reason: collision with other inner class name */
    public static final class C3217d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f224208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f224209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f224210c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3217d) == true) goto L8;
            return false;
        L8:
            C3217d r101 = (C3217d) r100;
            if (Intrinsics.areEqual(this.f224208a, r101.f224208a) == true) goto L12;
            return false;
        L12:
            if (this.f224209b == r101.f224209b) goto L15;
            return false;
        L15:
            if (this.f224210c == r101.f224210c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f224208a.hashCode() * 31;
            int r101 = 1231;
            if (this.f224209b == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f224210c == true) goto L11;
            r101 = 1237;
        L11:
            return r103 + r101;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "ViewGroupClipState(viewGroup=" + this.f224208a + ", clipChildren=" + this.f224209b + ", clipToPadding=" + this.f224210c + ')';
        }

        public C3217d(ViewGroup r100, boolean r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "viewGroup");
            this.f224208a = r100;
            this.f224209b = r101;
            this.f224210c = r102;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f224211a;

        public e(d r100) {
            this.f224211a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r100 = this.f224211a;     // Catch: Throwable -> L4
            r100.f224185r = false;     // Catch: Throwable -> L4
            d.b(r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void d() {
        ViewGroup.LayoutParams r100 = this.f224171d.getLayoutParams();
        View r101 = null;
        if ((r100 instanceof RelativeLayout.LayoutParams) == false) goto L5;
        RelativeLayout.LayoutParams r102 = (RelativeLayout.LayoutParams) r100;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        b r103 = this.f224182o;
        if (r103 == null) goto L16;
        List<C3217d> r104 = r103.f224204q;
        if (r104 == null) goto L16;
        Iterator<T> r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        C3217d r106 = (C3217d) r105.next();
        r106.f224208a.setClipChildren(false);
        r106.f224208a.setClipToPadding(false);
    L16:
        int[] r107 = new int[2];
        this.f224171d.getLocationInWindow(r107);
        ViewGroup.LayoutParams r108 = this.f224171d.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
    L20:
        if (r109 == null) goto L22;
        int r110 = r109.topMargin;
    L23:
        int r111 = (r107[1] - ((int) this.f224171d.getTranslationY())) - r110;
        int r112 = r102.getRule(3);
        if (r112 == 0) goto L29;
        View r113 = this.f224169b.findViewById(r112);
        if (r113 == null) goto L29;
        int r114 = r113.getHeight();
    L30:
        int r115 = r111 - r114;
        View r116 = a(this.f224168a.getWindow());
        ViewParent r117 = this.f224171d.getParent();
        int r118 = 0;
    L32:
        if ((r117 instanceof View) == false) goto L37;
        View r119 = (View) r117;
        r118 = r118 + r119.getPaddingTop();
        if (r117 == r116) goto L37;
        r117 = r119.getParent();
    L37:
        int r120 = RangesKt.coerceAtLeast(r118, 0);
        if (r115 > 0) goto L41;
        r115 = r120;
    L41:
        if (r115 <= 0) goto L43;
        this.f224181n = r115;
    L43:
        int r121 = this.f224181n;
        Object r122 = this.f224171d.getParent();
        if ((r122 instanceof View) == false) goto L46;
        r101 = (View) r122;
    L46:
        if (r101 == null) goto L48;
        int r123 = r101.getHeight();
    L49:
        if (r123 <= 0) goto L51;
        r102.height = r123 + r121;
    L51:
        r102.removeRule(3);
        r102.removeRule(2);
        r102.addRule(10);
        r102.topMargin = -r121;
        this.f224171d.setLayoutParams(r102);
        if (this.f224171d.getPaddingTop() == 0) goto L54;
        ViewPager r124 = this.f224171d;
        r124.setPadding(r124.getPaddingLeft(), 0, this.f224171d.getPaddingRight(), this.f224171d.getPaddingBottom());
    L54:
        this.f224171d.setTranslationY(0.0f);
        this.f224180m = true;
        return;
    L48:
        r123 = 0;
    L29:
        r114 = 0;
        goto L30
    L22:
        r110 = 0;
        goto L23
    L19:
        r109 = null;
        goto L20
    L5:
        r102 = null;
        goto L6
    }

    public final boolean g() {
        if (this.f224179l == true) goto L5;
    L7:
        return false;
    L5:
        if (j() == false) goto L7;
        return true;
    }

    public final void h() {
        b r100 = this.f224182o;
        if (this.f224179l == false) goto L67;
        if (r100 != null) goto L7;
        return;
    L7:
        if (this.f224180m == true) goto L9;
    L11:
        Iterator<T> r101 = r100.f224204q.iterator();
    L13:
        if (r101.hasNext() == false) goto L15;
        C3217d r102 = (C3217d) r101.next();
        r102.f224208a.setClipChildren(r102.f224209b);
        r102.f224208a.setClipToPadding(r102.f224210c);
        goto L13
    L15:
        Window r103 = this.f224168a.getWindow();
        WindowCompat.setDecorFitsSystemWindows(r103, false);
        r103.setStatusBarColor(r100.f224188a);
        r103.setNavigationBarColor(r100.f224189b);
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 29) goto L20;
        Boolean r105 = r100.f224191d;
        if (r105 == null) goto L20;
        r103.setNavigationBarContrastEnforced(r105.booleanValue());
    L20:
        a(r103).setSystemUiVisibility(r100.f224190c);
        int r106 = r100.f224190c;
        WindowInsetsControllerCompat r107 = WindowCompat.getInsetsController(r103, a(r103));
        boolean r108 = true;
        if (r104 < 23) goto L28;
        if ((r106 & 8192) == 0) goto L25;
        boolean r109 = true;
    L26:
        r107.setAppearanceLightStatusBars(r109);
        goto L28
    L25:
        r109 = false;
    L28:
        if (r104 >= 26) goto L30;
    L34:
        a(this.f224168a.getWindow()).setBackground(r100.f224192e);
        View r110 = this.f224169b.findViewById(R.id.main_page_root);
        if (r110 == null) goto L37;
        r110.setBackground(r100.f224193f);
    L37:
        View r111 = this.f224169b.findViewById(R.id.main_page_holder_view_container);
        if (r111 == null) goto L40;
        r111.setBackground(r100.f224194g);
    L40:
        View r112 = this.f224169b.findViewById(R.id.main_page_holder_view);
        if (r112 == null) goto L43;
        r112.setBackground(r100.f224195h);
    L43:
        View r113 = this.f224169b.findViewById(R.id.drive_sdk_main_title_bar_root_fl);
        if (r113 == null) goto L46;
        r113.setBackground(r100.f224196i);
    L46:
        this.f224171d.setBackground(r100.f224197j);
        Iterator r114 = ((LinkedHashMap) this.f224183p).entrySet().iterator();
    L47:
        TextView r115 = null;
        if (r114.hasNext() == false) goto L59;
        Map.Entry r116 = (Map.Entry) r114.next();
        View r117 = (View) r116.getKey();
        c r118 = (c) r116.getValue();
        r117.setBackground(r118.f224205a);
        Integer r119 = r118.f224206b;
        if (r119 == null) goto L57;
        int r120 = r119.intValue();
        if ((r117 instanceof TextView) == false) goto L54;
        r115 = (TextView) r117;
    L54:
        if (r115 == null) goto L57;
        r115.setTextColor(r120);
    L57:
        if ((r117 instanceof ImageView) == false) goto L47;
        ImageViewCompat.setImageTintList((ImageView) r117, r118.f224207c);
        goto L47
    L59:
        ((LinkedHashMap) this.f224183p).clear();
        this.f224179l = false;
        this.f224180m = false;
        this.f224181n = 0;
        this.f224182o = null;
        return;
    L30:
        if ((r106 & 16) != 0) goto L33;
        r108 = false;
    L33:
        r107.setAppearanceLightNavigationBars(r108);
        goto L34
    L9:
        if (r100.f224198k == null) goto L11;
        this.f224171d.setLayoutParams(new RelativeLayout.LayoutParams(r100.f224198k));
        this.f224171d.setPadding(r100.f224199l, r100.f224200m, r100.f224201n, r100.f224202o);
        this.f224171d.setTranslationY(r100.f224203p);
        goto L11
    }

    public final boolean j() {
        return this.f224172e.isMediaImmersiveActive(this.f224173f, this.f224174g.invoke(Integer.valueOf(this.f224177j)).booleanValue());
    }

    public final void l() {
        if (this.f224187t == false) goto L5;
        return;
    L5:
        boolean r100 = g();
        if (j() == true) goto L12;
        h();
        if (r100 == g()) goto L57;
        this.f224176i.invoke();
        return;
    L57:
        return;
    L12:
        if (this.f224182o == null) goto L14;
        boolean r210 = r100;
        d r101 = this;
    L50:
        r101.f224179l = true;
        r101.e(r101.f224168a.getWindow());
        c();
        d();
        m();
        if (r210 == g()) goto L53;
        r101.f224176i.invoke();
    L53:
        r101.f224171d.post(new g(r101));
        r101.f224171d.postDelayed(new h(r101), 64);
        return;
    L14:
        ViewGroup.LayoutParams r102 = this.f224171d.getLayoutParams();
        RelativeLayout.LayoutParams r103 = null;
        if ((r102 instanceof RelativeLayout.LayoutParams) == false) goto L17;
        RelativeLayout.LayoutParams r104 = (RelativeLayout.LayoutParams) r102;
    L18:
        int r105 = this.f224168a.getWindow().getStatusBarColor();
        int r106 = this.f224168a.getWindow().getNavigationBarColor();
        int r107 = a(this.f224168a.getWindow()).getSystemUiVisibility();
        if (Build.VERSION.SDK_INT < 29) goto L21;
        Boolean r108 = Boolean.valueOf(this.f224168a.getWindow().isNavigationBarContrastEnforced());
    L22:
        Drawable r110 = a(this.f224168a.getWindow()).getBackground();
        View r109 = this.f224169b.findViewById(R.id.main_page_root);
        if (r109 == null) goto L25;
        Drawable r111 = r109.getBackground();
    L26:
        View r112 = this.f224169b.findViewById(R.id.main_page_holder_view_container);
        if (r112 == null) goto L29;
        Drawable r113 = r112.getBackground();
    L30:
        View r114 = this.f224169b.findViewById(R.id.main_page_holder_view);
        if (r114 == null) goto L33;
        Drawable r115 = r114.getBackground();
    L34:
        View r116 = this.f224169b.findViewById(R.id.drive_sdk_main_title_bar_root_fl);
        if (r116 == null) goto L37;
        Drawable r117 = r116.getBackground();
    L38:
        Drawable r118 = this.f224171d.getBackground();
        if (r104 == null) goto L41;
        r103 = new RelativeLayout.LayoutParams(r104);
    L41:
        RelativeLayout.LayoutParams r119 = r103;
        int r120 = this.f224171d.getPaddingLeft();
        int r121 = this.f224171d.getPaddingTop();
        int r122 = this.f224171d.getPaddingRight();
        int r211 = this.f224171d.getPaddingBottom();
        float r212 = this.f224171d.getTranslationY();
        ArrayList r123 = new ArrayList();
        View r124 = a(this.f224168a.getWindow());
        ViewParent r125 = this.f224171d.getParent();
    L43:
        if ((r125 instanceof ViewGroup) == false) goto L48;
        r210 = r100;
        ViewGroup r126 = (ViewGroup) r125;
        Drawable r213 = r118;
        r123.add(new C3217d(r126, r126.getClipChildren(), r126.getClipToPadding()));
        if (r125 == r124) goto L49;
        r125 = r126.getParent();
        r118 = r213;
        r100 = r210;
    L49:
        r101 = this;
        r101.f224182o = new b(r105, r106, r107, r108, r110, r111, r113, r115, r117, r213, r119, r120, r121, r122, r211, r212, r123);
        goto L50
    L48:
        r210 = r100;
        r213 = r118;
        goto L49
    L37:
        r117 = null;
        goto L38
    L33:
        r115 = null;
        goto L34
    L29:
        r113 = null;
        goto L30
    L25:
        r111 = null;
        goto L26
    L21:
        r108 = null;
        goto L22
    L17:
        r104 = null;
        goto L18
    }

    public final void m() {
        b r100 = this.f224182o;
        if (r100 != null) goto L6;
        return;
    L6:
        if (g() == false) goto L8;
        int r101 = this.f224178k;
    L10:
        if (this.f224171d.getPaddingBottom() != r101) goto L12;
        return;
    L12:
        ViewPager r102 = this.f224171d;
        r102.setPadding(r102.getPaddingLeft(), this.f224171d.getPaddingTop(), this.f224171d.getPaddingRight(), r101);
        this.f224171d.requestLayout();
        return;
    L8:
        r101 = r100.f224202o;
        goto L10
    }

    public final void c() {
        if (k() == false) goto L5;
        int r100 = -16777216;
    L6:
        a(this.f224168a.getWindow()).setBackgroundColor(-16777216);
        View r101 = this.f224169b.findViewById(R.id.main_page_root);
        if (r101 == null) goto L9;
        r101.setBackgroundColor(-16777216);
    L9:
        View r102 = this.f224169b.findViewById(R.id.main_page_holder_view_container);
        if (r102 == null) goto L12;
        r102.setBackgroundColor(-16777216);
    L12:
        View r103 = this.f224169b.findViewById(R.id.main_page_holder_view);
        if (r103 == null) goto L15;
        r103.setBackgroundColor(-16777216);
    L15:
        this.f224171d.setBackgroundColor(-16777216);
        ViewGroup r104 = (ViewGroup) this.f224169b.findViewById(R.id.drive_sdk_main_title_bar_root_fl);
        if (r104 == null) goto L18;
        r104.setBackgroundColor(0);
    L18:
        if (r104 == null) goto L21;
        f(r104, r100);
        return;
    L21:
        return;
    L5:
        r100 = -1;
        goto L6
    }

    public final void i() {
        if (g() == true) goto L5;
        return;
    L5:
        if (this.f224185r == true) goto L10;
        this.f224185r = true;
        this.f224171d.post(new e(this));
        return;
    }

    public final boolean k() {
        if (j() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f224175h.invoke(Integer.valueOf(this.f224177j)).booleanValue() == false) goto L7;
        return true;
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final void b(d r100) {
        if (r100.g() == false) goto L7;
        r100.e(r100.f224168a.getWindow());
        r100.c();
        r100.d();
        r100.m();
        return;
    }

    public final void e(Window r100) {
        boolean r101 = k();
        WindowCompat.setDecorFitsSystemWindows(r100, false);
        r100.setStatusBarColor(0);
        if (r101 == false) goto L5;
        int r102 = -1;
    L6:
        r100.setNavigationBarColor(r102);
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 29) goto L9;
        r100.setNavigationBarContrastEnforced(false);
    L9:
        int r104 = ((a(r100).getSystemUiVisibility() | 1024) | 512) | 256;
        if (r103 < 23) goto L15;
        if (r101 == false) goto L13;
        r104 = r104 | 8192;
        goto L15
    L13:
        r104 = r104 & (-8193);
    L15:
        if (r103 < 26) goto L19;
        if (r101 == false) goto L18;
        r104 = r104 | 16;
        goto L19
    L18:
        r104 = r104 & (-17);
    L19:
        a(r100).setSystemUiVisibility(r104);
        WindowInsetsControllerCompat r105 = WindowCompat.getInsetsController(r100, a(r100));
        if (r103 < 23) goto L22;
        r105.setAppearanceLightStatusBars(r101);
    L22:
        if (r103 < 26) goto L25;
        r105.setAppearanceLightNavigationBars(r101);
        return;
    L25:
        return;
    L5:
        r102 = -16777216;
        goto L6
    }

    public final void f(View r100, int r101) {
        if (this.f224183p.containsKey(r100) == true) goto L19;
        Map<View, c> r102 = this.f224183p;
        Drawable r103 = r100.getBackground();
        ColorStateList r104 = null;
        if ((r100 instanceof TextView) == false) goto L8;
        TextView r105 = (TextView) r100;
    L9:
        if (r105 == null) goto L11;
        Integer r106 = Integer.valueOf(r105.getCurrentTextColor());
    L13:
        if ((r100 instanceof ImageView) == false) goto L15;
        ImageView r107 = (ImageView) r100;
    L16:
        if (r107 == null) goto L18;
        r104 = r107.getImageTintList();
    L18:
        r102.put(r100, new c(r103, r106, r104));
        goto L19
    L15:
        r107 = null;
        goto L16
    L11:
        r106 = null;
        goto L13
    L8:
        r105 = null;
    L19:
        int r108 = 0;
        r100.setBackgroundColor(0);
        if ((r100 instanceof TextView) == false) goto L23;
        ((TextView) r100).setTextColor(r101);
    L23:
        if ((r100 instanceof ImageView) == false) goto L26;
        ImageViewCompat.setImageTintList((ImageView) r100, ColorStateList.valueOf(r101));
    L26:
        if ((r100 instanceof ViewGroup) == false) goto L30;
        ViewGroup r109 = (ViewGroup) r100;
        int r110 = r109.getChildCount();
    L28:
        if (r108 >= r110) goto L32;
        f(r109.getChildAt(r108), r101);
        r108 = r108 + 1;
        goto L28
    L32:
        return;
    }

    public d(FragmentActivity r100, View r101, LifecycleOwner r102, DrivePreviewViewPager r103, DriveMediaImmersiveVM r104, boolean r105, Function1 r106, Function1 r107, Function0 r110) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r103, "viewPager");
        Intrinsics.checkNotNullParameter(r104, "mediaImmersiveVM");
        Intrinsics.checkNotNullParameter(r106, "isVcProvider");
        Intrinsics.checkNotNullParameter(r107, "darkMediaChromeProvider");
        Intrinsics.checkNotNullParameter(r110, "onActiveStateChanged");
        this.f224168a = r100;
        this.f224169b = r101;
        this.f224170c = r102;
        this.f224171d = r103;
        this.f224172e = r104;
        this.f224173f = r105;
        this.f224174g = r106;
        this.f224175h = r107;
        this.f224176i = r110;
        this.f224177j = r103.getCurrentItem();
        this.f224183p = new LinkedHashMap();
    }
}
