package lv7;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes23.dex */
public final class e {
    public static byte[] a(byte[] r210, byte[] r211) throws InvalidKeyException {
        if (r210.length != 32) goto L63;
        long[] r100 = new long[11];
        byte[] r101 = Arrays.copyOf(r210, 32);
        int r102 = 0;
        r101[0] = (byte) (r101[0] & 248);
        byte r103 = (byte) (r101[31] & ByteCompanionObject.MAX_VALUE);
        r101[31] = r103;
        r101[31] = (byte) (r103 | 64);
        if (r211.length != 32) goto L61;
        byte[] r104 = Arrays.copyOf(r211, r211.length);
        r104[31] = (byte) (r104[31] & ByteCompanionObject.MAX_VALUE);
        int r105 = 0;
    L8:
        if (r105 >= 7) goto L14;
        byte[][] r106 = com.google.crypto.tink.internal.b.f275748a;
        if (MessageDigest.isEqual(r106[r105], r104) == true) goto L13;
        r105 = r105 + 1;
        goto L8
    L13:
        throw new InvalidKeyException("Banned public key: " + d.a(r106[r105]));
    L14:
        int r107 = 10;
        long[] r108 = new long[10];
        int r109 = 0;
    L16:
        if (r109 >= 10) goto L18;
        int r110 = com.google.crypto.tink.internal.d.f275752a[r109];
        r108[r109] = (((((long) (r104[r110 + 3] & UByte.MAX_VALUE)) << 24) | ((((long) (r104[r110] & UByte.MAX_VALUE)) | (((long) (r104[r110 + 1] & UByte.MAX_VALUE)) << 8)) | (((long) (r104[r110 + 2] & UByte.MAX_VALUE)) << 16))) >> com.google.crypto.tink.internal.d.f275753b[r109]) & ((long) com.google.crypto.tink.internal.d.f275754c[r109 & 1]);
        r109 = r109 + 1;
        goto L16
    L18:
        long[] r111 = new long[19];
        long[] r112 = new long[19];
        r112[0] = 1;
        long[] r113 = new long[19];
        r113[0] = 1;
        long[] r114 = new long[19];
        long[] r115 = new long[19];
        long[] r116 = new long[19];
        r116[0] = 1;
        long[] r117 = new long[19];
        long[] r118 = new long[19];
        r118[0] = 1;
        System.arraycopy(r108, 0, r111, 0, 10);
        int r119 = 0;
    L20:
        if (r119 >= 32) goto L28;
        int r120 = r101[(32 - r119) - 1] & UByte.MAX_VALUE;
        int r121 = 8;
    L22:
        if (r102 >= r121) goto L27;
        int r122 = (r120 >> (7 - r102)) & 1;
        com.google.crypto.tink.internal.b.a(r113, r111, r122);
        com.google.crypto.tink.internal.b.a(r114, r112, r122);
        byte[] r123 = r101;
        long[] r124 = Arrays.copyOf(r113, r107);
        int r125 = r120;
        long[] r126 = new long[19];
        long[] r127 = r100;
        long[] r128 = new long[19];
        int r129 = r119;
        long[] r130 = new long[19];
        int r212 = r102;
        long[] r131 = new long[19];
        long[] r132 = new long[19];
        long[] r213 = r118;
        long[] r133 = new long[19];
        long[] r134 = new long[19];
        com.google.crypto.tink.internal.d.h(r113, r113, r114);
        com.google.crypto.tink.internal.d.g(r114, r124, r114);
        int r135 = 10;
        long[] r136 = Arrays.copyOf(r111, 10);
        com.google.crypto.tink.internal.d.h(r111, r111, r112);
        com.google.crypto.tink.internal.d.g(r112, r136, r112);
        com.google.crypto.tink.internal.d.c(r131, r111, r114);
        com.google.crypto.tink.internal.d.c(r132, r113, r112);
        com.google.crypto.tink.internal.d.e(r131);
        com.google.crypto.tink.internal.d.d(r131);
        com.google.crypto.tink.internal.d.e(r132);
        com.google.crypto.tink.internal.d.d(r132);
        long[] r214 = r111;
        System.arraycopy(r131, 0, r136, 0, 10);
        com.google.crypto.tink.internal.d.h(r131, r131, r132);
        com.google.crypto.tink.internal.d.g(r132, r136, r132);
        com.google.crypto.tink.internal.d.f(r134, r131);
        com.google.crypto.tink.internal.d.f(r133, r132);
        com.google.crypto.tink.internal.d.c(r132, r133, r108);
        com.google.crypto.tink.internal.d.e(r132);
        com.google.crypto.tink.internal.d.d(r132);
        System.arraycopy(r134, 0, r115, 0, 10);
        System.arraycopy(r132, 0, r116, 0, 10);
        com.google.crypto.tink.internal.d.f(r128, r113);
        com.google.crypto.tink.internal.d.f(r130, r114);
        com.google.crypto.tink.internal.d.c(r117, r128, r130);
        com.google.crypto.tink.internal.d.e(r117);
        com.google.crypto.tink.internal.d.d(r117);
        com.google.crypto.tink.internal.d.g(r130, r128, r130);
        Arrays.fill(r126, 10, 18, 0);
        int r137 = 0;
    L24:
        if (r137 >= r135) goto L26;
        r126[r137] = r130[r137] * 121665;
        r137 = r137 + 1;
        r135 = 10;
        goto L24
    L26:
        com.google.crypto.tink.internal.d.d(r126);
        com.google.crypto.tink.internal.d.h(r126, r126, r128);
        com.google.crypto.tink.internal.d.c(r213, r130, r126);
        com.google.crypto.tink.internal.d.e(r213);
        com.google.crypto.tink.internal.d.d(r213);
        com.google.crypto.tink.internal.b.a(r117, r115, r122);
        com.google.crypto.tink.internal.b.a(r213, r116, r122);
        r102 = r212 + 1;
        r111 = r115;
        r120 = r125;
        r101 = r123;
        r100 = r127;
        r119 = r129;
        r115 = r214;
        r107 = 10;
        r121 = 8;
        long[] r215 = r114;
        r114 = r213;
        r118 = r215;
        long[] r216 = r113;
        r113 = r117;
        r117 = r216;
        long[] r217 = r112;
        r112 = r116;
        r116 = r217;
        goto L22
    L27:
        r119 = r119 + 1;
        r102 = 0;
        r107 = 10;
        goto L20
    L28:
        long[] r138 = r100;
        long[] r139 = new long[10];
        long[] r140 = new long[10];
        long[] r141 = new long[10];
        long[] r142 = new long[10];
        long[] r143 = new long[10];
        long[] r144 = new long[10];
        long[] r145 = new long[10];
        long[] r146 = new long[10];
        long[] r147 = new long[10];
        long[] r148 = new long[10];
        long[] r149 = r111;
        long[] r150 = new long[10];
        com.google.crypto.tink.internal.d.f(r140, r114);
        com.google.crypto.tink.internal.d.f(r150, r140);
        com.google.crypto.tink.internal.d.f(r148, r150);
        com.google.crypto.tink.internal.d.b(r141, r148, r114);
        com.google.crypto.tink.internal.d.b(r142, r141, r140);
        com.google.crypto.tink.internal.d.f(r148, r142);
        com.google.crypto.tink.internal.d.b(r143, r148, r141);
        com.google.crypto.tink.internal.d.f(r148, r143);
        com.google.crypto.tink.internal.d.f(r150, r148);
        com.google.crypto.tink.internal.d.f(r148, r150);
        com.google.crypto.tink.internal.d.f(r150, r148);
        com.google.crypto.tink.internal.d.f(r148, r150);
        com.google.crypto.tink.internal.d.b(r144, r148, r143);
        com.google.crypto.tink.internal.d.f(r148, r144);
        com.google.crypto.tink.internal.d.f(r150, r148);
        int r151 = 2;
        int r152 = 2;
    L30:
        if (r152 >= 10) goto L32;
        com.google.crypto.tink.internal.d.f(r148, r150);
        com.google.crypto.tink.internal.d.f(r150, r148);
        r152 = r152 + 2;
        goto L30
    L32:
        com.google.crypto.tink.internal.d.b(r145, r150, r144);
        com.google.crypto.tink.internal.d.f(r148, r145);
        com.google.crypto.tink.internal.d.f(r150, r148);
        int r153 = 2;
    L34:
        if (r153 >= 20) goto L36;
        com.google.crypto.tink.internal.d.f(r148, r150);
        com.google.crypto.tink.internal.d.f(r150, r148);
        r153 = r153 + 2;
        goto L34
    L36:
        com.google.crypto.tink.internal.d.b(r148, r150, r145);
        com.google.crypto.tink.internal.d.f(r150, r148);
        com.google.crypto.tink.internal.d.f(r148, r150);
        int r154 = 2;
    L38:
        if (r154 >= 10) goto L40;
        com.google.crypto.tink.internal.d.f(r150, r148);
        com.google.crypto.tink.internal.d.f(r148, r150);
        r154 = r154 + 2;
        goto L38
    L40:
        com.google.crypto.tink.internal.d.b(r146, r148, r144);
        com.google.crypto.tink.internal.d.f(r148, r146);
        com.google.crypto.tink.internal.d.f(r150, r148);
        int r155 = 2;
    L42:
        if (r155 >= 50) goto L44;
        com.google.crypto.tink.internal.d.f(r148, r150);
        com.google.crypto.tink.internal.d.f(r150, r148);
        r155 = r155 + 2;
        goto L42
    L44:
        com.google.crypto.tink.internal.d.b(r147, r150, r146);
        com.google.crypto.tink.internal.d.f(r150, r147);
        com.google.crypto.tink.internal.d.f(r148, r150);
        int r156 = 2;
    L46:
        if (r156 >= 100) goto L48;
        com.google.crypto.tink.internal.d.f(r150, r148);
        com.google.crypto.tink.internal.d.f(r148, r150);
        r156 = r156 + 2;
        goto L46
    L48:
        com.google.crypto.tink.internal.d.b(r150, r148, r147);
        com.google.crypto.tink.internal.d.f(r148, r150);
        com.google.crypto.tink.internal.d.f(r150, r148);
    L49:
        if (r151 >= 50) goto L51;
        com.google.crypto.tink.internal.d.f(r148, r150);
        com.google.crypto.tink.internal.d.f(r150, r148);
        r151 = r151 + 2;
        goto L49
    L51:
        com.google.crypto.tink.internal.d.b(r148, r150, r146);
        com.google.crypto.tink.internal.d.f(r150, r148);
        com.google.crypto.tink.internal.d.f(r148, r150);
        com.google.crypto.tink.internal.d.f(r150, r148);
        com.google.crypto.tink.internal.d.f(r148, r150);
        com.google.crypto.tink.internal.d.f(r150, r148);
        com.google.crypto.tink.internal.d.b(r139, r150, r142);
        com.google.crypto.tink.internal.d.b(r138, r113, r139);
        long[] r157 = new long[10];
        long[] r158 = new long[10];
        long[] r159 = new long[11];
        long[] r160 = new long[11];
        long[] r161 = new long[11];
        com.google.crypto.tink.internal.d.b(r157, r108, r138);
        com.google.crypto.tink.internal.d.h(r158, r108, r138);
        long[] r162 = new long[10];
        int r163 = 0;
        r162[0] = 486662;
        com.google.crypto.tink.internal.d.h(r160, r158, r162);
        com.google.crypto.tink.internal.d.b(r160, r160, r112);
        com.google.crypto.tink.internal.d.h(r160, r160, r149);
        com.google.crypto.tink.internal.d.b(r160, r160, r157);
        com.google.crypto.tink.internal.d.b(r160, r160, r149);
    L52:
        if (r163 >= 10) goto L54;
        r159[r163] = r160[r163] * 4;
        r163 = r163 + 1;
        goto L52
    L54:
        com.google.crypto.tink.internal.d.d(r159);
        com.google.crypto.tink.internal.d.b(r160, r157, r112);
        com.google.crypto.tink.internal.d.g(r160, r160, r112);
        com.google.crypto.tink.internal.d.b(r161, r158, r149);
        com.google.crypto.tink.internal.d.h(r160, r160, r161);
        com.google.crypto.tink.internal.d.f(r160, r160);
        if (MessageDigest.isEqual(com.google.crypto.tink.internal.d.a(r159), com.google.crypto.tink.internal.d.a(r160)) == false) goto L59;
        return com.google.crypto.tink.internal.d.a(r138);
    L59:
        throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: " + d.a(r211));
    L61:
        throw new InvalidKeyException("Public key length is not 32-byte");
    L63:
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }
}
