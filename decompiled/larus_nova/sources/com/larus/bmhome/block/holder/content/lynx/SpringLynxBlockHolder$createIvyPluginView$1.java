package com.larus.bmhome.block.holder.content.lynx;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.block.holder.content.lynx.SpringLynxBlockHolder", f = "SpringLynxBlockHolder.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT}, m = "createIvyPluginView", n = {"ivyPluginView"}, s = {"L$0"})
final class SpringLynxBlockHolder$createIvyPluginView$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpringLynxBlockHolder this$0;

    public SpringLynxBlockHolder$createIvyPluginView$1(SpringLynxBlockHolder r100, Continuation<? super SpringLynxBlockHolder$createIvyPluginView$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return SpringLynxBlockHolder.j(this.this$0, null, null, this);
    }
}
