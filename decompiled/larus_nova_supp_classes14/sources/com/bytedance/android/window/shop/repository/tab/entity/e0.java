package com.bytedance.android.window.shop.repository.tab.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e0 extends f {
    public static final a m = null;
    public final d0 j;
    public WindowLayoutType k;
    public final List<d> l;

    public static final class a {
        public a() {
        }

        public static e0 a(List r7, WindowLayoutType r8, List r9) {
            Intrinsics.checkNotNullParameter(r7, "sortTypeDtoList");
            Intrinsics.checkNotNullParameter(r8, "layoutType");
            int r0 = d0.k;
            d0 r10 = d0.a.a(r7);
            ArrayList r1 = null;
            if (r9 == null) goto L20;
            ArrayList r2 = new ArrayList();
            Iterator r11 = r9.iterator();
        L6:
            if (r11.hasNext() == false) goto L18;
            com.bytedance.android.window.shop.repository.dto.a r3 = (com.bytedance.android.window.shop.repository.dto.a) r11.next();
            int r4 = d.e;
            Intrinsics.checkNotNullParameter(r3, "dto");
            Integer r5 = r3.a();
            if (r5 == null) goto L15;
            int r6 = r5.intValue();
            String r12 = r3.b();
            if (r12 == null) goto L15;
            Boolean r13 = r3.d();
            if (r13 == null) goto L15;
            d r14 = new d(r6, r12, r13.booleanValue(), r3.c());
        L16:
            if (r14 == null) goto L6;
            r2.add(r14);
        L15:
            r14 = null;
            goto L16
        L18:
            r1 = r2;
        L20:
            return new e0(r10, r8, r1);
        }
    }

    static {
        m = new a();
    }

    public e0(d0 r2, WindowLayoutType r3, List<d> r4) {
        Intrinsics.checkNotNullParameter(r2, "sortBarVO");
        Intrinsics.checkNotNullParameter(r3, "layout");
        super(2503);
        this.j = r2;
        this.k = r3;
        this.l = r4;
    }
}
