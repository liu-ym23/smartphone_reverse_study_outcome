package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.group.datasource.im.DispatchDeviceListRepository", f = "DispatchDeviceListRepository.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 168}, m = "refresh", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class DispatchDeviceListRepository$refresh$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DispatchDeviceListRepository this$0;

    public DispatchDeviceListRepository$refresh$1(DispatchDeviceListRepository r100, Continuation<? super DispatchDeviceListRepository$refresh$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DispatchDeviceListRepository r101 = this.this$0;
        int r102 = DispatchDeviceListRepository.f345220k;
        return r101.f(this);
    }
}
