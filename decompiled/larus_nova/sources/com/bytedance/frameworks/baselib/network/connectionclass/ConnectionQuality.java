package com.bytedance.frameworks.baselib.network.connectionclass;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum ConnectionQuality extends Enum<ConnectionQuality> {
    public static final ConnectionQuality EXCELLENT = null;
    public static final ConnectionQuality GOOD = null;
    public static final ConnectionQuality MODERATE = null;
    public static final ConnectionQuality POOR = null;
    public static final ConnectionQuality UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConnectionQuality[] f244649a = null;

    static {
        ConnectionQuality r100 = new ConnectionQuality("POOR", 0);
        POOR = r100;
        ConnectionQuality r101 = new ConnectionQuality("MODERATE", 1);
        MODERATE = r101;
        ConnectionQuality r102 = new ConnectionQuality("GOOD", 2);
        GOOD = r102;
        ConnectionQuality r103 = new ConnectionQuality("EXCELLENT", 3);
        EXCELLENT = r103;
        ConnectionQuality r104 = new ConnectionQuality("UNKNOWN", 4);
        UNKNOWN = r104;
        f244649a = new ConnectionQuality[]{r100, r101, r102, r103, r104};
    }

    public static ConnectionQuality[] values() {
        return (ConnectionQuality[]) f244649a.clone();
    }

    public static ConnectionQuality valueOf(String r100) {
        return (ConnectionQuality) a.a(ConnectionQuality.class, r100);
    }

    public ConnectionQuality(String r100, int r101) {
        super(r100, r101);
    }
}
