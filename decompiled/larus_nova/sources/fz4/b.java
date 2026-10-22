package fz4;

import com.bytedance.ee.bear.doc.screenshot.DocShotFragment;
import com.bytedance.ee.bear.doc.screenshot.DocShotPresenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class b implements DocShotPresenter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocShotFragment f479352a;

    public /* synthetic */ b(DocShotFragment r100) {
        this.f479352a = r100;
    }

    public final void a() {
        DocShotFragment r100 = this.f479352a;
        int r101 = DocShotFragment.f218061r;
        r100.getClass();
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L5
    L9:
        r100.f218064j = null;
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L9;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
