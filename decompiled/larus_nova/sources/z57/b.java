package z57;

import android.text.TextUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.HashMap;
import org.json.JSONObject;
import y57.d;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f570113b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f570114a;

    public interface a {
    }

    public final void a() {
        HashMap r100 = new HashMap();     // Catch: Throwable -> L31
        com.bytedance.praisedialoglib.manager.a r101 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a;     // Catch: Throwable -> L31
        y57.a r102 = r101.f266636b;     // Catch: Throwable -> L31
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getHost();     // Catch: Throwable -> L31
    L7:
        if (TextUtils.isEmpty(r104) == false) goto L9;
        return;
    L9:
        r100.put("package_name", r101.c());     // Catch: Throwable -> L31
        y57.a r105 = r101.f266636b;     // Catch: Throwable -> L31
        if (r105 == null) goto L12;
        String r106 = r105.getAppId();     // Catch: Throwable -> L31
    L13:
        r100.put("app_id", r106);     // Catch: Throwable -> L31
        r100.put("token", "WGzRHALelikNBSunxKOJhZyBWtAqZCEAcZYTuXzpLRX");     // Catch: Throwable -> L31
        r100.put("source", LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L31
        String r107 = r104 + "/zebra/praise/url";     // Catch: Throwable -> L31
        d r108 = r101.f266635a;     // Catch: Throwable -> L31
        if (r108 == null) goto L17;
        r103 = r108.a(r107, r100);     // Catch: Throwable -> L31
    L17:
        if (TextUtils.isEmpty(r103) == false) goto L20;
        ((com.bytedance.praisedialoglib.manager.d) this.f570114a).a();     // Catch: Throwable -> L31
        return;
    L20:
        JSONObject r109 = new JSONObject(r103);     // Catch: Throwable -> L31
        int r110 = r109.optInt("code");     // Catch: Throwable -> L31
        r109.optString("message");     // Catch: Throwable -> L31
        if (r110 != 0) goto L29;
        JSONObject r111 = r109.optJSONObject("data");     // Catch: Throwable -> L31
        String r112 = "";
        if (r111 == null) goto L26;
        r112 = r111.optString(ComplianceResult.JsonKey.MARKET_DEEP_LINK);     // Catch: Throwable -> L31
    L26:
        if (TextUtils.isEmpty(r112) == true) goto L28;
        com.bytedance.praisedialoglib.manager.d r113 = (com.bytedance.praisedialoglib.manager.d) this.f570114a;     // Catch: Throwable -> L31
        r113.f266650b.f266660a.post(new com.bytedance.praisedialoglib.manager.b(r113, r112));     // Catch: Throwable -> L31
        return;
    L28:
        ((com.bytedance.praisedialoglib.manager.d) this.f570114a).a();     // Catch: Throwable -> L31
        return;
    L29:
        ((com.bytedance.praisedialoglib.manager.d) this.f570114a).a();     // Catch: Throwable -> L31
        return;
    L12:
        r106 = null;
        goto L13
    L5:
        r104 = null;
    L31:
        th = move-exception;
        th.printStackTrace();
        ((com.bytedance.praisedialoglib.manager.d) this.f570114a).a();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(com.bytedance.praisedialoglib.manager.d r100) {
        this.f570114a = r100;
    }
}
