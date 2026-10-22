package com.bytedance.live.kmp.util;

import android.content.Context;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.live.kmp.core.KmpEnv;
import com.lynx.tasm.LynxError;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final void b(Throwable r100) {
        Context r101 = c.f255167a.getContext();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100 == null) goto L7;
        a(r101, r100, "操作失败, 请稍后重试");
        return;
    }

    public static final void c(Throwable r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, "fallbackPrompt");
        a(c.f255167a.getContext(), r100, r101);
    }

    public static final void a(Context r100, Throwable r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r102, "fallbackPrompt");
        if ((r101 instanceof ApiServerException) == false) goto L36;
        ApiServerException r103 = (ApiServerException) r101;
        String r104 = r103.getPrompt();
        String r105 = r103.getAlert();
        if (r103.isBlockNotice() == true) goto L40;
        boolean r106 = false;
        if (r105 != null) goto L10;
    L13:
        boolean r107 = true;
    L14:
        if (r107 == true) goto L23;
        Intrinsics.checkNotNullParameter("提示", "title");
        Intrinsics.checkNotNullParameter(r105, "message");
        Intrinsics.checkNotNullParameter("知道了", "confirmBtnText");
        if (r100 != null) goto L18;
        r100 = s1.getContext();
    L18:
        AlertDialog.Builder r108 = new AlertDialog.Builder(r100);
        r108.setTitle("提示");
        r108.setMessage(r105);
        r108.setPositiveButton("知道了", null);
        AlertDialog r109 = r108.create();
        if (DialogLancet.shouldBlockDialogShow(r109) == false) goto L43;
        DialogLancet.handleBlockedDialogShow(r109);
        goto L40
    L43:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L42
    L22:
        DialogLancet.beforeDialogShow(r109);
        r109.show();
        DialogLancet.afterDialogShow(r109);
        goto L40
    L23:
        if (r104 != null) goto L25;
    L26:
        r106 = true;
    L27:
        if (r106 == true) goto L32;
        Intrinsics.checkNotNullParameter(r104, "message");
        if (r100 != null) goto L31;
        r100 = s1.getContext();
    L31:
        IESUIUtils.displayToast(r100, r104);
        goto L40
    L32:
        Intrinsics.checkNotNullParameter(r102, "message");
        if (r100 != null) goto L35;
        r100 = s1.getContext();
    L35:
        IESUIUtils.displayToast(r100, r102);
        goto L40
    L25:
        if (r104.length() != 0) goto L27;
    L10:
        if (r105.length() == 0) goto L13;
        r107 = false;
    L40:
        KmpEnv r110 = KmpEnv.f255139a;
        com.bytedance.live.kmp.core.b.a();
        return;
    L36:
        Intrinsics.checkNotNullParameter(r102, "message");
        if (r100 != null) goto L39;
        r100 = s1.getContext();
    L39:
        IESUIUtils.displayToast(r100, r102);
        goto L40
    }
}
