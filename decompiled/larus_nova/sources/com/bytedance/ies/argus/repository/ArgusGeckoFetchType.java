package com.bytedance.ies.argus.repository;

import com.bytedance.ee.bear.operation.api.event.OperationName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/repository/ArgusGeckoFetchType;", "", "", "str", "Ljava/lang/String;", "getStr", "()Ljava/lang/String;", "CDN", "OFFLINE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusGeckoFetchType extends Enum<ArgusGeckoFetchType> {
    public static final ArgusGeckoFetchType CDN = null;
    public static final ArgusGeckoFetchType OFFLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusGeckoFetchType[] f246094a = null;
    private final String str;

    public static ArgusGeckoFetchType valueOf(String r100) {
        return (ArgusGeckoFetchType) r27.a.a(ArgusGeckoFetchType.class, r100);
    }

    public static ArgusGeckoFetchType[] values() {
        return (ArgusGeckoFetchType[]) f246094a.clone();
    }

    static {
        ArgusGeckoFetchType r100 = new ArgusGeckoFetchType("CDN", 0, "cdn");
        CDN = r100;
        ArgusGeckoFetchType r101 = new ArgusGeckoFetchType("OFFLINE", 1, OperationName.OPERATION_OFFLINE_AVAILABLE);
        OFFLINE = r101;
        f246094a = new ArgusGeckoFetchType[]{r100, r101};
    }

    public final String getStr() {
        return this.str;
    }

    public ArgusGeckoFetchType(String r100, int r101, String r102) {
        super(r100, r101);
        this.str = r102;
    }
}
