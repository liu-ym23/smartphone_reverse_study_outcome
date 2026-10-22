package com.larksuite.component.universe_design.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018B\u0011\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0013J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDDialog;", "Landroidx/appcompat/app/AppCompatDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "theme", "", "(Landroid/content/Context;I)V", "mCallback", "Lcom/larksuite/component/universe_design/dialog/UDDialog$DialogCallback;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "show", "dismiss", "setCallback", "callback", "setCallback$universe_ui_dialog_release", "getActivity", "Landroid/app/Activity;", "Companion", "Config", "DialogCallback", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDDialog extends AppCompatDialog {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final b config = null;
    private DialogCallback mCallback;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH'J\b\u0010\t\u001a\u00020\u0003H'J\b\u0010\n\u001a\u00020\u0003H'¨\u0006\u000b"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDDialog$DialogCallback;", "", "beforeCreate", "", "dialog", "Lcom/larksuite/component/universe_design/dialog/UDDialog;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", SendEventContainerMethodParamModel.EventKinds.onShow, "onDismiss", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface DialogCallback {
        void beforeCreate(UDDialog r100);

        void onCreate(UDDialog r100, Bundle r101);

        void onDismiss();

        void onShow();
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static /* synthetic */ void access$000(AppCompatDialog r100) {
        super.show();
    }

    public static /* synthetic */ void access$001(AppCompatDialog r100) {
        super.dismiss();
    }

    static {
        Companion = new a();
        $stable = 8;
        config = new b();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isShowing() == true) goto L5;
        return;
    L5:
        Activity r100 = getActivity(getContext());
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.isDestroyed() == true) goto L15;
        DialogCallback r101 = this.mCallback;
        if (r101 == null) goto L13;
        r101.onDismiss();
    L13:
        INVOKESPECIAL_com_larksuite_component_universe_design_dialog_UDDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        return;
    }

    @Override // android.app.Dialog
    public void show() {
        Activity r100 = getActivity(getContext());
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L11;
        INVOKESPECIAL_com_larksuite_component_universe_design_dialog_UDDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
        DialogCallback r101 = this.mCallback;
        if (r101 == null) goto L12;
        r101.onShow();
        return;
    L12:
        return;
    }

    public static final /* synthetic */ b access$getConfig$cp() {
        return config;
    }

    public UDDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, R.style.UDDialog);
    }

    public static void INVOKESPECIAL_com_larksuite_component_universe_design_dialog_UDDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AppCompatDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        access$001(r100);     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKESPECIAL_com_larksuite_component_universe_design_dialog_UDDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AppCompatDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        access$000(r100);
        DialogLancet.afterDialogShow(r100);
    }

    private final Activity getActivity(Context r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof Activity) == true) goto L13;
        if ((r100 instanceof ContextWrapper) == true) goto L11;
        return null;
    L11:
        return getActivity(((ContextWrapper) r100).getBaseContext());
    L13:
        return (Activity) r100;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.clearFlags(131080);
    L5:
        DialogCallback r102 = this.mCallback;
        if (r102 == null) goto L8;
        r102.beforeCreate(this);
    L8:
        super.onCreate(r100);
        DialogCallback r103 = this.mCallback;
        if (r103 == null) goto L12;
        r103.onCreate(this, r100);
        return;
    }

    public final void setCallback$universe_ui_dialog_release(DialogCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.mCallback = r100;
    }

    public UDDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
