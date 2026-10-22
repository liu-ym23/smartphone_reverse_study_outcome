package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerDef$VeLivePlayerProtocol extends Enum<VeLivePlayerDef$VeLivePlayerProtocol> {
    public static final VeLivePlayerDef$VeLivePlayerProtocol VeLivePlayerProtocolQUIC = null;
    public static final VeLivePlayerDef$VeLivePlayerProtocol VeLivePlayerProtocolTCP = null;
    public static final VeLivePlayerDef$VeLivePlayerProtocol VeLivePlayerProtocolTLS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerDef$VeLivePlayerProtocol[] f458622a = null;

    static {
        VeLivePlayerDef$VeLivePlayerProtocol r100 = new VeLivePlayerDef$VeLivePlayerProtocol("VeLivePlayerProtocolTCP", 0);
        VeLivePlayerProtocolTCP = r100;
        VeLivePlayerDef$VeLivePlayerProtocol r101 = new VeLivePlayerDef$VeLivePlayerProtocol("VeLivePlayerProtocolQUIC", 1);
        VeLivePlayerProtocolQUIC = r101;
        VeLivePlayerDef$VeLivePlayerProtocol r102 = new VeLivePlayerDef$VeLivePlayerProtocol("VeLivePlayerProtocolTLS", 2);
        VeLivePlayerProtocolTLS = r102;
        f458622a = new VeLivePlayerDef$VeLivePlayerProtocol[]{r100, r101, r102};
    }

    public static VeLivePlayerDef$VeLivePlayerProtocol[] values() {
        return (VeLivePlayerDef$VeLivePlayerProtocol[]) f458622a.clone();
    }

    public static VeLivePlayerDef$VeLivePlayerProtocol valueOf(String r100) {
        return (VeLivePlayerDef$VeLivePlayerProtocol) r27.a.a(VeLivePlayerDef$VeLivePlayerProtocol.class, r100);
    }

    private VeLivePlayerDef$VeLivePlayerProtocol(String r100, int r101) {
        super(r100, r101);
    }
}
