package com.bytedance.ee.bear.appsetting;

import android.app.Application;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements vo5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f206234a;

    @Override // vo5.a
    public final UserSession b() {
        return ((com.ss.android.lark.passportc.convention.a) e0c.k.a(this.f206234a, com.ss.android.lark.passportc.convention.a.class)).b();
    }

    public b(Application r100) {
        this.f206234a = r100;
    }

    @Override // vo5.a
    public final <T> T a(Class<T> r100) {
        UserSession r101 = b();
        return (T) e0c.k.b(((v) e0c.k.a(this.f206234a, v.class)).c(r101), r100);
    }
}
