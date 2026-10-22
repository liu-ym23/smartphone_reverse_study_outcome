package com.larus.media;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AudioPlayer$setTraceEnabled$1 extends FunctionReferenceImpl implements Function0<String> {
    public AudioPlayer$setTraceEnabled$1(Object r100) {
        super(0, r100, AudioPlayer.class, "audioTrackUnderrunLog", "audioTrackUnderrunLog()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return AudioPlayer.d(((AudioPlayer) this.receiver).f358892b);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
