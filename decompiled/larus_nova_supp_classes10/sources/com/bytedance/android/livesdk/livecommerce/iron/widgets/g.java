package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.event.a1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ IronPromotionListTopCategoryWidget a;
    public final /* synthetic */ IronPromotionListTopCategoryWidget$createExpandView$view$1 b;

    public g(IronPromotionListTopCategoryWidget r1, IronPromotionListTopCategoryWidget$createExpandView$view$1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        View r4 = this.b.getTagView();
        if (r4 != null) goto L5;
    L10:
        IronPromotionListTopCategoryWidget r5 = this.a;
        if (r5.k == false) goto L13;
        r5.b();
    L14:
        new a1(false, this.a.m).k();
        return;
    L13:
        r5.a();
        goto L14
    L5:
        if (r4.isEnabled() == true) goto L10;
        Function1<? super View, Unit> r6 = this.a.n;
        if (r6 == null) goto L16;
        Unit r7 = (Unit) r6.invoke(this.b);
        return;
    }
}
