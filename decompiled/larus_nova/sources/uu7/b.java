package uu7;

import android.util.Property;

/* JADX INFO: loaded from: classes23.dex */
public abstract class b<T> extends Property<T, Integer> {
    public abstract void a(T r100, int r101);

    public b(String r100) {
        super(Integer.class, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public final void set(Object r100, Integer r101) {
        a(r100, r101.intValue());
    }
}
