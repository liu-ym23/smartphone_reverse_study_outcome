package com.larus.im.internal.jni.media;

import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAudioPlayerProtocol;", "", "getPlayAmplitude", "", "startPlayer", "", "stopPlayer", "pausePlayer", "resumePlayer", "mutePlayer", "enable", "", "duck", ITTVideoEngineEventSource.KEY_VOLUME, "playFrame", "frame", "Lcom/larus/im/internal/jni/media/OmniAudioFrame;", "clearPlayerBuffer", "addListener", "delegate", "Lcom/larus/im/internal/jni/media/OmniAudioPlayerDelegate;", "removeListener", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniAudioPlayerProtocol {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void addListener(OmniAudioPlayerProtocol r100, OmniAudioPlayerDelegate r101) {
            Intrinsics.checkNotNullParameter(r101, "delegate");
        }

        public static void removeListener(OmniAudioPlayerProtocol r100, OmniAudioPlayerDelegate r101) {
            Intrinsics.checkNotNullParameter(r101, "delegate");
        }
    }

    void addListener(OmniAudioPlayerDelegate r100);

    void clearPlayerBuffer();

    void duck(float r100);

    float getPlayAmplitude();

    void mutePlayer(boolean r100);

    void pausePlayer();

    void playFrame(OmniAudioFrame r100);

    void removeListener(OmniAudioPlayerDelegate r100);

    void resumePlayer();

    void startPlayer();

    void stopPlayer();
}
