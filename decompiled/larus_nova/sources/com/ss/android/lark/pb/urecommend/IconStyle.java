package com.ss.android.lark.pb.urecommend;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum IconStyle extends Enum<IconStyle> implements WireEnum {
    private static final /* synthetic */ IconStyle[] $VALUES = null;
    public static final ProtoAdapter<IconStyle> ADAPTER = null;
    public static final IconStyle CIRCLE = null;
    public static final IconStyle RECTANGLE = null;
    private final int value;

    static {
        IconStyle r100 = new IconStyle("RECTANGLE", 0, 0);
        RECTANGLE = r100;
        IconStyle r101 = new IconStyle("CIRCLE", 1, 1);
        CIRCLE = r101;
        $VALUES = new IconStyle[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(IconStyle.class);
    }

    public static IconStyle[] values() {
        return (IconStyle[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static IconStyle fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return CIRCLE;
    L10:
        return RECTANGLE;
    }

    public static IconStyle valueOf(String r100) {
        return (IconStyle) a.a(IconStyle.class, r100);
    }

    private IconStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
