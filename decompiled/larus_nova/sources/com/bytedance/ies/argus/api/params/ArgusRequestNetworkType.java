package com.bytedance.ies.argus.api.params;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/api/params/ArgusRequestNetworkType;", "", "", "str", "Ljava/lang/String;", "getStr", "()Ljava/lang/String;", "WEBVIEW", "FOREST", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusRequestNetworkType extends Enum<ArgusRequestNetworkType> {
    public static final ArgusRequestNetworkType FOREST = null;
    public static final ArgusRequestNetworkType WEBVIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusRequestNetworkType[] f245646a = null;
    private final String str;

    public static ArgusRequestNetworkType valueOf(String r100) {
        return (ArgusRequestNetworkType) r27.a.a(ArgusRequestNetworkType.class, r100);
    }

    public static ArgusRequestNetworkType[] values() {
        return (ArgusRequestNetworkType[]) f245646a.clone();
    }

    static {
        ArgusRequestNetworkType r100 = new ArgusRequestNetworkType("WEBVIEW", 0, "webview");
        WEBVIEW = r100;
        ArgusRequestNetworkType r101 = new ArgusRequestNetworkType("FOREST", 1, "forest");
        FOREST = r101;
        f245646a = new ArgusRequestNetworkType[]{r100, r101};
    }

    public final String getStr() {
        return this.str;
    }

    public ArgusRequestNetworkType(String r100, int r101, String r102) {
        super(r100, r101);
        this.str = r102;
    }
}
