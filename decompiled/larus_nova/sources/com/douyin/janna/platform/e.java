package com.douyin.janna.platform;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes22.dex */
public final class e extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f273616a;

    public e(f r100) {
        this.f273616a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if ("huawei.intent.action.POWER_MODE_CHANGED_ACTION".equals(r101.getAction()) == false) goto L12;
        int r102 = r101.getIntExtra("state", 2);
        f r103 = this.f273616a;
        int r104 = 1;
        if (r102 == 1) goto L9;
        r104 = 0;
    L9:
        r103.f273603f = r104;
        boolean r105 = hq7.a.f486512a;
        r103.g(a.a(r104));
        return;
    }
}
