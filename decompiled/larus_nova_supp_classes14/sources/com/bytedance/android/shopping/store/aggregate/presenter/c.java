package com.bytedance.android.shopping.store.aggregate.presenter;

import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ ShopAggregatePageGroupPresenter a;

    public c(ShopAggregatePageGroupPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        ECUrlModel r1 = ((uj3.e) r9).a;
        if (r1 == null) goto L6;
        SimpleDraweeView r0 = this.a.w().b(2131362314).f();
        r0.setVisibility(0);
        h0.d(r0, r1, null, null, null, null, null, 120);
        ImageView r10 = (ImageView) this.a.w().b(2131392468).f();
        r10.setColorFilter(-1);
        r10.setAlpha(0.75f);
        ((TextView) this.a.w().b(2131391172).f()).setTextColor(-1);
        ((ImageView) this.a.w().b(2131387435).f()).setColorFilter(-1);
        return;
    }
}
