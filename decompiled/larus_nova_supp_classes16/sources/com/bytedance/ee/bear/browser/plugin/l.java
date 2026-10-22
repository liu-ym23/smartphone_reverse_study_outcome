package com.bytedance.ee.bear.browser.plugin;

import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements vo5.a {
    public final /* synthetic */ d0c.c a;

    public final UserSession b() {
        return this.a.e9();
    }

    public l(d0c.c r1) {
        this.a = r1;
    }

    public final <T> T a(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "userScopeApi");
        return (T) e0c.k.b(this.a.provideComponent(), r2);
    }
}
