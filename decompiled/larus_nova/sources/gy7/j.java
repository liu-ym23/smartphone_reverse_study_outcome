package gy7;

import com.lark.kmp.basic.ActionContext;
import com.lark.kmp.basic.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j extends b {
    public j(p r100, ActionContext r101) {
        Intrinsics.checkNotNullParameter(r100, "userPayload");
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        super(new u(UserState.OFFLINE, r101), r100);
    }
}
