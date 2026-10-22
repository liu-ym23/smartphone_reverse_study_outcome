package com.larus.platform.service;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes31.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f365759a = null;

    static {
        f365759a = LazyKt.lazy(new k0());
    }

    public static com.larus.platform.api.l2 a() {
        return (com.larus.platform.api.l2) f365759a.getValue();
    }
}
