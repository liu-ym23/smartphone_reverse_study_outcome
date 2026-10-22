package com.bytedance.lark.qrsdk;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class b {
    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
        JSONObject r101 = new JSONObject(r100).optJSONObject("qrlogin");     // Catch: JSONException -> L15
        if (r101 == null) goto L13;
        String r102 = r101.optString("token");     // Catch: JSONException -> L15
        if (r102 == null) goto L13;
        if (r102.length() <= 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        return r102;
    L10:
        r103 = false;
    L13:
        return null;
    }

    public static boolean b(String r110) {
        Intrinsics.checkNotNullParameter(r110, TemplateNodeType.RAW);
        if (StringsKt.startsWith$default(r110, "https://accounts.feishu.cn/accounts/page/qrlogin/doubao", false, 2, null) == false) goto L45;
        String r100 = StringsKt.substringBefore$default(StringsKt.substringAfter(r110, '?', ""), '#', null, 2, null);
        if (r100.length() != 0) goto L7;
        boolean r111 = true;
    L8:
        if (r111 == true) goto L36;
        List r112 = StringsKt.split$default(r100, new String[]{"&"}, false, 0, 6, null);
        if ((r112 instanceof Collection) == true) goto L13;
    L15:
        Iterator r113 = r112.iterator();
    L17:
        if (r113.hasNext() == false) goto L36;
        String r101 = (String) r113.next();
        int r102 = StringsKt.indexOf$default(r101, com.alipay.sdk.m.n.a.f25612h, 0, false, 6, null);
        if (r102 < 0) goto L21;
        String r103 = r101.substring(0, r102);
    L22:
        if (r102 < 0) goto L24;
        String r104 = r101.substring(r102 + 1);
    L26:
        if (Intrinsics.areEqual(r103, "token") == true) goto L28;
    L33:
        boolean r105 = false;
    L34:
        if (r105 == false) goto L17;
        boolean r114 = true;
    L37:
        if (r114 == false) goto L46;
        return true;
    L46:
        return false;
    L28:
        if (r104.length() <= 0) goto L30;
        boolean r106 = true;
    L31:
        if (r106 == false) goto L33;
        r105 = true;
        goto L34
    L30:
        r106 = false;
        goto L31
    L24:
        r104 = "";
        goto L26
    L21:
        r103 = r101;
        goto L22
    L13:
        if (r112.isEmpty() == false) goto L15;
    L36:
        r114 = false;
        goto L37
    L7:
        r111 = false;
        goto L8
    L45:
        return false;
    }
}
