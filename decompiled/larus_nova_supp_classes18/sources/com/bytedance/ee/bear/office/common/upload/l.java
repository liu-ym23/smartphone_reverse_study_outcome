package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements Runnable {
    public final /* synthetic */ h0 a;

    public l(h0 r1) {
        this.a = r1;
    }

    public final void a() {
        k r0 = k.a;
        h0 r1 = this.a;
        r0.getClass();
        String r5 = r1.b;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L19
        boolean r7 = false;
        if (r5 != null) goto L6;
    L9:
        boolean r8 = true;
    L10:
        if (r8 == true) goto L16;
        tt5.a.h("OfficeUploadExecutor", "remove upload task with drive key, localId=" + r1.a + ", keyHash=" + r5.hashCode());     // Catch: Throwable -> L19
        k.a().d(new String[]{r5});     // Catch: Throwable -> L19
        String r3 = com.bytedance.ee.bear.middleground.drive.rustsdk.e0.c(r5);     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L19
        if (r3.length() <= 0) goto L14;
        r7 = true;
    L14:
        if (r7 == false) goto L17;
        k.a().z(r3);     // Catch: Throwable -> L19
    L17:
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r9 = Result.exceptionOrNull-impl(r4);
        if (r9 == null) goto L28;
        StringBuilder r10 = new StringBuilder("remove upload task cleanup failed, localId=");
        r10.append(r1.a);
        r10.append(", keyHash=");
        if (r5 == null) goto L26;
        Integer r2 = Integer.valueOf(r5.hashCode());
    L27:
        r10.append(r2);
        tt5.a.l("OfficeUploadExecutor", r10.toString(), r9);
        goto L28
    L26:
        r2 = null;
    L28:
        Handler r11 = OfficeUploadStore.a;
        final String r12 = r1.a;
        Intrinsics.checkNotNullParameter(r12, "localId");
        OfficeUploadStore.e(new OfficeUploadStore$removeTask$1(r12));
        return;
    L16:
        tt5.a.h("OfficeUploadExecutor", "remove upload task without drive key, localId=" + r1.a);     // Catch: Throwable -> L19
        goto L17
    L6:
        if (r5.length() == 0) goto L9;
        r8 = false;
    L19:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
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
