package ec4;

import android.text.TextUtils;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import jc4.m;
import org.json.JSONObject;
import qb4.n;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements qb4.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f472080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean[] f472081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f472082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ jc4.a f472083d;

    @Override // qb4.f
    public final void onFail(int r100, JSONObject r101) {
        Objects.toString(r101);
        int r102 = n.f532367a;
        this.f472080a.countDown();
    }

    @Override // qb4.f
    public final void onSuccess(int r100, JSONObject r101) {
        this.f472081b[0] = true;
        if (r101 != null) goto L5;
    L7:
        jc4.a r102 = this.f472083d;
        Map r103 = this.f472082c;
        if (r102 != null) goto L10;
    L20:
        this.f472080a.countDown();
        return;
    L10:
        if (TextUtils.isEmpty(r102.f498098i) == true) goto L20;
        JSONObject r104 = new JSONObject(r102.f498098i);     // Catch: Exception -> L18
        Iterator<String> r105 = r104.keys();     // Catch: Exception -> L18
    L13:
        if (r105.hasNext() == false) goto L20;
        String r106 = r105.next();     // Catch: Exception -> L18
        String r107 = r104.optString(r106, "");     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r107) == true) goto L13;
        r103.put(r106, r107);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L5:
        if (TextUtils.isEmpty(r101.optString(LoginVerifyService.X_TT_TOKEN)) == true) goto L7;
        this.f472082c.put(LoginVerifyService.X_TT_TOKEN, r101.optString(LoginVerifyService.X_TT_TOKEN));
        goto L7
    }

    public e(CountDownLatch r100, boolean[] r101, Map r102, m r103) {
        this.f472080a = r100;
        this.f472081b = r101;
        this.f472082c = r102;
        this.f472083d = r103;
    }
}
