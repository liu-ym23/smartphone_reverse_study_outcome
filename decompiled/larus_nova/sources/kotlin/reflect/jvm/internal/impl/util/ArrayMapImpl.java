package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class ArrayMapImpl<T> extends ArrayMap<T> {
    public static final Companion Companion = null;
    private Object[] data;
    private int size;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ArrayMapImpl() {
        this(new Object[20], 0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return this.size;
    }

    public static final /* synthetic */ Object[] access$getData$p(ArrayMapImpl r100) {
        return r100.data;
    }

    private final void ensureCapacity(int r100) {
        Object[] r101 = this.data;
        if (r101.length <= r100) goto L5;
        return;
    L5:
        int r102 = r101.length;
    L6:
        r102 = r102 * 2;
        if (r102 <= r100) goto L6;
        this.data = Arrays.copyOf(this.data, r102);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public T get(int r100) {
        return (T) ArraysKt.getOrNull(this.data, r100);
    }

    private ArrayMapImpl(Object[] r100, int r101) {
        super(null);
        this.data = r100;
        this.size = r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int r100, T r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        ensureCapacity(r100);
        if (this.data[r100] != null) goto L5;
        this.size = getSize() + 1;
    L5:
        this.data[r100] = r101;
    }
}
