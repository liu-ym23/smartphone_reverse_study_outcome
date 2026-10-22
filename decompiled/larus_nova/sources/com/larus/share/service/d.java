package com.larus.share.service;

import android.net.Uri;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final String a(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(BdpAppEventConstant.SHARE_ID, "paramKey");
        Intrinsics.checkNotNullParameter(r111, "paramValue");
        if (StringsKt.isBlank(r110) == false) goto L5;
        return r110;
    L5:
        if (StringsKt.isBlank(r111) == true) goto L64;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L53
        URI r101 = new URI(r110);     // Catch: Throwable -> L53
        String r102 = r101.getScheme();     // Catch: Throwable -> L53
        if (r102 == null) goto L10;
        String r103 = r102.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L53
    L12:
        if (Intrinsics.areEqual(r103, "http") == false) goto L14;
    L15:
        String r104 = r101.getHost();     // Catch: Throwable -> L53
        boolean r105 = true;
        if (r104 != null) goto L18;
    L21:
        boolean r106 = true;
    L22:
        if (r106 == true) goto L31;
        String r107 = c(r110, BdpAppEventConstant.SHARE_ID);     // Catch: Throwable -> L53
        if (r107 != null) goto L27;
    L30:
        if (r105 == false) goto L31;
        int r108 = StringsKt.indexOf$default(r110, '#', 0, false, 6, null);     // Catch: Throwable -> L53
        if (r108 < 0) goto L36;
        String r109 = r110.substring(0, r108);     // Catch: Throwable -> L53
    L37:
        String r112 = "";
        if (r108 < 0) goto L40;
        String r113 = r110.substring(r108);     // Catch: Throwable -> L53
    L42:
        if (StringsKt.contains$default(r109, '?', false, 2, null) == true) goto L45;
        r112 = "?";
    L50:
        String r114 = r109 + r112 + "share_id=" + URLEncoder.encode(r111, Charsets.UTF_8.name()) + r113;     // Catch: Throwable -> L53
    L51:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L53
    L55:
        Object r116 = r110;
        if (Result.m9455isFailureimpl(r115) == true) goto L60;
        r116 = r115;
    L60:
        return (String) r116;
    L45:
        if (StringsKt.endsWith$default(r109, '?', false, 2, null) == true) goto L50;
        if (StringsKt.endsWith$default(r109, Typography.amp, false, 2, null) == true) goto L50;
        r112 = "&";
        goto L50
    L40:
        r113 = "";
        goto L42
    L36:
        r109 = r110;
        goto L37
    L27:
        if (StringsKt.isBlank(r107) == true) goto L30;
        r105 = false;
    L31:
        r114 = r110;
        goto L51
    L18:
        if (StringsKt.isBlank(r104) == true) goto L21;
        r106 = false;
        goto L22
    L14:
        if (Intrinsics.areEqual(r103, "https") == false) goto L31;
    L10:
        r103 = null;
    L53:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L55
    L64:
        return r110;
    }

    public static String b(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Intrinsics.checkNotNullParameter(r101, "params");
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        String r106 = (String) r104.getValue();
        if (r106 == null) goto L4;
        if ((!StringsKt.isBlank(r106)) == true) goto L11;
        r106 = null;
    L11:
        if (r106 == null) goto L4;
        r102.appendQueryParameter(r105, r106);
        goto L4
    L14:
        return r102.build().toString();
    }

    public static String c(String r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L41;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Object r103 = Result.m9449constructorimpl(new URI(r100).getRawQuery());     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r103) == false) goto L16;
        r103 = null;
    L16:
        String r104 = (String) r103;
        if (r104 == null) goto L42;
        Iterator r105 = StringsKt.split$default(r104, new String[]{"&"}, false, 0, 6, null).iterator();
    L20:
        if (r105.hasNext() == false) goto L43;
        String r106 = (String) r105.next();
        int r107 = StringsKt.indexOf$default(r106, com.alipay.sdk.m.n.a.f25612h, 0, false, 6, null);
        if (r107 > 0) goto L24;
    L29:
        String r108 = null;
    L30:
        if (r108 == null) goto L20;
        return r108;
    L24:
        if (Intrinsics.areEqual(r106.substring(0, r107), r101) == false) goto L29;
        r108 = r106.substring(r107 + 1);
        if ((!StringsKt.isBlank(r108)) == false) goto L29;
    L43:
        return null;
    L42:
        return null;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L41:
        return null;
    }

    @JvmStatic
    public static final String d(JSONObject r100, String r101) {
        String[] r102 = new String[4];
        String r103 = null;
        if (r100 == null) goto L5;
        String r104 = r100.optString(BdpAppEventConstant.SHARE_ID);
    L6:
        r102[0] = r104;
        if (r100 == null) goto L9;
        String r105 = r100.optString("ug_share_id");
    L10:
        r102[1] = r105;
        r102[2] = c(r101, BdpAppEventConstant.SHARE_ID);
        r102[3] = c(r101, "ug_share_id");
        int r106 = 0;
    L11:
        if (r106 >= 4) goto L26;
        String r107 = r102[r106];
        if (r107 == null) goto L22;
        String r108 = StringsKt.trim(r107).toString();
        if (r108 == null) goto L22;
        if (r108.length() <= 0) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L22;
    L23:
        if (r108 != null) goto L25;
        r106 = r106 + 1;
        goto L11
    L25:
        r103 = r108;
        goto L26
    L19:
        r109 = false;
    L22:
        r108 = null;
    L26:
        if (r103 == null) goto L28;
        return r103;
    L28:
        return "x" + UUID.randomUUID();
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
