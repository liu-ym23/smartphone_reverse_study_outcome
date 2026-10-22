package com.bytedance.ee.bear.templates.center;

import android.os.Bundle;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.sort.SortAndFilterFragment;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.widgets.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends t {
    public final /* synthetic */ TemplateCenterView c;

    public h(TemplateCenterView r3) {
        this.c = r3;
        super(300);
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        TemplateCenterView r6 = this.c;
        ConnectionService.NetworkState r0 = ((ConnectionService) r6.g.getValue()).getNetworkState();
        if (r0 == null) goto L5;
        boolean r1 = r0.a();
    L6:
        if (r1 == false) goto L8;
        Bundle r2 = new Bundle();
        r2.putString("key_module", "home");
        r2.putString("key_sub_module", "templates");
        r2.putString("key_view_model_tag", "templates");
        r2.putString("key_token", "template_v4");
        r2.putBoolean("key_sort_asc_enable", false);
        r2.putInt("key_default_type_pos", r6.h().getCurrentTabFilterIndex());
        r2.putBoolean("key_reset_enable", false);
        r2.putBoolean("key_sort_filter_enable", false);
        ActionSheetDialogFragment.ba0(r6.a, SortAndFilterFragment.class, r2);
        TemplateReportV2 r7 = TemplateReportV2.a;
        JSONObject r8 = new JSONObject();
        r8.put("click_type", "filter");
        r8.put("template_source", TemplateReportV2.c);
        TemplateReportV2.a().n(TemplateReportV2.b, r8);
        return;
    L8:
        Toast.showFailureText(r6.a, 2131887789);
        return;
    L5:
        r1 = false;
        goto L6
    }
}
