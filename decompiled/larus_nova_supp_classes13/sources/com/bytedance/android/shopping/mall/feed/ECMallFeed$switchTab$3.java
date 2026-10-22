package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class ECMallFeed$switchTab$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $action;
    final /* synthetic */ Integer $fromTabId;
    final /* synthetic */ List $gylViews;
    final /* synthetic */ Function1 $scrollToCategory;
    final /* synthetic */ long $startTime;
    final /* synthetic */ com.bytedance.android.shopping.api.mall.common.tools.d $toTabItem;
    final /* synthetic */ ECMallFeed this$0;

    public ECMallFeed$switchTab$3(ECMallFeed r1, Integer r2, Function1 r3, long r4, List r6, com.bytedance.android.shopping.api.mall.common.tools.d r7, String r8) {
        this.this$0 = r1;
        this.$fromTabId = r2;
        this.$scrollToCategory = r3;
        this.$startTime = r4;
        this.$gylViews = r6;
        this.$toTabItem = r7;
        this.$action = r8;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1051invoke() {
        ECMallFeed r0 = this.this$0;
        ECMallFavoriteSectionHelper r1 = r0.V;
        ECHybridListEngine r2 = r0.J;
        r1.getClass();
        ECMallFavoriteSectionHelper.F(r2, 1, 1);
        if ((!Intrinsics.areEqual(this.$fromTabId, this.this$0.R)) == false) goto L5;
        this.this$0.M();
    L5:
        this.$scrollToCategory.invoke(new AnonymousClass1(this));
        ECHybridListEngine r3 = this.this$0.J;
        if (r3 == null) goto L10;
        r3.b.setOnTouchListener(null);
        this.this$0.R(this.$toTabItem, this.$action);
        return;
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1051invoke();
        return Unit.INSTANCE;
    }
}
