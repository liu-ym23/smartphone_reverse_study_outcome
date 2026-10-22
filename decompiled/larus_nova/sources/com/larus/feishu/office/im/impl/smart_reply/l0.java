package com.larus.feishu.office.im.impl.smart_reply;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes29.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f343372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f343373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f343374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f343375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f343376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f343377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f343378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f343379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f343380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f343381j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f343382k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f343383l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f343384m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f343385n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f343386o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f343387p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f343388q;

    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f343389e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f343390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f343391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f343392c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f343393d;

        /* JADX INFO: renamed from: com.larus.feishu.office.im.impl.smart_reply.l0$a$a, reason: collision with other inner class name */
        public static final class C4312a {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f343390a == r101.f343390a) goto L12;
            return false;
        L12:
            if (this.f343391b == r101.f343391b) goto L15;
            return false;
        L15:
            if (this.f343392c == r101.f343392c) goto L18;
            return false;
        L18:
            if (this.f343393d == r101.f343393d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f343390a * 31) + this.f343391b) * 31) + this.f343392c) * 31) + this.f343393d;
        }

        public final String toString() {
            return "SnapshotBounds(left=" + this.f343390a + ", top=" + this.f343391b + ", width=" + this.f343392c + ", height=" + this.f343393d + ')';
        }

        static {
            f343389e = new a(0, 0, 0, 0);
        }

        public a(int r100, int r101, int r102, int r103) {
            this.f343390a = r100;
            this.f343391b = r101;
            this.f343392c = r102;
            this.f343393d = r103;
        }
    }

    public l0() {
        Intrinsics.checkNotNullParameter("flow_float_expand_smart_reply_snapshot", "snapshotTag");
        this.f343372a = "flow_float_expand_smart_reply_snapshot";
        this.f343373b = 50;
        this.f343374c = 100;
        a r100 = a.f343389e;
        this.f343379h = r100;
        this.f343380i = r100;
        this.f343381j = r100;
    }

    public final void a() {
        FrameLayout r100 = this.f343375d;
        if (r100 == null) goto L10;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L7;
        ViewGroup r102 = (ViewGroup) r101;
    L8:
        if (r102 == null) goto L10;
        r102.removeView(r100);
        goto L10
    L7:
        r102 = null;
    L10:
        ImageView r103 = this.f343384m;
        if (r103 == null) goto L18;
        ViewParent r104 = r103.getParent();
        if ((r104 instanceof ViewGroup) == false) goto L15;
        ViewGroup r105 = (ViewGroup) r104;
    L16:
        if (r105 == null) goto L18;
        r105.removeView(r103);
        goto L18
    L15:
        r105 = null;
    L18:
        FrameLayout r106 = this.f343383l;
        if (r106 == null) goto L26;
        ViewParent r107 = r106.getParent();
        if ((r107 instanceof ViewGroup) == false) goto L23;
        ViewGroup r108 = (ViewGroup) r107;
    L24:
        if (r108 == null) goto L26;
        r108.removeView(r106);
        goto L26
    L23:
        r108 = null;
    L26:
        this.f343375d = null;
        this.f343384m = null;
        this.f343383l = null;
        this.f343385n = null;
        this.f343386o = null;
        View r109 = this.f343387p;
        if (r109 == null) goto L29;
        r109.setAlpha(1.0f);
    L29:
        View r110 = this.f343388q;
        if (r110 == null) goto L36;
        Drawable r111 = r110.getBackground();
        if (r111 == null) goto L36;
        Drawable r112 = r111.mutate();
        if (r112 == null) goto L36;
        r112.setAlpha(255);
    L36:
        this.f343387p = null;
        this.f343388q = null;
        this.f343376e = null;
        this.f343377f = null;
        this.f343378g = null;
        a r113 = a.f343389e;
        this.f343379h = r113;
        this.f343380i = r113;
        this.f343381j = r113;
        this.f343382k = 0;
    }

    public final void c(int r110) {
        FrameLayout r100 = this.f343383l;
        if (r100 != null) goto L5;
        return;
    L5:
        ImageView r101 = this.f343385n;
        if (r101 != null) goto L8;
        return;
    L8:
        ImageView r102 = this.f343386o;
        if (r102 != null) goto L11;
        return;
    L11:
        int r103 = c7.b(Integer.valueOf(this.f343373b));
        int r104 = c7.b(Integer.valueOf(this.f343374c));
        float r105 = 1.0f;
        if (r110 > 0) goto L14;
    L13:
        float r106 = 0.0f;
    L17:
        if (r110 > 0) goto L19;
    L18:
        float r107 = 0.0f;
    L21:
        if (r110 <= 0) goto L26;
        if (r110 < r103) goto L25;
        r105 = 0.0f;
        goto L26
    L25:
        r105 = 1.0f - (r110 / r103);
    L26:
        r101.setAlpha(r106);
        r102.setAlpha(r107);
        View r108 = this.f343387p;
        if (r108 == null) goto L29;
        r108.setAlpha(r105);
    L29:
        View r109 = this.f343388q;
        int r111 = 0;
        if (r109 == null) goto L40;
        Drawable r112 = r109.getBackground();
        if (r112 == null) goto L40;
        Drawable r113 = r112.mutate();
        if (r113 == null) goto L40;
        if (r110 <= 0) goto L37;
        int r114 = 0;
    L38:
        r113.setAlpha(r114);
        goto L40
    L37:
        r114 = 255;
    L40:
        if (r106 <= 0.0f) goto L42;
    L45:
        r100.setVisibility(r111);
        return;
    L42:
        if (r107 > 0.0f) goto L45;
        r111 = 4;
        goto L45
    L19:
        if (r110 >= r104) goto L18;
        r107 = 1.0f;
        goto L21
    L14:
        if (r110 >= r103) goto L13;
        r106 = 1.0f - (r110 / r103);
        goto L17
    }

    public static Rect b(View r100, ViewGroup r101) {
        if (r100.getWidth() > 0) goto L5;
        return null;
    L5:
        if (r100.getHeight() <= 0) goto L11;
        int[] r102 = new int[2];
        int[] r103 = new int[2];
        r101.getLocationOnScreen(r102);
        r100.getLocationOnScreen(r103);
        int r104 = r103[0] - r102[0];
        return new Rect(r104, r103[1] - r102[1], r100.getWidth() + r104, (r103[1] - r102[1]) + r100.getHeight());
    L11:
        return null;
    }
}
