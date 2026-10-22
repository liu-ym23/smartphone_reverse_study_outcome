package com.ss.android.lark.auditsdk.screen;

import com.ss.android.lark.log.Log;
import java.util.function.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f409583a;

    public g(e r100) {
        this.f409583a = r100;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        e r102 = this.f409583a;
        Intrinsics.checkNotNull(r101);
        int r103 = r101.intValue();
        if (r103 == r102.f409581f) goto L20;
        Log.i("ScreenAuditCore", "[" + r102.f409576a + "] screen recording state changed, previous=" + r102.f409581f + " current=" + r103);
        r102.f409581f = r103;
        if (r103 != 1) goto L18;
        Log.i("ScreenAuditCore", "[" + r102.f409576a + "] screen recording visible, report audit");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L10
        r102.f409577b.invoke();     // Catch: Throwable -> L10
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L19;
        Log.e("ScreenAuditCore", "[" + r102.f409576a + "] onScreenRecordingVisible failed", r106);
        return;
    L19:
        return;
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L18:
        return;
    }
}
