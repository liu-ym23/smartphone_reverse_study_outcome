package com.ss.android.lark.keyboard.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.base.r;
import com.ss.android.lark.log.Log;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.keyboard.b f430968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.keyboard.base.f f430969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Long f430970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f430971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f430972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ r f430973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f430974g;

    public i(com.ss.android.lark.keyboard.b r100, com.ss.android.lark.keyboard.base.f r101, Long r102, String r103, r r104, String r105) {
        this.f430968a = r100;
        this.f430969b = r101;
        this.f430970c = r102;
        this.f430971d = false;
        this.f430972e = r103;
        this.f430973f = r104;
        this.f430974g = r105;
    }

    public final void a() {
        com.ss.android.lark.keyboard.base.f r100 = this.f430969b;
        Long r101 = this.f430970c;
        boolean r102 = this.f430971d;
        String r103 = this.f430972e;
        r r104 = this.f430973f;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L5
        r100.F(false, r101, r102, r103, r104);     // Catch: Throwable -> L5
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        String r107 = this.f430974g;
        Throwable r108 = Result.m9452exceptionOrNullimpl(r106);
        if (r108 == null) goto L13;
        Log.e(r107, "sendContentByKeyboardEditor failed", r108);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
