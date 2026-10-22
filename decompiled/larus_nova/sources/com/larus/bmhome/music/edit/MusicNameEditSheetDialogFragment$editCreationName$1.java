package com.larus.bmhome.music.edit;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.edit.MusicNameEditSheetDialogFragment", f = "MusicNameEditSheetDialogFragment.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME}, m = "editCreationName", n = {"name", "editNameCallback"}, s = {"L$0", "L$1"})
final class MusicNameEditSheetDialogFragment$editCreationName$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicNameEditSheetDialogFragment this$0;

    public MusicNameEditSheetDialogFragment$editCreationName$1(MusicNameEditSheetDialogFragment r100, Continuation<? super MusicNameEditSheetDialogFragment$editCreationName$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MusicNameEditSheetDialogFragment.U90(this.this$0, null, null, this);
    }
}
