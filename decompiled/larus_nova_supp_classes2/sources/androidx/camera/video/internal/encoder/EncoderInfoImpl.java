package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class EncoderInfoImpl implements EncoderInfo {
    protected final MediaCodecInfo.CodecCapabilities mCodecCapabilities;
    private final MediaCodecInfo mMediaCodecInfo;

    @Override // androidx.camera.video.internal.encoder.EncoderInfo
    public String getName() {
        return this.mMediaCodecInfo.getName();
    }

    public EncoderInfoImpl(MediaCodecInfo r4, String r5) throws InvalidConfigException {
        this.mMediaCodecInfo = r4;
        MediaCodecInfo.CodecCapabilities r6 = r4.getCapabilitiesForType(r5);     // Catch: RuntimeException -> L5
        Objects.requireNonNull(r6);     // Catch: RuntimeException -> L5
        MediaCodecInfo.CodecCapabilities r0 = r6;     // Catch: RuntimeException -> L5
        this.mCodecCapabilities = r6;     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        throw new InvalidConfigException("Unable to get CodecCapabilities for mime: " + r5, e);
    }
}
