package com.bytedance.lark.pb.settings.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum BadgeStyle extends Enum<BadgeStyle> implements WireEnum {
    private static final /* synthetic */ BadgeStyle[] $VALUES = null;
    public static final ProtoAdapter<BadgeStyle> ADAPTER = null;
    public static final BadgeStyle STRONG_REMIND = null;
    public static final BadgeStyle WEAK_REMIND = null;
    private final int value;

    static {
        BadgeStyle r100 = new BadgeStyle("WEAK_REMIND", 0, 1);
        WEAK_REMIND = r100;
        BadgeStyle r101 = new BadgeStyle("STRONG_REMIND", 1, 2);
        STRONG_REMIND = r101;
        $VALUES = new BadgeStyle[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(BadgeStyle.class);
    }

    public static BadgeStyle[] values() {
        return (BadgeStyle[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static BadgeStyle fromValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return STRONG_REMIND;
    L11:
        return WEAK_REMIND;
    }

    public static BadgeStyle valueOf(String r100) {
        return (BadgeStyle) a.a(BadgeStyle.class, r100);
    }

    private BadgeStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
