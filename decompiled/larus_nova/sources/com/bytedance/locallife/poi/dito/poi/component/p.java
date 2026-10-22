package com.bytedance.locallife.poi.dito.poi.component;

import androidx.lifecycle.Observer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class p<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiHeadImageDitoView f262526a;

    public p(PoiHeadImageDitoView r100) {
        this.f262526a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r110) {
        JSONObject r111 = (JSONObject) r110;
        PoiHeadImageDitoView r100 = this.f262526a;
        PoiHeadImageDitoView.c0(r100, r100.S, "click_photo", null, 0, false, false, null, null, null, null, 65528);
    }
}
