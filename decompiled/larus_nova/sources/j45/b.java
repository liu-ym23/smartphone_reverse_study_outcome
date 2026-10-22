package j45;

import android.app.Activity;
import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.fileselector.FileSelectFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends sa5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f497362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f497363b;

    @Override // sa5.e
    public final boolean j() {
        FileSelectFragment r100 = this.f497363b.f497364a;
        if ((r100 instanceof FileSelectFragment) == false) goto L16;
        Dialog r101 = r100.getDialog();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.isShowing() == false) goto L21;
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L10
    L14:
        this.f497362a.finish();
        return true;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L14;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    L21:
        return false;
    L16:
        return false;
    }

    public b(c r100, FragmentActivity r101) {
        this.f497363b = r100;
        this.f497362a = r101;
    }
}
