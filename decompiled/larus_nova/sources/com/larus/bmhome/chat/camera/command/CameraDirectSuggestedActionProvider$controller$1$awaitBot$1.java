package com.larus.bmhome.chat.camera.command;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.camera.command.CameraDirectSuggestedActionProvider$controller$1", f = "CameraDirectSuggestedActionProvider.kt", i = {}, l = {25}, m = "awaitBot", n = {}, s = {})
public final class CameraDirectSuggestedActionProvider$controller$1$awaitBot$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraDirectSuggestedActionProvider$controller$1 this$0;

    public CameraDirectSuggestedActionProvider$controller$1$awaitBot$1(CameraDirectSuggestedActionProvider$controller$1 r100, Continuation<? super CameraDirectSuggestedActionProvider$controller$1$awaitBot$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
