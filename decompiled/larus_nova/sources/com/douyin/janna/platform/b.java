package com.douyin.janna.platform;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f273614a;

    public b(a r100) {
        this.f273614a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if ("android.os.action.POWER_SAVE_MODE_CHANGED".equals(r101.getAction()) == false) goto L8;
        a r102 = this.f273614a;
        r102.f273603f = r102.f273608k.isPowerSaveMode() ? 1 : 0;
        a r103 = this.f273614a;
        int r104 = r103.f273603f;
        boolean r105 = hq7.a.f486512a;
        r103.g(a.a(r104));
        return;
    }
}
