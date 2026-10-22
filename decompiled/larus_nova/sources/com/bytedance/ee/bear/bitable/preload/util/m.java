package com.bytedance.ee.bear.bitable.preload.util;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes15.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f215045a;

    public m(b r100) {
        this.f215045a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        this.f215045a.getClass();
        tt5.a.h("BitablePreloadDBUtil", "deleteResource");
    }
}
