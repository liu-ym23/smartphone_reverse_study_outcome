package com.larus.office.base.plugins.attachment;

import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g implements ut5.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f360719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> f360720b;

    @Override // ut5.a
    public final void onResult(Boolean r100) {
        Boolean r101 = r100;
        FLogger.f375446a.i("[OfficePermissionTracer]", "validatePermission[" + this.f360719a + "] result: " + r101);
        if (this.f360720b.isActive() == false) goto L6;
        kotlinx.coroutines.i<Boolean> r102 = this.f360720b;
        Result.Companion r103 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(Boolean.valueOf(Intrinsics.areEqual(r101, Boolean.TRUE))));
        return;
    }

    public g(String r100, kotlinx.coroutines.j r101) {
        this.f360719a = r100;
        this.f360720b = r101;
    }

    @Override // ut5.a
    public final void onError(int r100, Throwable r101) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("validatePermission[");
        r103.append(this.f360719a);
        r103.append("] error: ");
        r103.append(r100);
        r103.append(", ");
        if (r101 == null) goto L5;
        String r104 = r101.getMessage();
    L6:
        r103.append(r104);
        r102.i("[OfficePermissionTracer]", r103.toString());
        if (this.f360720b.isActive() == false) goto L10;
        kotlinx.coroutines.i<Boolean> r105 = this.f360720b;
        Result.Companion r106 = Result.Companion;
        r105.resumeWith(Result.m9449constructorimpl(Boolean.FALSE));
        return;
    L10:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
