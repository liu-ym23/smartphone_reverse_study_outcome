package com.bytedance.ee.bear.integrator.di;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeAppInitializeImpl implements hb5.a {

    public static final class a {
    }

    static {
    }

    @Inject
    public OfficeAppInitializeImpl() {
    }

    @Override // hb5.a
    public final void checkAndInit() {
    }

    @Override // hb5.a
    public final Flowable<Object> Sc() {
        return Flowable.create(new OfficeAppInitializeImpl$fullInitFlow$1(), BackpressureStrategy.BUFFER);
    }
}
