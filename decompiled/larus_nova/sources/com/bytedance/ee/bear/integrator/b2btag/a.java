package com.bytedance.ee.bear.integrator.b2btag;

import com.bytedance.ee.bear.appsetting.c;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements com.bytedance.ee.bear.widgets.tagview.a {
    public a() {
    }

    @Override // com.bytedance.ee.bear.widgets.tagview.a
    public final boolean isEnable() {
        return c.a.f206237a.i("lark.suite_admin.orm.b2b.relation_tag_for_office_apps", false);
    }
}
