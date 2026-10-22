package com.bytedance.ee.bear.templates.center.list.base;

import androidx.lifecycle.Observer;
import dd5.w0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ BaseTemplateListView a;

    public m(BaseTemplateListView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        Integer r8 = (Integer) r7;
        BaseTemplateListView r0 = this.a;
        int r1 = w0.a;
        Intrinsics.checkNotNull(r8);
        int r9 = r8.intValue() - com.bytedance.ee.util.ui.n.d(16);
        int r2 = com.bytedance.ee.util.ui.n.d(16);
        int r3 = 2;
        int r4 = (r9 - (r2 * 2)) / 2;
        int r5 = com.bytedance.ee.util.ui.n.d(232);
        int r6 = com.bytedance.ee.util.ui.n.d(138);
        if (r4 < r6) goto L8;
    L5:
        if (r4 < r6) goto L10;
        if (r4 <= r5) goto L8;
    L10:
        r3 = r3 + 1;
        r4 = (r9 - (r2 * r3)) / r3;
    L8:
        r0.D(r3);
    }
}
