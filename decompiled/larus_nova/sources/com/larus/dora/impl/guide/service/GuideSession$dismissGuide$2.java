package com.larus.dora.impl.guide.service;

import com.larus.dora.impl.guide.common.DoraGuideMeta;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import t39.l;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$dismissGuide$2", f = "DoraGuideServiceImpl.kt", i = {}, l = {568}, m = "invokeSuspend", n = {}, s = {})
public final class GuideSession$dismissGuide$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraGuideMeta $guideMeta;
    int label;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$dismissGuide$2(GuideSession r100, DoraGuideMeta r101, Continuation<? super GuideSession$dismissGuide$2> r102) {
        this.this$0 = r100;
        this.$guideMeta = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new GuideSession$dismissGuide$2(this.this$0, this.$guideMeta, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((GuideSession$dismissGuide$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        GuideSession r103 = this.this$0;
        if (r103.f335959c != GuideSession.GuideSessionState.FINISHED) goto L12;
        g49.d.e(r103.c(), "dismissGuide ignored: session already finished");
        return Unit.INSTANCE;
    L12:
        CopyOnWriteArrayList<l> r104 = r103.f335966j;
        DoraGuideMeta r105 = this.$guideMeta;
        Iterator<T> r106 = r104.iterator();
    L14:
        if (r106.hasNext() == false) goto L21;
        Object r107 = r106.next();
        if (((l) r107).f() != r105.getGuideId()) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == false) goto L14;
    L22:
        l r109 = (l) r107;
        if (r109 != null) goto L26;
        g49.d.d(this.this$0.c(), "dismissGuide failed: guide not found id=" + this.$guideMeta.getGuideId());
        return Unit.INSTANCE;
    L26:
        this.this$0.f335966j.remove(r109);
        GuideSession r110 = this.this$0;
        this.label = 1;
        if (GuideSession.a(r110, r109, this) != r101) goto L30;
        return r101;
    L18:
        r108 = false;
        goto L19
    L21:
        r107 = null;
        goto L22
    }
}
