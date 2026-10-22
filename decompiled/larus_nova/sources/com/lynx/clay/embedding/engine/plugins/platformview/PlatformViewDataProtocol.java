package com.lynx.clay.embedding.engine.plugins.platformview;

/* JADX INFO: loaded from: classes32.dex */
public final enum PlatformViewDataProtocol extends Enum<PlatformViewDataProtocol> {
    public static final PlatformViewDataProtocol JSON_STRING = null;
    public static final PlatformViewDataProtocol LYNX_MAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlatformViewDataProtocol[] f380851a = null;

    static {
        PlatformViewDataProtocol r100 = new PlatformViewDataProtocol("LYNX_MAP", 0);
        LYNX_MAP = r100;
        PlatformViewDataProtocol r101 = new PlatformViewDataProtocol("JSON_STRING", 1);
        JSON_STRING = r101;
        f380851a = new PlatformViewDataProtocol[]{r100, r101};
    }

    public static PlatformViewDataProtocol[] values() {
        return (PlatformViewDataProtocol[]) f380851a.clone();
    }

    public static PlatformViewDataProtocol valueOf(String r100) {
        return (PlatformViewDataProtocol) r27.a.a(PlatformViewDataProtocol.class, r100);
    }

    public PlatformViewDataProtocol(String r100, int r101) {
        super(r100, r101);
    }
}
