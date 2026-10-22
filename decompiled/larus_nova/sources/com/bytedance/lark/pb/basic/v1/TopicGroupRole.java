package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum TopicGroupRole extends Enum<TopicGroupRole> implements WireEnum {
    private static final /* synthetic */ TopicGroupRole[] $VALUES = null;
    public static final ProtoAdapter<TopicGroupRole> ADAPTER = null;
    public static final TopicGroupRole MEMBER = null;
    public static final TopicGroupRole PARTICIPANT = null;
    public static final TopicGroupRole UNAUTHORIZED_USER = null;
    public static final TopicGroupRole UNKNOWN_ROLE = null;
    private final int value;

    static {
        TopicGroupRole r100 = new TopicGroupRole("UNKNOWN_ROLE", 0, 0);
        UNKNOWN_ROLE = r100;
        TopicGroupRole r101 = new TopicGroupRole("UNAUTHORIZED_USER", 1, 1);
        UNAUTHORIZED_USER = r101;
        TopicGroupRole r102 = new TopicGroupRole("MEMBER", 2, 2);
        MEMBER = r102;
        TopicGroupRole r103 = new TopicGroupRole("PARTICIPANT", 3, 3);
        PARTICIPANT = r103;
        $VALUES = new TopicGroupRole[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(TopicGroupRole.class);
    }

    public static TopicGroupRole[] values() {
        return (TopicGroupRole[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TopicGroupRole fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return PARTICIPANT;
    L14:
        return MEMBER;
    L16:
        return UNAUTHORIZED_USER;
    L18:
        return UNKNOWN_ROLE;
    }

    public static TopicGroupRole valueOf(String r100) {
        return (TopicGroupRole) a.a(TopicGroupRole.class, r100);
    }

    private TopicGroupRole(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
