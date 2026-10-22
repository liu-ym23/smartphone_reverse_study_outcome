package com.larus.account.saas.jsb.core;

import kotlin.Unit;
import y38.m;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements x38.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x38.g<Unit> f286392a;

    @Override // x38.h
    public final void onSendSuccess() {
        this.f286392a.onSuccess(Unit.INSTANCE);
    }

    public e(m r100) {
        this.f286392a = r100;
    }

    @Override // x38.h
    public final void a(int r100, String r101) {
        x38.g<Unit> r102 = this.f286392a;
        Integer r103 = Integer.valueOf(r100);
        if (r103.intValue() != 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L12;
        int r105 = r103.intValue();
    L13:
        if (r101 != null) goto L15;
        r101 = FlowAccountMobileSendCodeCore.Error.SEND_CODE_FAILED.getMessage();
    L15:
        r102.a(new x38.a(r105, r101, null));
        return;
    L12:
        r105 = FlowAccountMobileSendCodeCore.Error.SEND_CODE_FAILED.getCode();
        goto L13
    L5:
        r104 = false;
        goto L7
    }
}
