package com.bytedance.assem.arch.core;

import androidx.lifecycle.LifecycleOwner;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class i<T> implements ReadWriteProperty<Object, T> {
    public static final /* synthetic */ int b = 0;
    public T a;

    public static final class a {
    }

    static {
    }

    public i() {
    }

    public final T getValue(Object r3, KProperty<?> r4) {
        T r5 = this.a;
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException("Property " + r4.getName() + " should be initialized before get.");
    }

    public final void setValue(Object r1, KProperty<?> r2, T r3) {
        T r4 = this.a;
        this.a = r3;
        LifecycleOwner r5 = (LifecycleOwner) r3;
        LifecycleOwner r6 = (LifecycleOwner) r4;
        ((Assem.a) this).c.getClass();
    }
}
