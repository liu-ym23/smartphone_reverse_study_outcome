package com.larus.gallery.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.gallery.api.IGalleryDataSource$DefaultImpls", f = "IGalleryDataSource.kt", i = {0, 0, 1, 1}, l = {72, 73}, m = "refreshDisplayItems", n = {"$this", "destination$iv$iv", "$this", "destination$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class IGalleryDataSource$refreshDisplayItems$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    public IGalleryDataSource$refreshDisplayItems$1(Continuation<? super IGalleryDataSource$refreshDisplayItems$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return IGalleryDataSource.DefaultImpls.c(null, null, this);
    }
}
