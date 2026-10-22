package com.bytedance.dux.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes15.dex */
public class DoubleColorBallAnimationViewOld extends View implements f {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static long f204993p = 32;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AtomicInteger f204994q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f204995r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final AtomicInteger f204996s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f204997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f204998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f204999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PorterDuffXfermode f205000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f205001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f205002f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f205003g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f205004h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f205005i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f205006j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f205007k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f205008l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f205009m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f205010n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f205011o;

    @Override // com.bytedance.dux.drawable.f
    public final void b() {
        this.f205005i = false;
        this.f205003g = false;
        this.f205001e = 0.0f;
    }

    static {
        f204994q = new AtomicInteger(0);
        f204995r = false;
        f204996s = new AtomicInteger(0);
    }

    private static long getExpDelayTime() {
        AtomicInteger r100 = f204994q;
        if (r100.get() >= 2) goto L6;
        DoubleColorBallAnimationView.a(r100, new d());
    L6:
        return f204993p;
    }

    private static boolean getIsOpenInvalidateDelayExp() {
        AtomicInteger r100 = f204996s;
        if (r100.get() >= 2) goto L6;
        DoubleColorBallAnimationView.a(r100, new c());
    L6:
        return f204995r;
    }

    public final void a() {
        this.f205006j = -1;
        if (this.f205007k > 0) goto L5;
        setProgressBarInfo(dm4.a.b(36));
    L5:
        int r100 = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.f205007k <= r100) goto L10;
        if (r100 <= 0) goto L10;
        setProgressBarInfo(r100);
    L10:
        if (this.f204999c != null) goto L12;
        Paint r101 = new Paint();
        r101.setAntiAlias(true);
        r101.setDither(true);
        r101.setStyle(Paint.Style.FILL);
        this.f204999c = r101;
    L12:
        this.f205003g = true;
    }

    @Override // com.bytedance.dux.drawable.f
    public final void f() {
        a();
        this.f205005i = true;
        this.f205002f = true;
        postInvalidate();
    }

    @Override // com.bytedance.dux.drawable.f
    public final boolean isAnimating() {
        return this.f205005i;
    }

    public DoubleColorBallAnimationViewOld(Context r100) {
        this(r100, null);
    }

    public static void setExpDelayTime(long r100) {
        f204994q.compareAndSet(0, 2);
        f204993p = r100;
    }

    public static void setIsOpenInvalidateDelayExp(boolean r100) {
        f204996s.compareAndSet(0, 2);
        f204995r = r100;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f205005i == true) goto L7;
        if (this.f205002f == false) goto L7;
        return;
    L7:
        if (this.f205003g == false) goto L40;
        boolean r100 = false;
        if (this.f205002f == false) goto L18;
        long r101 = System.nanoTime() / 1000000;
        if (this.f205006j >= 0) goto L14;
        this.f205006j = r101;
    L14:
        float r102 = (r101 - this.f205006j) / 400.0f;
        this.f205001e = r102;
        int r103 = (int) r102;
        if (((this.f205004h + r103) & 1) != 1) goto L17;
        r100 = true;
    L17:
        this.f205001e = r102 - r103;
    L18:
        float r104 = this.f205001e;
        float r105 = r104 * 2.0f;
        if (r104 >= 0.5d) goto L21;
        float r106 = r105 * r104;
    L22:
        float r111 = this.f205007k + 0.0f;
        int r107 = r110.saveLayer(0.0f, 0.0f, r111, r111, this.f204999c, 31);
        float r108 = (this.f205011o * r106) + this.f205010n;
        double r109 = r106;
        float r112 = r106 * 2.0f;
        if (r109 < 0.5d) goto L26;
        r112 = 2.0f - r112;
    L26:
        float r113 = this.f205009m;
        float r114 = ((0.25f * r112) * r113) + r113;
        Paint r115 = this.f204999c;
        if (r100 == false) goto L29;
        int r116 = this.f204998b;
    L30:
        r115.setColor(r116);
        r110.drawCircle(0.0f + r108, this.f205008l + 0.0f, r114, this.f204999c);
        float r117 = this.f205007k - r108;
        float r118 = this.f205009m;
        float r119 = r118 - ((r112 * 0.375f) * r118);
        Paint r120 = this.f204999c;
        if (r100 == false) goto L33;
        int r121 = this.f204997a;
    L34:
        r120.setColor(r121);
        this.f204999c.setXfermode(this.f205000d);
        r110.drawCircle(r117 + 0.0f, this.f205008l + 0.0f, r119, this.f204999c);
        this.f204999c.setXfermode(null);
        r110.restoreToCount(r107);
        if (getIsOpenInvalidateDelayExp() == false) goto L37;
        long r122 = getExpDelayTime();
    L38:
        postInvalidateDelayed(r122);
        return;
    L37:
        r122 = 17;
        goto L38
    L33:
        r121 = this.f204998b;
        goto L34
    L29:
        r116 = this.f204997a;
        goto L30
    L21:
        r106 = (r105 * (2.0f - r104)) - 1.0f;
        goto L22
    }

    public void setCycleBias(int r100) {
        this.f205004h = r100;
    }

    @Override // com.bytedance.dux.drawable.f
    public void setProgress(float r100) {
        if (this.f205003g == true) goto L5;
        a();
    L5:
        this.f205001e = r100;
        this.f205005i = false;
        this.f205002f = false;
        postInvalidate();
    }

    @Override // com.bytedance.dux.drawable.f
    public void setProgressBarInfo(int r100) {
        if (r100 <= 0) goto L5;
        this.f205007k = r100;
        this.f205008l = r100 / 2.0f;
        float r101 = (r100 >> 1) * 0.32f;
        this.f205009m = r101;
        float r102 = (r100 * 0.16f) + r101;
        this.f205010n = r102;
        this.f205011o = r100 - (r102 * 2.0f);
        return;
    }

    public DoubleColorBallAnimationViewOld(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = Math.min(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        if (this.f205007k <= r102) goto L7;
        if (r102 <= 0) goto L8;
        setProgressBarInfo(r102);
        return;
    L8:
        return;
    }

    public DoubleColorBallAnimationViewOld(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f205000d = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.f205002f = false;
        this.f205003g = false;
        this.f205004h = 0;
        this.f205005i = false;
        this.f205006j = -1;
        this.f205007k = -1;
        boolean r103 = DoubleColorBallAnimationView.f204981f;
        this.f204997a = ContextCompat.getColor(r100, R.color.loading_1);
        this.f204998b = ContextCompat.getColor(r100, R.color.loading_2);
    }
}
