package com.bytedance.locallife.live.goodsshelves.topbar.view;

import android.view.View;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLocalLifeMultiStoreShelfTopBar f259953a;

    public c(LiveLocalLifeMultiStoreShelfTopBar r100) {
        this.f259953a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.locallife.common.utils.g.a(r100) == false) goto L5;
        return;
    L5:
        LiveLocalLifeMultiStoreShelfTopBar r101 = this.f259953a;
        int r102 = LiveLocalLifeMultiStoreShelfTopBar.f259913g;
        r101.getClass();
        LiveLifeSaaSUtil.k().openSchema(r101.getContext(), "sslocal://chatting/message?uid=" + r101.f259915b);
        LiveLocalLifeMultiStoreShelfTopBar.a("live_life_consultation_click", null);
    }
}
