package com.relax.relaxframework.utils;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes34.dex */
public final class __raf {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<__raf> f405295d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f405296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Long, Function1<Long, Unit>> f405297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f405298c;

    public static final class a {
    }

    static {
        f405295d = LazyKt.lazy(__raf$Companion$instance$2.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.relax.relaxframework.utils.f] */
    public __raf() {
        this.f405297b = new ConcurrentHashMap();
        this.f405298c = new f(this);
    }
}
