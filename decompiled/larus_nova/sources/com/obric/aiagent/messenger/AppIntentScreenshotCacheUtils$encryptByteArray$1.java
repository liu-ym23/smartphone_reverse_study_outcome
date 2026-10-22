package com.obric.aiagent.messenger;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.AppIntentScreenshotCacheUtils", f = "AppIntentScreenshotCacheUtils.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE}, m = "encryptByteArray", n = {}, s = {})
public final class AppIntentScreenshotCacheUtils$encryptByteArray$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppIntentScreenshotCacheUtils this$0;

    public AppIntentScreenshotCacheUtils$encryptByteArray$1(AppIntentScreenshotCacheUtils r100, Continuation<? super AppIntentScreenshotCacheUtils$encryptByteArray$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AppIntentScreenshotCacheUtils r101 = this.this$0;
        AppIntentScreenshotCacheUtils r102 = AppIntentScreenshotCacheUtils.f384749a;
        return r101.b(null, null, this);
    }
}
