package com.larus.larkfeed.impl.gallery;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.larkfeed.impl.gallery.LarkOfficeMaterialGalleryDataSource", f = "LarkOfficeMaterialGalleryHelper.kt", i = {0, 0, 1, 1}, l = {170, 199}, m = "mapToDisplayItem", n = {"originalData", "presentation", "originalData", "presentation"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class LarkOfficeMaterialGalleryDataSource$mapToDisplayItem$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LarkOfficeMaterialGalleryDataSource this$0;

    public LarkOfficeMaterialGalleryDataSource$mapToDisplayItem$1(LarkOfficeMaterialGalleryDataSource r100, Continuation<? super LarkOfficeMaterialGalleryDataSource$mapToDisplayItem$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n(null, this);
    }
}
