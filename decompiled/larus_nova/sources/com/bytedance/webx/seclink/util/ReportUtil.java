package com.bytedance.webx.seclink.util;

import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final class ReportUtil {

    public static final enum ERROR_TYPE extends Enum<ERROR_TYPE> {
        public static final ERROR_TYPE ApiFail = null;
        public static final ERROR_TYPE ApiResultError = null;
        public static final ERROR_TYPE Other = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ERROR_TYPE[] f272650a = null;
        private String type;

        static {
            ERROR_TYPE r100 = new ERROR_TYPE("ApiFail", 0, "ApiRequest");
            ApiFail = r100;
            ERROR_TYPE r101 = new ERROR_TYPE("ApiResultError", 1, "ApiResultError");
            ApiResultError = r101;
            ERROR_TYPE r102 = new ERROR_TYPE("Other", 2, "other");
            Other = r102;
            f272650a = new ERROR_TYPE[]{r100, r101, r102};
        }

        public static ERROR_TYPE[] values() {
            return (ERROR_TYPE[]) f272650a.clone();
        }

        public String getType() {
            return this.type;
        }

        public static ERROR_TYPE valueOf(String r100) {
            return (ERROR_TYPE) a.a(ERROR_TYPE.class, r100);
        }

        public ERROR_TYPE(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final void g(String r100) {
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L5
        r101.put("custom", "");     // Catch: JSONException -> L5
        r101.put("scene", r100);     // Catch: JSONException -> L5
        r101.put("key", "start_pull_setting");     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static final void e(String r100, int r101) {
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L5
        r102.put("type", r100);     // Catch: JSONException -> L5
        r102.put("custom", "index=" + r101);     // Catch: JSONException -> L5
        r102.put("key", "host_schedule");     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static void f(boolean r100, long r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L8
        r104.put("key", "setting");     // Catch: Exception -> L8
        r104.put("duration", r101);     // Catch: Exception -> L8
        if (r100 == false) goto L5;
        int r105 = 1;
    L6:
        r104.put("result", r105);     // Catch: Exception -> L8
        r104.put("host", r102);     // Catch: Exception -> L8
        r104.put("custom", r103);     // Catch: Exception -> L8
        return;
    L5:
        r105 = 0;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static final void b(String r100, String r101, int r102, String r103, int r104) {
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L4
        r105.put("result", r102);     // Catch: JSONException -> L4
        r105.put("biz_tag", r103);     // Catch: JSONException -> L4
        r105.put("mode", r104);     // Catch: JSONException -> L4
        r105.put("key", "handle_load_url");     // Catch: JSONException -> L4
        r105.put("url", r100);     // Catch: JSONException -> L4
        r105.put("scene", r101);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static final void c(String r100, String r101, int r102, String r103, int r104) {
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L4
        r105.put("result", r102);     // Catch: JSONException -> L4
        r105.put("biz_tag", r103);     // Catch: JSONException -> L4
        r105.put("mode", r104);     // Catch: JSONException -> L4
        r105.put("key", "handle_override_url_loading");     // Catch: JSONException -> L4
        r105.put("url", r100);     // Catch: JSONException -> L4
        r105.put("scene", r101);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void d(String r100, String r101, String r102, boolean r103, String r104) {
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L8
        r105.put("url", r100);     // Catch: JSONException -> L8
        r105.put("scene", r101);     // Catch: JSONException -> L8
        if (r103 == false) goto L5;
        int r106 = 1;
    L6:
        r105.put("result", r106);     // Catch: JSONException -> L8
        r105.put("custom", r104);     // Catch: JSONException -> L8
        r105.put("biz_tag", r102);     // Catch: JSONException -> L8
        r105.put("key", com.bytedance.android.ec.core.event.a.KEY_HIT_CACHE);     // Catch: JSONException -> L8
        return;
    L5:
        r106 = 0;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static final void a(boolean r100, String r101, String r102, String r103, String r104, String r105) {
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L8
        r106.put("custom", r105);     // Catch: JSONException -> L8
        r106.put("scene", r103);     // Catch: JSONException -> L8
        r106.put("biz_tag", r104);     // Catch: JSONException -> L8
        r106.put("host", r101);     // Catch: JSONException -> L8
        if (r100 == false) goto L5;
        int r107 = 1;
    L6:
        r106.put("result", r107);     // Catch: JSONException -> L8
        r106.put("url", r102);     // Catch: JSONException -> L8
        r106.put("key", "build_middle_page");     // Catch: JSONException -> L8
        return;
    L5:
        r107 = 0;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void h(String r100, boolean r101, String r102, String r103, String r104, boolean r105, long r106, int r110, String r111, int r112) {
        JSONObject r107 = new JSONObject();     // Catch: JSONException -> L12
        r107.put("host", r100);     // Catch: JSONException -> L12
        r107.put("url", r103);     // Catch: JSONException -> L12
        r107.put("scene", r102);     // Catch: JSONException -> L12
        r107.put("biz_tag", r104);     // Catch: JSONException -> L12
        int r108 = 1;
        if (r101 == false) goto L5;
        int r109 = 1;
    L6:
        r107.put("result", r109);     // Catch: JSONException -> L12
        r107.put("mode", r110);     // Catch: JSONException -> L12
        if (r105 == true) goto L10;
        r108 = 0;
    L10:
        r107.put("show_mid_page", r108);     // Catch: JSONException -> L12
        r107.put("risk", r112);     // Catch: JSONException -> L12
        r107.put("custom", r111);     // Catch: JSONException -> L12
        r107.put("duration", r106);     // Catch: JSONException -> L12
        r107.put("key", "verify");     // Catch: JSONException -> L12
        return;
    L5:
        r109 = 0;
    L12:
        e = move-exception;
        e.printStackTrace();
    }
}
