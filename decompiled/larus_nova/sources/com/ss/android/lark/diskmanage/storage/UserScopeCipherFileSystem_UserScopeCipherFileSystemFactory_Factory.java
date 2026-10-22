package com.ss.android.lark.diskmanage.storage;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class UserScopeCipherFileSystem_UserScopeCipherFileSystemFactory_Factory implements Factory<UserScopeCipherFileSystem.UserScopeCipherFileSystemFactory> {
    private final Provider<jkc.c> cipherManagerProvider;

    @Override // javax.inject.Provider
    public UserScopeCipherFileSystem.UserScopeCipherFileSystemFactory get() {
        return newInstance(this.cipherManagerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserScopeCipherFileSystem_UserScopeCipherFileSystemFactory_Factory(Provider<jkc.c> r100) {
        this.cipherManagerProvider = r100;
    }

    public static UserScopeCipherFileSystem_UserScopeCipherFileSystemFactory_Factory create(Provider<jkc.c> r100) {
        return new UserScopeCipherFileSystem_UserScopeCipherFileSystemFactory_Factory(r100);
    }

    public static UserScopeCipherFileSystem.UserScopeCipherFileSystemFactory newInstance(jkc.c r100) {
        return new UserScopeCipherFileSystem.UserScopeCipherFileSystemFactory(r100);
    }
}
