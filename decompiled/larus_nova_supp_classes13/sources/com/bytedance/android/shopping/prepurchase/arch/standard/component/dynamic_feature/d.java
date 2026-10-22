package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ DynamicViewWidgetOpt c;

    @Override // java.lang.Runnable
    public final void run() {
        List<? extends com.bytedance.android.ecom.arch.slice.g> r0 = this.c.d;
        if (r0 == null) goto L13;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L19;
        com.bytedance.android.ecom.arch.slice.g r2 = (com.bytedance.android.ecom.arch.slice.g) r1.next();
        IAction r3 = r2.getShowAction();
        if (r3 == null) goto L6;
        e r4 = this.c.a;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("dependency");
    L12:
        r4.d(r2, r3, this.c.b);
        goto L6
    L19:
        return;
    }

    public d(DynamicViewWidgetOpt r1) {
        this.c = r1;
        super("delay_report_show_event");
    }
}
