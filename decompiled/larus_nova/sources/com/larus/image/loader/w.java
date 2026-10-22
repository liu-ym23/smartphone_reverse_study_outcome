package com.larus.image.loader;

import android.net.Uri;
import com.larus.utils.o0;
import com.larus.utils.y0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class w {
    public static final void a(String r110, String r111, String r112, boolean r113, long r114) {
        Intrinsics.checkNotNullParameter(r110, "result");
        Uri r100 = y0.j(r112);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        String r102 = r100.getHost();     // Catch: Throwable -> L9
    L7:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r103) == false) goto L14;
        r103 = null;
    L14:
        String r104 = (String) r103;
        if (r100 != null) goto L48;
        String r105 = null;
    L20:
        boolean r106 = false;
        if (r105 == null) goto L23;
        int r107 = r105.length();     // Catch: Throwable -> L17
    L25:
        if (r107 > 2) goto L27;
    L35:
        String r108 = null;
    L36:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L17
    L40:
        if (Result.m9455isFailureimpl(r109) == false) goto L42;
        r109 = null;
    L42:
        String r115 = (String) r109;
        if (r113 == false) goto L45;
        String r116 = r112;
    L46:
        com.larus.platform.service.g r117 = com.larus.platform.service.g.f365738a;
        JSONObject r118 = new JSONObject();
        r118.put("result", r110);
        r118.put("biz_tag", o0.a(r111));
        r118.put("server_tag", o0.a(r115));
        r118.put("host_tag", o0.a(r104));
        r118.put("resp_code", r114);
        r118.put("origin_url", o0.a(r116));
        Unit r119 = Unit.INSTANCE;
        r117.monitorEventForSlardar("image_renew_url_monitor", r118, null, null);
        return;
    L45:
        r116 = null;
    L17:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L40
    L27:
        if (r105 != null) goto L29;
    L31:
        if (r106 == false) goto L35;
        int r121 = StringsKt.indexOf$default(r105, '/', 1, false, 4, null);     // Catch: Throwable -> L17
        if (r121 <= 1) goto L35;
        r108 = r105.substring(1, r121);     // Catch: Throwable -> L17
        goto L36
    L29:
        if (r105.charAt(0) != '/') goto L31;
        r106 = true;
        goto L31
    L23:
        r107 = 0;
        goto L25
    L48:
        r105 = r100.getPath();     // Catch: Throwable -> L17
        goto L20
    L6:
        r102 = null;
    L9:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
