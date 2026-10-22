package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class o extends k16.a {
    public o() {
    }

    @Override // k16.a, k16.b
    public final List<MethodFinder> L(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return CollectionsKt.listOf(new MethodFinder[]{new p(r100), new c(r100), new l(r100)});
    }
}
