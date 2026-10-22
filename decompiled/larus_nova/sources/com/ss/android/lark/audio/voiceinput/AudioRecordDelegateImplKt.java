package com.ss.android.lark.audio.voiceinput;

import com.ss.android.lark.audio.recorder.AudioRecordSettings;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class AudioRecordDelegateImplKt {
    public static final void a(com.ss.android.lark.audio.recorder.c r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (AudioRecordSettings.c().getRecordBufferSize() <= 0) goto L6;
        com.ss.android.lark.audio.recorder.b r101 = new com.ss.android.lark.audio.recorder.b(AudioRecordDelegateImplKt$updateBufferSizeIfNeed$1.INSTANCE, AudioRecordDelegateImplKt$updateBufferSizeIfNeed$2.INSTANCE);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f409110b = r101;
        return;
    }
}
