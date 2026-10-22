package com.larus.im.internal.jni.media;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAudioEngineProtocol;", "Lcom/larus/im/internal/jni/media/OmniAudioPlayerProtocol;", "Lcom/larus/im/internal/jni/media/OmniAudioRecorderProtocol;", "destroyEngine", "", "addListener", "delegate", "Lcom/larus/im/internal/jni/media/OmniAudioEngineDelegate;", "removeListener", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniAudioEngineProtocol extends OmniAudioPlayerProtocol, OmniAudioRecorderProtocol {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void addListener(OmniAudioEngineProtocol r100, OmniAudioPlayerDelegate r101) {
            Intrinsics.checkNotNullParameter(r101, "delegate");
            OmniAudioPlayerProtocol.DefaultImpls.addListener(r100, r101);
        }

        public static void removeListener(OmniAudioEngineProtocol r100, OmniAudioPlayerDelegate r101) {
            Intrinsics.checkNotNullParameter(r101, "delegate");
            OmniAudioPlayerProtocol.DefaultImpls.removeListener(r100, r101);
        }

        public static void addListener(OmniAudioEngineProtocol r100, OmniAudioRecorderDelegate r101) {
            Intrinsics.checkNotNullParameter(r101, "delegate");
            OmniAudioRecorderProtocol.DefaultImpls.addListener(r100, r101);
        }

        public static void removeListener(OmniAudioEngineProtocol r100, OmniAudioRecorderDelegate r101) {
            Intrinsics.checkNotNullParameter(r101, "delegate");
            OmniAudioRecorderProtocol.DefaultImpls.removeListener(r100, r101);
        }
    }

    void addListener(OmniAudioEngineDelegate r100);

    void destroyEngine();

    void removeListener(OmniAudioEngineDelegate r100);
}
