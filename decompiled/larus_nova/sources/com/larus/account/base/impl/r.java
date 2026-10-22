package com.larus.account.base.impl;

import com.larus.login.impl.switchbind.SwitchBindViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes24.dex */
public final class r extends ua7.a<xa7.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n38.m f286184a;

    public r(SwitchBindViewModel.AnonymousClass1.a r100) {
        this.f286184a = r100;
    }

    @Override // ua7.a
    public final void onResponse(ua7.b r100) {
        xa7.c r101 = (xa7.c) r100;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.f549249c != true) goto L7;
    L9:
        if (r102 == true) goto L35;
        n38.m r103 = this.f286184a;
        if (r101 == null) goto L27;
        int r104 = r101.f549253g;
    L28:
        if (r101 == null) goto L30;
        String r105 = r101.f549255i;
    L31:
        if (r105 != null) goto L33;
        r105 = "";
    L33:
        r103.a(r104, r105, null, null);
        return;
    L30:
        r105 = null;
        goto L31
    L27:
        r104 = -1;
        goto L28
    L35:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L12
        String r107 = r101.f563072z.toString();     // Catch: Throwable -> L12
        FLogger.f375446a.i("solveConflictAndSwitchBind", "jsonStr:" + r107);     // Catch: Throwable -> L12
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L18;
        FLogger.f375446a.e("solveConflictAndSwitchBind", String.valueOf(r109));
    L18:
        if (Result.m9455isFailureimpl(r108) == false) goto L21;
        r108 = null;
    L21:
        if (((Unit) r108) == null) goto L23;
    L23:
        this.f286184a.onSuccess(null);
        return;
    L12:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = false;
        goto L9
    }
}
