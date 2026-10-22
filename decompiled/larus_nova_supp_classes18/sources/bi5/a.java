package bi5;

import android.text.TextUtils;
import com.bytedance.ee.bear.appsetting.c;
import org.json.JSONObject;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static String b() {
        String r4 = "";
        String r2 = (String) c.a.a.d("biz_domain_config", "");
        if (TextUtils.isEmpty(r2) == true) goto L10;
        r4 = new JSONObject(r2).optJSONArray("scs_data").optString(0);     // Catch: Throwable -> L6
        tt5.a.h("RetentionLabelExecutor", "getRetentionHost()...result = " + r4);     // Catch: Throwable -> L6
        return r4;
    L6:
        tt5.a.d("RetentionLabelExecutor", "parse retentionHost error,  domainConfigStr = " + r2);
        return r4;
    L10:
        return "";
    }

    public static String a(int r2) {
        if (r2 != e.g.b) goto L7;
        return "DOC";
    L7:
        if (r2 != e.h.b) goto L11;
        return "SHEET";
    L11:
        if (r2 != e.i.b) goto L15;
        return "BITABLE";
    L15:
        if (r2 != e.k.b) goto L19;
        return "MINDNOTE";
    L19:
        if (r2 != e.l.b) goto L23;
        return "FILE";
    L23:
        if (r2 != e.o.b) goto L27;
        return "DOCX";
    L27:
        if (r2 != e.m.b) goto L31;
        return "SLIDES";
    L31:
        if (r2 != e.r.b) goto L35;
        return "BITABLE_SHARE_FORM";
    L35:
        if (r2 != e.t.b) goto L39;
        return "CREATIVITY_MIAODA";
    L39:
        if (r2 != e.u.b) goto L42;
        return "CREATIVITY_MIAODA_APP_DEVELOPMENT";
    L42:
        tt5.a.d("RetentionLabelExecutor", "getEntityTypeByType()...illegal type, type = " + r2);
        return "";
    }
}
