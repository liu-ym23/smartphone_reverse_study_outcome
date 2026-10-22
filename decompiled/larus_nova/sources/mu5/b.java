package mu5;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static <T> JSONObject a(T r100) {
        String r101 = e(r100);
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return new JSONObject();
    L7:
        return JSON.parseObject(r101);
    }

    public static void b(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L12;
        if (r100.contains("(") == true) goto L10;
        if (r100.contains(")") == true) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("function name can't contain brackets");
    L12:
        throw new NullPointerException("function name must not be null");
    }

    public static String c(String r100) {
    L8:
        e = move-exception;
        tt5.a.e("JsonUtils", "Combine requested contents fail : ", e, false);
        return null;
    L3:
        if (TextUtils.isEmpty(r100) == true) goto L7;
        b(r100);     // Catch: Exception -> L8
        return r100.replace("\n", "\\n");
    L7:
        throw new IllegalArgumentException("js func empty !");     // Catch: Exception -> L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> String e(T r100) {
        if (r100 != 0) goto L6;
        return "";
    L6:
        if ((r100 instanceof JSONObject) == false) goto L10;
        return ((JSONObject) r100).toString();
    L10:
        return JSON.toJSONString(r100);
    }

    public static <T> String d(String r100, T r101) {
    L9:
        e = move-exception;
        tt5.a.e("JsonUtils", "Combine requested contents fail : ", e, false);
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L8;
        b(r100);     // Catch: Exception -> L9
        return String.format("%s(%s)", new Object[]{r100, e(r101)}).replace("\n", "\\n");
    L8:
        throw new IllegalArgumentException("js func empty !");     // Catch: Exception -> L9
    }
}
