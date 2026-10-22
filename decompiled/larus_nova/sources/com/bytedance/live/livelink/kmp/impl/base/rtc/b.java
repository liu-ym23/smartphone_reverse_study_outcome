package com.bytedance.live.livelink.kmp.impl.base.rtc;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f255310a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f255311b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f255312c = null;

    static {
        int[] r100 = new int[LiveWrappedMediaStreamType.values().length];
        f255310a = r100;
        LiveWrappedMediaStreamType r101 = LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_VIDEO;
        r100[r101.ordinal()] = 1;
        LiveWrappedMediaStreamType r102 = LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_BOTH;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[LiveWrappedMediaStreamType.values().length];
        f255311b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
        int[] r104 = new int[RTCWaterMarkRegion.TranscoderImageRenderMode.values().length];
        f255312c = r104;
        r104[RTCWaterMarkRegion.TranscoderImageRenderMode.RENDER_HIDDEN.ordinal()] = 1;
        r104[RTCWaterMarkRegion.TranscoderImageRenderMode.RENDER_FIT.ordinal()] = 2;
        r104[RTCWaterMarkRegion.TranscoderImageRenderMode.RENDER_ADAPTIVE.ordinal()] = 3;
    }
}
