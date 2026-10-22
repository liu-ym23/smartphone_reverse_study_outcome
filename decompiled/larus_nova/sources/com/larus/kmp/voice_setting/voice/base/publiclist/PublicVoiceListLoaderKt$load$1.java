package com.larus.kmp.voice_setting.voice.base.publiclist;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.base.publiclist.PublicVoiceListLoaderKt", f = "PublicVoiceListLoader.kt", i = {0, 0, 0, 0}, l = {56}, m = "load", n = {"$this$load", "requestKind", "previousVoices", "nextIndex"}, s = {"L$0", "L$1", "L$2", "I$0"})
public final class PublicVoiceListLoaderKt$load$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public PublicVoiceListLoaderKt$load$1(Continuation<? super PublicVoiceListLoaderKt$load$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return PublicVoiceListLoaderKt.a(null, null, null, this);
    }
}
