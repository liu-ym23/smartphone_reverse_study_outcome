package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q0<T> implements Observer {
    public final /* synthetic */ ECWindowDialogStyledBackgroundPresenter a;
    public final /* synthetic */ int[][] b;

    public q0(ECWindowDialogStyledBackgroundPresenter r1, int[][] r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r3) {
        uq3.o r4 = ((uq3.a) r3).c;
        if (r4 != null) goto L5;
    L9:
        View r5 = this.a.w().b(2131370857).f();
        int[] r0 = (int[]) ArraysKt.lastOrNull(this.b);
        if (r0 == null) goto L14;
        Integer r1 = ArraysKt.lastOrNull(r0);
        if (r1 == null) goto L14;
        int r2 = r1.intValue();
    L15:
        r5.setBackgroundColor(r2);
        Unit r6 = Unit.INSTANCE;
        return;
    L14:
        r2 = -1;
        goto L15
    L5:
        if (r4.g == null) goto L9;
        Integer r7 = r4.h;
        if (r7 == null) goto L17;
        int r8 = r7.intValue();
        this.a.w().b(2131370857).f().setBackgroundColor(r8);
        return;
    }
}
