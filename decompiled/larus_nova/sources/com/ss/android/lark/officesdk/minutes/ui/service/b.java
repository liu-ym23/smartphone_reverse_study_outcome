package com.ss.android.lark.officesdk.minutes.ui.service;

import android.content.Context;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements qub.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qub.c f436806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qub.c f436807b;

    @Override // qub.c
    public final void B(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = f.f436814a;
        qub.c r102 = this.f436806a;
        if (r102 != null) goto L17;
        boolean r103 = false;
    L13:
        if (r103 == false) goto L15;
        return;
    L15:
        this.f436807b.B(r100);
        return;
    L17:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
        r102.B(r100);     // Catch: Throwable -> L7
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L12;
        int r107 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "styleProvider", "host dismissAllDialogs provider failed e=" + r106, null);
    L12:
        r103 = Result.m9456isSuccessimpl(r105);
    L7:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public b(qub.c r100, qub.c r101) {
        this.f436806a = r100;
        this.f436807b = r101;
    }

    @Override // qub.c
    public final void u0(Context r100, rub.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        int r102 = f.f436814a;
        qub.c r103 = this.f436806a;
        if (r103 != null) goto L17;
        boolean r104 = false;
    L13:
        if (r104 == false) goto L15;
        return;
    L15:
        this.f436807b.u0(r100, r101);
        return;
    L17:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        r103.u0(r100, r101);     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L12;
        int r108 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "styleProvider", "host dialog provider failed e=" + r107, null);
    L12:
        r104 = Result.m9456isSuccessimpl(r106);
    L7:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
