package j45;

import android.app.Activity;
import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.fileselector.FileSelectFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends sa5.e {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ c b;

    @Override // sa5.e
    public final boolean j() {
        FileSelectFragment r0 = this.b.a;
        if ((r0 instanceof FileSelectFragment) == false) goto L16;
        Dialog r1 = r0.getDialog();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.isShowing() == false) goto L21;
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L10
    L14:
        this.a.finish();
        return true;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L14;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    L21:
        return false;
    L16:
        return false;
    }

    public b(c r1, FragmentActivity r2) {
        this.b = r1;
        this.a = r2;
    }
}
