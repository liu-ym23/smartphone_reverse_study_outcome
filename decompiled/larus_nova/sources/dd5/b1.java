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
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes18.dex */
public final class b1 extends FrameLayout implements cqa.e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f467935i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f467936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f467937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f467938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f467939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f467940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f467941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f467942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DecelerateInterpolator f467943h;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f467944a = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            r100[RefreshState.RefreshReleased.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[RefreshState.Refreshing.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[RefreshState.None.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f467944a = r100;
        }
    }

    @Override // cqa.f
    public final boolean a() {
        return false;
    }

    @Override // cqa.f
    public final void d(float r100, int r101, int r102) {
    }

    @Override // cqa.f
    public final void g(SmartRefreshLayout.j r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "kernel");
    }

    @Override // cqa.f
    public View getView() {
        return this;
    }

    @Override // cqa.f
    public void setPrimaryColors(int... r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
    }

    static {
        f467935i = ColorProtector.parseColor("#1A8CFF");
    }

    public final void k() {
        if (this.f467939d == false) goto L6;
        l();
        return;
    L6:
        this.f467936a.setVisibility(0);
        this.f467936a.setAlpha(1.0f);
        this.f467936a.animate().translationY(this.f467940e).setDuration(200).setInterpolator(this.f467943h).start();
    }

    public final void l() {
        this.f467936a.animate().cancel();
        this.f467936a.setVisibility(0);
        this.f467936a.setAlpha(1.0f);
        this.f467936a.setTranslationY(this.f467940e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f467936a.animate().cancel();
        super.onDetachedFromWindow();
    }

    @Override // cqa.f
    public dqa.b getSpinnerStyle() {
        return dqa.b.f469719f;
    }

    public b1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f467937b = 160;
        int r101 = com.bytedance.ee.util.ui.n.f(r100, 40);
        this.f467940e = com.bytedance.ee.util.ui.n.f(r100, 64);
        this.f467941f = -r101;
        this.f467942g = com.bytedance.ee.util.ui.n.f(r100, 88);
        this.f467943h = new DecelerateInterpolator();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        FrameLayout r102 = new FrameLayout(r100);
        r102.setAlpha(0.0f);
        r102.setVisibility(4);
        GradientDrawable r103 = new GradientDrawable();
        r103.setShape(1);
        r103.setColor(-1);
        r102.setBackground(r103);
        r102.setElevation(com.bytedance.ee.util.ui.n.f(r100, 4));
        this.f467936a = r102;
        ProgressBar r104 = new ProgressBar(r100, null, R.attr.progressBarStyleSmall);
        r104.setIndeterminate(true);
        r104.setIndeterminateTintList(ColorStateList.valueOf(f467935i));
        int r105 = com.bytedance.ee.util.ui.n.f(r100, 24);
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(r101, r101, 49);
        r106.topMargin = -r101;
        Unit r107 = Unit.INSTANCE;
        addView(r102, r106);
        r102.addView(r104, new FrameLayout.LayoutParams(r105, r105, 17));
    }

    @Override // cqa.f
    public final int j(SmartRefreshLayout r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        this.f467938c = false;
        this.f467939d = false;
        this.f467936a.animate().cancel();
        this.f467936a.setAlpha(0.0f);
        this.f467936a.setTranslationY(0.0f);
        this.f467936a.setVisibility(4);
        return this.f467937b;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(com.bytedance.ee.util.ui.n.f(getContext(), 128), 1073741824));
    }

    @Override // gqa.e
    public final void e(cqa.h r100, RefreshState r101, RefreshState r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        Intrinsics.checkNotNullParameter(r101, "oldState");
        Intrinsics.checkNotNullParameter(r102, "newState");
        int r103 = b.f467944a[r102.ordinal()];
        if (r103 != 1) goto L5;
    L10:
        this.f467938c = true;
        k();
        return;
    L5:
        if (r103 == 2) goto L10;
        if (r103 != 3) goto L13;
        this.f467938c = false;
        this.f467939d = false;
        this.f467936a.animate().cancel();
        this.f467936a.setAlpha(0.0f);
        this.f467936a.setTranslationY(0.0f);
        this.f467936a.setVisibility(4);
        return;
    }

    @Override // cqa.f
    public final void f(cqa.h r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        k();
    }

    @Override // cqa.f
    public final void i(cqa.h r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        k();
    }

    @Override // cqa.f
    public final void b(boolean r100, float r101, int r102, int r103, int r104) {
        if (r100 == true) goto L4;
        return;
    L4:
        if (this.f467938c == true) goto L9;
        this.f467936a.animate().cancel();
        this.f467936a.setVisibility(0);
        float r105 = r102;
        this.f467936a.setAlpha(RangesKt.coerceIn((r105 / com.bytedance.ee.util.ui.n.f(getContext(), 64)) * 1.5f, 0.0f, 1.0f));
        FrameLayout r106 = this.f467936a;
        float r107 = com.bytedance.ee.util.ui.n.f(getContext(), 64);
        float r108 = RangesKt.coerceIn(r105 / r107, 0.0f, 1.0f);
        float r109 = RangesKt.coerceIn(RangesKt.coerceAtLeast(r105 - r107, 0.0f) / r107, 0.0f, 2.0f) / 4.0f;
        float r110 = this.f467941f;
        r106.setTranslationY(RangesKt.coerceIn(((this.f467940e * r108) + r110) + ((r107 * ((r109 - (r109 * r109)) * 2.0f)) * 2.0f), r110, this.f467942g) - this.f467941f);
        return;
    }
}
