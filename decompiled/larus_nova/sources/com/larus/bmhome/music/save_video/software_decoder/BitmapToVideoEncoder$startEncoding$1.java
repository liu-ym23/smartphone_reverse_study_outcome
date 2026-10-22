package com.larus.bmhome.music.save_video.software_decoder;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.save_video.software_decoder.BitmapToVideoEncoder", f = "BitmapToVideoEncoder.kt", i = {}, l = {62}, m = "startEncoding", n = {}, s = {})
public final class BitmapToVideoEncoder$startEncoding$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BitmapToVideoEncoder this$0;

    public BitmapToVideoEncoder$startEncoding$1(BitmapToVideoEncoder r100, Continuation<? super BitmapToVideoEncoder$startEncoding$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, 0, null, null, null, null, null, this);
    }
}
