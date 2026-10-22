package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ExtensionMode extends Enum<ExtensionMode> implements WireEnum {
    private static final /* synthetic */ ExtensionMode[] $VALUES = null;
    public static final ProtoAdapter<ExtensionMode> ADAPTER = null;
    public static final ExtensionMode MULTI = null;
    public static final ExtensionMode SINGLE = null;
    private final int value;

    static {
        ExtensionMode r100 = new ExtensionMode("SINGLE", 0, 0);
        SINGLE = r100;
        ExtensionMode r101 = new ExtensionMode("MULTI", 1, 1);
        MULTI = r101;
        $VALUES = new ExtensionMode[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(ExtensionMode.class);
    }

    public static ExtensionMode[] values() {
        return (ExtensionMode[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ExtensionMode fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return MULTI;
    L10:
        return SINGLE;
    }

    public static ExtensionMode valueOf(String r100) {
        return (ExtensionMode) a.a(ExtensionMode.class, r100);
    }

    private ExtensionMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
