package com.facebook.cache.common;

import java.io.InputStream;

/* JADX INFO: loaded from: classes22.dex */
public class WriterCallbacks {
    public WriterCallbacks() {
    }

    public static WriterCallback from(final InputStream r100) {
        return new AnonymousClass1(r100);
    }

    public static WriterCallback from(final byte[] r100) {
        return new AnonymousClass2(r100);
    }
}
