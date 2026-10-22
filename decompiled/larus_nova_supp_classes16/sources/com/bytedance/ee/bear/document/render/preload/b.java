package com.bytedance.ee.bear.document.render.preload;

import android.os.Build;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.container.DocumentImpl;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    static {
    }

    public static String a(DocumentImpl.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponent");
        String r3 = ((com.bytedance.ee.bear.document.template.a) r2.a(com.bytedance.ee.bear.document.template.a.class)).y0();
        if (DocOpenConfig.g() == true) goto L5;
    L7:
        String r0 = "https://";
    L8:
        String r4 = r0 + r3 + p.a().U0();
        tt5.a.h("TemplateUtils", "getPreloadUrl: url = " + r4);
        return r4;
    L5:
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        r0 = "http://";
        goto L8
    }
}
