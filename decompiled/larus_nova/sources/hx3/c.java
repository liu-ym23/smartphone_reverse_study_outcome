package hx3;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes14.dex */
public final class c {
    public static boolean a(String r310, long r311) {
        if (r311 > 0) goto L5;
        return true;
    L5:
        if (r311 > 10000) goto L53;
        boolean r100 = a.f487488a;
        if (r310 != null) goto L10;
        String r101 = "NULL";
    L11:
        a.f487489b.getClass();
        byte[] r102 = r101.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L44
        int r103 = r102.length;
        long r104 = -7286425919675154353L;
        if (r103 > 32) goto L26;
        if (r103 > 16) goto L24;
        int r105 = r102.length;
        if (r105 < 8) goto L20;
        long r210 = ((long) (r105 * 2)) - 7286425919675154353L;
        long r106 = a.b(r102, 0) - 7286425919675154353L;
        long r107 = a.b(r102, r105 - 8);
        long r108 = a.d((a.e(r107, 37) * r210) + r106, (a.e(r106, 25) + r107) * r210, r210);
    L28:
        r104 = r108;
    L29:
        boolean r109 = false;
    L36:
        if (r104 < 0) goto L38;
        BigInteger r110 = BigInteger.valueOf(r104);
    L40:
        if (((r110.longValue() >>> 32) % (10000 / r311)) != 0) goto L52;
        return true;
    L52:
        return r109;
    L38:
        r110 = BigInteger.valueOf(r104 & Long.MAX_VALUE).add(BigInteger.valueOf(Long.MAX_VALUE)).add(BigInteger.valueOf(1));
        goto L40
    L20:
        if (r105 < 4) goto L22;
        r104 = a.d(((((long) a.a(r102, 0)) & BodyPartID.bodyIdMax) << 3) + ((long) r105), ((long) a.a(r102, r105 - 4)) & BodyPartID.bodyIdMax, ((long) (r105 * 2)) - 7286425919675154353L);
        goto L29
    L22:
        if (r105 <= 0) goto L29;
        long r111 = (((long) ((r102[0] & UByte.MAX_VALUE) + ((r102[r105 >>> 1] & UByte.MAX_VALUE) << 8))) * (-7286425919675154353L)) ^ (((long) (r105 + ((r102[r105 - 1] & UByte.MAX_VALUE) << 2))) * (-4348849565147123417L));
        r104 = (-7286425919675154353L) * (r111 ^ (r111 >>> 47));
        goto L29
    L24:
        int r112 = r102.length;
        long r211 = ((long) (r112 * 2)) - 7286425919675154353L;
        long r113 = a.b(r102, 0) * (-5435081209227447693L);
        long r114 = a.b(r102, 8);
        long r115 = a.b(r102, r112 - 8) * r211;
        r104 = a.d((a.e(r113 + r114, 43) + a.e(r115, 30)) + (a.b(r102, r112 - 16) * (-7286425919675154353L)), (r113 + a.e(r114 - 7286425919675154353L, 18)) + r115, r211);
        goto L29
    L26:
        if (r103 > 64) goto L31;
        int r116 = r102.length;
        long r117 = ((long) (r116 * 2)) - 7286425919675154353L;
        long r118 = a.b(r102, 0) * (-7286425919675154353L);
        long r119 = a.b(r102, 8);
        long r120 = a.b(r102, r116 - 24);
        long r121 = a.b(r102, r116 - 32);
        long r212 = a.b(r102, 16) * (-7286425919675154353L);
        long r122 = a.b(r102, 24) * 9;
        long r213 = a.b(r102, r116 - 8);
        long r214 = a.b(r102, r116 - 16) * r117;
        long r123 = r118 + r213;
        long r124 = a.e(r123, 43) + ((a.e(r119, 30) + r120) * 9);
        long r125 = ((r123 ^ r121) + r122) + 1;
        long r126 = Long.reverseBytes((r124 + r125) * r117) + r214;
        long r127 = r212 + r122;
        long r128 = a.e(r127, 42) + r120;
        long r129 = r127 + r120;
        long r130 = (((r129 + (Long.reverseBytes(((r128 + r129) * r117) + ((Long.reverseBytes((r125 + r126) * r117) + r213) * r117)) + r119)) * r117) + r121) + r214;
        long r131 = (r130 >>> 47) ^ r130;
        Long.signum(r131);
        r108 = r128 + (r131 * r117);
        goto L28
    L31:
        long r132 = a.b(r102, r103 - 40);
        long r133 = a.b(r102, r103 - 16) + a.b(r102, r103 - 56);
        long r134 = r103;
        long r215 = a.c(a.b(r102, r103 - 48) + r134, a.b(r102, r103 - 24));
        r109 = false;
        b r135 = a.f(r102, r103 - 64, r134, r215);
        b r136 = a.f(r102, r103 - 32, r133 - 5435081209227447693L, r132);
        long r137 = (r132 * (-5435081209227447693L)) + a.b(r102, 0);
        int r138 = (r103 - 1) & (-64);
        b r139 = r136;
        long r140 = r137;
        int r141 = 0;
    L32:
        long r142 = a.e(((r140 + r133) + r135.f487490a) + a.b(r102, r141 + 8), 37) * (-5435081209227447693L);
        long r143 = a.e((r133 + r135.f487491b) + a.b(r102, r141 + 48), 42) * (-5435081209227447693L);
        long r144 = r142 ^ r139.f487491b;
        long r216 = r143 + (r135.f487490a + a.b(r102, r141 + 40));
        long r217 = a.e(r215 + r139.f487490a, 33) * (-5435081209227447693L);
        r135 = a.f(r102, r141, r135.f487491b * (-5435081209227447693L), r144 + r139.f487490a);
        r139 = a.f(r102, r141 + 32, r217 + r139.f487491b, r216 + a.b(r102, r141 + 16));
        r141 = r141 + 64;
        r138 = r138 - 64;
        if (r138 == 0) goto L34;
        r140 = r217;
        r215 = r144;
        r133 = r216;
        goto L32
    L34:
        long r145 = a.c(r135.f487490a, r139.f487490a);
        long r146 = r216 ^ (r216 >>> 47);
        Long.signum(r146);
        r104 = a.c((r145 + (r146 * (-5435081209227447693L))) + r144, a.c(r135.f487491b, r139.f487491b) + r217);
    L44:
        e = move-exception;
        throw new RuntimeException(e);
    L10:
        r101 = r310;
        goto L11
    L53:
        return true;
    }
}
