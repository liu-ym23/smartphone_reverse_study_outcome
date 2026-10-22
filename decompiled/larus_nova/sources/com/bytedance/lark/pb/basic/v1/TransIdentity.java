package com.bytedance.lark.pb.basic.v1;

import com.larus.dora.api.model.FlowDoraWifiScene;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum TransIdentity extends Enum<TransIdentity> implements WireEnum {
    private static final /* synthetic */ TransIdentity[] $VALUES = null;
    public static final ProtoAdapter<TransIdentity> ADAPTER = null;
    public static final TransIdentity OTHER = null;
    public static final TransIdentity RECEIVER = null;
    public static final TransIdentity SENDER = null;
    public static final TransIdentity WAITING_RECEIVER = null;
    private final int value;

    static {
        TransIdentity r100 = new TransIdentity(FlowDoraWifiScene.OTHER, 0, 0);
        OTHER = r100;
        TransIdentity r101 = new TransIdentity("SENDER", 1, 1);
        SENDER = r101;
        TransIdentity r102 = new TransIdentity("RECEIVER", 2, 2);
        RECEIVER = r102;
        TransIdentity r103 = new TransIdentity("WAITING_RECEIVER", 3, 3);
        WAITING_RECEIVER = r103;
        $VALUES = new TransIdentity[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(TransIdentity.class);
    }

    public static TransIdentity[] values() {
        return (TransIdentity[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TransIdentity fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return WAITING_RECEIVER;
    L14:
        return RECEIVER;
    L16:
        return SENDER;
    L18:
        return OTHER;
    }

    public static TransIdentity valueOf(String r100) {
        return (TransIdentity) a.a(TransIdentity.class, r100);
    }

    private TransIdentity(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
