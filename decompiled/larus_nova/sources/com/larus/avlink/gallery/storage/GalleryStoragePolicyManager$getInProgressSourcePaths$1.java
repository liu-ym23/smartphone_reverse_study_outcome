package com.larus.avlink.gallery.storage;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.storage.GalleryStoragePolicyManager", f = "GalleryStoragePolicyManager.kt", i = {0}, l = {216}, m = "getInProgressSourcePaths", n = {"$this$getInProgressSourcePaths_u24lambda_u2416"}, s = {"L$0"})
public final class GalleryStoragePolicyManager$getInProgressSourcePaths$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GalleryStoragePolicyManager this$0;

    public GalleryStoragePolicyManager$getInProgressSourcePaths$1(GalleryStoragePolicyManager r100, Continuation<? super GalleryStoragePolicyManager$getInProgressSourcePaths$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        GalleryStoragePolicyManager r101 = this.this$0;
        GalleryStoragePolicyManager r102 = GalleryStoragePolicyManager.f292721a;
        return r101.l(this);
    }
}
