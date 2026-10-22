package gy7;

import com.lark.kmp.basic.ActionContext;
import com.lark.kmp.basic.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends b {
    public a(ActionContext r100) {
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        super(new u(UserState.OFFLINE, r100), null);
    }
}
