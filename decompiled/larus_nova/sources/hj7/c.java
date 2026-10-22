package hj7;

import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.bytedance.ug.sdk.luckycat.impl.utils.w;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f485434a;

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.ug.sdk.luckycat.impl.manager.m r100 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(IBridgeContext r100) {
            this.f485434a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f485435a;

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.ug.sdk.luckycat.impl.manager.m r100 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(IBridgeContext r100) {
            this.f485435a = r100;
        }
    }

    /* JADX INFO: renamed from: hj7.c$c, reason: collision with other inner class name */
    public class RunnableC6155c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f485436a;

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.ug.sdk.luckycat.impl.manager.m r100 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC6155c(String r100, IBridgeContext r101) {
            this.f485436a = r101;
        }
    }

    public c() {
    }

    @BridgeMethod("luckycatAuthWX")
    public void wxAuth(@BridgeContext IBridgeContext r100) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBridge3", "3.0: luckycatAuthWX");
        if (w.a("com.tencent.mm") == true) goto L11;
        JSONObject r101 = new JSONObject();
        r101.put("error_code", 90021);     // Catch: JSONException -> L7
        r101.put("error_msg", "wx_not_install");     // Catch: JSONException -> L7
    L9:
        r100.callback(hj7.a.a(0, r101, "failed"));
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L11:
        rj7.c.a(new a(r100));
    }

    @BridgeMethod("wx_auth")
    public void wxAuthOld(@BridgeContext IBridgeContext r100) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBridge3", "3.0: wx_auth");
        if (w.a("com.tencent.mm") == true) goto L11;
        JSONObject r101 = new JSONObject();
        r101.put("error_code", 90021);     // Catch: JSONException -> L7
        r101.put("error_msg", "wx_not_install");     // Catch: JSONException -> L7
    L9:
        r100.callback(hj7.a.a(0, r101, "failed"));
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L11:
        rj7.c.a(new b(r100));
    }

    @BridgeMethod("luckycatAuthAlipay")
    public void aplipayAuth(@BridgeContext IBridgeContext r100, @BridgeParam(ComplianceResult.JsonKey.AUTH_INFO) String r101) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBridge3", "3.0: luckycatAuthAlipay");
        if (w.a(com.alipay.sdk.m.u.n.f25868b) == true) goto L11;
        JSONObject r102 = new JSONObject();
        r102.put("error_code", 90021);     // Catch: JSONException -> L7
        r102.put("error_msg", "wx_not_install");     // Catch: JSONException -> L7
    L9:
        r100.callback(hj7.a.a(0, r102, "failed"));
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L11:
        rj7.c.a(new RunnableC6155c(r101, r100));
    }
}
