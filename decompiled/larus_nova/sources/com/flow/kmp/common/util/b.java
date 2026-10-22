package com.flow.kmp.common.util;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class b {
    public static final String a(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.length;
        if (r101 > 0) goto L6;
        return "[]";
    L6:
        StringBuilder r102 = new StringBuilder("[");
        int r103 = 0;
    L7:
        if (r103 >= r101) goto L12;
        r102.append(UByte.m9461boximpl(UByte.m9467constructorimpl(r100[r103])));
        if (r103 == (r101 - 1)) goto L12;
        r102.append(", ");
        r103 = r103 + 1;
    L12:
        r102.append("]");
        return r102.toString();
    }

    public static final ByteBuffer b(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.limit(r100.capacity());
        r100.rewind();
        ByteBuffer r101 = ByteBuffer.allocateDirect(r100.capacity());
        r101.put(r100);
        return r101;
    }

    public static final void c(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.rewind();
        int r101 = r100.capacity();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100.put((byte) 0);
        r102 = r102 + 1;
        goto L3
    L5:
        r100.rewind();
    }

    public static final byte[] e(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.rewind();
        byte[] r101 = new byte[r100.remaining()];
        r100.get(r101);
        return r101;
    }

    public static final ByteBuffer g(byte[] r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L11:
        if (r101 == false) goto L14;
        return null;
    L14:
        ByteBuffer r102 = ByteBuffer.allocateDirect(r100.length);
        r102.put(r100);
        return r102;
    L5:
        if (r100.length != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r101 = false;
        goto L11
    L7:
        r103 = false;
        goto L8
    }

    public static final void d(ByteBuffer r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        r100.rewind();
        r100.put(ByteBuffer.wrap(r101));
    }

    public static final byte[] f(ByteBuffer r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = Math.min(r101, r100.limit());
        r100.rewind();
        byte[] r103 = new byte[r102];
        r100.get(r103);     // Catch: BufferUnderflowException -> L5
    L7:
        return r103;
    L5:
        e = move-exception;
        e.getMessage();
        goto L7
    }
}
