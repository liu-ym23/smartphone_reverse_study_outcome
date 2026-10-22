package com.bytedance.ee.bear.document.ssr;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.google.gson.Gson;
import com.ss.android.lark.utils.z;

/* JADX INFO: loaded from: classes16.dex */
public final class n {

    public interface a {
        void a(SimpleRequestResult r100, OfflineDoc r101);

        void b(Throwable r100, OfflineDoc r101);

        void c(SimpleRequestResult r100, OfflineDoc r101);
    }

    public n() {
    }

    public static int a(SimpleRequestResult r100, long r101) {
        long r102 = System.currentTimeMillis();
        if (r100 != null) goto L11;
        if (r101 <= 0) goto L11;
        if ((r102 - r101) <= 20000) goto L11;
        return 99999;
    L11:
        if (r100 != null) goto L54;
        return -1;
    L54:
        DATA r103 = r100.data;     // Catch: Exception -> L42
        if (r103 != 0) goto L17;
    L40:
        tt5.a.d("SsrHtmlRequestProcessor", "tryFindInvalidContent empty ");     // Catch: Exception -> L42
    L44:
        int r104 = 99993;
    L45:
        if (r104 == 0) goto L48;
        return r104;
    L48:
        if (r100.code != 0) goto L50;
        return 0;
    L50:
        return -1;
    L17:
        if (TextUtils.isEmpty(r103.toString()) == true) goto L40;
        String r105 = r100.data.toString();     // Catch: Exception -> L42
        Gson r106 = z.f444793a;     // Catch: Exception -> L42
        JSONObject r107 = null;
        if (TextUtils.isEmpty(r105) == false) goto L52;
    L24:
        if (r107 != null) goto L27;
        tt5.a.d("SsrHtmlRequestProcessor", "tryFindInvalidContent error, not json  ");     // Catch: Exception -> L42
    L39:
        r104 = 99994;
        goto L45
    L27:
        if (r107.containsKey("code") == true) goto L29;
    L38:
        tt5.a.d("SsrHtmlRequestProcessor", "tryFindInvalidContent error, not code or data  ");     // Catch: Exception -> L42
        goto L39
    L29:
        if (r107.containsKey("data") == false) goto L38;
        r104 = r107.getIntValue("code");     // Catch: Exception -> L42
        if (r104 == 0) goto L35;
        tt5.a.d("SsrHtmlRequestProcessor", "tryFindInvalidContent error, inner error code " + r104);     // Catch: Exception -> L42
        goto L45
    L35:
        if (TextUtils.isEmpty(r107.getString("data")) == false) goto L37;
        tt5.a.d("SsrHtmlRequestProcessor", "tryFindInvalidContent error, data empty ");     // Catch: Exception -> L42
        goto L39
    L37:
        r104 = 0;
        goto L45
    L52:
        r107 = JSON.parseObject(r105);     // Catch: Throwable -> L51
    L42:
        e = move-exception;
        tt5.a.e("SsrHtmlRequestProcessor", "tryFindInvalidContent empty  ", e, false);
        goto L44
    }
}
