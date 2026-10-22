package yuc;

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

/* JADX INFO: loaded from: classes42.dex */
public class a extends View implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f569264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Interpolator f569265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f569266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f569267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f569268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f569269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f569270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f569271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f569272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<zuc.a> f569273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<Integer> f569274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f569275l;

    @Override // xuc.c
    public final void a() {
    }

    @Override // xuc.c
    public final void onPageSelected() {
    }

    public List<Integer> getColors() {
        return this.f569274k;
    }

    public Interpolator getEndInterpolator() {
        return this.f569266c;
    }

    public float getLineHeight() {
        return this.f569268e;
    }

    public float getLineWidth() {
        return this.f569270g;
    }

    public int getMode() {
        return this.f569264a;
    }

    public Paint getPaint() {
        return this.f569272i;
    }

    public float getRoundRadius() {
        return this.f569271h;
    }

    public Interpolator getStartInterpolator() {
        return this.f569265b;
    }

    public float getXOffset() {
        return this.f569269f;
    }

    public float getYOffset() {
        return this.f569267d;
    }

    public a(Context r100) {
        super(r100);
        this.f569265b = new LinearInterpolator();
        this.f569266c = new LinearInterpolator();
        this.f569275l = new RectF();
        Paint r101 = new Paint(1);
        this.f569272i = r101;
        r101.setStyle(Paint.Style.FILL);
        this.f569268e = b.a(r100, 3.0d);
        this.f569270g = b.a(r100, 10.0d);
    }

    @Override // xuc.c
    public final void b(List<zuc.a> r100) {
        this.f569273j = r100;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        RectF r101 = this.f569275l;
        float r102 = this.f569271h;
        r100.drawRoundRect(r101, r102, r102, this.f569272i);
    }

    public void setColors(Integer... r100) {
        this.f569274k = Arrays.asList(r100);
    }

    public void setEndInterpolator(Interpolator r100) {
        this.f569266c = r100;
        if (r100 != null) goto L6;
        this.f569266c = new LinearInterpolator();
        return;
    }

    public void setLineHeight(float r100) {
        this.f569268e = r100;
    }

    public void setLineWidth(float r100) {
        this.f569270g = r100;
    }

    public void setMode(int r100) {
        if (r100 == 2) goto L10;
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L10;
        throw new IllegalArgumentException("mode " + r100 + " not supported.");
    L10:
        this.f569264a = r100;
    }

    public void setRoundRadius(float r100) {
        this.f569271h = r100;
    }

    public void setStartInterpolator(Interpolator r100) {
        this.f569265b = r100;
        if (r100 != null) goto L6;
        this.f569265b = new LinearInterpolator();
        return;
    }

    public void setXOffset(float r100) {
        this.f569269f = r100;
    }

    public void setYOffset(float r100) {
        this.f569267d = r100;
    }

    public void onPageScrolled(int r100, float r101, int r110) {
        List<zuc.a> r111 = this.f569273j;
        if (r111 != null) goto L5;
        return;
    L5:
        if (r111.isEmpty() == true) goto L22;
        List<Integer> r112 = this.f569274k;
        if (r112 != null) goto L10;
    L12:
        zuc.a r113 = tuc.a.a(this.f569273j, r100);
        zuc.a r102 = tuc.a.a(this.f569273j, r100 + 1);
        int r103 = this.f569264a;
        if (r103 != 0) goto L16;
        float r104 = r113.f573672a;
        float r105 = this.f569269f;
        float r106 = r104 + r105;
        float r107 = r102.f573672a + r105;
        float r114 = r113.f573674c - r105;
        int r108 = r102.f573674c;
    L15:
        float r109 = r108 - r105;
    L19:
        this.f569275l.left = r106 + ((r107 - r106) * this.f569265b.getInterpolation(r101));
        this.f569275l.right = r114 + ((r109 - r114) * this.f569266c.getInterpolation(r101));
        this.f569275l.top = (getHeight() - this.f569268e) - this.f569267d;
        this.f569275l.bottom = getHeight() - this.f569267d;
        invalidate();
        return;
    L16:
        if (r103 != 1) goto L18;
        float r115 = r113.f573675d;
        r105 = this.f569269f;
        r106 = r115 + r105;
        r107 = r102.f573675d + r105;
        r114 = r113.f573676e - r105;
        r108 = r102.f573676e;
        goto L15
    L18:
        int r116 = r113.f573672a;
        int r117 = r113.f573674c;
        float r118 = this.f569270g;
        float r119 = r116 + (((r117 - r116) - r118) / 2.0f);
        int r120 = r102.f573672a;
        int r121 = r102.f573674c;
        float r122 = r120 + (((r121 - r120) - r118) / 2.0f);
        r114 = (((r117 - r116) + r118) / 2.0f) + r116;
        r109 = (((r121 - r120) + r118) / 2.0f) + r120;
        r106 = r119;
        r107 = r122;
        goto L19
    L10:
        if (r112.size() <= 0) goto L12;
        this.f569272i.setColor(vuc.a.a(r101, ((Integer) ListProtector.get(this.f569274k, Math.abs(r100) % this.f569274k.size())).intValue(), ((Integer) ListProtector.get(this.f569274k, Math.abs(r100 + 1) % this.f569274k.size())).intValue()));
        goto L12
    }
}
