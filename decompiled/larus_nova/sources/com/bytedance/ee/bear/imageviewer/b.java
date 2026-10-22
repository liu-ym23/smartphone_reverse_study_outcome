package com.bytedance.ee.bear.imageviewer;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f226809a;

    public b(com.bytedance.ee.bear.contract.d r100) {
        this.f226809a = r100;
    }

    public final void a(int r100, String r101, String r102, long r103, long r104) {
        HashMap r105 = new HashMap();
        r105.put("code", Integer.toString(r100));
        r105.put("msg", r101);
        r105.put("pic_from", r102);
        r105.put("pic_size", Long.toString(r103));
        r105.put(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.toString(r104));
        r105.put("image_type", Integer.toString(-1));
        tt5.a.h("DownloadImageAnalytic", r105.toString());
        com.bytedance.ee.bear.contract.d r106 = this.f226809a;
        if (r106 == null) goto L6;
        r106.v("dev_performance_native_pic_download_result", r105);
        return;
    }
}
