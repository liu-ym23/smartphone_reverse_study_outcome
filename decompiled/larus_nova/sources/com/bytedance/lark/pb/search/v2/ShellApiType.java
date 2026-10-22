package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ShellApiType extends Enum<ShellApiType> implements WireEnum {
    private static final /* synthetic */ ShellApiType[] $VALUES = null;
    public static final ProtoAdapter<ShellApiType> ADAPTER = null;
    public static final ShellApiType OpenWindow = null;
    private final int value;

    static {
        ShellApiType r100 = new ShellApiType("OpenWindow", 0, 1);
        OpenWindow = r100;
        $VALUES = new ShellApiType[]{r100};
        ADAPTER = ProtoAdapter.newEnumAdapter(ShellApiType.class);
    }

    public static ShellApiType[] values() {
        return (ShellApiType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ShellApiType fromValue(int r100) {
        if (r100 == 1) goto L7;
        return null;
    L7:
        return OpenWindow;
    }

    public static ShellApiType valueOf(String r100) {
        return (ShellApiType) a.a(ShellApiType.class, r100);
    }

    private ShellApiType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
