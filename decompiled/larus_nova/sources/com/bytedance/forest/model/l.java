package com.bytedance.forest.model;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends k {
    private final b bytesProvider;

    public abstract int getBytesAtRange$forest_release(int r100, byte[] r101, int r102, int r103, Response r104) throws IOException;

    public abstract boolean initCache$forest_release(Integer r100);

    public final b getBytesProvider() {
        return this.bytesProvider;
    }

    public l(b r100) {
        this.bytesProvider = r100;
    }

    public static /* synthetic */ boolean initCache$forest_release$default(l r100, Integer r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = null;
    L7:
        return r100.initCache$forest_release(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initCache");
    }
}
