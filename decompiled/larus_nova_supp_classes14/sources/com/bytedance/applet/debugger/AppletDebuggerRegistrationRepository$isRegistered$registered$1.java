package com.bytedance.applet.debugger;

import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import com.larus.network.FlowHttpConnection;
import com.larus.platform.api.b2;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debugger.AppletDebuggerRegistrationRepository$isRegistered$registered$1", f = "AppletDebuggerRegistrationRepository.kt", i = {}, l = {17}, m = "invokeSuspend", n = {}, s = {})
public final class AppletDebuggerRegistrationRepository$isRegistered$registered$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    /* JADX INFO: renamed from: com.bytedance.applet.debugger.AppletDebuggerRegistrationRepository$isRegistered$registered$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.debugger.AppletDebuggerRegistrationRepository$isRegistered$registered$1$1", f = "AppletDebuggerRegistrationRepository.kt", i = {}, l = {TextExtraStruct.LVIDEO_WORK_DETAIL}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L11:
            dm9.a.b r14 = (dm9.a) r13;
            boolean r3 = false;
            if ((r14 instanceof dm9.a.b) == false) goto L21;
            dm9.a.b r15 = r14;
            if (r15.a.isSuccess() == false) goto L19;
            p r16 = (p) r15.a.getData();
            if (r16 == null) goto L18;
            r3 = Intrinsics.areEqual(r16.a(), Boxing.boxBoolean(true));
        L18:
            com.bytedance.ai.utils.g.a.i("AppletDebuggerRegistration", "[isRegistered] request success, registered=" + r3);
        L24:
            return Boxing.boxBoolean(r3);
        L19:
            com.bytedance.ai.utils.g.a.w("AppletDebuggerRegistration", "[isRegistered] business failed, code=" + r15.a.getCode() + ", msg=" + r15.a.getMsg());
            goto L24
        L21:
            if ((r14 instanceof dm9.a.a) == false) goto L26;
            com.bytedance.ai.utils.g r2 = com.bytedance.ai.utils.g.a;
            StringBuilder r4 = new StringBuilder("[isRegistered] request failed, code=");
            dm9.a.a r17 = (dm9.a.a) r14;
            r4.append(r17.a);
            r4.append(", msg=");
            r4.append(r17.b);
            r2.e("AppletDebuggerRegistration", r4.toString(), r17.c);
            goto L24
        L26:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            AppletDebuggerRegistrationApi.a r18 = AppletDebuggerRegistrationApi.a;
            AppletDebuggerRegistrationRepository$isRegistered$registered$1$1$result$1 r5 = new AppletDebuggerRegistrationRepository$isRegistered$registered$1$1$result$1(null);
            this.label = 1;
            r18.getClass();
            FlowHttpConnection r19 = FlowHttpConnection.a;
            r13 = FlowHttpConnection.g("AISDK", AppletDebuggerRegistrationApi.class, r5, true, null, b2.a.e(), null, this, 176);
            if (r13 != r0) goto L11;
            return r0;
        }
    }

    public AppletDebuggerRegistrationRepository$isRegistered$registered$1(Continuation<? super AppletDebuggerRegistrationRepository$isRegistered$registered$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new AppletDebuggerRegistrationRepository$isRegistered$registered$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CoroutineDispatcher r6 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(null);
        this.label = 1;
        r5 = BuildersKt.withContext(r6, r2, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
