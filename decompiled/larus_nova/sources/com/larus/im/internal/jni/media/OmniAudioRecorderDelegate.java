package com.larus.im.internal.jni.media;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAudioRecorderDelegate;", "", "onAudioEngineRecord", "", "frame", "Lcom/larus/im/internal/jni/media/OmniAudioFrame;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniAudioRecorderDelegate {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onAudioEngineRecord(OmniAudioRecorderDelegate r100, OmniAudioFrame r101) {
            Intrinsics.checkNotNullParameter(r101, "frame");
        }
    }

    void onAudioEngineRecord(OmniAudioFrame r100);
}
