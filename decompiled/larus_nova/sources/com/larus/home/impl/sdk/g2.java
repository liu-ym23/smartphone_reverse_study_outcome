package com.larus.home.impl.sdk;

import com.larus.platform.api.w3;
import com.larus.xbridge.IXBridgeApi;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g2 implements w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g2 f346180a = null;

    static {
        f346180a = new g2();
    }

    public g2() {
    }

    @Override // com.larus.platform.api.w3
    public final void a() {
        IXBridgeApi.f379669a.a();
    }

    @Override // com.larus.platform.api.w3
    public final void init() {
        IXBridgeApi.f379669a.init();
    }

    @Override // com.larus.platform.api.w3
    public final void b(String r100, Map<String, ? extends Object> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        IXBridgeApi.f379669a.b(r100, r101, r102);
    }
}
