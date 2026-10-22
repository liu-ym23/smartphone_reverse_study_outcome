package com.larus.uaigc.chat;

import com.larus.uaigc.helper.i0;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.chat.CreationVideoManagerViewModel$bindObservers$1", f = "CreationVideoManagerViewModel.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
final class CreationVideoManagerViewModel$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationVideoManagerViewModel this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.chat.CreationVideoManagerViewModel$bindObservers$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationVideoManagerViewModel f370401a;

        public AnonymousClass1(CreationVideoManagerViewModel r100) {
            this.f370401a = r100;
        }

        public final Object a(Unit r100, Continuation<? super Unit> r101) {
            if ((r101 instanceof CreationVideoManagerViewModel$bindObservers$1$1$emit$1) == false) goto L7;
            CreationVideoManagerViewModel$bindObservers$1$1$emit$1 r102 = (CreationVideoManagerViewModel$bindObservers$1$1$emit$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L16;
            if (r106 != 1) goto L15;
            String r107 = (String) r102.L$1;
            CreationVideoManagerViewModel r108 = (CreationVideoManagerViewModel) r102.L$0;
            ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L27
        L25:
            r108.f370391d = r107;     // Catch: Throwable -> L27
            Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
        L29:
            Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
            if (r110 == null) goto L33;
            FLogger.f375446a.e("CreationVideoManagerVM", "bindObservers: select auto play video failed", r110);
        L33:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r104);
            CreationVideoManagerViewModel r111 = this.f370401a;
            Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L27
            HashMap r113 = new HashMap(r111.f370389b);     // Catch: Throwable -> L27
            if (r113.isEmpty() == false) goto L21;
            FLogger.f375446a.i("CreationVideoManagerVM", "bindObservers collect: curBindMdVideoView 为空，跳过");     // Catch: Throwable -> L27
            return Unit.INSTANCE;
        L21:
            String r114 = CreationVideoManagerViewModel.k(r111, r113);     // Catch: Throwable -> L27
            MutableSharedFlow r115 = (MutableSharedFlow) r111.f370392e.getValue();     // Catch: Throwable -> L27
            r102.L$0 = r111;     // Catch: Throwable -> L27
            r102.L$1 = r114;     // Catch: Throwable -> L27
            r102.label = 1;     // Catch: Throwable -> L27
            if (r115.emit(r114, r102) != r105) goto L24;
            return r105;
        L24:
            r108 = r111;
            r107 = r114;
        L27:
            th = move-exception;
            Result.Companion r116 = Result.Companion;
            r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L7:
            r102 = new CreationVideoManagerViewModel$bindObservers$1$1$emit$1(this, r101);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((Unit) r100, r101);
        }
    }

    public CreationVideoManagerViewModel$bindObservers$1(CreationVideoManagerViewModel r100, Continuation<? super CreationVideoManagerViewModel$bindObservers$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CreationVideoManagerViewModel$bindObservers$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CreationVideoManagerViewModel$bindObservers$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        MutableSharedFlow<Unit> r103 = this.this$0.f370394g;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r104 = new i0(r103).f373026d;
        AnonymousClass1 r105 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r104.collect(r105, this) != r101) goto L12;
        return r101;
    }
}
