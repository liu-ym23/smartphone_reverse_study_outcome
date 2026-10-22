package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveWrappedSubscribeConfig {
    public final int a;
    public final LiveWrappedSVCLayer b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedSubscribeConfig$LiveWrappedSVCLayer;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "DEFAULT", "BASE", "MAIN", "HIGH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedSVCLayer extends Enum<LiveWrappedSVCLayer> {
        public static final LiveWrappedSVCLayer BASE = null;
        public static final a Companion = null;
        public static final LiveWrappedSVCLayer DEFAULT = null;
        public static final LiveWrappedSVCLayer HIGH = null;
        public static final LiveWrappedSVCLayer MAIN = null;
        public static final /* synthetic */ LiveWrappedSVCLayer[] a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        static {
            LiveWrappedSVCLayer r1 = new LiveWrappedSVCLayer("DEFAULT", 0, 0);
            DEFAULT = r1;
            LiveWrappedSVCLayer r2 = new LiveWrappedSVCLayer("BASE", 1, 1);
            BASE = r2;
            LiveWrappedSVCLayer r3 = new LiveWrappedSVCLayer("MAIN", 2, 2);
            MAIN = r3;
            LiveWrappedSVCLayer r4 = new LiveWrappedSVCLayer("HIGH", 3, 3);
            HIGH = r4;
            a = new LiveWrappedSVCLayer[]{r1, r2, r3, r4};
            Companion = new a();
        }

        public static LiveWrappedSVCLayer valueOf(String r1) {
            return (LiveWrappedSVCLayer) r27.a.a(LiveWrappedSVCLayer.class, r1);
        }

        public static LiveWrappedSVCLayer[] values() {
            return (LiveWrappedSVCLayer[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public LiveWrappedSVCLayer(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "SubscribeConfig{isScreen=false, subVideo=false, subAudio=false, videoIndex=0, svcLayer=" + this.b + ", sub_width=0, sub_height=0, sub_video_index=" + this.a + "}";
    }

    public LiveWrappedSubscribeConfig() {
        this.a = -1;
        this.b = LiveWrappedSVCLayer.DEFAULT;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L15:
        return false;
    L8:
        if ((!Intrinsics.areEqual(LiveWrappedSubscribeConfig.class, r5.getClass())) == true) goto L15;
        if (this.b == ((LiveWrappedSubscribeConfig) r5).b) goto L16;
        return false;
    L16:
        return true;
    }
}
