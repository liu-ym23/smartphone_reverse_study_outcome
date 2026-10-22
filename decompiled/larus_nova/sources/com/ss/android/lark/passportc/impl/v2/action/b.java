package com.ss.android.lark.passportc.impl.v2.action;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.passportc.entity.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final /* synthetic */ class b {
    public static void a(UserState r100, UserState r101, UserState r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        Intrinsics.checkNotNullParameter(r102, "expect");
        if (r100 == r101) goto L7;
        if (r101 != r102) goto L7;
        return;
    L7:
        throw new IllegalStateException("action state error, state: " + r100 + " -> " + r101);
    }
}
