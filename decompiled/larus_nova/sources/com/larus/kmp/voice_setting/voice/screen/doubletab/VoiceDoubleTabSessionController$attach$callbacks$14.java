package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class VoiceDoubleTabSessionController$attach$callbacks$14 extends FunctionReferenceImpl implements Function1<SpeakerVoice, Boolean> {
    public VoiceDoubleTabSessionController$attach$callbacks$14(Object r100) {
        super(1, r100, m4.class, "canAddMixVoice", "canAddMixVoice(Lcom/larus/im/bean/bot/SpeakerVoice;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(SpeakerVoice r100) {
        return Boolean.valueOf(((m4) this.receiver).b(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(SpeakerVoice r100) {
        return invoke2(r100);
    }
}
