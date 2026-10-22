package com.larus.avlink.gallery.executor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaAdditionReconciler", f = "MediaAdditionReconciler.kt", i = {}, l = {206, 207}, m = "hasInFlightSync", n = {}, s = {})
public final class MediaAdditionReconciler$hasInFlightSync$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaAdditionReconciler this$0;

    public MediaAdditionReconciler$hasInFlightSync$1(MediaAdditionReconciler r100, Continuation<? super MediaAdditionReconciler$hasInFlightSync$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MediaAdditionReconciler r101 = this.this$0;
        MediaAdditionReconciler r102 = MediaAdditionReconciler.f292495a;
        return r101.e(this);
    }
}
