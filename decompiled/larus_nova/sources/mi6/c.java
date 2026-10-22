package mi6;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType;

/* JADX INFO: loaded from: classes19.dex */
public final class c {
    public static final LiveWrappedMediaStreamType a(int r100) {
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L14;
        return LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_AUDIO;
    L14:
        return LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_BOTH;
    L15:
        return LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_VIDEO;
    L12:
        return LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_AUDIO;
    }
}
