package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum SyncStrategy extends Enum<SyncStrategy> implements WireEnum {
    private static final /* synthetic */ SyncStrategy[] $VALUES = null;
    public static final ProtoAdapter<SyncStrategy> ADAPTER = null;
    public static final SyncStrategy OldThenTrigger = null;
    public static final SyncStrategy Sync = null;
    private final int value;

    static {
        SyncStrategy r100 = new SyncStrategy("Sync", 0, 0);
        Sync = r100;
        SyncStrategy r101 = new SyncStrategy("OldThenTrigger", 1, 1);
        OldThenTrigger = r101;
        $VALUES = new SyncStrategy[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(SyncStrategy.class);
    }

    public static SyncStrategy[] values() {
        return (SyncStrategy[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SyncStrategy fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return OldThenTrigger;
    L10:
        return Sync;
    }

    public static SyncStrategy valueOf(String r100) {
        return (SyncStrategy) a.a(SyncStrategy.class, r100);
    }

    private SyncStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
