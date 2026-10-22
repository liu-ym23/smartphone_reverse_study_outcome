package com.ss.android.lark.integrator.im.message;

import android.content.Context;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements mqb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f428033a;

    @Override // mqb.a
    public final MessageLocationProvider$1$1 getChatDependency() {
        return new MessageLocationProvider$1$1();
    }

    @Override // mqb.a
    public final b getFavoriteDependency() {
        return new b();
    }

    @Override // mqb.a
    public final a getImageDependency() {
        return new a();
    }

    @Override // mqb.a
    public final boolean isGooglePlay() {
        return ((pmb.a) ApiUtils.getApi(pmb.a.class)).isUsPackage();
    }

    @Override // mqb.a
    public Context getContext() {
        return this.f428033a;
    }

    public c(Context r100) {
        this.f428033a = r100;
    }
}
