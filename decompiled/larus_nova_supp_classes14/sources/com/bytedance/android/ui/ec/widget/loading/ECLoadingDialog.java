package com.bytedance.android.ui.ec.widget.loading;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.ui.ec.widget.tools.ViewExtensionsKt;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\b\u0010\r\u001a\u00020\nH\u0002J$\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000fJ\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000fR\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/loading/ECLoadingDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/content/DialogInterface$OnKeyListener;", "context", "Landroid/content/Context;", "theme", "", "(Landroid/content/Context;I)V", "onCloseClickListener", "Lkotlin/Function0;", "", "addCloseClickListener", "listener", "initViews", "onKey", "", "dialog", "Landroid/content/DialogInterface;", "keyCode", "event", "Landroid/view/KeyEvent;", "setDialogCancelable", "cancelable", "setDialogWidth", "setMessage", "text", "", "setShowCloseBtn", "show", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLoadingDialog extends AppCompatDialog implements DialogInterface.OnKeyListener {
    private Function0<Unit> onCloseClickListener;

    public ECLoadingDialog(Context r4) {
        int r2 = 0;
        this(r4, r2, 2, null);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
        return false;
    }

    private final void initViews() {
        ECDuxLoadingAnimationView r0 = (ECDuxLoadingAnimationView) findViewById(2131379091);
        if (r0 == null) goto L5;
        r0.startAnimate();
    L5:
        View r1 = findViewById(2131366984);
        if (r1 == null) goto L9;
        r1.setVisibility(0);
        r1.setOnClickListener(new ECLoadingDialog$initViews$$inlined$apply$lambda$1(this));
        return;
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static final /* synthetic */ Function0 access$getOnCloseClickListener$p(ECLoadingDialog r0) {
        return r0.onCloseClickListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setDialogWidth(Context r8) {
        Window r9 = getWindow();
        if (r9 == null) goto L6;
        WindowManager.LayoutParams r0 = r9.getAttributes();
        r0.width = -2;
        r0.height = -2;
        r9.setAttributes(r0);
        float r1 = 10;
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r9).setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r1, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r1, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r1, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r1, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        r9.setGravity(17);
        r9.setDimAmount(0.0f);
        r9.setBackgroundDrawableResource(R.color.transparent);
        return;
    }

    public final void addCloseClickListener(Function0<Unit> r1) {
        this.onCloseClickListener = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDialogCancelable(boolean r1) {
        setCancelable(r1);
        setCanceledOnTouchOutside(r1);
    }

    public final void setMessage(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L14;
        TextView r1 = (TextView) findViewById(2131388525);
        if (r1 == null) goto L15;
        r1.setText(r2);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setShowCloseBtn(final boolean r6) {
        View r0 = findViewById(2131366984);
        if (r0 == null) goto L8;
        if (r6 == false) goto L6;
        r0.setVisibility(0);
        float r1 = 60;
        ViewExtensionsKt.expandTouchAreaForTopRightCorner(r0, MathKt.roundToInt(TypedValue.applyDimension(1, r1, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r1, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        r0.setOnClickListener(new ECLoadingDialog$setShowCloseBtn$$inlined$apply$lambda$1(this, r6));
        return;
    L6:
        r0.setVisibility(8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECLoadingDialog(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        requestWindowFeature(1);
        setContentView(2131560675);
        setDialogCancelable(true);
        setDialogWidth(r2);
        initViews();
    }

    public static final /* synthetic */ void access$setOnCloseClickListener$p(ECLoadingDialog r0, Function0 r1) {
        r0.onCloseClickListener = r1;
    }

    public /* synthetic */ ECLoadingDialog(Context r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        this(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addCloseClickListener$default(ECLoadingDialog r0, Function0 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.addCloseClickListener(r1);
    }
}
