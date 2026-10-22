package com.larus.avlink.env.event.detail;

import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.u;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes25.dex */
public final class f implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<CommonDialog> f292269a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        CommonDialog r100 = this.f292269a.element;
        if (r100 == null) goto L13;
        r100.dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L14;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    public f(Ref.ObjectRef<CommonDialog> r100) {
        this.f292269a = r100;
    }
}
