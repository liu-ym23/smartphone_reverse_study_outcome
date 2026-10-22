package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerProtocol extends Enum<VeLivePlayerProtocol> {
    public static final VeLivePlayerProtocol VeLivePlayerProtocolHTTP2 = null;
    public static final VeLivePlayerProtocol VeLivePlayerProtocolQUIC = null;
    public static final VeLivePlayerProtocol VeLivePlayerProtocolTCP = null;
    public static final VeLivePlayerProtocol VeLivePlayerProtocolTLS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerProtocol[] f459698a = null;

    static {
        VeLivePlayerProtocol r100 = new VeLivePlayerProtocol("VeLivePlayerProtocolTCP", 0);
        VeLivePlayerProtocolTCP = r100;
        VeLivePlayerProtocol r101 = new VeLivePlayerProtocol("VeLivePlayerProtocolQUIC", 1);
        VeLivePlayerProtocolQUIC = r101;
        VeLivePlayerProtocol r102 = new VeLivePlayerProtocol("VeLivePlayerProtocolTLS", 2);
        VeLivePlayerProtocolTLS = r102;
        VeLivePlayerProtocol r103 = new VeLivePlayerProtocol("VeLivePlayerProtocolHTTP2", 3);
        VeLivePlayerProtocolHTTP2 = r103;
        f459698a = new VeLivePlayerProtocol[]{r100, r101, r102, r103};
    }

    public static VeLivePlayerProtocol[] values() {
        return (VeLivePlayerProtocol[]) f459698a.clone();
    }

    public static VeLivePlayerProtocol valueOf(String r100) {
        return (VeLivePlayerProtocol) r27.a.a(VeLivePlayerProtocol.class, r100);
    }

    public VeLivePlayerProtocol(String r100, int r101) {
        super(r100, r101);
    }
}
