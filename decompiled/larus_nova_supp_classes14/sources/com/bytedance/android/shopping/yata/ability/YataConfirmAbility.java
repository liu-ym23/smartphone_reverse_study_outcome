package com.bytedance.android.shopping.yata.ability;

import android.content.Context;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class YataConfirmAbility implements v96.b {
    public final Context a;
    public final boolean b;

    /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog, java.lang.Object] */
    public final void a(final com.bytedance.kmp.ec.yata.event.ability.confirm.a r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        Function1<ECAlertDialog, Unit> r0 = new YataConfirmAbility$showConfirm$1(this, r4);
        ?? r5 = new ECAlertDialog(this.a, 2131954063);
        r5.enableLargeFont(this.b);
        r0.invoke(r5);
        r5.setCancelable(false);
        r5.setCanceledOnTouchOutside(false);
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
    }

    public YataConfirmAbility(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
    }
}
