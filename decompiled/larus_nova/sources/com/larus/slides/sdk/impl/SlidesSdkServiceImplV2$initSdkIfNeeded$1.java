package com.larus.slides.sdk.impl;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.slides.sdk.impl.SlidesSdkServiceImplV2", f = "SlidesSdkServiceImplV2.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER}, m = "initSdkIfNeeded", n = {}, s = {})
public final class SlidesSdkServiceImplV2$initSdkIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SlidesSdkServiceImplV2 this$0;

    public SlidesSdkServiceImplV2$initSdkIfNeeded$1(SlidesSdkServiceImplV2 r100, Continuation<? super SlidesSdkServiceImplV2$initSdkIfNeeded$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
