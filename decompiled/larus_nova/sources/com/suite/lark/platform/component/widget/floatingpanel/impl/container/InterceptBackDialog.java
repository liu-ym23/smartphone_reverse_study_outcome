package com.suite.lark.platform.component.widget.floatingpanel.impl.container;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import com.alipay.sdk.m.x.d;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/suite/lark/platform/component/widget/floatingpanel/impl/container/InterceptBackDialog;", "Landroidx/appcompat/app/AppCompatDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", d.f25924n, "Lkotlin/Function0;", "", "getOnBack", "()Lkotlin/jvm/functions/Function0;", "setOnBack", "(Lkotlin/jvm/functions/Function0;)V", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "dismiss", "getActivity", "Landroid/app/Activity;", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InterceptBackDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f460708a;

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Activity r100 = getActivity(getContext());
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        Handler r102 = DialogLancet.resolveDialogHandler(this);
        if (r102 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(this);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r103 == null) goto L23;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L23
    L12:
        if (Looper.myLooper() == r102.getLooper()) goto L14;
        r102.post(DialogLancet.createDismissRunnable(this));
        return;
    L5:
        if (r100.isDestroyed() != true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        Function0<Unit> r100 = this.f460708a;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    public InterceptBackDialog(Context r100) {
        super(r100);
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
    public final void onCreate(Bundle r100) {
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.addFlags(16);
    L5:
        Window r102 = getWindow();
        if (r102 == null) goto L8;
        r102.addFlags(32);
    L8:
        Window r103 = getWindow();
        if (r103 == null) goto L11;
        r103.clearFlags(2);
    L11:
        Window r104 = getWindow();
        if (r104 == null) goto L14;
        r104.requestFeature(1);
    L14:
        super.onCreate(r100);
    }
}
