package com.larus.bmhome.music.protocol;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.protocol.MusicPullingApi", f = "MusicPullingApi.kt", i = {0, 0, 0}, l = {34}, m = "pullMusicStateTillCanPlay", n = {"bindMessage", DBDefinition.TASK_ID, DBDefinition.RETRY_COUNT}, s = {"L$0", "L$1", "I$0"})
public final class MusicPullingApi$pullMusicStateTillCanPlay$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicPullingApi this$0;

    public MusicPullingApi$pullMusicStateTillCanPlay$1(MusicPullingApi r100, Continuation<? super MusicPullingApi$pullMusicStateTillCanPlay$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, 0, this);
    }
}
