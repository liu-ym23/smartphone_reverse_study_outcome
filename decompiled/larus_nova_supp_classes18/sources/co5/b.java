package co5;

import android.view.View;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.bean.SceneTemplateData;
import com.bytedance.ee.bear.templates.preview.group.TemplateSelectAdapter;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ TemplateSelectAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ SceneTemplateData.Scene c;

    public b(TemplateSelectAdapter r1, int r2, SceneTemplateData.Scene r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        TemplateSelectAdapter r12 = this.a;
        int r0 = r12.e;
        int r1 = this.b;
        if (r0 != r1) goto L5;
        return;
    L5:
        r12.e = r1;
        r12.notifyDataSetChanged();
        String r13 = p.a().ua(sbb.e.d(this.c.obj_type).getType(), this.c.obj_token, "template_preview");
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r13);
        SceneTemplateData.Scene r2 = this.c;
        String r3 = r2.obj_token;
        String r4 = r2.name;
        TemplateSelectAdapter r5 = this.a;
        com.bytedance.ee.bear.templates.b r14 = new com.bytedance.ee.bear.templates.b("single_template_show", r3, r4, r5.b, r5.c, r2.obj_type, r5.d, 96);
        TemplateReportV2 r6 = TemplateReportV2.a;
        TemplateReportV2.h(r14);
    }
}
