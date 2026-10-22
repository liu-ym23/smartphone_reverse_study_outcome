package com.ss.android.lark.active.message.impl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import j0c.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Result;", "Lcom/ss/android/lark/passportc/task/entity/UpdateStateResult;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class MultiTenantMsgSwitchImpl$closeMultiTenantMsg$1 extends Lambda implements Function1<Result<? extends d>, Unit> {
    public static final MultiTenantMsgSwitchImpl$closeMultiTenantMsg$1 INSTANCE = null;

    static {
        INSTANCE = new MultiTenantMsgSwitchImpl$closeMultiTenantMsg$1();
    }

    public MultiTenantMsgSwitchImpl$closeMultiTenantMsg$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m8601invoke(Object r100) {
        if (Result.m9456isSuccessimpl(r100) == false) goto L6;
        PassportLog.d("active_user_MultiTenantMsgSwitch", "closeMultiTenantMsg updateActiveUsers = isSuccess");
        return;
    L6:
        if (Result.m9455isFailureimpl(r100) == false) goto L10;
        PassportLog.d("active_user_MultiTenantMsgSwitch", "closeMultiTenantMsg updateActiveUsers = isFailure");
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Result<? extends d> r100) {
        m8601invoke(r100.m9458unboximpl());
        return Unit.INSTANCE;
    }
}
