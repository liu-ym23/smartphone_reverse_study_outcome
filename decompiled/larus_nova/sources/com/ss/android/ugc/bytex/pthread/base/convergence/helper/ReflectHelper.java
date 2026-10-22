package com.ss.android.ugc.bytex.pthread.base.convergence.helper;

import java.lang.reflect.Field;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/helper/ReflectHelper;", "", "()V", "setFieldLongValue", "", "clazz", "Ljava/lang/Class;", "any", "fieldName", "", "fieldValue", "", "setFieldValue", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ReflectHelper {
    public static final ReflectHelper INSTANCE = null;

    static {
        INSTANCE = new ReflectHelper();
    }

    private ReflectHelper() {
    }

    public final void setFieldLongValue(Class<?> r100, Object r101, String r102, long r103) {
        Field r104 = r100.getDeclaredField(r102);
        r104.setAccessible(true);
        r104.set(r101, Long.valueOf(r103));
    }

    public final void setFieldValue(Object r100, String r101, Object r102) {
        Field r103 = r100.getClass().getDeclaredField(r101);
        r103.setAccessible(true);
        r103.set(r100, r102);
    }
}
