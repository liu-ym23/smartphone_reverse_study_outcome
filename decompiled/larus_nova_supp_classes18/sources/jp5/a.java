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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class a extends View implements c {
    public int a;
    public Interpolator b;
    public Interpolator c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public Paint i;
    public List<zuc.a> j;
    public List<Integer> k;
    public final RectF l;
    public final RectF m;
    public final RectF n;

    public final void a() {
    }

    public final void onPageSelected() {
    }

    public List<Integer> getColors() {
        return this.k;
    }

    public Interpolator getEndInterpolator() {
        return this.c;
    }

    public float getLineHeight() {
        return this.e;
    }

    public float getLineWidth() {
        return this.g;
    }

    public int getMode() {
        return this.a;
    }

    public Paint getPaint() {
        return this.i;
    }

    public float getRoundRadius() {
        return this.h;
    }

    public Interpolator getStartInterpolator() {
        return this.b;
    }

    public float getXOffset() {
        return this.f;
    }

    public float getYOffset() {
        return this.d;
    }

    public a(Context r4) {
        super(r4);
        this.b = new LinearInterpolator();
        this.c = new LinearInterpolator();
        this.l = new RectF();
        this.m = new RectF();
        this.n = new RectF();
        Paint r0 = new Paint(1);
        this.i = r0;
        r0.setStyle(Paint.Style.FILL);
        this.e = b.a(r4, 2.0d);
        this.h = b.a(r4, 2.0d);
        this.g = b.a(r4, 10.0d);
    }

    public final void b(List<zuc.a> r1) {
        this.j = r1;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        r10.drawRoundRect(this.l, 0.0f, 0.0f, this.i);
        r10.drawArc(this.m, 180.0f, 90.0f, true, this.i);
        r10.drawArc(this.n, 270.0f, 90.0f, true, this.i);
    }

    public void setColors(Integer... r1) {
        this.k = Arrays.asList(r1);
    }

    public void setEndInterpolator(Interpolator r1) {
        this.c = r1;
        if (r1 != null) goto L6;
        this.c = new LinearInterpolator();
        return;
    }

    public void setLineHeight(float r1) {
        this.e = r1;
    }

    public void setLineWidth(float r1) {
        this.g = r1;
    }

    public void setMode(int r4) {
        if (r4 == 2) goto L10;
        if (r4 == 0) goto L10;
        if (r4 == 1) goto L10;
        throw new IllegalArgumentException("mode " + r4 + " not supported.");
    L10:
        this.a = r4;
    }

    public void setRoundRadius(float r1) {
        this.h = r1;
    }

    public void setStartInterpolator(Interpolator r1) {
        this.b = r1;
        if (r1 != null) goto L6;
        this.b = new LinearInterpolator();
        return;
    }

    public void setXOffset(float r1) {
        this.f = r1;
    }

    public void setYOffset(float r1) {
        this.d = r1;
    }

    public void onPageScrolled(int r8, float r9, int r10) {
        List<zuc.a> r11 = this.j;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L22;
        List<Integer> r12 = this.k;
        if (r12 != null) goto L10;
    L12:
        zuc.a r13 = tuc.a.a(this.j, r8);
        zuc.a r14 = tuc.a.a(this.j, r8 + 1);
        int r0 = this.a;
        if (r0 != 0) goto L16;
        float r1 = r13.a;
        float r2 = this.f;
        float r3 = r1 + r2;
        float r4 = r14.a + r2;
        float r15 = r13.c - r2;
        int r16 = r14.c;
    L15:
        float r17 = r16 - r2;
    L19:
        this.l.left = (r3 + ((r4 - r3) * this.b.getInterpolation(r9))) + this.h;
        this.l.right = (r15 + ((r17 - r15) * this.c.getInterpolation(r9))) - this.h;
        this.l.top = (getHeight() - this.e) - this.d;
        this.l.bottom = getHeight() - this.d;
        RectF r18 = this.m;
        RectF r19 = this.l;
        float r110 = r19.left;
        float r5 = this.h;
        r18.left = r110 - r5;
        r18.right = r19.left + r5;
        r18.top = r19.top;
        r18.bottom = r19.bottom + r5;
        RectF r20 = this.n;
        float r111 = r19.right;
        r20.left = r111 - r5;
        r20.right = r111 + r5;
        r20.top = r19.top;
        r20.bottom = r19.bottom + r5;
        invalidate();
        return;
    L16:
        if (r0 != 1) goto L18;
        float r6 = r13.d;
        r2 = this.f;
        r3 = r6 + r2;
        r4 = r14.d + r2;
        r15 = r13.e - r2;
        r16 = r14.e;
        goto L15
    L18:
        int r7 = r13.a;
        int r112 = r13.c;
        float r21 = this.g;
        float r22 = r7 + (((r112 - r7) - r21) / 2.0f);
        int r23 = r14.a;
        int r24 = r14.c;
        float r25 = r23 + (((r24 - r23) - r21) / 2.0f);
        r15 = (((r112 - r7) + r21) / 2.0f) + r7;
        r17 = (((r24 - r23) + r21) / 2.0f) + r23;
        r3 = r22;
        r4 = r25;
        goto L19
    L10:
        if (r12.size() <= 0) goto L12;
        this.i.setColor(vuc.a.a(r9, ((Integer) ListProtector.get(this.k, Math.abs(r8) % this.k.size())).intValue(), ((Integer) ListProtector.get(this.k, Math.abs(r8 + 1) % this.k.size())).intValue()));
        goto L12
    }
}
