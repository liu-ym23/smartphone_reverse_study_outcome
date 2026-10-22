package com.larus.common.app_ops;

import com.larus.common.app_ops.trasmitter.AsyncContext;
import com.larus.common.app_ops.trasmitter.AsyncContextLegacy;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f326262a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<AsyncContextLegacy> f326263b = null;

    public b() {
    }

    static {
        f326262a = new b();
        f326263b = new ThreadLocal();
    }

    public final AsyncContext getContext() {
        return f326263b.get();
    }
}
