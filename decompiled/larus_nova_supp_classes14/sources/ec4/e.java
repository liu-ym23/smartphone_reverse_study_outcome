package ec4;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import jc4.a;
import jc4.m;
import org.json.JSONObject;
import qb4.f;
import qb4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements f {
    public final /* synthetic */ CountDownLatch a;
    public final /* synthetic */ boolean[] b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ a d;

    public final void onFail(int r1, JSONObject r2) {
        Objects.toString(r2);
        int r3 = n.a;
        this.a.countDown();
    }

    public final void onSuccess(int r5, JSONObject r6) {
        this.b[0] = true;
        if (r6 != null) goto L5;
    L7:
        a r7 = this.d;
        Map r8 = this.c;
        if (r7 != null) goto L10;
    L20:
        this.a.countDown();
        return;
    L10:
        if (TextUtils.isEmpty(r7.i) == true) goto L20;
        JSONObject r0 = new JSONObject(r7.i);     // Catch: Exception -> L18
        Iterator<String> r9 = r0.keys();     // Catch: Exception -> L18
    L13:
        if (r9.hasNext() == false) goto L20;
        String r1 = r9.next();     // Catch: Exception -> L18
        String r2 = r0.optString(r1, "");     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r2) == true) goto L13;
        r8.put(r1, r2);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L5:
        if (TextUtils.isEmpty(r6.optString("X-Tt-Token")) == true) goto L7;
        this.c.put("X-Tt-Token", r6.optString("X-Tt-Token"));
        goto L7
    }

    public e(CountDownLatch r1, boolean[] r2, Map r3, m r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
