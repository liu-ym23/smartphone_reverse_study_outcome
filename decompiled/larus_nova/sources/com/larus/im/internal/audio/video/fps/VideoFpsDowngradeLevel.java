package com.larus.im.internal.audio.video.fps;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/audio/video/fps/VideoFpsDowngradeLevel;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "MEDIUM", "LOWER", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VideoFpsDowngradeLevel extends Enum<VideoFpsDowngradeLevel> {
    public static final VideoFpsDowngradeLevel LOWER = null;
    public static final VideoFpsDowngradeLevel MEDIUM = null;
    public static final VideoFpsDowngradeLevel NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoFpsDowngradeLevel[] f347505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f347506b = null;

    public static EnumEntries<VideoFpsDowngradeLevel> getEntries() {
        return f347506b;
    }

    static {
        VideoFpsDowngradeLevel r100 = new VideoFpsDowngradeLevel(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VideoFpsDowngradeLevel r101 = new VideoFpsDowngradeLevel("MEDIUM", 1);
        MEDIUM = r101;
        VideoFpsDowngradeLevel r102 = new VideoFpsDowngradeLevel("LOWER", 2);
        LOWER = r102;
        VideoFpsDowngradeLevel[] r103 = {r100, r101, r102};
        f347505a = r103;
        f347506b = EnumEntriesKt.enumEntries(r103);
    }

    public static VideoFpsDowngradeLevel[] values() {
        return (VideoFpsDowngradeLevel[]) f347505a.clone();
    }

    public static VideoFpsDowngradeLevel valueOf(String r100) {
        return (VideoFpsDowngradeLevel) a.a(VideoFpsDowngradeLevel.class, r100);
    }

    public VideoFpsDowngradeLevel(String r100, int r101) {
        super(r100, r101);
    }
}
