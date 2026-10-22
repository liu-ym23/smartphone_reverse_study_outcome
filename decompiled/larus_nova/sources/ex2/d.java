package ex2;

import com.bytedance.android.marketing.sdk.impl.utils.f;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class d {
    public static final boolean a(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }

    public static final JSONObject b(Object r100) {
        Gson r101 = f.f162817a;     // Catch: Exception -> L4
        return tv5.a.a(f.f162817a, r100);
    L4:
        return null;
    }

    public static final JSONObject c(String r100) {
        if (r100 != null) goto L14;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L11;
        return new JSONObject(r100);
    L16:
        return null;
    L11:
        return null;
    L14:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }
}
