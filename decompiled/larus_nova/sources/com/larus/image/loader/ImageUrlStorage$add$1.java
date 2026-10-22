package com.larus.image.loader;

import com.larus.utils.y0;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.image.loader.ImageUrlStorage$add$1", f = "ImageUrlStorage.kt", i = {0}, l = {78}, m = "invokeSuspend", n = {"pendingKey"}, s = {"L$0"})
final class ImageUrlStorage$add$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $originUrl;
    final /* synthetic */ String $renewUrl;
    Object L$0;
    int label;

    public ImageUrlStorage$add$1(String r100, String r101, Continuation<? super ImageUrlStorage$add$1> r102) {
        this.$originUrl = r100;
        this.$renewUrl = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ImageUrlStorage$add$1(this.$originUrl, this.$renewUrl, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ImageUrlStorage$add$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        String r103 = (String) this.L$0;
        ResultKt.throwOnFailure(r100);
    L14:
        HashMap<String, a> r104 = ImageUrlStorage.f350959e;
        if ((!r104.isEmpty()) == false) goto L19;
        r104.remove(r103);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ImageUrlStorage r105 = ImageUrlStorage.f350955a;
        String r106 = ImageUrlStorage.a(r105, this.$originUrl);
        if (ImageUrlStorage.f350960f == false) goto L17;
        String r107 = ImageUrlStorage.e(y0.i(this.$renewUrl));
        ImageUrlStorage.f350959e.put(r107, new a(this.$renewUrl, r106));
        this.L$0 = r107;
        this.label = 1;
        if (DelayKt.delay(10000, this) != r101) goto L13;
        return r101;
    L13:
        r103 = r107;
        goto L14
    L17:
        ImageUrlStorage.b(r105, r106, this.$renewUrl);
        goto L19
    }
}
