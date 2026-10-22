package com.ss.android.lark.watermark.userscope;

import android.app.Activity;
import androidx.lifecycle.Observer;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WatermarkImplV3 f445477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f445478b;

    public o(WatermarkImplV3 r100, Activity r101) {
        this.f445477a = r100;
        this.f445478b = r101;
    }

    public final void a() {
        com.ss.android.lark.watermark.v2.t r100 = this.f445477a.f445354f.remove(this.f445478b);
        if (r100 == null) goto L9;
        Observer<com.ss.android.lark.watermark.v2.v> r101 = r100.f445554a.get();
        if (r101 == null) goto L7;
        this.f445477a.f().f().removeObserver(r101);
        this.f445477a.f().b().removeObserver(r101);
    L7:
        com.ss.android.lark.watermark.v2.q<?> r102 = r100.f445555b;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r102.a(this.f445478b);
        return;
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
