package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y1 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ KtvRoomGuestWidget a;

    public y1(KtvRoomGuestWidget r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        this.a.H1 = false;
    }
}
