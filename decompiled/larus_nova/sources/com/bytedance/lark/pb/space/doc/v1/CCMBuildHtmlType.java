package com.bytedance.lark.pb.space.doc.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum CCMBuildHtmlType extends Enum<CCMBuildHtmlType> implements WireEnum {
    private static final /* synthetic */ CCMBuildHtmlType[] $VALUES = null;
    public static final ProtoAdapter<CCMBuildHtmlType> ADAPTER = null;
    public static final CCMBuildHtmlType BaseAndSheet = null;
    private final int value;

    static {
        CCMBuildHtmlType r100 = new CCMBuildHtmlType("BaseAndSheet", 0, 0);
        BaseAndSheet = r100;
        $VALUES = new CCMBuildHtmlType[]{r100};
        ADAPTER = ProtoAdapter.newEnumAdapter(CCMBuildHtmlType.class);
    }

    public static CCMBuildHtmlType[] values() {
        return (CCMBuildHtmlType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static CCMBuildHtmlType fromValue(int r100) {
        if (r100 == 0) goto L6;
        return null;
    L6:
        return BaseAndSheet;
    }

    public static CCMBuildHtmlType valueOf(String r100) {
        return (CCMBuildHtmlType) a.a(CCMBuildHtmlType.class, r100);
    }

    private CCMBuildHtmlType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
