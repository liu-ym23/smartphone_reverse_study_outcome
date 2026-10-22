package io.github.alexzhirkevich.compottie;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.github.alexzhirkevich.compottie.ResourcesAssetsManagerImpl", f = "ResourcesAssetsManager.kt", i = {}, l = {86}, m = "image", n = {}, s = {})
final class ResourcesAssetsManagerImpl$image$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ e0 this$0;

    public ResourcesAssetsManagerImpl$image$1(e0 r100, Continuation<? super ResourcesAssetsManagerImpl$image$1> r101) {
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
