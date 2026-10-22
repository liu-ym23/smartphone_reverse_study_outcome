package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import android.view.View;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.DetailPromotion;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f196393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AwemeFeedProductCard f196394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f196395c;

    public a(View r100, AwemeFeedProductCard r101, Function1 r102) {
        this.f196393a = r100;
        this.f196394b = r101;
        this.f196395c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.awemeopen.apps.framework.utils.y.a(this.f196393a) == false) goto L5;
        return;
    L5:
        Integer r101 = this.f196394b.f196351h;
        if (r101 == null) goto L15;
        int r102 = r101.intValue();
        List<DetailPromotion> r103 = this.f196394b.f196350g;
        if (r103 == null) goto L16;
        DetailPromotion r104 = (DetailPromotion) CollectionsKt.getOrNull(r103, r102);
        if (r104 == null) goto L17;
        Function1 r105 = this.f196395c;
        if (r105 == null) goto L18;
        r105.invoke(r104);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }
}
