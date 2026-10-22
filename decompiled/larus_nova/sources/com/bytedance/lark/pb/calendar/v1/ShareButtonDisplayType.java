package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ShareButtonDisplayType extends Enum<ShareButtonDisplayType> implements WireEnum {
    private static final /* synthetic */ ShareButtonDisplayType[] $VALUES = null;
    public static final ProtoAdapter<ShareButtonDisplayType> ADAPTER = null;
    public static final ShareButtonDisplayType FORBIDDEN_CALENDAR_READER = null;
    public static final ShareButtonDisplayType FORBIDDEN_EVENT_CANNOT_INVITE_ATTENDEE = null;
    public static final ShareButtonDisplayType FORBIDDEN_PRIVATE = null;
    public static final ShareButtonDisplayType HIDDEN = null;
    public static final ShareButtonDisplayType SHAREABLE = null;
    private final int value;

    static {
        ShareButtonDisplayType r100 = new ShareButtonDisplayType("HIDDEN", 0, 1);
        HIDDEN = r100;
        ShareButtonDisplayType r101 = new ShareButtonDisplayType("SHAREABLE", 1, 2);
        SHAREABLE = r101;
        ShareButtonDisplayType r102 = new ShareButtonDisplayType("FORBIDDEN_PRIVATE", 2, 3);
        FORBIDDEN_PRIVATE = r102;
        ShareButtonDisplayType r103 = new ShareButtonDisplayType("FORBIDDEN_CALENDAR_READER", 3, 4);
        FORBIDDEN_CALENDAR_READER = r103;
        ShareButtonDisplayType r104 = new ShareButtonDisplayType("FORBIDDEN_EVENT_CANNOT_INVITE_ATTENDEE", 4, 5);
        FORBIDDEN_EVENT_CANNOT_INVITE_ATTENDEE = r104;
        $VALUES = new ShareButtonDisplayType[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(ShareButtonDisplayType.class);
    }

    public static ShareButtonDisplayType[] values() {
        return (ShareButtonDisplayType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ShareButtonDisplayType fromValue(int r100) {
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L19;
        if (r100 == 4) goto L17;
        if (r100 == 5) goto L15;
        return null;
    L15:
        return FORBIDDEN_EVENT_CANNOT_INVITE_ATTENDEE;
    L17:
        return FORBIDDEN_CALENDAR_READER;
    L19:
        return FORBIDDEN_PRIVATE;
    L21:
        return SHAREABLE;
    L23:
        return HIDDEN;
    }

    public static ShareButtonDisplayType valueOf(String r100) {
        return (ShareButtonDisplayType) a.a(ShareButtonDisplayType.class, r100);
    }

    private ShareButtonDisplayType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
