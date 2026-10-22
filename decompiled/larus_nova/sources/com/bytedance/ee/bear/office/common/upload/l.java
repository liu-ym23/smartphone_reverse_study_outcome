package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f235403a;

    public l(h0 r100) {
        this.f235403a = r100;
    }

    public final void a() {
        k r100 = k.f235392a;
        h0 r101 = this.f235403a;
        r100.getClass();
        String r102 = r101.f235374b;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L19
        boolean r104 = false;
        if (r102 != null) goto L6;
    L9:
        boolean r105 = true;
    L10:
        if (r105 == true) goto L16;
        tt5.a.h("OfficeUploadExecutor", "remove upload task with drive key, localId=" + r101.f235373a + ", keyHash=" + r102.hashCode());     // Catch: Throwable -> L19
        k.a().d(new String[]{r102});     // Catch: Throwable -> L19
        String r106 = com.bytedance.ee.bear.middleground.drive.rustsdk.e0.c(r102);     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L19
        if (r106.length() <= 0) goto L14;
        r104 = true;
    L14:
        if (r104 == false) goto L17;
        k.a().z(r106);     // Catch: Throwable -> L19
    L17:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L28;
        StringBuilder r109 = new StringBuilder("remove upload task cleanup failed, localId=");
        r109.append(r101.f235373a);
        r109.append(", keyHash=");
        if (r102 == null) goto L26;
        Integer r110 = Integer.valueOf(r102.hashCode());
    L27:
        r109.append(r110);
        tt5.a.l("OfficeUploadExecutor", r109.toString(), r108);
        goto L28
    L26:
        r110 = null;
    L28:
        Handler r111 = OfficeUploadStore.f235310a;
        final String r112 = r101.f235373a;
        Intrinsics.checkNotNullParameter(r112, "localId");
        OfficeUploadStore.e(new OfficeUploadStore$removeTask$1(r112));
        return;
    L16:
        tt5.a.h("OfficeUploadExecutor", "remove upload task without drive key, localId=" + r101.f235373a);     // Catch: Throwable -> L19
        goto L17
    L6:
        if (r102.length() == 0) goto L9;
        r105 = false;
    L19:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
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
