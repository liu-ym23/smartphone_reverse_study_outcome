package com.larus.common_ui.widget.input.audiowave;

import com.larus.common_ui.widget.input.audiowave.amplitude.AudioAmplitudeProcessor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AudioWaveView$updateBars$1 extends AdaptedFunctionReference implements Function0<Float> {
    public AudioWaveView$updateBars$1(Object r100) {
        super(0, r100, AudioAmplitudeProcessor.class, "getMaxAmplitude", "getMaxAmplitude(Z)F", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Float invoke() {
        return Float.valueOf(AudioAmplitudeProcessor.a((AudioAmplitudeProcessor) this.receiver));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Float invoke() {
        return invoke();
    }
}
