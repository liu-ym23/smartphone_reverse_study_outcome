package com.bytedance.awemeopen.apps.framework.landscape.ui;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k {
    public static final String a(Long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_PLACEHOLDER);
        if (r100 != null) goto L5;
    L9:
        return r101;
    L5:
        if (r100.longValue() <= 0) goto L9;
        int r102 = com.bytedance.awemeopen.infra.util.k.f198968a;
        return com.bytedance.awemeopen.infra.util.k.b(r100.longValue());
    }

    public static final Long b(Long r100, boolean r101, boolean r102) {
        if (r100 == null) goto L8;
        if (r101 == false) goto L8;
        if (r102 == true) goto L8;
        return Long.valueOf(r100.longValue() - 1);
    L8:
        if (r101 == true) goto L15;
        if (r102 == false) goto L16;
        if (r100 != null) goto L14;
        return 1L;
    L14:
        return Long.valueOf(r100.longValue() + 1);
    L16:
        return r100;
    L15:
        return r100;
    }
}
