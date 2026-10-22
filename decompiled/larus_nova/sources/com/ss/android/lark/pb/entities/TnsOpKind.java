package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum TnsOpKind extends Enum<TnsOpKind> implements WireEnum {
    private static final /* synthetic */ TnsOpKind[] $VALUES = null;
    public static final ProtoAdapter<TnsOpKind> ADAPTER = null;
    public static final TnsOpKind TNS_OP_BANNED = null;
    public static final TnsOpKind TNS_OP_DISSOLVED = null;
    public static final TnsOpKind TNS_OP_NONE = null;
    private final int value;

    static {
        TnsOpKind r100 = new TnsOpKind("TNS_OP_NONE", 0, 0);
        TNS_OP_NONE = r100;
        TnsOpKind r101 = new TnsOpKind("TNS_OP_BANNED", 1, 1);
        TNS_OP_BANNED = r101;
        TnsOpKind r102 = new TnsOpKind("TNS_OP_DISSOLVED", 2, 2);
        TNS_OP_DISSOLVED = r102;
        $VALUES = new TnsOpKind[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(TnsOpKind.class);
    }

    public static TnsOpKind[] values() {
        return (TnsOpKind[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TnsOpKind fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return TNS_OP_DISSOLVED;
    L12:
        return TNS_OP_BANNED;
    L14:
        return TNS_OP_NONE;
    }

    public static TnsOpKind valueOf(String r100) {
        return (TnsOpKind) a.a(TnsOpKind.class, r100);
    }

    private TnsOpKind(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
