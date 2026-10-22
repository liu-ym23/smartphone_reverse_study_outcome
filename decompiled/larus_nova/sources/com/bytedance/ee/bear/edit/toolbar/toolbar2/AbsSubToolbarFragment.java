package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public abstract class AbsSubToolbarFragment extends BaseSubToolbarV2Fragment<DocToolbarV2> {
    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment
    public final BaseSubToolbarAdapter ca0() {
        DocSubToolbarAdapter r100 = new DocSubToolbarAdapter(W90((DocToolbarV2) Z90().getToolbar().getValue()));
        r100.f226233e = new a(this);
        return r100;
    }

    public AbsSubToolbarFragment() {
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment
    public final <V> void ga0(ItemV2 r100, V r101) {
        super.ga0(r100, r101);
    }

    public static void ia0(AbsSubToolbarFragment r100, ItemV2 r101, boolean r102) {
        r100.getClass();
        JSONObject r103 = new JSONObject(r101.getValue());     // Catch: Exception -> L5
        r103.put("openPanel", r102);     // Catch: Exception -> L5
        super.ga0(r101, r103.toString());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("SDKSubToolbarFragment", e, false);
    }
}
