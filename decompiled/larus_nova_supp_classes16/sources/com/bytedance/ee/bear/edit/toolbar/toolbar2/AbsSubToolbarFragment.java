package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class AbsSubToolbarFragment extends BaseSubToolbarV2Fragment<DocToolbarV2> {
    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment
    public final BaseSubToolbarAdapter ca0() {
        DocSubToolbarAdapter r1 = new DocSubToolbarAdapter(W90((DocToolbarV2) Z90().getToolbar().getValue()));
        r1.e = new a(this);
        return r1;
    }

    public AbsSubToolbarFragment() {
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment
    public final <V> void ga0(ItemV2 r1, V r2) {
        super.ga0(r1, r2);
    }

    public static void ia0(AbsSubToolbarFragment r2, ItemV2 r3, boolean r4) {
        r2.getClass();
        JSONObject r0 = new JSONObject(r3.getValue());     // Catch: Exception -> L5
        r0.put("openPanel", r4);     // Catch: Exception -> L5
        super.ga0(r3, r0.toString());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("SDKSubToolbarFragment", e, false);
    }
}
