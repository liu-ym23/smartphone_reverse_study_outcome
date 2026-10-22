package com.larus.voicecall.impl.utils;

import com.larus.common.apphost.AppHost;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class q implements Runnable {
    public /* synthetic */ q() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        AppHost.Companion r100 = AppHost.f326268a;
        String r101 = r100.getApplication().getResources().getString(R.string.larus_call_video_ended_toast);
        t19.s.j(t19.s.f544207a, r100.getApplication(), r101, null, false, 28);
    }
}
