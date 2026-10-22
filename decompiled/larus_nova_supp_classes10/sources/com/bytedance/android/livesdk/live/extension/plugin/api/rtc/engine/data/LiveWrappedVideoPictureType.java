package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoPictureType;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "VIDEO_PICTURE_TYPE_UNKNOWN", "VIDEO_PICTURE_TYPE_I", "VIDEO_PICTURE_TYPE_P", "VIDEO_PICTURE_TYPE_B", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoPictureType extends Enum<LiveWrappedVideoPictureType> {
    public static final LiveWrappedVideoPictureType VIDEO_PICTURE_TYPE_B = null;
    public static final LiveWrappedVideoPictureType VIDEO_PICTURE_TYPE_I = null;
    public static final LiveWrappedVideoPictureType VIDEO_PICTURE_TYPE_P = null;
    public static final LiveWrappedVideoPictureType VIDEO_PICTURE_TYPE_UNKNOWN = null;
    public static final /* synthetic */ LiveWrappedVideoPictureType[] a = null;
    private int value;

    static {
        LiveWrappedVideoPictureType r1 = new LiveWrappedVideoPictureType("VIDEO_PICTURE_TYPE_UNKNOWN", 0, 0);
        VIDEO_PICTURE_TYPE_UNKNOWN = r1;
        LiveWrappedVideoPictureType r2 = new LiveWrappedVideoPictureType("VIDEO_PICTURE_TYPE_I", 1, 1);
        VIDEO_PICTURE_TYPE_I = r2;
        LiveWrappedVideoPictureType r3 = new LiveWrappedVideoPictureType("VIDEO_PICTURE_TYPE_P", 2, 2);
        VIDEO_PICTURE_TYPE_P = r3;
        LiveWrappedVideoPictureType r4 = new LiveWrappedVideoPictureType("VIDEO_PICTURE_TYPE_B", 3, 3);
        VIDEO_PICTURE_TYPE_B = r4;
        a = new LiveWrappedVideoPictureType[]{r1, r2, r3, r4};
    }

    public static LiveWrappedVideoPictureType valueOf(String r1) {
        return (LiveWrappedVideoPictureType) a.a(LiveWrappedVideoPictureType.class, r1);
    }

    public static LiveWrappedVideoPictureType[] values() {
        return (LiveWrappedVideoPictureType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public LiveWrappedVideoPictureType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
