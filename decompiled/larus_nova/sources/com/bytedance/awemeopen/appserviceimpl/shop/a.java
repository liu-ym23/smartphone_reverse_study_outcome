package com.bytedance.awemeopen.appserviceimpl.shop;

import com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card.d;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements j34.a {
    public a() {
    }

    @Override // n24.a
    public final void f() {
    }

    @Override // k24.a
    public final void x0() {
    }

    @Override // j34.a
    public final void m(final String r110, final String r111, final String r112, final String r113, final String r114, final String r115, final String r116, final d r117) {
        Intrinsics.checkNotNullParameter(r110, "awemeId");
        Intrinsics.checkNotNullParameter(r111, "accessToken");
        Intrinsics.checkNotNullParameter(r112, "openId");
        Intrinsics.checkNotNullParameter(r113, "authorOpenId");
        Intrinsics.checkNotNullParameter(r114, "hostAppId");
        Intrinsics.checkNotNullParameter(r115, "ecomSDKVersion");
        Intrinsics.checkNotNullParameter(r116, "enterFrom");
        Intrinsics.checkNotNullParameter(r117, "callback");
        AoPool.a(new ShopService$getDetailPromotionList$1(r110, r111, r112, r113, r114, r115, r116, r117));
    }
}
