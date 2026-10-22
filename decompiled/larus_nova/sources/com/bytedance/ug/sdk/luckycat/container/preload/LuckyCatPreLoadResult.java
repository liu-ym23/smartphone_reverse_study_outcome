package com.bytedance.ug.sdk.luckycat.container.preload;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/container/preload/LuckyCatPreLoadResult;", "", "ERR_NOT_SCHEMA_SERVICE", "ERR_CONFIG_EMPTY", "luckycat-api_release"}, k = 1, mv = {1, 4, 0})
public final enum LuckyCatPreLoadResult extends Enum<LuckyCatPreLoadResult> {
    public static final LuckyCatPreLoadResult ERR_CONFIG_EMPTY = null;
    public static final LuckyCatPreLoadResult ERR_NOT_SCHEMA_SERVICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LuckyCatPreLoadResult[] f271070a = null;

    static {
        LuckyCatPreLoadResult r100 = new LuckyCatPreLoadResult("ERR_NOT_SCHEMA_SERVICE", 0);
        ERR_NOT_SCHEMA_SERVICE = r100;
        LuckyCatPreLoadResult r101 = new LuckyCatPreLoadResult("ERR_CONFIG_EMPTY", 1);
        ERR_CONFIG_EMPTY = r101;
        f271070a = new LuckyCatPreLoadResult[]{r100, r101};
    }

    public static LuckyCatPreLoadResult valueOf(String r100) {
        return (LuckyCatPreLoadResult) a.a(LuckyCatPreLoadResult.class, r100);
    }

    public static LuckyCatPreLoadResult[] values() {
        return (LuckyCatPreLoadResult[]) f271070a.clone();
    }

    public LuckyCatPreLoadResult(String r100, int r101) {
        super(r100, r101);
    }
}
