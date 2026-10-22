package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum EntityStatus extends Enum<EntityStatus> implements WireEnum {
    private static final /* synthetic */ EntityStatus[] $VALUES = null;
    public static final ProtoAdapter<EntityStatus> ADAPTER = null;
    public static final EntityStatus FAILED = null;
    public static final EntityStatus NORMAL = null;
    public static final EntityStatus PENDING = null;
    public static final EntityStatus READ = null;
    public static final EntityStatus UNREAD = null;
    private final int value;

    static {
        EntityStatus r100 = new EntityStatus(EffectConstants.NORMAL, 0, 1);
        NORMAL = r100;
        EntityStatus r101 = new EntityStatus("PENDING", 1, 2);
        PENDING = r101;
        EntityStatus r102 = new EntityStatus("FAILED", 2, 3);
        FAILED = r102;
        EntityStatus r103 = new EntityStatus("READ", 3, 4);
        READ = r103;
        EntityStatus r104 = new EntityStatus("UNREAD", 4, 5);
        UNREAD = r104;
        $VALUES = new EntityStatus[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(EntityStatus.class);
    }

    public static EntityStatus[] values() {
        return (EntityStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static EntityStatus fromValue(int r100) {
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L19;
        if (r100 == 4) goto L17;
        if (r100 == 5) goto L15;
        return null;
    L15:
        return UNREAD;
    L17:
        return READ;
    L19:
        return FAILED;
    L21:
        return PENDING;
    L23:
        return NORMAL;
    }

    public static EntityStatus valueOf(String r100) {
        return (EntityStatus) a.a(EntityStatus.class, r100);
    }

    private EntityStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
