package com.larus.uaigc.creation.gallery.providers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationGalleryUtil", f = "CreationGalleryUtil.kt", i = {0}, l = {187}, m = "getMetaDataMap", n = {"creationTaskId"}, s = {"L$0"})
final class CreationGalleryUtil$getMetaDataMap$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationGalleryUtil this$0;

    public CreationGalleryUtil$getMetaDataMap$1(CreationGalleryUtil r100, Continuation<? super CreationGalleryUtil$getMetaDataMap$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return CreationGalleryUtil.a(this.this$0, null, null, null, this);
    }
}
