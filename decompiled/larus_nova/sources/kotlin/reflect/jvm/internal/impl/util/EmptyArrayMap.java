package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes5.dex */
public final class EmptyArrayMap extends ArrayMap {
    public static final EmptyArrayMap INSTANCE = null;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.util.EmptyArrayMap$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator, KMappedMarker {
        public AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public Void next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }
    }

    static {
        INSTANCE = new EmptyArrayMap();
    }

    private EmptyArrayMap() {
        super(null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public Void get(int r100) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public Iterator iterator() {
        return new AnonymousClass1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public /* bridge */ /* synthetic */ Object get(int r100) {
        return get(r100);
    }

    public void set(int r100, Void r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public /* bridge */ /* synthetic */ void set(int r100, Object r101) {
        set(r100, (Void) r101);
    }
}
