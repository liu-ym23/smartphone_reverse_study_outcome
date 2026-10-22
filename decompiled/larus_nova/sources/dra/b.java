package dra;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f469800a;

    public b() {
    }

    public final void c() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L11
        Bundle r101 = this.f469800a;     // Catch: Exception -> L11
        if (r101 == null) goto L21;
        Iterator<String> r102 = r101.keySet().iterator();     // Catch: Exception -> L11
    L6:
        if (r102.hasNext() == false) goto L22;
        String r103 = r102.next();     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r103) == true) goto L6;
        r100.put(r103, this.f469800a.get(r103));     // Catch: Exception -> L11
        goto L6
    L22:
        return;
    L21:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    public final void b(String r100) {
        a("params_for_special", "uc_login");
    }

    public final void a(String r100, Object r101) {
        if (this.f469800a != null) goto L8;
        this.f469800a = new Bundle();
    L8:
        this.f469800a.putString(r100, r101.toString());     // Catch: Exception -> L7
        return;
    }
}
