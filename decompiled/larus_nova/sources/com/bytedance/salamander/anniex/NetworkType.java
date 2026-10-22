package com.bytedance.salamander.anniex;

import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/salamander/anniex/NetworkType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "WIFI", "_5G", "_4G", "_3G", "_2G", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum NetworkType extends Enum<NetworkType> {
    public static final NetworkType UNKNOWN = null;
    public static final NetworkType WIFI = null;
    public static final NetworkType _2G = null;
    public static final NetworkType _3G = null;
    public static final NetworkType _4G = null;
    public static final NetworkType _5G = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkType[] f267888a = null;
    private final String value;

    public static NetworkType valueOf(String r100) {
        return (NetworkType) r27.a.a(NetworkType.class, r100);
    }

    public static NetworkType[] values() {
        return (NetworkType[]) f267888a.clone();
    }

    static {
        NetworkType r100 = new NetworkType("WIFI", 0, "wifi");
        WIFI = r100;
        NetworkType r101 = new NetworkType("_5G", 1, CJPayBasicUtils.NETWORK_MOBILE);
        _5G = r101;
        NetworkType r102 = new NetworkType("_4G", 2, CJPayBasicUtils.NETWORK_4G);
        _4G = r102;
        NetworkType r103 = new NetworkType("_3G", 3, CJPayBasicUtils.NETWORK_3G);
        _3G = r103;
        NetworkType r104 = new NetworkType("_2G", 4, CJPayBasicUtils.NETWORK_2G);
        _2G = r104;
        NetworkType r105 = new NetworkType("UNKNOWN", 5, "unknown");
        UNKNOWN = r105;
        f267888a = new NetworkType[]{r100, r101, r102, r103, r104, r105};
    }

    public final String getValue() {
        return this.value;
    }

    public NetworkType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
