package com.ss.ugc.live.barrage.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f458167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ olc.a f458168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function3 f458169c;

    public f(View r100, olc.a r101, Function3 r102) {
        this.f458167a = r100;
        this.f458168b = r101;
        this.f458169c = r102;
    }

    public final void a() {
        View r100 = this.f458167a;
        olc.a r101 = this.f458168b;
        Lazy r102 = UtilsKt.f458142b;
        KProperty r103 = UtilsKt.f458141a[0];
        Handler r104 = (Handler) r102.getValue();
        monitor-enter(r100);
        UtilsKt.b(r100);     // Catch: Throwable -> L21
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));     // Catch: Throwable -> L21
        int r105 = r100.getMeasuredWidth();     // Catch: Throwable -> L21
        int r106 = r100.getMeasuredHeight();     // Catch: Throwable -> L21
        r100.layout(0, 0, r105, r106);     // Catch: Throwable -> L21
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L11
        if (r100.isOpaque() == false) goto L8;
        Bitmap.Config r108 = Bitmap.Config.RGB_565;     // Catch: Throwable -> L11
    L9:
        Bitmap r109 = r101.obtain(r105, r106, r108);     // Catch: Throwable -> L11
        r100.draw(new Canvas(r109));     // Catch: Throwable -> L11
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r110) == false) goto L16;
        r110 = null;
    L16:
        Bitmap r111 = (Bitmap) r110;     // Catch: Throwable -> L21
        if (r111 == null) goto L19;
        r104.post(new e(r111, r105, r106, r100, r101, this.f458169c));     // Catch: Throwable -> L21
    L19:
        monitor-exit(r100);
        return;
    L8:
        r108 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L21
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
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
