package com.bytedance.android.ui.ec.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.widget.NestedScrollView;
import com.bytedance.android.ui.base.widget.scroll.MaxHeightScrollView;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0017J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0006\u0010\u001c\u001a\u00020\u0017J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0019J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\u0010\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"J\u0006\u0010#\u001a\u00020\u0017J\u0006\u0010$\u001a\u00020\u0017J\u0018\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\"2\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010\"2\u0006\u0010'\u001a\u00020(J\u0012\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020\u0006J\u000e\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u0011R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/dialog/ECAlertDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "buttonLL", "Landroid/widget/LinearLayout;", "cancelTextView", "Landroid/widget/TextView;", "confirmTextView", "contentFL", "Landroid/widget/FrameLayout;", "contentTextView", "divider", "Landroid/view/View;", "divider1", "titleTextView", "titleViewTopPlaceHolder", "topContainer", "adjustMargin", "", "enableLargeFont", "", "hideNegativeButton", "init", "openContentClick", "setDialogCancelable", "cancelable", "setDialogWidth", "setMessage", "message", "", "setMessageGravityCenter", "setMessageGravityStart", "setNegativeButton", "cancelText", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "setPositiveButton", "confirmText", "setTitle", "title", "setTitleTopPlaceHolderVisibility", "isVisible", "height", "setTopCustomView", "topView", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAlertDialog extends AppCompatDialog {
    private LinearLayout buttonLL;
    private TextView cancelTextView;
    private TextView confirmTextView;
    private FrameLayout contentFL;
    private TextView contentTextView;
    private View divider;
    private View divider1;
    private TextView titleTextView;
    private View titleViewTopPlaceHolder;
    private FrameLayout topContainer;

    private final void adjustMargin() {
        View r0 = this.divider1;
        ViewGroup.LayoutParams r1 = null;
        if (r0 != null) goto L5;
    L19:
        View r2 = this.divider1;
        if (r2 == null) goto L32;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof LinearLayout.LayoutParams) == false) goto L25;
        r1 = r3;
    L25:
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) r1;
        if (r4 == null) goto L33;
        r4.setMargins(0, 0, 0, 0);
        r2.setLayoutParams(r4);
        return;
    L33:
        return;
    L32:
        return;
    L5:
        if (r0.getVisibility() != 0) goto L19;
        FrameLayout r5 = this.contentFL;
        if (r5 != null) goto L9;
    L10:
        View r6 = this.divider1;
        if (r6 == null) goto L29;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof LinearLayout.LayoutParams) == false) goto L16;
        r1 = r7;
    L16:
        LinearLayout.LayoutParams r8 = (LinearLayout.LayoutParams) r1;
        if (r8 == null) goto L30;
        r8.setMargins(0, MathKt.roundToInt(TypedValue.applyDimension(1, 24, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_dialog_ECAlertDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), 0, 0);
        r6.setLayoutParams(r8);
        return;
    L30:
        return;
    L29:
        return;
    L9:
        if (r5.getVisibility() == 0) goto L19;
        goto L10
    }

    public final void hideNegativeButton() {
        TextView r0 = this.cancelTextView;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        View r1 = this.divider;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    }

    public final void openContentClick() {
        TextView r0 = this.contentTextView;
        if (r0 == null) goto L6;
        r0.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    }

    public final void setMessageGravityCenter() {
        TextView r0 = this.contentTextView;
        if (r0 == null) goto L6;
        r0.setGravity(17);
        return;
    }

    public final void setMessageGravityStart() {
        TextView r0 = this.contentTextView;
        if (r0 == null) goto L6;
        r0.setGravity(8388611);
        return;
    }

    private final void init() {
        setContentView(2131560674);
        this.contentFL = (FrameLayout) findViewById(2131372710);
        this.contentTextView = (TextView) findViewById(2131390944);
        this.titleTextView = (TextView) findViewById(2131391606);
        this.titleViewTopPlaceHolder = findViewById(2131392602);
        this.buttonLL = (LinearLayout) findViewById(2131378631);
        this.cancelTextView = (TextView) findViewById(2131390273);
        this.confirmTextView = (TextView) findViewById(2131390381);
        this.divider = findViewById(2131392500);
        this.divider1 = findViewById(2131392501);
        this.topContainer = (FrameLayout) findViewById(2131389138);
        NestedScrollView r0 = (MaxHeightScrollView) findViewById(2131385238);
        if (r0 == null) goto L7;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1 == null) goto L7;
        r1.addOnGlobalLayoutListener(new AnonymousClass1(this));
    L7:
        setDialogWidth();
        setDialogCancelable(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setDialogWidth() {
        Window r0 = getWindow();
        if (r0 == null) goto L6;
        WindowManager.LayoutParams r1 = r0.getAttributes();
        r1.width = -1;
        r1.height = -2;
        r0.setAttributes(r1);
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_dialog_ECAlertDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r0).setPadding(0, 0, 0, 0);
        r0.setBackgroundDrawableResource(2131106784);
        return;
    }

    public ECAlertDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        init();
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_dialog_ECAlertDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_dialog_ECAlertDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public final void enableLargeFont(boolean r3) {
        if (r3 == false) goto L4;
        int r4 = 2;
    L5:
        TextView r0 = this.titleTextView;
        if (r0 == null) goto L8;
        r0.setTextSize(r4, 17.0f);
    L8:
        TextView r1 = this.contentTextView;
        if (r1 == null) goto L11;
        r1.setTextSize(r4, 14.0f);
    L11:
        TextView r2 = this.cancelTextView;
        if (r2 == null) goto L14;
        r2.setTextSize(r4, 15.0f);
    L14:
        TextView r5 = this.confirmTextView;
        if (r5 == null) goto L18;
        r5.setTextSize(r4, 15.0f);
        return;
    L18:
        return;
    L4:
        r4 = 1;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDialogCancelable(boolean r1) {
        setCancelable(r1);
        setCanceledOnTouchOutside(r1);
    }

    public final void setMessage(CharSequence r3) {
        FrameLayout r0 = this.contentFL;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        TextView r1 = this.contentTextView;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        TextView r2 = this.contentTextView;
        if (r2 == null) goto L11;
        r2.setText(r3);
    L11:
        adjustMargin();
    }

    public void setTitle(CharSequence r3) {
        TextView r0 = this.titleTextView;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        View r1 = this.titleViewTopPlaceHolder;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        TextView r2 = this.titleTextView;
        if (r2 == null) goto L12;
        r2.setText(r3);
        return;
    }

    public final void setTopCustomView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "topView");
        FrameLayout r0 = this.topContainer;
        if (r0 == null) goto L6;
        r0.addView(r2);
        return;
    }

    public ECAlertDialog(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        init();
    }

    public final void setNegativeButton(CharSequence r3, final DialogInterface.OnClickListener r4) {
        Intrinsics.checkNotNullParameter(r4, "onClickListener");
        LinearLayout r0 = this.buttonLL;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        View r1 = this.divider;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        View r2 = this.divider1;
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        TextView r5 = this.cancelTextView;
        if (r5 == null) goto L14;
        r5.setVisibility(0);
    L14:
        TextView r6 = this.cancelTextView;
        if (r6 == null) goto L17;
        r6.setText(r3);
    L17:
        TextView r7 = this.cancelTextView;
        if (r7 == null) goto L20;
        r7.setOnClickListener(new ViewOnClickListenerC02021(this, r4));
    L20:
        adjustMargin();
    }

    public final void setPositiveButton(CharSequence r3, final DialogInterface.OnClickListener r4) {
        Intrinsics.checkNotNullParameter(r4, "onClickListener");
        LinearLayout r0 = this.buttonLL;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        View r1 = this.divider1;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        TextView r2 = this.confirmTextView;
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        TextView r5 = this.confirmTextView;
        if (r5 == null) goto L14;
        r5.setText(r3);
    L14:
        TextView r6 = this.confirmTextView;
        if (r6 == null) goto L17;
        r6.setOnClickListener(new ViewOnClickListenerC02031(this, r4));
    L17:
        adjustMargin();
    }

    public final void setTitleTopPlaceHolderVisibility(boolean r2, int r3) {
        if (r2 == false) goto L14;
        View r4 = this.titleViewTopPlaceHolder;
        if (r4 == null) goto L6;
        r4.setVisibility(0);
    L6:
        View r5 = this.titleViewTopPlaceHolder;
        if (r5 == null) goto L18;
        if (r5 == null) goto L12;
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if (r0 == null) goto L12;
        r0.height = r3;
        Unit r6 = Unit.INSTANCE;
    L13:
        r5.setLayoutParams(r0);
        return;
    L12:
        r0 = null;
        goto L13
    L18:
        return;
    L14:
        View r7 = this.titleViewTopPlaceHolder;
        if (r7 == null) goto L20;
        r7.setVisibility(8);
        return;
    }

    public static /* synthetic */ void setTitleTopPlaceHolderVisibility$default(ECAlertDialog r0, boolean r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_dialog_ECAlertDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
    L5:
        r0.setTitleTopPlaceHolderVisibility(r1, r2);
    }
}
