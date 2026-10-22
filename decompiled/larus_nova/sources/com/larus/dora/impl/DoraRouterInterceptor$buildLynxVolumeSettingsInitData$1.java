package com.larus.dora.impl;

import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraRouterInterceptor", f = "DoraRouterInterceptor.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL}, m = "buildLynxVolumeSettingsInitData", n = {}, s = {})
public final class DoraRouterInterceptor$buildLynxVolumeSettingsInitData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraRouterInterceptor this$0;

    public DoraRouterInterceptor$buildLynxVolumeSettingsInitData$1(DoraRouterInterceptor r100, Continuation<? super DoraRouterInterceptor$buildLynxVolumeSettingsInitData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DoraRouterInterceptor r101 = this.this$0;
        List<String> r102 = DoraRouterInterceptor.f331907c;
        return r101.d(this);
    }
}
