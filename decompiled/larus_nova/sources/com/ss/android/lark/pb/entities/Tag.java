package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum Tag extends Enum<Tag> implements WireEnum {
    private static final /* synthetic */ Tag[] $VALUES = null;
    public static final ProtoAdapter<Tag> ADAPTER = null;
    public static final Tag APPROVAL = null;
    public static final Tag EXTERNAL = null;
    public static final Tag EXTERNAL_WARN = null;
    public static final Tag OFFICIAL = null;
    public static final Tag ONCALL = null;
    public static final Tag ONCALL_OFFLINE = null;
    public static final Tag UNKNOWN_TAG = null;
    private final int value;

    static {
        Tag r100 = new Tag("UNKNOWN_TAG", 0, 0);
        UNKNOWN_TAG = r100;
        Tag r101 = new Tag("APPROVAL", 1, 1);
        APPROVAL = r101;
        Tag r102 = new Tag("OFFICIAL", 2, 2);
        OFFICIAL = r102;
        Tag r103 = new Tag("ONCALL", 3, 3);
        ONCALL = r103;
        Tag r104 = new Tag("ONCALL_OFFLINE", 4, 4);
        ONCALL_OFFLINE = r104;
        Tag r105 = new Tag("EXTERNAL", 5, 5);
        EXTERNAL = r105;
        Tag r110 = new Tag("EXTERNAL_WARN", 6, 6);
        EXTERNAL_WARN = r110;
        $VALUES = new Tag[]{r100, r101, r102, r103, r104, r105, r110};
        ADAPTER = ProtoAdapter.newEnumAdapter(Tag.class);
    }

    public static Tag[] values() {
        return (Tag[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static Tag fromValue(int r100) {
        switch(r100) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return EXTERNAL_WARN;
    L8:
        return EXTERNAL;
    L10:
        return ONCALL_OFFLINE;
    L12:
        return ONCALL;
    L14:
        return OFFICIAL;
    L16:
        return APPROVAL;
    L18:
        return UNKNOWN_TAG;
    }

    public static Tag valueOf(String r100) {
        return (Tag) a.a(Tag.class, r100);
    }

    private Tag(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
