package io.ktor.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class h extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<a<?>, Object> f491960a;

    public h() {
        this.f491960a = new ConcurrentHashMap();
    }

    @Override // io.ktor.util.c
    public final Map f() {
        return this.f491960a;
    }

    @Override // io.ktor.util.b
    public final <T> T e(a<T> r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "block");
        T r102 = (T) this.f491960a.get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        T r103 = r101.invoke();
        Object r104 = this.f491960a.putIfAbsent((a<?>) r100, r103);
        if (r104 == null) goto L9;
        r103 = (T) r104;
    L9:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type T of io.ktor.util.ConcurrentSafeAttributes.computeIfAbsent");
        return r103;
    }
}
