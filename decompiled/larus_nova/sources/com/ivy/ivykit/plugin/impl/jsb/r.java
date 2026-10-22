package com.ivy.ivykit.plugin.impl.jsb;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class r implements com.bytedance.sdk.xbridge.cn.utils.j {
    public r() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.utils.j
    public final void a(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Map<Class<?>, ox7.a> r101 = ox7.b.f527091a;
        ox7.b.c("BDXBridge", r100.toString());
    }
}
