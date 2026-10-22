package com.bytedance.applet.aibridge.navi;

import android.app.AlertDialog;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.api.AppletExtServiceDelegate;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import e3.d;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/CancelThirdNaviOrPlanMethod;", "Lcom/bytedance/applet/aibridge/navi/AbsCancelThirdNaviOrPlanMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navi/AbsCancelThirdNaviOrPlanMethodIDL$CancelThirdNaviOrPlanMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navi/AbsCancelThirdNaviOrPlanMethodIDL$CancelThirdNaviOrPlanMethodResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CancelThirdNaviOrPlanMethod extends AbsCancelThirdNaviOrPlanMethodIDL {
    public final boolean mustRunInMain() {
        return true;
    }

    public CancelThirdNaviOrPlanMethod() {
    }

    public final void handle(d r3, ParamModel r4, h r5) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsCancelThirdNaviOrPlanMethodIDL.a) r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (AppletExtServiceDelegate.b.n() == true) goto L24;
        AlertDialog r6 = rv3.h.a();
        if (r6 == null) goto L23;
        Handler r7 = DialogLancet.resolveDialogHandler(r6);
        if (r7 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r6);
        goto L23
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r8 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r8 == null) goto L20;
        com.bytedance.crash.d.d(r8, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L9:
        if (Looper.myLooper() == r7.getLooper()) goto L11;
        r7.post(DialogLancet.createDismissRunnable(r6));
    L23:
        rv3.h.a = null;
    L24:
        r5.b(k3.a.b(Reflection.getOrCreateKotlinClass(AbsCancelThirdNaviOrPlanMethodIDL.b.class)), "");
    }
}
