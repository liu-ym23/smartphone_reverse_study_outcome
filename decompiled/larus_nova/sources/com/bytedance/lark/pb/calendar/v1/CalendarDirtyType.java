package com.bytedance.lark.pb.calendar.v1;

import com.larus.bmhome.chat.bean.WcbRenderStatus;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum CalendarDirtyType extends Enum<CalendarDirtyType> implements WireEnum {
    private static final /* synthetic */ CalendarDirtyType[] $VALUES = null;
    public static final ProtoAdapter<CalendarDirtyType> ADAPTER = null;
    public static final CalendarDirtyType DELETED = null;
    public static final CalendarDirtyType NONE_DIRTY_TYPE = null;
    public static final CalendarDirtyType UPDATED = null;
    private final int value;

    static {
        CalendarDirtyType r100 = new CalendarDirtyType("NONE_DIRTY_TYPE", 0, 0);
        NONE_DIRTY_TYPE = r100;
        CalendarDirtyType r101 = new CalendarDirtyType(WcbRenderStatus.UPDATED, 1, 1);
        UPDATED = r101;
        CalendarDirtyType r102 = new CalendarDirtyType("DELETED", 2, 2);
        DELETED = r102;
        $VALUES = new CalendarDirtyType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(CalendarDirtyType.class);
    }

    public static CalendarDirtyType[] values() {
        return (CalendarDirtyType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static CalendarDirtyType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return DELETED;
    L12:
        return UPDATED;
    L14:
        return NONE_DIRTY_TYPE;
    }

    public static CalendarDirtyType valueOf(String r100) {
        return (CalendarDirtyType) a.a(CalendarDirtyType.class, r100);
    }

    private CalendarDirtyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
