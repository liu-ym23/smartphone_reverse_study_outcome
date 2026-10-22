package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveWrappedVideoEncoderConfig {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final LiveWrappedEncoderPreference f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedVideoEncoderConfig$LiveWrappedCodecMode;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "CODEC_MODE_AUTO", "CODEC_MODE_HARDWARE", "CODEC_MODE_SOFTWARE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedCodecMode extends Enum<LiveWrappedCodecMode> {
        public static final LiveWrappedCodecMode CODEC_MODE_AUTO = null;
        public static final LiveWrappedCodecMode CODEC_MODE_HARDWARE = null;
        public static final LiveWrappedCodecMode CODEC_MODE_SOFTWARE = null;
        public static final a Companion = null;
        public static final /* synthetic */ LiveWrappedCodecMode[] a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        static {
            LiveWrappedCodecMode r1 = new LiveWrappedCodecMode("CODEC_MODE_AUTO", 0, 0);
            CODEC_MODE_AUTO = r1;
            LiveWrappedCodecMode r2 = new LiveWrappedCodecMode("CODEC_MODE_HARDWARE", 1, 1);
            CODEC_MODE_HARDWARE = r2;
            LiveWrappedCodecMode r3 = new LiveWrappedCodecMode("CODEC_MODE_SOFTWARE", 2, 2);
            CODEC_MODE_SOFTWARE = r3;
            a = new LiveWrappedCodecMode[]{r1, r2, r3};
            Companion = new a();
        }

        public static LiveWrappedCodecMode valueOf(String r1) {
            return (LiveWrappedCodecMode) r27.a.a(LiveWrappedCodecMode.class, r1);
        }

        public static LiveWrappedCodecMode[] values() {
            return (LiveWrappedCodecMode[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public LiveWrappedCodecMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedVideoEncoderConfig$LiveWrappedEncoderPreference;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "DISABLED", "MAINTAIN_FRAMERATE", "MAINTAIN_QUALITY", "AUTO", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedEncoderPreference extends Enum<LiveWrappedEncoderPreference> {
        public static final LiveWrappedEncoderPreference AUTO = null;
        public static final a Companion = null;
        public static final LiveWrappedEncoderPreference DISABLED = null;
        public static final LiveWrappedEncoderPreference MAINTAIN_FRAMERATE = null;
        public static final LiveWrappedEncoderPreference MAINTAIN_QUALITY = null;
        public static final /* synthetic */ LiveWrappedEncoderPreference[] a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        static {
            LiveWrappedEncoderPreference r1 = new LiveWrappedEncoderPreference("DISABLED", 0, 0);
            DISABLED = r1;
            LiveWrappedEncoderPreference r2 = new LiveWrappedEncoderPreference("MAINTAIN_FRAMERATE", 1, 1);
            MAINTAIN_FRAMERATE = r2;
            LiveWrappedEncoderPreference r3 = new LiveWrappedEncoderPreference("MAINTAIN_QUALITY", 2, 2);
            MAINTAIN_QUALITY = r3;
            LiveWrappedEncoderPreference r4 = new LiveWrappedEncoderPreference("AUTO", 3, 3);
            AUTO = r4;
            a = new LiveWrappedEncoderPreference[]{r1, r2, r3, r4};
            Companion = new a();
        }

        public static LiveWrappedEncoderPreference valueOf(String r1) {
            return (LiveWrappedEncoderPreference) r27.a.a(LiveWrappedEncoderPreference.class, r1);
        }

        public static LiveWrappedEncoderPreference[] values() {
            return (LiveWrappedEncoderPreference[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public LiveWrappedEncoderPreference(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedVideoEncoderConfig$LiveWrappedVideoCodecType;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "CODEC_TYPE_AUTO", "CODEC_TYPE_H264", "CODEC_TYPE_BYTEVC1", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedVideoCodecType extends Enum<LiveWrappedVideoCodecType> {
        public static final LiveWrappedVideoCodecType CODEC_TYPE_AUTO = null;
        public static final LiveWrappedVideoCodecType CODEC_TYPE_BYTEVC1 = null;
        public static final LiveWrappedVideoCodecType CODEC_TYPE_H264 = null;
        public static final a Companion = null;
        public static final /* synthetic */ LiveWrappedVideoCodecType[] a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        static {
            LiveWrappedVideoCodecType r1 = new LiveWrappedVideoCodecType("CODEC_TYPE_AUTO", 0, 0);
            CODEC_TYPE_AUTO = r1;
            LiveWrappedVideoCodecType r2 = new LiveWrappedVideoCodecType("CODEC_TYPE_H264", 1, 1);
            CODEC_TYPE_H264 = r2;
            LiveWrappedVideoCodecType r3 = new LiveWrappedVideoCodecType("CODEC_TYPE_BYTEVC1", 2, 2);
            CODEC_TYPE_BYTEVC1 = r3;
            a = new LiveWrappedVideoCodecType[]{r1, r2, r3};
            Companion = new a();
        }

        public static LiveWrappedVideoCodecType valueOf(String r1) {
            return (LiveWrappedVideoCodecType) r27.a.a(LiveWrappedVideoCodecType.class, r1);
        }

        public static LiveWrappedVideoCodecType[] values() {
            return (LiveWrappedVideoCodecType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public LiveWrappedVideoCodecType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "VideoEncoderConfig{width=" + this.a + "height=" + this.b + ", frameRate=" + this.c + ", maxBitrate=" + this.d + ", minBitrate=" + this.e + ", encodePreference=" + this.f + '}';
    }

    public LiveWrappedVideoEncoderConfig(int r2, int r3, int r4, int r5, int r6) {
        this.d = -1;
        this.f = LiveWrappedEncoderPreference.MAINTAIN_FRAMERATE;
        LiveWrappedVideoCodecType r0 = LiveWrappedVideoCodecType.CODEC_TYPE_AUTO;
        LiveWrappedCodecMode r1 = LiveWrappedCodecMode.CODEC_MODE_AUTO;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
