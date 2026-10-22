package com.larus.avlink.platform;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.platform.AndroidPlatformKt", f = "AndroidPlatform.kt", i = {0, 0}, l = {38, 39}, m = "getConversation", n = {"conversationId", "conversationRepo"}, s = {"L$0", "L$1"})
public final class AndroidPlatformKt$getConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public AndroidPlatformKt$getConversation$1(Continuation<? super AndroidPlatformKt$getConversation$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return AndroidPlatformKt.b(null, this);
    }
}
