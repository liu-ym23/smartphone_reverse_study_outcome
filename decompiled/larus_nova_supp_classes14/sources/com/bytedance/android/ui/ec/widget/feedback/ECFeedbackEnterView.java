package com.bytedance.android.ui.ec.widget.feedback;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ui.ec.widget.tools.UnitExtensionKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001-B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0002J\u0018\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020#2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010,\u001a\u00020#R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/android/ui/ec/widget/feedback/ECFeedbackEnterView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleEventObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgColor", "buttonText", "", "callback", "Lcom/bytedance/android/ui/ec/widget/feedback/ECFeedbackEnterView$OnFeedbackCallback;", "cornerRadiusDp", "iconResId", "iconSizeDp", "iconTextSpacingDp", "iconView", "Landroid/widget/ImageView;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "paddingHorizontalDp", "paddingVerticalDp", "removeViewRunnable", "Ljava/lang/Runnable;", "rootView", "Landroid/view/ViewGroup;", "textColor", "textSizeSp", "", "textView", "Landroid/widget/TextView;", "destroy", "", "initIconView", "initLifecycleListener", "initTextView", "onStateChanged", "source", "event", "Landroidx/lifecycle/Lifecycle$Event;", "setOnFeedBackCallBack", "show", "OnFeedbackCallback", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFeedbackEnterView extends FrameLayout implements LifecycleEventObserver {
    private final int bgColor;
    private final String buttonText;
    private OnFeedbackCallback callback;
    private final int cornerRadiusDp;
    private final int iconResId;
    private final int iconSizeDp;
    private final int iconTextSpacingDp;
    private final ImageView iconView;
    private LifecycleOwner lifecycleOwner;
    private final int paddingHorizontalDp;
    private final int paddingVerticalDp;
    private final Runnable removeViewRunnable;
    private ViewGroup rootView;
    private final int textColor;
    private final float textSizeSp;
    private final TextView textView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/feedback/ECFeedbackEnterView$OnFeedbackCallback;", "", "onFeedBackClick", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnFeedbackCallback {
        void onFeedBackClick();
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 1;
        }
    }

    public ECFeedbackEnterView(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public ECFeedbackEnterView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    private final void destroy() {
        removeCallbacks(this.removeViewRunnable);
        this.removeViewRunnable.run();
    }

    private final void initIconView() {
        int r0 = UnitExtensionKt.dp2px(this.iconSizeDp);
        Drawable r1 = ContextCompat.getDrawable(getContext(), this.iconResId);
        this.iconView.setImageDrawable(r1);
        this.iconView.setLayoutParams(new FrameLayout.LayoutParams(r0, r0));
        this.iconView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private final void initTextView() {
        this.textView.setText(this.buttonText);
        this.textView.setTextColor(this.textColor);
        this.textView.setTextSize(this.textSizeSp);
        this.textView.setGravity(17);
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -1);
        r0.leftMargin = UnitExtensionKt.dp2px(this.iconTextSpacingDp);
        r0.bottomMargin = UnitExtensionKt.dp2px(2);
        this.textView.setLayoutParams(r0);
    }

    public final void show() {
        removeCallbacks(this.removeViewRunnable);
        Context r0 = getContext();
        ViewGroup r2 = null;
        if ((r0 instanceof Activity) == true) goto L5;
        r0 = null;
    L5:
        Activity r1 = (Activity) r0;
        if (r1 == null) goto L8;
        r2 = (ViewGroup) r1.findViewById(R.id.content);
    L8:
        this.rootView = r2;
        if (r2 != null) goto L11;
    L13:
        postDelayed(this.removeViewRunnable, 6000);
        return;
    L11:
        if (r2.indexOfChild(this) != (-1)) goto L13;
        r2.addView(this);
        goto L13
    }

    private final void initLifecycleListener() {
        if ((getContext() instanceof LifecycleOwner) == false) goto L13;
        Context r0 = getContext();
        Lifecycle r2 = null;
        if ((r0 instanceof LifecycleOwner) == true) goto L7;
        r0 = null;
    L7:
        LifecycleOwner r1 = (LifecycleOwner) r0;
        this.lifecycleOwner = r1;
        if (r1 == null) goto L10;
        r2 = r1.getLifecycle();
    L10:
        if (r2 == null) goto L14;
        r2.addObserver(this);
        return;
    L14:
        return;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_feedback_ECFeedbackEnterView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static final /* synthetic */ OnFeedbackCallback access$getCallback$p(ECFeedbackEnterView r0) {
        return r0.callback;
    }

    public static final /* synthetic */ ViewGroup access$getRootView$p(ECFeedbackEnterView r0) {
        return r0.rootView;
    }

    public final void setOnFeedBackCallBack(OnFeedbackCallback r1) {
        this.callback = r1;
    }

    public static final /* synthetic */ void access$setCallback$p(ECFeedbackEnterView r0, OnFeedbackCallback r1) {
        r0.callback = r1;
    }

    public static final /* synthetic */ void access$setRootView$p(ECFeedbackEnterView r0, ViewGroup r1) {
        r0.rootView = r1;
    }

    public void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (WhenMappings.$EnumSwitchMapping$0[r3.ordinal()] != 1) goto L7;
        destroy();
        this.lifecycleOwner = null;
        return;
    }

    public ECFeedbackEnterView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        int r12 = ColorProtector.parseColor("#B3000000");
        this.bgColor = r12;
        this.textColor = -1;
        this.textSizeSp = 12.0f;
        this.iconSizeDp = 16;
        this.cornerRadiusDp = 8;
        this.paddingHorizontalDp = 10;
        this.paddingVerticalDp = 8;
        this.iconTextSpacingDp = 4;
        this.iconResId = 2131236551;
        this.buttonText = "功能反馈";
        ImageView r3 = new ImageView(r9);
        this.iconView = r3;
        TextView r4 = new TextView(r9);
        this.textView = r4;
        this.removeViewRunnable = new ECFeedbackEnterView$removeViewRunnable$1(this);
        initLifecycleListener();
        LinearLayout r5 = new LinearLayout(r9);
        r5.setOrientation(0);
        r5.setGravity(16);
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-2, -2);
        r6.gravity = 16;
        r6.leftMargin = UnitExtensionKt.dp2px(16);
        Unit r13 = Unit.INSTANCE;
        r5.setLayoutParams(r6);
        r5.setClickable(true);
        r5.setFocusable(true);
        float r7 = TypedValue.applyDimension(1, 8, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_feedback_ECFeedbackEnterView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()));
        GradientDrawable r8 = new GradientDrawable();
        r8.setShape(0);
        r8.setColor(r12);
        r8.setCornerRadii(new float[]{r7, r7, r7, r7, r7, r7, r7, r7});
        r5.setBackground(r8);
        r5.setPadding(UnitExtensionKt.dp2px(10), UnitExtensionKt.dp2px(8), UnitExtensionKt.dp2px(10), UnitExtensionKt.dp2px(8));
        initIconView();
        initTextView();
        r5.addView(r3);
        r5.addView(r4);
        r5.setOnClickListener(new AnonymousClass1(this));
        addView(r5);
    }

    public /* synthetic */ ECFeedbackEnterView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
