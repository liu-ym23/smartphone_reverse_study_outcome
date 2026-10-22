package jp5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Arrays;
import java.util.List;
import vuc.b;
import xuc.c;

/* JADX INFO: loaded from: classes18.dex */
public class a extends View implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f499968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Interpolator f499969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f499970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f499971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f499972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f499973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f499974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f499975h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f499976i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<zuc.a> f499977j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<Integer> f499978k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f499979l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RectF f499980m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f499981n;

    @Override // xuc.c
    public final void a() {
    }

    @Override // xuc.c
    public final void onPageSelected() {
    }

    public List<Integer> getColors() {
        return this.f499978k;
    }

    public Interpolator getEndInterpolator() {
        return this.f499970c;
    }

    public float getLineHeight() {
        return this.f499972e;
    }

    public float getLineWidth() {
        return this.f499974g;
    }

    public int getMode() {
        return this.f499968a;
    }

    public Paint getPaint() {
        return this.f499976i;
    }

    public float getRoundRadius() {
        return this.f499975h;
    }

    public Interpolator getStartInterpolator() {
        return this.f499969b;
    }

    public float getXOffset() {
        return this.f499973f;
    }

    public float getYOffset() {
        return this.f499971d;
    }

    public a(Context r100) {
        super(r100);
        this.f499969b = new LinearInterpolator();
        this.f499970c = new LinearInterpolator();
        this.f499979l = new RectF();
        this.f499980m = new RectF();
        this.f499981n = new RectF();
        Paint r101 = new Paint(1);
        this.f499976i = r101;
        r101.setStyle(Paint.Style.FILL);
        this.f499972e = b.a(r100, 2.0d);
        this.f499975h = b.a(r100, 2.0d);
        this.f499974g = b.a(r100, 10.0d);
    }

    @Override // xuc.c
    public final void b(List<zuc.a> r100) {
        this.f499977j = r100;
    }

    @Override // android.view.View
    public void onDraw(Canvas r110) {
        r110.drawRoundRect(this.f499979l, 0.0f, 0.0f, this.f499976i);
        r110.drawArc(this.f499980m, 180.0f, 90.0f, true, this.f499976i);
        r110.drawArc(this.f499981n, 270.0f, 90.0f, true, this.f499976i);
    }

    public void setColors(Integer... r100) {
        this.f499978k = Arrays.asList(r100);
    }

    public void setEndInterpolator(Interpolator r100) {
        this.f499970c = r100;
        if (r100 != null) goto L6;
        this.f499970c = new LinearInterpolator();
        return;
    }

    public void setLineHeight(float r100) {
        this.f499972e = r100;
    }

    public void setLineWidth(float r100) {
        this.f499974g = r100;
    }

    public void setMode(int r100) {
        if (r100 == 2) goto L10;
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L10;
        throw new IllegalArgumentException("mode " + r100 + " not supported.");
    L10:
        this.f499968a = r100;
    }

    public void setRoundRadius(float r100) {
        this.f499975h = r100;
    }

    public void setStartInterpolator(Interpolator r100) {
        this.f499969b = r100;
        if (r100 != null) goto L6;
        this.f499969b = new LinearInterpolator();
        return;
    }

    public void setXOffset(float r100) {
        this.f499973f = r100;
    }

    public void setYOffset(float r100) {
        this.f499971d = r100;
    }

    public void onPageScrolled(int r100, float r101, int r110) {
        List<zuc.a> r111 = this.f499977j;
        if (r111 != null) goto L5;
        return;
    L5:
        if (r111.isEmpty() == true) goto L22;
        List<Integer> r112 = this.f499978k;
        if (r112 != null) goto L10;
    L12:
        zuc.a r113 = tuc.a.a(this.f499977j, r100);
        zuc.a r102 = tuc.a.a(this.f499977j, r100 + 1);
        int r103 = this.f499968a;
        if (r103 != 0) goto L16;
        float r104 = r113.f573672a;
        float r105 = this.f499973f;
        float r106 = r104 + r105;
        float r107 = r102.f573672a + r105;
        float r114 = r113.f573674c - r105;
        int r108 = r102.f573674c;
    L15:
        float r109 = r108 - r105;
    L19:
        this.f499979l.left = (r106 + ((r107 - r106) * this.f499969b.getInterpolation(r101))) + this.f499975h;
        this.f499979l.right = (r114 + ((r109 - r114) * this.f499970c.getInterpolation(r101))) - this.f499975h;
        this.f499979l.top = (getHeight() - this.f499972e) - this.f499971d;
        this.f499979l.bottom = getHeight() - this.f499971d;
        RectF r115 = this.f499980m;
        RectF r116 = this.f499979l;
        float r117 = r116.left;
        float r118 = this.f499975h;
        r115.left = r117 - r118;
        r115.right = r116.left + r118;
        r115.top = r116.top;
        r115.bottom = r116.bottom + r118;
        RectF r119 = this.f499981n;
        float r120 = r116.right;
        r119.left = r120 - r118;
        r119.right = r120 + r118;
        r119.top = r116.top;
        r119.bottom = r116.bottom + r118;
        invalidate();
        return;
    L16:
        if (r103 != 1) goto L18;
        float r121 = r113.f573675d;
        r105 = this.f499973f;
        r106 = r121 + r105;
        r107 = r102.f573675d + r105;
        r114 = r113.f573676e - r105;
        r108 = r102.f573676e;
        goto L15
    L18:
        int r122 = r113.f573672a;
        int r123 = r113.f573674c;
        float r124 = this.f499974g;
        float r125 = r122 + (((r123 - r122) - r124) / 2.0f);
        int r126 = r102.f573672a;
        int r127 = r102.f573674c;
        float r128 = r126 + (((r127 - r126) - r124) / 2.0f);
        r114 = (((r123 - r122) + r124) / 2.0f) + r122;
        r109 = (((r127 - r126) + r124) / 2.0f) + r126;
        r106 = r125;
        r107 = r128;
        goto L19
    L10:
        if (r112.size() <= 0) goto L12;
        this.f499976i.setColor(vuc.a.a(r101, ((Integer) ListProtector.get(this.f499978k, Math.abs(r100) % this.f499978k.size())).intValue(), ((Integer) ListProtector.get(this.f499978k, Math.abs(r100 + 1) % this.f499978k.size())).intValue()));
        goto L12
    }
}
