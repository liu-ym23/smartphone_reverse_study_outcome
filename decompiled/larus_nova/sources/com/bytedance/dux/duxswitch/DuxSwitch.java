package com.bytedance.dux.duxswitch;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import em4.n;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/dux/duxswitch/DuxSwitch;", "Lcom/bytedance/dux/duxswitch/SwitchCompat;", "", "enable", "", "setAdaptLargeFontInternal", "(Ljava/lang/Boolean;)V", "checked", "setChecked", "setCheckedWithoutFeedback", "enabled", "setEnabled", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxSwitch extends SwitchCompat {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final DuxComponent f205017p0 = null;
    public boolean T;
    public final boolean U;
    public final boolean V;
    public final boolean W;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f205018k0;

    public static final class a {
    }

    public DuxSwitch(Context r100) {
        this(r100, null, 0, 30);
    }

    public DuxSwitch(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 28);
    }

    public DuxSwitch(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 24);
    }

    static {
        f205017p0 = DuxComponent.SWITCH;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.U == false) goto L16;
        boolean r100 = this.f205018k0;
        if (r100 == true) goto L7;
    L9:
        if (r100 == true) goto L11;
    L13:
        int r101 = MathKt.roundToInt(TypedValue.applyDimension(1, 21, d(Resources.getSystem())));
    L14:
        n.a(this, r101 + MathKt.roundToInt(TypedValue.applyDimension(1, 4, d(Resources.getSystem()))));
        return;
    L11:
        if (this.T == true) goto L13;
        r101 = MathKt.roundToInt(TypedValue.applyDimension(2, 21, d(Resources.getSystem())));
        goto L14
    L7:
        if (this.T == false) goto L9;
        r101 = MathKt.roundToInt(TypedValue.applyDimension(1, 21 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), d(Resources.getSystem())));
        goto L14
    }

    public static DisplayMetrics d(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final void setAdaptLargeFontInternal(Boolean r100) {
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f205018k0 = DuxLargeFontHelper.a(f205017p0, r100);
    }

    @Override // com.bytedance.dux.duxswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        e(r100, true);
    }

    public final void setCheckedWithoutFeedback(boolean r100) {
        e(r100, false);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == false) goto L5;
        float r101 = 1.0f;
    L6:
        setAlpha(r101);
        return;
    L5:
        r101 = 0.5f;
        goto L6
    }

    public final void e(boolean r100, boolean r101) {
        if (r100 != isChecked()) goto L5;
    L12:
        super.setChecked(r100);
        return;
    L5:
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L12;
        if (r100 == false) goto L9;
        Drawable r102 = getTrackDrawable();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) r102).startTransition(180);
    L10:
        if (r101 == false) goto L12;
        performHapticFeedback(1, 2);
        goto L12
    L9:
        Drawable r103 = getTrackDrawable();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) r103).reverseTransition(180);
        goto L10
    }

    public DuxSwitch(Context r210, AttributeSet r211, int r212, int r213) {
        if ((r213 & 2) == 0) goto L5;
        AttributeSet r100 = null;
    L7:
        if ((r213 & 4) == 0) goto L9;
        int r101 = 0;
    L10:
        super(r210, r100, r101);
        this.T = false;
        this.U = true;
        Lazy r102 = DuxLargeFontHelper.f205243a;
        this.f205018k0 = DuxLargeFontHelper.a(f205017p0, null);
        if (r210 == null) goto L26;
        Resources.Theme r103 = r210.getTheme();
        if (r103 == null) goto L26;
        TypedArray r104 = r103.obtainStyledAttributes(r100, new int[]{R.attr.adaptLargeFontMode, R.attr.isAlwaysDark, R.attr.isAlwaysLight, R.attr.limitLargeFontScale}, 0, 0);
        if (r104 == null) goto L26;
        this.V = r104.getBoolean(2, false);     // Catch: Throwable -> L23
        this.W = r104.getBoolean(1, false);     // Catch: Throwable -> L23
        if (r104.hasValue(0) == false) goto L20;
        setAdaptLargeFontInternal(Boolean.valueOf(r104.getBoolean(0, false)));     // Catch: Throwable -> L23
    L20:
        if (r104.hasValue(0) == false) goto L22;
        this.T = r104.getBoolean(3, this.T);     // Catch: Throwable -> L23
    L22:
        r104.recycle();
    L23:
        th = move-exception;
        r104.recycle();
        throw th;
    L26:
        setLayerType(1, null);
        ShapeDrawable r105 = new ShapeDrawable(new rl4.a(r210));
        boolean r106 = this.f205018k0;
        if (r106 == true) goto L29;
    L31:
        if (r106 == true) goto L33;
    L35:
        int r107 = MathKt.roundToInt(TypedValue.applyDimension(1, 21, d(Resources.getSystem())));
    L36:
        r105.setIntrinsicHeight(r107);
        r105.setIntrinsicWidth(r105.getIntrinsicHeight());
        setThumbDrawable(r105);
        ShapeDrawable r108 = new ShapeDrawable();
        boolean r109 = this.f205018k0;
        if (r109 == true) goto L39;
    L41:
        if (r109 == true) goto L43;
    L45:
        int r110 = MathKt.roundToInt(TypedValue.applyDimension(1, 21, d(Resources.getSystem())));
    L46:
        float r111 = 4;
        r108.setIntrinsicHeight(r110 + MathKt.roundToInt(TypedValue.applyDimension(1, r111, d(Resources.getSystem()))));
        boolean r112 = this.f205018k0;
        if (r112 == true) goto L49;
    L51:
        if (r112 == true) goto L53;
    L55:
        int r113 = MathKt.roundToInt(TypedValue.applyDimension(1, 43, d(Resources.getSystem())));
    L56:
        r108.setIntrinsicWidth(r113);
        float r114 = 2;
        float r115 = r108.getIntrinsicHeight() / r114;
        r108.setShape(new RoundRectShape(new float[]{r115, r115, r115, r115, r115, r115, r115, r115}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        if (this.V == false) goto L60;
        int r116 = R.color.LineReverse;
    L63:
        Intrinsics.checkNotNull(r210);
        DrawableCompat.setTint(r108, ContextCompat.getColor(r210, r116));
        ShapeDrawable r117 = new ShapeDrawable();
        boolean r118 = this.f205018k0;
        if (r118 == true) goto L66;
    L68:
        if (r118 == true) goto L70;
    L72:
        int r119 = MathKt.roundToInt(TypedValue.applyDimension(1, 21, d(Resources.getSystem())));
    L73:
        r117.setIntrinsicHeight(r119 + MathKt.roundToInt(TypedValue.applyDimension(1, r111, d(Resources.getSystem()))));
        boolean r120 = this.f205018k0;
        if (r120 == true) goto L76;
    L78:
        if (r120 == true) goto L80;
    L82:
        int r121 = MathKt.roundToInt(TypedValue.applyDimension(1, 43, d(Resources.getSystem())));
    L83:
        r117.setIntrinsicWidth(r121);
        float r122 = r117.getIntrinsicHeight() / r114;
        r117.setShape(new RoundRectShape(new float[]{r122, r122, r122, r122, r122, r122, r122, r122}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        DrawableCompat.setTint(r117, ContextCompat.getColor(r210, R.color.ConstSwitchBG));
        TransitionDrawable r123 = new TransitionDrawable(new ShapeDrawable[]{r108, r117});
        r123.setCrossFadeEnabled(true);
        setTrackDrawable(r123);
        Drawable r124 = getTrackDrawable();
        Intrinsics.checkNotNull(r124, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) r124).resetTransition();
        setThumbConstraintRight(MathKt.roundToInt(TypedValue.applyDimension(1, r114, d(Resources.getSystem()))));
        setThumbConstraintLeft(MathKt.roundToInt(TypedValue.applyDimension(1, r114, d(Resources.getSystem()))));
        if (isChecked() == false) goto L87;
        Drawable r125 = getTrackDrawable();
        Intrinsics.checkNotNull(r125, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) r125).startTransition(180);
    L87:
        return;
    L80:
        if (this.T == true) goto L82;
        r121 = MathKt.roundToInt(TypedValue.applyDimension(2, 43, d(Resources.getSystem())));
        goto L83
    L76:
        if (this.T == false) goto L78;
        r121 = MathKt.roundToInt(TypedValue.applyDimension(1, 43 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), d(Resources.getSystem())));
        goto L83
    L70:
        if (this.T == true) goto L72;
        r119 = MathKt.roundToInt(TypedValue.applyDimension(2, 21, d(Resources.getSystem())));
        goto L73
    L66:
        if (this.T == false) goto L68;
        r119 = MathKt.roundToInt(TypedValue.applyDimension(1, 21 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), d(Resources.getSystem())));
        goto L73
    L60:
        if (this.W == false) goto L62;
        r116 = R.color.ConstLineInverse;
        goto L63
    L62:
        r116 = R.color.LinePrimary2;
        goto L63
    L53:
        if (this.T == true) goto L55;
        r113 = MathKt.roundToInt(TypedValue.applyDimension(2, 43, d(Resources.getSystem())));
        goto L56
    L49:
        if (this.T == false) goto L51;
        r113 = MathKt.roundToInt(TypedValue.applyDimension(1, 43 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), d(Resources.getSystem())));
        goto L56
    L43:
        if (this.T == true) goto L45;
        r110 = MathKt.roundToInt(TypedValue.applyDimension(2, 21, d(Resources.getSystem())));
        goto L46
    L39:
        if (this.T == false) goto L41;
        r110 = MathKt.roundToInt(TypedValue.applyDimension(1, 21 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), d(Resources.getSystem())));
        goto L46
    L33:
        if (this.T == true) goto L35;
        r107 = MathKt.roundToInt(TypedValue.applyDimension(2, 21, d(Resources.getSystem())));
        goto L36
    L29:
        if (this.T == false) goto L31;
        r107 = MathKt.roundToInt(TypedValue.applyDimension(1, 21 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), d(Resources.getSystem())));
        goto L36
    L9:
        r101 = r212;
        goto L10
    L5:
        r100 = r211;
        goto L7
    }
}
