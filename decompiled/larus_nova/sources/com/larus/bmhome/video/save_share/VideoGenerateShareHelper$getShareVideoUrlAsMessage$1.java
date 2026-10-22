package com.larus.bmhome.video.save_share;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.save_share.VideoGenerateShareHelper", f = "VideoGenerateShareHelper.kt", i = {0, 0, 0, 0}, l = {477}, m = "getShareVideoUrlAsMessage", n = {"shareButton", "shareScene", "videoId", "loadingDialog"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class VideoGenerateShareHelper$getShareVideoUrlAsMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoGenerateShareHelper this$0;

    public VideoGenerateShareHelper$getShareVideoUrlAsMessage$1(VideoGenerateShareHelper r100, Continuation<? super VideoGenerateShareHelper$getShareVideoUrlAsMessage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        VideoGenerateShareHelper r101 = this.this$0;
        VideoGenerateShareHelper r102 = VideoGenerateShareHelper.f315329a;
        return r101.g(null, null, null, null, false, null, this);
    }
}
