package com.ss.android.socialbase.downloader.network;

import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum NetworkQuality extends Enum<NetworkQuality> {
    private static final /* synthetic */ NetworkQuality[] $VALUES = null;
    public static final NetworkQuality EXCELLENT = null;
    public static final NetworkQuality GOOD = null;
    public static final NetworkQuality MODERATE = null;
    public static final NetworkQuality POOR = null;
    public static final NetworkQuality UNKNOWN = null;

    static {
        NetworkQuality r100 = new NetworkQuality("POOR", 0);
        POOR = r100;
        NetworkQuality r101 = new NetworkQuality("MODERATE", 1);
        MODERATE = r101;
        NetworkQuality r102 = new NetworkQuality("GOOD", 2);
        GOOD = r102;
        NetworkQuality r103 = new NetworkQuality("EXCELLENT", 3);
        EXCELLENT = r103;
        NetworkQuality r104 = new NetworkQuality("UNKNOWN", 4);
        UNKNOWN = r104;
        $VALUES = new NetworkQuality[]{r100, r101, r102, r103, r104};
    }

    public static NetworkQuality[] values() {
        return (NetworkQuality[]) $VALUES.clone();
    }

    public static NetworkQuality valueOf(String r100) {
        return (NetworkQuality) a.a(NetworkQuality.class, r100);
    }

    private NetworkQuality(String r100, int r101) {
        super(r100, r101);
    }
}
