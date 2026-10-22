package com.bytedance.ee.bear.middleground.permission.secret;

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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.permission.secret.InputReasonFragment$observeSecretPushOnce$2", f = "InputReasonFragment.kt", i = {}, l = {754}, m = "invokeSuspend", n = {}, s = {})
final class InputReasonFragment$observeSecretPushOnce$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<bu5.a> $secretPush;
    int label;
    final /* synthetic */ InputReasonFragment this$0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.secret.InputReasonFragment$observeSecretPushOnce$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.middleground.permission.secret.InputReasonFragment$observeSecretPushOnce$2$1", f = "InputReasonFragment.kt", i = {0}, l = {848}, m = "invokeSuspend", n = {"$this$withTimeout"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<bu5.a> $secretPush;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ InputReasonFragment this$0;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.secret.InputReasonFragment$observeSecretPushOnce$2$1$a */
        public static final class a implements bu5.a {
            public final /* synthetic */ InputReasonFragment a;
            public final /* synthetic */ kotlinx.coroutines.i<Unit> b;

            public a(InputReasonFragment r1, kotlinx.coroutines.j r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void didReceivePush(String r2) {
                tt5.a.h("InputReasonFragment", "(" + this.a + ") observeSecretPushOnce - RnPush callback.");
                if (this.b.isActive() == false) goto L6;
                kotlinx.coroutines.i<Unit> r3 = this.b;
                Result.Companion r0 = Result.Companion;
                r3.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                return;
            }
        }

        public AnonymousClass1(InputReasonFragment r1, Ref.ObjectRef<bu5.a> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$secretPush = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$secretPush, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Ref.ObjectRef r2 = (Ref.ObjectRef) this.L$2;
            InputReasonFragment r3 = (InputReasonFragment) this.L$1;
            CoroutineScope r4 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r9);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            final CoroutineScope r10 = (CoroutineScope) this.L$0;
            final InputReasonFragment r5 = this.this$0;
            final Ref.ObjectRef<bu5.a> r6 = this.$secretPush;
            this.L$0 = r10;
            this.L$1 = r5;
            this.L$2 = r6;
            this.label = 1;
            kotlinx.coroutines.j r7 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r7.C();
            tt5.a.h("InputReasonFragment", "(" + r5 + ") observeSecretPushOnce, register RnPush.");
            a r8 = new a(r5, r7);
            r6.element = r8;
            ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).d7(r5.h, r5.i, r8);
            r7.i(new InputReasonFragment$observeSecretPushOnce$2$1$1$1(r6, r10, r5));
            Object r11 = r7.B();
            if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
            DebugProbesKt.probeCoroutineSuspended(this);
        L11:
            if (r11 != r0) goto L14;
            return r0;
        }
    }

    public InputReasonFragment$observeSecretPushOnce$2(InputReasonFragment r1, Ref.ObjectRef<bu5.a> r2, Continuation<? super InputReasonFragment$observeSecretPushOnce$2> r3) {
        this.this$0 = r1;
        this.$secretPush = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new InputReasonFragment$observeSecretPushOnce$2(this.this$0, this.$secretPush, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        AnonymousClass1 r7 = new AnonymousClass1(this.this$0, this.$secretPush, null);
        this.label = 1;
        if (TimeoutKt.b(5000, r7, this) != r0) goto L12;
        return r0;
    }
}
