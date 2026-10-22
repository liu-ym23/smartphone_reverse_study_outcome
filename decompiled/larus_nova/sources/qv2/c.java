package qv2;

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

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f534878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f534879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f534880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f534881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f534882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f534883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f534884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f534885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PorterDuffXfermode f534886i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f534887j;

    public c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f534887j = r100;
        this.f534882e = new RectF();
        this.f534883f = new float[8];
        this.f534884g = new Path();
        this.f534885h = new Paint(1);
        this.f534886i = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    public final void a(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f534878a == 0) goto L5;
    L11:
        int r101 = r100.saveLayer(this.f534882e, this.f534885h);
        this.f534884g.reset();
        this.f534884g.addRoundRect(this.f534882e, this.f534883f, Path.Direction.CW);
        r100.drawPath(this.f534884g, this.f534885h);
        this.f534885h.setXfermode(this.f534886i);
        r100.saveLayer(this.f534882e, this.f534885h);
        this.f534887j.g(r100);
        this.f534885h.setXfermode(null);
        this.f534885h.setColorFilter(null);
        r100.restoreToCount(r101);
        return;
    L5:
        if (this.f534880c != 0) goto L11;
        if (this.f534879b != 0) goto L11;
        if (this.f534881d != 0) goto L11;
        this.f534887j.g(r100);
    }

    public final void c(int r100, int r101) {
        if (this.f534878a == 0) goto L5;
    L10:
        if (r100 == 0) goto L16;
        if (r101 == 0) goto L17;
        this.f534882e.set(0.0f, 0.0f, r100, r101);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (this.f534880c != 0) goto L10;
        if (this.f534881d != 0) goto L10;
        if (this.f534879b != 0) goto L10;
    }

    public final void b(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ttlive_allRadius, R.attr.ttlive_leftBottomRadius, R.attr.ttlive_leftTopRadius, R.attr.ttlive_rightBottomRadius, R.attr.ttlive_rightTopRadius}, r102, 0);
        if (r103 == null) goto L6;
        int r104 = r103.getDimensionPixelSize(0, 0);
        d(r103.getDimensionPixelSize(2, r104), r103.getDimensionPixelSize(1, r104), r103.getDimensionPixelSize(4, r104), r103.getDimensionPixelSize(3, r104));
        r103.recycle();
        return;
    }

    public final void d(int r100, int r101, int r102, int r103) {
        this.f534878a = r100;
        this.f534879b = r101;
        this.f534880c = r102;
        this.f534881d = r103;
        float[] r104 = this.f534883f;
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
        this.f534887j.h();
        return;
    L7:
        Object r109 = this.f534887j;
        if ((r109 instanceof ViewGroup) == true) goto L10;
        r109 = null;
    L10:
        ViewGroup r110 = (ViewGroup) r109;
        if (r110 == null) goto L13;
        r110.setWillNotDraw(false);
        goto L13
    }
}
