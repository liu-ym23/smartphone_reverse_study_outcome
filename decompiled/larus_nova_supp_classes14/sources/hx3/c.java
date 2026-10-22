package hx3;

import com.bytedance.applet.debugger.DebuggerSessionViewModel;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static boolean a(String r33, long r34) {
        if (r34 > 0) goto L5;
        return true;
    L5:
        if (r34 > DebuggerSessionViewModel.MODE_SWITCH_TIMEOUT_MS) goto L53;
        boolean r5 = a.a;
        if (r33 != null) goto L10;
        String r6 = "NULL";
    L11:
        a.b.getClass();
        byte[] r7 = r6.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L44
        int r8 = r7.length;
        long r9 = -7286425919675154353L;
        if (r8 > 32) goto L26;
        if (r8 > 16) goto L24;
        int r0 = r7.length;
        if (r0 < 8) goto L20;
        long r23 = ((long) (r0 * 2)) - 7286425919675154353L;
        long r1 = a.b(r7, 0) - 7286425919675154353L;
        long r4 = a.b(r7, r0 - 8);
        long r2 = a.d((a.e(r4, 37) * r23) + r1, (a.e(r1, 25) + r4) * r23, r23);
    L28:
        r9 = r2;
    L29:
        boolean r3 = false;
    L36:
        if (r9 < 0) goto L38;
        BigInteger r10 = BigInteger.valueOf(r9);
    L40:
        if (((r10.longValue() >>> 32) % (DebuggerSessionViewModel.MODE_SWITCH_TIMEOUT_MS / r34)) != 0) goto L52;
        return true;
    L52:
        return r3;
    L38:
        r10 = BigInteger.valueOf(r9 & Long.MAX_VALUE).add(BigInteger.valueOf(Long.MAX_VALUE)).add(BigInteger.valueOf(1));
        goto L40
    L20:
        if (r0 < 4) goto L22;
        r9 = a.d(((((long) a.a(r7, 0)) & 4294967295L) << 3) + ((long) r0), ((long) a.a(r7, r0 - 4)) & 4294967295L, ((long) (r0 * 2)) - 7286425919675154353L);
        goto L29
    L22:
        if (r0 <= 0) goto L29;
        long r11 = (((long) ((r7[0] & 255) + ((r7[r0 >>> 1] & 255) << 8))) * (-7286425919675154353L)) ^ (((long) (r0 + ((r7[r0 - 1] & 255) << 2))) * (-4348849565147123417L));
        r9 = (-7286425919675154353L) * (r11 ^ (r11 >>> 47));
        goto L29
    L24:
        int r12 = r7.length;
        long r24 = ((long) (r12 * 2)) - 7286425919675154353L;
        long r13 = a.b(r7, 0) * (-5435081209227447693L);
        long r14 = a.b(r7, 8);
        long r15 = a.b(r7, r12 - 8) * r24;
        r9 = a.d((a.e(r13 + r14, 43) + a.e(r15, 30)) + (a.b(r7, r12 - 16) * (-7286425919675154353L)), (r13 + a.e(r14 - 7286425919675154353L, 18)) + r15, r24);
        goto L29
    L26:
        if (r8 > 64) goto L31;
        int r16 = r7.length;
        long r17 = ((long) (r16 * 2)) - 7286425919675154353L;
        long r18 = a.b(r7, 0) * (-7286425919675154353L);
        long r19 = a.b(r7, 8);
        long r110 = a.b(r7, r16 - 24);
        long r111 = a.b(r7, r16 - 32);
        long r21 = a.b(r7, 16) * (-7286425919675154353L);
        long r20 = a.b(r7, 24) * 9;
        long r25 = a.b(r7, r16 - 8);
        long r27 = a.b(r7, r16 - 16) * r17;
        long r112 = r18 + r25;
        long r113 = a.e(r112, 43) + ((a.e(r19, 30) + r110) * 9);
        long r114 = ((r112 ^ r111) + r20) + 1;
        long r115 = Long.reverseBytes((r113 + r114) * r17) + r27;
        long r22 = r21 + r20;
        long r26 = a.e(r22, 42) + r110;
        long r28 = r22 + r110;
        long r29 = (((r28 + (Long.reverseBytes(((r26 + r28) * r17) + ((Long.reverseBytes((r114 + r115) * r17) + r25) * r17)) + r19)) * r17) + r111) + r27;
        long r30 = (r29 >>> 47) ^ r29;
        Long.signum(r30);
        r2 = r26 + (r30 * r17);
        goto L28
    L31:
        long r116 = a.b(r7, r8 - 40);
        long r117 = a.b(r7, r8 - 16) + a.b(r7, r8 - 56);
        long r31 = r8;
        long r210 = a.c(a.b(r7, r8 - 48) + r31, a.b(r7, r8 - 24));
        r3 = false;
        b r32 = a.f(r7, r8 - 64, r31, r210);
        b r35 = a.f(r7, r8 - 32, r117 - 5435081209227447693L, r116);
        long r118 = (r116 * (-5435081209227447693L)) + a.b(r7, 0);
        int r36 = (r8 - 1) & (-64);
        b r119 = r35;
        long r37 = r118;
        int r120 = 0;
    L32:
        long r38 = a.e(((r37 + r117) + r32.a) + a.b(r7, r120 + 8), 37) * (-5435081209227447693L);
        long r39 = a.e((r117 + r32.b) + a.b(r7, r120 + 48), 42) * (-5435081209227447693L);
        long r121 = r38 ^ r119.b;
        long r211 = r39 + (r32.a + a.b(r7, r120 + 40));
        long r212 = a.e(r210 + r119.a, 33) * (-5435081209227447693L);
        r32 = a.f(r7, r120, r32.b * (-5435081209227447693L), r121 + r119.a);
        r119 = a.f(r7, r120 + 32, r212 + r119.b, r211 + a.b(r7, r120 + 16));
        r120 = r120 + 64;
        r36 = r36 - 64;
        if (r36 == 0) goto L34;
        r37 = r212;
        r210 = r121;
        r117 = r211;
        goto L32
    L34:
        long r40 = a.c(r32.a, r119.a);
        long r41 = r211 ^ (r211 >>> 47);
        Long.signum(r41);
        r9 = a.c((r40 + (r41 * (-5435081209227447693L))) + r121, a.c(r32.b, r119.b) + r212);
    L44:
        e = move-exception;
        throw new RuntimeException(e);
    L10:
        r6 = r33;
        goto L11
    L53:
        return true;
    }
}
