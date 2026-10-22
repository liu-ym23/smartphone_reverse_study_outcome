package fz4;

import com.bytedance.ee.bear.doc.screenshot.DocShotFragment;
import com.bytedance.ee.bear.doc.screenshot.DocShotPresenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class b implements DocShotPresenter.c {
    public final /* synthetic */ DocShotFragment a;

    public /* synthetic */ b(DocShotFragment r1) {
        this.a = r1;
    }

    public final void a() {
        DocShotFragment r0 = this.a;
        int r1 = DocShotFragment.r;
        r0.getClass();
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L5
    L9:
        r0.j = null;
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L9;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
