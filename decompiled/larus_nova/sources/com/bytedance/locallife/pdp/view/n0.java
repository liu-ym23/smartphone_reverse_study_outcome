package com.bytedance.locallife.pdp.view;

import androidx.lifecycle.Observer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class n0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OldGoodsHeaderView f261935a;

    public n0(OldGoodsHeaderView r100) {
        this.f261935a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        OldGoodsHeaderView r101 = this.f261935a;
        r101.M = ((JSONObject) r100).optInt("current_distance_to_top");
        this.f261935a.i0();
    }
}
