package com.bytedance.ee.bear.leanmode;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.leanmode.CCMConfig;

/* JADX INFO: loaded from: classes16.dex */
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile h f227597c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<CCMConfig> f227598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Long> f227599b;

    public static h a() {
        if (f227597c != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f227597c != null) goto L9;
        f227597c = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f227597c;
    }

    public h() {
        this.f227598a = new MutableLiveData();
        this.f227599b = new MutableLiveData();
    }
}
