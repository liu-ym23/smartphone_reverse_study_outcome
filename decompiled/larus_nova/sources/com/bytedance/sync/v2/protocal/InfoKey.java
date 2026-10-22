package com.bytedance.sync.v2.protocal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes3.dex */
public final enum InfoKey extends Enum<InfoKey> implements WireEnum {
    private static final /* synthetic */ InfoKey[] $VALUES = null;
    public static final ProtoAdapter<InfoKey> ADAPTER = null;
    public static final InfoKey CustomParams = null;
    public static final InfoKey ErrCode = null;
    public static final InfoKey ErrMsg = null;
    public static final InfoKey Params = null;
    private final int value;

    static {
        InfoKey r100 = new InfoKey("Params", 0, 0);
        Params = r100;
        InfoKey r101 = new InfoKey("CustomParams", 1, 1);
        CustomParams = r101;
        InfoKey r102 = new InfoKey("ErrCode", 2, 100);
        ErrCode = r102;
        InfoKey r103 = new InfoKey("ErrMsg", 3, 101);
        ErrMsg = r103;
        $VALUES = new InfoKey[]{r100, r101, r102, r103};
        ADAPTER = new ProtoAdapter_InfoKey();
    }

    public static InfoKey[] values() {
        return (InfoKey[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }

    public static InfoKey fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 100) goto L14;
        if (r100 == 101) goto L12;
        return null;
    L12:
        return ErrMsg;
    L14:
        return ErrCode;
    L16:
        return CustomParams;
    L18:
        return Params;
    }

    public static InfoKey valueOf(String r100) {
        return (InfoKey) r27.a.a(InfoKey.class, r100);
    }

    private InfoKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
