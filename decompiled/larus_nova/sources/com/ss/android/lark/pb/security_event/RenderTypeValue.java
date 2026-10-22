package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum RenderTypeValue extends Enum<RenderTypeValue> implements WireEnum {
    private static final /* synthetic */ RenderTypeValue[] $VALUES = null;
    public static final ProtoAdapter<RenderTypeValue> ADAPTER = null;
    public static final RenderTypeValue CopyText = null;
    public static final RenderTypeValue PlainText = null;
    public static final RenderTypeValue TimeText = null;
    private final int value;

    static {
        RenderTypeValue r100 = new RenderTypeValue("PlainText", 0, 1);
        PlainText = r100;
        RenderTypeValue r101 = new RenderTypeValue("CopyText", 1, 2);
        CopyText = r101;
        RenderTypeValue r102 = new RenderTypeValue("TimeText", 2, 3);
        TimeText = r102;
        $VALUES = new RenderTypeValue[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(RenderTypeValue.class);
    }

    public static RenderTypeValue[] values() {
        return (RenderTypeValue[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static RenderTypeValue fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return TimeText;
    L13:
        return CopyText;
    L15:
        return PlainText;
    }

    public static RenderTypeValue valueOf(String r100) {
        return (RenderTypeValue) a.a(RenderTypeValue.class, r100);
    }

    private RenderTypeValue(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
