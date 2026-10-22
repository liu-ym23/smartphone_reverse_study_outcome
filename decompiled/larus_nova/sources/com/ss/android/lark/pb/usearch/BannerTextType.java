package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum BannerTextType extends Enum<BannerTextType> implements WireEnum {
    private static final /* synthetic */ BannerTextType[] $VALUES = null;
    public static final ProtoAdapter<BannerTextType> ADAPTER = null;
    public static final BannerTextType CLICKABLE = null;
    public static final BannerTextType IMPORTANT = null;
    public static final BannerTextType INFO = null;
    private final int value;

    static {
        BannerTextType r100 = new BannerTextType("IMPORTANT", 0, 1);
        IMPORTANT = r100;
        BannerTextType r101 = new BannerTextType("INFO", 1, 2);
        INFO = r101;
        BannerTextType r102 = new BannerTextType("CLICKABLE", 2, 3);
        CLICKABLE = r102;
        $VALUES = new BannerTextType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(BannerTextType.class);
    }

    public static BannerTextType[] values() {
        return (BannerTextType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static BannerTextType fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return CLICKABLE;
    L13:
        return INFO;
    L15:
        return IMPORTANT;
    }

    public static BannerTextType valueOf(String r100) {
        return (BannerTextType) a.a(BannerTextType.class, r100);
    }

    private BannerTextType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
