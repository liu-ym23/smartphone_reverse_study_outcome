package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements View.OnClickListener {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        jc1.k.n(IInteractService.class).getAudioTalkService().v();
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L7;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r3 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r3 == null) goto L9;
        r3.tryFastMatch("song_guide");
        return;
    L9:
        return;
    L7:
        jc1.k.n(IInteractService.class).getVideoTalkService().b3();
    }
}
