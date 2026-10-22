package com.ss.android.lark.ui.dialog;

import com.larksuite.framework.ui.BaseDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes38.dex */
public class ComponentDialog extends BaseDialog {

    @Retention(RetentionPolicy.SOURCE)
    public @interface GRAVITY {
    }

    @Override // com.larksuite.framework.ui.BaseDialog, android.app.Dialog
    public void show() {
        setCanceledOnTouchOutside(true);
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }
}
