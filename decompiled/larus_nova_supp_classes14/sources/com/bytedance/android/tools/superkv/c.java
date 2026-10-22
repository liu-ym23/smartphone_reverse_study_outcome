package com.bytedance.android.tools.superkv;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final Charset d = null;
    public ByteBuffer a;
    public int b;
    public final byte[] c;

    static {
        d = Charset.forName("UTF-8");
    }

    public final byte a() {
        return this.a.get();
    }

    public c() {
        this.c = new byte[1024];
    }
}
