package com.obric.matrix.platform.sdk.ones.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes33.dex */
public class StaticAccountStatusReceiver extends BroadcastReceiver {
    public StaticAccountStatusReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        final String r102 = r101.getAction();
        dka.a.c("AccountSDK_StaticAccountStatusReceiver", "onReceive action = " + r102);
        boolean r103 = false;
        final int r104 = r101.getIntExtra("obric.intent.extra.account.LOGOUT_SCENE", 0);
        g.f396941c.getClass();
        if (r102 != null) goto L7;
    L8:
        r103 = true;
    L9:
        if (r103 == true) goto L13;
        g.f396948j.post(new f(r102, r104));
        return;
    L13:
        return;
    L7:
        if (r102.length() != 0) goto L9;
        goto L8
    }
}
