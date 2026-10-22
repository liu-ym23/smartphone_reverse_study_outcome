package com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import t19.s;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class c implements Runnable {
    public /* synthetic */ c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        s r100 = s.f544207a;
        Application r101 = AppHost.f326268a.getApplication();
        r100.getClass();
        s.c(r101, "文件已不存在");
    }
}
