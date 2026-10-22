package gy7;

import com.lark.kmp.basic.ActionContext;
import com.lark.kmp.basic.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class l extends b {
    public l(p r100, ActionContext r101) {
        Intrinsics.checkNotNullParameter(r100, "userPayload");
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        super(new u(UserState.ONLINE, r101), r100);
    }
}
