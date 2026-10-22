package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.card;

import android.content.DialogInterface;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ KtvRoomCardWidget a;

    public f(KtvRoomCardWidget r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        if (((Widget) this.a.p.a).isDestroyed == false) goto L5;
        ALogger.i(bb0.b.b(), "onMusicCut, but widget is destory, invoke class :".concat(KtvRoomCardWidget.b.class.getSimpleName()));
    L8:
        r3.dismiss();
        return;
    L5:
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r5 = KtvModeOrderSongDataContext.Companion.a();
        if (r5 == null) goto L8;
        r5.cutMusic();
        goto L8
    }
}
