package com.larus.uaigc.chat.block.create.horizontal;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.horizontal.LocalCreationHorizontalGroup", f = "LocalCreationHorizontalGroup.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA}, m = "onClickItem", n = {}, s = {})
final class LocalCreationHorizontalGroup$onClickItem$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalCreationHorizontalGroup this$0;

    public LocalCreationHorizontalGroup$onClickItem$1(LocalCreationHorizontalGroup r100, Continuation<? super LocalCreationHorizontalGroup$onClickItem$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return LocalCreationHorizontalGroup.o(this.this$0, null, null, null, this);
    }
}
