package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum SugRichTextType extends Enum<SugRichTextType> implements WireEnum {
    private static final /* synthetic */ SugRichTextType[] $VALUES = null;
    public static final ProtoAdapter<SugRichTextType> ADAPTER = null;
    public static final SugRichTextType MESSAGE_FILTER_SUG = null;
    public static final SugRichTextType TAB_SUG = null;
    public static final SugRichTextType UNKNOWN_SUG = null;
    public static final SugRichTextType USER_SUG = null;
    private final int value;

    static {
        SugRichTextType r100 = new SugRichTextType("UNKNOWN_SUG", 0, 0);
        UNKNOWN_SUG = r100;
        SugRichTextType r101 = new SugRichTextType("USER_SUG", 1, 1);
        USER_SUG = r101;
        SugRichTextType r102 = new SugRichTextType("TAB_SUG", 2, 2);
        TAB_SUG = r102;
        SugRichTextType r103 = new SugRichTextType("MESSAGE_FILTER_SUG", 3, 3);
        MESSAGE_FILTER_SUG = r103;
        $VALUES = new SugRichTextType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(SugRichTextType.class);
    }

    public static SugRichTextType[] values() {
        return (SugRichTextType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SugRichTextType fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return MESSAGE_FILTER_SUG;
    L14:
        return TAB_SUG;
    L16:
        return USER_SUG;
    L18:
        return UNKNOWN_SUG;
    }

    public static SugRichTextType valueOf(String r100) {
        return (SugRichTextType) a.a(SugRichTextType.class, r100);
    }

    private SugRichTextType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
