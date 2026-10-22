package com.larus.livetutor.impl.typing.rhythm;

import com.larus.livetutor.impl.typing.enumeration.TypingStreamStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements ITypingRhythmController {
    public a() {
    }

    @Override // com.larus.livetutor.impl.typing.rhythm.ITypingRhythmController
    public final ITypingRhythmController.Beat a(ITypingRhythmController.Beat r100, TypingStreamStatus r101) {
        Intrinsics.checkNotNullParameter(r100, "lastBeat");
        Intrinsics.checkNotNullParameter(r101, "streamStatus");
        return new ITypingRhythmController.Beat(1, 20);
    }
}
