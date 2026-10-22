package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum BannerStyle extends Enum<BannerStyle> implements WireEnum {
    private static final /* synthetic */ BannerStyle[] $VALUES = null;
    public static final ProtoAdapter<BannerStyle> ADAPTER = null;
    public static final BannerStyle INLINE_NORMAL = null;
    public static final BannerStyle INLINE_SMALL = null;
    public static final BannerStyle TOP_INFO = null;
    public static final BannerStyle TOP_WARN = null;
    private final int value;

    static {
        BannerStyle r100 = new BannerStyle("TOP_INFO", 0, 1);
        TOP_INFO = r100;
        BannerStyle r101 = new BannerStyle("TOP_WARN", 1, 2);
        TOP_WARN = r101;
        BannerStyle r102 = new BannerStyle("INLINE_SMALL", 2, 11);
        INLINE_SMALL = r102;
        BannerStyle r103 = new BannerStyle("INLINE_NORMAL", 3, 12);
        INLINE_NORMAL = r103;
        $VALUES = new BannerStyle[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(BannerStyle.class);
    }

    public static BannerStyle[] values() {
        return (BannerStyle[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static BannerStyle fromValue(int r100) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 11) goto L15;
        if (r100 == 12) goto L13;
        return null;
    L13:
        return INLINE_NORMAL;
    L15:
        return INLINE_SMALL;
    L17:
        return TOP_WARN;
    L19:
        return TOP_INFO;
    }

    public static BannerStyle valueOf(String r100) {
        return (BannerStyle) a.a(BannerStyle.class, r100);
    }

    private BannerStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
