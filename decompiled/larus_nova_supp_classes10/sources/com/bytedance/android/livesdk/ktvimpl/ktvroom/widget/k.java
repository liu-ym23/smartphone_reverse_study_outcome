package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ l a;

    public k(l r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        l r5 = this.a;
        KtvContext r0 = r5.t;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r1 = r0.getKtvCoreViewModel();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r2 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r1.getValue();
        if (r2 == null) goto L9;
        KtvRoomLyricsStateMachineConfig.d r3 = r2.getCurState();
    L10:
        boolean r6 = r3 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d;
        View r7 = r5.k;
        if (r7 == null) goto L13;
        r7.setSelected(!r6);
    L13:
        KtvContext r8 = r5.t;
        if (r8 == null) goto L21;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r9 = r8.getKtvSingerViewModel();
        if (r9 == null) goto L22;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r10 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r9.getValue();
        if (r10 == null) goto L23;
        r10.togglePause(!r6);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L9:
        r3 = null;
        goto L10
    }
}
