package qb4;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.bdturing.EventReport;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.C7305b f532325a;

    public c(b.C7305b r100) {
        this.f532325a = r100;
    }

    @Override // qb4.f
    public final void onFail(int r100, JSONObject r110) {
        if (r100 != 10) goto L21;
        if (r110 == null) goto L21;
        if (TextUtils.isEmpty(r110.optString("decision")) == true) goto L21;
        String r101 = r110.optString("decision");
        JSONObject r111 = r110.optJSONObject("query");
        b.C7305b r102 = this.f532325a;
        b r103 = r102.f532314d;
        Activity r104 = r102.f532311a;
        f r105 = r102.f532312b;
        r103.f532305d = 0;
        if (r105 != null) goto L11;
        return;
    L11:
        if (r104 != null) goto L13;
    L14:
        r105.onFail(1, null);
    L15:
        jc4.m r106 = new jc4.m(r101);
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L18
        r107.put("key", "verify_protect_start");     // Catch: Exception -> L18
        r107.put("custom", r101);     // Catch: Exception -> L18
        EventReport.w("turing_verify_sdk", r107, r106);     // Catch: Exception -> L18
    L20:
        r106.f498097h = 3;
        r103.j(r104, r106, new d(r105, r106, r111), true);
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L13:
        if (TextUtils.isEmpty(r101) == false) goto L15;
    L21:
        this.f532325a.f532312b.onFail(r100, r110);
    }

    @Override // qb4.f
    public final void onSuccess(int r100, JSONObject r101) {
        this.f532325a.f532312b.onSuccess(r100, r101);
    }
}
