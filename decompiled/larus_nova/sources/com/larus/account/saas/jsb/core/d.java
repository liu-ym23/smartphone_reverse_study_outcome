package com.larus.account.saas.jsb.core;

import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y38.k;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements x38.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x38.g<Unit> f286391a;

    public d(k r100) {
        this.f286391a = r100;
    }

    @Override // x38.b
    public final void a(b48.c r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        c48.a.a().a();
        String r101 = com.larus.init.task.accountsdk.a.f351133a.getApplication().getString(R.string.larus_accountsdk_accountRestrict_toast_networkError);
        x38.g<Unit> r102 = this.f286391a;
        FlowAccountLogoutCore.Error r103 = FlowAccountLogoutCore.Error.LOGOUT_FAILED;
        int r104 = r103.getCode();
        if (StringsKt.isBlank(r101) == false) goto L5;
        r101 = r103.getMessage();
    L5:
        r102.a(new x38.a(r104, r101, null));
    }

    @Override // x38.b
    public final void b(b48.g r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f286391a.onSuccess(Unit.INSTANCE);
    }
}
