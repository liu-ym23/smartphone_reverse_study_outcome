package swb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class k {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> String b(T r100) {
        if (r100 != 0) goto L6;
        return "";
    L6:
        if ((r100 instanceof JSONObject) == false) goto L10;
        return ((JSONObject) r100).toString();
    L10:
        if ((r100 instanceof org.json.JSONObject) == false) goto L14;
        return ((org.json.JSONObject) r100).toString();
    L14:
        return JSON.toJSONString(r100);
    }

    public static <T> String a(String r100, T r101) {
    L18:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c("JsonUtils", "Combine requested contents fail : ", e);
        return null;
    L3:
        if (TextUtils.isEmpty(r100) == true) goto L17;
        Object[] r102 = new Object[2];     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r100) == true) goto L15;
        if (r100.contains("(") == true) goto L13;
        if (r100.contains(")") == true) goto L13;
        r102[0] = r100;     // Catch: Exception -> L18
        r102[1] = b(r101);     // Catch: Exception -> L18
        return String.format("%s(%s)", r102).replace("\n", "\\n");
    L13:
        throw new IllegalArgumentException("function name can't contain brackets");     // Catch: Exception -> L18
    L15:
        throw new NullPointerException("function name must not be null");     // Catch: Exception -> L18
    L17:
        throw new IllegalArgumentException("js func empty !");     // Catch: Exception -> L18
    }
}
