package com.ss.android.lark.framework.assembly.rust;

import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: classes36.dex */
public final class z extends iua.a<y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f425724a = 0;

    public static final class a {
        public static y a() {
            return (y) ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(z.class, true);
        }
    }

    static {
    }

    @Override // iua.a
    public final /* bridge */ /* synthetic */ y getDefault() {
        return null;
    }

    @Override // iua.a
    public final boolean isSticky() {
        return true;
    }

    @Override // iua.a
    public final iua.b getLarkExperimentInfo() {
        return new iua.b("rust_throughput_experiment", "adjust Rust network request semaphore && thread core size");
    }

    public z() {
    }
}
