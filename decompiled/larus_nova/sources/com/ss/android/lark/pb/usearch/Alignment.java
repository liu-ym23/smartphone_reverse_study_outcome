package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum Alignment extends Enum<Alignment> implements WireEnum {
    private static final /* synthetic */ Alignment[] $VALUES = null;
    public static final ProtoAdapter<Alignment> ADAPTER = null;
    public static final Alignment Center = null;
    public static final Alignment Left = null;
    public static final Alignment Right = null;
    private final int value;

    static {
        Alignment r100 = new Alignment("Left", 0, 0);
        Left = r100;
        Alignment r101 = new Alignment("Right", 1, 1);
        Right = r101;
        Alignment r102 = new Alignment("Center", 2, 2);
        Center = r102;
        $VALUES = new Alignment[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(Alignment.class);
    }

    public static Alignment[] values() {
        return (Alignment[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static Alignment fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return Center;
    L12:
        return Right;
    L14:
        return Left;
    }

    public static Alignment valueOf(String r100) {
        return (Alignment) a.a(Alignment.class, r100);
    }

    private Alignment(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
