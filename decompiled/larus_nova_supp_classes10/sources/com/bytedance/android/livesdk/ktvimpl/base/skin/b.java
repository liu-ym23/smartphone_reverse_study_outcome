package com.bytedance.android.livesdk.ktvimpl.base.skin;

import android.view.View;
import com.bytedance.android.live.ktv.common.model.api.x0;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdkapi.depend.message.GetDressPageListMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ KtvDressWidget a;

    public b(KtvDressWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        KtvDressWidget r5 = this.a;
        int r0 = r5.h;
        GetDressPageListMode r1 = GetDressPageListMode.LIST_MODE_PREVIEW;
        if (r0 != r1.getValue()) goto L5;
        int r2 = GetDressPageListMode.LIST_MODE_FULL.getValue();
    L6:
        r5.h = r2;
        if (this.a.h != GetDressPageListMode.LIST_MODE_FULL.getValue()) goto L9;
        Long r6 = KtvLoggerHelper.a;
        KtvLoggerHelper.W("ksong");
    L9:
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r7 = this.a.r;
        if (r7 == null) goto L12;
        x0 r8 = r7.obtainHonorTagList();
    L13:
        KtvDressWidget r3 = this.a;
        r3.wq(r8, r3.h);
        return;
    L12:
        r8 = null;
        goto L13
    L5:
        r2 = r1.getValue();
        goto L6
    }
}
