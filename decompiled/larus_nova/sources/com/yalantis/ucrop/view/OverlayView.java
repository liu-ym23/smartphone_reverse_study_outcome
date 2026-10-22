package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import sqc.d;
import vqc.f;
import wqc.b;

/* JADX INFO: loaded from: classes41.dex */
public class OverlayView extends View {
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f464474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f464475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f464476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f464477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f464478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f464479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f464480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f464481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f464482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f464483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f464484k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f464485l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f464486m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Path f464487n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f464488o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint f464489p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Paint f464490q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Paint f464491r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f464492s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f464493t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f464494u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f464495v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f464496w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f464497x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f464498y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public d f464499z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FreestyleMode {
    }

    public final void a() {
        this.f464478e = f.a(this.f464474a);
        RectF r100 = this.f464474a;
        r100.centerX();
        r100.centerY();
        this.f464482i = null;
        this.f464487n.reset();
        this.f464487n.addCircle(this.f464474a.centerX(), this.f464474a.centerY(), Math.min(this.f464474a.width(), this.f464474a.height()) / 2.0f, Path.Direction.CW);
    }

    public RectF getCropViewRect() {
        return this.f464474a;
    }

    public int getFreestyleCropMode() {
        return this.f464492s;
    }

    public d getOverlayViewChangeListener() {
        return this.f464499z;
    }

