package androidx.camera.video.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.QuirkSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    public static List<Quirk> loadQuirks(QuirkSettings r3) {
        ArrayList r0 = new ArrayList();
        if (r3.shouldEnableQuirk(MediaFormatMustNotUseFrameRateToFindEncoderQuirk.class, MediaFormatMustNotUseFrameRateToFindEncoderQuirk.load()) == false) goto L6;
        r0.add(new MediaFormatMustNotUseFrameRateToFindEncoderQuirk());
    L6:
        if (r3.shouldEnableQuirk(MediaCodecInfoReportIncorrectInfoQuirk.class, MediaCodecInfoReportIncorrectInfoQuirk.load()) == false) goto L9;
        r0.add(new MediaCodecInfoReportIncorrectInfoQuirk());
    L9:
        if (r3.shouldEnableQuirk(DeactivateEncoderSurfaceBeforeStopEncoderQuirk.class, DeactivateEncoderSurfaceBeforeStopEncoderQuirk.load()) == false) goto L12;
        r0.add(new DeactivateEncoderSurfaceBeforeStopEncoderQuirk());
    L12:
        if (r3.shouldEnableQuirk(CameraUseInconsistentTimebaseQuirk.class, CameraUseInconsistentTimebaseQuirk.load()) == false) goto L15;
        r0.add(new CameraUseInconsistentTimebaseQuirk());
    L15:
        if (r3.shouldEnableQuirk(ReportedVideoQualityNotSupportedQuirk.class, ReportedVideoQualityNotSupportedQuirk.load()) == false) goto L18;
        r0.add(new ReportedVideoQualityNotSupportedQuirk());
    L18:
        if (r3.shouldEnableQuirk(EncoderNotUsePersistentInputSurfaceQuirk.class, EncoderNotUsePersistentInputSurfaceQuirk.load()) == false) goto L21;
        r0.add(new EncoderNotUsePersistentInputSurfaceQuirk());
    L21:
        if (r3.shouldEnableQuirk(VideoEncoderCrashQuirk.class, VideoEncoderCrashQuirk.load()) == false) goto L24;
        r0.add(new VideoEncoderCrashQuirk());
    L24:
        if (r3.shouldEnableQuirk(ExcludeStretchedVideoQualityQuirk.class, ExcludeStretchedVideoQualityQuirk.load()) == false) goto L27;
        r0.add(new ExcludeStretchedVideoQualityQuirk());
    L27:
        if (r3.shouldEnableQuirk(MediaStoreVideoCannotWrite.class, MediaStoreVideoCannotWrite.load()) == false) goto L30;
        r0.add(new MediaStoreVideoCannotWrite());
    L30:
        if (r3.shouldEnableQuirk(AudioEncoderIgnoresInputTimestampQuirk.class, AudioEncoderIgnoresInputTimestampQuirk.load()) == false) goto L33;
        r0.add(new AudioEncoderIgnoresInputTimestampQuirk());
    L33:
        if (r3.shouldEnableQuirk(VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.class, VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.load()) == false) goto L36;
        r0.add(new VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk());
    L36:
        if (r3.shouldEnableQuirk(NegativeLatLongSavesIncorrectlyQuirk.class, NegativeLatLongSavesIncorrectlyQuirk.load()) == false) goto L39;
        r0.add(new NegativeLatLongSavesIncorrectlyQuirk());
    L39:
        if (r3.shouldEnableQuirk(AudioTimestampFramePositionIncorrectQuirk.class, AudioTimestampFramePositionIncorrectQuirk.load()) == false) goto L42;
        r0.add(new AudioTimestampFramePositionIncorrectQuirk());
    L42:
        if (r3.shouldEnableQuirk(ExtraSupportedResolutionQuirk.class, ExtraSupportedResolutionQuirk.load()) == false) goto L45;
        r0.add(new ExtraSupportedResolutionQuirk());
    L45:
        if (r3.shouldEnableQuirk(StretchedVideoResolutionQuirk.class, StretchedVideoResolutionQuirk.load()) == false) goto L48;
        r0.add(new StretchedVideoResolutionQuirk());
    L48:
        if (r3.shouldEnableQuirk(CodecStuckOnFlushQuirk.class, CodecStuckOnFlushQuirk.load()) == false) goto L51;
        r0.add(new CodecStuckOnFlushQuirk());
    L51:
        if (r3.shouldEnableQuirk(StopCodecAfterSurfaceRemovalCrashMediaServerQuirk.class, StopCodecAfterSurfaceRemovalCrashMediaServerQuirk.load()) == false) goto L54;
        r0.add(new StopCodecAfterSurfaceRemovalCrashMediaServerQuirk());
    L54:
        if (r3.shouldEnableQuirk(ExtraSupportedQualityQuirk.class, ExtraSupportedQualityQuirk.load()) == false) goto L57;
        r0.add(new ExtraSupportedQualityQuirk());
    L57:
        if (r3.shouldEnableQuirk(SignalEosOutputBufferNotComeQuirk.class, SignalEosOutputBufferNotComeQuirk.load()) == false) goto L60;
        r0.add(new SignalEosOutputBufferNotComeQuirk());
    L60:
        if (r3.shouldEnableQuirk(SizeCannotEncodeVideoQuirk.class, SizeCannotEncodeVideoQuirk.load()) == false) goto L62;
        r0.add(new SizeCannotEncodeVideoQuirk());
    L62:
        return r0;
    }
}
