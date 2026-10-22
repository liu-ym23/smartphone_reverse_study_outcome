package com.ss.android.lark.passport_user.container;

import com.ss.android.lark.passportc.api.i;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.api.k;
import com.ss.android.lark.passportc.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;
import yzb.b;

/* JADX INFO: loaded from: classes37.dex */
public final class CreateUserComponentTask_Factory implements Factory<CreateUserComponentTask> {
    private final Provider<b> larkUserListApiProvider;
    private final Provider<i> multiOnlineFGProvider;
    private final Provider<j> passportGlobalServiceProvider;
    private final Provider<k> passportStateManager2Provider;
    private final Provider<l> passportStateManagerProvider;

    @Override // javax.inject.Provider
    public CreateUserComponentTask get() {
        return newInstance(this.multiOnlineFGProvider, this.passportStateManagerProvider, this.passportStateManager2Provider, this.passportGlobalServiceProvider, this.larkUserListApiProvider);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CreateUserComponentTask_Factory(Provider<i> r100, Provider<l> r101, Provider<k> r102, Provider<j> r103, Provider<b> r104) {
        this.multiOnlineFGProvider = r100;
        this.passportStateManagerProvider = r101;
        this.passportStateManager2Provider = r102;
        this.passportGlobalServiceProvider = r103;
        this.larkUserListApiProvider = r104;
    }

    public static CreateUserComponentTask_Factory create(Provider<i> r100, Provider<l> r101, Provider<k> r102, Provider<j> r110, Provider<b> r111) {
        return new CreateUserComponentTask_Factory(r100, r101, r102, r110, r111);
    }

    public static CreateUserComponentTask newInstance(Provider<i> r100, Provider<l> r101, Provider<k> r102, Provider<j> r110, Provider<b> r111) {
        return new CreateUserComponentTask(r100, r101, r102, r110, r111);
    }
}
