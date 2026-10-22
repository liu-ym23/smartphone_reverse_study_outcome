package com.ss.ugc.effectplatform.util;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f458040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f458041b = null;

    static {
        f458041b = new LinkedHashMap();
    }

    public static String a(ModelInfo r100) {
        return r100.getName() + "_v" + r100.getVersion() + "_size" + r100.getType() + "_md5" + ilc.b.a(r100) + ".model";
    }

    public static String b(String r110) {
        if (StringsKt.contains$default(r110, "md5", false, 2, null) == true) goto L5;
        return null;
    L5:
        int r100 = StringsKt.indexOf$default(r110, "md5", 0, false, 6, null);
        int r101 = StringsKt.lastIndexOf$default(r110, "_model", 0, false, 6, null);
        if (r101 != (-1)) goto L12;
        r101 = StringsKt.lastIndexOf$default(r110, ".model", 0, false, 6, null);
    L12:
        return r110.substring(r100 + 3, r101);
    L14:
        return null;
    }

    public static String d(String r100) {
        if (f458040a == false) goto L15;
        Map<String, String> r101 = f458041b;
        String r102 = (String) ((LinkedHashMap) r101).get(r100);
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L13;
        return r102;
    L13:
        String r104 = c(r100, "_v[0-9]+[\\._][0-9]+[\\._](size[0-9]+_md5[a-z0-9]+_)?(model|dat|bin|bytenn|zip)");
        r101.put(r100, r104);
        return r104;
    L7:
        if (r102.length() == 0) goto L10;
        r103 = false;
        goto L11
    L15:
        return c(r100, "_v[0-9]");
    }

    public static int e(String r110) {
        if (StringsKt.contains$default(r110, "size", false, 2, null) == true) goto L5;
        return 0;
    L5:
        int r100 = StringsKt.lastIndexOf$default(r110, "size", 0, false, 6, null);
        if (StringsKt.contains$default(r110, "md5", false, 2, null) == false) goto L8;
        int r101 = bytekn.foundation.utils.g.f21810a;
        int r102 = bytekn.foundation.utils.g.a.a(r110, "_md5");
    L10:
        if (r100 < r102) goto L16;
        return -1;
    L16:
        return CastIntegerProtector.parseInt(r110.substring(r100 + 4, r102));
    L18:
        return -1;
    L8:
        int r103 = bytekn.foundation.utils.g.f21810a;
        r102 = bytekn.foundation.utils.g.a.a(r110, "\\.model|_model|\\.dat");
        goto L10
    }

    public static String f(String r110) {
        StringsKt.lastIndexOf$default(r110, HTTP.URL_DEFAULT, 0, false, 6, null);
        int r100 = StringsKt.lastIndexOf$default(r110, "_v", 0, false, 6, null);
        int r101 = bytekn.foundation.utils.g.f21810a;
        int r102 = bytekn.foundation.utils.g.a.a(r110, "\\.model|_model|\\.dat");
        if (r100 > 0) goto L7;
        return "1.0";
    L7:
        return r110.substring(r100 + 2, r102);
    }

    public static String c(String r100, String r101) {
        int r102 = StringsKt.lastIndexOf$default(r100, HTTP.URL_DEFAULT, 0, false, 6, null);
        int r103 = bytekn.foundation.utils.g.f21810a;
        int r104 = bytekn.foundation.utils.g.a.a(r100, r101);
        int r105 = o.f458045a;
        int r106 = r102 + 1;
        if (r.b(r100) == true) goto L14;
        if (r106 < 0) goto L14;
        if (r104 < 0) goto L14;
        if (r106 >= r104) goto L14;
        if (r106 >= r100.length()) goto L14;
        if (r104 > r100.length()) goto L14;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L21;
        if (r100 == null) goto L20;
        return r100.substring(r106, r104);
    L20:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L21:
        int r108 = bytekn.foundation.utils.g.a.a(r100, "\\.model|_model|\\.dat");
        if (r108 <= 0) goto L29;
        if (r108 <= r102) goto L29;
        if (r100 == null) goto L27;
        return r100.substring(r106, r108);
    L27:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L29:
        return r100.substring(r106, r100.length());
    L14:
        r107 = false;
        goto L16
    }
}
