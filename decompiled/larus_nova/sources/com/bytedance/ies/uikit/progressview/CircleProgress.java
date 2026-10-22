package com.bytedance.ies.uikit.progressview;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.TimeUtils;

/* JADX INFO: loaded from: classes19.dex */
public class CircleProgress extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f249083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TimeInterpolator f249084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f249085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f249086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f249087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f249088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f249089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f249090h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Point f249091i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a[] f249092j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f249093k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f249094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f249095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f249096c;

        public a(float r100, float r101, int r102) {
            this.f249094a = r100;
            this.f249095b = r101;
            this.f249096c = r102;
        }
    }

    public static class b implements TimeInterpolator {
        public b() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 * 2.0f;
            if (r101 < 1.0f) goto L5;
            float r102 = r101 - 2.0f;
            return (((0.5f * r102) * r102) * r102) + 1.0f;
        L5:
            return ((0.5f * r101) * r101) * r101;
        }
    }

    private float getFactor() {
        if (this.f249090h == false) goto L6;
        this.f249089g = AnimationUtils.currentAnimationTimeMillis() - this.f249088f;
    L6:
        return (this.f249089g / this.f249093k) % 5.0f;
    }

    public CircleProgress(Context r100) {
        super(r100);
        this.f249084b = new b();
        this.f249090h = false;
        this.f249091i = new Point();
        this.f249093k = TimeUtils.SECONDS_PER_HOUR;
        b(null, 0);
    }

    public final void a(float r100) {
        int r101 = (int) ((this.f249086d / 3) * r100);
        this.f249087e = r101 / 6;
        int r102 = 0;
    L4:
        if (r102 >= 8) goto L6;
        float r103 = r101;
        double r104 = ((double) r102) * 0.7853981633974483d;
        this.f249092j[r102] = new a((-((float) Math.sin(r104))) * r103, r103 * (-((float) Math.cos(r104))), this.f249083a[r102 % 3]);
        r102 = r102 + 1;
        goto L4
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        r100.save();
        Point r101 = this.f249091i;
        r100.translate(r101.x, r101.y);
        float r102 = getFactor();
        r100.rotate(36.0f * r102);
        int r103 = 0;
    L4:
        if (r103 >= 8) goto L12;
        this.f249085c.setColor(this.f249092j[r103].f249096c);
        float r104 = (r102 - (r103 * 0.0825f)) * 3.0f;
        if (r104 >= 0.0f) goto L9;
        r104 = 0.0f;
    L11:
        float r105 = this.f249084b.getInterpolation(r104);
        a r106 = this.f249092j[r103];
        float r107 = r106.f249094a;
        float r108 = r106.f249095b;
        r100.drawCircle(r107 - ((r107 * 2.0f) * r105), r108 - ((2.0f * r108) * r105), this.f249087e, this.f249085c);
        r103 = r103 + 1;
        goto L4
    L9:
        if (r104 <= 1.0f) goto L11;
        r104 = 1.0f;
        goto L11
    L12:
        r100.restore();
        if (this.f249090h == false) goto L20;
        postInvalidate();
        return;
    }

    public void setDuration(long r100) {
        this.f249093k = r100;
    }

    public void setInterpolator(TimeInterpolator r100) {
        this.f249084b = r100;
    }

    public void setRadius(float r100) {
        this.f249090h = false;
        a(r100);
        this.f249089g %= this.f249093k;
        this.f249088f = AnimationUtils.currentAnimationTimeMillis();
        this.f249090h = true;
        postInvalidate();
    }

    public CircleProgress(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f249084b = new b();
        this.f249090h = false;
        this.f249091i = new Point();
        this.f249093k = TimeUtils.SECONDS_PER_HOUR;
        b(r101, 0);
    }

    public final void b(AttributeSet r100, int r101) {
        this.f249092j = new a[8];
        Paint r102 = new Paint();
        this.f249085c = r102;
        r102.setAntiAlias(true);
        this.f249085c.setStyle(Paint.Style.FILL);
        TypedArray r103 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.color1, R.attr.color2, R.attr.color3}, r101, 0);
        int r104 = r103.getColor(0, -1759188);
        int r105 = r103.getColor(1, -14708582);
        int r106 = r103.getColor(2, -221678);
        r103.recycle();
        this.f249083a = new int[]{r104, r105, r106};
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = getResources().getDimensionPixelSize(R.dimen.default_circle_view_size);
        int r103 = Math.min(View.getDefaultSize(r102, r100), View.getDefaultSize(r102, r101));
        this.f249086d = r103;
        setMeasuredDimension(r103, r103);
        Point r104 = this.f249091i;
        int r105 = this.f249086d;
        r104.set(r105 / 2, r105 / 2);
        a(1.0f);
    }

    public CircleProgress(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f249084b = new b();
        this.f249090h = false;
        this.f249091i = new Point();
        this.f249093k = TimeUtils.SECONDS_PER_HOUR;
        b(r101, r102);
    }
}
