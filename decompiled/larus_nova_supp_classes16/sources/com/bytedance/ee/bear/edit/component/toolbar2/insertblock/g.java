package com.bytedance.ee.bear.edit.component.toolbar2.insertblock;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements Runnable {
    public final /* synthetic */ InsertNewBlockFragment a;
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;

    public static final class a implements e.a {
        public final /* synthetic */ InsertNewBlockFragment a;

        public a(InsertNewBlockFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.insertblock.e.a
        public final void a(int r2) {
            if (r2 <= 0) goto L11;
            return;
        L11:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L14;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public g(InsertNewBlockFragment r1, View r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (this.a.getActivity() == null) goto L13;
        InsertNewBlockFragment r0 = this.a;
        FragmentActivity r2 = r0.getActivity();
        View r3 = this.b;
        r0.h = new e(r2, r3, r3.getHeight());
        InsertNewBlockFragment r1 = this.a;
        e r4 = r1.h;
        if (r4 == null) goto L7;
        View r5 = this.c;
        r4.f = false;
        r4.a(r4.a[1]);
        View r6 = r5.findViewById(2131375196);
        r6.setOnTouchListener(new d(r4, r6));
        r4.e = new a(r1);
    L7:
        InsertNewBlockViewModel r7 = this.a.k;
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L10:
        InsertNewBlockViewModel.a r8 = r7.getDelegate();
        if (r8 == null) goto L15;
        AbsInsertNewBlockPlugin.a(((com.bytedance.ee.bear.edit.component.toolbar2.insertblock.a) r8).a, "setPanelHeight", String.valueOf(n.E(this.b.getHeight())));
        return;
    L15:
        return;
    L13:
        tt5.a.d("InsertNewBlockFragment", "view.post : activity is null!");
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
