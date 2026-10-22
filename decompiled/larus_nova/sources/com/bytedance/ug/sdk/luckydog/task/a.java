package com.bytedance.ug.sdk.luckydog.task;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f271841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f271842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f271843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ServiceConnection f271844d;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        super.handleMessage(r100);     // Catch: Throwable -> L8
        if (r100.what != 36866) goto L6;
        il7.m r102 = AppActivateHelper.f271819a;     // Catch: Throwable -> L8
        AppActivateHelper.g("consume_token", this.f271841a, this.f271842b);     // Catch: Throwable -> L8
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "[" + this.f271841a + "] receive TOKEN_CONSUME, call unbindService");     // Catch: Throwable -> L8
        this.f271843c.unbindService(this.f271844d);     // Catch: Throwable -> L8
        AppActivateHelper.f271828j.remove(this.f271842b);     // Catch: Throwable -> L8
    L6:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        AppActivateHelper.i("handleMessage", r104);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public a(String r100, String r101, Context r102, b r103, Looper r104) {
        this.f271841a = r100;
        this.f271842b = r101;
        this.f271843c = r102;
        this.f271844d = r103;
        super(r104);
    }
}
