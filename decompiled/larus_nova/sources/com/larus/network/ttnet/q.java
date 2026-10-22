package com.larus.network.ttnet;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements NetworkParams.f {
    public q() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.f
    public final void a(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "values");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.f
    public final void b() {
    }
}
