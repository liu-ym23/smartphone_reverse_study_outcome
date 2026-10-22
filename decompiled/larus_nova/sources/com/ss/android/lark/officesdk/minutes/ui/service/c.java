package com.ss.android.lark.officesdk.minutes.ui.service;

import android.content.Context;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements qub.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qub.d f436808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qub.d f436809b;

    @Override // qub.d
    public final void t0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = f.f436814a;
        qub.d r102 = this.f436808a;
        if (r102 != null) goto L17;
        boolean r103 = false;
    L13:
        if (r103 == false) goto L15;
        return;
    L15:
        this.f436809b.t0(r100);
        return;
    L17:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
        r102.t0(r100);     // Catch: Throwable -> L7
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L12;
        int r107 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "styleProvider", "host hideAllLoadings provider failed e=" + r106, null);
    L12:
        r103 = Result.m9456isSuccessimpl(r105);
    L7:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public c(qub.d r100, qub.d r101) {
        this.f436808a = r100;
        this.f436809b = r101;
    }
}
