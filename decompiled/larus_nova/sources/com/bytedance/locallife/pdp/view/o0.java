package com.bytedance.locallife.pdp.view;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class o0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OldGoodsHeaderView f261937a;

    public o0(OldGoodsHeaderView r100) {
        this.f261937a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        if (this.f261937a.f261888p0 == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101.optString("", ""), "event_closed") == false) goto L9;
        this.f261937a.m0();
        return;
    }
}
