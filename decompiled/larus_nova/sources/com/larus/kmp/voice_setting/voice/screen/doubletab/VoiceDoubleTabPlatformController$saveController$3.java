package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class VoiceDoubleTabPlatformController$saveController$3 extends FunctionReferenceImpl implements Function0<Boolean> {
    public VoiceDoubleTabPlatformController$saveController$3(Object r100) {
        super(0, r100, VoiceDoubleTabSelectionController.class, "isMixStyleEnabled", "isMixStyleEnabled()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(((VoiceDoubleTabSelectionController) this.receiver).c());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
