package com.bytedance.locallife.live.dsl.card;

import android.view.View;
import com.bytedance.locallife.common.utils.g;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f259452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveLocalLifeDSLCard f259453b;

    public b(View r100, LiveLocalLifeDSLCard r101) {
        this.f259452a = r100;
        this.f259453b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (g.a(this.f259452a) == false) goto L5;
        return;
    L5:
        LiveLocalLifeDSLCard.A(this.f259453b, "live_life_expound_card", "tap", null);
    }
}
