package com.obric.oui.dialog.base;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class r extends AbstractDialogModal {
    public boolean A;

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public final void c() {
        this.A = false;
        super.c();
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal, android.content.DialogInterface
    public final void dismiss() {
        if (this.A == false) goto L5;
        return;
    L5:
        this.A = true;
        super.dismiss();
    }

    public r(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public final void setDismissing(boolean r100) {
        this.A = r100;
    }
}
