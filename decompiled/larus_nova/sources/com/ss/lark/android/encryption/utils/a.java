package com.ss.lark.android.encryption.utils;

import java.math.BigInteger;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f456826a = 0;

    static {
    }

    public static void a(Cipher r100, SecretKey r101, IvParameterSpec r102, long r110) {
        if (r110 < 0) goto L15;
        if (r100 == null) goto L16;
        if (r101 == null) goto L17;
        if (r102 == null) goto L18;
        long r103 = 16;
        int r104 = (int) (r110 % r103);
        byte[] r105 = new BigInteger(1, r102.getIV()).add(BigInteger.valueOf((r110 - ((long) r104)) / r103)).toByteArray();
        if (r105.length < 16) goto L11;
        IvParameterSpec r111 = new IvParameterSpec(r105, r105.length - 16, 16);
    L12:
        r100.init(1, r101, r111);
        byte[] r106 = new byte[r104];
        r100.update(r106, 0, r104, r106);
        Arrays.fill(r106, (byte) 0);
        return;
    L11:
        byte[] r112 = new byte[16];
        System.arraycopy(r105, 0, r112, 16 - r105.length, r105.length);
        r111 = new IvParameterSpec(r112);
        goto L12
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        throw new IllegalArgumentException("Invalid offset");
    }
}
