package com.larus.dora.impl.dynamic;

import com.larus.platform.model.NewcomerGuideItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "Lcom/larus/dora/impl/network/OnboardingStatus;", "", "Lcom/larus/platform/model/NewcomerGuideItem;", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "status", "config", "connectionState"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraDynamicFragment$onViewCreated$5$1", f = "DoraDynamicFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDynamicFragment$onViewCreated$5$1 extends SuspendLambda implements Function4<com.larus.dora.impl.network.w, List<? extends NewcomerGuideItem>, e59.b, Continuation<? super Triple<? extends com.larus.dora.impl.network.w, ? extends List<? extends NewcomerGuideItem>, ? extends e59.b>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    public DoraDynamicFragment$onViewCreated$5$1(Continuation<? super DoraDynamicFragment$onViewCreated$5$1> r100) {
        super(4, r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(com.larus.dora.impl.network.w r100, List<NewcomerGuideItem> r101, e59.b r102, Continuation<? super Triple<com.larus.dora.impl.network.w, ? extends List<NewcomerGuideItem>, ? extends e59.b>> r103) {
        DoraDynamicFragment$onViewCreated$5$1 r104 = new DoraDynamicFragment$onViewCreated$5$1(r103);
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.L$2 = r102;
        return r104.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(com.larus.dora.impl.network.w r100, List<? extends NewcomerGuideItem> r101, e59.b r102, Continuation<? super Triple<? extends com.larus.dora.impl.network.w, ? extends List<? extends NewcomerGuideItem>, ? extends e59.b>> r103) {
        return invoke2(r100, r101, r102, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return new Triple((com.larus.dora.impl.network.w) this.L$0, (List) this.L$1, (e59.b) this.L$2);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
