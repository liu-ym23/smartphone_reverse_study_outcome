package com.ss.android.lark.foundation.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\tJ&\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\t2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J&\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\t2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u0010\u0010\u001f\u001a\u00020\u00002\b\b\u0001\u0010 \u001a\u00020\u0005J\u0010\u0010!\u001a\u00020\u00002\b\b\u0001\u0010 \u001a\u00020\u0005J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0015H\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0015H\u0016J\u0012\u0010&\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\f\u0010)\u001a\u00020\u0003*\u00020\u0003H\u0002J\b\u0010*\u001a\u00020\u0012H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/ss/android/lark/foundation/dialog/FlowAlertDialog;", "Landroidx/activity/ComponentDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "themeResId", "", "<init>", "(Landroid/content/Context;I)V", "titleText", "", RXScreenCaptureService.KEY_CONTENT_TEXT, "positiveText", "negativeText", "positiveColorInt", "Ljava/lang/Integer;", "negativeColorInt", "positiveListener", "Lkotlin/Function1;", "", "negativeListener", "isCancelable", "", "dismissOnOutside", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "setTitleText", "text", "setMessageText", "setPositiveButton", "listener", "setNegativeButton", "setPositiveButtonColor", "color", "setNegativeButtonColor", "setCanceledOnTouchOutside", "cancel", "setCancelable", ForwardDependency$ForwardLocation.FLAG, WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "findContextImpl", ChameleonOpenTracker.Stage.RENDER, "flow-ud_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowAlertDialog extends ComponentDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f425600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f425601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f425602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f425603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f425604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f425605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super FlowAlertDialog, Unit> f425606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super FlowAlertDialog, Unit> f425607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f425608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f425609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ComposeView f425610k;

    public /* synthetic */ FlowAlertDialog() {
        throw null;
    }

    public static Context b(Context r100) {
        if ((r100 instanceof Activity) == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof ContextWrapper) == true) goto L8;
        return r100;
    L8:
        return b(((ContextWrapper) r100).getBaseContext());
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L20;
        r101.setBackgroundDrawable(new ColorDrawable(0));
        ComposeView r102 = new ComposeView(getContext(), null, 0, 6, null);
        r102.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow.INSTANCE);
        this.f425610k = r102;
        Object r103 = b(getContext());
        ComposeView r104 = this.f425610k;
        ComposeView r105 = null;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("composeView");
        r104 = null;
    L8:
        if ((r103 instanceof SavedStateRegistryOwner) == false) goto L10;
        SavedStateRegistryOwner r106 = (SavedStateRegistryOwner) r103;
    L11:
        ViewTreeSavedStateRegistryOwner.set(r104, r106);
        ComposeView r107 = this.f425610k;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("composeView");
        r107 = null;
    L14:
        setContentView(r107);
        ComposeView r108 = this.f425610k;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("composeView");
    L18:
        r105.setContent(ComposableLambdaKt.composableLambdaInstance(1424654349, true, new FlowAlertDialog$render$1(this)));
        return;
    L17:
        r105 = r108;
        goto L18
    L10:
        r106 = null;
        goto L11
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean r100) {
        super.setCancelable(r100);
        this.f425608i = r100;
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r100) {
        super.setCanceledOnTouchOutside(r100);
        this.f425609j = r100;
    }

    public FlowAlertDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f425600a = "";
        this.f425601b = "";
        this.f425602c = "";
        this.f425603d = "";
        this.f425608i = true;
        this.f425609j = true;
    }
}
