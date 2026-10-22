package jr3;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ies.bullet.service.sdk.d;
import com.bytedance.ies.bullet.service.sdk.e;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y36.p;
import y36.s;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends e {
    @Override // t36.e
    public final String getName() {
        return "AnniePro";
    }

    public a() {
    }

    @Override // t36.e
    public final boolean b(d r110) {
        Intrinsics.checkNotNullParameter(r110, "schemaData");
        T r100 = new y36.a(r110, "enable_annie_pro", Boolean.FALSE).f565862b;
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == true) goto L5;
        return true;
    L5:
        r110.a("__x_param_annie_pro", new y36.a(r101), false);
        String r102 = (String) ((LinkedHashMap) r110.f248139p).get("app_id");
        if (r102 == null) goto L33;
        String r103 = (String) ((LinkedHashMap) r110.f248139p).get("local_host");
        String r104 = (String) ((LinkedHashMap) r110.f248139p).get("start_page");
        if (r103 != null) goto L10;
    L13:
        boolean r105 = true;
    L14:
        String r106 = "";
        if (r105 == false) goto L24;
        StringBuilder r107 = new StringBuilder();
        int r108 = kr3.a.f505704a;
        int r109 = hr3.a.f486858a;
        Intrinsics.checkNotNullParameter("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application/", "path");
        if (StringsKt.isBlank("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application/") == false) goto L20;
    L23:
        r107.append(r106);
        r107.append(r102);
        r107.append(kr3.a.a(r104));
        String r111 = r107.toString();
    L32:
        r110.i("surl");
        r110.a("url", new s(UriProtector.parse(r111)), true);
        r110.a("bdhm_bid", new p(r102), true);
        r110.a("group", new p(r102), true);
        goto L33
    L20:
        if (StringsKt.endsWith$default("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application/", HTTP.URL_DEFAULT, false, 2, null) == false) goto L22;
        r106 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application/";
        goto L23
    L22:
        r106 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application//";
        goto L23
    L24:
        StringBuilder r112 = new StringBuilder();
        int r113 = kr3.a.f505704a;
        Intrinsics.checkNotNullParameter(r103, "path");
        if (StringsKt.isBlank(r103) == false) goto L28;
    L31:
        r112.append(r106);
        r112.append(kr3.a.a(r104));
        r111 = r112.toString();
        goto L32
    L28:
        if (StringsKt.endsWith$default(r103, HTTP.URL_DEFAULT, false, 2, null) == false) goto L30;
        r103 = r103.substring(0, r103.length() - 1);
    L30:
        r106 = r103;
        goto L31
    L10:
        if (r103.length() == 0) goto L13;
        r105 = false;
    L33:
        return true;
    }
}
