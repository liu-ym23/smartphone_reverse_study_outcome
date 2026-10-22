package com.bytedance.dux.indicator;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/dux/indicator/DuxCarouselIndicator;", "Lcom/bytedance/dux/indicator/DuxBaseIndicator;", "", "value", OfficeSDKRequestTag.KEY_NEW_USER, FaceService.girlLabel, "getDotsWidthFactor", "()F", "setDotsWidthFactor", "(F)V", "dotsWidthFactor", "", "o", "I", "getSelectedDotColor", "()I", "setSelectedDotColor", "(I)V", "selectedDotColor", "Lcom/bytedance/dux/indicator/DuxBaseIndicator$a;", "getCustom", "()Lcom/bytedance/dux/indicator/DuxBaseIndicator$a;", "custom", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxCarouselIndicator extends DuxBaseIndicator {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final DuxComponent f205216q = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinearLayout f205217m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f205218n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f205219o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArgbEvaluator f205220p;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxCarouselIndicator f205221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f205222b;

        public b(DuxCarouselIndicator r100, int r101) {
            this.f205221a = r100;
            this.f205222b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f205221a.getDotsClickable() == false) goto L13;
            int r101 = this.f205222b;
            DuxBaseIndicator.b r102 = this.f205221a.getPager();
            if (r102 == null) goto L7;
            int r103 = r102.getCount();
        L8:
            if (r101 >= r103) goto L14;
            DuxBaseIndicator.b r104 = this.f205221a.getPager();
            if (r104 == null) goto L15;
            r104.a(this.f205222b);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r103 = 0;
            goto L8
        }
    }

    public DuxCarouselIndicator(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public DuxCarouselIndicator(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public DuxCarouselIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    static {
        f205216q = DuxComponent.CAROUSEL_INDICATOR;
    }

    @Override // com.bytedance.dux.indicator.DuxBaseIndicator
    public final com.bytedance.dux.indicator.a c() {
        return new com.bytedance.dux.indicator.a(this);
    }

    @Override // com.bytedance.dux.indicator.DuxBaseIndicator
    public DuxBaseIndicator.a getCustom() {
        if (getLimitLargeFontScale() == false) goto L5;
        float r100 = 6 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f);
        Resources r101 = Resources.getSystem();
        float r102 = TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    L6:
        Resources r103 = Resources.getSystem();
        return new DuxBaseIndicator.a(r102, TypedValue.applyDimension(1, 3, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())), new int[]{R.attr.dotsClickable, R.attr.dotsColor, R.attr.dotsCornerRadius, R.attr.dotsSize, R.attr.dotsSpacing, R.attr.dotsStrokeColor, R.attr.dotsStrokeWidth, R.attr.dotsWidthFactor, R.attr.selectedDotColor});
    L5:
        Resources r104 = Resources.getSystem();
        r102 = TypedValue.applyDimension(2, 6, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()));
        goto L6
    }

    @Override // com.bytedance.dux.indicator.DuxBaseIndicator
    public final void h() {
        LinearLayout r100 = this.f205217m;
        LinearLayout r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
        r100 = null;
    L5:
        LinearLayout r102 = this.f205217m;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L9:
        r100.removeViewAt(r101.getChildCount() - 1);
        ArrayList<View> r103 = this.f205186c;
        ListProtector.remove(r103, r103.size() - 1);
        return;
    L8:
        r101 = r102;
        goto L9
    }

    public final float getDotsWidthFactor() {
        return this.f205218n;
    }

    public final int getSelectedDotColor() {
        return this.f205219o;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.dux.indicator.DuxBaseIndicator
    public final void b(int r100) {
        ImageView r101 = new ImageView(getContext());
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams((int) getDotsSize(), (int) getDotsSize());
        boolean r103 = false;
        r102.setMargins((int) getDotsSpacing(), 0, (int) getDotsSpacing(), 0);
        r101.setLayoutParams(r102);
        GradientDrawable r104 = new GradientDrawable();
        r104.setCornerRadius(getDotsCornerRadius());
        if (isInEditMode() == false) goto L8;
        if (r100 != 0) goto L6;
        int r105 = this.f205219o;
    L7:
        r104.setColor(r105);
    L17:
        r104.setStroke((int) getDotsStrokeWidth(), getDotsStrokeColor());
        r101.setBackground(r104);
        r101.setOnClickListener(new b(this, r100));
        r101.setImportantForAccessibility(2);
        this.f205186c.add(r101);
        LinearLayout r106 = this.f205217m;
        if (r106 != 0) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
        r106 = null;
    L20:
        r106.addView(r101);
        return;
    L6:
        r105 = getDotsColor();
        goto L7
    L8:
        DuxBaseIndicator.b r107 = getPager();
        if (r107 != null) goto L11;
    L13:
        if (r103 == false) goto L15;
        int r108 = this.f205219o;
    L16:
        r104.setColor(r108);
        goto L17
    L15:
        r108 = getDotsColor();
        goto L16
    L11:
        if (r107.getCurrentItem() != r100) goto L13;
        r103 = true;
        goto L13
    }

    @Override // com.bytedance.dux.indicator.DuxBaseIndicator
    public final void d(int r100) {
        View r101 = (View) ListProtector.get(this.f205186c, r100);
        Drawable r102 = r101.getBackground();
        if ((r102 instanceof GradientDrawable) == false) goto L5;
        GradientDrawable r103 = (GradientDrawable) r102;
    L6:
        if (r103 == null) goto L11;
        DuxBaseIndicator.b r104 = getPager();
        Intrinsics.checkNotNull(r104);
        if (r100 != r104.getCurrentItem()) goto L10;
        r103.setColor(this.f205219o);
        goto L11
    L10:
        r103.setColor(getDotsColor());
    L11:
        if (r103 == null) goto L14;
        r103.setCornerRadius(getDotsCornerRadius());
    L14:
        if (r103 == null) goto L16;
        r103.setStroke((int) getDotsStrokeWidth(), getDotsStrokeColor());
    L16:
        r101.setBackground(r103);
        r101.invalidate();
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void setDotsWidthFactor(float r100) {
        if (this.f205218n != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        if (r100 >= 1.0f) goto L10;
        r100 = 2.667f;
    L10:
        this.f205218n = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setSelectedDotColor(int r100) {
        if (this.f205219o == r100) goto L6;
        this.f205219o = r100;
        f();
        return;
    }

    public DuxCarouselIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        LinearLayout r104 = null;
        if ((r103 & 2) == 0) goto L5;
        r101 = null;
    L5:
        int r105 = 0;
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, false);
        Lazy r106 = DuxLargeFontHelper.f205243a;
        DuxLargeFontHelper.a(f205216q, null);
        this.f205218n = 2.667f;
        this.f205219o = getDotsColor();
        this.f205220p = new ArgbEvaluator();
        LinearLayout r107 = new LinearLayout(getContext());
        this.f205217m = r107;
        r107.setOrientation(0);
        LinearLayout r108 = this.f205217m;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L12:
        addView(r104, -2, -2);
        if (r101 == null) goto L16;
        TypedArray r109 = getContext().obtainStyledAttributes(r101, getCustom().f205198c);
        setSelectedDotColor(r109.getColor(8, getDotsColor()));
        setDotsWidthFactor(r109.getFloat(7, this.f205218n));
        r109.recycle();
    L16:
        if (isInEditMode() == false) goto L24;
        int r110 = this.f205186c.size();
    L19:
        if (r105 >= 5) goto L21;
        b(r105 + r110);
        r105 = r105 + 1;
        goto L19
    L21:
        e();
        return;
    L24:
        return;
    L11:
        r104 = r108;
        goto L12
    }
}
