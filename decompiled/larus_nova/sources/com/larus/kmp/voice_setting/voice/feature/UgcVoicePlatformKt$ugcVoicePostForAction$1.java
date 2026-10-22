package com.larus.kmp.voice_setting.voice.feature;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.feature.UgcVoicePlatformKt", f = "UgcVoicePlatform.kt", i = {}, l = {46}, m = "ugcVoicePostForAction", n = {}, s = {})
public final class UgcVoicePlatformKt$ugcVoicePostForAction$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public UgcVoicePlatformKt$ugcVoicePostForAction$1(Continuation<? super UgcVoicePlatformKt$ugcVoicePostForAction$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return UgcVoicePlatformKt.c(null, null, this);
    }
}
