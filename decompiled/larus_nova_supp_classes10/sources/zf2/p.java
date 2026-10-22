package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedColorSpace;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class p {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedColorSpace.values().length];
        a = r0;
        r0[LiveWrappedColorSpace.BT601_LIMITED_RANGE.ordinal()] = 1;
        r0[LiveWrappedColorSpace.BT601_FULL_RANGE.ordinal()] = 2;
        r0[LiveWrappedColorSpace.BT709_LIMITED_RANGE.ordinal()] = 3;
        r0[LiveWrappedColorSpace.BT709_FULL_RANGE.ordinal()] = 4;
    }
}
