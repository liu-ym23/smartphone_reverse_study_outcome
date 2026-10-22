package com.lark.kmp.rustclient.internal;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f282550a;

    public e() {
        this.f282550a = "rust-client-push";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        return new PthreadThreadV2(r100, this.f282550a);
    }
}
