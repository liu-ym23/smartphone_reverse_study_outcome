package com.bytedance.ee.bear.middleground.permission.secret;

import android.text.Editable;
import android.view.View;
import com.bytedance.ee.bear.middleground.permission.secret.model.SecretApprovalResultModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/middleground/permission/secret/UpdateSecretLevelResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.permission.secret.InputReasonFragment$sendApprovalRequest$2", f = "InputReasonFragment.kt", i = {0}, l = {848}, m = "invokeSuspend", n = {"approvalReqDisposable"}, s = {"L$0"})
final class InputReasonFragment$sendApprovalRequest$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UpdateSecretLevelResult>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ InputReasonFragment this$0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ kotlinx.coroutines.i<UpdateSecretLevelResult> a;
        public final /* synthetic */ InputReasonFragment b;

        public a(kotlinx.coroutines.j r1, InputReasonFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            SecretApprovalResultModel r6 = (SecretApprovalResultModel) r5;
            if (this.a.isActive() == false) goto L6;
            tt5.a.h("InputReasonFragment", "(" + this.b + ") sendApprovalRequest, onNext");
            kotlinx.coroutines.i<UpdateSecretLevelResult> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(new UpdateSecretLevelResult(true, null, r6.getInstance_code())));
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ kotlinx.coroutines.i<UpdateSecretLevelResult> a;
        public final /* synthetic */ InputReasonFragment b;

        public b(kotlinx.coroutines.j r1, InputReasonFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            if (this.a.isActive() == false) goto L6;
            tt5.a.e("InputReasonFragment", "(" + this.b + ") sendApprovalRequest, onError:", r6, false);
            kotlinx.coroutines.i<UpdateSecretLevelResult> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(new UpdateSecretLevelResult(false, r6, "")));
            return;
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ kotlinx.coroutines.i<UpdateSecretLevelResult> a;
        public final /* synthetic */ InputReasonFragment b;

        public c(kotlinx.coroutines.j r1, InputReasonFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            if (this.a.isActive() == false) goto L6;
            tt5.a.h("InputReasonFragment", "(" + this.b + ") sendApprovalRequest, onComplete");
            kotlinx.coroutines.i<UpdateSecretLevelResult> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(new UpdateSecretLevelResult(false, null, "")));
            return;
        }
    }

    public InputReasonFragment$sendApprovalRequest$2(InputReasonFragment r1, Continuation<? super InputReasonFragment$sendApprovalRequest$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InputReasonFragment$sendApprovalRequest$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super UpdateSecretLevelResult> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        InputReasonFragment r3 = (InputReasonFragment) this.L$1;
        Ref.ObjectRef r4 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r5 = r19;
    L29:
        UpdateSecretLevelResult r6 = (UpdateSecretLevelResult) r5;
        tt5.a.h("InputReasonFragment", "(" + this.this$0 + ") sendApprovalRequest, did get response: " + r6);
        Disposable r7 = (Disposable) r4.element;
        if (r7 == null) goto L32;
        r7.dispose();
    L32:
        r4.element = null;
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        tt5.a.h("InputReasonFragment", "(" + this.this$0 + ") sendApprovalRequest, will send request.");
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        InputReasonFragment r9 = this.this$0;
        this.L$0 = r8;
        this.L$1 = r9;
        this.label = 1;
        kotlinx.coroutines.j r10 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r10.C();
        int r11 = InputReasonFragment.B;
        SecretViewModel r12 = (SecretViewModel) r9.x.getValue();
        String r13 = r9.h;
        int r14 = r9.i;
        String r15 = r9.t.getApproval_code() + "";
        SecretLevel r16 = r9.r;
        if (r16 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("oldSerretLevel");
        r16 = null;
    L11:
        String r17 = r16.getId();
        String r18 = r9.j;
        View r110 = r9.getView();
        if (r110 == null) goto L14;
        SpaceEditText r20 = (SpaceEditText) r110.findViewById(2131375324);
    L15:
        if (r20 == null) goto L22;
        Editable r21 = r20.getText();
        if (r21 == null) goto L22;
        String r22 = r21.toString();
        if (r22 == null) goto L22;
        String r111 = r22;
    L23:
        r8.element = r12.generateApproveReq(r13, r14, r15, r17, r18, r111, r9.v, r9.s).subscribe(new a(r10, r9), new b(r10, r9), new c(r10, r9));
        r10.i(new InputReasonFragment$sendApprovalRequest$2$result$1$4(r8));
        r5 = r10.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(this);
    L26:
        if (r5 != r1) goto L28;
        return r1;
    L28:
        r4 = r8;
    L22:
        r111 = "";
        goto L23
    L14:
        r20 = null;
        goto L15
    }
}
