package com.ss.android.vesdk;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;

/* JADX INFO: loaded from: classes40.dex */
public final enum VERecordMode extends Enum<VERecordMode> {
    private static final /* synthetic */ VERecordMode[] $VALUES = null;
    public static final VERecordMode AUDIO = null;
    public static final VERecordMode CUSTOM_VIDEO_BG = null;
    public static final VERecordMode CUSTOM_VIDEO_BG_GIF = null;
    public static final VERecordMode DEFAULT = null;
    public static final VERecordMode DUET = null;
    public static final VERecordMode DUET_KARAOKE = null;
    public static final VERecordMode KARAOKE = null;
    public static final VERecordMode KARAOKE_PURE_AUDIO = null;
    public static final VERecordMode MOTION_PHOTO = null;
    public static final VERecordMode REACTION = null;
    public static final VERecordMode SCREEN = null;

    private static /* synthetic */ VERecordMode[] $values() {
        return new VERecordMode[]{DEFAULT, DUET, REACTION, CUSTOM_VIDEO_BG, DUET_KARAOKE, KARAOKE, KARAOKE_PURE_AUDIO, CUSTOM_VIDEO_BG_GIF, AUDIO, SCREEN, MOTION_PHOTO};
    }

    static {
        DEFAULT = new VERecordMode("DEFAULT", 0);
        DUET = new VERecordMode("DUET", 1);
        REACTION = new VERecordMode(CardAdapter.REACTION, 2);
        CUSTOM_VIDEO_BG = new VERecordMode("CUSTOM_VIDEO_BG", 3);
        DUET_KARAOKE = new VERecordMode("DUET_KARAOKE", 4);
        KARAOKE = new VERecordMode("KARAOKE", 5);
        KARAOKE_PURE_AUDIO = new VERecordMode("KARAOKE_PURE_AUDIO", 6);
        CUSTOM_VIDEO_BG_GIF = new VERecordMode("CUSTOM_VIDEO_BG_GIF", 7);
        AUDIO = new VERecordMode("AUDIO", 8);
        SCREEN = new VERecordMode("SCREEN", 9);
        MOTION_PHOTO = new VERecordMode("MOTION_PHOTO", 10);
        $VALUES = $values();
    }

    public static VERecordMode[] values() {
        return (VERecordMode[]) $VALUES.clone();
    }

    public static VERecordMode valueOf(String r100) {
        return (VERecordMode) r27.a.a(VERecordMode.class, r100);
    }

    private VERecordMode(String r100, int r101) {
        super(r100, r101);
    }
}
