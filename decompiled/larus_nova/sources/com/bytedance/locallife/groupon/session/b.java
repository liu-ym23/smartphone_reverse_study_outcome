package com.bytedance.locallife.groupon.session;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends d {
    @Override // com.bytedance.locallife.groupon.session.d
    public final Map<String, Object> l() {
        return MapsKt.emptyMap();
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        super(r100);
    }
}
