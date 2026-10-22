package com.bytedance.ug.sdk.luckycat.impl.settings;

import hn7.a;

/* JADX INFO: loaded from: classes3.dex */
public final class e<T extends hn7.a> implements hn7.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f271484a = null;

    static {
        f271484a = new e();
    }

    public e() {
    }

    @Override // hn7.b
    public final void a(hn7.a r100) {
        zl7.i r101 = (zl7.i) r100;
        if (r101 == null) goto L8;
        DogSettingsManager r102 = DogSettingsManager.f271481f;
        if (DogSettingsManager.f271477b.compareAndSet(false, true) == false) goto L9;
        r101.I(r102);
        return;
    L9:
        return;
    }
}
