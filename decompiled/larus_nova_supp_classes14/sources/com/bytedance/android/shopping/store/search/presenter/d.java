package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;
import com.bytedance.android.ec.store.search.history.HistoryChip;
import com.bytedance.android.ec.store.search.history.HistoryView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ ShopSearchHistoryPresenter a;

    public d(ShopSearchHistoryPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        String r12 = (String) r11;
        if (r12 == null) goto L34;
        HistoryView r0 = this.a.f;
        HistoryChip r1 = null;
        if (r0 == null) goto L26;
        Intrinsics.checkNotNullParameter(r12, "keyword");
        int r2 = r0.getChildCount();
        if (r2 < 0) goto L26;
        int r3 = 0;
    L9:
        View r4 = r0.getChildAt(r3);
        if ((r4 instanceof HistoryChip.WrapCard) == true) goto L12;
        r4 = null;
    L12:
        HistoryChip.WrapCard r5 = (HistoryChip.WrapCard) r4;
        if (r5 == null) goto L15;
        HistoryChip r6 = r5.getChip();
    L16:
        if (r6 == null) goto L20;
        sj3.h r7 = r6.getHistory();
        if (r7 == null) goto L20;
        String r8 = r7.d;
    L22:
        if (Intrinsics.areEqual(r12, r8) == true) goto L23;
        if (r3 == r2) goto L26;
        r3 = r3 + 1;
        goto L9
    L23:
        r1 = r6;
    L20:
        r8 = null;
        goto L22
    L15:
        r6 = null;
    L26:
        if (r1 == null) goto L30;
        sj3.h r13 = r1.getHistory();
        if (r13 == null) goto L35;
        this.a.E().updateHistory(this.a.u().c.getContext().getApplicationContext(), new sj3.h(r13.a, r13.b, r13.c, r13.d, new Date()));
        return;
    L35:
        return;
    L30:
        this.a.E().insertHistory(this.a.u().c.getContext().getApplicationContext(), r12);
        return;
    }
}
