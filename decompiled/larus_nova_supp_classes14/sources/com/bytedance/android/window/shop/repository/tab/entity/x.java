package com.bytedance.android.window.shop.repository.tab.entity;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x extends f {
    public static final /* synthetic */ int l = 0;
    public int j;
    public final WindowProductCategoryVODeprecated k;

    public static final class a {
        public static x a(List r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "categoryDtoList");
            int r0 = WindowProductCategoryVODeprecated.k;
            WindowProductCategoryVODeprecated r3 = WindowProductCategoryVODeprecated.b.a(r1);
            if (r3 != null) goto L7;
            return null;
        L7:
            return new x(r3, r2);
        }
    }

    static {
    }

    public final void e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "categoryId");
        Iterator<WindowProductCategoryVODeprecated.a> r0 = this.k.j.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r0.next().a, r4) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 < 0) goto L15;
        this.j = r1;
        return;
    L15:
        return;
    L9:
        r1 = -1;
        goto L10
    }

    public x(WindowProductCategoryVODeprecated r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "categoryVO");
        super(2511);
        this.k = r2;
        if (r3 == null) goto L6;
        e(r3);
        return;
    }
}
