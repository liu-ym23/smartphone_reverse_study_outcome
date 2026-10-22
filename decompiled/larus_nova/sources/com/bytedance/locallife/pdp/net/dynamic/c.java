package com.bytedance.locallife.pdp.net.dynamic;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, e> f261605a;

    public c() {
        this(new HashMap());
    }

    public c(Map<String, e> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f261605a = r100;
    }
}
