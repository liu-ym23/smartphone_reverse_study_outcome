package plb;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f529807e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f529808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f529809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f529810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Region f529811d;

    /* JADX INFO: renamed from: plb.a$a, reason: collision with other inner class name */
    public static final class C7211a {
    }

    static {
    }

    public void a() {
    }

    public void b(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
    }

    public boolean c(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return false;
    }

    public void d(RectF r100, RectF r101) {
        Intrinsics.checkNotNullParameter(r100, "baseView");
        Intrinsics.checkNotNullParameter(r101, "baseContent");
    }

    public final void e() {
        RectF r100 = this.f529810c;
        float r101 = this.f529808a.getWidth();
        float r102 = this.f529808a.getHeight();
        RectF r103 = new RectF();
        RectF r104 = new RectF();
        float r105 = r100.left;
        float r106 = 0.0f;
        if (r105 >= 0.0f) goto L5;
        r105 = 0.0f;
    L5:
        r103.left = r105;
        float r107 = r100.top;
        if (r107 >= 0.0f) goto L8;
        r107 = 0.0f;
    L8:
        r103.top = r107;
        r103.right = r105 + RangesKt.coerceAtMost(r100.width(), r101);
        r103.bottom = r103.top + RangesKt.coerceAtMost(r100.height(), r102);
        float r108 = r100.left;
        if (r108 >= 0.0f) goto L11;
        float r109 = Math.abs(r108);
    L12:
        r104.left = r109;
        float r110 = r100.top;
        if (r110 >= 0.0f) goto L15;
        r106 = Math.abs(r110);
    L15:
        r104.top = r106;
        r104.right = r104.left + RangesKt.coerceAtMost(r100.width(), r101);
        r104.bottom = r104.top + RangesKt.coerceAtMost(r100.height(), r102);
        Log.i("ILargeImageViewPlusProvider", "updateVisibleContentRect, baseView:" + r103 + ",baseContent:" + r104);
        d(r103, r104);
        return;
    L11:
        r109 = 0.0f;
        goto L12
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f529808a = r100;
        RectF r101 = new RectF(2.1474836E9f, 2.1474836E9f, 2.1474836E9f, 2.1474836E9f);
        this.f529809b = r101;
        this.f529810c = new RectF(r101);
        this.f529811d = new Region();
    }
}
