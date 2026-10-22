package com.larus.platform.service;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f365718a = null;

    static {
        f365718a = LazyKt.lazy(new a());
    }

    public static com.larus.platform.api.l1 a() {
        return (com.larus.platform.api.l1) f365718a.getValue();
    }
}
