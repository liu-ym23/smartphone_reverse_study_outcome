package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.MediaSpec;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;
import androidx.core.util.Supplier;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class AudioConfigUtil {
    static final int AUDIO_CHANNEL_COUNT_DEFAULT = 1;
    static final int AUDIO_SAMPLE_RATE_DEFAULT = 44100;
    static final int AUDIO_SOURCE_DEFAULT = 5;
    static final int AUDIO_SOURCE_FORMAT_DEFAULT = 2;
    private static final String TAG = "AudioConfigUtil";

    public static /* synthetic */ int a(int r0, Integer r1, Integer r2) {
        return lambda$selectSampleRateOrNearestSupported$0(r0, r1, r2);
    }

    private AudioConfigUtil() {
    }

    public static int resolveAudioSource(AudioSpec r3) {
        int r4 = r3.getSource();
        if (r4 != (-1)) goto L5;
        Logger.d(TAG, "Using default AUDIO source: 5");
        return 5;
    L5:
        Logger.d(TAG, "Using provided AUDIO source: " + r4);
        return r4;
    }

    public static int resolveAudioSourceFormat(AudioSpec r3) {
        int r4 = r3.getSourceFormat();
        if (r4 != (-1)) goto L5;
        Logger.d(TAG, "Using default AUDIO source format: 2");
        return 2;
    L5:
        Logger.d(TAG, "Using provided AUDIO source format: " + r4);
        return r4;
    }

    public static AudioMimeInfo resolveAudioMimeInfo(MediaSpec r8, VideoValidatedEncoderProfilesProxy r9) {
        String r0 = MediaSpec.outputFormatToAudioMime(r8.getOutputFormat());
        int r1 = MediaSpec.outputFormatToAudioProfile(r8.getOutputFormat());
        if (r9 != null) goto L5;
    L17:
        EncoderProfilesProxy.AudioProfileProxy r10 = null;
    L18:
        AudioMimeInfo.Builder r11 = AudioMimeInfo.builder(r0).setProfile(r1);
        if (r10 == null) goto L22;
        r11.setCompatibleAudioProfile(r10);
    L22:
        return r11.build();
    L5:
        if (r9.getDefaultAudioProfile() == null) goto L17;
        r10 = r9.getDefaultAudioProfile();
        String r2 = r10.getMediaType();
        int r3 = r10.getProfile();
        if (Objects.equals(r2, EncoderProfilesProxy.AudioProfileProxy.MEDIA_TYPE_NONE) == false) goto L10;
        Logger.d(TAG, "EncoderProfiles contains undefined AUDIO mime type so cannot be used. May rely on fallback defaults to derive settings [chosen mime type: " + r0 + "(profile: " + r1 + ")]");
        goto L17
    L10:
        if (r8.getOutputFormat() != (-1)) goto L13;
        Logger.d(TAG, "MediaSpec contains OUTPUT_FORMAT_AUTO. Using EncoderProfiles to derive AUDIO settings [mime type: " + r2 + "(profile: " + r3 + ")]");
        r0 = r2;
        r1 = r3;
        goto L18
    L13:
        if (Objects.equals(r0, r2) == false) goto L16;
        if (r1 != r3) goto L16;
        Logger.d(TAG, "MediaSpec audio mime/profile matches EncoderProfiles. Using EncoderProfiles to derive AUDIO settings [mime type: " + r2 + "(profile: " + r1 + ")]");
        r0 = r2;
    L16:
        Logger.d(TAG, "MediaSpec audio mime or profile does not match EncoderProfiles, so EncoderProfiles settings cannot be used. May rely on fallback defaults to derive AUDIO settings [EncoderProfiles mime type: " + r2 + "(profile: " + r3 + "), chosen mime type: " + r0 + "(profile: " + r1 + ")]");
        goto L17
    }

    public static AudioSettings resolveAudioSettings(AudioMimeInfo r1, AudioSpec r2) {
        EncoderProfilesProxy.AudioProfileProxy r3 = r1.getCompatibleAudioProfile();
        if (r3 == null) goto L5;
        Supplier r0 = new AudioSettingsAudioProfileResolver(r2, r3);
    L7:
        return (AudioSettings) r0.get();
    L5:
        r0 = new AudioSettingsDefaultResolver(r2);
        goto L7
    }

    private static /* synthetic */ int lambda$selectSampleRateOrNearestSupported$0(int r2, Integer r3, Integer r4) {
        int r0 = Math.abs(r3.intValue() - r2) - Math.abs(r4.intValue() - r2);
        if (r0 != 0) goto L7;
        float r5 = Math.signum(r3.intValue() - r4.intValue());
    L6:
        return (int) r5;
    L7:
        r5 = Math.signum(r0);
        goto L6
    }

    public static AudioEncoderConfig resolveAudioEncoderConfig(AudioMimeInfo r14, Timebase r15, AudioSettings r16, AudioSpec r17) {
        EncoderProfilesProxy.AudioProfileProxy r6 = r14.getCompatibleAudioProfile();
        if (r6 == null) goto L5;
        Supplier r7 = new AudioEncoderConfigAudioProfileResolver(r14.getMimeType(), r14.getProfile(), r15, r17, r16, r6);
    L7:
        return (AudioEncoderConfig) r7.get();
    L5:
        r7 = new AudioEncoderConfigDefaultResolver(r14.getMimeType(), r14.getProfile(), r15, r17, r16);
        goto L7
    }

    public static int selectSampleRateOrNearestSupported(Range<Integer> r7, int r8, int r9, final int r10) {
        ArrayList r0 = null;
        int r1 = 0;
        int r2 = r10;
    L4:
        if (r7.contains(Integer.valueOf(r2)) == true) goto L6;
        Logger.d(TAG, "Sample rate " + r2 + "Hz is not in target range " + r7);
    L10:
        if (r0 != null) goto L13;
        Logger.d(TAG, "Trying common sample rates in proximity order to target " + r10 + "Hz");
        r0 = new ArrayList(AudioSettings.COMMON_SAMPLE_RATES);
        Collections.sort(r0, new a(r10));
    L13:
        if (r1 >= r0.size()) goto L15;
        r2 = ((Integer) ListProtector.get(r0, r1)).intValue();
        r1 = r1 + 1;
        goto L4
    L15:
        Logger.d(TAG, "No sample rate found in target range or supported by audio source. Falling back to default sample rate of 44100Hz");
        return AUDIO_SAMPLE_RATE_DEFAULT;
    L6:
        if (AudioSource.isSettingsSupported(r2, r8, r9) == true) goto L7;
        Logger.d(TAG, "Sample rate " + r2 + "Hz is not supported by audio source with channel count " + r8 + " and source format " + r9);
        goto L10
    L7:
        return r2;
    }

    public static int scaleAndClampBitrate(int r6, int r7, int r8, int r9, int r10, Range<Integer> r11) {
        int r0 = (int) ((((double) r6) * new Rational(r7, r8).doubleValue()) * new Rational(r9, r10).doubleValue());
        if (Logger.isDebugEnabled(TAG) == false) goto L5;
        String r12 = String.format("Base Bitrate(%dbps) * Channel Count Ratio(%d / %d) * Sample Rate Ratio(%d / %d) = %d", new Object[]{Integer.valueOf(r6), Integer.valueOf(r7), Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r0)});
    L7:
        if (AudioSpec.BITRATE_RANGE_AUTO.equals(r11) == true) goto L11;
        r0 = ((Integer) r11.clamp(Integer.valueOf(r0))).intValue();
        if (Logger.isDebugEnabled(TAG) == false) goto L11;
        r12 = r12 + String.format("\nClamped to range %s -> %dbps", new Object[]{r11, Integer.valueOf(r0)});
    L11:
        Logger.d(TAG, r12);
        return r0;
    L5:
        r12 = "";
        goto L7
    }
}
