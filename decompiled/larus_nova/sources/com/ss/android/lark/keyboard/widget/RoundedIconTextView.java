package com.ss.android.lark.keyboard.widget;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.ImageViewCompat;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b!\u0018\u0000 o2\u00020\u0001:\u0001oB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010C\u001a\u00020DH\u0002J\u001a\u0010E\u001a\u00020D2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010F\u001a\u00020DH\u0002J\u0010\u0010G\u001a\u00020D2\u0006\u0010H\u001a\u00020IH\u0014J\u0006\u0010J\u001a\u00020\u001aJ\u0006\u0010K\u001a\u00020\u001cJ\u000e\u0010L\u001a\u00020D2\u0006\u0010M\u001a\u00020\u0007J\u0016\u0010L\u001a\u00020D2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020OJ\b\u0010Q\u001a\u00020DH\u0002J\u000e\u0010R\u001a\u00020D2\u0006\u0010S\u001a\u00020OJ\u000e\u0010T\u001a\u00020D2\u0006\u0010U\u001a\u00020!J\u000e\u0010V\u001a\u00020D2\u0006\u0010W\u001a\u00020!J\u0016\u0010V\u001a\u00020D2\u0006\u0010W\u001a\u00020!2\u0006\u0010X\u001a\u00020!J\u0006\u0010 \u001a\u00020!J&\u0010Y\u001a\u00020D2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u0007J\u000e\u0010\\\u001a\u00020D2\u0006\u0010]\u001a\u00020!J\u000e\u0010^\u001a\u00020D2\u0006\u0010_\u001a\u00020\u0007J\u000e\u0010`\u001a\u00020D2\u0006\u0010_\u001a\u00020\u0007J\u000e\u0010a\u001a\u00020D2\u0006\u0010_\u001a\u00020\u0007J\u000e\u0010b\u001a\u00020D2\u0006\u0010_\u001a\u00020\u0007J\u000e\u0010c\u001a\u00020D2\u0006\u0010_\u001a\u00020\u0007J\u000e\u0010d\u001a\u00020D2\u0006\u0010_\u001a\u00020\u0007J\u000e\u0010e\u001a\u00020D2\u0006\u0010f\u001a\u00020!J\u0012\u0010g\u001a\u00020D2\b\b\u0002\u0010h\u001a\u00020!H\u0002J\u0010\u0010i\u001a\u00020D2\u0006\u0010j\u001a\u00020\u000eH\u0002J\u0010\u0010k\u001a\u00020D2\u0006\u0010l\u001a\u00020\u000eH\u0002J\u0010\u0010m\u001a\u00020\u000e2\u0006\u0010n\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u0012\u0010)\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u0012\u0010*\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u0012\u0010+\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00107\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b8\u00109R\u001b\u0010<\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010;\u001a\u0004\b=\u00109R\u000e\u0010?\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010@\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010;\u001a\u0004\bA\u00109¨\u0006p"}, d2 = {"Lcom/ss/android/lark/keyboard/widget/RoundedIconTextView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkedCloseTintColor", "borderColor", "backgroundColor", "borderWidth", "", "cornerRadius", "contentPaddingLeft", "contentPaddingTop", "contentPaddingRight", "contentPaddingBottom", "backgroundPaint", "Landroid/graphics/Paint;", "borderPaint", SVGRenderEngine.RECT, "Landroid/graphics/RectF;", "iconView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "closeView", "originTypeface", "Landroid/graphics/Typeface;", "isChecked", "", "uncheckedBackgroundColor", "uncheckedBorderColor", "uncheckedTextColor", "Ljava/lang/Integer;", "uncheckedIconTint", "Landroid/content/res/ColorStateList;", "checkedBackgroundColor", "checkedBorderColor", "checkedTextColor", "checkedIconTintColor", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "premultipliedArgbEvaluator", "Landroid/animation/TypeEvaluator;", "bgAnimator", "Landroid/animation/ValueAnimator;", "borderAnimator", "textAnimator", "tintAnimator", "closeAnimator", "closeIconProgress", "closeIconSizePx", "getCloseIconSizePx", "()I", "closeIconSizePx$delegate", "Lkotlin/Lazy;", "closeIconSpacingPx", "getCloseIconSpacingPx", "closeIconSpacingPx$delegate", "iconSize", "textStartMarginWithIconPx", "getTextStartMarginWithIconPx", "textStartMarginWithIconPx$delegate", "initContentView", "", "parseAttributes", "initPaints", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getIconView", "getTextView", "setIcon", "resourceId", "resKey", "", "entityId", "updateTextStartMargin", "setText", "text", "setTextBold", CommodityText.BOLD, "setChecked", "checked", "animate", "setCheckedStyle", "textColor", "iconTintColor", "setInputTopActionCheckedStyle", "isEnterpriseAccount", "setCheckedBackgroundColor", "color", "setCheckedBorderColor", "setCheckedTextColor", "setCheckedIconTintColor", "setBorderColor", "setCustomBackgroundColor", "setBoarderVisible", "isVisible", "applyCheckedStateIfNeed", "force", "animateCloseIconProgress", PickerReporterConstants.KEY.TARGET, "applyCloseIconProgress", "progress", "dpToPx", "dp", "Companion", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoundedIconTextView extends FrameLayout {
    public static final PathInterpolator F = null;
    public static final LinearInterpolator G = null;
    public ValueAnimator A;
    public float B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f431006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f431007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f431008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f431009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f431010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f431011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f431012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f431013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f431014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f431015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f431016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f431017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f431018m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f431019n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f431020o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ColorStateList f431021p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f431022q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f431023r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Integer f431024s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f431025t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArgbEvaluator f431026u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f431027v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ValueAnimator f431028w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ValueAnimator f431029x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ValueAnimator f431030y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ValueAnimator f431031z;

    public static final class a {
    }

    public static final class b<T> implements TypeEvaluator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f431032a = null;

        static {
            f431032a = new b();
        }

        public b() {
        }

        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float r100, Object r101, Object r110) {
            Integer r102 = (Integer) r101;
            Integer r111 = (Integer) r110;
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
            int r103 = r102.intValue();
            Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.Int");
            int r112 = r111.intValue();
            float r104 = Color.alpha(r103) / 255.0f;
            float r105 = Color.red(r103) / 255.0f;
            float r106 = Color.green(r103) / 255.0f;
            float r107 = Color.blue(r103) / 255.0f;
            float r108 = Color.alpha(r112) / 255.0f;
            float r109 = Color.red(r112) / 255.0f;
            float r113 = r105 * r104;
            float r114 = r106 * r104;
            float r115 = r107 * r104;
            float r116 = (Color.green(r112) / 255.0f) * r108;
            float r117 = r104 + ((r108 - r104) * r100);
            float r118 = r113 + (((r109 * r108) - r113) * r100);
            float r119 = r114 + ((r116 - r114) * r100);
            float r120 = r115 + ((((Color.blue(r112) / 255.0f) * r108) - r115) * r100);
            if (r117 > 0.0f) goto L6;
            return 0;
        L6:
            return Integer.valueOf(Color.argb(RangesKt.coerceIn((int) (r117 * 255.0f), 0, 255), RangesKt.coerceIn((int) (RangesKt.coerceIn(r118 / r117, 0.0f, 1.0f) * 255.0f), 0, 255), RangesKt.coerceIn((int) (RangesKt.coerceIn(r119 / r117, 0.0f, 1.0f) * 255.0f), 0, 255), RangesKt.coerceIn((int) (RangesKt.coerceIn(r120 / r117, 0.0f, 1.0f) * 255.0f), 0, 255)));
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoundedIconTextView f431033a;

        public c(RoundedIconTextView r100) {
            this.f431033a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
            int r102 = ((Integer) r101).intValue();
            RoundedIconTextView r103 = this.f431033a;
            r103.f431008c = r102;
            r103.f431011f.setColor(r102);
            this.f431033a.invalidate();
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoundedIconTextView f431034a;

        public d(RoundedIconTextView r100) {
            this.f431034a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
            int r102 = ((Integer) r101).intValue();
            RoundedIconTextView r103 = this.f431034a;
            r103.f431007b = r102;
            r103.f431012g.setColor(r102);
            this.f431034a.invalidate();
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoundedIconTextView f431035a;

        public e(RoundedIconTextView r100) {
            this.f431035a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            TextView r101 = this.f431035a.f431015j;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            r101 = null;
        L5:
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
            r101.setTextColor(((Integer) r102).intValue());
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoundedIconTextView f431036a;

        public f(RoundedIconTextView r100) {
            this.f431036a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
            int r102 = ((Integer) r101).intValue();
            ImageView r103 = this.f431036a.f431014i;
            if (r103 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
            r103 = null;
        L5:
            ImageViewCompat.setImageTintList(r103, ColorStateList.valueOf(r102));
        }
    }

    public RoundedIconTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RoundedIconTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        F = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
        G = new LinearInterpolator();
    }

    private final int getCloseIconSizePx() {
        return ((Number) this.C.getValue()).intValue();
    }

    private final int getCloseIconSpacingPx() {
        return ((Number) this.D.getValue()).intValue();
    }

    private final int getTextStartMarginWithIconPx() {
        return ((Number) this.E.getValue()).intValue();
    }

    public final void f() {
        TextView r100 = this.f431015j;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f431014i == null) goto L35;
        TextView r101 = null;
        if (r100 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r100 = null;
    L10:
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof LinearLayout.LayoutParams) == false) goto L13;
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r102;
    L14:
        if (r103 != null) goto L16;
        return;
    L16:
        ImageView r104 = this.f431014i;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r104 = null;
    L19:
        int r105 = 0;
        if (r104.getVisibility() != 0) goto L22;
        boolean r106 = true;
    L23:
        if (r106 == false) goto L26;
        r105 = getTextStartMarginWithIconPx();
    L26:
        if (r103.getMarginStart() != r105) goto L28;
        return;
    L28:
        r103.setMarginStart(r105);
        TextView r107 = this.f431015j;
        if (r107 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L32:
        r101.setLayoutParams(r103);
        return;
    L31:
        r101 = r107;
        goto L32
    L22:
        r106 = false;
        goto L23
    L13:
        r103 = null;
        goto L14
    }

    public final ImageView getIconView() {
        ImageView r100 = this.f431014i;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        return null;
    L6:
        return r100;
    }

    public final TextView getTextView() {
        TextView r100 = this.f431015j;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        return null;
    L6:
        return r100;
    }

    public final void a(boolean r100) {
        if (this.f431015j != null) goto L5;
        return;
    L5:
        if (this.f431014i != null) goto L7;
        return;
    L7:
        if (this.f431016k == null) goto L69;
        if (r100 == false) goto L11;
    L13:
        ImageView r101 = null;
        if (this.f431017l == false) goto L47;
        Integer r102 = this.f431022q;
        if (r102 == null) goto L18;
        int r103 = r102.intValue();
    L19:
        Integer r104 = this.f431023r;
        if (r104 == null) goto L22;
        int r105 = r104.intValue();
    L23:
        Integer r106 = this.f431024s;
        if (r106 == null) goto L26;
    L25:
        int r107 = r106.intValue();
    L33:
        Integer r108 = this.f431025t;
        this.f431008c = r103;
        this.f431011f.setColor(r103);
        this.f431007b = r105;
        this.f431012g.setColor(r105);
        TextView r109 = this.f431015j;
        if (r109 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r109 = null;
    L36:
        r109.setTextColor(r107);
        if (r108 == null) goto L42;
        ImageView r110 = this.f431014i;
        if (r110 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r110 = null;
    L41:
        ImageViewCompat.setImageTintList(r110, ColorStateList.valueOf(r108.intValue()));
    L42:
        ImageView r111 = this.f431016k;
        if (r111 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
    L46:
        ImageViewCompat.setImageTintList(r101, ColorStateList.valueOf(this.f431006a));
    L62:
        if (this.f431017l == false) goto L64;
        float r112 = 1.0f;
    L65:
        b(r112);
        invalidate();
        return;
    L64:
        r112 = 0.0f;
        goto L65
    L45:
        r101 = r111;
        goto L46
    L26:
        r106 = this.f431020o;
        if (r106 != null) goto L25;
        TextView r113 = this.f431015j;
        if (r113 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r113 = null;
    L32:
        r107 = r113.getCurrentTextColor();
        goto L33
    L22:
        r105 = this.f431019n;
        goto L23
    L18:
        r103 = this.f431018m;
        goto L19
    L47:
        int r114 = this.f431018m;
        this.f431008c = r114;
        this.f431011f.setColor(r114);
        int r115 = this.f431019n;
        this.f431007b = r115;
        this.f431012g.setColor(r115);
        Integer r116 = this.f431020o;
        if (r116 == null) goto L53;
        int r117 = r116.intValue();
        TextView r118 = this.f431015j;
        if (r118 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r118 = null;
    L52:
        r118.setTextColor(r117);
    L53:
        ImageView r119 = this.f431014i;
        if (r119 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r119 = null;
    L56:
        ImageViewCompat.setImageTintList(r119, this.f431021p);
        ImageView r120 = this.f431016k;
        if (r120 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
    L60:
        ImageViewCompat.setImageTintList(r101, this.f431021p);
        goto L62
    L59:
        r101 = r120;
        goto L60
    L11:
        if (this.f431017l == true) goto L13;
        return;
    }

    public final void b(float r100) {
        this.B = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        ImageView r101 = this.f431016k;
        if (r101 != null) goto L5;
        return;
    L5:
        ImageView r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
        r101 = null;
    L8:
        r101.setAlpha(this.B);
        ImageView r103 = this.f431016k;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
        r103 = null;
    L11:
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if ((r104 instanceof LinearLayout.LayoutParams) == false) goto L14;
        LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) r104;
    L15:
        if (r105 != null) goto L17;
        return;
    L17:
        r105.width = (int) (getCloseIconSizePx() * this.B);
        r105.setMarginStart((int) (getCloseIconSpacingPx() * this.B));
        ImageView r106 = this.f431016k;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
    L21:
        r102.setLayoutParams(r105);
        return;
    L20:
        r102 = r106;
        goto L21
    L14:
        r105 = null;
        goto L15
    }

    public final float c(float r100) {
        Resources r101 = getContext().getResources();
        return r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        RectF r101 = this.f431013h;
        float r102 = this.f431009d;
        float r103 = 2;
        r101.set(r102 / r103, r102 / r103, getWidth() - (this.f431009d / r103), getHeight() - (this.f431009d / r103));
        RectF r104 = this.f431013h;
        float r105 = this.f431010e;
        r100.drawRoundRect(r104, r105, r105, this.f431011f);
        RectF r106 = this.f431013h;
        float r107 = this.f431010e;
        r100.drawRoundRect(r106, r107, r107, this.f431012g);
    }

    public final void setBoarderVisible(boolean r100) {
        if (r100 == false) goto L4;
        float r101 = c(2.0f);
    L5:
        this.f431009d = r101;
        this.f431012g.setStrokeWidth(r101);
        invalidate();
        return;
    L4:
        r101 = 0.0f;
        goto L5
    }

    public final void setBorderColor(int r100) {
        this.f431019n = r100;
        if (this.f431017l == true) goto L6;
        this.f431007b = r100;
        this.f431012g.setColor(r100);
        invalidate();
        return;
    }

    public final void setChecked(boolean r100) {
        d(r100, false);
    }

    public final void setCheckedBackgroundColor(int r100) {
        this.f431022q = Integer.valueOf(r100);
        a(true);
    }

    public final void setCheckedBorderColor(int r100) {
        this.f431023r = Integer.valueOf(r100);
        a(true);
    }

    public final void setCheckedIconTintColor(int r100) {
        this.f431025t = Integer.valueOf(r100);
        a(true);
    }

    public final void setCheckedTextColor(int r100) {
        this.f431024s = Integer.valueOf(r100);
        a(true);
    }

    public final void setCustomBackgroundColor(int r100) {
        this.f431018m = r100;
        if (this.f431017l == true) goto L6;
        this.f431008c = r100;
        this.f431011f.setColor(r100);
        invalidate();
        return;
    }

    public final void setIcon(int r100) {
        ImageView r101 = this.f431014i;
        ImageView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r101 = null;
    L5:
        r101.setImageResource(r100);
        ImageView r103 = this.f431014i;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L9:
        r102.setVisibility(0);
        f();
        a(true);
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void setInputTopActionCheckedStyle(boolean r100) {
        if (r100 == false) goto L4;
        this.f431006a = UIUtils.getColor(getContext(), R.color.flow_ud_neutral_transparent_4);
        e(0, UIUtils.getColor(getContext(), R.color.flow_ud_neutral_100), UIUtils.getColor(getContext(), R.color.flow_ud_neutral_100), UIUtils.getColor(getContext(), R.color.flow_ud_neutral_100));
        return;
    L4:
        this.f431006a = UIUtils.getColor(getContext(), R.color.flow_ud_primary_transparent_4);
        e(UIUtils.getColor(getContext(), R.color.flow_ud_primary_transparent_3), UIUtils.getColor(getContext(), R.color.flow_ud_primary_transparent_1), UIUtils.getColor(getContext(), R.color.flow_ud_primary_50), UIUtils.getColor(getContext(), R.color.flow_ud_primary_50));
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f431015j;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r101 = null;
    L5:
        r101.setText(r100);
        a(true);
    }

    public final void setTextBold(boolean r100) {
        TextView r101 = this.f431015j;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r101 = null;
    L5:
        if (r100 == false) goto L7;
        int r102 = h18.e.f483540a;
        Typeface r103 = h18.e.b(getContext(), 1);
    L8:
        r101.setTypeface(r103);
        return;
    L7:
        int r104 = h18.e.f483540a;
        r103 = h18.e.b(getContext(), 0);
        goto L8
    }

    public final void d(boolean r110, boolean r111) {
        if (this.f431015j != null) goto L5;
        return;
    L5:
        if (this.f431014i != null) goto L7;
        return;
    L7:
        if (this.f431016k != null) goto L10;
        return;
    L10:
        if (this.f431017l != r110) goto L17;
        if (r111 == true) goto L17;
        if (r110 == false) goto L14;
        float r100 = 1.0f;
    L15:
        b(r100);
        return;
    L14:
        r100 = 0.0f;
    L17:
        ValueAnimator r101 = this.f431028w;
        if (r101 == null) goto L20;
        r101.cancel();
    L20:
        ValueAnimator r102 = this.f431029x;
        if (r102 == null) goto L23;
        r102.cancel();
    L23:
        ValueAnimator r103 = this.f431030y;
        if (r103 == null) goto L26;
        r103.cancel();
    L26:
        ValueAnimator r104 = this.f431031z;
        if (r104 == null) goto L29;
        r104.cancel();
    L29:
        ValueAnimator r105 = this.A;
        if (r105 == null) goto L32;
        r105.cancel();
    L32:
        int r106 = this.f431011f.getColor();
        int r107 = this.f431012g.getColor();
        TextView r108 = this.f431015j;
        ImageView r109 = null;
        if (r108 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r108 = null;
    L35:
        int r112 = r108.getCurrentTextColor();
        ImageView r113 = this.f431014i;
        if (r113 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r113 = null;
    L38:
        ColorStateList r114 = ImageViewCompat.getImageTintList(r113);
        if (r114 != null) goto L43;
        r114 = this.f431021p;
        if (r114 != null) goto L43;
        int r115 = UDColorUtils.getColor(getContext(), R.color.flow_ud_neutral_100);
    L45:
        if (r110 == false) goto L49;
        Integer r116 = this.f431022q;
        if (r116 == null) goto L49;
        int r117 = r116.intValue();
    L50:
        if (r110 == false) goto L54;
        Integer r118 = this.f431023r;
        if (r118 == null) goto L54;
        int r119 = r118.intValue();
    L55:
        if (r110 == false) goto L66;
        Integer r120 = this.f431024s;
        if (r120 != null) goto L68;
        r120 = this.f431020o;
        if (r120 != null) goto L68;
        TextView r121 = this.f431015j;
        if (r121 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r121 = null;
    L65:
        int r122 = r121.getCurrentTextColor();
    L73:
        if (r110 == false) goto L77;
        Integer r123 = this.f431025t;
        if (r123 == null) goto L80;
        int r124 = r123.intValue();
    L81:
        if (r110 == false) goto L83;
        int r125 = this.f431006a;
    L87:
        this.f431017l = r110;
        if (r111 == true) goto L95;
        a(true);
        if (r110 == false) goto L92;
        float r126 = 1.0f;
    L93:
        b(r126);
        return;
    L92:
        r126 = 0.0f;
        goto L93
    L95:
        ImageView r127 = this.f431016k;
        if (r127 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
    L99:
        ImageViewCompat.setImageTintList(r109, ColorStateList.valueOf(r125));
        ValueAnimator r128 = ValueAnimator.ofObject(this.f431027v, new Object[]{Integer.valueOf(r106), Integer.valueOf(r117)});
        r128.setDuration(200);
        LinearInterpolator r129 = G;
        r128.setInterpolator(r129);
        r128.addUpdateListener(new c(this));
        r128.start();
        this.f431028w = r128;
        ValueAnimator r130 = ValueAnimator.ofObject(this.f431027v, new Object[]{Integer.valueOf(r107), Integer.valueOf(r119)});
        r130.setDuration(200);
        r130.setInterpolator(r129);
        r130.addUpdateListener(new d(this));
        r130.start();
        this.f431029x = r130;
        ValueAnimator r131 = ValueAnimator.ofObject(this.f431026u, new Object[]{Integer.valueOf(r112), Integer.valueOf(r122)});
        r131.setDuration(200);
        r131.setInterpolator(r129);
        r131.addUpdateListener(new e(this));
        r131.start();
        this.f431030y = r131;
        ValueAnimator r132 = ValueAnimator.ofObject(this.f431026u, new Object[]{Integer.valueOf(r115), Integer.valueOf(r124)});
        r132.setDuration(200);
        r132.setInterpolator(r129);
        r132.addUpdateListener(new f(this));
        r132.start();
        this.f431031z = r132;
        if (r110 == false) goto L102;
        float r133 = 1.0f;
    L103:
        float r134 = this.B;
        if (r134 != r133) goto L106;
        boolean r135 = true;
    L107:
        if (r135 == true) goto L117;
        ValueAnimator r136 = this.A;
        if (r136 == null) goto L112;
        r136.cancel();
    L112:
        ValueAnimator r137 = ValueAnimator.ofFloat(new float[]{r134, r133});
        r137.setDuration(200);
        r137.setInterpolator(F);
        r137.addUpdateListener(new j(this));
        r137.addListener(new k(this, r133));
        r137.start();
        this.A = r137;
        return;
    L117:
        return;
    L106:
        r135 = false;
        goto L107
    L102:
        r133 = 0.0f;
        goto L103
    L98:
        r109 = r127;
        goto L99
    L83:
        ColorStateList r138 = this.f431021p;
        if (r138 == null) goto L86;
        r125 = r138.getDefaultColor();
        goto L87
    L86:
        r125 = r115;
    L80:
        r124 = r115;
        goto L81
    L77:
        ColorStateList r139 = this.f431021p;
        if (r139 == null) goto L80;
        r124 = r139.getDefaultColor();
    L68:
        r122 = r120.intValue();
        goto L73
    L66:
        r120 = this.f431020o;
        if (r120 != null) goto L68;
        TextView r140 = this.f431015j;
        if (r140 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r140 = null;
    L72:
        r122 = r140.getCurrentTextColor();
    L54:
        r119 = this.f431019n;
    L49:
        r117 = this.f431018m;
    L43:
        r115 = r114.getDefaultColor();
        goto L45
    }

    public RoundedIconTextView(final Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        this.f431006a = UIUtils.getColor(r100, R.color.flow_ud_primary_transparent_4);
        this.f431007b = UIUtils.getColor(r100, R.color.flow_ud_neutral_transparent_2);
        this.f431008c = UIUtils.getColor(r100, R.color.flow_ud_bg_base_3);
        this.f431009d = 2.0f;
        this.f431010e = c(8.0f);
        float r101 = c(12.0f);
        float r102 = c(8.0f);
        float r112 = c(12.0f);
        float r113 = c(8.0f);
        Paint r103 = new Paint(1);
        this.f431011f = r103;
        Paint r104 = new Paint(1);
        this.f431012g = r104;
        this.f431013h = new RectF();
        this.f431018m = this.f431008c;
        this.f431019n = this.f431007b;
        this.f431026u = new ArgbEvaluator();
        this.f431027v = b.f431032a;
        this.C = LazyKt.lazy(new RoundedIconTextView$closeIconSizePx$2(r100));
        this.D = LazyKt.lazy(new RoundedIconTextView$closeIconSpacingPx$2(r100));
        UIUtils.dp2px(r100, 14.0f);
        this.E = LazyKt.lazy(new RoundedIconTextView$textStartMarginWithIconPx$2(r100));
        LayoutInflater.from(getContext()).inflate(R.layout.rounded_icon_text_view, this, true);
        this.f431014i = (ImageView) findViewById(R.id.icon_view);
        this.f431015j = (TextView) findViewById(R.id.text_view);
        this.f431016k = (ImageView) findViewById(R.id.close_view);
        TextView r105 = this.f431015j;
        LinearLayout.LayoutParams r106 = null;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r105 = null;
    L5:
        r105.getTypeface();
        ImageView r107 = this.f431014i;
        if (r107 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r107 = null;
    L8:
        r107.setVisibility(8);
        f();
        ImageView r108 = this.f431016k;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
        r108 = null;
    L11:
        r108.setImportantForAccessibility(2);
        r108.setClickable(false);
        r108.setFocusable(false);
        r108.setAlpha(0.0f);
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if ((r109 instanceof LinearLayout.LayoutParams) == false) goto L14;
        r106 = (LinearLayout.LayoutParams) r109;
    L14:
        if (r106 == null) goto L16;
        r106.width = 0;
        r106.setMarginStart(0);
    L16:
        setPadding((int) r101, (int) r102, (int) r112, (int) r113);
        setWillNotDraw(false);
        r103.setColor(this.f431008c);
        r103.setStyle(Paint.Style.FILL);
        r104.setColor(this.f431007b);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeWidth(this.f431009d);
        this.f431018m = this.f431008c;
        this.f431019n = this.f431007b;
        this.f431020o = Integer.valueOf(UIUtils.getColor(r100, R.color.flow_ud_neutral_100));
        this.f431021p = ColorStateList.valueOf(UDColorUtils.getColor(r100, R.color.flow_ud_neutral_100));
    }

    public /* synthetic */ RoundedIconTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void e(int r100, int r101, int r102, int r103) {
        this.f431022q = Integer.valueOf(r100);
        this.f431023r = Integer.valueOf(r101);
        this.f431024s = Integer.valueOf(r102);
        this.f431025t = Integer.valueOf(r103);
        a(true);
    }
}
