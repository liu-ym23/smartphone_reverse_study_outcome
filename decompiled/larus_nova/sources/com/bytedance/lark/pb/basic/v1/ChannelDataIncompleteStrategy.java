package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ChannelDataIncompleteStrategy extends Enum<ChannelDataIncompleteStrategy> implements WireEnum {
    private static final /* synthetic */ ChannelDataIncompleteStrategy[] $VALUES = null;
    public static final ProtoAdapter<ChannelDataIncompleteStrategy> ADAPTER = null;
    public static final ChannelDataIncompleteStrategy IGNORE_LOCAL_DATA = null;
    public static final ChannelDataIncompleteStrategy RETURN_LOCAL_DATA = null;
    public static final ChannelDataIncompleteStrategy SYNC_SERVER_DATA = null;
    private final int value;

    static {
        ChannelDataIncompleteStrategy r100 = new ChannelDataIncompleteStrategy("IGNORE_LOCAL_DATA", 0, 1);
        IGNORE_LOCAL_DATA = r100;
        ChannelDataIncompleteStrategy r101 = new ChannelDataIncompleteStrategy("RETURN_LOCAL_DATA", 1, 2);
        RETURN_LOCAL_DATA = r101;
        ChannelDataIncompleteStrategy r102 = new ChannelDataIncompleteStrategy("SYNC_SERVER_DATA", 2, 3);
        SYNC_SERVER_DATA = r102;
        $VALUES = new ChannelDataIncompleteStrategy[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChannelDataIncompleteStrategy.class);
    }

    public static ChannelDataIncompleteStrategy[] values() {
        return (ChannelDataIncompleteStrategy[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ChannelDataIncompleteStrategy fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return SYNC_SERVER_DATA;
    L13:
        return RETURN_LOCAL_DATA;
    L15:
        return IGNORE_LOCAL_DATA;
    }

    public static ChannelDataIncompleteStrategy valueOf(String r100) {
        return (ChannelDataIncompleteStrategy) a.a(ChannelDataIncompleteStrategy.class, r100);
    }

    private ChannelDataIncompleteStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
