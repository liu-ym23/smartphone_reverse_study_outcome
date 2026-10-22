package com.ss.android.lark.passportc.impl.v2.action.foreground;

import com.ss.android.lark.passportc.internal.y;
import com.ss.android.lark.passportc.task.g;
import dagger.internal.Factory;
import g0c.a;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class ForegroundUserComponentDelegateImpl_Factory implements Factory<a> {
    private final Provider<g> taskOrderProvider;
    private final Provider<y> userComponentManagerProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.userComponentManagerProvider.get(), this.taskOrderProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ForegroundUserComponentDelegateImpl_Factory(Provider<y> r100, Provider<g> r101) {
        this.userComponentManagerProvider = r100;
        this.taskOrderProvider = r101;
    }

    public static ForegroundUserComponentDelegateImpl_Factory create(Provider<y> r100, Provider<g> r101) {
        return new ForegroundUserComponentDelegateImpl_Factory(r100, r101);
    }

    public static a newInstance(y r100, g r101) {
        return new a(r100, r101);
    }
}
