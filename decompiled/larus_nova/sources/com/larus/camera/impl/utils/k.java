package com.larus.camera.impl.utils;

import com.larus.common.apphost.AppHost;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f322785a = null;

    static {
        f322785a = LazyKt.lazy(new j());
    }

    public static boolean a() {
        return AppHost.f326268a.isOversea();
    }
}
