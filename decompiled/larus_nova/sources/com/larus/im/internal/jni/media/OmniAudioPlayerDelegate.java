package com.larus.im.internal.jni.media;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAudioPlayerDelegate;", "", "onAudioEnginePlayed", "", "frame", "Lcom/larus/im/internal/jni/media/OmniAudioFrame;", "onAudioEnginePause", "onAudioEngineResume", "onAudioEngineDidEndPlay", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniAudioPlayerDelegate {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onAudioEngineDidEndPlay(OmniAudioPlayerDelegate r100) {
        }

        public static void onAudioEnginePause(OmniAudioPlayerDelegate r100) {
        }

        public static void onAudioEnginePlayed(OmniAudioPlayerDelegate r100, OmniAudioFrame r101) {
            Intrinsics.checkNotNullParameter(r101, "frame");
        }

        public static void onAudioEngineResume(OmniAudioPlayerDelegate r100) {
        }
    }

    void onAudioEngineDidEndPlay();

    void onAudioEnginePause();

    void onAudioEnginePlayed(OmniAudioFrame r100);

    void onAudioEngineResume();
}
