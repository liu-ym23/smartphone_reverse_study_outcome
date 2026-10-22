package com.bytedance.ee.bear.integrator.b2btag;

import com.bytedance.ee.bear.appsetting.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements com.bytedance.ee.bear.widgets.tagview.a {
    public a() {
    }

    public final boolean isEnable() {
        return c.a.a.i("lark.suite_admin.orm.b2b.relation_tag_for_office_apps", false);
    }
}
