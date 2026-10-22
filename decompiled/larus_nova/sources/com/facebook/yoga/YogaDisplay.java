package com.facebook.yoga;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaDisplay extends Enum<YogaDisplay> {
    private static final /* synthetic */ YogaDisplay[] $VALUES = null;
    public static final YogaDisplay CONTENTS = null;
    public static final YogaDisplay FLEX = null;
    public static final YogaDisplay NONE = null;
    private final int mIntValue;

    private static /* synthetic */ YogaDisplay[] $values() {
        return new YogaDisplay[]{FLEX, NONE, CONTENTS};
    }

    static {
        FLEX = new YogaDisplay("FLEX", 0, 0);
        NONE = new YogaDisplay(UserProfileEvent.POSITION_NONE, 1, 1);
        CONTENTS = new YogaDisplay("CONTENTS", 2, 2);
        $VALUES = $values();
    }

    public static YogaDisplay[] values() {
        return (YogaDisplay[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaDisplay fromInt(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 != 2) goto L10;
        return CONTENTS;
    L10:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L12:
        return NONE;
    L14:
        return FLEX;
    }

    public static YogaDisplay valueOf(String r100) {
        return (YogaDisplay) Enum.valueOf(YogaDisplay.class, r100);
    }

    private YogaDisplay(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
