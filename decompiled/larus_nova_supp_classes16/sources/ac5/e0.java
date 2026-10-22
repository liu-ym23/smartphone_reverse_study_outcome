package ac5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.create.g0;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.templates.TemplateReport;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e0 extends com.bytedance.ee.bear.route.a {
    public final String e(BearUrl r1, RouteBean r2) {
        return "";
    }

    public e0() {
    }

    public final boolean b(Context r8, BearUrl r9, RouteBean r10) {
        boolean r11 = TextUtils.equals("template_create", r9.a);
        if (r11 == false) goto L26;
        tt5.a.h("TemplateCreateRouteInterceptor", "dispatchUrl()..." + r9.a);
        if (r10 == null) goto L11;
        Map r4 = r10.k;
        if (r4 == null) goto L11;
        if (r4.size() <= 0) goto L11;
        Map r12 = r10.k;
        String r5 = (String) r12.get("template_i18n_id");
        String r6 = (String) r12.get("create_source");
        String r13 = (String) r12.get(DocRedirectToDocxPlugin.FROM);
    L13:
        if (CollectionUtils.isEmpty(r9.d) == false) goto L15;
    L19:
        String r14 = TemplateReport.a;
        if (r6 == null) goto L22;
        r13 = r6;
    L25:
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        TemplateReport.a = r13;
        new g0().b(new com.bytedance.ee.bear.list.create.l(null, -1, true, r5)).subscribe(new c0(), new d0());
        goto L26
    L22:
        if (r13 != null) goto L25;
        r13 = "";
        goto L25
    L15:
        if (TextUtils.isEmpty(r5) == false) goto L19;
        if (TextUtils.isEmpty(r6) == false) goto L19;
        Map<String, String> r16 = r9.d;
        r5 = r16.get("template_i18n_id");
        r6 = r16.get("create_source");
        r13 = r16.get(DocRedirectToDocxPlugin.FROM);
    L11:
        r13 = null;
        r5 = null;
        r6 = null;
    L26:
        return r11;
    }
}
