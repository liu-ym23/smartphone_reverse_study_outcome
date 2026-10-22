package oo7;

import android.text.TextUtils;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f524639a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f524640a;

        public a() {
            this.f524640a = new b(UUID.randomUUID().toString());
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f524641a;

        public b(String r100) {
            this.f524641a = r100;
        }
    }

    public static String a(String r100, String r101) {
        StringBuilder r102 = new StringBuilder("UGLog_");
        r102.append(r100);
        if (r101 == null) goto L8;
        if (TextUtils.isEmpty(r101) == true) goto L8;
        r102.append("_");
        r102.append(r101);
    L8:
        return r102.toString();
    }

    public static String b(String r100, JSONObject r101, a r102) {
        if (r101 != null) goto L4;
    L5:
        if (r102 == null) goto L22;
    L7:
        StringBuffer r103 = new StringBuffer(r100);
        if (r101 != null) goto L10;
    L12:
        if (r102 == null) goto L18;
        if (r102.f524640a == null) goto L18;
        JSONObject r104 = new JSONObject();
        r102.f524640a.getClass();     // Catch: JSONException -> L19
        r104.put(AppbrandHostConstants.SCHEMA_INSPECT.SESSION, r102.f524640a.f524641a);     // Catch: JSONException -> L19
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L19
        r105.put("stages", r104);     // Catch: JSONException -> L19
        r103.append("|xContext:");     // Catch: JSONException -> L19
        r103.append(r105);     // Catch: JSONException -> L19
    L18:
        return r103.toString();
    L10:
        if (r101.length() == 0) goto L12;
        r103.append("|xParam:");
        r103.append(r101);
        goto L12
    L22:
        return r100;
    L4:
        if (r101.length() != 0) goto L7;
        goto L5
    }

    public static void c(String r100, String r101, JSONObject r102, a r103) {
        eo7.a r104 = eo7.a.b.f473353a;
        jo7.c.a(new q(r101, r100, r102, r103));
    }
}
