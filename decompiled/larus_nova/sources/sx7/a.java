package sx7;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    static {
    }

    public static JSONObject a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return null;
    L10:
        return new JSONObject(r100);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
