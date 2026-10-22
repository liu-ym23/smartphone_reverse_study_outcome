package com.bytedance.ee.bear.edit.component.toolbar2;

import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class a implements DocSubToolbarAdapter.a {
    public final /* synthetic */ AbsSubToolbarFragment a;

    public /* synthetic */ a(AbsSubToolbarFragment r1) {
        this.a = r1;
    }

    public final void a(ItemV2 r4, boolean r5) {
        AbsSubToolbarFragment r0 = this.a;
        int r1 = AbsSubToolbarFragment.t;
        r0.getClass();
        JSONObject r2 = new JSONObject(r4.getValue());     // Catch: Exception -> L5
        r2.put("openPanel", r5);     // Catch: Exception -> L5
        r0.ga0(r4, r2.toString());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("SDKSubToolbarFragment", e, false);
    }
}
