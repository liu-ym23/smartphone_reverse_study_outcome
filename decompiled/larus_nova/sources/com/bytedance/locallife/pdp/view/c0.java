package com.bytedance.locallife.pdp.view;

import androidx.lifecycle.Observer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class c0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MenuGoodsHeaderView f261908a;

    public c0(MenuGoodsHeaderView r100) {
        this.f261908a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        MenuGoodsHeaderView r101 = this.f261908a;
        r101.N = ((JSONObject) r100).optInt("current_distance_to_top");
        this.f261908a.i0();
    }
}
