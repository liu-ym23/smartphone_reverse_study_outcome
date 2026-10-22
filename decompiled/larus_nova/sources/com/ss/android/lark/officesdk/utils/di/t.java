package com.ss.android.lark.officesdk.utils.di;

import java.security.SecureRandom;
import java.util.UUID;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes37.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<String> f437235a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<SecureRandom> f437236b = null;

    static {
        f437235a = new ThreadLocal();
        f437236b = new ThreadLocal();
    }

    @JvmStatic
    public static final UUID a() {
        ThreadLocal<SecureRandom> r100 = f437236b;
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
        int r105 = 0;
        long r106 = 0;
    L7:
        if (r105 >= 8) goto L9;
        r106 = (r106 << 8) | (255 & (((long) r102[r105]) + 0));
        r105 = r105 + 1;
        goto L7
    L9:
        long r110 = 0;
        int r107 = 8;
    L10:
        if (r107 >= 16) goto L13;
        r110 = (r110 << 8) | ((((long) r102[r107]) + 0) & 255);
        r107 = r107 + 1;
        goto L10
    L13:
        return new UUID(r106, r110);
    }
}
