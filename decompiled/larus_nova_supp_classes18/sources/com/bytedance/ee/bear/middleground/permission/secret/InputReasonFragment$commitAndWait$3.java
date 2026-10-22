package com.bytedance.ee.bear.middleground.permission.secret;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.secret.ApprovalDialogCallbacks;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.permission.secret.InputReasonFragment$commitAndWait$3", f = "InputReasonFragment.kt", i = {0}, l = {709}, m = "invokeSuspend", n = {"approvalReqTask"}, s = {"L$0"})
final class InputReasonFragment$commitAndWait$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InputReasonFragment this$0;

    public InputReasonFragment$commitAndWait$3(InputReasonFragment r1, Continuation<? super InputReasonFragment$commitAndWait$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        InputReasonFragment$commitAndWait$3 r0 = new InputReasonFragment$commitAndWait$3(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r4 = false;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        Deferred r1 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r18);
    L13:
        if (r1.isCompleted() == true) goto L16;
        tt5.a.d("InputReasonFragment", "(" + this.this$0 + ") commitAndWait, awaitAll finished but approvalReqTask is not completed.");
        return Unit.INSTANCE;
    L16:
        UpdateSecretLevelResult r3 = (UpdateSecretLevelResult) r1.getCompleted();
        if (r3.getSuccess() == false) goto L74;
        InputReasonFragment r5 = this.this$0;
        String r6 = r3.getSessionCode();
        if (r5.y == false) goto L21;
        Toast.cancelLoading();
        r5.y = false;
    L21:
        r5.z = false;
        View r7 = r5.getView();
        if (r7 == null) goto L24;
        UDEditText r8 = (SpaceEditText) r7.findViewById(2131375324);
    L25:
        rcb.c.d(r8);
        String r9 = "";
        if (com.bytedance.ee.bear.middleground.permission.b.n() == true) goto L28;
    L39:
        int r10 = ReSubmitApplyDialog.a;
        FragmentActivity r11 = r5.requireActivity();
        if (r6 == null) goto L43;
        r9 = r6;
    L43:
        int r12 = r5.i;
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r9, "code");
        StringBuilder r13 = new StringBuilder("showSuccessApply code: ");
        if (r9.length() <= 0) goto L46;
        boolean r14 = true;
    L47:
        r13.append(r14);
        tt5.a.h("ReSubmitApplyDialog", r13.toString());
        BearUDDialogBuilder r15 = new BearUDDialogBuilder(r11);
        r15.a.title(2131889923);
        r15.a.message(a0.a(r12, 2131888879, 2131889922));
        r15.a.style(2131951622);
        if (r9.length() <= 0) goto L50;
        boolean r16 = true;
    L51:
        if (r16 == false) goto L53;
        r15.b(2131391778, 2131889920, 2131106622, new l(r9));
    L53:
        r15.b(2131391777, 2131889921, 2131105548, m.a);
        r15.h();
        com.bytedance.ee.bear.middleground.permission.c.L(true);
    L55:
        if (r5.ca0() == false) goto L93;
        ArrayList<SecretApprovalDefModel.Reviewer> r17 = r5.t.getReviewers();
        if (r17 != null) goto L59;
    L60:
        r4 = true;
    L61:
        if (r4 == false) goto L65;
        ApprovalDialogCallbacks r19 = r5.w;
        if (r19 == null) goto L93;
        r19.onSuccessResult(r6);
        goto L93
    L65:
        ApprovalDialogCallbacks r20 = r5.w;
        if (r20 == null) goto L93;
        r20.onApproval(r6);
        goto L93
    L59:
        if (r17.isEmpty() == false) goto L61;
    L93:
        r5.dismissAllowingStateLoss();     // Catch: Exception -> L70
    L92:
        return Unit.INSTANCE;
    L70:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r21 = DialogFragmentLancet.sLastShowStack;
        if (r21 == null) goto L92;
        com.bytedance.crash.d.d(r21, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L92
    L50:
        r16 = false;
        goto L51
    L46:
        r14 = false;
        goto L47
    L28:
        if (r5.t.getReviewers() != null) goto L30;
    L32:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().l(r5.h, r5.k + "", r5.l);
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).Q(r5.h, r5.k, r5.l);
        if (r5.q.length() <= 0) goto L35;
        boolean r22 = true;
    L36:
        if (r22 == false) goto L38;
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).Q(r5.q, r5.k, r5.l);
    L38:
        Toast.showSuccessText(r5.getContext(), 2131889256);
        goto L55
    L35:
        r22 = false;
        goto L36
    L30:
        if (r5.t.getReviewers().size() <= 0) goto L32;
    L24:
        r8 = null;
        goto L25
    L74:
        InputReasonFragment r23 = this.this$0;
        NetService.ServerErrorException r24 = r3.getError();
        if (r23.y == false) goto L77;
        Toast.cancelLoading();
        r23.y = false;
    L77:
        r23.z = false;
        int r25 = b0.a;
        CharSequence r26 = eu5.b.a.getText(2131889896);
        if (r24 != null) goto L80;
    L82:
        int r27 = -1;
    L84:
        if (r27 != 4) goto L86;
        r26 = eu5.b.a.getText(2131889895);
    L86:
        String r28 = r26.toString();
        Toast.showFailureText(r23.getContext(), r28);
        if (r23.ca0() == false) goto L92;
        ApprovalDialogCallbacks r29 = r23.w;
        if (r29 == null) goto L92;
        r29.onFail(r28);
        goto L92
    L80:
        if ((r24 instanceof NetService.ServerErrorException) == false) goto L82;
        r27 = r24.getCode();
        goto L84
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r30 = (CoroutineScope) this.L$0;
        Deferred r110 = BuildersKt.async$default(r30, null, null, new InputReasonFragment$commitAndWait$3$observeSecretPushTask$1(this.this$0, null), 3, null);
        Deferred r31 = BuildersKt.async$default(r30, null, null, new InputReasonFragment$commitAndWait$3$approvalReqTask$1(this.this$0, null), 3, null);
        Deferred[] r32 = {r110, r31};
        this.L$0 = r31;
        this.label = 1;
        if (AwaitKt.b(r32, this) != r0) goto L11;
        return r0;
    L11:
        r1 = r31;
        goto L13
    }
}
