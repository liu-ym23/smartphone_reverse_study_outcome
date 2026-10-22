package com.bytedance.bdp.appbase.network;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f200879a = null;

    static {
        int[] r100 = new int[BdpFromSource.values().length];
        f200879a = r100;
        r100[BdpFromSource.f200853cp.ordinal()] = 1;
        r100[BdpFromSource.download_cp.ordinal()] = 2;
        r100[BdpFromSource.upload_cp.ordinal()] = 3;
        r100[BdpFromSource.prefetch.ordinal()] = 4;
        r100[BdpFromSource.cp_http_secure.ordinal()] = 5;
        r100[BdpFromSource.preconnect_cp.ordinal()] = 6;
        r100[BdpFromSource.dns.ordinal()] = 7;
    }
}
