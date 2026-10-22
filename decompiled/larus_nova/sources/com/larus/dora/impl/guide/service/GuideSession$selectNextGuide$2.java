package com.larus.dora.impl.guide.service;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t39.l;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/api/IDoraGuideInteractor;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$selectNextGuide$2", f = "DoraGuideServiceImpl.kt", i = {0, 0}, l = {582}, m = "invokeSuspend", n = {"$this$withContext", "element$iv"}, s = {"L$0", "L$3"})
final class GuideSession$selectNextGuide$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super l>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$selectNextGuide$2(GuideSession r100, Continuation<? super GuideSession$selectNextGuide$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        GuideSession$selectNextGuide$2 r102 = new GuideSession$selectNextGuide$2(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super l> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super l> r101) {
        return ((GuideSession$selectNextGuide$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0092 -> B:20:0x009a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        Object r102 = this.L$3;
        Iterator r103 = (Iterator) this.L$2;
        GuideSession r104 = (GuideSession) this.L$1;
        CoroutineScope r105 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r110);
        CoroutineScope r106 = r105;
        GuideSession r107 = r104;
        Iterator r108 = r103;
        Object r109 = r102;
        Object r111 = r100;
        GuideSession$selectNextGuide$2 r112 = this;
    L21:
        if (((Boolean) r110).booleanValue() == true) goto L28;
        GuideSession$selectNextGuide$2 r113 = r112;
        r100 = r111;
        Iterator r114 = r108;
        GuideSession r115 = r107;
        CoroutineScope r116 = r106;
    L10:
        if (r114.hasNext() == false) goto L24;
        Object r117 = r114.next();
        l r118 = (l) r117;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L14
        g49.d.d(r115.c(), "launchNextGuide checking guide=" + r118.f() + ':' + r118);     // Catch: Throwable -> L14
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        r113.L$0 = r116;
        r113.L$1 = r115;
        r113.L$2 = r114;
        r113.L$3 = r117;
        r113.label = 1;
        Object r120 = r118.c(r113);
        if (r120 != r100) goto L19;
        return r100;
    L19:
        Object r121 = r100;
        r112 = r113;
        r110 = r120;
        r106 = r116;
        r107 = r115;
        r108 = r114;
        r109 = r117;
        r111 = r121;
    L14:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L24:
        return null;
    L28:
        return r109;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        CoroutineScope r123 = (CoroutineScope) this.L$0;
        GuideSession r124 = this.this$0;
        r114 = r124.f335966j.iterator();
        r116 = r123;
        r115 = r124;
        r113 = this;
        goto L10
    }
}
