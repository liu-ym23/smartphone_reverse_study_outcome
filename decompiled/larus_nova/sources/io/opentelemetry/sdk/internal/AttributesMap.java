package io.opentelemetry.sdk.internal;

import itc.g;
import itc.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class AttributesMap extends HashMap<itc.f<?>, Object> implements g {
    private static final long serialVersionUID = -5072696312123632376L;
    private final long capacity;
    private final int lengthLimit;
    private int totalAddedValues;

    public g immutableCopy() {
        itc.d r100 = new itc.d();
        forEach(new itc.c(r100));
        return r100.a();
    }

    public h toBuilder() {
        itc.d r100 = new itc.d();
        forEach(new itc.c(r100));
        return r100;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return "AttributesMap{data=" + super.toString() + ", capacity=" + this.capacity + ", totalAddedValues=" + this.totalAddedValues + '}';
    }

    public Map<itc.f<?>, Object> asMap() {
        return Collections.unmodifiableMap(this);
    }

    public int getTotalAddedValues() {
        return this.totalAddedValues;
    }

    @Override // java.util.HashMap, java.util.Map, itc.g
    public void forEach(BiConsumer<? super itc.f<?>, ? super Object> r100) {
        super.forEach(r100);
    }

    @Nullable
    public <T> T get(itc.f<T> r100) {
        return (T) get(r100);
    }

    public AttributesMap(long r100, int r101) {
        this.totalAddedValues = 0;
        this.capacity = r100;
        this.lengthLimit = r101;
    }

    public static AttributesMap create(long r100, int r101) {
        return new AttributesMap(r100, r101);
    }

    public <T> void put(itc.f<T> r100, T r101) {
        this.totalAddedValues++;
        if (size() >= this.capacity) goto L5;
    L7:
        put(r100, a.a(r101, this.lengthLimit));
        return;
    L5:
        if (containsKey(r100) == true) goto L7;
    }
}
