package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v implements DialogInterface.OnClickListener {
    public final /* synthetic */ SecretLevelFragment a;
    public final /* synthetic */ SecretLevel b;
    public final /* synthetic */ Ref.ObjectRef<SecretApprovalDefModel> c;

    public v(SecretLevelFragment r1, SecretLevel r2, Ref.ObjectRef<SecretApprovalDefModel> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r14, int r15) {
        int r16 = InputReasonFragment.B;
        FragmentActivity r0 = this.a.requireActivity();
        SecretLevelFragment r17 = this.a;
        String r1 = r17.k;
        int r2 = r17.l;
        String r3 = this.b.getId();
        String r4 = this.b.getName();
        int r5 = this.b.getLevel();
        String r6 = this.b.getApplyTips();
        SecretLevelFragment r18 = this.a;
        InputReasonFragment.a.a(r0, r1, r2, r3, r4, r5, r6, r18.n, r18.m.getSecretLevel(), (SecretApprovalDefModel) this.c.element, false, null, this.b);
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r19 = DialogFragmentLancet.sLastShowStack;
        if (r19 == null) goto L12;
        com.bytedance.crash.d.d(r19, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
