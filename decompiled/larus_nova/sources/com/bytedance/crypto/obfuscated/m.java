package com.bytedance.crypto.obfuscated;

import android.content.Context;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import kotlin.UByte;

/* JADX INFO: loaded from: classes15.dex */
public abstract class m {
    public static byte[] a(Context r110, SecretKey r111, int r112, byte[] r113) {
        byte r100 = -2;
        if (r110 == null) goto L13;
        if (r113 == null) goto L13;
        if (r113.length == 0) goto L13;
        if (r112 == 1) goto L12;
        if (r112 != 2) goto L13;
    L12:
        r100 = 0;
    L13:
        if (r100 == 0) goto L17;
        return new byte[0];
    L17:
        if (r112 != 1) goto L26;
        byte[] r101 = new byte[12];
        new SecureRandom().nextBytes(r101);
        byte[] r114 = o.a(r112, r111, r110.getPackageName().getBytes(StandardCharsets.UTF_8), r101, r113);
        if (r114 == null) goto L25;
        if (r114.length == 0) goto L25;
        byte[] r115 = new byte[r114.length + 17];
        byte r116 = (byte) 18;
        byte r102 = (byte) 205;
        System.arraycopy(new byte[]{r116, r102, r116, r102}, 0, r115, 0, 4);
        r115[4] = 1;
        System.arraycopy(r101, 0, r115, 5, 12);
        System.arraycopy(r114, 0, r115, 17, r114.length);
        return r115;
    L25:
        return new byte[0];
    L26:
        byte[] r103 = new byte[4];
        if (r113.length < 4) goto L49;
        System.arraycopy(r113, 0, r103, 0, 4);
        if (((((r103[2] & UByte.MAX_VALUE) << 8) | (((r103[0] & UByte.MAX_VALUE) << 24) | ((r103[1] & UByte.MAX_VALUE) << 16))) | (r103[3] & UByte.MAX_VALUE)) != 315429581) goto L49;
        if (r113.length < 5) goto L49;
        if ((r113[4] & UByte.MAX_VALUE) != 1) goto L49;
        if (r113.length < 17) goto L49;
        byte[] r104 = new byte[12];
        System.arraycopy(r113, 5, r104, 0, 12);
        if (r113.length < 33) goto L49;
        int r105 = r113.length - 17;
        byte[] r106 = new byte[r105];
        System.arraycopy(r113, 17, r106, 0, r105);
        byte[] r117 = o.a(r112, r111, r110.getPackageName().getBytes(StandardCharsets.UTF_8), r104, r106);
        if (r117 == null) goto L49;
        if (r117.length == 0) goto L49;
        return r117;
    L49:
        return new byte[0];
    }
}
