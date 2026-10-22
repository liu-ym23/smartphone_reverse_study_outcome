package com.ss.android.lark.abtest.feature.launch;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends iua.a<Integer> {

    public static final class a {
    }

    static {
    }

    @Override // iua.a
    public final Integer getDefault() {
        return 0;
    }

    @Override // iua.a
    public final boolean isSticky() {
        return true;
    }

    @Override // iua.a
    public final iua.b getLarkExperimentInfo() {
        return new iua.b("launch_latency_optimise_first_stage", "launch latency optimization A/B test");
    }

    public b() {
    }
}
