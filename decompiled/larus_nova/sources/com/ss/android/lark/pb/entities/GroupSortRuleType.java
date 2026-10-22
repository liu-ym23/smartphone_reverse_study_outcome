package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum GroupSortRuleType extends Enum<GroupSortRuleType> implements WireEnum {
    private static final /* synthetic */ GroupSortRuleType[] $VALUES = null;
    public static final ProtoAdapter<GroupSortRuleType> ADAPTER = null;
    public static final GroupSortRuleType GROUP_CREATE_TIME = null;
    public static final GroupSortRuleType GROUP_DEFAULT_SORT = null;
    public static final GroupSortRuleType GROUP_NUM_MEMBERS = null;
    public static final GroupSortRuleType GROUP_UPDATE_TIME = null;
    private final int value;

    static {
        GroupSortRuleType r100 = new GroupSortRuleType("GROUP_DEFAULT_SORT", 0, 1);
        GROUP_DEFAULT_SORT = r100;
        GroupSortRuleType r101 = new GroupSortRuleType("GROUP_UPDATE_TIME", 1, 2);
        GROUP_UPDATE_TIME = r101;
        GroupSortRuleType r102 = new GroupSortRuleType("GROUP_CREATE_TIME", 2, 3);
        GROUP_CREATE_TIME = r102;
        GroupSortRuleType r103 = new GroupSortRuleType("GROUP_NUM_MEMBERS", 3, 4);
        GROUP_NUM_MEMBERS = r103;
        $VALUES = new GroupSortRuleType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(GroupSortRuleType.class);
    }

    public static GroupSortRuleType[] values() {
        return (GroupSortRuleType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static GroupSortRuleType fromValue(int r100) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        return null;
    L13:
        return GROUP_NUM_MEMBERS;
    L15:
        return GROUP_CREATE_TIME;
    L17:
        return GROUP_UPDATE_TIME;
    L19:
        return GROUP_DEFAULT_SORT;
    }

    public static GroupSortRuleType valueOf(String r100) {
        return (GroupSortRuleType) a.a(GroupSortRuleType.class, r100);
    }

    private GroupSortRuleType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
