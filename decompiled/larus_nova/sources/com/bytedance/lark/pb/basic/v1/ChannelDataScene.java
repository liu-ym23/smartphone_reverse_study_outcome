package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ChannelDataScene extends Enum<ChannelDataScene> implements WireEnum {
    private static final /* synthetic */ ChannelDataScene[] $VALUES = null;
    public static final ProtoAdapter<ChannelDataScene> ADAPTER = null;
    public static final ChannelDataScene FIRST_SCREEN = null;
    public static final ChannelDataScene NEXT_PAGE = null;
    public static final ChannelDataScene PREVIOUS_PAGE = null;
    public static final ChannelDataScene SPECIFIED_POSITION = null;
    private final int value;

    static {
        ChannelDataScene r100 = new ChannelDataScene("FIRST_SCREEN", 0, 1);
        FIRST_SCREEN = r100;
        ChannelDataScene r101 = new ChannelDataScene("SPECIFIED_POSITION", 1, 2);
        SPECIFIED_POSITION = r101;
        ChannelDataScene r102 = new ChannelDataScene("PREVIOUS_PAGE", 2, 3);
        PREVIOUS_PAGE = r102;
        ChannelDataScene r103 = new ChannelDataScene("NEXT_PAGE", 3, 4);
        NEXT_PAGE = r103;
        $VALUES = new ChannelDataScene[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChannelDataScene.class);
    }

    public static ChannelDataScene[] values() {
        return (ChannelDataScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ChannelDataScene fromValue(int r100) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        return null;
    L13:
        return NEXT_PAGE;
    L15:
        return PREVIOUS_PAGE;
    L17:
        return SPECIFIED_POSITION;
    L19:
        return FIRST_SCREEN;
    }

    public static ChannelDataScene valueOf(String r100) {
        return (ChannelDataScene) a.a(ChannelDataScene.class, r100);
    }

    private ChannelDataScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
