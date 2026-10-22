package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import androidx.core.util.Pair;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements Runnable {
    public final /* synthetic */ h0 a;

    public m(h0 r1) {
        this.a = r1;
    }

    public final void a() {
        k r0 = k.a;
        h0 r2 = this.a;
        r0.getClass();
        String r3 = r2.b;
        boolean r4 = true;
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L25;
        int r5 = e0.a;
        OfficeUploadTaskSource r6 = r2.n;
        Intrinsics.checkNotNullParameter(r6, "source");
        if (r6 != OfficeUploadTaskSource.LOCAL) goto L21;
        if (r3 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r7 == false) goto L21;
    L22:
        if (r4 == true) goto L24;
        tt5.a.k("OfficeUploadExecutor", "retry recovered upload without key, localId=" + r2.a);
        final String r8 = eu5.b.a.getString(2131892996);
        Handler r9 = OfficeUploadStore.a;
        OfficeUploadStore.f(r2.a, new OfficeUploadExecutor$retryInternal$1(r8));
        k.b(r8);
        return;
    L24:
        tt5.a.h("OfficeUploadExecutor", "retry upload without key, restart by local task, localId=" + r2.a);
        h0 r10 = h0.a(r2, null, null, null, false, null, null, null, null, null, null, OfficeUploadStatus.UNSTARTED, null, null, null, 0, 0, 58367);
        Intrinsics.checkNotNullParameter(r10, "task");
        k.b.execute(new n(r10));
        return;
    L15:
        if (StringsKt.isBlank(r3) == true) goto L18;
        r7 = false;
    L21:
        r4 = false;
        goto L22
    L25:
        tt5.a.h("OfficeUploadExecutor", "resume upload, localId=" + r2.a + ", keyHash=" + r3.hashCode());
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L28
        Object r12 = Result.constructor-impl(k.a().h(r3, new OfficeUploadExecutor$callbackFor$1(r2.a)));     // Catch: Throwable -> L28
    L30:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 != null) goto L47;
        final Pair r14 = (Pair) r12;
        Integer r15 = (Integer) r14.first;
        if (r15 != null) goto L36;
    L46:
        tt5.a.k("OfficeUploadExecutor", "resume upload failed, localId=" + r2.a + ", code=" + r14.first + ", message=" + ((String) r14.second));
        final String r16 = k.d(((Number) r14.first).intValue(), (String) r14.second);
        Handler r17 = OfficeUploadStore.a;
        OfficeUploadStore.f(r2.a, new OfficeUploadExecutor$retryInternal$2(r14, r16));
        k.b(r16);
        return;
    L36:
        if (r15.intValue() != 0) goto L46;
        CharSequence r18 = (CharSequence) r14.second;
        if (r18 != null) goto L40;
    L43:
        if (r4 == true) goto L46;
        tt5.a.h("OfficeUploadExecutor", "resume upload accepted, localId=" + r2.a + ", newKeyHash=" + ((String) r14.second).hashCode());
        Handler r19 = OfficeUploadStore.a;
        OfficeUploadStore.f(r2.a, new OfficeUploadExecutor$retryInternal$3(r14));
        return;
    L40:
        if (r18.length() == 0) goto L43;
        r4 = false;
        goto L43
    L47:
        tt5.a.l("OfficeUploadExecutor", "resume upload throw, localId=" + r2.a + ", keyHash=" + r3.hashCode(), r13);
        k.a.getClass();
        final String r20 = eu5.b.a.getString(2131892996);
        Handler r21 = OfficeUploadStore.a;
        OfficeUploadStore.f(r2.a, new OfficeUploadExecutor$retryInternal$result$2$1(r20));
        k.b(r20);
        return;
    L28:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L10
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
