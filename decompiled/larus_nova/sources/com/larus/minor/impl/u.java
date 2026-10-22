package com.larus.minor.impl;

import com.larus.applog.api.IApplog;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class u implements Runnable {
    public /* synthetic */ u() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        IApplog.f287053a.a("is_minor_mode", Integer.valueOf(v.f359218b.get() ? 1 : 0));
    }
}
