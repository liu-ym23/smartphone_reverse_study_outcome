package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.im.bean.bot.MixVoice;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class VoiceDoubleTabPreviewController$playback$4 extends FunctionReferenceImpl implements Function0<List<? extends MixVoice>> {
    public VoiceDoubleTabPreviewController$playback$4(Object r100) {
        super(0, r100, w6.class, "currentDisplayVoiceListForPreview", "currentDisplayVoiceListForPreview()Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends MixVoice> invoke2() {
        return ((w6) this.receiver).d();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends MixVoice> invoke() {
        return invoke2();
    }
}
