package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ContentAlignType extends Enum<ContentAlignType> implements WireEnum {
    private static final /* synthetic */ ContentAlignType[] $VALUES = null;
    public static final ProtoAdapter<ContentAlignType> ADAPTER = null;
    public static final ContentAlignType ContentAlignType_BOTTOM = null;
    public static final ContentAlignType ContentAlignType_MIDDLE = null;
    public static final ContentAlignType ContentAlignType_TOP = null;
    private final int value;

    static {
        ContentAlignType r100 = new ContentAlignType("ContentAlignType_TOP", 0, 1);
        ContentAlignType_TOP = r100;
        ContentAlignType r101 = new ContentAlignType("ContentAlignType_MIDDLE", 1, 2);
        ContentAlignType_MIDDLE = r101;
        ContentAlignType r102 = new ContentAlignType("ContentAlignType_BOTTOM", 2, 3);
        ContentAlignType_BOTTOM = r102;
        $VALUES = new ContentAlignType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(ContentAlignType.class);
    }

    public static ContentAlignType[] values() {
        return (ContentAlignType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ContentAlignType fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return ContentAlignType_BOTTOM;
    L13:
        return ContentAlignType_MIDDLE;
    L15:
        return ContentAlignType_TOP;
    }

    public static ContentAlignType valueOf(String r100) {
        return (ContentAlignType) a.a(ContentAlignType.class, r100);
    }

    private ContentAlignType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
