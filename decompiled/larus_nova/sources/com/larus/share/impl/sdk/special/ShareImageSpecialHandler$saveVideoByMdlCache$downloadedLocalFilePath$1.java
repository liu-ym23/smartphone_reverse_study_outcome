package com.larus.share.impl.sdk.special;

import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
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

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.share.impl.sdk.special.ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1", f = "ShareImageSpecialHandler.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
final class ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ String $downloadUrl;
    private /* synthetic */ Object L$0;
    int label;

    public ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1(String r100, String r101, Continuation<? super ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1> r102) {
        this.$downloadUrl = r100;
        this.$cacheKey = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1 r102 = new ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1(this.$downloadUrl, this.$cacheKey, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L19
    L15:
        String r103 = (String) r100;     // Catch: Throwable -> L19
    L17:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L19
    L21:
        String r105 = this.$cacheKey;
        Throwable r106 = Result.m9452exceptionOrNullimpl(r104);
        if (r106 == null) goto L28;
        if ((r106 instanceof CancellationException) == true) goto L26;
        FLogger.f375446a.e("ShareImageSpecialHandler", "[saveVideoByMdlCache] mdl download exception, key=" + r105 + ", " + r106);
        goto L28
    L26:
        throw r106;
    L28:
        if (Result.m9455isFailureimpl(r104) == false) goto L31;
        return null;
    L31:
        return r104;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r107 = (CoroutineScope) this.L$0;
        String r108 = this.$downloadUrl;
        String r109 = this.$cacheKey;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L19
        Lazy r111 = q3.f365794a;     // Catch: Throwable -> L19
        z3 r112 = q3.a();     // Catch: Throwable -> L19
        if (r112 == null) goto L16;
        this.label = 1;     // Catch: Throwable -> L19
        r100 = r112.h(r108, r109, this);     // Catch: Throwable -> L19
        if (r100 != r101) goto L15;
        return r101;
    L16:
        r103 = null;
    L19:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }
}
