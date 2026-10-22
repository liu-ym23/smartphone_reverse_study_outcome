package com.ss.android.lark.security.compliance.infra.base;

import c0c.b;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class UserScopeProxy<T> extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f440420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<T> f440421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<T> f440422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f440423e;

    public final T rf() {
        return (T) this.f440423e.getValue();
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f440420b;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        Object r104 = k.b(r102.c(r103), this.f440421c);
        this.f440422d.e((T) r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }

    public UserScopeProxy(j r100, v r101, Class<T> r102) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r102, "clazz");
        super(r100);
        this.f440420b = r101;
        this.f440421c = r102;
        UserSession r103 = r100.b();
        if (r103 != null) goto L5;
        r103 = ContainerConstsKt.a();
    L5:
        this.f440422d = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r103), r102), r102);
        this.f440423e = LazyKt.lazy(new UserScopeProxy$proxyInstance$2(this));
        h.a(this);
    }
}
