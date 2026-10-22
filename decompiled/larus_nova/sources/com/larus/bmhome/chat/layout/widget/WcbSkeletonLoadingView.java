package com.larus.bmhome.chat.layout.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.graphics.ColorUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0002:;B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014J(\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0014J\b\u0010(\u001a\u00020\u001fH\u0014J\b\u0010)\u001a\u00020\u001fH\u0014J\u0018\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u000200H\u0014J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u000203H\u0014J\u0018\u00104\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u00020\u001fH\u0002J\b\u00106\u001a\u00020\u001fH\u0002J\b\u00107\u001a\u00020\u001fH\u0002J\b\u00108\u001a\u00020\u001fH\u0002J\b\u00109\u001a\u00020\u001fH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/WcbSkeletonLoadingView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "strokePaint", "Landroid/graphics/Paint;", "blockPaint", "shimmerPaint", "outerRect", "Landroid/graphics/RectF;", "blockRect", "shimmerPath", "Landroid/graphics/Path;", "shimmerMatrix", "Landroid/graphics/Matrix;", "style", "Lcom/larus/bmhome/chat/layout/widget/WcbSkeletonLoadingView$Style;", "shimmerGradient", "Landroid/graphics/LinearGradient;", "animator", "Landroid/animation/ValueAnimator;", "shimmerWidth", "", "shimmerHighlightColor", "setStyle", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "width", "height", "oldWidth", "oldHeight", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", RemoteMessageConst.Notification.VISIBILITY, "onWindowVisibilityChanged", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "rebuildDrawingState", "rebuildGradient", "refreshColors", "updateAnimationState", "startShimmer", "stopShimmer", "Style", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WcbSkeletonLoadingView extends View {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f304940m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f304941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f304942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f304943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f304944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f304945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f304946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Matrix f304947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Style f304948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearGradient f304949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ValueAnimator f304950j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f304951k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f304952l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/WcbSkeletonLoadingView$Style;", "", "<init>", "(Ljava/lang/String;I)V", "SUGGEST", "TITLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        public static final Style SUGGEST = null;
        public static final Style TITLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f304953a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f304954b = null;

        public static EnumEntries<Style> getEntries() {
            return f304954b;
        }

        static {
            Style r100 = new Style("SUGGEST", 0);
            SUGGEST = r100;
            Style r101 = new Style("TITLE", 1);
            TITLE = r101;
            Style[] r102 = {r100, r101};
            f304953a = r102;
            f304954b = EnumEntriesKt.enumEntries(r102);
        }

        public static Style[] values() {
            return (Style[]) f304953a.clone();
        }

        public static Style valueOf(String r100) {
            return (Style) r27.a.a(Style.class, r100);
        }

        public Style(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f304955a = null;

        static {
            int[] r100 = new int[Style.values().length];
            r100[Style.SUGGEST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Style.TITLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f304955a = r100;
        }
    }

    static {
    }

    public WcbSkeletonLoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public WcbSkeletonLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void d() {
        ValueAnimator r100 = this.f304950j;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f304950j = null;
        this.f304947g.reset();
        LinearGradient r101 = this.f304949i;
        if (r101 == null) goto L9;
        r101.setLocalMatrix(this.f304947g);
        return;
    }

    public final void b() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        this.f304951k = getWidth() * 0.65f;
        LinearGradient r100 = new LinearGradient(0.0f, 0.0f, this.f304951k, 0.0f, new int[]{0, this.f304952l, 0}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.f304943c.setShader(r100);
        this.f304949i = r100;
    }

    public final void c() {
        int r100 = v19.c.a(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100);
        this.f304942b.setColor(ColorUtils.setAlphaComponent(r100, 10));
        this.f304952l = ColorUtils.setAlphaComponent(r100, 18);
        this.f304941a.setColor(v19.c.a(R.attr.larus_neutral_transparent_2, getContext(), R.color.larus_neutral_transparent_2_day));
    }

    public final void e() {
        if (isAttachedToWindow() == true) goto L5;
    L23:
        d();
        return;
    L5:
        if (isShown() == false) goto L23;
        if (getWindowVisibility() != 0) goto L23;
        if (getWidth() <= 0) goto L23;
        if (getHeight() <= 0) goto L23;
        ValueAnimator r100 = this.f304950j;
        if (r100 != null) goto L15;
    L17:
        boolean r101 = false;
    L18:
        if (r101 == false) goto L20;
        return;
    L20:
        if (this.f304949i == null) goto L27;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{-this.f304951k, getWidth() + this.f304951k});
        r102.setDuration(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
        r102.setRepeatCount(-1);
        r102.setInterpolator(new LinearInterpolator());
        r102.addUpdateListener(new n1(this));
        r102.start();
        this.f304950j = r102;
        return;
    L27:
        return;
    L15:
        if (r100.isRunning() != true) goto L17;
        r101 = true;
        goto L18
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        d();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        c();
        b();
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f304948h != Style.SUGGEST) goto L5;
        r100.drawRoundRect(this.f304944d, c7.b(8), c7.b(8), this.f304941a);
    L5:
        r100.drawRoundRect(this.f304945e, c7.b(6), c7.b(6), this.f304942b);
        if (this.f304949i != null) goto L8;
        return;
    L8:
        int r101 = r100.save();
        r100.clipPath(this.f304946f);
        r100.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f304943c);
        r100.restoreToCount(r101);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        e();
    }

    public final void setStyle(Style r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        if (this.f304948h != r100) goto L5;
        return;
    L5:
        this.f304948h = r100;
        requestLayout();
        a(getWidth(), getHeight());
        invalidate();
    }

    public final void a(int r100, int r101) {
        if (r100 <= 0) goto L15;
        if (r101 <= 0) goto L16;
        this.f304946f.reset();
        float r102 = this.f304941a.getStrokeWidth() / 2.0f;
        float r103 = r100;
        float r104 = r101;
        this.f304944d.set(r102, r102, r103 - r102, r104 - r102);
        int r105 = b.f304955a[this.f304948h.ordinal()];
        if (r105 != 1) goto L8;
        float r106 = c7.b(12);
        float r107 = c7.b(12);
        this.f304945e.set(r106, r107, r103 - r106, r104 - r107);
    L13:
        this.f304946f.addRoundRect(this.f304945e, c7.b(6), c7.b(6), Path.Direction.CW);
        b();
        return;
    L8:
        if (r105 != 2) goto L11;
        this.f304945e.set(0.0f, 0.0f, r103, r104);
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
    L16:
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        Style r102 = this.f304948h;
        int[] r103 = b.f304955a;
        int r104 = r103[r102.ordinal()];
        if (r104 == 1) goto L8;
        if (r104 != 2) goto L7;
        int r105 = c7.b(56);
    L9:
        int r106 = r103[this.f304948h.ordinal()];
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        int r107 = c7.b(12);
    L16:
        setMeasuredDimension(View.resolveSize(r105, r100), View.resolveSize(r107, r101));
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        r107 = c7.b(36);
        goto L16
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r105 = c7.b(102);
        goto L9
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        e();
    }

    public WcbSkeletonLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeWidth(c7.b(1));
        this.f304941a = r103;
        this.f304942b = new Paint(1);
        this.f304943c = new Paint(1);
        this.f304944d = new RectF();
        this.f304945e = new RectF();
        this.f304946f = new Path();
        this.f304947g = new Matrix();
        this.f304948h = Style.SUGGEST;
        setImportantForAccessibility(2);
        c();
    }

    public /* synthetic */ WcbSkeletonLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        d();
        a(r100, r101);
        e();
    }
}
