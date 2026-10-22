package com.facebook.yoga;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaErrata extends Enum<YogaErrata> {
    private static final /* synthetic */ YogaErrata[] $VALUES = null;
    public static final YogaErrata ABSOLUTE_PERCENT_AGAINST_INNER_SIZE = null;
    public static final YogaErrata ABSOLUTE_POSITION_WITHOUT_INSETS_EXCLUDES_PADDING = null;
    public static final YogaErrata ALL = null;
    public static final YogaErrata CLASSIC = null;
    public static final YogaErrata NONE = null;
    public static final YogaErrata STRETCH_FLEX_BASIS = null;
    private final int mIntValue;

    private static /* synthetic */ YogaErrata[] $values() {
        return new YogaErrata[]{NONE, STRETCH_FLEX_BASIS, ABSOLUTE_POSITION_WITHOUT_INSETS_EXCLUDES_PADDING, ABSOLUTE_PERCENT_AGAINST_INNER_SIZE, ALL, CLASSIC};
    }

    static {
        NONE = new YogaErrata(UserProfileEvent.POSITION_NONE, 0, 0);
        STRETCH_FLEX_BASIS = new YogaErrata("STRETCH_FLEX_BASIS", 1, 1);
        ABSOLUTE_POSITION_WITHOUT_INSETS_EXCLUDES_PADDING = new YogaErrata("ABSOLUTE_POSITION_WITHOUT_INSETS_EXCLUDES_PADDING", 2, 2);
        ABSOLUTE_PERCENT_AGAINST_INNER_SIZE = new YogaErrata("ABSOLUTE_PERCENT_AGAINST_INNER_SIZE", 3, 4);
        ALL = new YogaErrata(AccountType.ALL, 4, Integer.MAX_VALUE);
        CLASSIC = new YogaErrata("CLASSIC", 5, 2147483646);
        $VALUES = $values();
    }

    public static YogaErrata[] values() {
        return (YogaErrata[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaErrata fromInt(int r100) {
        if (r100 == 0) goto L23;
        if (r100 == 1) goto L21;
        if (r100 == 2) goto L19;
        if (r100 == 4) goto L17;
        switch(r100) {
            case 2147483646: goto L15;
            case 2147483647: goto L13;
            default: goto L11;
        };
    L11:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L13:
        return ALL;
    L15:
        return CLASSIC;
    L17:
        return ABSOLUTE_PERCENT_AGAINST_INNER_SIZE;
    L19:
        return ABSOLUTE_POSITION_WITHOUT_INSETS_EXCLUDES_PADDING;
    L21:
        return STRETCH_FLEX_BASIS;
    L23:
        return NONE;
    }

    public static YogaErrata valueOf(String r100) {
        return (YogaErrata) Enum.valueOf(YogaErrata.class, r100);
    }

    private YogaErrata(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
