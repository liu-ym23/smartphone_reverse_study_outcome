package com.bytedance.ee.bear.leanmode;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.leanmode.CCMConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public static volatile h c;
    public final MutableLiveData<CCMConfig> a;
    public final MutableLiveData<Long> b;

    public static h a() {
        if (c != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public h() {
        this.a = new MutableLiveData();
        this.b = new MutableLiveData();
    }
}
