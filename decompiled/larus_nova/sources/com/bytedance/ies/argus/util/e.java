package com.bytedance.ies.argus.util;

import android.net.Uri;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f246255a = 0;

    static {
    }

    public static String a(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        if (r110.isHierarchical() == false) goto L5;
        Uri r100 = UriProtector.parse(r110.toString());
    L6:
        String r101 = r100.getEncodedAuthority();
        if (r101 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L14;
        return null;
    L14:
        String r103 = r100.getHost();
        if (r103 != null) goto L17;
        return null;
    L17:
        String r104 = r100.getEncodedAuthority();
        if (r104 != null) goto L20;
        return null;
    L20:
        int r105 = 0;
        int r106 = 0;
    L22:
        if (r105 >= r104.length()) goto L30;
        if (r104.charAt(r105) != '@') goto L26;
        boolean r107 = true;
    L27:
        if (r107 == false) goto L29;
        r106 = r106 + 1;
    L29:
        r105 = r105 + 1;
        goto L22
    L26:
        r107 = false;
        goto L27
    L30:
        if (r106 <= 1) goto L53;
        String r111 = r110.getEncodedAuthority();
        if (r111 != null) goto L34;
        r103 = null;
    L50:
        if (r103 != null) goto L53;
        return null;
    L34:
        int r108 = StringsKt.lastIndexOf$default(r111, '@', 0, false, 6, null);
        int r109 = r111.length() - 1;
    L35:
        if ((-1) >= r109) goto L45;
        char r112 = r111.charAt(r109);
        if (':' == r112) goto L46;
        if (r112 < '0') goto L45;
        if (r112 > '9') goto L45;
        r109 = r109 - 1;
    L46:
        if (r109 != (-1)) goto L48;
        String r113 = r111.substring(r108 + 1);
    L49:
        r103 = Uri.decode(r113);
        goto L50
    L48:
        r113 = r111.substring(r108 + 1, r109);
    L45:
        r109 = -1;
    L53:
        if (StringsKt.contains$default(r103, '\\', false, 2, null) == true) goto L55;
        return r103;
    L55:
        return StringsKt.substringBefore$default(r103, '\\', null, 2, null);
    L9:
        if (StringsKt.contains$default(r101, GXTemplateKey.GAIAX_PE, false, 2, null) != true) goto L11;
        r102 = true;
        goto L12
    L5:
        r100 = r110;
        goto L6
    }
}
