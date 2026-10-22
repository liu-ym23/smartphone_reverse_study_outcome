package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l0 extends ECShopBasePresenter {
    public View u;
    public View v;

    public static final class a<T> implements Observer {
        public final /* synthetic */ l0 a;

        public a(l0 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 != null) goto L6;
        L8:
            l0.q0(this.a, true);
            return;
        L6:
            if (r3.intValue() != 0) goto L8;
            l0.q0(this.a, false);
        }
    }

    public l0(Fragment r1) {
        super(r1);
    }

    public final void A(QModel r4) {
        View r5 = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131370877));
        if (r5 != null) goto L5;
        return;
    L5:
        this.u = r5;
        View r6 = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131370953));
        if (r6 != null) goto L8;
        return;
    L8:
        this.v = r6;
        T().getScrollState().a(W(), new a(this), false);
    }

    public static final void q0(l0 r1, boolean r2) {
        if (r2 == false) goto L20;
        Integer r3 = (Integer) r1.T().getSlideHintState().getValue();
        if (r3 != null) goto L7;
    L14:
        View r4 = r1.v;
        if (r4 == null) goto L17;
        ExtensionsKt.gone(r4);
    L17:
        View r5 = r1.u;
        if (r5 == null) goto L29;
        ExtensionsKt.visible(r5);
        return;
    L29:
        return;
    L7:
        if (r3.intValue() != 1) goto L14;
        View r6 = r1.v;
        if (r6 == null) goto L11;
        ExtensionsKt.visible(r6);
    L11:
        View r7 = r1.u;
        if (r7 == null) goto L27;
        ExtensionsKt.gone(r7);
        return;
    L27:
        return;
    L20:
        View r8 = r1.v;
        if (r8 == null) goto L23;
        ExtensionsKt.gone(r8);
    L23:
        View r9 = r1.u;
        if (r9 == null) goto L31;
        ExtensionsKt.visible(r9);
        return;
    }
}
