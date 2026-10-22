package com.larus.im.internal.jni.media;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAudioEngineDelegate;", "Lcom/larus/im/internal/jni/media/OmniAudioPlayerDelegate;", "Lcom/larus/im/internal/jni/media/OmniAudioRecorderDelegate;", "onAudioEngineStateChanged", "", "state", "Lcom/larus/im/internal/jni/media/OmniAudioEngineDeviceState;", "type", "Lcom/larus/im/internal/jni/media/OmniAudioEngineDeviceType;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "extraJson", "", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniAudioEngineDelegate extends OmniAudioPlayerDelegate, OmniAudioRecorderDelegate {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onAudioEngineStateChanged(OmniAudioEngineDelegate r100, OmniAudioEngineDeviceState r101, OmniAudioEngineDeviceType r102, Exception r103, String r104) {
            Intrinsics.checkNotNullParameter(r101, "state");
            Intrinsics.checkNotNullParameter(r102, "type");
        }

        public static void onAudioEngineDidEndPlay(OmniAudioEngineDelegate r100) {
            OmniAudioPlayerDelegate.DefaultImpls.onAudioEngineDidEndPlay(r100);
        }

        public static void onAudioEnginePause(OmniAudioEngineDelegate r100) {
            OmniAudioPlayerDelegate.DefaultImpls.onAudioEnginePause(r100);
        }

        public static void onAudioEngineResume(OmniAudioEngineDelegate r100) {
            OmniAudioPlayerDelegate.DefaultImpls.onAudioEngineResume(r100);
        }

        public static void onAudioEnginePlayed(OmniAudioEngineDelegate r100, OmniAudioFrame r101) {
            Intrinsics.checkNotNullParameter(r101, "frame");
            OmniAudioPlayerDelegate.DefaultImpls.onAudioEnginePlayed(r100, r101);
        }

        public static void onAudioEngineRecord(OmniAudioEngineDelegate r100, OmniAudioFrame r101) {
            Intrinsics.checkNotNullParameter(r101, "frame");
            OmniAudioRecorderDelegate.DefaultImpls.onAudioEngineRecord(r100, r101);
        }

        public static /* synthetic */ void onAudioEngineStateChanged$default(OmniAudioEngineDelegate r100, OmniAudioEngineDeviceState r101, OmniAudioEngineDeviceType r102, Exception r103, String r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L6;
            r104 = null;
        L6:
            r100.onAudioEngineStateChanged(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAudioEngineStateChanged");
        }
    }

    void onAudioEngineStateChanged(OmniAudioEngineDeviceState r100, OmniAudioEngineDeviceType r101, Exception r102, String r103);
}
