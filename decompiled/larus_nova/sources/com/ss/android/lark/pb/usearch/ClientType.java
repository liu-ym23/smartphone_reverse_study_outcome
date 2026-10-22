package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ClientType extends Enum<ClientType> implements WireEnum {
    private static final /* synthetic */ ClientType[] $VALUES = null;
    public static final ProtoAdapter<ClientType> ADAPTER = null;
    public static final ClientType ANDROID = null;
    public static final ClientType HARMONY = null;
    public static final ClientType IOS = null;
    public static final ClientType UNKNOWN_CLIENT_TYPE = null;
    public static final ClientType WEB = null;
    private final int value;

    static {
        ClientType r100 = new ClientType("UNKNOWN_CLIENT_TYPE", 0, 0);
        UNKNOWN_CLIENT_TYPE = r100;
        ClientType r101 = new ClientType("WEB", 1, 1);
        WEB = r101;
        ClientType r102 = new ClientType("ANDROID", 2, 2);
        ANDROID = r102;
        ClientType r103 = new ClientType("IOS", 3, 3);
        IOS = r103;
        ClientType r104 = new ClientType("HARMONY", 4, 4);
        HARMONY = r104;
        $VALUES = new ClientType[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(ClientType.class);
    }

    public static ClientType[] values() {
        return (ClientType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ClientType fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return HARMONY;
    L16:
        return IOS;
    L18:
        return ANDROID;
    L20:
        return WEB;
    L22:
        return UNKNOWN_CLIENT_TYPE;
    }

    public static ClientType valueOf(String r100) {
        return (ClientType) a.a(ClientType.class, r100);
    }

    private ClientType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
