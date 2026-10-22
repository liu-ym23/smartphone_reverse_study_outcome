package kk4;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import pk4.i;
import pk4.j;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile b f503793a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f503794a = null;

        static {
            f503794a = new c();
        }
    }

    public static b a() {
        String r100 = i.a.f529628a.f529627a.getString("dora_x_link_common_config", "");
        if (TextUtils.isEmpty(r100) == false) goto L7;
        j.d("DoraXLinkCommonConfigCenter", "loadCache empty");
        return null;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L21;
    L12:
        b r101 = null;
    L13:
        if (r101 != null) goto L15;
    L19:
        j.d("DoraXLinkCommonConfigCenter", "loadCache invalid");
        return null;
    L15:
        if (r101.d() == false) goto L19;
        j.d("DoraXLinkCommonConfigCenter", "loadCache success");
        return r101;
    L21:
        r101 = new b(b.a.b(new JSONObject(r100).optJSONObject("Android")));     // Catch: JSONException -> L11
        goto L13
    }

    public c() {
    }
}
