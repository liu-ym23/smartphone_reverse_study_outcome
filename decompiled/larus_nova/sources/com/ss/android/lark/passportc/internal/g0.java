package com.ss.android.lark.passportc.internal;

import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g0 implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UserSession f438463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f438464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public User f438465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Function1<f0c.h, Unit>> f438466d;

    @Override // com.ss.android.lark.passportc.internal.f0
    public final User getUser() {
        User r100 = this.f438464b.a(this.f438463a.f438138b);
        if (r100 == null) goto L6;
        this.f438465c = r100;
        return r100;
    L6:
        return this.f438465c;
    }

    @Override // com.ss.android.lark.passportc.internal.f0
    public final UserSession getSession() {
        return this.f438463a;
    }

    @Override // com.ss.android.lark.passportc.internal.f0
    public final void a(Function1<? super f0c.h, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f438466d.add(r100);
    }

    public final void b(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, UserInfo.USERSTATE);
        Iterator<T> r101 = this.f438466d.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Function1) r101.next()).invoke(r100);
        goto L4
    }

    public g0(UserSession r100, p r101, User r102) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "userDataSource");
        Intrinsics.checkNotNullParameter(r102, "userSaved");
        this.f438463a = r100;
        this.f438464b = r101;
        this.f438465c = r102;
        this.f438466d = Collections.synchronizedSet(new LinkedHashSet());
    }
}
