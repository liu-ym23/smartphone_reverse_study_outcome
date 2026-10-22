package com.larksuite.framework.utils;

import java.security.SecureRandom;
import java.util.UUID;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes24.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<SecureRandom> f286042a = null;

    static {
        f286042a = new ThreadLocal();
    }

    public static UUID a() {
        ThreadLocal<SecureRandom> r100 = f286042a;
        SecureRandom r101 = r100.get();
        if (r101 != null) goto L5;
        r101 = new SecureRandom();
        r100.set(r101);
    L5:
        byte[] r102 = new byte[16];
        r101.nextBytes(r102);
        byte r103 = (byte) (r102[6] & 15);
        r102[6] = r103;
        r102[6] = (byte) (r103 | 64);
        byte r104 = (byte) (r102[8] & 63);
        r102[8] = r104;
        r102[8] = (byte) (r104 | ByteCompanionObject.MIN_VALUE);
        long r105 = 0;
        int r106 = 0;
        long r107 = 0;
    L6:
        if (r106 >= 8) goto L8;
        r107 = (r107 << 8) | ((long) (r102[r106] & UByte.MAX_VALUE));
        r106 = r106 + 1;
        goto L6
    L8:
        int r108 = 8;
    L9:
        if (r108 >= 16) goto L12;
        r105 = (r105 << 8) | ((long) (r102[r108] & UByte.MAX_VALUE));
        r108 = r108 + 1;
        goto L9
    L12:
        return new UUID(r107, r105);
    }
}
