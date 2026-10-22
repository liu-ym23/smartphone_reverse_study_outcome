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

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    public interface a {
        void b(int r100, Throwable r101, OfflineDoc r102);

        void f(int r100, OfflineDoc r101);

        void g(int r100, OfflineDoc r101);
    }

    public e() {
    }

    public static int a(SimpleRequestResult r100, long r101) {
        long r102 = System.currentTimeMillis();
        if (r100 != null) goto L11;
        if (r101 <= 0) goto L11;
        if ((r102 - r101) <= 20000) goto L11;
        return 99999;
    L11:
        if (r100 != null) goto L50;
        return -1;
    L50:
        DATA r103 = r100.data;     // Catch: Exception -> L40
        if (r103 != 0) goto L17;
    L38:
        tt5.a.d("HtmlCacheWebProcessor", "tryFindInvalidContent empty ");     // Catch: Exception -> L40
    L42:
        int r104 = 99993;
    L43:
        if (r104 == 0) goto L46;
        return r104;
    L46:
        if (r100.code != 0) goto L48;
        return 0;
    L48:
        return -1;
    L17:
        if (TextUtils.isEmpty(r103.toString()) == true) goto L38;
        String r105 = r100.data.toString();     // Catch: Exception -> L40
        Gson r106 = z.f444793a;     // Catch: Exception -> L40
        JSONObject r107 = null;
        if (TextUtils.isEmpty(r105) == true) goto L25;
        r107 = JSON.parseObject(r105);     // Catch: Throwable -> L49
    L25:
        if (r107.containsKey("code") == true) goto L27;
    L36:
        tt5.a.d("HtmlCacheWebProcessor", "tryFindInvalidContent error, not code or data  ");     // Catch: Exception -> L40
    L37:
        r104 = 99994;
        goto L43
    L27:
        if (r107.containsKey("data") == false) goto L36;
        r104 = r107.getIntValue("code");     // Catch: Exception -> L40
        if (r104 == 0) goto L33;
        tt5.a.d("HtmlCacheWebProcessor", "tryFindInvalidContent error, inner error code " + r104);     // Catch: Exception -> L40
        goto L43
    L33:
        if (TextUtils.isEmpty(r107.getString("data")) == false) goto L35;
        tt5.a.d("HtmlCacheWebProcessor", "tryFindInvalidContent error, data empty ");     // Catch: Exception -> L40
        goto L37
    L35:
        r104 = 0;
    L40:
        e = move-exception;
        tt5.a.e("HtmlCacheWebProcessor", "tryFindInvalidContent empty  ", e, false);
        goto L42
    }

    public final void b(final OfflineDoc r110, final a r111) {
        tt5.a.h("HtmlCacheWebProcessor", du5.b.g(r110.getObj_token()) + " start to fetch ssr " + r110.getFrom_source());
        NetService.d r100 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new b());
        StringBuilder r101 = new StringBuilder("/ssr-mobile-app/docx/");
        r101.append(r110.getObj_token());
        NetService.f r102 = new NetService.f(r101.toString());
        boolean r103 = false;
        r102.f216912i = false;
        String r104 = p.f540583t;
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L9;
        r104 = JSON.parseObject(DocOpenConfig.c()).getJSONObject("doubao").getString("internal_api");     // Catch: Exception -> L6
    L11:
        r102.f216904a = r104;
        r102.f216906c = 2;
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L27;
    L18:
        if (r103 == false) goto L20;
        r102.b("scene", "doubaoMiniApp");
    L20:
        String r105 = ((b0) org.koin.java.a.a(b0.class)).getVersionName();
        if (AppInfoUtils.f().booleanValue() == false) goto L25;
        r105 = swb.b.a(LarkContext.getApplication());
        if (TextUtils.isEmpty(r105) == false) goto L25;
        r105 = "1.0.0";
    L25:
        r102.b("version", r105);
        final long r112 = System.currentTimeMillis();
        r100.a(r102).blockingSubscribe(new c(this, r112, r111, r110), new d(this, r110, r112, r111));
        return;
    L27:
        r103 = ((etb.a) LarkContext.spiByDwarf(etb.a.class)).isEnable();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        tt5.a.j("HtmlCacheWebProcessor", e);
    L6:
        e = move-exception;
        tt5.a.j("HtmlCacheWebProcessor", e);
        goto L11
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.ark_domain") == false) goto L11;
        r104 = ((t45.c) k.a(LarkContext.getApplication(), t45.c.class)).f9();
        goto L11
    }
}
