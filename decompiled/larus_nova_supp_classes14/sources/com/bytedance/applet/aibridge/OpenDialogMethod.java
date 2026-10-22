package com.bytedance.applet.aibridge;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.f0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/OpenDialogMethod;", "Lcom/bytedance/applet/aibridge/AbsOpenDialogMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsOpenDialogMethodIDL$AbsOpenDialogParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsOpenDialogMethodIDL$AbsOpenDialogResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenDialogMethod extends AbsOpenDialogMethodIDL {
    public OpenDialogMethod() {
    }

    public final void handle(e3.d r6, ParamModel r7, f3.h r8) {
        AbsOpenDialogMethodIDL.a r9 = (AbsOpenDialogMethodIDL.a) r7;
        Intrinsics.checkNotNullParameter(r6, "bridgeContext");
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        CommonDialog.a r0 = new CommonDialog.a();
        String r1 = r9.getTitle();
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r1, "title");
        r0.a = r1;
    L5:
        String r2 = r9.getContent();
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        r0.b = false;
    L15:
        String r4 = r9.getCancelText();
        if (r4 == null) goto L18;
        CommonDialog.a.e(r0, new q(r8), r4, 4);
    L18:
        r0.z = false;
        p r5 = new p();
        Intrinsics.checkNotNullParameter(r5, "callback");
        r0.B = r5;
        String r10 = r9.getConfirmText();
        if (r10 == null) goto L21;
        f0 r11 = new f0(null, Integer.valueOf(ContextCompat.getColor(AppHost.a.getApplication(), 2131103203)), null, 5);
        Intrinsics.checkNotNullParameter(r11, "commonDialogTextStyleConfig");
        r0.D = r11;
        CommonDialog.a.f(r0, new r(r8), r10, false, 12);
    L21:
        FragmentActivity r12 = AppHost.a.a().getCurrentActivity();
        if ((r12 instanceof FragmentActivity) == false) goto L24;
        FragmentActivity r13 = r12;
    L25:
        if (r13 == null) goto L34;
        FragmentManager r14 = r13.getSupportFragmentManager();
        if (r14 == null) goto L34;
        CommonDialog r15 = r0.a();
        LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r15, null, r16);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r14, r15, r16) == true) goto L40;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36
    L33:
        r15.show(r14, null);
        return;
    L40:
        return;
    L34:
        Intrinsics.checkNotNullParameter(AbsOpenDialogMethodIDL.b.class, "<this>");
        AbsOpenDialogMethodIDL.b r17 = k3.c.a(AbsOpenDialogMethodIDL.b.class);
        r17.setConfirm(false);
        r8.b(r17, "");
        return;
    L24:
        r13 = null;
        goto L25
    L14:
        r0.g(r2);
        goto L15
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
        goto L12
    }
}
