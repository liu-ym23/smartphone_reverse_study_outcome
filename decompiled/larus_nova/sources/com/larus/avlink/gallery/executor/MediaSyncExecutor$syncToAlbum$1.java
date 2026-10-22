package com.larus.avlink.gallery.executor;

import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaSyncExecutor", f = "MediaSyncExecutor.kt", i = {0, 0, 3, 4, 4, 4, 5, 6, 6, 7}, l = {105, 116, 131, 146, 157, 198, 206, 220, VideoRef.VALUE_VIDEO_REF_AI_BARRAGE_URL}, m = "syncToAlbum", n = {"metadata", "uniqId", "uniqId", "uniqId", "displayPath", "systemGalleryId", "uniqId", "uniqId", "systemGalleryId", "uniqId"}, s = {"L$0", "L$1", "L$0", "L$0", "L$1", "J$0", "L$0", "L$0", "J$0", "L$0"})
public final class MediaSyncExecutor$syncToAlbum$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaSyncExecutor this$0;

    public MediaSyncExecutor$syncToAlbum$1(MediaSyncExecutor r100, Continuation<? super MediaSyncExecutor$syncToAlbum$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, this);
    }
}
