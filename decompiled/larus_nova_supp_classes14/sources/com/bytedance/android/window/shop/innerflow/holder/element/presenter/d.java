package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class d<T> extends QPresenter {
    public fo.b e;
    public final yp3.e<T> f;

    public abstract void D(T r1);

    public abstract void E();

    public final void C() {
        E();
        fo.b r0 = this.e;
        if (r0 == null) goto L5;
        r0.b.clear();
        r0.a.clear();
    L5:
        this.e = null;
    }

    public d(yp3.e<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "elementType");
        this.f = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A(QModel r2) {
        if (r2 == null) goto L6;
        vp3.b r3 = (vp3.b) r2;
        Object r0 = r3.b(this.f);
        this.e = r3.a;
        D(r0);
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.innerflow.entity.vo.ECWindowInnerFlowItemVO");
    }
}
