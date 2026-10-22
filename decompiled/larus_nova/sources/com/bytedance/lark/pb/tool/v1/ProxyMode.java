package com.bytedance.lark.pb.tool.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ProxyMode extends Enum<ProxyMode> implements WireEnum {
    private static final /* synthetic */ ProxyMode[] $VALUES = null;
    public static final ProtoAdapter<ProxyMode> ADAPTER = null;
    public static final ProxyMode Automatic = null;
    public static final ProxyMode Debug = null;
    public static final ProxyMode No = null;
    public static final ProxyMode Specify = null;
    public final Boolean deprecated;
    private final int value;

    static {
        ProxyMode r100 = new ProxyMode("No", 0, 2, null);
        No = r100;
        ProxyMode r101 = new ProxyMode("Debug", 1, 3, Boolean.TRUE);
        Debug = r101;
        ProxyMode r102 = new ProxyMode("Specify", 2, 4, null);
        Specify = r102;
        ProxyMode r103 = new ProxyMode("Automatic", 3, 5, null);
        Automatic = r103;
        $VALUES = new ProxyMode[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(ProxyMode.class);
    }

    public static ProxyMode[] values() {
        return (ProxyMode[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ProxyMode fromValue(int r100) {
        if (r100 == 2) goto L19;
        if (r100 == 3) goto L17;
        if (r100 == 4) goto L15;
        if (r100 == 5) goto L13;
        return null;
    L13:
        return Automatic;
    L15:
        return Specify;
    L17:
        return Debug;
    L19:
        return No;
    }

    public static ProxyMode valueOf(String r100) {
        return (ProxyMode) a.a(ProxyMode.class, r100);
    }

    private ProxyMode(String r100, int r101, int r102, Boolean r103) {
        super(r100, r101);
        this.value = r102;
        this.deprecated = r103;
    }
}
