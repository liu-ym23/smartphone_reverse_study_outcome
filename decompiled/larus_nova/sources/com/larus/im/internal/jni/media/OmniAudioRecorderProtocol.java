package com.larus.im.internal.jni.media;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAudioRecorderProtocol;", "", "getRecordAmplitude", "", "startRecorder", "", "stopRecorder", "setBluetoothForceToMedia", "enable", "", "addListener", "delegate", "Lcom/larus/im/internal/jni/media/OmniAudioRecorderDelegate;", "removeListener", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniAudioRecorderProtocol {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void addListener(OmniAudioRecorderProtocol r100, OmniAudioRecorderDelegate r101) {
            Intrinsics.checkNotNullParameter(r101, "delegate");
        }

        public static void removeListener(OmniAudioRecorderProtocol r100, OmniAudioRecorderDelegate r101) {
            Intrinsics.checkNotNullParameter(r101, "delegate");
        }
    }

    void addListener(OmniAudioRecorderDelegate r100);

    float getRecordAmplitude();

    void removeListener(OmniAudioRecorderDelegate r100);

    void setBluetoothForceToMedia(boolean r100);

    void startRecorder();

    void stopRecorder();
}
