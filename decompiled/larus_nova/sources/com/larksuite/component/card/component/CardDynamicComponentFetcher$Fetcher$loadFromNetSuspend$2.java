package com.larksuite.component.card.component;

import com.larksuite.component.card.utils.NetUtils;
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
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larksuite.component.card.component.CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2", f = "CardDynamicComponentFetcher.kt", i = {0}, l = {88}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
final class CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends byte[]>>, Object> {
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;

    public CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2(String r100, Continuation<? super CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2> r101) {
        this.$url = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2 r102 = new CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2(this.$url, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Result<? extends byte[]>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Result<byte[]>> r101) {
        return ((CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 != 1) goto L9;
        CoroutineScope r103 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L24
    L14:
        Response r104 = (Response) r100;     // Catch: Throwable -> L24
        if (r104.isSuccessful() == false) goto L22;
        ResponseBody r105 = r104.body();     // Catch: Throwable -> L24
        if (r105 == null) goto L21;
        byte[] r106 = r105.bytes();     // Catch: Throwable -> L24
        if (r106 == null) goto L21;
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L24
    L27:
        return Result.m9448boximpl(r107);
    L21:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L24
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(new RuntimeException("response body is null")));     // Catch: Throwable -> L24
        goto L27
    L22:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L24
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(new RuntimeException("response is not successful, code: " + r104.code())));     // Catch: Throwable -> L24
        goto L27
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        int r111 = NetUtils.f283948a;     // Catch: Throwable -> L24
        String r112 = this.$url;     // Catch: Throwable -> L24
        this.L$0 = r110;     // Catch: Throwable -> L24
        this.label = 1;     // Catch: Throwable -> L24
        r100 = NetUtils.a(r112, this);     // Catch: Throwable -> L24
        if (r100 != r101) goto L14;
        return r101;
    L24:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }
}
