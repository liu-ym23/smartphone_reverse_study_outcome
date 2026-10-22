package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog;

import android.view.View;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiDeleteConfirmDialog f242453a;

    public e(WikiDeleteConfirmDialog r100) {
        this.f242453a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WikiDeleteConfirmDialog r101 = this.f242453a;
        int r102 = WikiDeleteConfirmDialog.f242439o;
        WikiDeleteConfirmDialog.ParamsViewModel r103 = r101.ca0();
        if (r103 == null) goto L25;
        WikiDeleteConfirmDialog.b r104 = r103.getDelegate();
        if (r104 == null) goto L25;
        if (r101.aa0().isSelected() == false) goto L10;
        byte r105 = 2131368778;
    L13:
        if (r105 != R.id.deleteCurrentOnly) goto L15;
        r104.a();
        goto L25
    L15:
        if (r105 != R.id.deleteWithSub) goto L25;
        r104.b();
        goto L25
    L10:
        if (r101.ba0().isSelected() == false) goto L12;
        r105 = 2131368781;
        goto L13
    L12:
        r105 = -1;
    L25:
        this.f242453a.dismissAllowingStateLoss();     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r106 = DialogFragmentLancet.sLastShowStack;
        if (r106 == null) goto L27;
        com.bytedance.crash.d.d(r106, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
