package com.bytedance.ee.bear.imageviewer;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static void a(ImageData.Image r5) {
        if (r5 != null) goto L4;
        String r0 = "";
    L5:
        if (r5 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r0) == true) goto L29;
        v45.a r1 = (v45.a) org.koin.java.a.a(v45.a.class);
        if (r1.a(r0) == false) goto L15;
        String r2 = r1.b(r0);
        if (TextUtils.isEmpty(r2) == true) goto L25;
        tt5.a.h("ImageUrlConverter", "convertRealPath(): localImage = " + du5.b.g(r2));
        r5.setOriginalSrc(r2);
        return;
    L25:
        return;
    L15:
        if (r1.e(r0) == false) goto L27;
        String r3 = r1.f(r0);
        if (TextUtils.isEmpty(r3) == false) goto L20;
        r3 = r1.f(r5.getSrc());
        tt5.a.h("ImageUrlConverter", "convertRealPath(): netImage src = " + du5.b.g(r5.getSrc()));
    L20:
        if (TextUtils.isEmpty(r3) == true) goto L22;
        r5.setSrc(r3);
        return;
    L22:
        tt5.a.k("ImageUrlConverter", "convertRealPath() netImage  " + r0 + " is not foud ...");
        return;
    L27:
        return;
    L29:
        return;
    L4:
        r0 = r5.getRealSrc();
        goto L5
    }
}
