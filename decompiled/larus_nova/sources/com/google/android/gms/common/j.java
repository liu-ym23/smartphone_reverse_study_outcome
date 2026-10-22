package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes23.dex */
public final class j extends k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callable f274580d;

    @Override // com.google.android.gms.common.k
    public final void a() {
        String r100 = (String) this.f274580d.call();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public /* synthetic */ j(d r100) {
        super(false, null, null);
        this.f274580d = r100;
    }
}
