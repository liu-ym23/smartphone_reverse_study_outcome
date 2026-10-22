package androidx.camera.video.internal;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.compat.Api28Impl;
import androidx.camera.video.internal.compat.Api31Impl;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class DebugUtils {
    private static final String AUDIO_CAPS_PREFIX = "[AudioCaps] ";
    private static final String CODEC_CAPS_PREFIX = "[CodecCaps] ";
    private static final String ENCODER_CAPS_PREFIX = "[EncoderCaps] ";
    private static final String TAG = "DebugUtils";
    private static final String VIDEO_CAPS_PREFIX = "[VideoCaps] ";

    private DebugUtils() {
    }

    private static String formatInterval(long r11) {
        TimeUnit r0 = TimeUnit.MILLISECONDS;
        long r1 = r0.toHours(r11);
        TimeUnit r3 = TimeUnit.HOURS;
        long r4 = r0.toMinutes(r11 - r3.toMillis(r1));
        long r6 = r11 - r3.toMillis(r1);
        TimeUnit r8 = TimeUnit.MINUTES;
        long r7 = r0.toSeconds(r6 - r8.toMillis(r4));
        long r12 = ((r11 - r3.toMillis(r1)) - r8.toMillis(r4)) - TimeUnit.SECONDS.toMillis(r7);
        return String.format(Locale.US, "%02d:%02d:%02d.%03d", new Object[]{Long.valueOf(r1), Long.valueOf(r4), Long.valueOf(r7), Long.valueOf(r12)});
    }

    public static String readableBufferInfo(MediaCodec.BufferInfo r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append("Dump BufferInfo: " + r5.toString() + "\n");
        r0.append("\toffset: " + r5.offset + "\n");
        r0.append("\tsize: " + r5.size + "\n");
        StringBuilder r1 = new StringBuilder("\tflag: ");
        r1.append(r5.flags);
        r0.append(r1.toString());
        ArrayList r2 = new ArrayList();
        if ((r5.flags & 4) == 0) goto L6;
        r2.add("EOS");
    L6:
        if ((r5.flags & 2) == 0) goto L9;
        r2.add("CODEC_CONFIG");
    L9:
        if ((r5.flags & 1) == 0) goto L12;
        r2.add("KEY_FRAME");
    L12:
        if ((r5.flags & 8) == 0) goto L15;
        r2.add("PARTIAL_FRAME");
    L15:
        if (r2.isEmpty() == true) goto L17;
        r0.append(" (");
        r0.append(TextUtils.join(" | ", r2));
        r0.append(")");
    L17:
        r0.append("\n");
        r0.append("\tpresentationTime: " + r5.presentationTimeUs + " (" + readableUs(r5.presentationTimeUs) + ")\n");
        return r0.toString();
    }

    public static String readableMs(long r0) {
        return formatInterval(r0);
    }

    public static String readableUs(long r1) {
        return readableMs(TimeUnit.MICROSECONDS.toMillis(r1));
    }

    private static void stringToLog(String r2) {
        if (Logger.isInfoEnabled(TAG) == false) goto L8;
        Scanner r1 = new Scanner(r2);
    L6:
        if (r1.hasNextLine() == false) goto L10;
        Logger.i(TAG, r1.nextLine());
        goto L6
    L10:
        return;
    }

    private static String toString(MediaCodecInfo.CodecProfileLevel r3) {
        if (r3 != null) goto L6;
        return "null";
    L6:
        return String.format("{level=%d, profile=%d}", new Object[]{Integer.valueOf(r3.level), Integer.valueOf(r3.profile)});
    }

    public static String dumpMediaCodecListForFormat(MediaCodecList r10, MediaFormat r11) {
        StringBuilder r1 = new StringBuilder();
        logToString(r1, "[Start] Dump MediaCodecList for mediaFormat " + r11);
        String r2 = r11.getString("mime");
        MediaCodecInfo[] r12 = r10.getCodecInfos();
        int r3 = r12.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L19;
        MediaCodecInfo r6 = r12[r5];
        if (r6.isEncoder() == false) goto L18;
        boolean r7 = true;
        if (r2 == null) goto L10;
        boolean r8 = true;
    L21:
        Preconditions.checkArgument(r8);     // Catch: IllegalArgumentException -> L17
        MediaCodecInfo.CodecCapabilities r9 = r6.getCapabilitiesForType(r2);     // Catch: IllegalArgumentException -> L17
        if (r9 != null) goto L15;
        r7 = false;
    L15:
        Preconditions.checkArgument(r7);     // Catch: IllegalArgumentException -> L17
        logToString(r1, "[Start] [" + r6.getName() + "]");     // Catch: IllegalArgumentException -> L17
        dumpCodecCapabilities(r1, r9, r11);     // Catch: IllegalArgumentException -> L17
        logToString(r1, "[End] [" + r6.getName() + "]");     // Catch: IllegalArgumentException -> L17
    L17:
        logToString(r1, "[" + r6.getName() + "] does not support mime " + r2);
        goto L18
    L10:
        r8 = false;
    L18:
        r5 = r5 + 1;
        goto L3
    L19:
        logToString(r1, "[End] Dump MediaCodecList");
        String r13 = r1.toString();
        stringToLog(r13);
        return r13;
    }

    private static void logToString(StringBuilder r0, String r1) {
        r0.append(r1);
        r0.append("\n");
    }

    private static void dumpAudioCapabilities(StringBuilder r3, MediaCodecInfo.AudioCapabilities r4, MediaFormat r5) {
        logToString(r3, "[AudioCaps] getBitrateRange = " + r4.getBitrateRange());
        logToString(r3, "[AudioCaps] getMaxInputChannelCount = " + r4.getMaxInputChannelCount());
        if (Build.VERSION.SDK_INT < 31) goto L5;
        logToString(r3, "[AudioCaps] getMinInputChannelCount = " + Api31Impl.getMinInputChannelCount(r4));
        logToString(r3, "[AudioCaps] getInputChannelCountRanges = " + Arrays.toString(Api31Impl.getInputChannelCountRanges(r4)));
    L5:
        logToString(r3, "[AudioCaps] getSupportedSampleRateRanges = " + Arrays.toString(r4.getSupportedSampleRateRanges()));
        logToString(r3, "[AudioCaps] getSupportedSampleRates = " + Arrays.toString(r4.getSupportedSampleRates()));
        int r6 = r5.getInteger("sample-rate");     // Catch: Throwable -> L8
        logToString(r3, "[AudioCaps] isSampleRateSupported for " + r6 + " = " + r4.isSampleRateSupported(r6));     // Catch: Throwable -> L8
        return;
    L8:
        logToString(r3, "[AudioCaps] mediaFormat does not contain sample rate");
    }

    private static void dumpCodecCapabilities(StringBuilder r6, MediaCodecInfo.CodecCapabilities r7, MediaFormat r8) {
        logToString(r6, "[CodecCaps] isFormatSupported = " + r7.isFormatSupported(r8));     // Catch: ClassCastException -> L5
    L6:
        logToString(r6, "[CodecCaps] getDefaultFormat = " + r7.getDefaultFormat());
        if (r7.profileLevels == null) goto L13;
        StringBuilder r0 = new StringBuilder("[");
        ArrayList r1 = new ArrayList();
        MediaCodecInfo.CodecProfileLevel[] r2 = r7.profileLevels;
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L11;
        r1.add(toString(r2[r4]));
        r4 = r4 + 1;
        goto L9
    L11:
        r0.append(TextUtils.join(", ", r1));
        r0.append("]");
        logToString(r6, "[CodecCaps] profileLevels = " + r0);
    L13:
        if (r7.colorFormats == null) goto L15;
        logToString(r6, "[CodecCaps] colorFormats = " + Arrays.toString(r7.colorFormats));
    L15:
        MediaCodecInfo.VideoCapabilities r5 = r7.getVideoCapabilities();
        if (r5 == null) goto L18;
        dumpVideoCapabilities(r6, r5, r8);
    L18:
        MediaCodecInfo.AudioCapabilities r9 = r7.getAudioCapabilities();
        if (r9 == null) goto L21;
        dumpAudioCapabilities(r6, r9, r8);
    L21:
        MediaCodecInfo.EncoderCapabilities r10 = r7.getEncoderCapabilities();
        if (r10 == null) goto L28;
        dumpEncoderCapabilities(r6, r10, r8);
        return;
    L28:
        return;
    L5:
        logToString(r6, "[CodecCaps] isFormatSupported=false");
        goto L6
    }

    private static void dumpEncoderCapabilities(StringBuilder r3, MediaCodecInfo.EncoderCapabilities r4, MediaFormat r5) {
        logToString(r3, "[EncoderCaps] getComplexityRange = " + r4.getComplexityRange());
        if (Build.VERSION.SDK_INT < 28) goto L9;
        logToString(r3, "[EncoderCaps] getQualityRange = " + Api28Impl.getQualityRange(r4));
    L9:
        logToString(r3, "[EncoderCaps] isBitrateModeSupported = " + r4.isBitrateModeSupported(r5.getInteger("bitrate-mode")));     // Catch: Throwable -> L7
        return;
    L7:
        logToString(r3, "[EncoderCaps] mediaFormat does not contain bitrate mode");
    }

    private static void dumpVideoCapabilities(StringBuilder r10, MediaCodecInfo.VideoCapabilities r11, MediaFormat r12) {
        logToString(r10, "[VideoCaps] getBitrateRange = " + r11.getBitrateRange());
        logToString(r10, "[VideoCaps] getSupportedWidths = " + r11.getSupportedWidths() + ", getWidthAlignment = " + r11.getWidthAlignment());
        logToString(r10, "[VideoCaps] getSupportedHeights = " + r11.getSupportedHeights() + ", getHeightAlignment = " + r11.getHeightAlignment());
        int r2 = 0;
        boolean r3 = true;
        int r4 = r12.getInteger("width");     // Catch: Throwable -> L10
        int r5 = r12.getInteger("height");     // Catch: Throwable -> L10
        if (r4 <= 0) goto L7;
        if (r5 <= 0) goto L7;
        boolean r6 = true;
    L8:
        Preconditions.checkArgument(r6);     // Catch: Throwable -> L10
        boolean r7 = true;
    L12:
        if (r7 == true) goto L38;
    L20:
        logToString(r10, "[VideoCaps] getSupportedFrameRates = " + r11.getSupportedFrameRates());
        int r13 = r12.getInteger("frame-rate");     // Catch: Throwable -> L27
        if (r13 > 0) goto L25;
        r3 = false;
    L25:
        Preconditions.checkArgument(r3);     // Catch: Throwable -> L27
        r2 = r13;
    L28:
        if (r7 == false) goto L30;
        logToString(r10, "[VideoCaps] getSupportedFrameRatesFor " + r4 + "x" + r5 + " = " + r11.getSupportedFrameRatesFor(r4, r5));
    L30:
        if (r7 == false) goto L42;
        if (r2 <= 0) goto L43;
        logToString(r10, "[VideoCaps] areSizeAndRateSupported for " + r4 + "x" + r5 + ", " + r2 + " = " + r11.areSizeAndRateSupported(r4, r5, r2));
        return;
    L43:
        return;
    L42:
        return;
    L27:
        logToString(r10, "[VideoCaps] mediaFormat does not contain frame rate");
        goto L28
    L38:
        logToString(r10, "[VideoCaps] getSupportedHeightsFor " + r4 + " = " + r11.getSupportedHeightsFor(r4));     // Catch: IllegalArgumentException -> L15
    L40:
        logToString(r10, "[VideoCaps] getSupportedWidthsFor " + r5 + " = " + r11.getSupportedWidthsFor(r5));     // Catch: IllegalArgumentException -> L18
    L19:
        logToString(r10, "[VideoCaps] isSizeSupported for " + r4 + "x" + r5 + " = " + r11.isSizeSupported(r4, r5));
    L18:
        logToString(r10, "[VideoCaps] could not getSupportedWidthsFor " + r5);
    L15:
        logToString(r10, "[VideoCaps] could not getSupportedHeightsFor " + r4);
    L7:
        r6 = false;
    L10:
        logToString(r10, "[VideoCaps] mediaFormat does not contain valid width and height");
        r4 = 0;
        r5 = 0;
        r7 = false;
        goto L12
    }

    public static String dumpCodecCapabilities(String r3, MediaCodec r4, MediaFormat r5) {
        StringBuilder r0 = new StringBuilder();
        MediaCodecInfo.CodecCapabilities r1 = r4.getCodecInfo().getCapabilitiesForType(r3);     // Catch: IllegalArgumentException -> L9
        if (r1 == null) goto L6;
        boolean r2 = true;
    L7:
        Preconditions.checkArgument(r2);     // Catch: IllegalArgumentException -> L9
        dumpCodecCapabilities(r0, r1, r5);     // Catch: IllegalArgumentException -> L9
    L11:
        return r0.toString();
    L6:
        r2 = false;
    L9:
        logToString(r0, "[" + r4.getName() + "] does not support mime " + r3);
        goto L11
    }
}
