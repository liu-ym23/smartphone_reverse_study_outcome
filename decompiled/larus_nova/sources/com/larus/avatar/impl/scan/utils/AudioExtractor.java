package com.larus.avatar.impl.scan.utils;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttvideoengine.model.SubInfo;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes23.dex */
public final class AudioExtractor {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/avatar/impl/scan/utils/AudioExtractor$ErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "FILE_NOT_FOUND", "NO_AUDIO_TRACK", "UNSUPPORTED_MIME", "MUXER_INIT_FAILED", "EXTRACTION_FAILED", "OUTPUT_VALIDATION_FAILED", "CANCELLED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ErrorCode extends Enum<ErrorCode> {
        public static final ErrorCode CANCELLED = null;
        public static final ErrorCode EXTRACTION_FAILED = null;
        public static final ErrorCode FILE_NOT_FOUND = null;
        public static final ErrorCode MUXER_INIT_FAILED = null;
        public static final ErrorCode NO_AUDIO_TRACK = null;
        public static final ErrorCode OUTPUT_VALIDATION_FAILED = null;
        public static final ErrorCode UNSUPPORTED_MIME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ErrorCode[] f291110a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f291111b = null;

        public static EnumEntries<ErrorCode> getEntries() {
            return f291111b;
        }

        static {
            ErrorCode r100 = new ErrorCode("FILE_NOT_FOUND", 0);
            FILE_NOT_FOUND = r100;
            ErrorCode r101 = new ErrorCode("NO_AUDIO_TRACK", 1);
            NO_AUDIO_TRACK = r101;
            ErrorCode r102 = new ErrorCode("UNSUPPORTED_MIME", 2);
            UNSUPPORTED_MIME = r102;
            ErrorCode r103 = new ErrorCode("MUXER_INIT_FAILED", 3);
            MUXER_INIT_FAILED = r103;
            ErrorCode r104 = new ErrorCode("EXTRACTION_FAILED", 4);
            EXTRACTION_FAILED = r104;
            ErrorCode r105 = new ErrorCode("OUTPUT_VALIDATION_FAILED", 5);
            OUTPUT_VALIDATION_FAILED = r105;
            ErrorCode r110 = new ErrorCode("CANCELLED", 6);
            CANCELLED = r110;
            ErrorCode[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f291110a = r111;
            f291111b = EnumEntriesKt.enumEntries(r111);
        }

        public static ErrorCode[] values() {
            return (ErrorCode[]) f291110a.clone();
        }

        public static ErrorCode valueOf(String r100) {
            return (ErrorCode) r27.a.a(ErrorCode.class, r100);
        }

        public ErrorCode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f291112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaFormat f291113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f291114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f291115d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f291116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f291117f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f291118g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f291112a == r101.f291112a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f291113b, r101.f291113b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f291114c, r101.f291114c) == true) goto L18;
            return false;
        L18:
            if (this.f291115d == r101.f291115d) goto L21;
            return false;
        L21:
            if (this.f291116e == r101.f291116e) goto L24;
            return false;
        L24:
            if (this.f291117f == r101.f291117f) goto L27;
            return false;
        L27:
            if (this.f291118g == r101.f291118g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((this.f291112a * 31) + this.f291113b.hashCode()) * 31) + this.f291114c.hashCode()) * 31) + this.f291115d) * 31) + this.f291116e) * 31;
            long r101 = this.f291117f;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f291118g;
        }

        public final String toString() {
            return "AudioTrackInfo(trackIndex=" + this.f291112a + ", format=" + this.f291113b + ", mime=" + this.f291114c + ", sampleRate=" + this.f291115d + ", channelCount=" + this.f291116e + ", durationUs=" + this.f291117f + ", bitRate=" + this.f291118g + ')';
        }

        public a(int r100, MediaFormat r101, String r102, int r103, int r104, long r105, int r106) {
            Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
            Intrinsics.checkNotNullParameter(r102, "mime");
            this.f291112a = r100;
            this.f291113b = r101;
            this.f291114c = r102;
            this.f291115d = r103;
            this.f291116e = r104;
            this.f291117f = r105;
            this.f291118g = r106;
        }
    }

    public static final class b {
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ErrorCode f291119a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f291120b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Throwable f291121c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L8;
                return false;
            L8:
                a r101 = (a) r100;
                if (this.f291119a == r101.f291119a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f291120b, r101.f291120b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f291121c, r101.f291121c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r100 = ((this.f291119a.hashCode() * 31) + this.f291120b.hashCode()) * 31;
                Throwable r101 = this.f291121c;
                if (r101 != null) goto L5;
                int r102 = 0;
            L7:
                return r100 + r102;
            L5:
                r102 = r101.hashCode();
                goto L7
            }

            public final String toString() {
                return "Failure(errorCode=" + this.f291119a + ", message=" + this.f291120b + ", cause=" + this.f291121c + ')';
            }

            public a(ErrorCode r100, String r101, Throwable r102) {
                Intrinsics.checkNotNullParameter(r100, "errorCode");
                Intrinsics.checkNotNullParameter(r101, "message");
                this.f291119a = r100;
                this.f291120b = r101;
                this.f291121c = r102;
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f291122a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f291123b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f291124c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final int f291125d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final int f291126e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final long f291127f;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f291122a, r101.f291122a) == true) goto L12;
                return false;
            L12:
                if (this.f291123b == r101.f291123b) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f291124c, r101.f291124c) == true) goto L18;
                return false;
            L18:
                if (this.f291125d == r101.f291125d) goto L21;
                return false;
            L21:
                if (this.f291126e == r101.f291126e) goto L24;
                return false;
            L24:
                if (this.f291127f == r101.f291127f) goto L26;
                return false;
            L26:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f291122a.hashCode() * 31;
                long r101 = this.f291123b;
                int r102 = (((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f291124c.hashCode()) * 31) + this.f291125d) * 31) + this.f291126e) * 31;
                long r103 = this.f291127f;
                return r102 + ((int) (r103 ^ (r103 >>> 32)));
            }

            public final String toString() {
                return "Success(outputPath=" + this.f291122a + ", durationMs=" + this.f291123b + ", mimeType=" + this.f291124c + ", sampleRate=" + this.f291125d + ", channelCount=" + this.f291126e + ", fileSizeBytes=" + this.f291127f + ')';
            }

            public b(String r100, long r101, String r102, int r103, int r104, long r105) {
                Intrinsics.checkNotNullParameter(r100, "outputPath");
                Intrinsics.checkNotNullParameter(r102, DBDefinition.MIME_TYPE);
                this.f291122a = r100;
                this.f291123b = r101;
                this.f291124c = r102;
                this.f291125d = r103;
                this.f291126e = r104;
                this.f291127f = r105;
            }
        }

        public c() {
        }
    }

    static {
    }

    public AudioExtractor() {
    }

    public static a b(MediaExtractor r110) {
        ArrayList r100 = new ArrayList();
        int r101 = r110.getTrackCount();
        int r111 = 0;
    L3:
        Object r102 = null;
        if (r111 >= r101) goto L20;
        MediaFormat r103 = r110.getTrackFormat(r111);
        String r104 = r103.getString("mime");
        if (r104 == null) goto L18;
        if (StringsKt.startsWith$default(r104, "audio/", false, 2, null) == false) goto L18;
        int r105 = d(r103, com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE, 44100);
        int r106 = d(r103, com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT, 2);
        if (r103.containsKey("durationUs") == false) goto L16;
        long r107 = r103.getLong("durationUs");     // Catch: Exception -> L15
    L17:
        int r108 = r111;
        r100.add(new a(r108, r103, r104, r105, r106, r107, d(r103, "bitrate", 0)));
    L16:
        r107 = 0;
    L18:
        r111 = r111 + 1;
        goto L3
    L20:
        if (r100.isEmpty() == false) goto L22;
        return null;
    L22:
        Iterator r112 = r100.iterator();
    L24:
        if (r112.hasNext() == false) goto L28;
        Object r109 = r112.next();
        if (Intrinsics.areEqual(((a) r109).f291114c, "audio/mp4a-latm") == false) goto L24;
        r102 = r109;
    L28:
        a r113 = (a) r102;
        if (r113 == null) goto L31;
        return r113;
    L31:
        return (a) CollectionsKt.first(r100);
    }

    public static boolean c(String r100) {
        Set r101 = SetsKt.mutableSetOf(new String[]{"audio/mp4a-latm", MimeType.MP3});
        int r102 = Build.VERSION.SDK_INT;
        r101.add("audio/ac3");
        r101.add("audio/eac3");
        if (r102 < 29) goto L6;
        r101.add("audio/opus");
    L6:
        return r101.contains(r100);
    }

    public static String e(String r110) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110);
        if (r100.exists() == true) goto L7;
        return "Output file does not exist";
    L7:
        if (r100.length() != 0) goto L10;
        return "Output file size is 0";
    L10:
        MediaExtractor r101 = new MediaExtractor();
        r101.setDataSource(r110);     // Catch: Throwable -> L29 Exception -> L41
        if (r101.getTrackCount() == 0) goto L56;
        int r111 = r101.getTrackCount();     // Catch: Throwable -> L29 Exception -> L41
        boolean r102 = false;
        int r103 = 0;
    L17:
        String r104 = null;
        if (r103 >= r111) goto L44;
        MediaFormat r105 = r101.getTrackFormat(r103);     // Catch: Throwable -> L29 Exception -> L41
        String r106 = r105.getString("mime");     // Catch: Throwable -> L29 Exception -> L41
        if (r106 != null) goto L23;
    L43:
        r103 = r103 + 1;
        goto L17
    L23:
        if (StringsKt.startsWith$default(r106, "audio/", false, 2, null) == false) goto L43;
        if (r105.containsKey("durationUs") == false) goto L32;
        long r107 = r105.getLong("durationUs");     // Catch: Throwable -> L29 Exception -> L31
    L34:
        if (r107 > 0) goto L36;
    L40:
        r102 = true;
        goto L44
    L36:
        if (r107 >= 100000) goto L40;
        String r112 = "Output audio duration is abnormal (" + (r107 / ((long) 1000)) + "ms), data may be incomplete";     // Catch: Throwable -> L29 Exception -> L41
    L64:
        r101.release();     // Catch: Exception -> L53
    L39:
        return r112;
    L32:
        r107 = 0;
    L44:
        if (r102 == true) goto L58;
        r104 = "Output file does not contain an audio track";
    L58:
        r101.release();     // Catch: Exception -> L54
    L49:
        return r104;
    L56:
        r101.release();     // Catch: Exception -> L52
    L15:
        return "Output file contains no tracks";
    L41:
        e = move-exception;
        r104 = "Output file validation failed: " + e.getMessage();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r101.release();     // Catch: Exception -> L55
    L51:
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [long] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.media.MediaExtractor] */
    public static c a(AudioExtractor r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "inputPath");
        Intrinsics.checkNotNullParameter(r112, "outputPath");
        PolarisFileWrapper r100 = new PolarisFileWrapper(r111);
        MediaMuxer r113 = null;
        if (r100.exists() == true) goto L5;
    L92:
        c.a r101 = new c.a(ErrorCode.FILE_NOT_FOUND, "Input file does not exist or is empty: " + r111, null);
    L126:
        return r101;
    L5:
        if (r100.isFile() == false) goto L92;
        MediaExtractor r102 = r100.length();
        if (r102 == 0) goto L92;
        PolarisFileWrapper r114 = new PolarisFileWrapper(r112);
        r102 = new MediaExtractor();     // Catch: Exception -> L49 Throwable -> L67
        r102.setDataSource(r111);     // Catch: Exception -> L49 Throwable -> L67
        a r103 = b(r102);     // Catch: Throwable -> L16 Exception -> L18
        if (r103 != null) goto L20;
        c r104 = new c.a(ErrorCode.NO_AUDIO_TRACK, "No audio track found in the video", null);     // Catch: Throwable -> L16 Exception -> L18
        r102.release();     // Catch: Exception -> L95
    L116:
        return r104;
    L125:
        return r104;
    L20:
        FLogger r105 = FLogger.f375446a;     // Catch: Throwable -> L16 Exception -> L18
        StringBuilder r106 = new StringBuilder("Audio track found: mime=");     // Catch: Throwable -> L16 Exception -> L18
        r106.append(r103.f291114c);     // Catch: Throwable -> L16 Exception -> L18
        r106.append(", sampleRate=");     // Catch: Throwable -> L16 Exception -> L18
        r106.append(r103.f291115d);     // Catch: Throwable -> L16 Exception -> L18
        r106.append(", channels=");     // Catch: Throwable -> L16 Exception -> L18
        r106.append(r103.f291116e);     // Catch: Throwable -> L16 Exception -> L18
        r106.append(", duration=");     // Catch: Throwable -> L16 Exception -> L18
        long r115 = 1000;
        r106.append(r103.f291117f / r115);     // Catch: Throwable -> L16 Exception -> L18
        r106.append("ms, bitRate=");     // Catch: Throwable -> L16 Exception -> L18
        r106.append(r103.f291118g);     // Catch: Throwable -> L16 Exception -> L18
        r105.i("AudioExtractor", r106.toString());     // Catch: Throwable -> L16 Exception -> L18
        if (c(r103.f291114c) == true) goto L25;
        r101 = new c.a(ErrorCode.UNSUPPORTED_MIME, "Audio codec " + r103.f291114c + " does not support remux to MP4 container, consider using FFmpeg for transcoding", null);     // Catch: Throwable -> L16 Exception -> L18
    L112:
        r102.release();     // Catch: Exception -> L96
        goto L126
    L25:
        r102.selectTrack(r103.f291112a);     // Catch: Throwable -> L16 Exception -> L18
        File r107 = r114.getParentFile();     // Catch: Throwable -> L16 Exception -> L18
        if (r107 == null) goto L31;
        if (r107.exists() == true) goto L31;
        r107.mkdirs();     // Catch: Throwable -> L16 Exception -> L18
    L31:
        if (r114.exists() == false) goto L108;
        r114.delete();     // Catch: Throwable -> L16 Exception -> L18
    L108:
        MediaMuxer r108 = new MediaMuxer(r112, 0);     // Catch: Throwable -> L16 Exception -> L64
        int r109 = r108.addTrack(r103.f291113b);     // Catch: Exception -> L59 Throwable -> L61
        r108.start();     // Catch: Exception -> L59 Throwable -> L61
        int r116 = 1048576;
        int r117 = d(r103.f291113b, "max-input-size", 1048576);     // Catch: Exception -> L59 Throwable -> L61
        if (r117 <= 0) goto L41;
        r116 = 8388608;
        if (r117 > 8388608) goto L41;
        r116 = r117;
    L41:
        ByteBuffer r118 = ByteBuffer.allocate(r116);     // Catch: Exception -> L59 Throwable -> L61
        MediaCodec.BufferInfo r119 = new MediaCodec.BufferInfo();     // Catch: Exception -> L59 Throwable -> L61
    L42:
        int r120 = r102.readSampleData(r118, 0);     // Catch: Exception -> L59 Throwable -> L61
        if (r120 < 0) goto L44;
        r119.offset = 0;     // Catch: Exception -> L59 Throwable -> L61
        r119.size = r120;     // Catch: Exception -> L59 Throwable -> L61
        r119.presentationTimeUs = r102.getSampleTime();     // Catch: Exception -> L59 Throwable -> L61
        int r121 = 1;
        if ((r102.getSampleFlags() & 1) != 0) goto L57;
        r121 = 0;
    L57:
        r119.flags = r121;     // Catch: Exception -> L59 Throwable -> L61
        r108.writeSampleData(r109, r118, r119);     // Catch: Exception -> L59 Throwable -> L61
        r102.advance();     // Catch: Exception -> L59 Throwable -> L61
        goto L42
    L44:
        r108.stop();     // Catch: Exception -> L59 Throwable -> L61
        r108.release();     // Catch: Exception -> L59 Throwable -> L61
        r102.release();     // Catch: Throwable -> L16 Exception -> L18
        String r122 = e(r112);     // Catch: Exception -> L49 Throwable -> L67
        if (r122 == null) goto L52;
        r114.delete();     // Catch: Exception -> L49 Throwable -> L67
        r104 = new c.a(ErrorCode.OUTPUT_VALIDATION_FAILED, r122, null);     // Catch: Exception -> L49 Throwable -> L67
        goto L116
    L52:
        r104 = new c.b(r112, r103.f291117f / r115, r103.f291114c, r103.f291115d, r103.f291116e, r114.length());     // Catch: Exception -> L49 Throwable -> L67
        goto L116
    L59:
        e = e;
        r113 = r108;
    L70:
        FLogger.f375446a.e("AudioExtractor", "Audio extraction failed", e);     // Catch: Throwable -> L16
        r114.delete();     // Catch: Throwable -> L16
        r101 = new c.a(ErrorCode.EXTRACTION_FAILED, "Extraction exception: " + e.getMessage(), e);     // Catch: Throwable -> L16
        if (r113 != null) goto L101;
    L75:
        if (r113 != null) goto L106;
    L79:
        if (r102 == 0) goto L126;
    L106:
        r113.release();     // Catch: Exception -> L78
        goto L79
    L101:
        r113.stop();     // Catch: Exception -> L74
    L61:
        th = th;
        r113 = r108;
    L81:
        if (r113 != null) goto L114;
    L85:
        if (r113 != null) goto L98;
    L89:
        if (r102 == 0) goto L123;
        r102.release();     // Catch: Exception -> L97
        throw th;
    L124:
        throw th;
    L123:
        throw th;
    L98:
        r113.release();     // Catch: Exception -> L88
        goto L89
    L114:
        r113.stop();     // Catch: Exception -> L84
    L64:
        e = move-exception;
        r101 = new c.a(ErrorCode.MUXER_INIT_FAILED, "MediaMuxer initialization failed: " + e.getMessage(), e);     // Catch: Throwable -> L16 Exception -> L18
    L18:
        e = e;
    L16:
        th = th;
    L49:
        e = e;
        r102 = 0;
    L67:
        th = th;
        r102 = 0;
        goto L81
    }

    public static int d(MediaFormat r100, String r101, int r102) {
        if (r100.containsKey(r101) == false) goto L10;
        return r100.getInteger(r101);
    L10:
        return r102;
    L7:
        return r102;
    }
}
