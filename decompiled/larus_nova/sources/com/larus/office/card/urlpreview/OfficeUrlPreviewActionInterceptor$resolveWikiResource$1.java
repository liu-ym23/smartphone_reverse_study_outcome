package com.larus.office.card.urlpreview;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.card.urlpreview.OfficeUrlPreviewActionInterceptor", f = "OfficeUrlPreviewActionInterceptor.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER}, m = "resolveWikiResource", n = {"mappedType"}, s = {"I$0"})
final class OfficeUrlPreviewActionInterceptor$resolveWikiResource$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeUrlPreviewActionInterceptor this$0;

    public OfficeUrlPreviewActionInterceptor$resolveWikiResource$1(OfficeUrlPreviewActionInterceptor r100, Continuation<? super OfficeUrlPreviewActionInterceptor$resolveWikiResource$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return OfficeUrlPreviewActionInterceptor.d(this.this$0, null, null, this);
    }
}
