package com.ss.android.lark.passport;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class UserListFetcherTriggerImpl extends c0c.b implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Function0<Unit> f437679d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f437680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f437681c;

    public static final class a {
    }

    static {
        f437679d = UserListFetcherTriggerImpl$Companion$emptyDestroy$1.INSTANCE;
    }

    @Inject
    public UserListFetcherTriggerImpl(j r100, v r101) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        super(r100);
        this.f437680b = r101;
        this.f437681c = f437679d;
    }

    @Override // c0c.b
    public final void pf(g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "toState");
        Log.i("UserListFetcherTrigger", "preparing fromUser=" + r100 + ", toState=" + r101);
        this.f437681c.invoke();
        g r102 = r101.a();
        if (r102 == null) goto L9;
        UserSession r103 = r102.f475034b;
        if (r103 == null) goto L9;
        this.f437681c = ((b) k.b(this.f437680b.c(r103), b.class)).register();
        return;
    L9:
        Log.w("UserListFetcherTrigger", "onUserChanged toUserSession is invalid.");
    }
}
