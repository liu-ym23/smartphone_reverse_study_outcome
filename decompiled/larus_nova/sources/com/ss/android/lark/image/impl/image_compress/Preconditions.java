package com.ss.android.lark.image.impl.image_compress;

/* JADX INFO: loaded from: classes36.dex */
final class Preconditions {
    public static <T> T checkNotNull(T r100, Object r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(String.valueOf(r101));
    }
}
