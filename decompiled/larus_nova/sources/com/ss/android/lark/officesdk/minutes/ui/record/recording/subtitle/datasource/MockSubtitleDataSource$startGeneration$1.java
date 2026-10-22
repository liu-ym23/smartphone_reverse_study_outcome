package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.datasource;

import bwb.b;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.datasource.MockSubtitleDataSource$startGeneration$1", f = "MockSubtitleDataSource.kt", i = {0, 1}, l = {61, 66}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
final class MockSubtitleDataSource$startGeneration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a this$0;

    public MockSubtitleDataSource$startGeneration$1(a r100, Continuation<? super MockSubtitleDataSource$startGeneration$1> r101) {
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MockSubtitleDataSource$startGeneration$1 r102 = new MockSubtitleDataSource$startGeneration$1(null, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MockSubtitleDataSource$startGeneration$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r103 = (CoroutineScope) this.L$0;
        int r104 = b.f21271a;
        b.g(MmUiLogScene.SUBTITLE, "startGeneration", "Starting mock subtitle generation", null, 8);
        CoroutineScope r105 = r103;
    L21:
        if (CoroutineScopeKt.isActive(r105) == false) goto L23;
        throw null;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        int r106 = b.f21271a;
        b.d(MmUiLogScene.SUBTITLE, "startGeneration", "Error in generation loop e:" + e, null);
        goto L21
    L23:
        return Unit.INSTANCE;
    L5:
        if (r102 == 1) goto L12;
        if (r102 != 2) goto L11;
        r105 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L25
        goto L21
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        CoroutineScope r107 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L17
        this.L$0 = r107;     // Catch: Exception -> L17
        this.label = 2;     // Catch: Exception -> L17
        if (DelayKt.delay(1000, this) != r101) goto L16;
        return r101;
    L16:
        r105 = r107;
    L17:
        e = move-exception;
        r105 = r107;
        int r108 = b.f21271a;
        b.d(MmUiLogScene.SUBTITLE, "startGeneration", "Error in generation loop e:" + e, null);
        goto L21
    }
}
