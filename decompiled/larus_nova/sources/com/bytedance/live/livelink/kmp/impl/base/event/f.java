package com.bytedance.live.livelink.kmp.impl.base.event;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedForwardStreamStateInfo;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomState;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f255278a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f255279b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f255280c = null;

    static {
        int[] r100 = new int[LiveWrappedRoomState.values().length];
        f255278a = r100;
        r100[LiveWrappedRoomState.JOIN_FAILED.ordinal()] = 1;
        r100[LiveWrappedRoomState.LEFT.ordinal()] = 2;
        int[] r101 = new int[LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamState.values().length];
        r101[LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamState.FORWARD_STREAM_STATE_IDLE.ordinal()] = 1;
        r101[LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamState.FORWARD_STREAM_STATE_SUCCESS.ordinal()] = 2;
        r101[LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamState.FORWARD_STREAM_STATE_FAILURE.ordinal()] = 3;
        int[] r102 = new int[LiveWrappedMediaStreamType.values().length];
        f255279b = r102;
        LiveWrappedMediaStreamType r103 = LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_AUDIO;
        r102[r103.ordinal()] = 1;
        LiveWrappedMediaStreamType r104 = LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_VIDEO;
        r102[r104.ordinal()] = 2;
        LiveWrappedMediaStreamType r105 = LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_BOTH;
        r102[r105.ordinal()] = 3;
        int[] r106 = new int[LiveWrappedMediaStreamType.values().length];
        f255280c = r106;
        r106[r103.ordinal()] = 1;
        r106[r104.ordinal()] = 2;
        r106[r105.ordinal()] = 3;
    }
}
