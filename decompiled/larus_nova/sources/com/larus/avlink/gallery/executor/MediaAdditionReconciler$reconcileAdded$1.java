package com.larus.avlink.gallery.executor;

import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaAdditionReconciler", f = "MediaAdditionReconciler.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4}, l = {188, 189, 190, 191, 193}, m = "reconcileAdded", n = {"albumDir", SlcFlexDirection.FLEX_ROW, "createdCount", "id", "albumDir", SlcFlexDirection.FLEX_ROW, "createdCount", "id", "albumDir", SlcFlexDirection.FLEX_ROW, "createdCount", "id", "albumDir", SlcFlexDirection.FLEX_ROW, "createdCount", "id", "albumDir", "createdCount", "id"}, s = {"L$0", "L$2", "I$0", "J$0", "L$0", "L$2", "I$0", "J$0", "L$0", "L$2", "I$0", "J$0", "L$0", "L$2", "I$0", "J$0", "L$0", "I$0", "J$0"})
final class MediaAdditionReconciler$reconcileAdded$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaAdditionReconciler this$0;

    public MediaAdditionReconciler$reconcileAdded$1(MediaAdditionReconciler r100, Continuation<? super MediaAdditionReconciler$reconcileAdded$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MediaAdditionReconciler.a(this.this$0, null, this);
    }
}
