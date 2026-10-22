package com.squareup.wire;

/* JADX INFO: loaded from: classes5.dex */
final class Preconditions {
    private Preconditions() {
    }

    public static void checkNotNull(Object r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r101);
    }
}
