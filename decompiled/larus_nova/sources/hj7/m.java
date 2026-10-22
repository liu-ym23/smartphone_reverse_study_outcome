package hj7;

import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<ij7.i> f485457a;

    public class a implements qj7.g.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f485458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f485459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f485460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f485461d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f485462e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ m f485463f;

        @Override // qj7.g.e
        public final void onSuccess(String r100) {
            JSONObject r101 = new JSONObject();     // Catch: Throwable -> L12
            r101.put("error_code", 200);     // Catch: Throwable -> L12
            r101.put("is_succ", "succ");     // Catch: Throwable -> L12
            r101.put("error_message", "success");     // Catch: Throwable -> L12
            r101.put("res_data", new JSONObject(r100));     // Catch: Throwable -> L12
            if (this.f485458a == false) goto L6;
            int r102 = 1;
        L7:
            r101.put("force_request", r102);     // Catch: Throwable -> L12
            r101.put("url", this.f485459b);     // Catch: Throwable -> L12
            if (this.f485458a == true) goto L10;
            r101.put("prefetch_status", 3);     // Catch: Throwable -> L12
            r101.put("prefetch_error_msg", this.f485460c.optString("prefetch_error_msg", ""));     // Catch: Throwable -> L12
        L10:
            this.f485461d.callback(hj7.a.a(1, r101, "success"));     // Catch: Throwable -> L12
            return;
        L6:
            r102 = 0;
        L12:
            th = move-exception;
            this.f485461d.callback(hj7.a.a(0, null, th.toString()));
        }

        @Override // qj7.g.e
        public final void onFailed(int r100, String r110) {
            JSONObject r101 = new JSONObject();
            r101.put("is_succ", "fail");     // Catch: Throwable -> L14
            r101.put("error_code", r100);     // Catch: Throwable -> L14
            r101.put("error_message", r110);     // Catch: Throwable -> L14
            r101.put("url", this.f485459b);     // Catch: Throwable -> L14
            if (this.f485458a == false) goto L6;
            int r102 = 1;
        L7:
            r101.put("force_request", r102);     // Catch: Throwable -> L14
            if (this.f485458a == true) goto L10;
            r101.put("prefetch_status", 3);     // Catch: Throwable -> L14
            r101.put("prefetch_error_msg", this.f485460c.optString("prefetch_error_msg", ""));     // Catch: Throwable -> L14
        L10:
            String r103 = this.f485462e;     // Catch: Throwable -> L14
            String r104 = this.f485459b;     // Catch: Throwable -> L14
            ij7.i r105 = this.f485463f.f485457a.get();     // Catch: Throwable -> L14
            if (r105 == null) goto L16;
            this.f485461d.getWebView();     // Catch: Throwable -> L14
            com.bytedance.ug.sdk.luckycat.impl.manager.m r106 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;     // Catch: Throwable -> L14
            StringBuilder r107 = new StringBuilder("ug_sdk_luckycat_webview_fetch_error_;error:");     // Catch: Throwable -> L14
            r107.append("FetchError{method='" + r103 + "', url='" + r104 + "', errorMessage='" + r110 + "', errorCode=" + r100 + '}');     // Catch: Throwable -> L14
            r107.append(";common_params:");     // Catch: Throwable -> L14
            r107.append(r105.e(r105.f490107c));     // Catch: Throwable -> L14
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", r107.toString());     // Catch: Throwable -> L14
        L16:
            this.f485461d.callback(hj7.a.a(0, r101, "failed"));
            return;
        L6:
            r102 = 0;
        L14:
            th = move-exception;
            th.printStackTrace();
            goto L16
        }

        public a(m r100, boolean r101, String r102, JSONObject r103, IBridgeContext r104, String r105) {
            this.f485463f = r100;
            this.f485458a = r101;
            this.f485459b = r102;
            this.f485460c = r103;
            this.f485461d = r104;
            this.f485462e = r105;
        }
    }

    public class b implements qj7.g.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f485464a;

        public b(IBridgeContext r100) {
            this.f485464a = r100;
        }

        @Override // qj7.g.e
        public final void onSuccess(String r100) {
            this.f485464a.callback(hj7.a.a(1, new JSONObject(r100), "success"));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            this.f485464a.callback(hj7.a.a(0, null, th.toString()));
        }

        @Override // qj7.g.e
        public final void onFailed(int r100, String r101) {
            JSONObject r102 = new JSONObject();
            r102.put("errorCode", r100);     // Catch: Throwable -> L5
            r102.put("errorMessage", r101);     // Catch: Throwable -> L5
        L7:
            this.f485464a.callback(hj7.a.a(0, r102, "fail"));
            return;
        L5:
            th = move-exception;
            th.printStackTrace();
            goto L7
        }
    }

    public m() {
    }

    public final void a(IBridgeContext r110, JSONObject r111) {
        String r100 = r111.optString(com.alipay.sdk.m.p.e.f25671s);
        String r101 = r111.optString("url");
        rj7.c.a(new qj7.g(r101, r100, r111.optString("params"), r111.optString("body_content_type"), new a(this, r111.optBoolean("force_request", true), r101, r111, r110, r100)));
    }

    @BridgeMethod("luckycatRequestNetwork")
    public void requestNetwork(@BridgeParam("data") JSONObject r100, @BridgeContext IBridgeContext r101) {
        if (r100 != null) goto L6;
        r101.callback(hj7.a.a(0, null, "data empty"));
        return;
    L6:
        if (r100.optBoolean("force_request", true) == false) goto L9;
        a(r101, r100);
        return;
    L9:
        com.bytedance.ug.sdk.luckycat.impl.manager.m r102 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        a(r101, r100);
    }

    @BridgeMethod("safeHttpRequest")
    public void safeHttpRequest(@BridgeParam(com.alipay.sdk.m.p.e.f25671s) String r100, @BridgeParam("url") String r101, @BridgeParam("params") String r110, @BridgeParam("body_content_type") String r111, @BridgeContext IBridgeContext r112) {
        rj7.c.a(new qj7.g(r101, r100, r110, r111, new b(r112)));
    }
}
