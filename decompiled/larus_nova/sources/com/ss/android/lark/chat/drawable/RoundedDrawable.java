package com.ss.android.lark.chat.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class RoundedDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f415072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f415073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f415074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f415075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f415076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f415077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f415078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f415079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f415080i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<Path> f415081j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f415082k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearGradient f415083l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f415084m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f415085n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f415086o;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        int r100 = r110.save();
        r110.clipRect(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom);
        Paint r101 = this.f415084m;
        if (r101 != null) goto L8;
        r101 = new Paint();
        LinearGradient r102 = this.f415083l;
        if (r102 != null) goto L7;
        r102 = new LinearGradient(0.0f, 0.0f, getBounds().width(), 0.0f, this.f415078g, this.f415079h, Shader.TileMode.MIRROR);
        this.f415083l = r102;
    L7:
        r101.setShader(r102);
        r101.setAntiAlias(true);
        this.f415084m = r101;
    L8:
        r110.drawPaint(r101);
        if (this.f415077f <= 0) goto L36;
        Paint r103 = this.f415082k;
        if (r103 != null) goto L17;
        r103 = new Paint();
        r103.setStyle(Paint.Style.STROKE);
        r103.setAntiAlias(true);
        r103.setStrokeWidth(this.f415077f);
        if (this.f415085n == false) goto L16;
        r103.setStrokeWidth(r103.getStrokeWidth() * 2);
    L16:
        this.f415082k = r103;
    L17:
        r103.setColor(this.f415076e);
        List<Path> r104 = this.f415081j;
        List r105 = r104;
        if (r104 != null) goto L32;
        ArrayList r106 = new ArrayList();
        this.f415081j = r106;
        int r107 = this.f415080i;
        if (r107 != 1) goto L23;
        r106.addAll(b(getBounds().width(), this.f415074c, getBounds().width(), getBounds().height() - this.f415075d));
        Path r108 = new Path();
        r108.moveTo(getBounds().width(), getBounds().height() - this.f415075d);
        float r109 = getBounds().width() - this.f415075d;
        float r111 = getBounds().height();
        float r112 = this.f415075d;
        a(r108, r109, r111 - r112, r112, 0);
        r108.lineTo(this.f415073b, getBounds().height());
        float r113 = this.f415073b;
        float r114 = getBounds().height();
        float r115 = this.f415073b;
        a(r108, r113, r114 - r115, r115, 1);
        r106.add(r108);
        r106.addAll(b(0.0f, getBounds().height() - this.f415073b, 0.0f, this.f415072a));
        r105 = r106;
        goto L32
    L23:
        if (r107 == 2) goto L30;
        if (r107 != 3) goto L26;
        Path r116 = new Path();
        r116.moveTo(this.f415072a, 0.0f);
        r116.lineTo(getBounds().width() - this.f415074c, 0.0f);
        float r117 = getBounds().width();
        float r118 = this.f415074c;
        a(r116, r117 - r118, r118, r118, -1);
        r106.add(r116);
        r106.addAll(b(getBounds().width(), this.f415074c, getBounds().width(), getBounds().height() - this.f415075d));
        Path r119 = new Path();
        r119.moveTo(getBounds().width(), getBounds().height() - this.f415075d);
        float r120 = getBounds().width() - this.f415075d;
        float r121 = getBounds().height();
        float r122 = this.f415075d;
        a(r119, r120, r121 - r122, r122, 0);
        r119.lineTo(this.f415073b, getBounds().height());
        r106.add(r119);
        r105 = r106;
        goto L32
    L26:
        if (r107 == 4) goto L28;
        r106.addAll(b(getBounds().width(), this.f415074c, getBounds().width(), getBounds().height() - this.f415075d));
        Path r123 = new Path();
        r123.moveTo(getBounds().width(), getBounds().height() - this.f415075d);
        float r124 = getBounds().width() - this.f415075d;
        float r125 = getBounds().height();
        float r126 = this.f415075d;
        a(r123, r124, r125 - r126, r126, 0);
        r123.lineTo(this.f415073b, getBounds().height());
        float r127 = this.f415073b;
        float r128 = getBounds().height();
        float r129 = this.f415073b;
        a(r123, r127, r128 - r129, r129, 1);
        r106.add(r123);
        r106.addAll(b(0.0f, getBounds().height() - this.f415073b, 0.0f, this.f415072a));
        Path r130 = new Path();
        r130.moveTo(0.0f, this.f415072a);
        float r131 = this.f415072a;
        a(r130, r131, r131, r131, 2);
        r130.lineTo(getBounds().width() - this.f415074c, 0.0f);
        float r132 = getBounds().width();
        float r133 = this.f415074c;
        a(r130, r132 - r133, r133, this.f415075d, 3);
        r106.add(r130);
        r105 = r106;
        goto L32
    L28:
        Path r134 = new Path();
        r134.moveTo(getBounds().width() - this.f415075d, getBounds().height());
        r134.lineTo(this.f415073b, getBounds().height());
        float r135 = this.f415073b;
        float r136 = getBounds().height();
        float r137 = this.f415073b;
        a(r134, r135, r136 - r137, r137, 1);
        r106.add(r134);
        r106.addAll(b(0.0f, getBounds().height() - this.f415073b, 0.0f, this.f415072a));
        Path r138 = new Path();
        r138.moveTo(0.0f, this.f415072a);
        float r139 = this.f415072a;
        a(r138, r139, r139, r139, 2);
        r138.lineTo(getBounds().width() - this.f415074c, 0.0f);
        r106.add(r138);
        r105 = r106;
        goto L32
    L30:
        r106.addAll(b(0.0f, getBounds().height() - this.f415073b, 0.0f, this.f415072a));
        Path r140 = new Path();
        r140.moveTo(0.0f, this.f415072a);
        float r141 = this.f415072a;
        a(r140, r141, r141, r141, 2);
        r140.lineTo(getBounds().width() - this.f415074c, 0.0f);
        float r142 = getBounds().width();
        float r143 = this.f415074c;
        a(r140, r142 - r143, r143, r143, 3);
        r106.add(r140);
        r106.addAll(b(getBounds().width(), this.f415074c, getBounds().width(), getBounds().height() - this.f415075d));
        r105 = r106;
    L32:
        Iterator r144 = r105.iterator();
    L34:
        if (r144.hasNext() == false) goto L36;
        r110.drawPath((Path) r144.next(), r103);
    L36:
        r110.restoreToCount(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        if (Intrinsics.areEqual(r100, getBounds()) == true) goto L5;
        this.f415081j = null;
        this.f415084m = null;
        this.f415083l = null;
    L5:
        super.setBounds(r100);
    }

    public static List b(float r110, float r111, float r112, float r113) {
        ArrayList r100 = new ArrayList();
        float r101 = r112 - r110;
        float r102 = r113 - r111;
        int r103 = (int) (Math.max(Math.abs(r101), Math.abs(r102)) / 100);
        if (r103 != 0) goto L7;
        Path r104 = new Path();
        r104.moveTo(r110, r111);
        r104.lineTo(r112, r113);
        r100.add(r104);
        return r100;
    L7:
        if (1 > r103) goto L12;
        int r105 = 1;
    L9:
        Path r106 = new Path();
        r106.moveTo(r110, r111);
        float r107 = 1;
        float r108 = r103;
        r110 = r110 + ((r101 * r107) / r108);
        r111 = r111 + ((r107 * r102) / r108);
        r106.lineTo(r110, r111);
        r100.add(r106);
        if (r105 == r103) goto L12;
        r105 = r105 + 1;
    L12:
        Path r109 = new Path();
        r109.moveTo(r110, r111);
        r109.lineTo(r112, r113);
        r100.add(r109);
        return r100;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r100, int r101, int r102, int r103) {
        if (r100 == getBounds().left) goto L5;
    L10:
        this.f415081j = null;
        this.f415084m = null;
        this.f415083l = null;
    L11:
        super.setBounds(r100, r101, r102, r103);
        return;
    L5:
        if (r102 != getBounds().right) goto L10;
        if (r101 != getBounds().top) goto L10;
        if (r103 == getBounds().bottom) goto L11;
        goto L10
    }

    public static void a(Path r100, float r101, float r110, float r111, int r112) {
        r100.arcTo(r101 - r111, r110 - r111, r101 + r111, r110 + r111, r112 * 90.0f, 90.0f, false);
    }

    public RoundedDrawable(float r100, float r101, float r102, float r103, int r104, int r105, int r106, int r107, int r108) {
        this.f415072a = r100;
        this.f415073b = r101;
        this.f415074c = r102;
        this.f415075d = r103;
        this.f415076e = r104;
        this.f415077f = r105;
        this.f415078g = r106;
        this.f415079h = r107;
        this.f415080i = r108;
        this.f415085n = true;
        new Path();
        this.f415086o = LazyKt.lazy(RoundedDrawable$mClearPaint$2.INSTANCE);
    }
}
