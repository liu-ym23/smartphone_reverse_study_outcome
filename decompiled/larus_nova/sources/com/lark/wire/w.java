package com.lark.wire;

import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class w extends ProtoAdapter<String> {
    @Override // com.lark.wire.ProtoAdapter
    public final String b(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return r100.e();
    }

    @Override // com.lark.wire.ProtoAdapter
    public final String c(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return r100.i();
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(String r110) {
        String r111 = r110;
        Intrinsics.checkNotNullParameter(r111, "value");
        int r100 = r111.length();
        Intrinsics.checkNotNullParameter(r111, "<this>");
        boolean r101 = true;
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L45;
        if (r100 <= r111.length()) goto L11;
        r101 = false;
    L11:
        if (r101 == false) goto L43;
        long r103 = 0;
        int r104 = 0;
    L13:
        if (r104 >= r100) goto L41;
        char r105 = r111.charAt(r104);
        if (r105 < 128) goto L16;
        if (r105 < 2048) goto L19;
        if (r105 < 55296) goto L37;
        if (r105 > 57343) goto L37;
        int r106 = r104 + 1;
        if (r106 >= r100) goto L28;
        char r112 = r111.charAt(r106);
    L30:
        if (r105 > 56319) goto L36;
        if (r112 < 56320) goto L36;
        if (r112 > 57343) goto L36;
        r103 = r103 + ((long) 4);
        r104 = r104 + 2;
    L36:
        r103 = r103 + 1;
        r104 = r106;
        goto L13
    L28:
        r112 = 0;
    L37:
        int r107 = 3;
    L38:
        r103 = r103 + ((long) r107);
    L39:
        r104 = r104 + 1;
        goto L13
    L19:
        r107 = 2;
        goto L38
    L16:
        r103 = r103 + 1;
        goto L39
    L41:
        return (int) r103;
    L43:
        throw new IllegalArgumentException(("endIndex > string.length: " + r100 + " > " + r111.length()).toString());
    L45:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r100 + " < 0").toString());
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r100, String r101) {
        String r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "writer");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.f282767a.writeUtf8(r102);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r110, String r111) {
        String r112 = r111;
        Intrinsics.checkNotNullParameter(r110, "writer");
        Intrinsics.checkNotNullParameter(r112, "value");
        r110.getClass();
        Intrinsics.checkNotNullParameter(r112, "value");
        int r100 = r112.length() - 1;
    L3:
        if (r100 < 0) goto L37;
        int r101 = r100 - 1;
        char r102 = r112.charAt(r100);
        if (r102 >= 128) goto L13;
        r110.c(1);
        int r103 = r110.f282776e;
        byte[] r104 = r110.f282775d;
        int r105 = r103 - 1;
        r104[r105] = (byte) r102;
        int r106 = Math.max(-1, r101 - r105);
    L7:
        if (r101 <= r106) goto L11;
        char r107 = r112.charAt(r101);
        if (r107 >= 128) goto L11;
        r101 = r101 - 1;
        r105 = r105 - 1;
        r104[r105] = (byte) r107;
    L11:
        r110.f282776e = r105;
    L36:
        r100 = r101;
        goto L3
    L13:
        if (r102 >= 2048) goto L16;
        r110.c(2);
        byte[] r108 = r110.f282775d;
        int r109 = r110.f282776e - 1;
        r108[r109] = (byte) (128 | (r102 & '?'));
        int r113 = r109 - 1;
        r110.f282776e = r113;
        r108[r113] = (byte) ((r102 >> 6) | 192);
        goto L36
    L16:
        if (r102 >= 55296) goto L18;
    L35:
        r110.c(3);
        byte[] r114 = r110.f282775d;
        int r115 = r110.f282776e - 1;
        r114[r115] = (byte) ((r102 & '?') | 128);
        int r116 = r115 - 1;
        r114[r116] = (byte) (128 | (63 & (r102 >> 6)));
        int r117 = r116 - 1;
        r110.f282776e = r117;
        r114[r117] = (byte) ((r102 >> '\f') | 224);
        goto L36
    L18:
        if (r102 > 57343) goto L35;
        if (r101 < 0) goto L22;
        char r118 = r112.charAt(r101);
    L24:
        if (r118 <= 56319) goto L26;
    L34:
        r110.c(1);
        byte[] r119 = r110.f282775d;
        int r120 = r110.f282776e - 1;
        r110.f282776e = r120;
        r119[r120] = 63;
        goto L36
    L26:
        if (56320 <= r102) goto L28;
    L30:
        boolean r121 = false;
    L31:
        if (r121 == false) goto L34;
        r101 = r101 - 1;
        int r122 = ((r102 & 1023) | ((r118 & 1023) << 10)) + 65536;
        r110.c(4);
        byte[] r123 = r110.f282775d;
        int r124 = r110.f282776e - 1;
        r123[r124] = (byte) ((r122 & 63) | 128);
        int r125 = r124 - 1;
        r123[r125] = (byte) (((r122 >> 6) & 63) | 128);
        int r126 = r125 - 1;
        r123[r126] = (byte) (128 | (63 & (r122 >> 12)));
        int r127 = r126 - 1;
        r110.f282776e = r127;
        r123[r127] = (byte) ((r122 >> 18) | 240);
        goto L36
    L28:
        if (r102 >= 57344) goto L30;
        r121 = true;
        goto L31
    L22:
        r118 = CharCompanionObject.MAX_VALUE;
        goto L24
    }

    public w(FieldEncoding r100, KClass<String> r101, Syntax r110) {
        super(r100, r101, null, r110, "", 32);
    }
}
