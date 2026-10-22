package com.bytedance.ee.bear.drive.view.preview.excel;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements Function<String, Publisher<DriveFilePath>> {
    public final /* synthetic */ String a;
    public final /* synthetic */ j b;

    public final Object apply(Object r13) throws Exception {
        String r14 = (String) r13;
        j r16 = this.b;
        t r0 = r16.a;
        z r17 = r16.b;
        String r1 = r17.p;
        String r2 = r17.o;
        String r18 = r17.n;
        String r3 = this.a;
        r0.getClass();
        y75.b r19 = t.b(r1, r2, r18, r3);
        if (r19 != null) goto L5;
        j r110 = this.b;
        ExcelCacheHelper r4 = r110.i;
        String r5 = r110.d.getApiPrefix();
        j r111 = this.b;
        t r6 = r111.a;
        DriveFilePath r7 = r111.f;
        z r8 = r111.b;
        return r4.b(r5, r6, r7, r8.p, r8.o, r8.n, this.a, r8.s, r8.t, DrivePriority.DownloadPriority.PREVIEW, r111.j);
    L5:
        DriveFilePath.a r9 = DriveFilePath.Companion;
        String r112 = r19.e;
        r9.getClass();
        DriveFilePath r113 = DriveFilePath.a.b(r112);
        tt5.a.h("ExcelRenderModel", "get cache form local file, subId = " + this.a);
        return Flowable.just(r113);
    }

    public i(j r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
