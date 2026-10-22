package com.bytedance.android.window.shop.widget;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends j {
    public final Function1<Integer, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "removeNotifier");
        this.a = r2;
    }

    @Override // com.bytedance.android.window.shop.widget.j
    public final void a(com.bytedance.android.window.shop.repository.tab.entity.f r2, List r3, WindowTypeSeparatedAdapter r4) {
        Intrinsics.checkNotNullParameter(r2, "vo");
        Intrinsics.checkNotNullParameter(r3, "list");
        Intrinsics.checkNotNullParameter(r4, "adapter");
        ArrayList r5 = (ArrayList) r3;
        Integer r6 = Integer.valueOf(r5.indexOf(r2));
        if (r6.intValue() < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r6 = null;
    L9:
        if (r6 == null) goto L12;
        int r7 = r6.intValue();
        ListProtector.remove(r5, r7);
        r4.notifyItemRemoved(r7);
        this.a.invoke(Integer.valueOf(r7));
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
