package com.suite.lark.platform.component.storage.di;

import android.text.TextUtils;
import com.ss.android.lark.storage.file.FileStorage;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import woc.b;

/* JADX INFO: loaded from: classes36.dex */
public final class UserStorageModule_ProvideUserFileStorageFactory implements Factory<FileStorage> {
    private final Provider<String> uidProvider;

    @Override // javax.inject.Provider
    public FileStorage get() {
        return provideUserFileStorage(this.uidProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserStorageModule_ProvideUserFileStorageFactory(Provider<String> r100) {
        this.uidProvider = r100;
    }

    public static UserStorageModule_ProvideUserFileStorageFactory create(Provider<String> r100) {
        return new UserStorageModule_ProvideUserFileStorageFactory(r100);
    }

    public static FileStorage provideUserFileStorage(String r100) {
        int r101 = b.f560540a;
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (TextUtils.equals(r100, "absent_user") == false) goto L5;
        FileStorage r102 = LarkFileStorage.f("");
    L7:
        return (FileStorage) Preconditions.checkNotNullFromProvides(r102);
    L5:
        r102 = LarkFileStorage.f(r100);
        goto L7
    }
}
