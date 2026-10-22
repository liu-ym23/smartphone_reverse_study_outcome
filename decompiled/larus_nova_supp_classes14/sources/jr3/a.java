package jr3;

import com.bytedance.ies.bullet.service.sdk.d;
import com.bytedance.ies.bullet.service.sdk.e;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y36.i;
import y36.p;
import y36.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends e {
    public final String getName() {
        return "AnniePro";
    }

    public a() {
    }

    public final boolean b(d r13) {
        Intrinsics.checkNotNullParameter(r13, "schemaData");
        Object r0 = ((i) new y36.a(r13, "enable_annie_pro", Boolean.FALSE)).b;
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == true) goto L5;
        return true;
    L5:
        r13.a("__x_param_annie_pro", new y36.a(r1), false);
        String r2 = (String) ((LinkedHashMap) r13.p).get("app_id");
        if (r2 == null) goto L33;
        String r3 = (String) ((LinkedHashMap) r13.p).get("local_host");
        String r4 = (String) ((LinkedHashMap) r13.p).get("start_page");
        if (r3 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        String r6 = "";
        if (r5 == false) goto L24;
        StringBuilder r7 = new StringBuilder();
        int r8 = kr3.a.a;
        int r9 = hr3.a.a;
        Intrinsics.checkNotNullParameter("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application/", "path");
        if (StringsKt.isBlank("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application/") == false) goto L20;
    L23:
        r7.append(r6);
        r7.append(r2);
        r7.append(kr3.a.a(r4));
        String r10 = r7.toString();
    L32:
        r13.i("surl");
        r13.a("url", new s(UriProtector.parse(r10)), true);
        r13.a("bdhm_bid", new p(r2), true);
        r13.a("group", new p(r2), true);
        goto L33
    L20:
        if (StringsKt.endsWith$default("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application/", "/", false, 2, null) == false) goto L22;
        r6 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application/";
        goto L23
    L22:
        r6 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application//";
        goto L23
    L24:
        StringBuilder r11 = new StringBuilder();
        int r12 = kr3.a.a;
        Intrinsics.checkNotNullParameter(r3, "path");
        if (StringsKt.isBlank(r3) == false) goto L28;
    L31:
        r11.append(r6);
        r11.append(kr3.a.a(r4));
        r10 = r11.toString();
        goto L32
    L28:
        if (StringsKt.endsWith$default(r3, "/", false, 2, null) == false) goto L30;
        r3 = r3.substring(0, r3.length() - 1);
    L30:
        r6 = r3;
        goto L31
    L10:
        if (r3.length() == 0) goto L13;
        r5 = false;
    L33:
        return true;
    }
}
