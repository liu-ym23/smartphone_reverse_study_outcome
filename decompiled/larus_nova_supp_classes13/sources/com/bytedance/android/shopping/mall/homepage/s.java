package com.bytedance.android.shopping.mall.homepage;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.feed.jsb.ECMallDrawToolItemToCenter;
import com.bytedance.android.shopping.mall.feed.jsb.EcMallShadowBubbleShow;
import com.bytedance.android.shopping.mall.feed.jsb.l0;
import com.bytedance.android.shopping.mall.feed.jsb.m0;
import com.bytedance.android.shopping.mall.homepage.jsb.ECMallGetMallTabFrameJSB;
import com.bytedance.android.shopping.mall.homepage.jsb.ECMallGetTabFrameJSB;
import com.bytedance.android.shopping.mall.homepage.jsb.ECMallMountLottieJsb;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s {
    public final qf3.d a;
    public final List<IDLXBridgeMethod> b;

    public s(Context r4, View r5, ECMallFeed r6, ck.a r7, ECMallFragment$pageStateHelper$1 r8) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "mallFeed");
        qf3.d r0 = new qf3.d(r4, r6);
        this.a = r0;
        List<IDLXBridgeMethod> r9 = CollectionsKt.mutableListOf(new IDLXBridgeMethod[]{new com.bytedance.android.ec.hybrid.card.bridge.b(), new com.bytedance.android.shopping.mall.homepage.jsb.m(r0, r5), new com.bytedance.android.shopping.mall.homepage.jsb.f(r0), new com.bytedance.android.shopping.mall.homepage.jsb.o(r0), new ECMallMountLottieJsb(r0, r5), new com.bytedance.android.shopping.mall.feed.jsb.k(r0), new com.bytedance.android.shopping.mall.feed.jsb.j(r0), new l0(r0)});
        r9.add(new com.bytedance.android.shopping.mall.homepage.jsb.b(r0));
        r9.add(new com.bytedance.android.shopping.mall.homepage.jsb.a(r0));
        r9.add(new com.bytedance.android.shopping.mall.homepage.jsb.c(r0));
        if (r7 == null) goto L5;
        r9.add(new dk.b(r7, r8));
        r9.add(new dk.a(r7, null));
    L5:
        r9.add(new com.bytedance.android.shopping.mall.homepage.jsb.l(r0));
        r9.add(new com.bytedance.android.shopping.mall.homepage.jsb.s(r0));
        r9.add(new com.bytedance.android.shopping.mall.homepage.jsb.n(r0));
        r9.add(new com.bytedance.android.shopping.mall.homepage.jsb.j(r0));
        r9.add(new com.bytedance.android.shopping.mall.homepage.jsb.e(r0));
        r9.add(new com.bytedance.android.shopping.mall.homepage.jsb.k(r0));
        r9.add(new ECMallGetMallTabFrameJSB(r0));
        r9.add(new ECMallGetTabFrameJSB(r0));
        r9.add(new com.bytedance.android.shopping.mall.homepage.jsb.g(r0));
        r9.add(new ECMallDrawToolItemToCenter(r0));
        r9.add(new com.bytedance.android.shopping.mall.homepage.jsb.h(r0));
        r9.add(new com.bytedance.android.shopping.mall.homepage.jsb.i(r0));
        r9.add(new m0(r0));
        r9.add(new com.bytedance.android.shopping.mall.homepage.jsb.d(r0));
        kjc.c r10 = new kjc.c();
        if (5 != kjc.a.a()) goto L9;
        kjc.b r11 = r10.a;
        r9.add(new EcMallShadowBubbleShow(r0));
        r11.a = Unit.INSTANCE;
        r10.b = true;
    L9:
        if (r10.b == true) goto L11;
        r10.a.a = Unit.INSTANCE;
    L11:
        Object r12 = r10.a.a;
        Unit r13 = Unit.INSTANCE;
        this.b = r9;
    }
}
