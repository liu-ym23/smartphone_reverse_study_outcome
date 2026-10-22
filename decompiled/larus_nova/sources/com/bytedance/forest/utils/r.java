package com.bytedance.forest.utils;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    static {
    }

    public static com.bytedance.forest.model.j a(String r110, String r111) {
        if (r110.length() <= 0) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == true) goto L9;
    L74:
        return null;
    L9:
        if (r111.length() <= 0) goto L11;
        boolean r101 = true;
    L12:
        if (r101 == false) goto L74;
        Integer r102 = Integer.valueOf(StringsKt.indexOf$default(r110, '?', 0, false, 6, null));
        if (r102.intValue() == (-1)) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == true) goto L20;
        r102 = null;
    L20:
        if (r102 == null) goto L22;
        r110 = r110.substring(0, r102.intValue());
    L22:
        Integer r104 = Integer.valueOf(StringsKt.indexOf$default(r110, '#', 0, false, 6, null));
        if (r104.intValue() == (-1)) goto L25;
        boolean r105 = true;
    L26:
        if (r105 == true) goto L30;
        r104 = null;
    L30:
        if (r104 == null) goto L37;
        int r106 = r104.intValue();
        if (r110 == null) goto L35;
        r110 = r110.substring(0, r106);
        goto L37
    L35:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L37:
        if ((!TextUtils.isEmpty(StringsKt.trim(r111).toString())) == true) goto L40;
        r111 = null;
    L40:
        if (r111 == null) goto L74;
        if (StringsKt.endsWith$default(r111, '/', false, 2, null) == true) goto L44;
        r111 = r111.concat(HTTP.URL_DEFAULT);
    L44:
        Integer r107 = Integer.valueOf(StringsKt.indexOf$default(r110, r111, 0, false, 6, null));
        if (r107.intValue() == (-1)) goto L47;
        boolean r108 = true;
    L48:
        if (r108 == true) goto L51;
        r107 = null;
    L51:
        if (r107 == null) goto L74;
        int r109 = r107.intValue() + r111.length();
        if (r110 == null) goto L73;
        String r112 = r110.substring(r109);
        Integer r113 = Integer.valueOf(StringsKt.indexOf$default(r112, '/', 0, false, 6, null));
        if (r113.intValue() == (-1)) goto L57;
        boolean r114 = true;
    L58:
        if (r114 == true) goto L61;
        r113 = null;
    L61:
        if (r113 == null) goto L74;
        int r115 = r113.intValue();
        if (r112 == null) goto L71;
        String r116 = r112.substring(0, r115);
        String r117 = r112.substring(r115 + 1);
        if ((!StringsKt.isBlank(r116)) == false) goto L74;
        if ((!StringsKt.isBlank(r117)) == false) goto L74;
        return new com.bytedance.forest.model.j("", r116, r117);
    L71:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L57:
        r114 = false;
        goto L58
    L73:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L47:
        r108 = false;
        goto L48
    L25:
        r105 = false;
        goto L26
    L16:
        r103 = false;
        goto L17
    L11:
        r101 = false;
        goto L12
    L5:
        r100 = false;
        goto L7
    }
}
