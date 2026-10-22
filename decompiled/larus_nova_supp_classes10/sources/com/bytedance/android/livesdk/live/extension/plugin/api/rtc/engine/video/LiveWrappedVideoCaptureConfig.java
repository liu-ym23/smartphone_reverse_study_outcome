package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveWrappedVideoCaptureConfig {
    public final LiveWrappedCapturePreference a;
    public final int b;
    public final int c;
    public final int d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/video/LiveWrappedVideoCaptureConfig$LiveWrappedCapturePreference;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "AUTO", "MANUAL", "AUTO_PERFORMANCE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedCapturePreference extends Enum<LiveWrappedCapturePreference> {
        public static final LiveWrappedCapturePreference AUTO = null;
        public static final LiveWrappedCapturePreference AUTO_PERFORMANCE = null;
        public static final a Companion = null;
        public static final LiveWrappedCapturePreference MANUAL = null;
        public static final /* synthetic */ LiveWrappedCapturePreference[] a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        static {
            LiveWrappedCapturePreference r1 = new LiveWrappedCapturePreference("AUTO", 0, 0);
            AUTO = r1;
            LiveWrappedCapturePreference r2 = new LiveWrappedCapturePreference("MANUAL", 1, 1);
            MANUAL = r2;
            LiveWrappedCapturePreference r3 = new LiveWrappedCapturePreference("AUTO_PERFORMANCE", 2, 2);
            AUTO_PERFORMANCE = r3;
            a = new LiveWrappedCapturePreference[]{r1, r2, r3};
            Companion = new a();
        }

        public static LiveWrappedCapturePreference valueOf(String r1) {
            return (LiveWrappedCapturePreference) r27.a.a(LiveWrappedCapturePreference.class, r1);
        }

        public static LiveWrappedCapturePreference[] values() {
            return (LiveWrappedCapturePreference[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public LiveWrappedCapturePreference(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public final String toString() {
        return "VideoCaptureConfig{capturePreference=" + this.a + "width=" + this.b + ", height=" + this.c + ", frameRate=" + this.d + '}';
    }

    public LiveWrappedVideoCaptureConfig(int r2, int r3, int r4) {
        this.a = LiveWrappedCapturePreference.AUTO;
        this.a = LiveWrappedCapturePreference.MANUAL;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
