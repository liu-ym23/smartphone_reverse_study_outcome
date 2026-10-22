package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoPixelFormat;", "", "", "value", "", "toString", "I", "Companion", "a", "UNKNOWN", "I420", "NV12", "NV21", "RGBA", "TEXTURE_2D", "TEXTURE_OES", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoPixelFormat extends Enum<LiveWrappedVideoPixelFormat> {
    public static final a Companion = null;
    public static final LiveWrappedVideoPixelFormat I420 = null;
    public static final LiveWrappedVideoPixelFormat NV12 = null;
    public static final LiveWrappedVideoPixelFormat NV21 = null;
    public static final LiveWrappedVideoPixelFormat RGBA = null;
    public static final LiveWrappedVideoPixelFormat TEXTURE_2D = null;
    public static final LiveWrappedVideoPixelFormat TEXTURE_OES = null;
    public static final LiveWrappedVideoPixelFormat UNKNOWN = null;
    public static final /* synthetic */ LiveWrappedVideoPixelFormat[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoPixelFormat$a] */
    static {
        LiveWrappedVideoPixelFormat r1 = new LiveWrappedVideoPixelFormat("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        LiveWrappedVideoPixelFormat r2 = new LiveWrappedVideoPixelFormat("I420", 1, 1);
        I420 = r2;
        LiveWrappedVideoPixelFormat r3 = new LiveWrappedVideoPixelFormat("NV12", 2, 2);
        NV12 = r3;
        LiveWrappedVideoPixelFormat r4 = new LiveWrappedVideoPixelFormat("NV21", 3, 3);
        NV21 = r4;
        LiveWrappedVideoPixelFormat r5 = new LiveWrappedVideoPixelFormat("RGBA", 4, 5);
        RGBA = r5;
        LiveWrappedVideoPixelFormat r6 = new LiveWrappedVideoPixelFormat("TEXTURE_2D", 5, 3553);
        TEXTURE_2D = r6;
        LiveWrappedVideoPixelFormat r7 = new LiveWrappedVideoPixelFormat("TEXTURE_OES", 6, 36197);
        TEXTURE_OES = r7;
        a = new LiveWrappedVideoPixelFormat[]{r1, r2, r3, r4, r5, r6, r7};
        Companion = new a();
    }

    public static LiveWrappedVideoPixelFormat valueOf(String r1) {
        return (LiveWrappedVideoPixelFormat) r27.a.a(LiveWrappedVideoPixelFormat.class, r1);
    }

    public static LiveWrappedVideoPixelFormat[] values() {
        return (LiveWrappedVideoPixelFormat[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(t0.a[ordinal()]) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        return "kVideoPixelFormatUnknown";
    L6:
        return "kVideoPixelFormatTextureOES";
    L8:
        return "kVideoPixelFormatTexture2D";
    L10:
        return "kVideoPixelFormatRGBA";
    L12:
        return "kVideoPixelFormatNV21";
    L14:
        return "kVideoPixelFormatNV12";
    L16:
        return "kVideoPixelFormatI420";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoPixelFormat(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
