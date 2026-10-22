package com.larus.avlink.aiproactive;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "listState", "Lcom/larus/avlink/aiproactive/AiProactiveListState;", "behaviorAwareEnabled"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.aiproactive.AiProactiveTaskViewModel$imuBannerVisibleFlow$1", f = "AiProactiveTaskViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AiProactiveTaskViewModel$imuBannerVisibleFlow$1 extends SuspendLambda implements Function3<q, Boolean, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    public AiProactiveTaskViewModel$imuBannerVisibleFlow$1(Continuation<? super AiProactiveTaskViewModel$imuBannerVisibleFlow$1> r100) {
        super(3, r100);
    }

    public final Object invoke(q r100, boolean r101, Continuation<? super Boolean> r102) {
        AiProactiveTaskViewModel$imuBannerVisibleFlow$1 r103 = new AiProactiveTaskViewModel$imuBannerVisibleFlow$1(r102);
        r103.L$0 = r100;
        r103.Z$0 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(q r100, Boolean r101, Continuation<? super Boolean> r102) {
        return invoke(r100, r101.booleanValue(), r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L36;
        ResultKt.throwOnFailure(r100);
        q r101 = (q) this.L$0;
        boolean r102 = this.Z$0;
        if ((r101 instanceof q.d) == false) goto L7;
        q.d r103 = (q.d) r101;
    L8:
        boolean r104 = true;
        if (r103 == null) goto L28;
        List<t88.n> r105 = r103.f291601a;
        if (r105 == null) goto L28;
        List<t88.n> r106 = r105;
        if ((r106 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r107 = r106.iterator();
    L19:
        if (r107.hasNext() == false) goto L16;
        if (((t88.n) r107.next()).h() != 3) goto L23;
        boolean r108 = true;
    L24:
        if (r108 == false) goto L19;
        boolean r109 = true;
    L26:
        if (r109 != true) goto L28;
        boolean r110 = true;
    L29:
        if (r110 == false) goto L32;
        if (r102 == true) goto L32;
    L34:
        return Boxing.boxBoolean(r104);
    L32:
        r104 = false;
        goto L34
    L23:
        r108 = false;
    L16:
        r109 = false;
        goto L26
    L15:
        if (r106.isEmpty() == false) goto L17;
    L28:
        r110 = false;
        goto L29
    L7:
        r103 = null;
        goto L8
    L36:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
