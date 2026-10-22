package com.larus.voicecall.impl.component.core;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.voicecall.impl.ui.VoiceCallContentLayout;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.core.RealtimeCoreComponent$listenOnRetryCommands$1", f = "RealtimeCoreComponent.kt", i = {}, l = {540}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCoreComponent$listenOnRetryCommands$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCoreComponent this$0;

    /* JADX INFO: renamed from: com.larus.voicecall.impl.component.core.RealtimeCoreComponent$listenOnRetryCommands$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/voicecall/impl/RealtimeRetryRequest;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.component.core.RealtimeCoreComponent$listenOnRetryCommands$1$3", f = "RealtimeCoreComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<com.larus.voicecall.impl.c0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RealtimeCoreComponent this$0;

        public AnonymousClass3(RealtimeCoreComponent r100, Continuation<? super AnonymousClass3> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass3(this.this$0, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(com.larus.voicecall.impl.c0 r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(com.larus.voicecall.impl.c0 r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r100);
            RealtimeCoreComponent r101 = this.this$0;
            int r102 = RealtimeCoreComponent.P;
            e3a.b r103 = r101.W3();
            r101.X3().i0();
            n3a.a r104 = (n3a.a) r101.f377298y.getValue();
            if (r104 == null) goto L7;
            r104.u00("automatic_click");
        L7:
            RealtimeCallParam.d r105 = r103.a().f288752l;
            String r106 = UUID.randomUUID().toString();
            r105.getClass();
            Intrinsics.checkNotNullParameter(r106, "<set-?>");
            r105.f288785a = r106;
            if (r103.f484273n == false) goto L19;
            r103.f484273n = false;
            g3a.a r107 = r101.V3();
            if (r107 == null) goto L19;
            VoiceCallContentLayout r108 = r107.dg();
            if (r108 == null) goto L19;
            if (r108.f379318a.f378295w.getVisibility() != 0) goto L16;
            boolean r109 = true;
        L17:
            if (r109 == false) goto L19;
            com.larus.voicecall.impl.utils.c.d(r108.f379318a.f378295w, false);
            goto L19
        L16:
            r109 = false;
        L19:
            r101.Q3().v(r103.a());
            return Unit.INSTANCE;
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public RealtimeCoreComponent$listenOnRetryCommands$1(RealtimeCoreComponent r100, Continuation<? super RealtimeCoreComponent$listenOnRetryCommands$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RealtimeCoreComponent$listenOnRetryCommands$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RealtimeCoreComponent$listenOnRetryCommands$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.voicecall.impl.component.core.t0] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.voicecall.impl.component.core.r0] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.voicecall.impl.component.core.s0] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        RealtimeCoreComponent r103 = this.this$0;
        int r104 = RealtimeCoreComponent.P;
        kotlinx.coroutines.flow.b r105 = ((com.larus.voicecall.impl.d0) r103.Q3().f377101w.getValue()).f378211b;
        final RealtimeCoreComponent r106 = this.this$0;
        ?? r107 = new r0(r106);
        ?? r108 = new s0(r106);
        AnonymousClass3 r109 = new AnonymousClass3(r106, null);
        ?? r110 = new t0();
        this.label = 1;
        Object r111 = r105.collect(new com.larus.voicecall.impl.e0(r107, r108, r109, r110), this);
        if (r111 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r111 = Unit.INSTANCE;
    L12:
        if (r111 != r101) goto L15;
        return r101;
    }
}
