package com.ss.android.lark.pb.videochat;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum SIBizScene extends Enum<SIBizScene> implements WireEnum {
    private static final /* synthetic */ SIBizScene[] $VALUES = null;
    public static final ProtoAdapter<SIBizScene> ADAPTER = null;
    public static final SIBizScene INDEPENDENT = null;
    public static final SIBizScene MEETING = null;
    public static final SIBizScene MINUTES = null;
    private final int value;

    static {
        SIBizScene r100 = new SIBizScene("MEETING", 0, 0);
        MEETING = r100;
        SIBizScene r101 = new SIBizScene("MINUTES", 1, 1);
        MINUTES = r101;
        SIBizScene r102 = new SIBizScene("INDEPENDENT", 2, 2);
        INDEPENDENT = r102;
        $VALUES = new SIBizScene[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(SIBizScene.class);
    }

    public static SIBizScene[] values() {
        return (SIBizScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SIBizScene fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return INDEPENDENT;
    L12:
        return MINUTES;
    L14:
        return MEETING;
    }

    public static SIBizScene valueOf(String r100) {
        return (SIBizScene) a.a(SIBizScene.class, r100);
    }

    private SIBizScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
