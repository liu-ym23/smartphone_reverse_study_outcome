package rl2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f538447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f538448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f538449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f538450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f538451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f538452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f538453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f538454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PorterDuffXfermode f538455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f538456j;

    public c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f538456j = r100;
        this.f538451e = new RectF();
        this.f538452f = new float[8];
        this.f538453g = new Path();
        this.f538454h = new Paint(1);
        this.f538455i = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    public final void a(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f538447a == 0) goto L5;
    L11:
        int r101 = r100.saveLayer(this.f538451e, this.f538454h);
        this.f538453g.reset();
        this.f538453g.addRoundRect(this.f538451e, this.f538452f, Path.Direction.CW);
        r100.drawPath(this.f538453g, this.f538454h);
        this.f538454h.setXfermode(this.f538455i);
        r100.saveLayer(this.f538451e, this.f538454h);
        this.f538456j.g(r100);
        this.f538454h.setXfermode(null);
        this.f538454h.setColorFilter(null);
        r100.restoreToCount(r101);
        return;
    L5:
        if (this.f538449c != 0) goto L11;
        if (this.f538448b != 0) goto L11;
        if (this.f538450d != 0) goto L11;
        this.f538456j.g(r100);
    }

    public final void c(int r100, int r101) {
        if (this.f538447a == 0) goto L5;
    L10:
        if (r100 == 0) goto L16;
        if (r101 == 0) goto L17;
        this.f538451e.set(0.0f, 0.0f, r100, r101);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (this.f538449c != 0) goto L10;
        if (this.f538450d != 0) goto L10;
        if (this.f538448b != 0) goto L10;
    }

    public final void b(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ec_allRadius, R.attr.ec_leftBottomRadius, R.attr.ec_leftTopRadius, R.attr.ec_rightBottomRadius, R.attr.ec_rightTopRadius}, r102, 0);
        if (r103 == null) goto L6;
        int r104 = r103.getDimensionPixelSize(0, 0);
        d(r103.getDimensionPixelSize(2, r104), r103.getDimensionPixelSize(1, r104), r103.getDimensionPixelSize(4, r104), r103.getDimensionPixelSize(3, r104));
        r103.recycle();
        return;
    }

    public final void d(int r100, int r101, int r102, int r103) {
        this.f538447a = r100;
        this.f538448b = r101;
        this.f538449c = r102;
        this.f538450d = r103;
        float[] r104 = this.f538452f;
        float r105 = r100;
        r104[0] = r105;
        r104[1] = r105;
        float r106 = r102;
        r104[2] = r106;
        r104[3] = r106;
        float r107 = r103;
        r104[4] = r107;
        r104[5] = r107;
        float r108 = r101;
        r104[6] = r108;
        r104[7] = r108;
        if (r101 > 0) goto L7;
        if (r100 > 0) goto L7;
        if (r102 > 0) goto L7;
        if (r103 > 0) goto L7;
    L13:
        this.f538456j.h();
        return;
    L7:
        Object r109 = this.f538456j;
        if ((r109 instanceof ViewGroup) == true) goto L10;
        r109 = null;
    L10:
        ViewGroup r110 = (ViewGroup) r109;
        if (r110 == null) goto L13;
        r110.setWillNotDraw(false);
        goto L13
    }
}
