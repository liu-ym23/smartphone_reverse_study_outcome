package com.larus.larkfeed.impl.gallery;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.larkfeed.impl.gallery.LarkOfficeMaterialGalleryDataSource", f = "LarkOfficeMaterialGalleryHelper.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME}, m = "refreshDisplayItems", n = {"destination$iv$iv"}, s = {"L$0"})
public final class LarkOfficeMaterialGalleryDataSource$refreshDisplayItems$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LarkOfficeMaterialGalleryDataSource this$0;

    public LarkOfficeMaterialGalleryDataSource$refreshDisplayItems$1(LarkOfficeMaterialGalleryDataSource r100, Continuation<? super LarkOfficeMaterialGalleryDataSource$refreshDisplayItems$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