    public OverlayView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        r110.save();
        if (this.f464485l == false) goto L5;
        r110.clipPath(this.f464487n, Region.Op.DIFFERENCE);
    L6:
        r110.drawColor(this.f464486m);
        r110.restore();
        if (this.f464485l == false) goto L10;
        r110.drawCircle(this.f464474a.centerX(), this.f464474a.centerY(), Math.min(this.f464474a.width(), this.f464474a.height()) / 2.0f, this.f464488o);
    L10:
        if (this.f464484k == false) goto L26;
        if (this.f464482i == null) goto L14;
    L22:
        float[] r100 = this.f464482i;
        if (r100 == null) goto L26;
        r110.drawLines(r100, this.f464489p);
        goto L26
    L14:
        if (this.f464474a.isEmpty() == true) goto L22;
        this.f464482i = new float[(this.f464479f * 4) + (this.f464480g * 4)];
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L17:
        if (r102 >= this.f464479f) goto L20;
        float[] r104 = this.f464482i;
        int r105 = r103 + 1;
        RectF r106 = this.f464474a;
        r104[r103] = r106.left;
        int r107 = r105 + 1;
        float r108 = r102 + 1.0f;
        float r109 = r106.height() * (r108 / (this.f464479f + 1));
        RectF r111 = this.f464474a;
        r104[r105] = r109 + r111.top;
        float[] r112 = this.f464482i;
        int r113 = r107 + 1;
        r112[r107] = r111.right;
        r103 = r113 + 1;
        r112[r113] = (r111.height() * (r108 / (this.f464479f + 1))) + this.f464474a.top;
        r102 = r102 + 1;
    L20:
        if (r101 >= this.f464480g) goto L22;
        float[] r114 = this.f464482i;
        int r115 = r103 + 1;
        float r116 = r101 + 1.0f;
        float r117 = this.f464474a.width() * (r116 / (this.f464480g + 1));
        RectF r118 = this.f464474a;
        r114[r103] = r117 + r118.left;
        float[] r119 = this.f464482i;
        int r120 = r115 + 1;
        r119[r115] = r118.top;
        int r121 = r120 + 1;
        float r122 = r118.width() * (r116 / (this.f464480g + 1));
        RectF r123 = this.f464474a;
        r119[r120] = r122 + r123.left;
        r103 = r121 + 1;
        this.f464482i[r121] = r123.bottom;
        r101 = r101 + 1;
    L26:
        if (this.f464483j == false) goto L29;
        r110.drawRect(this.f464474a, this.f464490q);
    L29:
        if (this.f464492s == 0) goto L34;
        r110.save();
        this.f464475b.set(this.f464474a);
        RectF r124 = this.f464475b;
        int r125 = this.f464498y;
        r124.inset(r125, -r125);
        r110.clipRect(this.f464475b, Region.Op.DIFFERENCE);
        this.f464475b.set(this.f464474a);
        RectF r126 = this.f464475b;
        int r127 = this.f464498y;
        r126.inset(-r127, r127);
        r110.clipRect(this.f464475b, Region.Op.DIFFERENCE);
        r110.drawRect(this.f464474a, this.f464491r);
        r110.restore();
        return;
    L34:
        return;
    L5:
        r110.clipRect(this.f464474a, Region.Op.DIFFERENCE);
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        if (this.f464474a.isEmpty() == false) goto L5;
        return false;
    L5:
        if (this.f464492s == 0) goto L102;
        float r100 = r110.getX();
        float r101 = r110.getY();
        if ((r110.getAction() & 255) != 0) goto L34;
        double r102 = this.f464496w;
        int r103 = 0;
        int r111 = -1;
    L11:
        if (r103 >= 8) goto L17;
        double r104 = Math.sqrt(Math.pow(r100 - this.f464478e[r103], 2.0d) + Math.pow(r101 - this.f464478e[r103 + 1], 2.0d));
        if (r104 >= r102) goto L15;
        r111 = r103 / 2;
        r102 = r104;
    L15:
        r103 = r103 + 2;
        goto L11
    L17:
        if (this.f464492s != 1) goto L22;
        if (r111 >= 0) goto L22;
        if (this.f464474a.contains(r100, r101) == false) goto L22;
        int r105 = 4;
    L23:
        this.f464495v = r105;
        if (r105 == (-1)) goto L26;
        boolean r106 = true;
    L27:
        if (r106 == true) goto L30;
        this.f464493t = -1.0f;
        this.f464494u = -1.0f;
    L32:
        return r106;
    L30:
        if (this.f464493t >= 0.0f) goto L32;
        this.f464493t = r100;
        this.f464494u = r101;
        goto L32
    L26:
        r106 = false;
    L22:
        r105 = r111;
        goto L23
    L34:
        if ((r110.getAction() & 255) != 2) goto L89;
        if (r110.getPointerCount() != 1) goto L89;
        if (this.f464495v == (-1)) goto L89;
        float r107 = Math.min(Math.max(r100, getPaddingLeft()), getWidth() - getPaddingRight());
        float r108 = Math.min(Math.max(r101, getPaddingTop()), getHeight() - getPaddingBottom());
        this.f464475b.set(this.f464474a);
        int r109 = this.f464495v;
        if (r109 == 0) goto L60;
        if (r109 == 1) goto L59;
        if (r109 != 2) goto L44;
        RectF r112 = this.f464475b;
        RectF r113 = this.f464474a;
        r112.set(r113.left, r113.top, r107, r108);
    L62:
        if (this.f464475b.height() < this.f464497x) goto L64;
        boolean r114 = true;
    L66:
        if (this.f464475b.width() < this.f464497x) goto L68;
        boolean r115 = true;
    L69:
        RectF r116 = this.f464474a;
        if (r115 == false) goto L72;
        float r117 = this.f464475b.left;
    L73:
        if (r114 == false) goto L75;
        float r118 = this.f464475b.top;
    L76:
        if (r115 == false) goto L78;
        float r119 = this.f464475b.right;
    L79:
        if (r114 == false) goto L81;
        float r120 = this.f464475b.bottom;
    L82:
        r116.set(r117, r118, r119, r120);
        if (r114 == true) goto L85;
        if (r115 == true) goto L85;
    L86:
        this.f464493t = r107;
        this.f464494u = r108;
        return true;
    L85:
        a();
        postInvalidate();
        goto L86
    L81:
        r120 = r116.bottom;
        goto L82
    L78:
        r119 = r116.right;
        goto L79
    L75:
        r118 = r116.top;
        goto L76
    L72:
        r117 = r116.left;
        goto L73
    L68:
        r115 = false;
        goto L69
    L64:
        r114 = false;
        goto L66
    L44:
        if (r109 != 3) goto L46;
        RectF r121 = this.f464475b;
        RectF r122 = this.f464474a;
        r121.set(r107, r122.top, r122.right, r108);
        goto L62
    L46:
        if (r109 != 4) goto L62;
        this.f464475b.offset(r107 - this.f464493t, r108 - this.f464494u);
        if (this.f464475b.left <= getLeft()) goto L86;
        if (this.f464475b.top <= getTop()) goto L86;
        if (this.f464475b.right >= getRight()) goto L86;
        if (this.f464475b.bottom >= getBottom()) goto L86;
        this.f464474a.set(this.f464475b);
        a();
        postInvalidate();
        goto L86
    L59:
        RectF r123 = this.f464475b;
        RectF r124 = this.f464474a;
        r123.set(r124.left, r108, r107, r124.bottom);
        goto L62
    L60:
        RectF r125 = this.f464475b;
        RectF r126 = this.f464474a;
        r125.set(r107, r108, r126.right, r126.bottom);
    L89:
        if ((r110.getAction() & 255) != 1) goto L100;
        this.f464493t = -1.0f;
        this.f464494u = -1.0f;
        this.f464495v = -1;
        d r127 = this.f464499z;
        if (r127 == null) goto L101;
        ((b) r127).f560783a.f464516a.setCropRect(this.f464474a);
        return false;
    L101:
        return false;
    L100:
        return false;
    L102:
        return false;
    }

    public void setCircleDimmedLayer(boolean r100) {
        this.f464485l = r100;
    }

    public void setCropFrameColor(int r100) {
        this.f464490q.setColor(r100);
    }

    public void setCropFrameStrokeWidth(int r100) {
        this.f464490q.setStrokeWidth(r100);
    }

    public void setCropGridColor(int r100) {
        this.f464489p.setColor(r100);
    }

    public void setCropGridColumnCount(int r100) {
        this.f464480g = r100;
        this.f464482i = null;
    }

    public void setCropGridCornerColor(int r100) {
        this.f464491r.setColor(r100);
    }

    public void setCropGridRowCount(int r100) {
        this.f464479f = r100;
        this.f464482i = null;
    }

    public void setCropGridStrokeWidth(int r100) {
        this.f464489p.setStrokeWidth(r100);
    }

    public void setDimmedColor(int r100) {
        this.f464486m = r100;
    }

    public void setFreestyleCropEnabled(boolean r100) {
        this.f464492s = r100 ? 1 : 0;
    }

    public void setFreestyleCropMode(int r100) {
        this.f464492s = r100;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(d r100) {
        this.f464499z = r100;
    }

    public void setShowCropFrame(boolean r100) {
        this.f464483j = r100;
    }

    public void setShowCropGrid(boolean r100) {
        this.f464484k = r100;
    }

    public void setTargetAspectRatio(float r100) {
        this.f464481h = r100;
        int r101 = this.f464476c;
        if (r101 <= 0) goto L12;
        int r102 = (int) (r101 / r100);
        int r103 = this.f464477d;
        if (r102 <= r103) goto L7;
        int r104 = (int) (r103 * r100);
        int r105 = (r101 - r104) / 2;
        this.f464474a.set(getPaddingLeft() + r105, getPaddingTop(), (getPaddingLeft() + r104) + r105, getPaddingTop() + this.f464477d);
    L8:
        d r106 = this.f464499z;
        if (r106 == null) goto L11;
        ((b) r106).f560783a.f464516a.setCropRect(this.f464474a);
    L11:
        a();
        postInvalidate();
        return;
    L7:
        int r107 = (r103 - r102) / 2;
        this.f464474a.set(getPaddingLeft(), getPaddingTop() + r107, getPaddingLeft() + this.f464476c, (getPaddingTop() + r102) + r107);
        goto L8
    L12:
        this.A = true;
    }

    public OverlayView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public OverlayView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f464474a = new RectF();
        this.f464475b = new RectF();
        this.f464482i = null;
        this.f464487n = new Path();
        this.f464488o = new Paint(1);
        this.f464489p = new Paint(1);
        this.f464490q = new Paint(1);
        this.f464491r = new Paint(1);
        this.f464492s = 0;
        this.f464493t = -1.0f;
        this.f464494u = -1.0f;
        this.f464495v = -1;
        this.f464496w = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.f464497x = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.f464498y = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == false) goto L8;
        int r105 = getPaddingLeft();
        int r106 = getPaddingTop();
        int r107 = getWidth() - getPaddingRight();
        int r108 = getHeight() - getPaddingBottom();
        this.f464476c = r107 - r105;
        this.f464477d = r108 - r106;
        if (this.A == false) goto L9;
        this.A = false;
        setTargetAspectRatio(this.f464481h);
        return;
    L9:
        return;
    }
}
