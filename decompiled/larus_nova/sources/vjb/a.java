package vjb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f555448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f555449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f555450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f555451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f555452e;

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (getChildCount() != 0) goto L5;
        boolean r101 = true;
    L6:
        View r102 = null;
        if (r101 == true) goto L16;
        View r103 = getChildAt(0);
        if ((r103 instanceof ViewGroup) == false) goto L12;
        ViewGroup r104 = (ViewGroup) r103;
    L13:
        if (r104 == null) goto L16;
        r102 = r104.findViewById(R.id.bubble_card);
        goto L16
    L12:
        r104 = null;
    L16:
        if (r102 == null) goto L18;
        r102.getLocationInWindow(this.f555451d);
        getLocationInWindow(this.f555452e);
        int[] r105 = this.f555451d;
        int r106 = r105[0];
        int[] r107 = this.f555452e;
        float r108 = r106 - r107[0];
        float r109 = r105[1] - r107[1];
        this.f555450c.set(r108, r109, r102.getWidth() + r108, r102.getHeight() + r109);
        RectF r110 = this.f555450c;
        float r111 = this.f555448a;
        r100.drawRoundRect(r110, r111, r111, this.f555449b);
    L18:
        super.dispatchDraw(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public a(Context r100, int r101, float r102, float r103, float r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f555448a = r102;
        Paint r106 = new Paint(1);
        r106.setColor(r101);
        r106.setShadowLayer(r104, 0.0f, r103, r105);
        this.f555449b = r106;
        this.f555450c = new RectF();
        this.f555451d = new int[2];
        this.f555452e = new int[2];
        setWillNotDraw(false);
        setLayerType(1, null);
        int r107 = (int) (Math.abs(0.0f) + r104);
        setPadding(r107, (int) RangesKt.coerceAtLeast(r104 - r103, 0.0f), r107, (int) RangesKt.coerceAtLeast(r104 + r103, 0.0f));
        setClipToPadding(false);
        setClipChildren(false);
    }
}
