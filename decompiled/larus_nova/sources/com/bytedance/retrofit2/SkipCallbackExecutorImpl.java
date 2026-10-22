package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes3.dex */
final class SkipCallbackExecutorImpl implements SkipCallbackExecutor {
    private static final SkipCallbackExecutor INSTANCE = null;

    public SkipCallbackExecutorImpl() {
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    static {
        INSTANCE = new SkipCallbackExecutorImpl();
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return "@" + SkipCallbackExecutor.class.getName() + "()";
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return SkipCallbackExecutor.class;
    }

    public static Annotation[] ensurePresent(Annotation[] r100) {
        if (Utils.isAnnotationPresent(r100, SkipCallbackExecutor.class) == false) goto L5;
        return r100;
    L5:
        Annotation[] r101 = new Annotation[r100.length + 1];
        r101[0] = INSTANCE;
        System.arraycopy(r100, 0, r101, 1, r100.length);
        return r101;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object r100) {
        return r100 instanceof SkipCallbackExecutor;
    }
}
