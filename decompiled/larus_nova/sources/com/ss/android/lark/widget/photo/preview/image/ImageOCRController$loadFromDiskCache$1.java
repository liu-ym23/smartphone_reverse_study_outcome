package com.ss.android.lark.widget.photo.preview.image;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.widget.photo.preview.image.ImageOCRController", f = "ImageOCRController.kt", i = {0, 0, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PROTOCOL_DOWNGRADE, 460}, m = "loadFromDiskCache", n = {"key", "$this$withLock_u24default$iv", "key", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class ImageOCRController$loadFromDiskCache$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageOCRController this$0;

    public ImageOCRController$loadFromDiskCache$1(ImageOCRController r100, Continuation<? super ImageOCRController$loadFromDiskCache$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ImageOCRController.d(this.this$0, null, this);
    }
}
