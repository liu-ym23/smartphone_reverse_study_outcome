package pj5;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.more.fresh.DocFreshNessAdapter;
import com.bytedance.ee.bear.more.fresh.DocFreshNessFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ i a;
    public final /* synthetic */ DocFreshNessFragment b;

    public k(i r1, DocFreshNessFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Boolean r8 = (Boolean) r7;
        if (this.a.h != 0) goto L14;
        Context r9 = this.b.getContext();
        if (r9 != null) goto L7;
        r9 = eu5.b.a;
    L7:
        Toast.showSuccessText(r9, this.b.getString(2131888828));
        this.b.dismissAllowingStateLoss();     // Catch: Exception -> L10
    L34:
        m.b(this.b.m);
        return;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r10 = DialogFragmentLancet.sLastShowStack;
        if (r10 == null) goto L34;
        com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L34
    L14:
        Context r11 = this.b.getContext();
        if (r11 != null) goto L17;
        r11 = eu5.b.a;
    L17:
        String r12 = xo5.a.c(r11, 2131888842, "validity", this.a.b);
        Context r2 = this.b.getContext();
        if (r2 != null) goto L20;
        r2 = eu5.b.a;
    L20:
        Toast.showSuccessText(r2, r12);
        DocFreshNessFragment r13 = this.b;
        i r3 = this.a;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r3, "entity");
        Iterator<T> r4 = r13.o.iterator();
    L22:
        if (r4.hasNext() == false) goto L24;
        ((i) r4.next()).a = false;
        goto L22
    L24:
        r3.a = true;
        DocFreshNessAdapter r14 = r13.p;
        if (r14 == null) goto L36;
        r14.notifyDataSetChanged();
    L36:
        this.b.dismissAllowingStateLoss();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r15 = DialogFragmentLancet.sLastShowStack;
        if (r15 == null) goto L34;
        com.bytedance.crash.d.d(r15, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L34
    }
}
