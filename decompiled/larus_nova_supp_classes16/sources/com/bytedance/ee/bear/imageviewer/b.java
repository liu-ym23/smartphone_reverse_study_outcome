package com.bytedance.ee.bear.imageviewer;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public final com.bytedance.ee.bear.contract.d a;

    public b(com.bytedance.ee.bear.contract.d r1) {
        this.a = r1;
    }

    public final void a(int r3, String r4, String r5, long r6, long r8) {
        HashMap r0 = new HashMap();
        r0.put("code", Integer.toString(r3));
        r0.put("msg", r4);
        r0.put("pic_from", r5);
        r0.put("pic_size", Long.toString(r6));
        r0.put("cost_time", Long.toString(r8));
        r0.put("image_type", Integer.toString(-1));
        tt5.a.h("DownloadImageAnalytic", r0.toString());
        com.bytedance.ee.bear.contract.d r7 = this.a;
        if (r7 == null) goto L6;
        r7.v("dev_performance_native_pic_download_result", r0);
        return;
    }
}
