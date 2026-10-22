package com.ss.android.lark.officesdk.minutes.ui.service;

import android.content.Context;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qub.h;

/* JADX INFO: loaded from: classes37.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f436812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f436813b;

    public e(h r100, h r101) {
        this.f436812a = r100;
        this.f436813b = r101;
    }

    @Override // qub.h
    public final void u(Context r100, rub.e r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        int r102 = f.f436814a;
        h r103 = this.f436812a;
        if (r103 != null) goto L17;
        boolean r104 = false;
    L13:
        if (r104 == false) goto L15;
        return;
    L15:
        this.f436813b.u(r100, r101);
        return;
    L17:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        r103.u(r100, r101);     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L12;
        int r108 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "styleProvider", "host toast provider failed e=" + r107, null);
    L12:
        r104 = Result.m9456isSuccessimpl(r106);
    L7:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
