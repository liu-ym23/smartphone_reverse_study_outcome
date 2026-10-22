package com.bytedance.ee.bear.document.offline.sync;

import com.bytedance.ee.bear.contract.drive.DriveManualResponseEntity;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n implements com.bytedance.ee.bear.h.a {
    public final /* synthetic */ DocxPreloadStrategyV2 a;
    public final /* synthetic */ CopyOnWriteArrayList<String> b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public n(DocxPreloadStrategyV2 r1, CopyOnWriteArrayList<String> r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a(DriveManualResponseEntity r5) {
        tt5.a.h(this.a.a, "preloadFiles response status : " + Integer.valueOf(r5.a) + "   filetoken : " + du5.b.i(r5.b) + ' ');
        if (h0.o == true) goto L5;
        return;
    L5:
        if (r5.a != 5) goto L20;
        CopyOnWriteArrayList<String> r0 = this.b;
        if (r0 == null) goto L9;
        r0.remove(r5.b);
    L9:
        String r6 = this.a.a;
        StringBuilder r1 = new StringBuilder("preloadFiles batchImgPreloadJobs 3 blockList : ");
        CopyOnWriteArrayList<String> r2 = this.b;
        if (r2 == null) goto L12;
        Integer r3 = Integer.valueOf(r2.size());
    L13:
        r1.append(r3);
        r1.append(' ');
        tt5.a.h(r6, r1.toString());
        CopyOnWriteArrayList<String> r7 = this.b;
        if (r7 != null) goto L16;
    L17:
        tt5.a.h(this.a.a, "preloadFiles DOWNLOAD_TYPE_UNKNOWN docToken: " + du5.b.i(this.c) + " originToken: " + du5.b.i(this.d));
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).k(this.d, 0);
        return;
    L16:
        if (r7.size() == 0) goto L17;
        return;
    L12:
        r3 = null;
        goto L13
    }
}
