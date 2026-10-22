package k14;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f501367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f501368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f501369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f501370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f501371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f501372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f501373g;

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.f501369c = new Paint(1);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f501369c.setColor(this.f501367a);
        float r101 = this.f501368b;
        r100.drawCircle(r101, r101, r101, this.f501369c);
    }

    public final void setThumbState(boolean r100) {
        if (r100 == false) goto L5;
        ViewGroup.LayoutParams r101 = getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r101).setMarginStart(this.f501370d);
        return;
    L5:
        ViewGroup.LayoutParams r102 = getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r102).setMarginStart(this.f501371e);
    }
}
