package com.google.common.collect;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class b<K, V> implements Map.Entry<K, V> {
    public b() {
    }

    @Override // java.util.Map.Entry
    @ParametricNullness
    public abstract K getKey();

    @Override // java.util.Map.Entry
    @ParametricNullness
    public abstract V getValue();

    public String toString() {
        return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        K r100 = getKey();
        V r101 = getValue();
        int r102 = 0;
        if (r100 != null) goto L5;
        int r103 = 0;
    L6:
        if (r101 == null) goto L10;
        r102 = r101.hashCode();
    L10:
        return r103 ^ r102;
    L5:
        r103 = r100.hashCode();
        goto L6
    }

    @Override // java.util.Map.Entry
    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof Map.Entry) == false) goto L10;
        Map.Entry r101 = (Map.Entry) r100;
        if (com.google.common.base.k.a(getKey(), r101.getKey()) == true) goto L7;
        return false;
    L7:
        if (com.google.common.base.k.a(getValue(), r101.getValue()) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.util.Map.Entry
    @ParametricNullness
    public V setValue(@ParametricNullness V r100) {
        throw new UnsupportedOperationException();
    }
}
