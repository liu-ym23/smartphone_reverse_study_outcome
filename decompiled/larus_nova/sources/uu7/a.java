package uu7;

import android.util.Property;

/* JADX INFO: loaded from: classes23.dex */
public abstract class a<T> extends Property<T, Float> {
    public abstract void a(T r100, float r101);

    public a(String r100) {
        super(Float.class, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public final void set(Object r100, Float r101) {
        a(r100, r101.floatValue());
    }
}
