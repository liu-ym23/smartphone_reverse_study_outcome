package com.bytedance.android.shopping.mall.feed;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "callback", "Lkotlin/Function0;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class ECMallFeed$switchTab$scrollToCategory$1 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {
    final /* synthetic */ boolean $scrollToTop;
    final /* synthetic */ ECMallFeed this$0;

    public ECMallFeed$switchTab$scrollToCategory$1(ECMallFeed r1, boolean r2) {
        this.this$0 = r1;
        this.$scrollToTop = r2;
        super(1);
    }

    public final void invoke(final Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        if (Intrinsics.areEqual(ECMallFeed.a(this.this$0), "category_tab_section") == false) goto L5;
    L8:
        r9.invoke();
        return;
    L5:
        if (this.$scrollToTop == false) goto L8;
        ECMallFeed.h0(this.this$0, "category_tab_section", 10, true, 2.0f, null, 16);
        Observer<Boolean> r0 = new ECMallFeed$switchTab$scrollToCategory$1$observer$1(this, r9);
        ECMallFeed r10 = this.this$0;
        r10.C0.observe(r10.A1.s4(), r0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Function0) r1);
        return Unit.INSTANCE;
    }
}
