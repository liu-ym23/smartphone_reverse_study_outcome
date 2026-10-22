package com.bytedance.dux.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.c;
import em4.n;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0017\u0018J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/dux/widget/DuxCheckBox;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "", "adaptLargeFont", "", "setAdaptLargeFontInternal", "(Ljava/lang/Boolean;)V", "", "type", "setShape", "setSize", "light", "setAlwaysLight", "Landroid/graphics/drawable/Drawable;", "drawable", "setButtonDrawable", "setAdaptLargeFont", "newValue", "setChecked", "Lcom/bytedance/dux/widget/DuxCheckBox$b;", "listener", "setOnCheckedChangeListener", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "dux_release"}, k = 1, mv = {1, 7, 1})
public class DuxCheckBox extends AppCompatImageView implements Checkable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f205879m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final DuxComponent f205880n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f205881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f205882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f205883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f205884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f205885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f205886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorFilter f205887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorFilter f205888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f205889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f205890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f205891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f205892l;

    public static final class a {
    }

    public interface b {
    }

    public DuxCheckBox(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 30);
    }

    public DuxCheckBox(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 28);
    }

    public DuxCheckBox(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 24);
    }

    public final void setOnCheckedChangeListener(b r100) {
    }

    static {
        f205879m = new int[]{R.attr.state_checked};
        f205880n = DuxComponent.CHECK_BOX;
    }

    public final void createColorFilter() {
        int r100 = this.f205889i;
        if (r100 == (-1)) goto L6;
        int r101 = c.f473060a;
        this.f205887g = new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(r100), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(r100), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(r100), 0.0f, 0.0f, 0.0f, (Color.alpha(r100) * 1.0f) / 255, 0.0f});
    L6:
        if (this.f205890j == (-1)) goto L9;
        this.f205888h = new PorterDuffColorFilter(this.f205890j, PorterDuff.Mode.SRC_IN);
        return;
    }

    public final void syncDrawableStyle() {
        int r100 = this.f205882b;
        if (r100 == 0) goto L5;
    L7:
        if (r100 == 0) goto L9;
    L11:
        if (r100 != 0) goto L13;
    L15:
        Drawable r101 = ContextCompat.getDrawable(getContext(), com.larus.nova.R.drawable.dux_checkbox_square);
    L16:
        setButtonDrawable(r101);
        return;
    L13:
        if (this.f205886f == false) goto L15;
        r101 = ContextCompat.getDrawable(getContext(), com.larus.nova.R.drawable.dux_checkbox_square_always_light);
        goto L16
    L9:
        if (this.f205886f == true) goto L11;
        r101 = ContextCompat.getDrawable(getContext(), com.larus.nova.R.drawable.dux_checkbox_circle);
        goto L16
    L5:
        if (this.f205886f == false) goto L7;
        r101 = ContextCompat.getDrawable(getContext(), com.larus.nova.R.drawable.dux_checkbox_circle_always_light);
        goto L16
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f205885e);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f205891k == false) goto L6;
        n.a(this, MathKt.roundToInt(TypedValue.applyDimension(1, 44, j(Resources.getSystem()))));
        return;
    }

    @Override // android.view.View
    public final boolean performClick() {
        toggle();
        boolean r100 = super.performClick();
        if (r100 == true) goto L5;
        playSoundEffect(0);
    L5:
        return r100;
    }

    public final void syncButtonCheckState() {
        Drawable r100 = getDrawable();
        if (r100 == null) goto L5;
        r100.clearColorFilter();
    L5:
        createColorFilter();
        Drawable r101 = getDrawable();
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f205885e == false) goto L11;
        ColorFilter r102 = this.f205887g;
    L12:
        r101.setColorFilter(r102);
        return;
    L11:
        r102 = this.f205888h;
        goto L12
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f205885e;
    }

    public static DisplayMetrics j(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final void setAdaptLargeFontInternal(Boolean r100) {
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f205892l = DuxLargeFontHelper.a(f205880n, r100);
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (this.f205885e == false) goto L5;
        View.mergeDrawableStates(r101, f205879m);
    L5:
        return r101;
    }

    public final void setAdaptLargeFont(Boolean r100) {
        setAdaptLargeFontInternal(r100);
        setSize(this.f205883c);
    }

    public final void setAlwaysLight(boolean r100) {
        this.f205886f = r100;
        syncDrawableStyle();
        invalidate();
    }

    public final void setButtonDrawable(Drawable r100) {
        setImageDrawable(r100);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.f205885e == r100) goto L6;
        this.f205885e = r100;
        syncButtonCheckState();
        refreshDrawableState();
        return;
    }

    public final void setShape(int r100) {
        this.f205882b = r100;
        syncDrawableStyle();
        invalidate();
    }

    public final void setSize(int r100) {
        this.f205883c = r100;
        if (r100 != 0) goto L14;
        boolean r101 = this.f205892l;
        if (r101 == true) goto L7;
    L9:
        if (r101 == true) goto L11;
    L13:
        int r102 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, j(Resources.getSystem())));
    L24:
        this.f205884d = r102;
        requestLayout();
        return;
    L11:
        if (this.f205881a == true) goto L13;
        r102 = MathKt.roundToInt(TypedValue.applyDimension(2, 16, j(Resources.getSystem())));
        goto L24
    L7:
        if (this.f205881a == false) goto L9;
        r102 = MathKt.roundToInt(TypedValue.applyDimension(1, 16 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), j(Resources.getSystem())));
        goto L24
    L14:
        boolean r103 = this.f205892l;
        if (r103 == true) goto L17;
    L19:
        if (r103 == true) goto L21;
    L23:
        r102 = MathKt.roundToInt(TypedValue.applyDimension(1, 20, j(Resources.getSystem())));
        goto L24
    L21:
        if (this.f205881a == true) goto L23;
        r102 = MathKt.roundToInt(TypedValue.applyDimension(2, 20, j(Resources.getSystem())));
        goto L24
    L17:
        if (this.f205881a == false) goto L19;
        r102 = MathKt.roundToInt(TypedValue.applyDimension(1, 20 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), j(Resources.getSystem())));
        goto L24
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = this.f205884d;
        if (r102 <= 0) goto L5;
        r100 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
    L5:
        int r103 = this.f205884d;
        if (r103 <= 0) goto L8;
        r101 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
    L8:
        super.onMeasure(r100, r101);
    }

    public DuxCheckBox(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f205881a = false;
        this.f205889i = -1;
        this.f205890j = -1;
        this.f205891k = true;
        Lazy r104 = DuxLargeFontHelper.f205243a;
        this.f205892l = DuxLargeFontHelper.a(f205880n, null);
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.adaptLargeFontMode, com.larus.nova.R.attr.adapt_for_csr, com.larus.nova.R.attr.dux_checkBoxAlwaysLight, com.larus.nova.R.attr.dux_checkBoxButton, com.larus.nova.R.attr.dux_checkBoxCheckedColor, com.larus.nova.R.attr.dux_checkBoxClickable, com.larus.nova.R.attr.dux_checkBoxShape, com.larus.nova.R.attr.dux_checkBoxSize, com.larus.nova.R.attr.dux_checkBoxUncheckedColor, com.larus.nova.R.attr.limitLargeFontScale}, r102, 0);
        this.f205882b = r105.getInt(6, 0);
        this.f205883c = r105.getInt(7, 0);
        this.f205891k = r105.getBoolean(1, true);
        this.f205889i = r105.getColor(4, -1);
        this.f205890j = r105.getColor(8, -1);
        this.f205886f = r105.getBoolean(2, false);
        setClickable(r105.getBoolean(5, true));
        if (r105.hasValue(0) == false) goto L12;
        setAdaptLargeFontInternal(Boolean.valueOf(r105.getBoolean(0, false)));
    L12:
        if (r105.hasValue(9) == false) goto L14;
        this.f205881a = r105.getBoolean(9, false);
    L14:
        Drawable r106 = r105.getDrawable(3);
        r105.recycle();
        createColorFilter();
        if (r106 == null) goto L17;
        setButtonDrawable(r106);
    L18:
        setBackground(null);
        syncButtonCheckState();
        return;
    L17:
        setShape(this.f205882b);
        setSize(this.f205883c);
        goto L18
    }
}
