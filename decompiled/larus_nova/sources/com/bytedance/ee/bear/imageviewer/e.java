package com.bytedance.ee.bear.imageviewer;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;

/* JADX INFO: loaded from: classes16.dex */
public final class e {
    public static void a(ImageData.Image r100) {
        if (r100 != null) goto L4;
        String r101 = "";
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L29;
        v45.a r102 = (v45.a) org.koin.java.a.a(v45.a.class);
        if (r102.a(r101) == false) goto L15;
        String r103 = r102.b(r101);
        if (TextUtils.isEmpty(r103) == true) goto L25;
        tt5.a.h("ImageUrlConverter", "convertRealPath(): localImage = " + du5.b.g(r103));
        r100.setOriginalSrc(r103);
        return;
    L25:
        return;
    L15:
        if (r102.e(r101) == false) goto L27;
        String r104 = r102.f(r101);
        if (TextUtils.isEmpty(r104) == false) goto L20;
        r104 = r102.f(r100.getSrc());
        tt5.a.h("ImageUrlConverter", "convertRealPath(): netImage src = " + du5.b.g(r100.getSrc()));
    L20:
        if (TextUtils.isEmpty(r104) == true) goto L22;
        r100.setSrc(r104);
        return;
    L22:
        tt5.a.k("ImageUrlConverter", "convertRealPath() netImage  " + r101 + " is not foud ...");
        return;
    L27:
        return;
    L29:
        return;
    L4:
        r101 = r100.getRealSrc();
        goto L5
    }
}
