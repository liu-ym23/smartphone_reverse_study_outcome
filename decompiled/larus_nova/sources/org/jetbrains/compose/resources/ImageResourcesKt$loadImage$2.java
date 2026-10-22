package org.jetbrains.compose.resources;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lorg/jetbrains/compose/resources/ImageCache;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "org.jetbrains.compose.resources.ImageResourcesKt$loadImage$2", f = "ImageResources.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
final class ImageResourcesKt$loadImage$2 extends SuspendLambda implements Function1<Continuation<Object>, Object> {
    final /* synthetic */ Function1<byte[], Object> $decode;
    final /* synthetic */ String $path;
    final /* synthetic */ t $resourceReader;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageResourcesKt$loadImage$2(Function1<? super byte[], Object> r100, t r101, String r102, Continuation<? super ImageResourcesKt$loadImage$2> r103) {
        this.$decode = r100;
        this.$resourceReader = r101;
        this.$path = r102;
        super(1, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new ImageResourcesKt$loadImage$2(this.$decode, this.$resourceReader, this.$path, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<Object> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<Object> r100) {
        return ((ImageResourcesKt$loadImage$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        Function1 r103 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r100);
    L13:
        return r103.invoke(r100);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Function1<byte[], Object> r104 = this.$decode;
        t r105 = this.$resourceReader;
        String r106 = this.$path;
        this.L$0 = r104;
        this.label = 1;
        Object r107 = r105.a(r106);
        if (r107 != r101) goto L11;
        return r101;
    L11:
        r103 = r104;
        r100 = r107;
        goto L13
    }
}
