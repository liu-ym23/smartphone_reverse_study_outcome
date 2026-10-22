package com.bytedance.kmp.network;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f252529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean[] f252530b = null;

    static {
        f252529a = "0123456789ABCDEF".toCharArray();
        boolean[] r100 = new boolean[123];
        r100[45] = true;
        r100[46] = true;
        r100[95] = true;
        char r101 = '0';
    L4:
        if (r101 >= ':') goto L6;
        r100[r101] = true;
        r101 = (char) (r101 + 1);
        goto L4
    L6:
        char r102 = 'A';
    L8:
        if (r102 >= '[') goto L10;
        r100[r102] = true;
        r102 = (char) (r102 + 1);
        goto L8
    L10:
        char r103 = 'a';
    L11:
        if (r103 >= '{') goto L13;
        r100[r103] = true;
        r103 = (char) (r103 + 1);
        goto L11
    L13:
        f252530b = r100;
    }

    public static String b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        Intrinsics.checkNotNullParameter("", "allow");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L68;
        String r101 = null;
        StringBuilder r102 = null;
        int r103 = 0;
    L10:
        if (r103 >= r110.length()) goto L51;
        char r104 = r110.charAt(r103);
        if (Intrinsics.compare(r104, 122) <= 0) goto L14;
    L16:
        boolean r105 = false;
    L17:
        if (r105 == true) goto L48;
        if (StringsKt.contains$default("", r104, false, 2, null) == true) goto L48;
        if (r102 != null) goto L24;
        r102 = new StringBuilder(r110.length());
        r102.append(r110, 0, r103);
    L24:
        if (Character.isHighSurrogate(r104) == false) goto L30;
        int r106 = r103 + 1;
        if (r106 >= r110.length()) goto L30;
        char r107 = r110.charAt(r106);
        if (Character.isLowSurrogate(r107) == false) goto L30;
        int r108 = a.f252478a;
        int r109 = ((r104 << '\n') + r107) - 56613888;
    L32:
        if (r109 < 128) goto L33;
        int r111 = a.f252478a;
        if (65536 <= r109) goto L37;
    L39:
        boolean r112 = false;
    L40:
        if (r112 == false) goto L45;
        int r113 = r103 + 2;
        byte[] r114 = StringsKt.encodeToByteArray(r110.substring(r103, r113));
        int r115 = r114.length;
        int r116 = 0;
    L42:
        if (r116 >= r115) goto L44;
        byte r117 = r114[r116];
        r102.append(GXTemplateKey.GAIAX_PE);
        char[] r118 = f252529a;
        r102.append(r118[(r117 >> 4) & 15]);
        r102.append(r118[r117 & 15]);
        r116 = r116 + 1;
        goto L42
    L44:
        r103 = r113;
        goto L10
    L45:
        byte[] r119 = StringsKt.encodeToByteArray(String.valueOf(r104));
        int r120 = r119.length;
        int r121 = 0;
    L46:
        if (r121 >= r120) goto L50;
        byte r122 = r119[r121];
        r102.append(GXTemplateKey.GAIAX_PE);
        char[] r123 = f252529a;
        r102.append(r123[(r122 >> 4) & 15]);
        r102.append(r123[r122 & 15]);
        r121 = r121 + 1;
    L50:
        r103 = r103 + 1;
        goto L10
    L37:
        if (r109 >= 1114112) goto L39;
        r112 = true;
        goto L40
    L33:
        r102.append(GXTemplateKey.GAIAX_PE);
        char[] r124 = f252529a;
        r102.append(r124[(r109 >> 4) & 15]);
        r102.append(r124[r109 & 15]);
    L30:
        r109 = r104;
    L48:
        if (r102 == null) goto L50;
        r102.append(r104);
        goto L50
    L14:
        if (f252530b[r104] == false) goto L16;
        r105 = true;
        goto L17
    L51:
        if (r102 == null) goto L53;
        r101 = r102.toString();
    L53:
        if (r101 != null) goto L56;
        return r110;
    L56:
        return r101;
    L68:
        return r110;
    L5:
        r100 = false;
        goto L6
    }

    public static String a(String r100, Map r110) {
        Intrinsics.checkNotNullParameter(r100, "originalUrl");
        boolean r101 = true;
        if (r110 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return r100;
    L11:
        List r111 = CollectionsKt.toList(r110.entrySet());
        if (r111.isEmpty() == false) goto L14;
        return r100;
    L14:
        int r103 = StringsKt.indexOf$default(r100, '#', 0, false, 6, null);
        if (r103 < 0) goto L17;
        String r104 = r100.substring(0, r103);
        String r105 = r100.substring(r103);
    L18:
        StringBuilder r106 = new StringBuilder(r100.length() + (r111.size() * 16));
        r106.append(r104);
        if (StringsKt.endsWith$default(r104, "?", false, 2, null) == false) goto L21;
    L27:
        Iterator r107 = r111.iterator();
        int r112 = 0;
    L29:
        if (r107.hasNext() == false) goto L38;
        Object r108 = r107.next();
        int r109 = r112 + 1;
        if (r112 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        Map.Entry r113 = (Map.Entry) r108;
        if (r112 <= 0) goto L36;
        r106.append(Typography.amp);
    L36:
        r106.append(b((String) r113.getKey()));
        r106.append(com.alipay.sdk.m.n.a.f25612h);
        r106.append(b((String) r113.getValue()));
        r112 = r109;
        goto L29
    L38:
        if (r105.length() > 0) goto L41;
        r101 = false;
    L41:
        if (r101 == false) goto L44;
        r106.append(r105);
    L44:
        return r106.toString();
    L21:
        if (StringsKt.endsWith$default(r104, "&", false, 2, null) == true) goto L27;
        if (StringsKt.contains$default(r104, '?', false, 2, null) == false) goto L26;
        r106.append(Typography.amp);
        goto L27
    L26:
        r106.append('?');
        goto L27
    L17:
        r105 = "";
        r104 = r100;
        goto L18
    L5:
        if (r110.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }
}
