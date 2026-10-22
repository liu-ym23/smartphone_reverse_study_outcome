package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum EmptyStateType extends Enum<EmptyStateType> implements WireEnum {
    private static final /* synthetic */ EmptyStateType[] $VALUES = null;
    public static final ProtoAdapter<EmptyStateType> ADAPTER = null;
    public static final EmptyStateType EMPTY_STATE_GET_MATERIALS = null;
    public static final EmptyStateType EMPTY_STATE_REPORT_DISPLAY = null;
    public static final EmptyStateType EMPTY_STATE_SEND_SUMMARY = null;
    public static final EmptyStateType EMPTY_STATE_UNKNOWN = null;
    private final int value;

    static {
        EmptyStateType r100 = new EmptyStateType("EMPTY_STATE_UNKNOWN", 0, 0);
        EMPTY_STATE_UNKNOWN = r100;
        EmptyStateType r101 = new EmptyStateType("EMPTY_STATE_GET_MATERIALS", 1, 1);
        EMPTY_STATE_GET_MATERIALS = r101;
        EmptyStateType r102 = new EmptyStateType("EMPTY_STATE_REPORT_DISPLAY", 2, 2);
        EMPTY_STATE_REPORT_DISPLAY = r102;
        EmptyStateType r103 = new EmptyStateType("EMPTY_STATE_SEND_SUMMARY", 3, 3);
        EMPTY_STATE_SEND_SUMMARY = r103;
        $VALUES = new EmptyStateType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(EmptyStateType.class);
    }

    public static EmptyStateType[] values() {
        return (EmptyStateType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static EmptyStateType fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return EMPTY_STATE_SEND_SUMMARY;
    L14:
        return EMPTY_STATE_REPORT_DISPLAY;
    L16:
        return EMPTY_STATE_GET_MATERIALS;
    L18:
        return EMPTY_STATE_UNKNOWN;
    }

    public static EmptyStateType valueOf(String r100) {
        return (EmptyStateType) a.a(EmptyStateType.class, r100);
    }

    private EmptyStateType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
