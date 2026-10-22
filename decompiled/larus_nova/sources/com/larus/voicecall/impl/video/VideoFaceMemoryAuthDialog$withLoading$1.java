package com.larus.voicecall.impl.video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.video.VideoFaceMemoryAuthDialog", f = "VideoFaceMemoryAuthDialog.kt", i = {}, l = {108}, m = "withLoading", n = {}, s = {})
public final class VideoFaceMemoryAuthDialog$withLoading$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoFaceMemoryAuthDialog this$0;

    public VideoFaceMemoryAuthDialog$withLoading$1(VideoFaceMemoryAuthDialog r100, Continuation<? super VideoFaceMemoryAuthDialog$withLoading$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        VideoFaceMemoryAuthDialog r101 = this.this$0;
        int r102 = VideoFaceMemoryAuthDialog.f379566g;
        return r101.T90(null, null, this);
    }
}
