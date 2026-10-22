package com.bytedance.ee.bear.bitable.common.widgets.flex;

import com.bytedance.ee.bear.bitable.n;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class a<T> {
    public static float a(b r100, List r110, int r111, double r112) {
        Intrinsics.checkNotNullParameter(r110, "data");
        int r101 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r102 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.modify_flex_measure_max_size_enable") == false) goto L5;
        float r113 = r111;
    L6:
        Iterator<T> r114 = r110.iterator();
        float r103 = 1.0f;
        float r104 = 0.0f;
    L8:
        if (r114.hasNext() == false) goto L22;
        float r105 = r100.g2(r114.next());
        if (r104 != 0.0f) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
    L17:
        r104 = r104 + r105;
    L19:
        if (r103 <= Math.floor(r112)) goto L8;
        return (float) r112;
    L15:
        if ((r104 + r105) <= r113) goto L17;
        r103 = r103 + 1.0f;
        r104 = r105;
        goto L19
    L12:
        r106 = false;
        goto L13
    L22:
        return r103;
    L5:
        r113 = r111 + r100.m1();
        goto L6
    }
}
