package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class MutableClassToInstanceMap<B> extends k0<Class<? extends B>, B> implements Serializable {
    private final Map<Class<? extends B>, B> delegate;

    public static final class SerializedForm<B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Map<Class<? extends B>, B> backingMap;

        public Object readResolve() {
            return MutableClassToInstanceMap.create(this.backingMap);
        }

        public SerializedForm(Map<Class<? extends B>, B> r100) {
            this.backingMap = r100;
        }
    }

    public class a extends q0<Map.Entry<Class<? extends B>, B>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MutableClassToInstanceMap f275284a;

        /* JADX INFO: renamed from: com.google.common.collect.MutableClassToInstanceMap$a$a, reason: collision with other inner class name */
        public class C3852a extends v2<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>> {
            public C3852a(Iterator r100) {
                super(r100);
            }

            @Override // com.google.common.collect.v2
            public final Object a(Object r100) {
                return MutableClassToInstanceMap.access$100((Map.Entry) r100);
            }
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final Set<Map.Entry<Class<? extends B>, B>> delegate() {
            return this.f275284a.delegate().entrySet();
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
            return new C3852a(delegate().iterator());
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        public a(MutableClassToInstanceMap r100) {
            this.f275284a = r100;
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final <T> T[] toArray(T[] r100) {
            return (T[]) standardToArray(r100);
        }
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap(new HashMap());
    }

    private Object writeReplace() {
        return new SerializedForm(delegate());
    }

    @Override // com.google.common.collect.k0, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new a(this);
    }

    @Override // com.google.common.collect.k0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.k0, com.google.common.collect.o0
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    public MutableClassToInstanceMap(Map<Class<? extends B>, B> r100) {
        r100.getClass();
        this.delegate = r100;
    }

    public static Map.Entry access$100(Map.Entry r100) {
        return new a2(r100);
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> r100) {
        return new MutableClassToInstanceMap(r100);
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @CheckForNull
    public <T extends B> T getInstance(Class<T> r100) {
        B r101 = get(r100);
        return (T) com.google.common.primitives.c.a(r100).cast(r101);
    }

    @Override // com.google.common.collect.k0, java.util.Map
    public void putAll(Map<? extends Class<? extends B>, ? extends B> r100) {
        LinkedHashMap r101 = new LinkedHashMap(r100);
        Iterator r102 = r101.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        Class r104 = (Class) r103.getKey();
        Object r105 = r103.getValue();
        com.google.common.primitives.c.a(r104).cast(r105);
        goto L4
    L6:
        super.putAll(r101);
    }

    public static Object access$000(Class r100, Object r101) {
        return com.google.common.primitives.c.a(r100).cast(r101);
    }

    @CheckForNull
    public B put(Class<? extends B> r100, @ParametricNullness B r101) {
        com.google.common.primitives.c.a(r100).cast(r101);
        return (B) super.put(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    public <T extends B> T putInstance(Class<T> r100, @ParametricNullness T r101) {
        B r102 = put(r100, r101);
        return (T) com.google.common.primitives.c.a(r100).cast(r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.k0, java.util.Map
    @CheckForNull
    public /* bridge */ /* synthetic */ Object put(Object r100, @ParametricNullness Object r101) {
        return put((Class) r100, r101);
    }
}
