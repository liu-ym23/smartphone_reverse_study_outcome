package com.bytedance.ee.bear.document.ssr;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.google.gson.Gson;
import com.ss.android.lark.utils.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n {

    public interface a {
        void a(SimpleRequestResult r1, OfflineDoc r2);

        void b(Throwable r1, OfflineDoc r2);

        void c(SimpleRequestResult r1, OfflineDoc r2);
    }

    public n() {
    }

    public static int a(SimpleRequestResult r7, long r8) {
        long r0 = System.currentTimeMillis();
        if (r7 != null) goto L11;
        if (r8 <= 0) goto L11;
        if ((r0 - r8) <= 20000) goto L11;
        return 99999;
    L11:
        if (r7 != null) goto L54;
        return -1;
    L54:
        DATA r4 = r7.data;     // Catch: Exception -> L42
        if (r4 != 0) goto L17;
    L40:
        tt5.a.d("SsrHtmlRequestProcessor", "tryFindInvalidContent empty ");     // Catch: Exception -> L42
    L44:
        int r1 = 99993;
    L45:
        if (r1 == 0) goto L48;
        return r1;
    L48:
        if (r7.code != 0) goto L50;
        return 0;
    L50:
        return -1;
    L17:
        if (TextUtils.isEmpty(r4.toString()) == true) goto L40;
        String r5 = r7.data.toString();     // Catch: Exception -> L42
        Gson r6 = z.a;     // Catch: Exception -> L42
        JSONObject r9 = null;
        if (TextUtils.isEmpty(r5) == false) goto L52;
    L24:
        if (r9 != null) goto L27;
        tt5.a.d("SsrHtmlRequestProcessor", "tryFindInvalidContent error, not json  ");     // Catch: Exception -> L42
    L39:
        r1 = 99994;
        goto L45
    L27:
        if (r9.containsKey("code") == true) goto L29;
    L38:
        tt5.a.d("SsrHtmlRequestProcessor", "tryFindInvalidContent error, not code or data  ");     // Catch: Exception -> L42
        goto L39
    L29:
        if (r9.containsKey("data") == false) goto L38;
        r1 = r9.getIntValue("code");     // Catch: Exception -> L42
        if (r1 == 0) goto L35;
        tt5.a.d("SsrHtmlRequestProcessor", "tryFindInvalidContent error, inner error code " + r1);     // Catch: Exception -> L42
        goto L45
    L35:
        if (TextUtils.isEmpty(r9.getString("data")) == false) goto L37;
        tt5.a.d("SsrHtmlRequestProcessor", "tryFindInvalidContent error, data empty ");     // Catch: Exception -> L42
        goto L39
    L37:
        r1 = 0;
        goto L45
    L52:
        r9 = JSON.parseObject(r5);     // Catch: Throwable -> L51
    L42:
        e = move-exception;
        tt5.a.e("SsrHtmlRequestProcessor", "tryFindInvalidContent empty  ", e, false);
        goto L44
    }
}
