package com.larus.office.base.host;

import com.larus.account.base.model.LoginPlatform;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes29.dex */
public final class l implements n38.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<Boolean, Throwable, Unit> f360531a;

    /* JADX WARN: Multi-variable type inference failed */
    public l(Function2<? super Boolean, ? super Throwable, Unit> r100) {
        this.f360531a = r100;
    }

    @Override // n38.h
    public final void b(LoginPlatform r100, String r101, Boolean r102) {
        this.f360531a.invoke(Boolean.TRUE, null);
    }

    @Override // n38.h
    public final void a(LoginPlatform r100, int r101, String r102, String r103, String r104, Integer r105, String r106, Map r107) {
        Function2<Boolean, Throwable, Unit> r108 = this.f360531a;
        Boolean r109 = Boolean.FALSE;
        if (r102 != null) goto L5;
        r102 = "Logout failed: " + r101;
    L5:
        r108.invoke(r109, new IllegalStateException(r102));
    }
}
