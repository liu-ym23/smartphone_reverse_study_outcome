package io.ktor.util;

import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f491951a = null;

    static {
        int[] r100 = new int[256];
        int r101 = 0;
    L3:
        if (r101 >= 256) goto L5;
        r100[r101] = StringsKt.indexOf$default("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", (char) r101, 0, false, 6, null);
        r101 = r101 + 1;
        goto L3
    L5:
        f491951a = r100;
    }

    public static final String a(byte[] r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        int r100 = 3;
        char[] r101 = new char[((r110.length * 8) / 6) + 3];
        int r102 = 0;
        int r103 = 0;
    L3:
        int r104 = r102 + 3;
        if (r104 > r110.length) goto L10;
        byte r105 = r110[r102];
        byte r106 = r110[r102 + 1];
        byte r107 = r110[r102 + 2];
        int r108 = (r107 & UByte.MAX_VALUE) | (((r105 & UByte.MAX_VALUE) << 16) | ((r106 & UByte.MAX_VALUE) << 8));
        int r109 = 3;
    L7:
        if ((-1) >= r109) goto L9;
        r101[r103] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((r108 >> (r109 * 6)) & 63);
        r109 = r109 - 1;
        r103 = r103 + 1;
        goto L7
    L9:
        r102 = r104;
        goto L3
    L10:
        int r111 = r110.length - r102;
        if (r111 != 0) goto L15;
        return StringsKt.concatToString(r101, 0, r103);
    L15:
        if (r111 != 1) goto L17;
        int r112 = ((r110[r102] & UByte.MAX_VALUE) << 16) | 0;
    L18:
        int r113 = r112 | 0;
        int r114 = ((3 - r111) * 8) / 6;
        if (r114 > 3) goto L24;
    L20:
        int r115 = r103 + 1;
        r101[r103] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((r113 >> (r100 * 6)) & 63);
        if (r100 == r114) goto L23;
        r100 = r100 - 1;
        r103 = r115;
        goto L20
    L23:
        r103 = r115;
    L24:
        int r116 = 0;
    L25:
        if (r116 >= r114) goto L28;
        r101[r103] = com.alipay.sdk.m.n.a.f25612h;
        r116 = r116 + 1;
        r103 = r103 + 1;
        goto L25
    L28:
        return StringsKt.concatToString(r101, 0, r103);
    L17:
        r112 = ((r110[r102 + 1] & UByte.MAX_VALUE) << 8) | ((r110[r102] & UByte.MAX_VALUE) << 16);
        goto L18
    }
}
