package yhc;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class l0 {
    public static void a(JSONObject r100, String r101, Object r102) {
        if (TextUtils.isEmpty(r101) == true) goto L13;
        if (r102 == null) goto L14;
        r100.put(r101, r102);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        return;
    }
}
