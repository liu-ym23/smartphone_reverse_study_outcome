package dd5;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b1 extends FrameLayout implements cqa.e {
    public static final int i = 0;
    public final FrameLayout a;
    public final int b;
    public boolean c;
    public boolean d;
    public final float e;
    public final float f;
    public final float g;
    public final DecelerateInterpolator h;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RefreshState.values().length];
            r0[RefreshState.RefreshReleased.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[RefreshState.Refreshing.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[RefreshState.None.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final boolean a() {
        return false;
    }

    public final void d(float r1, int r2, int r3) {
    }

    public final void g(SmartRefreshLayout.j r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "kernel");
    }

    public View getView() {
        return this;
    }

    public void setPrimaryColors(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "colors");
    }

    static {
        i = ColorProtector.parseColor("#1A8CFF");
    }

    public final void k() {
        if (this.d == false) goto L6;
        l();
        return;
    L6:
        this.a.setVisibility(0);
        this.a.setAlpha(1.0f);
        this.a.animate().translationY(this.e).setDuration(200).setInterpolator(this.h).start();
    }

    public final void l() {
        this.a.animate().cancel();
        this.a.setVisibility(0);
        this.a.setAlpha(1.0f);
        this.a.setTranslationY(this.e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.a.animate().cancel();
        super.onDetachedFromWindow();
    }

    public dqa.b getSpinnerStyle() {
        return dqa.b.f;
    }

    public b1(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        this.b = 160;
        int r0 = com.bytedance.ee.util.ui.n.f(r7, 40);
        this.e = com.bytedance.ee.util.ui.n.f(r7, 64);
        this.f = -r0;
        this.g = com.bytedance.ee.util.ui.n.f(r7, 88);
        this.h = new DecelerateInterpolator();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        FrameLayout r1 = new FrameLayout(r7);
        r1.setAlpha(0.0f);
        r1.setVisibility(4);
        GradientDrawable r3 = new GradientDrawable();
        r3.setShape(1);
        r3.setColor(-1);
        r1.setBackground(r3);
        r1.setElevation(com.bytedance.ee.util.ui.n.f(r7, 4));
        this.a = r1;
        ProgressBar r2 = new ProgressBar(r7, null, R.attr.progressBarStyleSmall);
        r2.setIndeterminate(true);
        r2.setIndeterminateTintList(ColorStateList.valueOf(i));
        int r8 = com.bytedance.ee.util.ui.n.f(r7, 24);
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(r0, r0, 49);
        r4.topMargin = -r0;
        Unit r5 = Unit.INSTANCE;
        addView(r1, r4);
        r1.addView(r2, new FrameLayout.LayoutParams(r8, r8, 17));
    }

    public final int j(SmartRefreshLayout r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "layout");
        this.c = false;
        this.d = false;
        this.a.animate().cancel();
        this.a.setAlpha(0.0f);
        this.a.setTranslationY(0.0f);
        this.a.setVisibility(4);
        return this.b;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(com.bytedance.ee.util.ui.n.f(getContext(), 128), 1073741824));
    }

    public final void e(cqa.h r2, RefreshState r3, RefreshState r4) {
        Intrinsics.checkNotNullParameter(r2, "refreshLayout");
        Intrinsics.checkNotNullParameter(r3, "oldState");
        Intrinsics.checkNotNullParameter(r4, "newState");
        int r5 = b.a[r4.ordinal()];
        if (r5 != 1) goto L5;
    L10:
        this.c = true;
        k();
        return;
    L5:
        if (r5 == 2) goto L10;
        if (r5 != 3) goto L13;
        this.c = false;
        this.d = false;
        this.a.animate().cancel();
        this.a.setAlpha(0.0f);
        this.a.setTranslationY(0.0f);
        this.a.setVisibility(4);
        return;
    }

    public final void f(cqa.h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "layout");
        k();
    }

    public final void i(cqa.h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
        k();
    }

    public final void b(boolean r3, float r4, int r5, int r6, int r7) {
        if (r3 == true) goto L4;
        return;
    L4:
        if (this.c == true) goto L9;
        this.a.animate().cancel();
        this.a.setVisibility(0);
        float r8 = r5;
        this.a.setAlpha(RangesKt.coerceIn((r8 / com.bytedance.ee.util.ui.n.f(getContext(), 64)) * 1.5f, 0.0f, 1.0f));
        FrameLayout r9 = this.a;
        float r10 = com.bytedance.ee.util.ui.n.f(getContext(), 64);
        float r11 = RangesKt.coerceIn(r8 / r10, 0.0f, 1.0f);
        float r12 = RangesKt.coerceIn(RangesKt.coerceAtLeast(r8 - r10, 0.0f) / r10, 0.0f, 2.0f) / 4.0f;
        float r13 = this.f;
        r9.setTranslationY(RangesKt.coerceIn(((this.e * r11) + r13) + ((r10 * ((r12 - (r12 * r12)) * 2.0f)) * 2.0f), r13, this.g) - this.f);
        return;
    }
}
