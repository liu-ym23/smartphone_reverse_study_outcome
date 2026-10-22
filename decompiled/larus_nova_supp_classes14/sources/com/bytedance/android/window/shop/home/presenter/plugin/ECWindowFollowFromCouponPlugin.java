package com.bytedance.android.window.shop.home.presenter.plugin;

import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.c;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowFollowFromCouponPlugin extends ECWindowJsbPlugin {
    public static final /* synthetic */ int d = 0;
    public final Function0<String> b;
    public final Function0<Unit> c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c("ecom.coupon.follow_state_changed", new ECWindowFollowFromCouponPlugin$createJsbActions$1(this)));
    }

    public ECWindowFollowFromCouponPlugin(Function0<String> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "getSecAuthorId");
        Intrinsics.checkNotNullParameter(r3, "receiver");
        this.b = r2;
        this.c = r3;
    }
}
