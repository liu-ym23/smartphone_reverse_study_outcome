package com.ss.android.lark.framework.assembly.rust;

import com.ss.android.lark.abtest.api.ABTestExperimentPlugin;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
@ABTestExperimentPlugin
public final class a0 implements hua.a {
    public a0() {
    }

    @Override // hua.a
    public final String getBizName() {
        return "Rust_Throughput_Performance";
    }

    @Override // hua.a
    public final List<iua.a<?>> a() {
        ArrayList r100 = new ArrayList();
        r100.add(new z());
        return r100;
    }
}
