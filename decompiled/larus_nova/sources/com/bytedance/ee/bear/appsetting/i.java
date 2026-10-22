package com.bytedance.ee.bear.appsetting;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<T> f206260a = null;

    static {
        f206260a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("EmergencySettingFGManager", "observeSettingChanged err", (Throwable) r100, false);
    }
}
