package com.larus.avlink.gallery.business;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.business.MediaLifecycleStateManager", f = "MediaLifecycleStateManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {107, 132, 136}, m = "transitionTo", n = {"uniqId", "newState", "updateMetadata", "autoCleanup", "uniqId", "newState", "oldState", "updatedMetadata", "autoCleanup", "uniqId", "newState", "oldState", "updatedMetadata", "autoCleanup"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"})
public final class MediaLifecycleStateManager$transitionTo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaLifecycleStateManager this$0;

    public MediaLifecycleStateManager$transitionTo$1(MediaLifecycleStateManager r100, Continuation<? super MediaLifecycleStateManager$transitionTo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, null, false, this);
    }
}
