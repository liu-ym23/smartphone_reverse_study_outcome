package com.ss.android.lark.passportc.task;

import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.q;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class InitStaticUserConventionTask_Factory implements Factory<h> {
    private final Provider<Set<q>> staticConventionsProvider;
    private final Provider<m> userServiceProvider;

    public static h newInstance() {
        return new h();
    }

    @Override // javax.inject.Provider
    public h get() {
        h r100 = newInstance();
        r100.f438501a = this.userServiceProvider.get();
        r100.f438502b = this.staticConventionsProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public InitStaticUserConventionTask_Factory(Provider<m> r100, Provider<Set<q>> r101) {
        this.userServiceProvider = r100;
        this.staticConventionsProvider = r101;
    }

    public static InitStaticUserConventionTask_Factory create(Provider<m> r100, Provider<Set<q>> r101) {
        return new InitStaticUserConventionTask_Factory(r100, r101);
    }
}
