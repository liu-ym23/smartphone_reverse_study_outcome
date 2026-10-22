package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class NiceImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f226505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f226506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f226507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f226508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f226509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f226510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f226511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f226512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f226513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f226514j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f226515k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f226516l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f226517m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Xfermode f226518n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f226519o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f226520p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f226521q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float[] f226522r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float[] f226523s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public RectF f226524t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RectF f226525u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Paint f226526v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Path f226527w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Path f226528x;

    public final void j() {
        if (this.f226506b == false) goto L5;
        return;
    L5:
        int r100 = 0;
        if (this.f226512h <= 0) goto L10;
    L7:
        float[] r101 = this.f226522r;
        if (r100 >= r101.length) goto L13;
        int r102 = this.f226512h;
        r101[r100] = r102;
        this.f226523s[r100] = r102 - (this.f226508d / 2.0f);
        r100 = r100 + 1;
        goto L7
    L13:
        return;
    L10:
        float[] r103 = this.f226522r;
        int r104 = this.f226513i;
        float r105 = r104;
        r103[1] = r105;
        r103[0] = r105;
        int r106 = this.f226514j;
        float r107 = r106;
        r103[3] = r107;
        r103[2] = r107;
        int r108 = this.f226516l;
        float r110 = r108;
        r103[5] = r110;
        r103[4] = r110;
        int r111 = this.f226515k;
        float r112 = r111;
        r103[7] = r112;
        r103[6] = r112;
        float[] r109 = this.f226523s;
        int r113 = this.f226508d;
        float r114 = r104 - (r113 / 2.0f);
        r109[1] = r114;
        r109[0] = r114;
        float r115 = r106 - (r113 / 2.0f);
        r109[3] = r115;
        r109[2] = r115;
        float r116 = r108 - (r113 / 2.0f);
        r109[5] = r116;
        r109[4] = r116;
        float r117 = r111 - (r113 / 2.0f);
        r109[7] = r117;
        r109[6] = r117;
    }

    public final void m() {
        if (this.f226506b == true) goto L6;
        RectF r100 = this.f226525u;
        int r101 = this.f226508d;
        r100.set(r101 / 2.0f, r101 / 2.0f, this.f226519o - (r101 / 2.0f), this.f226520p - (r101 / 2.0f));
        return;
    }

    public NiceImageView(Context r100) {
        this(r100, null);
    }

    public final void l(boolean r100) {
        if (r100 == false) goto L4;
        this.f226512h = 0;
    L4:
        j();
        m();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        r100.saveLayer(this.f226524t, null, 31);
        if (this.f226507c == true) goto L5;
        int r101 = this.f226519o;
        int r102 = this.f226508d * 2;
        int r103 = this.f226510f * 2;
        float r104 = ((r101 - r102) - r103) * 1.0f;
        float r105 = r101;
        int r106 = this.f226520p;
        float r107 = ((r106 - r102) - r103) * 1.0f;
        float r108 = r106;
        r100.scale(r104 / r105, r107 / r108, r105 / 2.0f, r108 / 2.0f);
    L5:
        super.onDraw(r100);
        this.f226526v.reset();
        this.f226527w.reset();
        if (this.f226506b == false) goto L8;
        this.f226527w.addCircle(this.f226519o / 2.0f, this.f226520p / 2.0f, this.f226521q, Path.Direction.CCW);
    L9:
        this.f226526v.setAntiAlias(true);
        this.f226526v.setStyle(Paint.Style.FILL);
        this.f226526v.setXfermode(this.f226518n);
        if (Build.VERSION.SDK_INT > 27) goto L12;
        r100.drawPath(this.f226527w, this.f226526v);
    L13:
        this.f226526v.setXfermode(null);
        int r109 = this.f226517m;
        if (r109 == 0) goto L16;
        this.f226526v.setColor(r109);
        r100.drawPath(this.f226527w, this.f226526v);
    L16:
        r100.restore();
        if (this.f226506b == false) goto L24;
        int r110 = this.f226508d;
        if (r110 <= 0) goto L21;
        int r111 = this.f226509e;
        float r112 = r110;
        float r113 = this.f226521q - (r112 / 2.0f);
        this.f226527w.reset();
        this.f226526v.setStrokeWidth(r112);
        this.f226526v.setColor(r111);
        this.f226526v.setStyle(Paint.Style.STROKE);
        this.f226527w.addCircle(this.f226519o / 2.0f, this.f226520p / 2.0f, r113, Path.Direction.CCW);
        r100.drawPath(this.f226527w, this.f226526v);
    L21:
        int r114 = this.f226510f;
        if (r114 <= 0) goto L28;
        int r115 = this.f226511g;
        float r116 = r114;
        float r117 = (this.f226521q - this.f226508d) - (r116 / 2.0f);
        this.f226527w.reset();
        this.f226526v.setStrokeWidth(r116);
        this.f226526v.setColor(r115);
        this.f226526v.setStyle(Paint.Style.STROKE);
        this.f226527w.addCircle(this.f226519o / 2.0f, this.f226520p / 2.0f, r117, Path.Direction.CCW);
        r100.drawPath(this.f226527w, this.f226526v);
        return;
    L28:
        return;
    L24:
        int r118 = this.f226508d;
        if (r118 <= 0) goto L30;
        int r119 = this.f226509e;
        RectF r120 = this.f226525u;
        float[] r121 = this.f226522r;
        this.f226527w.reset();
        this.f226526v.setStrokeWidth(r118);
        this.f226526v.setColor(r119);
        this.f226526v.setStyle(Paint.Style.STROKE);
        this.f226527w.addRoundRect(r120, r121, Path.Direction.CCW);
        r100.drawPath(this.f226527w, this.f226526v);
        return;
    L30:
        return;
    L12:
        this.f226528x.reset();
        this.f226528x.addRect(this.f226524t, Path.Direction.CCW);
        this.f226528x.op(this.f226527w, Path.Op.DIFFERENCE);
        r100.drawPath(this.f226528x, this.f226526v);
        goto L13
    L8:
        this.f226527w.addRoundRect(this.f226524t, this.f226523s, Path.Direction.CCW);
        goto L9
    }

    public void setBorderColor(int r100) {
        this.f226509e = r100;
        invalidate();
    }

    public void setBorderWidth(int r100) {
        this.f226508d = com.bytedance.ee.util.ui.n.f(this.f226505a, r100);
        l(false);
    }

    public void setCornerBottomLeftRadius(int r100) {
        this.f226515k = com.bytedance.ee.util.ui.n.f(this.f226505a, r100);
        l(true);
    }

    public void setCornerBottomRightRadius(int r100) {
        this.f226516l = com.bytedance.ee.util.ui.n.f(this.f226505a, r100);
        l(true);
    }

    public void setCornerRadius(int r100) {
        this.f226512h = com.bytedance.ee.util.ui.n.f(this.f226505a, r100);
        l(false);
    }

    public void setCornerTopLeftRadius(int r100) {
        this.f226513i = com.bytedance.ee.util.ui.n.f(this.f226505a, r100);
        l(true);
    }

    public void setCornerTopRightRadius(int r100) {
        this.f226514j = com.bytedance.ee.util.ui.n.f(this.f226505a, r100);
        l(true);
    }

    public void setInnerBorderColor(int r100) {
        this.f226511g = r100;
        invalidate();
    }

    public void setInnerBorderWidth(int r100) {
        this.f226510f = com.bytedance.ee.util.ui.n.f(this.f226505a, r100);
        if (this.f226506b == true) goto L5;
        this.f226510f = 0;
    L5:
        invalidate();
    }

    public void setMaskColor(int r100) {
        this.f226517m = r100;
        invalidate();
    }

    public NiceImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public NiceImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f226509e = -1;
        this.f226511g = -1;
        this.f226505a = r100;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.border_color, R.attr.border_width, R.attr.corner_bottom_left_radius, R.attr.corner_bottom_right_radius, R.attr.corner_radius, R.attr.corner_top_left_radius, R.attr.corner_top_right_radius, R.attr.inner_border_color, R.attr.inner_border_width, R.attr.is_circle, R.attr.is_cover_src, R.attr.mask_color}, 0, 0);
        int r104 = 0;
    L4:
        if (r104 >= r103.getIndexCount()) goto L40;
        int r105 = r103.getIndex(r104);
        if (r105 != 10) goto L9;
        this.f226507c = r103.getBoolean(r105, this.f226507c);
    L39:
        r104 = r104 + 1;
        goto L4
    L9:
        if (r105 != 9) goto L12;
        this.f226506b = r103.getBoolean(r105, this.f226506b);
        goto L39
    L12:
        if (r105 != 1) goto L14;
        this.f226508d = r103.getDimensionPixelSize(r105, this.f226508d);
        goto L39
    L14:
        if (r105 != 0) goto L16;
        this.f226509e = r103.getColor(r105, this.f226509e);
        goto L39
    L16:
        if (r105 != 8) goto L19;
        this.f226510f = r103.getDimensionPixelSize(r105, this.f226510f);
        goto L39
    L19:
        if (r105 != 7) goto L22;
        this.f226511g = r103.getColor(r105, this.f226511g);
        goto L39
    L22:
        if (r105 != 4) goto L25;
        this.f226512h = r103.getDimensionPixelSize(r105, this.f226512h);
        goto L39
    L25:
        if (r105 != 5) goto L28;
        this.f226513i = r103.getDimensionPixelSize(r105, this.f226513i);
        goto L39
    L28:
        if (r105 != 6) goto L31;
        this.f226514j = r103.getDimensionPixelSize(r105, this.f226514j);
        goto L39
    L31:
        if (r105 != 2) goto L34;
        this.f226515k = r103.getDimensionPixelSize(r105, this.f226515k);
        goto L39
    L34:
        if (r105 != 3) goto L37;
        this.f226516l = r103.getDimensionPixelSize(r105, this.f226516l);
        goto L39
    L37:
        if (r105 != 11) goto L39;
        this.f226517m = r103.getColor(r105, this.f226517m);
        goto L39
    L40:
        r103.recycle();
        this.f226522r = new float[8];
        this.f226523s = new float[8];
        this.f226525u = new RectF();
        this.f226524t = new RectF();
        this.f226526v = new Paint();
        this.f226527w = new Path();
        if (Build.VERSION.SDK_INT > 27) goto L43;
        this.f226518n = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    L44:
        j();
        if (this.f226506b == true) goto L62;
        this.f226510f = 0;
        return;
    L62:
        return;
    L43:
        this.f226518n = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.f226528x = new Path();
        goto L44
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f226519o = r100;
        this.f226520p = r101;
        m();
        if (this.f226506b == false) goto L5;
        float r104 = Math.min(this.f226519o, this.f226520p) / 2.0f;
        this.f226521q = r104;
        RectF r105 = this.f226524t;
        float r106 = this.f226519o / 2.0f;
        float r107 = this.f226520p / 2.0f;
        r105.set(r106 - r104, r107 - r104, r106 + r104, r107 + r104);
        return;
    L5:
        this.f226524t.set(0.0f, 0.0f, this.f226519o, this.f226520p);
        if (this.f226507c == false) goto L10;
        this.f226524t = this.f226525u;
        return;
    }
}
