package com.google.common.collect;

import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@Immutable(containerOf = {"B"})
@ElementTypesAreNonnullByDefault
public final class ImmutableClassToInstanceMap<B> extends k0<Class<? extends B>, B> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImmutableClassToInstanceMap<Object> f275053a = null;
    private final ImmutableMap<Class<? extends B>, B> delegate;

    public static /* synthetic */ class a {
    }

    public static final class b<B> {
        public b() {
            ImmutableMap.builder();
        }
    }

    static {
        f275053a = new ImmutableClassToInstanceMap(ImmutableMap.of());
    }

    public static <B> b<B> builder() {
        return new b();
    }

    @Override // com.google.common.collect.k0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    public Object readResolve() {
        if (isEmpty() == false) goto L6;
        return of();
    L6:
        return this;
    }

    public static <B> ImmutableClassToInstanceMap<B> of() {
        return (ImmutableClassToInstanceMap<B>) f275053a;
    }

    @Override // com.google.common.collect.k0, com.google.common.collect.o0
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    public ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> r100) {
        this.delegate = r100;
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> r100) {
        if ((r100 instanceof ImmutableClassToInstanceMap) == true) goto L5;
        ImmutableMap.b r101 = ImmutableMap.builder();
        Iterator<Map.Entry<? extends Class<? extends S>, ? extends S>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<? extends Class<? extends S>, ? extends S> r103 = r102.next();
        Class<? extends S> r104 = r103.getKey();
        S r105 = r103.getValue();
        r101.e(r104, com.google.common.primitives.c.a(r104).cast(r105));
        goto L8
    L10:
        ImmutableMap r106 = r101.d();
        if (r106.isEmpty() == false) goto L14;
        return of();
    L14:
        return new ImmutableClassToInstanceMap(r106, null);
    L5:
        return (ImmutableClassToInstanceMap) r100;
    }

    @CheckForNull
    public <T extends B> T getInstance(Class<T> r100) {
        ImmutableMap<Class<? extends B>, B> r101 = this.delegate;
        r100.getClass();
        return r101.get(r100);
    }

    public /* synthetic */ ImmutableClassToInstanceMap(ImmutableMap r100, a r101) {
        this(r100);
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> r100, T r101) {
        return new ImmutableClassToInstanceMap(ImmutableMap.of(r100, r101));
    }

    @CheckForNull
    public <T extends B> T putInstance(Class<T> r100, T r101) {
        throw new UnsupportedOperationException();
    }
}
