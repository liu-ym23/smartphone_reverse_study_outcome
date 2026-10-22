package com.bytedance.lark.pb.contact.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum UserCustomStatusDuration extends Enum<UserCustomStatusDuration> implements WireEnum {
    private static final /* synthetic */ UserCustomStatusDuration[] $VALUES = null;
    public static final ProtoAdapter<UserCustomStatusDuration> ADAPTER = null;
    public static final UserCustomStatusDuration HOUR_1 = null;
    public static final UserCustomStatusDuration HOUR_2 = null;
    public static final UserCustomStatusDuration HOUR_4 = null;
    public static final UserCustomStatusDuration MINUTES_30 = null;
    public static final UserCustomStatusDuration UNTIL_TONIGHT = null;
    private final int value;

    static {
        UserCustomStatusDuration r100 = new UserCustomStatusDuration("MINUTES_30", 0, 1);
        MINUTES_30 = r100;
        UserCustomStatusDuration r101 = new UserCustomStatusDuration("HOUR_1", 1, 2);
        HOUR_1 = r101;
        UserCustomStatusDuration r102 = new UserCustomStatusDuration("HOUR_2", 2, 3);
        HOUR_2 = r102;
        UserCustomStatusDuration r103 = new UserCustomStatusDuration("HOUR_4", 3, 4);
        HOUR_4 = r103;
        UserCustomStatusDuration r104 = new UserCustomStatusDuration("UNTIL_TONIGHT", 4, 5);
        UNTIL_TONIGHT = r104;
        $VALUES = new UserCustomStatusDuration[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserCustomStatusDuration.class);
    }

    public static UserCustomStatusDuration[] values() {
        return (UserCustomStatusDuration[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static UserCustomStatusDuration fromValue(int r100) {
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L19;
        if (r100 == 4) goto L17;
        if (r100 == 5) goto L15;
        return null;
    L15:
        return UNTIL_TONIGHT;
    L17:
        return HOUR_4;
    L19:
        return HOUR_2;
    L21:
        return HOUR_1;
    L23:
        return MINUTES_30;
    }

    public static UserCustomStatusDuration valueOf(String r100) {
        return (UserCustomStatusDuration) a.a(UserCustomStatusDuration.class, r100);
    }

    private UserCustomStatusDuration(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
