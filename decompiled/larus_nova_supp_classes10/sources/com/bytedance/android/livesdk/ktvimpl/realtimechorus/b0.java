package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b0<T> implements Observer {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public b0(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        com.bytedance.android.live.ktv.common.karaokestation.model.y r3 = (com.bytedance.android.live.ktv.common.karaokestation.model.y) r2;
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
