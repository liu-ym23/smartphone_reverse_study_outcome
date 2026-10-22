package com.larus.avlink.gallery.compat;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.compat.ThumbnailMetadataHelper", f = "ThumbnailMetadataHelper.kt", i = {0, 0, 1, 1}, l = {61, 72}, m = "createThumbnailMetadata", n = {"metadata", "imageUuid", "metadata", "imageUuid"}, s = {"L$0", "J$0", "L$0", "J$0"})
final class ThumbnailMetadataHelper$createThumbnailMetadata$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThumbnailMetadataHelper this$0;

    public ThumbnailMetadataHelper$createThumbnailMetadata$1(ThumbnailMetadataHelper r100, Continuation<? super ThumbnailMetadataHelper$createThumbnailMetadata$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, 0, null, 0, 0, 0, 0, this);
    }
}
