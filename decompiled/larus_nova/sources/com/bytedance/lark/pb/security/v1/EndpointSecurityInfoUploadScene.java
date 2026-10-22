package com.bytedance.lark.pb.security.v1;

import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum EndpointSecurityInfoUploadScene extends Enum<EndpointSecurityInfoUploadScene> implements WireEnum {
    private static final /* synthetic */ EndpointSecurityInfoUploadScene[] $VALUES = null;
    public static final ProtoAdapter<EndpointSecurityInfoUploadScene> ADAPTER = null;
    public static final EndpointSecurityInfoUploadScene BLOCKED = null;
    public static final EndpointSecurityInfoUploadScene ENV_CHANGED = null;
    public static final EndpointSecurityInfoUploadScene SYNC = null;
    private final int value;

    static {
        EndpointSecurityInfoUploadScene r100 = new EndpointSecurityInfoUploadScene(BridgeSyncType.SYNC, 0, 1);
        SYNC = r100;
        EndpointSecurityInfoUploadScene r101 = new EndpointSecurityInfoUploadScene("ENV_CHANGED", 1, 2);
        ENV_CHANGED = r101;
        EndpointSecurityInfoUploadScene r102 = new EndpointSecurityInfoUploadScene("BLOCKED", 2, 3);
        BLOCKED = r102;
        $VALUES = new EndpointSecurityInfoUploadScene[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(EndpointSecurityInfoUploadScene.class);
    }

    public static EndpointSecurityInfoUploadScene[] values() {
        return (EndpointSecurityInfoUploadScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static EndpointSecurityInfoUploadScene fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return BLOCKED;
    L13:
        return ENV_CHANGED;
    L15:
        return SYNC;
    }

    public static EndpointSecurityInfoUploadScene valueOf(String r100) {
        return (EndpointSecurityInfoUploadScene) a.a(EndpointSecurityInfoUploadScene.class, r100);
    }

    private EndpointSecurityInfoUploadScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
