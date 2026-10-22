package com.ss.android.lark.passportc.internal;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f438455a = null;

    static {
        f438455a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.passportc.internal.f0
    public final User getUser() {
        return (User) AbsentUserDelegateKt.f438303a.getValue();
    }

    @Override // com.ss.android.lark.passportc.internal.f0
    public final UserSession getSession() {
        return ContainerConstsKt.a();
    }

    @Override // com.ss.android.lark.passportc.internal.f0
    public final void a(Function1<? super f0c.h, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        r100.invoke(f0c.i.f475038a);
    }
}
