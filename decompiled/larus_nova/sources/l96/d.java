package l96;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.tencent.open.SocialConstants;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public static final c a(PolarisFileInputStreamWrapper r110) {
        Intrinsics.checkNotNullParameter(r110, "inputStream");
        BufferedReader r100 = new BufferedReader(new InputStreamReader(r110));     // Catch: Exception -> L37
        String r101 = TextStreamsKt.readText(r100);     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r100, null);     // Catch: Exception -> L37
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L37
        String r103 = r102.optString("version", "");     // Catch: Exception -> L37
        JSONObject r104 = r102.optJSONObject("android");     // Catch: Exception -> L37
        if (r104 == null) goto L8;
        JSONArray r105 = r104.optJSONArray("card_list");     // Catch: Exception -> L37
    L9:
        HashMap r106 = new HashMap();     // Catch: Exception -> L37
        if (r105 == null) goto L12;
        int r107 = r105.length();     // Catch: Exception -> L37
    L13:
        int r108 = 0;
    L14:
        if (r108 >= r107) goto L51;
        if (r105 == null) goto L27;
        JSONObject r109 = r105.optJSONObject(r108);     // Catch: Exception -> L37
        if (r109 == null) goto L27;
        String r111 = r109.optString("card_version", "");     // Catch: Exception -> L37
        String r112 = r109.optString("card_id", "");     // Catch: Exception -> L37
        String r113 = r109.optString("card_template_path", "");     // Catch: Exception -> L37
        r109.optString(SocialConstants.PARAM_APP_DESC);     // Catch: Exception -> L37
        r109.optBoolean("fetch_res", false);     // Catch: Exception -> L37
        ArrayList r114 = new ArrayList();     // Catch: Exception -> L37
        JSONArray r115 = r109.optJSONArray("res_http_prefix");     // Catch: Exception -> L37
        if (r115 == null) goto L26;
        int r116 = r115.length();     // Catch: Exception -> L37
        int r117 = 0;
    L21:
        if (r117 >= r116) goto L26;
        String r118 = r115.optString(r117);     // Catch: Exception -> L37
        if (r118 == null) goto L25;
        r114.add(r118);     // Catch: Exception -> L37
    L25:
        r117 = r117 + 1;     // Catch: Exception -> L37
    L26:
        r109.optJSONObject("extra");     // Catch: Exception -> L37
        r106.put(r112, new a(r111, r112, r113, r114));     // Catch: Exception -> L37
    L27:
        r108 = r108 + 1;     // Catch: Exception -> L37
        goto L14
    L51:
        return new c(r103, r106);
    L12:
        r107 = 0;
        goto L13
    L8:
        r105 = null;
        goto L9
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r100, th);     // Catch: Exception -> L37
        throw th;     // Catch: Exception -> L37
    L37:
        return null;
    }
}
