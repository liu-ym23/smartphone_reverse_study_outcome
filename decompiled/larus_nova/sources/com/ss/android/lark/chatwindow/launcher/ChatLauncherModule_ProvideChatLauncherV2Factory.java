package com.ss.android.lark.chatwindow.launcher;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatLauncherModule_ProvideChatLauncherV2Factory implements Factory<c> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public c get() {
        return provideChatLauncherV2(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatLauncherModule_ProvideChatLauncherV2Factory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static ChatLauncherModule_ProvideChatLauncherV2Factory create(Provider<j> r100, Provider<v> r101) {
        return new ChatLauncherModule_ProvideChatLauncherV2Factory(r100, r101);
    }

    public static c provideChatLauncherV2(j r100, v r101) {
        int r102 = a.f416972a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        b r103 = new b(r100, r101);
        h.a(r103);
        return (c) Preconditions.checkNotNullFromProvides(r103);
    }
}
