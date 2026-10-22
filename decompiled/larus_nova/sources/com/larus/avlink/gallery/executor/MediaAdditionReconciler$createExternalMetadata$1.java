package com.larus.avlink.gallery.executor;

import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaAdditionReconciler", f = "MediaAdditionReconciler.kt", i = {0, 0, 0, 1, 1, 2, 2}, l = {212, 230, 233}, m = "createExternalMetadata", n = {SlcFlexDirection.FLEX_ROW, "uniqId", "mediaStoreId", SlcFlexDirection.FLEX_ROW, "uniqId", SlcFlexDirection.FLEX_ROW, "uniqId"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$0", "L$1"})
public final class MediaAdditionReconciler$createExternalMetadata$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaAdditionReconciler this$0;

    public MediaAdditionReconciler$createExternalMetadata$1(MediaAdditionReconciler r100, Continuation<? super MediaAdditionReconciler$createExternalMetadata$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MediaAdditionReconciler r101 = this.this$0;
        MediaAdditionReconciler r102 = MediaAdditionReconciler.f292495a;
        return r101.d(0, null, this);
    }
}
