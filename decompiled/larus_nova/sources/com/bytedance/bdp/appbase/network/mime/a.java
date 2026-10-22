package com.bytedance.bdp.appbase.network.mime;

import gb4.e;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes11.dex */
public class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f200901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f200902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f200903c;

    @Override // gb4.e
    public final long b() {
        return this.f200902b.length;
    }

    public final String toString() {
        return "ByteArrayRequestBody(bytes=" + this.f200902b.length + ", fileName=" + this.f200903c + ", realContentType='" + this.f200901a + "')";
    }

    @Override // gb4.e
    public final String a() {
        return this.f200901a;
    }

    public a(byte[] r100) {
        this.f200902b = r100;
        this.f200903c = null;
        this.f200901a = "application/json; charset=UTF-8";
    }

    @Override // gb4.e
    public final void c(OutputStream r100) {
        r100.write(this.f200902b);
    }
}
