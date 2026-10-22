package com.ss.bytertc.engine.type;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SubscribeMediaType extends Enum<SubscribeMediaType> {
    private static final /* synthetic */ SubscribeMediaType[] $VALUES = null;
    public static final SubscribeMediaType AUDIO_AND_VIDEO = null;
    public static final SubscribeMediaType AUDIO_ONLY = null;
    public static final SubscribeMediaType NONE = null;
    public static final SubscribeMediaType VIDEO_ONLY = null;
    private int value;

    static {
        SubscribeMediaType r100 = new SubscribeMediaType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        SubscribeMediaType r101 = new SubscribeMediaType("AUDIO_ONLY", 1, 1);
        AUDIO_ONLY = r101;
        SubscribeMediaType r102 = new SubscribeMediaType("VIDEO_ONLY", 2, 2);
        VIDEO_ONLY = r102;
        SubscribeMediaType r103 = new SubscribeMediaType("AUDIO_AND_VIDEO", 3, 3);
        AUDIO_AND_VIDEO = r103;
        $VALUES = new SubscribeMediaType[]{r100, r101, r102, r103};
    }

    public static SubscribeMediaType[] values() {
        return (SubscribeMediaType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static SubscribeMediaType valueOf(String r100) {
        return (SubscribeMediaType) a.a(SubscribeMediaType.class, r100);
    }

    private SubscribeMediaType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
