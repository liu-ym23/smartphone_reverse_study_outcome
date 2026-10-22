package com.ss.android.lark.passportc.impl.v2.state;

import com.ss.android.lark.passportc.api.f;
import com.ss.android.lark.passportc.impl.v2.action.g;
import com.ss.android.lark.passportc.internal.p;
import com.ss.android.lark.passportc.internal.t;
import com.ss.android.lark.passportc.task.d;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import l0c.c;

/* JADX INFO: loaded from: classes37.dex */
public final class UserStateMachineFactory_Factory implements Factory<a> {
    private final Provider<com.ss.android.lark.passportc.impl.v2.action.a> backgroundComponentDelegateProvider;
    private final Provider<f> backgroundUserServiceProvider;
    private final Provider<t> executorsProvider;
    private final Provider<g> foregroundComponentDelegateProvider;
    private final Provider<Set<d>> globalOnlineTasksProvider;
    private final Provider<l0c.d> taskMonitorProvider;
    private final Provider<p> userDataSourceProvider;
    private final Provider<c> userFlowMonitorProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.foregroundComponentDelegateProvider.get(), this.backgroundComponentDelegateProvider.get(), this.backgroundUserServiceProvider.get(), this.globalOnlineTasksProvider.get(), this.userDataSourceProvider.get(), this.taskMonitorProvider.get(), this.executorsProvider.get(), this.userFlowMonitorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserStateMachineFactory_Factory(Provider<g> r100, Provider<com.ss.android.lark.passportc.impl.v2.action.a> r101, Provider<f> r102, Provider<Set<d>> r103, Provider<p> r104, Provider<l0c.d> r105, Provider<t> r106, Provider<c> r107) {
        this.foregroundComponentDelegateProvider = r100;
        this.backgroundComponentDelegateProvider = r101;
        this.backgroundUserServiceProvider = r102;
        this.globalOnlineTasksProvider = r103;
        this.userDataSourceProvider = r104;
        this.taskMonitorProvider = r105;
        this.executorsProvider = r106;
        this.userFlowMonitorProvider = r107;
    }

    public static UserStateMachineFactory_Factory create(Provider<g> r110, Provider<com.ss.android.lark.passportc.impl.v2.action.a> r111, Provider<f> r112, Provider<Set<d>> r113, Provider<p> r114, Provider<l0c.d> r115, Provider<t> r116, Provider<c> r117) {
        return new UserStateMachineFactory_Factory(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public static a newInstance(g r110, com.ss.android.lark.passportc.impl.v2.action.a r111, f r112, Set<d> r113, p r114, l0c.d r115, t r116, c r117) {
        return new a(r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
