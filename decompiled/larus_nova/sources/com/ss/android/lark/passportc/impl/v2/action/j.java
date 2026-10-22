package com.ss.android.lark.passportc.impl.v2.action;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.passportc.api.ExecuteStrategy;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.impl.v2.state.UserStateModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class j implements c {
    public j() {
    }

    @Override // i0c.b
    public final h0c.b a(UpdateUserContext r100, Object r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter((UserState) r101, "from");
        Intrinsics.checkNotNullParameter((UserState) r102, RemoteMessageConst.TO);
        UserStateModel r103 = r100.f438253b;
        com.ss.android.lark.passportc.api.d r104 = r100.f438256e;
        final UserSession r105 = r100.f438261j;
        if (r105 == null) goto L10;
        if (r104.f438113b == ExecuteStrategy.ROLLBACK) goto L7;
        Function1<f0c.d, Boolean> r106 = new UpdateToAbsentStateAction$execute$1(r105);
        UpdateToAbsentStateAction$execute$2 r107 = UpdateToAbsentStateAction$execute$2.INSTANCE;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r106, "find");
        Intrinsics.checkNotNullParameter(r107, "action");
        r103.e(new UserStateModel.b[]{new UserStateModel.b(r106, r107)});
    L7:
        int r108 = h0c.b.f483503b;
        return new h0c.b.c(com.ss.android.lark.passportc.task.i.f438529a);
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
