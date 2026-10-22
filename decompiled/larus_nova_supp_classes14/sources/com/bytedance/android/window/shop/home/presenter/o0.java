package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o0<T> implements Observer {
    public final /* synthetic */ ECWindowDialogStyledBackgroundPresenter a;
    public final /* synthetic */ boolean b;

    public o0(ECWindowDialogStyledBackgroundPresenter r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r4) {
        Integer r5 = (Integer) r4;
        ViewGroup.LayoutParams r0 = this.a.f0().getLayoutParams();
        if (r0 != null) goto L5;
        r0 = new ViewGroup.LayoutParams(-1, r5.intValue());
    L5:
        r0.height = r5.intValue();
        if (this.b == false) goto L8;
        View r1 = this.a.w().b(2131370845).f();
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        r2.height = r5.intValue();
        Unit r6 = Unit.INSTANCE;
        r1.setLayoutParams(r2);
    L8:
        this.a.f0().setLayoutParams(r0);
    }
}
