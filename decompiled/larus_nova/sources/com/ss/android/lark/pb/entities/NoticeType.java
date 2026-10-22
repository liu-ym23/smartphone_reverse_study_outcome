package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum NoticeType extends Enum<NoticeType> implements WireEnum {
    private static final /* synthetic */ NoticeType[] $VALUES = null;
    public static final ProtoAdapter<NoticeType> ADAPTER = null;
    public static final NoticeType DIGITAL_NOTICE = null;
    public static final NoticeType Notice_default = null;
    public static final NoticeType RED_DOT_NOTICE = null;
    private final int value;

    static {
        NoticeType r100 = new NoticeType("Notice_default", 0, 0);
        Notice_default = r100;
        NoticeType r101 = new NoticeType("DIGITAL_NOTICE", 1, 1);
        DIGITAL_NOTICE = r101;
        NoticeType r102 = new NoticeType("RED_DOT_NOTICE", 2, 2);
        RED_DOT_NOTICE = r102;
        $VALUES = new NoticeType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(NoticeType.class);
    }

    public static NoticeType[] values() {
        return (NoticeType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static NoticeType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return RED_DOT_NOTICE;
    L12:
        return DIGITAL_NOTICE;
    L14:
        return Notice_default;
    }

    public static NoticeType valueOf(String r100) {
        return (NoticeType) a.a(NoticeType.class, r100);
    }

    private NoticeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
