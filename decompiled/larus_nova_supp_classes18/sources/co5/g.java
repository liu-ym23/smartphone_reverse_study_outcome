package co5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.bean.SceneTemplateData;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ e a;

    public g(e r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        SelectorConfig r2 = new SelectorConfig();
        r2.c(SelectorType.SPACE_SAVE_TEMPLATE);
        r2.a(SelectorScope.SPACE_ONLY);
        r2.b(this.a.a.getString(2131887826));
        r2.d = true;
        r2.e = true;
        r2.g = 16;
        com.bytedance.ee.bear.contract.route.parcelable.f r0 = (com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.f.class, null, null, 6);
        e r1 = this.a;
        Context r3 = r1.a;
        td5.f r4 = new td5.f();
        r4.e = 16;
        r4.d = r1.b.collection_id;
        Unit r14 = Unit.INSTANCE;
        r0.c(r3, r2, r4, null, null);
        e r15 = this.a;
        List<SceneTemplateData.Scene> r5 = r15.b.template_collection;
        if (r5 == null) goto L8;
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        SceneTemplateData.Scene r7 = (SceneTemplateData.Scene) r6.next();
        com.bytedance.ee.bear.templates.b r11 = new com.bytedance.ee.bear.templates.b("use_click_button", r7.obj_token, r7.name, r15.b.collection_id, r15.d, r7.obj_type, r15.c, 96);
        TemplateReportV2 r8 = TemplateReportV2.a;
        TemplateReportV2.h(r11);
        goto L6
    L10:
        return;
    }
}
