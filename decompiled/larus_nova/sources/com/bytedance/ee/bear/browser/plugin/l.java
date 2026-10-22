package com.bytedance.ee.bear.browser.plugin;

import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class l implements vo5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0c.c f216625a;

    @Override // vo5.a
    public final UserSession b() {
        return this.f216625a.e9();
    }

    public l(d0c.c r100) {
        this.f216625a = r100;
    }

    @Override // vo5.a
    public final <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "userScopeApi");
        return (T) e0c.k.b(this.f216625a.provideComponent(), r100);
    }
}
