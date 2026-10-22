package com.ss.android.lark.coremd.ext;

import com.ss.android.lark.coremd.ext.f;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ExtendProviderImpl<E extends f> implements h<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<E> f419617c;

    @Override // com.ss.android.lark.coremd.ext.h
    public final E a() {
        ConcurrentHashMap<Class<?>, Object> r100 = k.f419620a;
        return (E) k.a(this.f419617c);
    }

    public ExtendProviderImpl(Class<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        this.f419617c = r100;
    }

    public final <R> R b(final Function1<? super E, ? extends R> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return (R) i.a(this.f419617c, new ExtendProviderImpl$invoke$1(r100));
    }
}
