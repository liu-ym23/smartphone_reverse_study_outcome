package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w1<T> implements Observer {
    public final /* synthetic */ ECWindowRootPresenter.c a;

    public w1(ECWindowRootPresenter.c r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Pair r5 = (Pair) r4;
        ECWindowRootPresenter r6 = this.a.a;
        int r0 = ECWindowRootPresenter.q;
        View r7 = r6.w().b(2131370922).f();
        if (this.a.a.F() == false) goto L5;
        int r1 = 0;
    L6:
        r7.setVisibility(r1);
        MutableLiveData<Float> r8 = this.a.a.O().getSubCollapseProgress();
        ECWindowRootPresenter r2 = this.a.a;
        r8.setValue(Float.valueOf(r2.Y(r2.w().b(2131370890).f().getMeasuredHeight())));
        return;
    L5:
        r1 = 4;
        goto L6
    }
}
