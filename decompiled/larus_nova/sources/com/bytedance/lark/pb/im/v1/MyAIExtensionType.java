package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum MyAIExtensionType extends Enum<MyAIExtensionType> implements WireEnum {
    private static final /* synthetic */ MyAIExtensionType[] $VALUES = null;
    public static final ProtoAdapter<MyAIExtensionType> ADAPTER = null;
    public static final MyAIExtensionType ExtensionTypeCustom = null;
    public static final MyAIExtensionType ExtensionTypeQA = null;
    private final int value;

    static {
        MyAIExtensionType r100 = new MyAIExtensionType("ExtensionTypeQA", 0, 1);
        ExtensionTypeQA = r100;
        MyAIExtensionType r101 = new MyAIExtensionType("ExtensionTypeCustom", 1, 2);
        ExtensionTypeCustom = r101;
        $VALUES = new MyAIExtensionType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(MyAIExtensionType.class);
    }

    public static MyAIExtensionType[] values() {
        return (MyAIExtensionType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static MyAIExtensionType fromValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return ExtensionTypeCustom;
    L11:
        return ExtensionTypeQA;
    }

    public static MyAIExtensionType valueOf(String r100) {
        return (MyAIExtensionType) a.a(MyAIExtensionType.class, r100);
    }

    private MyAIExtensionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
