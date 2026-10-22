package com.bytedance.android.ui.ec.widget.switchbutton;

import android.content.Context;
import android.content.res.Resources;
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
import com.bytedance.android.ui.ec.widget.tools.ViewExtensionsKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/switchbutton/ECSwitch;", "Lcom/bytedance/android/ui/ec/widget/switchbutton/CustomSwitchCompat;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adaptForCSR", "", "onAttachedToWindow", "", "setChecked", "checked", "setCheckedInner", "withHapticFeedback", "withAnim", "setCheckedWithoutFeedback", "setEnabled", "enabled", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSwitch extends CustomSwitchCompat {
    private boolean adaptForCSR;

    public ECSwitch(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public ECSwitch(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.adaptForCSR == false) goto L6;
        ViewExtensionsKt.expandTouchArea(this, MathKt.roundToInt(TypedValue.applyDimension(1, 45, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        return;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    @Override // com.bytedance.android.ui.ec.widget.switchbutton.CustomSwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        setCheckedInner(r2, true, true);
    }

    public final void setCheckedWithoutFeedback(boolean r3) {
        setCheckedInner(r3, false, true);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == false) goto L5;
        float r2 = 1.0f;
    L6:
        setAlpha(r2);
        return;
    L5:
        r2 = 0.5f;
        goto L6
    }

    public ECSwitch(Context r19, AttributeSet r20, int r21) {
        Intrinsics.checkNotNullParameter(r19, "context");
        super(r19, r20, r21);
        this.adaptForCSR = true;
        setLayerType(1, null);
        ShapeDrawable r3 = new ShapeDrawable(new OvalShapeWithShadow(r19));
        float r4 = 21;
        r3.setIntrinsicHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r4, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        r3.setIntrinsicWidth(MathKt.roundToInt(TypedValue.applyDimension(1, r4, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        Unit r5 = Unit.INSTANCE;
        setThumbDrawable(r3);
        ShapeDrawable r6 = new ShapeDrawable();
        float r7 = 25;
        r6.setIntrinsicHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r7, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        float r8 = 43;
        r6.setIntrinsicWidth(MathKt.roundToInt(TypedValue.applyDimension(1, r8, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        float r9 = (float) 12.5d;
        r6.setShape(new RoundRectShape(new float[]{TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        DrawableCompat.setTint(r6, ContextCompat.getColor(r19, 2131101741));
        ShapeDrawable r10 = new ShapeDrawable();
        r10.setIntrinsicHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r7, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        r10.setIntrinsicWidth(MathKt.roundToInt(TypedValue.applyDimension(1, r8, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        r10.setShape(new RoundRectShape(new float[]{TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r9, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        DrawableCompat.setTint(r10, ContextCompat.getColor(r19, 2131101740));
        TransitionDrawable r1 = new TransitionDrawable(new ShapeDrawable[]{r6, r10});
        r1.setCrossFadeEnabled(true);
        setTrackDrawable(r1);
        Drawable r2 = getTrackDrawable();
        if (r2 == null) goto L13;
        ((TransitionDrawable) r2).resetTransition();
        float r11 = 2;
        setThumbConstraintRight(MathKt.roundToInt(TypedValue.applyDimension(1, r11, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        setThumbConstraintLeft(MathKt.roundToInt(TypedValue.applyDimension(1, r11, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        if (isChecked() == false) goto L11;
        Drawable r12 = getTrackDrawable();
        if (r12 == null) goto L10;
        ((TransitionDrawable) r12).startTransition(180);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L11:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    }

    private final void setCheckedInner(boolean r3, boolean r4, boolean r5) {
        if (r3 == isChecked()) goto L21;
        if (r5 == false) goto L21;
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L21;
        if (r3 == false) goto L14;
        Drawable r1 = getTrackDrawable();
        if (r1 == null) goto L13;
        ((TransitionDrawable) r1).startTransition(180);
    L17:
        if (r4 == false) goto L21;
        performHapticFeedback(1, 2);
        goto L21
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L14:
        Drawable r2 = getTrackDrawable();
        if (r2 == null) goto L20;
        ((TransitionDrawable) r2).reverseTransition(180);
        goto L17
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L21:
        super.setChecked(r3);
    }

    public /* synthetic */ ECSwitch(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
