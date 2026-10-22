package com.bytedance.locallife.poi.poidetail.container.plugin.business;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.data.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiBusinessCoiPlugin f264069a;

    public f(PoiBusinessCoiPlugin r100) {
        this.f264069a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        u r101 = (u) r100;
        if (r101.f258256b == 0) goto L18;
        PoiBusinessCoiPlugin r102 = this.f264069a;
        int r103 = r102.f263917e;
        if (r103 != (-1)) goto L8;
        return;
    L8:
        if (r101.f258261g < (r103 - 1)) goto L10;
        DitoDataCenter r104 = r102.e();
        int r105 = DitoDataCenter.f258004d;
        MutableLiveData<JSONObject> r106 = r104.a0("coi_part_show", 1);
        JSONObject r107 = new JSONObject();
        r107.put("show", true);
        r106.setValue(r107);
        PoiBusinessCoiPlugin.C(this.f264069a, 1);
    L11:
        int r108 = r101.f258260f;
        PoiBusinessCoiPlugin r109 = this.f264069a;
        if (r108 < r109.f263917e) goto L14;
        PoiBusinessCoiPlugin.B(r109, 1);
        return;
    L14:
        PoiBusinessCoiPlugin.B(r109, 0);
        return;
    L10:
        DitoDataCenter r110 = r102.e();
        int r111 = DitoDataCenter.f258004d;
        MutableLiveData<JSONObject> r112 = r110.a0("coi_part_show", 1);
        JSONObject r113 = new JSONObject();
        r113.put("show", false);
        r112.setValue(r113);
        PoiBusinessCoiPlugin.C(this.f264069a, 0);
        goto L11
    }
}
