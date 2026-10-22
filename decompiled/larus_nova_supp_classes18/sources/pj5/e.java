package pj5;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.more.fresh.DocDynamicChampionFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ DocDynamicChampionFragment a;

    public e(DocDynamicChampionFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Boolean r5 = (Boolean) r4;
        Context r6 = this.a.getContext();
        if (r6 != null) goto L5;
        r6 = eu5.b.a;
    L5:
        String r7 = xo5.a.c(r6, 2131888842, "validity", this.a.getString(2131888852));
        m.b(this.a.n);
        Context r0 = this.a.getContext();
        if (r0 != null) goto L8;
        r0 = eu5.b.a;
    L8:
        Toast.showSuccessText(r0, r7);
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L18;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
