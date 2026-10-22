package com.bytedance.bdlocation.utils.json;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public class SuperclassExclusionStrategy implements ExclusionStrategy {
    public SuperclassExclusionStrategy() {
    }

    @Override // com.google.gson.ExclusionStrategy
    public boolean shouldSkipClass(Class<?> r100) {
        return false;
    }

    @Override // com.google.gson.ExclusionStrategy
    public boolean shouldSkipField(FieldAttributes r100) {
        String r101 = r100.getName();
        return isFieldInSuperclass(r100.getDeclaringClass(), r101);
    }

    private Field getField(Class<?> r100, String r101) {
        return r100.getDeclaredField(r101);
    L4:
        return null;
    }

    private boolean isFieldInSuperclass(Class<?> r100, String r101) {
        Class<? super Object> r102 = r100.getSuperclass();
    L3:
        if (r102 == null) goto L9;
        if (getField(r102, r101) != null) goto L6;
        r102 = r102.getSuperclass();
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
