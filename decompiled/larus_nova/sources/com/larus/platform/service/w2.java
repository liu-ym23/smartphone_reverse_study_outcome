package com.larus.platform.service;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class w2 implements com.larus.platform.api.n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w2 f365819a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365820b = null;

    public w2() {
    }

    static {
        f365819a = new w2();
        f365820b = LazyKt.lazy(new v2());
    }

    @Override // com.larus.platform.api.n3
    public final List k() {
        Intrinsics.checkNotNullParameter("chat_settings", "page");
        com.larus.platform.api.n3 r100 = (com.larus.platform.api.n3) f365820b.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.k();
    }
}
