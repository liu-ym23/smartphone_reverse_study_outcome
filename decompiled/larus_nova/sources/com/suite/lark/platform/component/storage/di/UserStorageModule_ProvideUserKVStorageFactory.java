package com.suite.lark.platform.component.storage.di;

import android.app.Application;
import android.text.TextUtils;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.storage.a;
import com.ss.android.lark.util.share_preference.UserSP;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import woc.b;

/* JADX INFO: loaded from: classes36.dex */
public final class UserStorageModule_ProvideUserKVStorageFactory implements Factory<a> {
    private final Provider<Application> appProvider;
    private final Provider<String> uidProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideUserKVStorage(this.appProvider.get(), this.uidProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserStorageModule_ProvideUserKVStorageFactory(Provider<Application> r100, Provider<String> r101) {
        this.appProvider = r100;
        this.uidProvider = r101;
    }

    public static UserStorageModule_ProvideUserKVStorageFactory create(Provider<Application> r100, Provider<String> r101) {
        return new UserStorageModule_ProvideUserKVStorageFactory(r100, r101);
    }

    public static a provideUserKVStorage(Application r100, String r101) {
        int r102 = b.f560540a;
        Intrinsics.checkNotNullParameter(r100, "app");
        Intrinsics.checkNotNullParameter(r101, "uid");
        if (TextUtils.equals(r101, "absent_user") == false) goto L5;
        a r103 = LarkKVStorage.e(r100, UserSP.TEMP_NAME);
    L7:
        return (a) Preconditions.checkNotNullFromProvides(r103);
    L5:
        r103 = LarkKVStorage.e(r100, r101);
        goto L7
    }
}
