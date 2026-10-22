package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedColorSpace;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571738a = null;

    static {
        int[] r100 = new int[LiveWrappedColorSpace.values().length];
        f571738a = r100;
        r100[LiveWrappedColorSpace.BT601_LIMITED_RANGE.ordinal()] = 1;
        r100[LiveWrappedColorSpace.BT601_FULL_RANGE.ordinal()] = 2;
        r100[LiveWrappedColorSpace.BT709_LIMITED_RANGE.ordinal()] = 3;
        r100[LiveWrappedColorSpace.BT709_FULL_RANGE.ordinal()] = 4;
    }
}
