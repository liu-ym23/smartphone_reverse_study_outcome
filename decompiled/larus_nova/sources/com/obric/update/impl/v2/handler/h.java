package com.obric.update.impl.v2.handler;

import com.larus.utils.logger.FLogger;
import com.ss.android.update.OnUpdateStatusChangedListener;

/* JADX INFO: loaded from: classes5.dex */
public final class h implements OnUpdateStatusChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f404121a;

    public h(f r100) {
        this.f404121a = r100;
    }

    @Override // yhc.i
    public final void b(boolean r100) {
        FLogger.f375446a.i("ObricInitHandler", "sdk onPrepare pre:" + r100);
    }

    @Override // com.ss.android.update.OnUpdateStatusChangedListener
    public final void c(int r100) {
        FLogger.f375446a.i("ObricInitHandler", "sdk onUpdateStatusChanged status:" + r100);
        this.f404121a.f404115b.invoke(Integer.valueOf(r100));
    }

    @Override // yhc.i
    public final void a(boolean r100, boolean r101) {
        FLogger.f375446a.i("ObricInitHandler", "sdk downloadResult isSuccess:" + r100 + ",pre:" + r101);
        this.f404121a.f404117d.invoke(Boolean.valueOf(r100), Boolean.valueOf(r101));
    }

    @Override // yhc.i
    public final void e(int r100, boolean r101) {
        FLogger.f375446a.i("ObricInitHandler", "sdk saveDownloadInfo size:" + r100 + ",etag:,pre:" + r101);
    }

    @Override // yhc.i
    public final void d(int r100, int r101, boolean r102) {
        FLogger.f375446a.i("ObricInitHandler", "sdk updateProgress byteSoFar:" + r100 + ",contentLength:" + r101 + ",pre:" + r102);
        this.f404121a.f404116c.invoke(Integer.valueOf(r100), Integer.valueOf(r101), Boolean.valueOf(r102));
    }
}
