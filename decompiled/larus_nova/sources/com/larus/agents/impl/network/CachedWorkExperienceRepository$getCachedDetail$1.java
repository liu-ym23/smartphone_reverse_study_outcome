package com.larus.agents.impl.network;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository", f = "WorkExperienceApi.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME}, m = "getCachedDetail", n = {"accountId"}, s = {"L$0"})
public final class CachedWorkExperienceRepository$getCachedDetail$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CachedWorkExperienceRepository this$0;

    public CachedWorkExperienceRepository$getCachedDetail$1(CachedWorkExperienceRepository r100, Continuation<? super CachedWorkExperienceRepository$getCachedDetail$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k(null, this);
    }
}
