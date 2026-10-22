package com.ss.ugc.live.barrage.barrage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes36.dex */
public class TextBarrage extends AbsBarrage {
    public static final /* synthetic */ KProperty[] B = null;
    public final float A;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f458073q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f458074r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f458075s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f458076t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f458077u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Rect f458078v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f458079w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f458080x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f458081y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Typeface f458082z;

    static {
        B = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TextBarrage.class), "textPaint", "getTextPaint()Landroid/graphics/Paint;"))};
    }

    @Override // com.ss.ugc.live.barrage.barrage.AbsBarrage
    public Bitmap h() {
        return null;
    }

    public final Paint q() {
        Lazy r100 = this.f458076t;
        KProperty r101 = B[0];
        return (Paint) r100.getValue();
    }

    @Override // com.ss.ugc.live.barrage.barrage.AbsBarrage
    public void k() {
        r(q());
    }

    @Override // com.ss.ugc.live.barrage.barrage.AbsBarrage
    public void g(Canvas r100) {
        String r101 = this.f458079w;
        RectF r102 = this.f458058f;
        float r103 = r102.left;
        float r104 = this.f458075s;
        if (r104 > 0) goto L6;
        r104 = this.f458065m.f458068b;
    L6:
        r100.drawText(r101, r103 + r104, (r102.bottom - this.f458077u) + this.f458065m.f458069c, q());
    }

    public final void r(Paint r100) {
        Rect r101 = this.f458078v;
        String r102 = this.f458079w;
        r100.getTextBounds(r102, 0, r102.length(), r101);
        Rect r103 = this.f458078v;
        this.f458077u = r103.bottom;
        this.f458073q = r103.width();
        this.f458074r = this.f458078v.height();
        float r104 = 2;
        o(Math.max(this.f458073q, this.A), this.f458074r + (this.f458065m.f458069c * r104));
        if (this.f458058f.width() != (this.A + (this.f458065m.f458068b * 2))) goto L5;
        this.f458075s = (this.f458058f.width() - this.f458073q) / r104;
    L5:
        this.f458054b = true;
        int r105 = this.f458079w.length();
        if (6 <= r105) goto L9;
    L11:
        this.f458079w.length();
        return;
    L9:
        if (10 < r105) goto L11;
    }

    public TextBarrage(String r100, float r101, int r102, Typeface r103, float r104, final AbsBarrage.b r105) {
        super(r105);
        this.f458079w = r100;
        this.f458080x = r101;
        this.f458081y = r102;
        this.f458082z = r103;
        this.A = r104;
        this.f458075s = -1.0f;
        this.f458076t = LazyKt.lazy(LazyThreadSafetyMode.NONE, new TextBarrage$textPaint$2(this, r105));
        this.f458078v = new Rect();
    }
}
