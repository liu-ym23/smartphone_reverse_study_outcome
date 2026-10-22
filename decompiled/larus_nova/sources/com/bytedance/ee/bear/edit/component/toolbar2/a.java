package com.bytedance.ee.bear.edit.component.toolbar2;

import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class a implements DocSubToolbarAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsSubToolbarFragment f226109a;

    public /* synthetic */ a(AbsSubToolbarFragment r100) {
        this.f226109a = r100;
    }

    public final void a(ItemV2 r100, boolean r101) {
        AbsSubToolbarFragment r102 = this.f226109a;
        int r103 = AbsSubToolbarFragment.f226048t;
        r102.getClass();
        JSONObject r104 = new JSONObject(r100.getValue());     // Catch: Exception -> L5
        r104.put("openPanel", r101);     // Catch: Exception -> L5
        r102.ga0(r100, r104.toString());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("SDKSubToolbarFragment", e, false);
    }
}
