package lh5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpPolicyModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class h {

    public interface a {
    }

    public interface b {
        void a(DlpPolicyModel r100);
    }

    public h() {
    }

    public static String a() {
        String r100 = "";
        String r101 = (String) com.bytedance.ee.bear.appsetting.c.a.f206237a.d("biz_domain_config", "");
        if (TextUtils.isEmpty(r101) == true) goto L11;
        r100 = new JSONObject(r101).optJSONArray("scs_data").optString(0);     // Catch: Throwable -> L6
        tt5.a.h("DlpDataFetcher", "getDlpHost, domainConfigStr: " + r101 + ", result: " + r100);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        tt5.a.d("DlpDataFetcher", "getDlpHost, failed, domainConfigStr: " + r101 + ", error: " + th);
        return r100;
    L11:
        return "";
    }

    public static void b(String r100, String r101, String r102, String r103, final b r104) {
        NetService.d r105 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new nh5.b());
        NetService.f r106 = new NetService.f("/lark/scs/compliance/intercept/ccm/policystatus/");
        String r107 = a();
        if (TextUtils.isEmpty(r107) == false) goto L6;
        r104.a(null);
        return;
    L6:
        r106.f216912i = false;
        r106.f216904a = r107;
        r106.f216906c = 2;
        r106.b("token", r100);
        r106.b("policyType", "DLP");
        r106.b("entityType", r101);
        if (TextUtils.isEmpty(r102) == true) goto L10;
        r106.b("owner_id", r102);
    L10:
        if (TextUtils.isEmpty(r103) == true) goto L12;
        r106.b("tenant_id", r103);
    L12:
        r105.a(r106).observeOn(fo5.d.d()).subscribe(new d(r104), new e(r104));
    }
}
