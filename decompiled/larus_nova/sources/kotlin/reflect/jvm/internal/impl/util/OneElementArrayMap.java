package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes42.dex */
public final class OneElementArrayMap<T> extends ArrayMap<T> {
    private final int index;
    private final T value;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.util.OneElementArrayMap$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private boolean notVisited;
        final /* synthetic */ OneElementArrayMap<T> this$0;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.notVisited == false) goto L7;
            this.notVisited = false;
            return this.this$0.getValue();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.notVisited;
        }

        public AnonymousClass1(OneElementArrayMap<T> r100) {
            this.this$0 = r100;
            this.notVisited = true;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    public final int getIndex() {
        return this.index;
    }

    public final T getValue() {
        return this.value;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public T get(int r100) {
        if (r100 == this.index) goto L7;
        return null;
    L7:
        return this.value;
    }

    public OneElementArrayMap(T r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        super(null);
        this.value = r100;
        this.index = r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int r100, T r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        throw new IllegalStateException();
    }
}
