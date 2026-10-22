package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ l a;

    public c(l r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        this.a.getKtvContext().getOpenKtvRoomDialogEvent().post(new od2.b("bottom", true, null));
        pd2.d.n.getClass();
        pd2.d.u("full_mv");
    }
}
