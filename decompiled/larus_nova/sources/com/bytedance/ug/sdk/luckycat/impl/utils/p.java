package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class p {
    static {
    }

    @JvmStatic
    public static final boolean a(String r110, List<String> r111) {
        Uri r112 = UriProtector.parse(r110);
        if (r112.isHierarchical() == false) goto L5;
        Uri r100 = UriProtector.parse(r112.toString());
    L7:
        if ((!Intrinsics.areEqual(r100.getScheme(), "http")) == true) goto L9;
    L11:
        String r101 = r100.getHost();
        if (r101 == null) goto L70;
        String r102 = r100.getEncodedAuthority();
        if (r102 == null) goto L70;
        int r103 = 0;
        int r104 = 0;
    L17:
        if (r103 >= r102.length()) goto L26;
        if (r102.charAt(r103) != '@') goto L21;
        boolean r105 = true;
    L22:
        if (r105 == false) goto L24;
        r104 = r104 + 1;
    L24:
        r103 = r103 + 1;
        goto L17
    L21:
        r105 = false;
        goto L22
    L26:
        if (r104 <= 1) goto L48;
        String r113 = r112.getEncodedAuthority();
        if (r113 == null) goto L45;
        int r106 = StringsKt.lastIndexOf$default(r113, '@', 0, false, 6, null);
        int r107 = r113.length() - 1;
    L30:
        if (r107 < 0) goto L40;
        char r108 = r113.charAt(r107);
        if (':' == r108) goto L41;
        if (r108 < '0') goto L40;
        if (r108 > '9') goto L40;
        r107 = r107 - 1;
    L41:
        if (r107 != (-1)) goto L43;
        String r114 = r113.substring(r106 + 1);
    L44:
        r101 = Uri.decode(r114);
    L46:
        if (r101 == null) goto L70;
    L43:
        r114 = r113.substring(r106 + 1, r107);
    L40:
        r107 = -1;
        goto L41
    L45:
        r101 = null;
    L48:
        if (StringsKt.contains$default(r101, '\\', false, 2, null) == false) goto L50;
        r101 = StringsKt.substringBefore$default(r101, '\\', null, 2, null);
    L50:
        Iterator r115 = ((ArrayList) r111).iterator();
    L52:
        if (r115.hasNext() == false) goto L70;
        String r116 = (String) r115.next();
        if (r116.length() != 0) goto L56;
        boolean r109 = true;
    L57:
        if (r109 == true) goto L52;
        if (Intrinsics.areEqual(r116, r101) == true) goto L91;
        if (StringsKt.startsWith$default(r116, ".", false, 2, null) == true) goto L65;
        if (StringsKt.endsWith$default(r101, ".".concat(r116), false, 2, null) == false) goto L52;
        return true;
    L65:
        if (StringsKt.endsWith$default(r101, r116, false, 2, null) == false) goto L52;
        return true;
    L91:
        return true;
    L56:
        r109 = false;
    L70:
        return false;
    L9:
        if ((!Intrinsics.areEqual(r100.getScheme(), "https")) == false) goto L11;
    L5:
        r100 = r112;
        goto L7
    }
}
