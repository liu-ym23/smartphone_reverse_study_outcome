package com.larus.office.plugins.snapshot;

import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements b.InterfaceC4449b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocShotFragment f363482a;

    @Override // com.larus.office.plugins.snapshot.b.InterfaceC4449b
    public final void onBack() {
        yo9.a r100 = this.f363482a.f363473g;
        if (r100 == null) goto L14;
        r100.onSnapshotFail("Cancelled");
    L14:
        this.f363482a.dismissAllowingStateLoss();     // Catch: Exception -> L8
    L12:
        this.f363482a.f363471e = null;
        return;
    L8:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L12;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }

    public a(DocShotFragment r100) {
        this.f363482a = r100;
    }
}
