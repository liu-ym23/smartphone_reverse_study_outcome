package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a0 implements View.OnClickListener {
    public final /* synthetic */ KtvOpusSingerInfoView a;

    public a0(KtvOpusSingerInfoView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        KtvRoomViewModel r4 = this.a.h;
        if (r4 == null) goto L6;
        KtvRoomViewModel.showSingerUserProfiler$default(r4, null, 1, null);
        return;
    }
}
