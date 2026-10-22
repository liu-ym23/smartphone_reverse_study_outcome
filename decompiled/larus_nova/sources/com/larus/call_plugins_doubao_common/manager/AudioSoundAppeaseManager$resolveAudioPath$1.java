package com.larus.call_plugins_doubao_common.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.call_plugins_doubao_common.manager.AudioSoundAppeaseManager", f = "AudioSoundAppeaseManager.kt", i = {0}, l = {329}, m = "resolveAudioPath", n = {"localAudioPath"}, s = {"L$0"})
final class AudioSoundAppeaseManager$resolveAudioPath$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AudioSoundAppeaseManager this$0;

    public AudioSoundAppeaseManager$resolveAudioPath$1(AudioSoundAppeaseManager r100, Continuation<? super AudioSoundAppeaseManager$resolveAudioPath$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return AudioSoundAppeaseManager.a(this.this$0, null, this);
    }
}
