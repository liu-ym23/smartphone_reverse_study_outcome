package rv3;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes14.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f539402a = null;

    static {
        f539402a = new Gson();
    }

    public static String b(String r110) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(URLEncoder.encode(r110, "UTF-8"), Marker.ANY_NON_NULL_MARKER, "%20", false, 4, null), "%21", "!", false, 4, null), "%27", "'", false, 4, null), "%28", "(", false, 4, null), "%29", ")", false, 4, null), "%7E", Constants.WAVE_SEPARATOR, false, 4, null);
    }

    public static String a(i r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter("db_1GFLTGc", "appId");
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "routeMode");
        String r104 = GsonProtectorUtils.toJson(f539402a, r100);
        StringBuilder r105 = new StringBuilder();
        StringBuilder r106 = new StringBuilder("navigation_page?pageData=");
        Intrinsics.checkNotNull(r104);
        r106.append(b(r104));
        r105.append(r106.toString());
        if (r102 != null) goto L5;
    L10:
        if (r103 == null) goto L18;
        if (StringsKt.isBlank(r103) == false) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L18;
        r105.append("&widget_instance_id=" + b(r103));
    L18:
        return "sslocal://doubao_apps?app_id=db_1GFLTGc&path=" + b(r105.toString()) + "&env_version=release&route_mode=" + r101;
    L5:
        if (StringsKt.isBlank(r102) == false) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L10;
        r105.append("&trace_id=" + b(r102));
        goto L10
    }
}
