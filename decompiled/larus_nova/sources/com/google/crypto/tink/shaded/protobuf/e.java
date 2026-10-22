package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes23.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f275885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f275886b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ByteBuffer f275887c = null;

    public interface a {
    }

    public interface b<T extends a> {
    }

    public interface c {
    }

    static {
        Charset.forName("US-ASCII");
        f275885a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] r100 = new byte[0];
        f275886b = r100;
        f275887c = ByteBuffer.wrap(r100);
        d.a(r100, 0, 0, false);
    }
}
