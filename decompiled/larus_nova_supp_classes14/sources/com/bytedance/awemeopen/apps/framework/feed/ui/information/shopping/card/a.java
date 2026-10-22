package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import android.view.View;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.DetailPromotion;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ AwemeFeedProductCard b;
    public final /* synthetic */ Function1 c;

    public a(View r1, AwemeFeedProductCard r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (com.bytedance.awemeopen.apps.framework.utils.y.a(this.a) == false) goto L5;
        return;
    L5:
        Integer r3 = this.b.h;
        if (r3 == null) goto L15;
        int r4 = r3.intValue();
        List<DetailPromotion> r0 = this.b.g;
        if (r0 == null) goto L16;
        DetailPromotion r5 = (DetailPromotion) CollectionsKt.getOrNull(r0, r4);
        if (r5 == null) goto L17;
        Function1 r1 = this.c;
        if (r1 == null) goto L18;
        r1.invoke(r5);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }
}
