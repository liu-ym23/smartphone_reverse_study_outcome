package com.bytedance.ee.bear.list.cache;

import com.bytedance.ee.util.db.a;
import dagger.internal.Factory;
import javax.inject.Provider;
import mc5.x2;
import t45.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class UserDatabaseManager_Factory implements Factory<x2> {
    private final Provider<a> dbControllerProvider;
    private final Provider<c> spaceKitUrlHelperProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public x2 m8get() {
        return newInstance((a) this.dbControllerProvider.get(), (c) this.spaceKitUrlHelperProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m8get();
    }

    public UserDatabaseManager_Factory(Provider<a> r1, Provider<c> r2) {
        this.dbControllerProvider = r1;
        this.spaceKitUrlHelperProvider = r2;
    }

    public static UserDatabaseManager_Factory create(Provider<a> r1, Provider<c> r2) {
        return new UserDatabaseManager_Factory(r1, r2);
    }

    public static x2 newInstance(a r1, c r2) {
        return new x2(r1, r2);
    }
}
