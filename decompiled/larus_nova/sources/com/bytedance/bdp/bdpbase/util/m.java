package com.bytedance.bdp.bdpbase.util;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes11.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<byte[]> f201345a = null;

    static {
        f201345a = new AtomicReference(new byte[8192]);
        new AtomicReference(new char[2048]);
    }

    public static byte[] a() {
        byte[] r100 = f201345a.getAndSet(null);
        if (r100 == null) goto L7;
        if (r100.length < 8192) goto L7;
        return r100;
    L7:
        return new byte[8192];
    }

    public static void b(byte[] r100) {
        if (r100.length > 8192) goto L7;
        f201345a.set(r100);
        return;
    }
}
