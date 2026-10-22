package com.bytedance.ee.lark.infra.network.miniapp.net;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum NetworkVersion extends Enum<NetworkVersion> {
    public static final String NETWORK_API_VERSION_V1 = "v1";
    public static final String NETWORK_API_VERSION_V2 = "v2";
    public static final NetworkVersion V1 = null;
    public static final NetworkVersion V2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkVersion[] f242805a = null;
    private String version;

    static {
        NetworkVersion r100 = new NetworkVersion(OuterPayLoginWrapper.LOGIN_STYLE_V1, 0, "v1");
        V1 = r100;
        NetworkVersion r101 = new NetworkVersion("V2", 1, "v2");
        V2 = r101;
        f242805a = new NetworkVersion[]{r100, r101};
    }

    public static NetworkVersion[] values() {
        return (NetworkVersion[]) f242805a.clone();
    }

    public String getValue() {
        return this.version;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.version;
    }

    public static NetworkVersion fromString(String r100) {
        if ("v2".equalsIgnoreCase(r100) == false) goto L7;
        return V2;
    L7:
        return V1;
    }

    public static NetworkVersion valueOf(String r100) {
        return (NetworkVersion) a.a(NetworkVersion.class, r100);
    }

    public NetworkVersion(String r100, int r101, String r102) {
        super(r100, r101);
        this.version = r102;
    }
}
