package com.larus.utils;

import android.net.NetworkInfo;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class d0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f375379a;

    public /* synthetic */ d0(boolean r100) {
        this.f375379a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r100 = this.f375379a;
        NetworkInfo r101 = e0.f375386b.getActiveNetworkInfo();
        if (r101 == null) goto L5;
        boolean r102 = r101.isConnected();
    L7:
        if (r100 == false) goto L9;
        FLogger.f375446a.i("NetworkStateUtil", "network available, new state: " + r102);
    L10:
        e0.f375387c.postValue(Boolean.valueOf(r102));
        return;
    L9:
        FLogger.f375446a.i("NetworkStateUtil", "network lost, new state: " + r102);
        goto L10
    L5:
        r102 = false;
        goto L7
    }
}
