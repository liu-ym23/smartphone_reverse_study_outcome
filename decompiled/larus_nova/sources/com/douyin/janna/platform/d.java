package com.douyin.janna.platform;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HONORProcessor f273615a;

    public d(HONORProcessor r100) {
        this.f273615a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if ("hihonor.intent.action.HWSYSTEMMANAGER_CHANGE_POWERMODE".equals(r101.getAction()) == false) goto L8;
        HONORProcessor r102 = this.f273615a;
        r102.f273603f = 1;
        r102.g(a.a(1));
    L10:
        int r103 = this.f273615a.f273603f;
        boolean r104 = hq7.a.f486512a;
        return;
    L8:
        if ("hihonor.intent.action.HWSYSTEMMANAGER_SHUTDOWN_LIMIT_POWERMODE".equals(r101.getAction()) == false) goto L10;
        HONORProcessor r105 = this.f273615a;
        r105.f273603f = 0;
        r105.g(a.a(0));
        goto L10
    }
}
