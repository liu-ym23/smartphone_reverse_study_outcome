package com.larus.home.impl.route;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.route.EditInstructionRouterInterceptor", f = "EditInstructionRouterInterceptor.kt", i = {0, 0, 1, 1}, l = {353, MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL}, m = "getItemDataOfMainActionBar", n = {"type", "mainActionBarList", "type", "targetItem"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class EditInstructionRouterInterceptor$getItemDataOfMainActionBar$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EditInstructionRouterInterceptor this$0;

    public EditInstructionRouterInterceptor$getItemDataOfMainActionBar$1(EditInstructionRouterInterceptor r100, Continuation<? super EditInstructionRouterInterceptor$getItemDataOfMainActionBar$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return EditInstructionRouterInterceptor.c(this.this$0, null, this);
    }
}
