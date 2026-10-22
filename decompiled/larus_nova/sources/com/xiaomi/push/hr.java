package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes41.dex */
public class hr extends ByteArrayOutputStream {
    public hr() {
    }

    public int a() {
        return ((ByteArrayOutputStream) this).count;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m9267a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public hr(int r100) {
        super(r100);
    }
}
