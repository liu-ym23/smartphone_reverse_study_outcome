package com.ss.android.lark.passportc.impl.v2.action;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f<Component> implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f438222b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<Component> f438223a;

    public static final class a {
    }

    static {
    }

    public f(m<Component> r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentDelegate");
        this.f438223a = r100;
    }

    @Override // i0c.b
    public final h0c.b a(UpdateUserContext r100, Object r101, Object r102) {
        UserState r103 = (UserState) r101;
        UserState r104 = (UserState) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "from");
        Intrinsics.checkNotNullParameter(r104, RemoteMessageConst.TO);
        if (r103 == r104) goto L13;
        if (r104 != UserState.ABSENT) goto L13;
        UserSession r105 = r100.f438261j;
        if (r105 == null) goto L9;
        this.f438223a.a(r105);
    L10:
        int r106 = h0c.b.f483503b;
        return new h0c.b.c(com.ss.android.lark.passportc.task.i.f438529a);
    L9:
        Log.e("DeleteUserComponentAction", "delete user component failed, target session is null, user:" + r100.f438254c.userId);
    L13:
        throw new IllegalStateException("delete user component action state error, state: " + r103 + " -> " + r104);
    }
}
