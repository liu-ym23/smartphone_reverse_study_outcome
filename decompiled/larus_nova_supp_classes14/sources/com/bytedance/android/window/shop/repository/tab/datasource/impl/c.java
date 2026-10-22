package com.bytedance.android.window.shop.repository.tab.datasource.impl;

import com.bytedance.android.window.shop.repository.dto.WindowExtensionDataListResponseDTO;
import com.bytedance.android.window.shop.repository.dto.w;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowVODataType;
import com.bytedance.android.window.shop.repository.tab.entity.n0;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.datasource.c b;

    public c(a r1, com.bytedance.android.window.shop.repository.tab.datasource.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Pair r9 = (Pair) r8;
        WindowExtensionDataListResponseDTO r0 = (WindowExtensionDataListResponseDTO) r9.component1();
        List r10 = (List) r9.component2();
        a.a(this.a, r10);
        uq3.j r3 = null;
        if ((!r10.isEmpty()) == false) goto L5;
        this.b.y(new n0(r10, this.a.getType(), null, 12), ShopWindowVODataType.NORMAL);
    L5:
        ((mq3.a) this.a.e.b()).setExtensionCardParam(null);
        a r11 = this.a;
        com.bytedance.android.window.shop.repository.tab.datasource.c r1 = this.b;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r0, "dto");
        Intrinsics.checkNotNullParameter(r1, "callback");
        if (r0.getControlInfo() == null) goto L24;
        r11.b.update(true);
        w r2 = r0.getControlInfo();
        if (r2 == null) goto L10;
        int r4 = uq3.j.e;
        Intrinsics.checkNotNullParameter(r2, "dto");
        r3 = new uq3.j();
        r3.a = Intrinsics.areEqual(r2.c(), Boolean.TRUE);
        r3.b = r2.b();
        r3.c = r2.d();
        r3.d = r2.a();
    L10:
        if (r3 != null) goto L12;
        return;
    L12:
        if (r3.a == true) goto L14;
        return;
    L14:
        if (r3.b == null) goto L29;
        String r5 = r3.c;
        if (r5 == null) goto L30;
        ((mq3.a) r11.e.b()).setPath(r5);
        ((mq3.a) r11.e.b()).setCommonPassThroughParam(r3.d);
        mq3.a r6 = (mq3.a) r11.e.b();
        Integer r7 = r3.b;
        if (r7 == null) goto L22;
        int r12 = r7.intValue();
    L23:
        r6.setPageNum(r12);
        r11.b.a = r3.a;
        r1.e();
        r11.d(r1);
        return;
    L22:
        r12 = 0;
        goto L23
    L30:
        return;
    L29:
        return;
    L24:
        r1.c(r11);
    }
}
