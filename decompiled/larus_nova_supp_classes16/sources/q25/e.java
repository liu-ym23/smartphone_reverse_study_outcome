package q25;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.google.gson.Gson;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.z;
import e0c.k;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {

    public interface a {
        void b(int r1, Throwable r2, OfflineDoc r3);

        void f(int r1, OfflineDoc r2);

        void g(int r1, OfflineDoc r2);
    }

    public e() {
    }

    public static int a(SimpleRequestResult r7, long r8) {
        long r0 = System.currentTimeMillis();
        if (r7 != null) goto L11;
        if (r8 <= 0) goto L11;
        if ((r0 - r8) <= 20000) goto L11;
        return 99999;
    L11:
        if (r7 != null) goto L50;
        return -1;
    L50:
        DATA r4 = r7.data;     // Catch: Exception -> L40
        if (r4 != 0) goto L17;
    L38:
        tt5.a.d("HtmlCacheWebProcessor", "tryFindInvalidContent empty ");     // Catch: Exception -> L40
    L42:
        int r1 = 99993;
    L43:
        if (r1 == 0) goto L46;
        return r1;
    L46:
        if (r7.code != 0) goto L48;
        return 0;
    L48:
        return -1;
    L17:
        if (TextUtils.isEmpty(r4.toString()) == true) goto L38;
        String r5 = r7.data.toString();     // Catch: Exception -> L40
        Gson r6 = z.a;     // Catch: Exception -> L40
        JSONObject r9 = null;
        if (TextUtils.isEmpty(r5) == true) goto L25;
        r9 = JSON.parseObject(r5);     // Catch: Throwable -> L49
    L25:
        if (r9.containsKey("code") == true) goto L27;
    L36:
        tt5.a.d("HtmlCacheWebProcessor", "tryFindInvalidContent error, not code or data  ");     // Catch: Exception -> L40
    L37:
        r1 = 99994;
        goto L43
    L27:
        if (r9.containsKey("data") == false) goto L36;
        r1 = r9.getIntValue("code");     // Catch: Exception -> L40
        if (r1 == 0) goto L33;
        tt5.a.d("HtmlCacheWebProcessor", "tryFindInvalidContent error, inner error code " + r1);     // Catch: Exception -> L40
        goto L43
    L33:
        if (TextUtils.isEmpty(r9.getString("data")) == false) goto L35;
        tt5.a.d("HtmlCacheWebProcessor", "tryFindInvalidContent error, data empty ");     // Catch: Exception -> L40
        goto L37
    L35:
        r1 = 0;
    L40:
        e = move-exception;
        tt5.a.e("HtmlCacheWebProcessor", "tryFindInvalidContent empty  ", e, false);
        goto L42
    }

    public final void b(final OfflineDoc r13, final a r14) {
        tt5.a.h("HtmlCacheWebProcessor", du5.b.g(r13.getObj_token()) + " start to fetch ssr " + r13.getFrom_source());
        NetService.d r0 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new b());
        StringBuilder r3 = new StringBuilder("/ssr-mobile-app/docx/");
        r3.append(r13.getObj_token());
        NetService.f r2 = new NetService.f(r3.toString());
        boolean r4 = false;
        r2.i = false;
        String r5 = p.t;
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L9;
        r5 = JSON.parseObject(DocOpenConfig.c()).getJSONObject("doubao").getString("internal_api");     // Catch: Exception -> L6
    L11:
        r2.a = r5;
        r2.c = 2;
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L27;
    L18:
        if (r4 == false) goto L20;
        r2.b("scene", "doubaoMiniApp");
    L20:
        String r1 = ((b0) org.koin.java.a.a(b0.class)).getVersionName();
        if (AppInfoUtils.f().booleanValue() == false) goto L25;
        r1 = swb.b.a(LarkContext.getApplication());
        if (TextUtils.isEmpty(r1) == false) goto L25;
        r1 = "1.0.0";
    L25:
        r2.b("version", r1);
        final long r10 = System.currentTimeMillis();
        r0.a(r2).blockingSubscribe(new c(this, r10, r14, r13), new d(this, r13, r10, r14));
        return;
    L27:
        r4 = ((etb.a) LarkContext.spiByDwarf(etb.a.class)).isEnable();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        tt5.a.j("HtmlCacheWebProcessor", e);
    L6:
        e = move-exception;
        tt5.a.j("HtmlCacheWebProcessor", e);
        goto L11
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ark_domain") == false) goto L11;
        r5 = ((t45.c) k.a(LarkContext.getApplication(), t45.c.class)).f9();
        goto L11
    }
}
