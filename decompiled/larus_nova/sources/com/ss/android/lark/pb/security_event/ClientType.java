package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ClientType extends Enum<ClientType> implements WireEnum {
    private static final /* synthetic */ ClientType[] $VALUES = null;
    public static final ProtoAdapter<ClientType> ADAPTER = null;
    public static final ClientType ClientAndroid = null;
    public static final ClientType ClientHarmonyOS = null;
    public static final ClientType ClientIOS = null;
    public static final ClientType ClientLarkPC = null;
    public static final ClientType ClientUnknown = null;
    public static final ClientType ClientWeb = null;
    private final int value;

    static {
        ClientType r100 = new ClientType("ClientUnknown", 0, 0);
        ClientUnknown = r100;
        ClientType r101 = new ClientType("ClientLarkPC", 1, 1);
        ClientLarkPC = r101;
        ClientType r102 = new ClientType("ClientAndroid", 2, 2);
        ClientAndroid = r102;
        ClientType r103 = new ClientType("ClientIOS", 3, 3);
        ClientIOS = r103;
        ClientType r104 = new ClientType("ClientWeb", 4, 4);
        ClientWeb = r104;
        ClientType r105 = new ClientType("ClientHarmonyOS", 5, 5);
        ClientHarmonyOS = r105;
        $VALUES = new ClientType[]{r100, r101, r102, r103, r104, r105};
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
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 == 5) goto L16;
        return null;
    L16:
        return ClientHarmonyOS;
    L18:
        return ClientWeb;
    L20:
        return ClientIOS;
    L22:
        return ClientAndroid;
    L24:
        return ClientLarkPC;
    L26:
        return ClientUnknown;
    }

    public static ClientType valueOf(String r100) {
        return (ClientType) a.a(ClientType.class, r100);
    }

    private ClientType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
