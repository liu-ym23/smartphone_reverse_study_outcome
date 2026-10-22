package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class OOMSoftReference<T> {
    SoftReference<T> softRef1;
    SoftReference<T> softRef2;
    SoftReference<T> softRef3;

    public void clear() {
        SoftReference<T> r100 = this.softRef1;
        if (r100 == null) goto L5;
        r100.clear();
        this.softRef1 = null;
    L5:
        SoftReference<T> r101 = this.softRef2;
        if (r101 == null) goto L8;
        r101.clear();
        this.softRef2 = null;
    L8:
        SoftReference<T> r102 = this.softRef3;
        if (r102 == null) goto L12;
        r102.clear();
        this.softRef3 = null;
        return;
    }

    @Nullable
    public T get() {
        SoftReference<T> r100 = this.softRef1;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.get();
    }

    public OOMSoftReference() {
        this.softRef1 = null;
        this.softRef2 = null;
        this.softRef3 = null;
    }

    public void set(@Nonnull T r100) {
        this.softRef1 = new SoftReference(r100);
        this.softRef2 = new SoftReference(r100);
        this.softRef3 = new SoftReference(r100);
    }
}
