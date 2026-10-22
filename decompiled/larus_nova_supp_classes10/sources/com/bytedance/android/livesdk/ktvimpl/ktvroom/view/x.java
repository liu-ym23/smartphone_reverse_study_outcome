package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.message.model.td;
import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ KtvMvSingerInfoView a;

    public x(KtvMvSingerInfoView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        KtvRoomViewModel r6 = this.a.j;
        if (r6 == null) goto L19;
        boolean r0 = false;
        if (r6 == null) goto L10;
        NextLiveData<Integer> r1 = r6.getSingHotRank();
        if (r1 == null) goto L10;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L10;
    L11:
        int r3 = r2.intValue();
        KtvMvSingerInfoView r4 = this.a;
        Integer r7 = Integer.valueOf(r4.i);
        r4.getClass();
        int r8 = td.HOT_STATUS_FEVER;
        if (r7 != null) goto L15;
    L17:
        r6.onSingHotClick(r3, r0);
        return;
    L15:
        if (r7.intValue() != r8) goto L17;
        r0 = true;
    L10:
        r2 = 0;
        goto L11
    }
}
