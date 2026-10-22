package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import android.os.SystemClock;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.CreateResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m<T, R> implements Function {
    public final /* synthetic */ a a;

    public m(a r1) {
        this.a = r1;
    }

    public final Object apply(Object r9) {
        CreateResult r10 = (CreateResult) r9;
        Intrinsics.checkNotNullParameter(r10, "it");
        a r0 = this.a;
        r0.e.a(r0.d, "check_import_result");
        r0.e.j(r0.d, "start_import_file");
        long r1 = SystemClock.uptimeMillis();
        if (r10.getJob_timeout() <= 0) goto L5;
        long r3 = r10.getJob_timeout();
    L6:
        tt5.a.h("ImImportFileModel", "checkImportResult ticket=" + r10.getTicket());
        NetService.f r5 = new NetService.f("/space/api/import/result/" + r10.getTicket());
        r5.c = 2;
        return r0.a.Vc(new com.bytedance.ee.bear.drive.biz.importfile.im.entity.b()).a(r5).map(b.a).subscribeOn(fo5.d.e()).doOnNext(c.a).repeatWhen(f.a).takeUntil(new g(r1, r3)).filter(h.a).doOnNext(new i(r0));
    L5:
        r3 = 60;
        goto L6
    }
}
