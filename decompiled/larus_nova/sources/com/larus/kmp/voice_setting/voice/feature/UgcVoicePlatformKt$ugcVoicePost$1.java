package com.larus.kmp.voice_setting.voice.feature;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.feature.UgcVoicePlatformKt", f = "UgcVoicePlatform.kt", i = {0, 0}, l = {71}, m = "ugcVoicePost", n = {"path", "serializer"}, s = {"L$0", "L$1"})
public final class UgcVoicePlatformKt$ugcVoicePost$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public UgcVoicePlatformKt$ugcVoicePost$1(Continuation<? super UgcVoicePlatformKt$ugcVoicePost$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return UgcVoicePlatformKt.b(null, null, null, this);
    }
}
