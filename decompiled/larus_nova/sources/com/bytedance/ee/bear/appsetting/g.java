package com.bytedance.ee.bear.appsetting;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T> f206258a = null;

    static {
        f206258a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("EmergencySettingFGManager", "doCacheClean err", (Throwable) r100, false);
    }
}
