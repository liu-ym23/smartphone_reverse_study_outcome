package com.bytedance.locallife.pdp.plugin;

import androidx.lifecycle.Observer;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.locallife.biz.videopip.LifeVideoPipSessionManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoodsDetailVideoPipPlugin f261677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f261678b;

    public c(GoodsDetailVideoPipPlugin r100, boolean r101) {
        this.f261677a = r100;
        this.f261678b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        int r101 = ((JSONObject) r100).optInt("state");
        if (r101 != 4) goto L5;
        GoodsDetailVideoPipPlugin r102 = this.f261677a;
        r102.f261632f = CJPayConstant.CJ_PAY_FINGER_PAGE_STYLE_HALF;
        r102.t(this.f261678b);
        return;
    L5:
        if (r101 != 6) goto L7;
    L9:
        GoodsDetailVideoPipPlugin r103 = this.f261677a;
        r103.f261632f = "full_page";
        com.bytedance.locallife.biz.videopip.b r104 = LifeVideoPipSessionManager.f256999a;
        LifeVideoPipSessionManager.i(r103.f261637k);
        return;
    L7:
        if (r101 == 7) goto L9;
    }
}
