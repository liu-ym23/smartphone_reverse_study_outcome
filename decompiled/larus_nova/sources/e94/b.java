package e94;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f471488a;

    public final String toString() {
        return this.f471488a.toString();
    }

    public b(String r100) {
    L8:
        e = move-exception;
        g94.b.b("SandboxJsonObject", new Object[]{e});
        JSONObject r101 = new JSONObject();
    L10:
        this.f471488a = r101;
        return;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        r101 = new JSONObject();     // Catch: JSONException -> L8
    L12:
        goto L10
    L7:
        r101 = new JSONObject(r100);     // Catch: JSONException -> L8
        goto L12
    }
}
