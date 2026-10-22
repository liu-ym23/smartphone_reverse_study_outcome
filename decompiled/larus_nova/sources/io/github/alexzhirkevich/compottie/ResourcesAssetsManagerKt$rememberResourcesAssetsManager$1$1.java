package io.github.alexzhirkevich.compottie;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.github.alexzhirkevich.compottie.ResourcesAssetsManagerKt$rememberResourcesAssetsManager$1$1", f = "ResourcesAssetsManager.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class ResourcesAssetsManagerKt$rememberResourcesAssetsManager$1$1 extends SuspendLambda implements Function2<String, Continuation<? super byte[]>, Object> {
    final /* synthetic */ State<Function2<String, Continuation<? super byte[]>, Object>> $updatedReadBytes$delegate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ResourcesAssetsManagerKt$rememberResourcesAssetsManager$1$1(State<? extends Function2<? super String, ? super Continuation<? super byte[]>, ? extends Object>> r100, Continuation<? super ResourcesAssetsManagerKt$rememberResourcesAssetsManager$1$1> r101) {
        this.$updatedReadBytes$delegate = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ResourcesAssetsManagerKt$rememberResourcesAssetsManager$1$1 r102 = new ResourcesAssetsManagerKt$rememberResourcesAssetsManager$1$1(this.$updatedReadBytes$delegate, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String r100, Continuation<? super byte[]> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String r100, Continuation<? super byte[]> r101) {
        return ((ResourcesAssetsManagerKt$rememberResourcesAssetsManager$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        String r103 = (String) this.L$0;
        Function2<String, Continuation<? super byte[]>, Object> r104 = this.$updatedReadBytes$delegate.getValue();
        this.label = 1;
        r100 = r104.invoke(r103, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
