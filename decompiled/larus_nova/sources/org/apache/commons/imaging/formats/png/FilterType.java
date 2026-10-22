package org.apache.commons.imaging.formats.png;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
final enum FilterType extends Enum<FilterType> {
    private static final /* synthetic */ FilterType[] $VALUES = null;
    public static final FilterType AVERAGE = null;
    public static final FilterType NONE = null;
    public static final FilterType PAETH = null;
    public static final FilterType SUB = null;
    public static final FilterType UP = null;

    static {
        FilterType r100 = new FilterType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        FilterType r101 = new FilterType("SUB", 1);
        SUB = r101;
        FilterType r102 = new FilterType("UP", 2);
        UP = r102;
        FilterType r103 = new FilterType("AVERAGE", 3);
        AVERAGE = r103;
        FilterType r104 = new FilterType("PAETH", 4);
        PAETH = r104;
        $VALUES = new FilterType[]{r100, r101, r102, r103, r104};
    }

    public static FilterType[] values() {
        return (FilterType[]) $VALUES.clone();
    }

    public static FilterType valueOf(String r100) {
        return (FilterType) a.a(FilterType.class, r100);
    }

    private FilterType(String r100, int r101) {
        super(r100, r101);
    }
}
