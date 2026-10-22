package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECShopTopMarqueeUDSlidePresenter$setShowDurationDisposable$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ECShopTopMarqueeUDSlidePresenter this$0;

    public ECShopTopMarqueeUDSlidePresenter$setShowDurationDisposable$1(ECShopTopMarqueeUDSlidePresenter r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m156invoke() {
        ECShopTopMarqueeUDSlidePresenter r0 = this.this$0;
        int r1 = ECShopTopMarqueeUDSlidePresenter.I;
        r0.getClass();
        ECShopTopMarqueeUDSlidePresenter r2 = this.this$0;
        r2.E++;
        View r3 = r2.u;
        if (r3 == null) goto L6;
        ECShopTopMarqueeUDSlidePresenter.q0(r2, 0, -r3.getHeight(), this.this$0.H);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m156invoke();
        return Unit.INSTANCE;
    }
}
