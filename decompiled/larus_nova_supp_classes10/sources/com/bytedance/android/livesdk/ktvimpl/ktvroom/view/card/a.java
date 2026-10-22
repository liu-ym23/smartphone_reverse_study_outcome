package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.card;

import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ KtvRoomCardWidget a;

    public a(KtvRoomCardWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        y r3 = (y) r2;
        if (NetworkUtils.g(((Widget) this.a).context) == false) goto L8;
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = KtvModeOrderSongDataContext.Companion.a();
        if (r0 == null) goto L9;
        r0.beginWifiDownload(r3);
        return;
    L9:
        return;
    }
}
