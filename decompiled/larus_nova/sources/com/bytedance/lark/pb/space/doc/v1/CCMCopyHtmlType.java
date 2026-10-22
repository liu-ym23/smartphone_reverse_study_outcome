package com.bytedance.lark.pb.space.doc.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum CCMCopyHtmlType extends Enum<CCMCopyHtmlType> implements WireEnum {
    private static final /* synthetic */ CCMCopyHtmlType[] $VALUES = null;
    public static final ProtoAdapter<CCMCopyHtmlType> ADAPTER = null;
    public static final CCMCopyHtmlType Docx = null;
    public static final CCMCopyHtmlType Sheet = null;
    public static final CCMCopyHtmlType Unknown = null;
    private final int value;

    static {
        CCMCopyHtmlType r100 = new CCMCopyHtmlType("Unknown", 0, 0);
        Unknown = r100;
        CCMCopyHtmlType r101 = new CCMCopyHtmlType("Sheet", 1, 1);
        Sheet = r101;
        CCMCopyHtmlType r102 = new CCMCopyHtmlType("Docx", 2, 2);
        Docx = r102;
        $VALUES = new CCMCopyHtmlType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(CCMCopyHtmlType.class);
    }

    public static CCMCopyHtmlType[] values() {
        return (CCMCopyHtmlType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static CCMCopyHtmlType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return Docx;
    L12:
        return Sheet;
    L14:
        return Unknown;
    }

    public static CCMCopyHtmlType valueOf(String r100) {
        return (CCMCopyHtmlType) a.a(CCMCopyHtmlType.class, r100);
    }

    private CCMCopyHtmlType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
