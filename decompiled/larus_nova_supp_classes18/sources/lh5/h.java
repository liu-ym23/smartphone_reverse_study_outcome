package lh5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpPolicyModel;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {

    public interface a {
    }

    public interface b {
        void a(DlpPolicyModel r1);
    }

    public h() {
    }

    public static String a() {
        String r4 = "";
        String r2 = (String) com.bytedance.ee.bear.appsetting.c.a.a.d("biz_domain_config", "");
        if (TextUtils.isEmpty(r2) == true) goto L11;
        r4 = new JSONObject(r2).optJSONArray("scs_data").optString(0);     // Catch: Throwable -> L6
        tt5.a.h("DlpDataFetcher", "getDlpHost, domainConfigStr: " + r2 + ", result: " + r4);     // Catch: Throwable -> L6
        return r4;
    L6:
        th = move-exception;
        tt5.a.d("DlpDataFetcher", "getDlpHost, failed, domainConfigStr: " + r2 + ", error: " + th);
        return r4;
    L11:
        return "";
    }

    public static void b(String r4, String r5, String r6, String r7, final b r8) {
        NetService.d r0 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new nh5.b());
        NetService.f r1 = new NetService.f("/lark/scs/compliance/intercept/ccm/policystatus/");
        String r2 = a();
        if (TextUtils.isEmpty(r2) == false) goto L6;
        r8.a(null);
        return;
    L6:
        ((NetService.e) r1).i = false;
        ((NetService.e) r1).a = r2;
        ((NetService.e) r1).c = 2;
        r1.b(ResourceData.KEY_TOKEN, r4);
        r1.b("policyType", "DLP");
        r1.b("entityType", r5);
        if (TextUtils.isEmpty(r6) == true) goto L10;
        r1.b("owner_id", r6);
    L10:
        if (TextUtils.isEmpty(r7) == true) goto L12;
        r1.b("tenant_id", r7);
    L12:
        r0.a(r1).observeOn(fo5.d.d()).subscribe(new d(r8), new e(r8));
    }
}
