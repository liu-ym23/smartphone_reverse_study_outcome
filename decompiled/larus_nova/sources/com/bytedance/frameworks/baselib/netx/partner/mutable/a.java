package com.bytedance.frameworks.baselib.netx.partner.mutable;

import java.io.EOFException;
import kotlin.UByte;
import okio.Buffer;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f244840a = null;

    static {
        f244840a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String b(String r100, String r101, boolean r102, boolean r110) {
        return a(r100, 0, r100.length(), r101, false, r102, r110);
    }

    public static String c(String r100, int r101, int r110, boolean r111) {
        int r102 = r101;
    L3:
        if (r102 >= r110) goto L28;
        char r103 = r100.charAt(r102);
        if (r103 == '%') goto L10;
        if (r103 != '+') goto L9;
        if (r111 == true) goto L10;
    L9:
        r102 = r102 + 1;
    L10:
        Buffer r104 = new Buffer();
        r104.writeUtf8(r100, r101, r102);
    L11:
        if (r102 >= r110) goto L26;
        int r105 = r100.codePointAt(r102);
        if (r105 != 37) goto L20;
        int r106 = r102 + 2;
        if (r106 >= r110) goto L20;
        int r107 = cvc.c.g(r100.charAt(r102 + 1));
        int r108 = cvc.c.g(r100.charAt(r106));
        if (r107 == (-1)) goto L23;
        if (r108 == (-1)) goto L23;
        r104.writeByte((r107 << 4) + r108);
        r102 = r106;
    L24:
        r102 = r102 + Character.charCount(r105);
    L23:
        r104.writeUtf8CodePoint(r105);
    L20:
        if (r105 != 43) goto L23;
        if (r111 == false) goto L23;
        r104.writeByte(32);
        goto L24
    L26:
        return r104.readUtf8();
    L28:
        return r100.substring(r101, r110);
    }

    public static String a(String r110, int r111, int r112, String r113, boolean r210, boolean r211, boolean r212) {
        int r100 = r111;
    L3:
        if (r100 >= r112) goto L59;
        int r101 = r110.codePointAt(r100);
        if (r101 < 32) goto L17;
        if (r101 == 127) goto L17;
        if (r101 < 128) goto L10;
        if (r212 == true) goto L17;
    L10:
        if (r113.indexOf(r101) != (-1)) goto L17;
        if (r101 != 37) goto L13;
        if (r210 == false) goto L17;
    L13:
        if (r101 != 43) goto L16;
        if (r211 == true) goto L17;
    L16:
        r100 = r100 + Character.charCount(r101);
    L17:
        Buffer r102 = new Buffer();
        r102.writeUtf8(r110, r111, r100);
        Buffer r114 = null;
    L18:
        if (r100 >= r112) goto L57;
        int r115 = r110.codePointAt(r100);
        if (r210 == true) goto L22;
    L30:
        if (r115 != 43) goto L36;
        if (r211 == false) goto L36;
        if (r210 == false) goto L34;
        String r116 = Marker.ANY_NON_NULL_MARKER;
    L35:
        r102.writeUtf8(r116);
    L52:
        r100 = r100 + Character.charCount(r115);
        goto L18
    L34:
        r116 = "%2B";
    L36:
        if (r115 < 32) goto L45;
        if (r115 == 127) goto L45;
        if (r115 < 128) goto L41;
        if (r212 == true) goto L45;
    L41:
        if (r113.indexOf(r115) != (-1)) goto L45;
        if (r115 != 37) goto L44;
        if (r210 == false) goto L45;
    L44:
        r102.writeUtf8CodePoint(r115);
    L45:
        if (r114 != null) goto L47;
        r114 = new Buffer();
    L47:
        r114.writeUtf8CodePoint(r115);
    L60:
    L53:
        e = move-exception;
        throw new RuntimeException(e);
    L49:
        if (r114.exhausted() == true) goto L52;
        int r117 = r114.readByte() & UByte.MAX_VALUE;     // Catch: EOFException -> L53
        r102.writeByte(37);     // Catch: EOFException -> L53
        char[] r118 = f244840a;     // Catch: EOFException -> L53
        r102.writeByte(r118[(r117 >> 4) & 15]);     // Catch: EOFException -> L53
        r102.writeByte(r118[r117 & 15]);     // Catch: EOFException -> L53
        goto L60
    L22:
        if (r115 == 9) goto L52;
        if (r115 == 10) goto L52;
        if (r115 == 12) goto L52;
        if (r115 != 13) goto L30;
    L57:
        return r102.readUtf8();
    L59:
        return r110.substring(r111, r112);
    }
}
