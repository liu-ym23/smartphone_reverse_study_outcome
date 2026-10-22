package com.bytedance.android.window.shop.search.presenter;

import android.view.View;
import com.bytedance.android.ec.window.base.search.history.ECWindowHistoryChip;
import com.bytedance.android.ec.window.base.search.history.ECWindowHistoryView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ WindowSearchHistoryPresenter a;

    public d(WindowSearchHistoryPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        String r12 = (String) r11;
        if (r12 == null) goto L34;
        ECWindowHistoryView r0 = this.a.g;
        ECWindowHistoryChip r1 = null;
        if (r0 == null) goto L26;
        Intrinsics.checkNotNullParameter(r12, "keyword");
        int r2 = r0.getChildCount();
        if (r2 < 0) goto L26;
        int r3 = 0;
    L9:
        View r4 = r0.getChildAt(r3);
        if ((r4 instanceof ECWindowHistoryChip.WrapCard) == true) goto L12;
        r4 = null;
    L12:
        ECWindowHistoryChip.WrapCard r5 = (ECWindowHistoryChip.WrapCard) r4;
        if (r5 == null) goto L15;
        ECWindowHistoryChip r6 = r5.getChip();
    L16:
        if (r6 == null) goto L20;
        cp.a r7 = r6.getHistory();
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
        cp.a r13 = r1.getHistory();
        if (r13 == null) goto L35;
        WindowSearchHistoryPresenter.E(this.a).updateHistory(this.a.u().c.getContext().getApplicationContext(), new cp.a(r13.a, r13.b, r13.c, r13.d, new Date()));
        return;
    L35:
        return;
    L30:
        WindowSearchHistoryPresenter.E(this.a).insertHistory(this.a.u().c.getContext().getApplicationContext(), r12);
        return;
    }
}
