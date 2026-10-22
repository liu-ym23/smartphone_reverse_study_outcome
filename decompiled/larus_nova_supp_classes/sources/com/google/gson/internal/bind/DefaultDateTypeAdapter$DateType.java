package com.google.gson.internal.bind;

import com.google.gson.TypeAdapterFactory;
import java.util.Date;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class DefaultDateTypeAdapter$DateType<T extends Date> {
    public static final DefaultDateTypeAdapter$DateType<Date> DATE = null;
    private final Class<T> dateClass;

    public abstract T deserialize(Date r1);

    static {
        final Class<Date> r1 = Date.class;
        DATE = new AnonymousClass1(r1);
    }

    public final TypeAdapterFactory createDefaultsAdapterFactory() {
        return createFactory(new DefaultDateTypeAdapter(this, 2, 2, null));
    }

    public DefaultDateTypeAdapter$DateType(Class<T> r1) {
        this.dateClass = r1;
    }

    private TypeAdapterFactory createFactory(DefaultDateTypeAdapter<T> r2) {
        return TypeAdapters.newFactory(this.dateClass, r2);
    }

    public final TypeAdapterFactory createAdapterFactory(int r3) {
        return createFactory(new DefaultDateTypeAdapter(this, r3, null));
    }

    public final TypeAdapterFactory createAdapterFactory(String r3) {
        return createFactory(new DefaultDateTypeAdapter(this, r3, null));
    }

    public final TypeAdapterFactory createAdapterFactory(int r3, int r4) {
        return createFactory(new DefaultDateTypeAdapter(this, r3, r4, null));
    }
}
