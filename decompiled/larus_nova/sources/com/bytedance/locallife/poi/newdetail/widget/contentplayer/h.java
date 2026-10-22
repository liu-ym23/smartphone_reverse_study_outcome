package com.bytedance.locallife.poi.newdetail.widget.contentplayer;

import androidx.lifecycle.Observer;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiContentPlayerView f263424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<i> f263425b;

    public h(PoiContentPlayerView r100, List<i> r101) {
        this.f263424a = r100;
        this.f263425b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        this.f263424a.f263397o.setOffscreenPageLimit(this.f263425b.size());
    }
}
