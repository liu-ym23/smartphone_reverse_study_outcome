package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.mall.feed.help.ECMallGulRefresh;
import com.bytedance.android.shopping.mall.homepage.tools.FavRefreshParams;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECMallFeed$gulRefresh$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ FavRefreshParams $favRefreshParams;
    final /* synthetic */ ECMallFeed this$0;

    public ECMallFeed$gulRefresh$1(ECMallFeed r1, FavRefreshParams r2) {
        this.this$0 = r1;
        this.$favRefreshParams = r2;
        super(0);
    }

    public final int invoke() {
        ECMallFeed r0 = this.this$0;
        FavRefreshParams r1 = this.$favRefreshParams;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r0.T0 == false) goto L13;
        Lazy r3 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.e.b, "disable refresh gyl, can not refresh");
        return 1001;
    L13:
        if (r0.P == false) goto L15;
    L31:
        Lazy r4 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.e.b, "has refresh or loadMore, can not refresh");
        return 1004;
    L15:
        if (r0.A1.JQ() == true) goto L31;
        if (r2 == false) goto L24;
        Integer r5 = r0.R;
        if (r5 == null) goto L24;
        if (r5.intValue() == 0) goto L24;
        Lazy r6 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.e.b, "cur_tabId_wrong, can not refresh");
        return 1005;
    L24:
        if (r0.S0 == true) goto L26;
        Lazy r7 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.e.b, "page not visible, can not refresh");
        r0.U0 = true;
        return 1007;
    L26:
        ECMallGulRefresh r8 = r0.w();
        if (r8 != null) goto L29;
    L30:
        Lazy r9 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.e.b, "has scroll list, can not refresh");
        return 1006;
    L29:
        if (r8.b != r0.Q) goto L30;
        return 1;
    L5:
        if (r1.c != true) goto L8;
        r2 = false;
        goto L10
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1004invoke() {
        return Integer.valueOf(invoke());
    }
}
