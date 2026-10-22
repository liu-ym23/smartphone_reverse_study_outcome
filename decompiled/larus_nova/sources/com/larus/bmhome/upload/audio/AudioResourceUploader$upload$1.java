package com.larus.bmhome.upload.audio;

import com.larus.bmhome.upload.audio.k;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.audio.AudioResourceUploader", f = "AudioResourceUploader.kt", i = {0, 1}, l = {109, 121}, m = "upload", n = {"onFail", "result"}, s = {"L$0", "L$0"})
final class AudioResourceUploader$upload$1<T extends k> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ g this$0;

    public AudioResourceUploader$upload$1(g r100, Continuation<? super AudioResourceUploader$upload$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return g.a(this.this$0, null, null, null, this);
    }
}
