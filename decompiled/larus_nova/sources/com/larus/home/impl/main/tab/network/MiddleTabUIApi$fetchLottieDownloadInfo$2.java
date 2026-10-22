package com.larus.home.impl.main.tab.network;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/home/impl/main/tab/network/MiddleTabUIDownloadInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.tab.network.MiddleTabUIApi$fetchLottieDownloadInfo$2", f = "MiddleTabUIApi.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
public final class MiddleTabUIApi$fetchLottieDownloadInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a>, Object> {
    int label;

    public MiddleTabUIApi$fetchLottieDownloadInfo$2(Continuation<? super MiddleTabUIApi$fetchLottieDownloadInfo$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MiddleTabUIApi$fetchLottieDownloadInfo$2(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super a> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super a> r101) {
        return ((MiddleTabUIApi$fetchLottieDownloadInfo$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L12:
        return ((com.larus.network.http.a) r110).f360135b;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        JSONObject r102 = new JSONObject();
        this.label = 1;
        r110 = HttpExtKt.k(ServiceType.BASIC_SERVICE, a.class, "/alice/user/tabbar/config", r102, null, null, false, null, null, null, this, 1008);
        if (r110 != r100) goto L12;
        return r100;
    }
}
