package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "holder", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECMallFeedComponent$LynxCardLoadStatusChecker$check$1 extends Lambda implements Function1<BaseViewHolder, Unit> {
    final /* synthetic */ ECMallFeedComponent.i this$0;

    public ECMallFeedComponent$LynxCardLoadStatusChecker$check$1(ECMallFeedComponent.i r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(BaseViewHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        if ((r4 instanceof ECLynxCardHolder) == false) goto L15;
        com.bytedance.android.ec.hybrid.list.util.d.b r5 = ((ECLynxCardHolder) r4).p;
        if (r5.a != ECLynxCardHolder.LoadState.FAILED) goto L15;
        String r6 = r5.b;
        if (r6 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        this.this$0.a++;
        goto L15
    L9:
        if (StringsKt.isBlank(r6) == true) goto L12;
        r7 = false;
    L15:
        ECMallFeedComponent.i r8 = this.this$0;
        if (r8.a < 20) goto L19;
        ECMallFeed r9 = r8.b.k;
        ECMallFavoriteSectionHelper r0 = r9.V;
        ECHybridListEngine r10 = r9.J;
        Lazy r2 = ECMallFavoriteSectionHelper.I;
        r0.getClass();
        ECMallFavoriteSectionHelper.F(r10, 2, 0);
        this.this$0.b.B = false;
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((BaseViewHolder) r1);
        return Unit.INSTANCE;
    }
}
