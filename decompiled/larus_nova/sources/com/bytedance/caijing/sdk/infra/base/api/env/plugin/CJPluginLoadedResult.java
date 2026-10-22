package com.bytedance.caijing.sdk.infra.base.api.env.plugin;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/env/plugin/CJPluginLoadedResult;", "", "SUCCESS", "FAIL", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum CJPluginLoadedResult extends Enum<CJPluginLoadedResult> {
    public static final CJPluginLoadedResult FAIL = null;
    public static final CJPluginLoadedResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CJPluginLoadedResult[] f202220a = null;

    public static CJPluginLoadedResult valueOf(String r100) {
        return (CJPluginLoadedResult) a.a(CJPluginLoadedResult.class, r100);
    }

    public static CJPluginLoadedResult[] values() {
        return (CJPluginLoadedResult[]) f202220a.clone();
    }

    static {
        CJPluginLoadedResult r100 = new CJPluginLoadedResult("SUCCESS", 0);
        SUCCESS = r100;
        CJPluginLoadedResult r101 = new CJPluginLoadedResult("FAIL", 1);
        FAIL = r101;
        f202220a = new CJPluginLoadedResult[]{r100, r101};
    }

    public CJPluginLoadedResult(String r100, int r101) {
        super(r100, r101);
    }
}
