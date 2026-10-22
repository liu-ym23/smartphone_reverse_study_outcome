package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes18.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<OfficeUploadRecoveryTarget> f235342a;

    public b0(List<OfficeUploadRecoveryTarget> r100) {
        this.f235342a = r100;
    }

    public final void a() {
        Iterator<T> r100 = this.f235342a.iterator();
    L4:
        if (r100.hasNext() == false) goto L17;
        OfficeUploadRecoveryTarget r101 = (OfficeUploadRecoveryTarget) r100.next();
        OfficeUploadRecoveryCoordinator.f235291a.getClass();
        String r102 = OfficeUploadRecoveryCoordinator.d(r101);
        String r103 = du5.b.k(r102);
        LinkedHashMap<String, OfficeUploadRecoveryCoordinator.a> r104 = OfficeUploadRecoveryCoordinator.f235294d;
        OfficeUploadRecoveryCoordinator.a r105 = r104.get(r102);
        if (r105 != null) goto L7;
        OfficeUploadRecoveryCoordinator.RecoveryMonitor r106 = new OfficeUploadRecoveryCoordinator.RecoveryMonitor(r101);
        r104.put(r102, new OfficeUploadRecoveryCoordinator.a(r101, r106));
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L11
        OfficeUploadRecoveryCoordinator.a().m(OfficeUploadRecoveryCoordinator.b(r101), FileInfoPuller.CALLER_EXPLORER, r106);     // Catch: Throwable -> L11
        tt5.a.h("OfficeUploadRecovery", "office_upload_recovery_trace register_monitor_success target=" + r103);     // Catch: Throwable -> L11
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L16;
        tt5.a.l("OfficeUploadRecovery", "office_upload_recovery_trace register_monitor_failed target=" + r103, r109);
    L16:
        OfficeUploadRecoveryCoordinator.c(r101);
    L11:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L7:
        r105.f235299c++;
        tt5.a.h("OfficeUploadRecovery", "office_upload_recovery_trace target_ref_inc target=" + r103 + " ref=" + r105.f235299c);
        OfficeUploadRecoveryCoordinator.c(r101);
        goto L4
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
