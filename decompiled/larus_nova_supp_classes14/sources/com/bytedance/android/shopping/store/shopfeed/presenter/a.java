package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.l0;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a extends QPresenter {
    public final Fragment e;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.shopfeed.presenter.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0016a implements View.OnClickListener {
        public final /* synthetic */ a a;

        public ViewOnClickListenerC0016a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Activity r2 = l0.b(this.a.u().c());
            if (r2 == null) goto L6;
            r2.finish();
            return;
        }
    }

    public Integer D() {
        return null;
    }

    public abstract int E();

    public abstract int F();

    public a(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.e = r2;
    }

    public void A(QModel r4) {
        ImageView r5 = (ImageView) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131386228));
        if (r5 == null) goto L9;
        Integer r0 = D();
        if (r0 == null) goto L7;
        r5.setColorFilter(r0.intValue());
    L7:
        d2.d(r5, E(), F(), 0, 0);
        r5.setOnClickListener(new ViewOnClickListenerC0016a(this));
        return;
    }
}
