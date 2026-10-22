package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.camera.video.internal.utils.CodecUtil;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AudioEncoderInfoImpl extends EncoderInfoImpl implements AudioEncoderInfo {
    private final MediaCodecInfo.AudioCapabilities mAudioCapabilities;

    @Override // androidx.camera.video.internal.encoder.AudioEncoderInfo
    public Range<Integer> getBitrateRange() {
        return this.mAudioCapabilities.getBitrateRange();
    }

    public static AudioEncoderInfoImpl from(AudioEncoderConfig r2) throws InvalidConfigException {
        return new AudioEncoderInfoImpl(CodecUtil.findCodecAndGetCodecInfo(r2), r2.getMimeType());
    }

    public AudioEncoderInfoImpl(MediaCodecInfo r1, String r2) throws InvalidConfigException {
        super(r1, r2);
        MediaCodecInfo.AudioCapabilities r3 = this.mCodecCapabilities.getAudioCapabilities();
        Objects.requireNonNull(r3);
        this.mAudioCapabilities = r3;
    }
}
