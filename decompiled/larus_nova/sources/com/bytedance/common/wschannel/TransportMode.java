package com.bytedance.common.wschannel;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum TransportMode extends Enum<TransportMode> {
    private static final /* synthetic */ TransportMode[] $VALUES = null;
    public static final TransportMode HTTP2 = null;
    public static final TransportMode TLS = null;
    public static final TransportMode TLS_PROXY = null;
    public static final TransportMode TUDP = null;
    public static final TransportMode TUDP_PROXY = null;
    final int mTypeValue;

    public static TransportMode convertToMode() {
        return null;
    }

    static {
        TransportMode r100 = new TransportMode("TUDP", 0, 0);
        TUDP = r100;
        TransportMode r101 = new TransportMode("TLS", 1, 1);
        TLS = r101;
        TransportMode r102 = new TransportMode("HTTP2", 2, 2);
        HTTP2 = r102;
        TransportMode r103 = new TransportMode("TUDP_PROXY", 3, 3);
        TUDP_PROXY = r103;
        TransportMode r104 = new TransportMode("TLS_PROXY", 4, 4);
        TLS_PROXY = r104;
        $VALUES = new TransportMode[]{r100, r101, r102, r103, r104};
    }

    public static TransportMode[] values() {
        return (TransportMode[]) $VALUES.clone();
    }

    public int getTypeValue() {
        return this.mTypeValue;
    }

    public static TransportMode valueOf(String r100) {
        return (TransportMode) a.a(TransportMode.class, r100);
    }

    private TransportMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mTypeValue = r102;
    }
}
