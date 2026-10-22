package rv3;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.net.URLEncoder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k {
    public static final Gson a = null;

    static {
        a = new Gson();
    }

    public static String b(String r18) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(URLEncoder.encode(r18, "UTF-8"), "+", "%20", false, 4, null), "%21", "!", false, 4, null), "%27", "'", false, 4, null), "%28", "(", false, 4, null), "%29", ")", false, 4, null), "%7E", "~", false, 4, null);
    }

    public static String a(i r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter("db_1GFLTGc", "appId");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "routeMode");
        String r7 = GsonProtectorUtils.toJson(a, r3);
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = new StringBuilder("navigation_page?pageData=");
        Intrinsics.checkNotNull(r7);
        r1.append(b(r7));
        r0.append(r1.toString());
        if (r5 != null) goto L5;
    L10:
        if (r6 == null) goto L18;
        if (StringsKt.isBlank(r6) == false) goto L15;
        r6 = null;
    L15:
        if (r6 == null) goto L18;
        r0.append("&widget_instance_id=" + b(r6));
    L18:
        return "sslocal://doubao_apps?app_id=db_1GFLTGc&path=" + b(r0.toString()) + "&env_version=release&route_mode=" + r4;
    L5:
        if (StringsKt.isBlank(r5) == false) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L10;
        r0.append("&trace_id=" + b(r5));
        goto L10
    }
}
