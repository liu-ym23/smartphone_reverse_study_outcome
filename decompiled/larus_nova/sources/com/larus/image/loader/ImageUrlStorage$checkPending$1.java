package com.larus.image.loader;

import android.net.Uri;
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

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.image.loader.ImageUrlStorage$checkPending$1", f = "ImageUrlStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ImageUrlStorage$checkPending$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $successful;
    final /* synthetic */ Uri $uri;
    int label;

    public ImageUrlStorage$checkPending$1(Uri r100, boolean r101, Continuation<? super ImageUrlStorage$checkPending$1> r102) {
        this.$uri = r100;
        this.$successful = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ImageUrlStorage$checkPending$1(this.$uri, this.$successful, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ImageUrlStorage$checkPending$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r100);
        HashMap<String, a> r101 = ImageUrlStorage.f350959e;
        if (r101.isEmpty() == true) goto L7;
        ImageUrlStorage r102 = ImageUrlStorage.f350955a;
        Uri r103 = this.$uri;
        r102.getClass();
        a r104 = r101.remove(ImageUrlStorage.e(r103));
        if (r104 == null) goto L14;
        if (this.$successful == false) goto L14;
        ImageUrlStorage.b(r102, r104.f350963b, r104.f350962a);
    L14:
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
