package com.larus.avlink.gallery.storage;

import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.storage.GalleryStoragePolicyManager", f = "GalleryStoragePolicyManager.kt", i = {0, 0, 0}, l = {188}, m = "cleanupSourceFilesLocked", n = {"config", TriggerTiming.NOW, "retentionMillis"}, s = {"L$0", "J$0", "J$1"})
final class GalleryStoragePolicyManager$cleanupSourceFilesLocked$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GalleryStoragePolicyManager this$0;

    public GalleryStoragePolicyManager$cleanupSourceFilesLocked$1(GalleryStoragePolicyManager r100, Continuation<? super GalleryStoragePolicyManager$cleanupSourceFilesLocked$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return GalleryStoragePolicyManager.b(this.this$0, this);
    }
}
