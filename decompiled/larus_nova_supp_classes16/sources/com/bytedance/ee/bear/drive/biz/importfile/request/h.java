package com.bytedance.ee.bear.drive.biz.importfile.request;

import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import l55.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ StartImportRequesterManagerImplV2 a;

    public h(StartImportRequesterManagerImplV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        StartImportRequesterManagerImplV2.StartImportResult r7 = (StartImportRequesterManagerImplV2.StartImportResult) r6;
        tt5.a.b("StartImportRequesterManagerImplV2", "ticket " + r7.getTicket());
        StartImportRequesterManagerImplV2 r0 = this.a;
        r0.d.a(r0.f.a, "check_import_result");
        StartImportRequesterManagerImplV2 r1 = this.a;
        r1.d.j(r1.f.a, "start_import_file");
        StartImportRequesterManagerImplV2 r2 = this.a;
        String r3 = r7.getTicket();
        int r8 = r7.getJob_timeout();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "ticket");
        r2.h.add(r2.j.Vc(new StartImportRequesterManagerImplV2.a()).a(new NetService.f("/space/api/import/result/" + r3)).repeatWhen(j.a).takeUntil(new c(r8)).filter(d.a).subscribeOn(fo5.d.d()).subscribe(new e(r2), new f(r2)));
    }
}
