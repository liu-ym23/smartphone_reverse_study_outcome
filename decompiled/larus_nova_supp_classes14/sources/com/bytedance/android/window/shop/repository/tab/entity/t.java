package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.d1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t extends c0 {
    public static final /* synthetic */ int u = 0;
    public String t;

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<? extends com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO>] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
        public static t a(int r4, d1 r5) {
            Intrinsics.checkNotNullParameter(r5, "dto");
            t r0 = new t(r4);
            r0.j = r5.a();
            r0.l = r5.c();
            r0.m = r5.d();
            r0.k = r5.h();
            List<WindowV2ProductItemDTO> r6 = r5.f();
            if (r6 == null) goto L8;
            List<WindowV2ProductItemDTO> r7 = r6;
            ?? r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator r8 = r7.iterator();
        L6:
            if (r8.hasNext() == false) goto L9;
            WindowV2ProductItemDTO r2 = (WindowV2ProductItemDTO) r8.next();
            r1.add(WindowV2ProductItemVO.a.c(WindowV2ProductItemVO.P, r2));
        L9:
            r0.q = r1;
            r0.r = r5.b();
            r0.t = r5.g();
            r0.o = r5.e();
            return r0;
        L8:
            r1 = CollectionsKt.emptyList();
            goto L9
        }
    }

    static {
    }

    public t(int r1) {
        super(r1);
    }
}
