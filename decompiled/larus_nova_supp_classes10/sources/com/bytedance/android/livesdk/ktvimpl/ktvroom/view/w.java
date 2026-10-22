package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ KtvMvSingerInfoView a;

    public w(KtvMvSingerInfoView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        KtvRoomViewModel r4 = this.a.j;
        if (r4 == null) goto L6;
        KtvRoomViewModel.showSingerUserProfiler$default(r4, null, 1, null);
        return;
    }
}
