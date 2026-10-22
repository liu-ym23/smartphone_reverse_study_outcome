package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoPixelFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class t0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedVideoPixelFormat.values().length];
        a = r0;
        r0[LiveWrappedVideoPixelFormat.I420.ordinal()] = 1;
        r0[LiveWrappedVideoPixelFormat.NV12.ordinal()] = 2;
        r0[LiveWrappedVideoPixelFormat.NV21.ordinal()] = 3;
        r0[LiveWrappedVideoPixelFormat.RGBA.ordinal()] = 4;
        r0[LiveWrappedVideoPixelFormat.TEXTURE_2D.ordinal()] = 5;
        r0[LiveWrappedVideoPixelFormat.TEXTURE_OES.ordinal()] = 6;
    }
}
