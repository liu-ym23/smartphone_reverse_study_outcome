package co5;

import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.bean.SceneTemplateData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (TextUtils.isEmpty(this.a.b.app_link) == false) goto L5;
        tt5.a.h("TemplateSelectView", "handleEcologyButton app_link is empty");
        return;
    L5:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(this.a.b.app_link);
        TemplateReportV2 r8 = TemplateReportV2.a;
        e r9 = this.a;
        String r0 = r9.d;
        SceneTemplateData r1 = r9.b;
        String r2 = r1.collection_id;
        String r3 = r1.name;
        String r10 = r9.c;
        Intrinsics.checkNotNullParameter(r2, "setId");
        Intrinsics.checkNotNullParameter(r3, "templateName");
        JSONObject r4 = new JSONObject();
        r4.put("click_type", "consult_button");
        r4.put("set_id", r2);
        r4.put("set_name", r3);
        r4.put("is_customized", Boolean.valueOf(Intrinsics.areEqual("4", r10)));
        r4.put("template_source", TemplateReportV2.c);
        if (r0 == null) goto L8;
        r4.put("templatecenter_source", r0);
    L8:
        TemplateReportV2.a().o("ccm_set_template_preview_click", r4, false);
    }
}
