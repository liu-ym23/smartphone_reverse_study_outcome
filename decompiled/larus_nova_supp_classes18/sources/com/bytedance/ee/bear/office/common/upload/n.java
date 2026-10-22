package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority$UploadPriority;
import com.bytedance.ee.bear.middleground.drive.export.UploadRequestInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements Runnable {
    public final /* synthetic */ h0 a;

    public n(h0 r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final void a() {
        k r0 = k.a;
        n r1 = this;
        h0 r2 = r1.a;
        r0.getClass();
        OfficeUploadExecutor$callbackFor$1 r15 = new OfficeUploadExecutor$callbackFor$1(r2.a);
        StringBuilder r3 = new StringBuilder("start upload, localId=");
        r3.append(r2.a);
        r3.append(", target=");
        r3.append(k.c(r2.i));
        r3.append(", isFileUseUri=");
        r3.append(r2.d);
        r3.append(", pointer=");
        String r4 = r2.c;
        StringBuilder r5 = new StringBuilder("hash=");
        r5.append(r4.hashCode());
        r5.append(", length=");
        r5.append(r4.length());
        r5.append(", ext=");
        String r13 = "";
        r5.append(StringsKt.substringAfterLast(r4, '.', ""));
        r3.append(r5.toString());
        r3.append(", fileNameLength=");
        r3.append(r2.e.length());
        r3.append(", totalBytes=");
        r3.append(r2.g);
        tt5.a.h("OfficeUploadExecutor", r3.toString());
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L24
        com.bytedance.ee.bear.drive.sdk.service.g r7 = k.a();     // Catch: Throwable -> L24
        UploadRequestInfo.a r8 = new UploadRequestInfo.a();     // Catch: Throwable -> L24
        if (r2.d == false) goto L6;
        r8.b = r2.c;     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L24
    L7:
        r8.c = r2.e;     // Catch: Throwable -> L24
        r8.e = "explorer";     // Catch: Throwable -> L24
        g0 r9 = r2.i;     // Catch: Throwable -> L24
        if (Intrinsics.areEqual(r9, g0.b.a) == false) goto L11;
        String r10 = "";
    L13:
        r8.d = r10;     // Catch: Throwable -> L24
        r8.g = DrivePriority$UploadPriority.BACKGROUND.getPriority();     // Catch: Throwable -> L24
        Map<String, String> r11 = MapsKt.mapOf(TuplesKt.to("size_checker", "true"));     // Catch: Throwable -> L24
        r8.j = r11;     // Catch: Throwable -> L24
        r8.l = r15;     // Catch: Throwable -> L24
        r2 = r2;
        String r20 = "OfficeUploadExecutor";
        r13 = "";
        String r12 = ", target=";
        Object r14 = Result.constructor-impl(r7.s(new UploadRequestInfo(r8.a, r8.b, r8.c, r8.d, r8.e, r8.f, r8.g, r8.h, r8.i, r11, r8.k, r15)));     // Catch: Throwable -> L22
    L27:
        Object r16 = r14;
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 != null) goto L30;
        h0 r18 = r2;
        String r19 = r20;
    L31:
        final String r110 = (String) r16;
        if (r110 != null) goto L34;
    L37:
        boolean r21 = true;
    L38:
        if (r21 == false) goto L40;
        tt5.a.k(r19, "driveUpload return empty key, localId=" + r18.a + r12 + k.c(r18.i));
        final String r22 = eu5.b.a.getString(2131892996);
        Handler r23 = OfficeUploadStore.a;
        OfficeUploadStore.f(r18.a, new OfficeUploadExecutor$startInternal$1(r22));
        k.b(r22);
        return;
    L40:
        tt5.a.h(r19, "driveUpload accepted, localId=" + r18.a + ", keyHash=" + r110.hashCode());
        Handler r24 = OfficeUploadStore.a;
        OfficeUploadStore.f(r18.a, new OfficeUploadExecutor$startInternal$2(r110));
        return;
    L34:
        if (r110.length() == 0) goto L37;
        r21 = false;
        goto L38
    L30:
        StringBuilder r25 = new StringBuilder("driveUpload throw, localId=");
        r18 = r2;
        r25.append(r18.a);
        r25.append(r12);
        k r26 = k.a;
        g0 r27 = r18.i;
        r26.getClass();
        r25.append(k.c(r27));
        r19 = r20;
        tt5.a.l(r19, r25.toString(), r17);
        r16 = r13;
    L18:
        th = th;
        r1 = ", target=";
        r20 = "OfficeUploadExecutor";
    L26:
        Result.Companion r28 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        r12 = r1;
        goto L27
    L11:
        if ((r9 instanceof g0.a) == false) goto L21;
        r10 = ((g0.a) r9).a;     // Catch: Throwable -> L24
        goto L13
    L21:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L22
    L22:
        th = th;
        goto L26
    L6:
        r8.a = r2.c;     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L24
    L24:
        th = th;
        r20 = "OfficeUploadExecutor";
        r1 = ", target=";
        goto L26
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
