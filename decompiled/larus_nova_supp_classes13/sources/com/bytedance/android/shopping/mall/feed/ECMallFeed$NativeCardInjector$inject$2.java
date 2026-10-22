package com.bytedance.android.shopping.mall.feed;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.mall.homepage.card.live.NativeLiveCard;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeed$NativeCardInjector$inject$2 extends com.bytedance.android.ec.hybrid.list.ability.p0 {
    public final /* synthetic */ ECMallFeed.n b;
    public final /* synthetic */ com.bytedance.android.shopping.api.mall.idl.c c;

    public final BaseViewHolder n(ViewGroup r27) {
        Intrinsics.checkNotNullParameter(r27, "parent");
        ECMallFeed.n r2 = this.b;
        r27.getContext();
        Map<Integer, List<View>> r3 = com.bytedance.android.shopping.mall.homepage.opt.i.a;
        Pair r1 = ECMallFeed.n.a(r2, 2131564681, r27, "live");
        View r4 = (View) r1.component1();
        boolean r17 = ((Boolean) r1.component2()).booleanValue();
        ECMallFeed r5 = this.b.a;
        ECMallFeed.e r6 = r5.B1;
        boolean r7 = r6.m;
        Integer r8 = r6.s;
        boolean r9 = r6.i;
        Fragment r10 = r5.A1.M();
        Fragment r11 = this.b.a.A1.M();
        String r12 = null;
        if (r11 == null) goto L5;
        View r13 = r11.getView();
    L6:
        ECMallFeed r14 = this.b.a;
        int r15 = r14.B1.n;
        com.bytedance.android.shopping.mall.homepage.card.live.n r16 = r14.h0;
        com.bytedance.android.shopping.mall.homepage.card.live.e r18 = new com.bytedance.android.shopping.mall.homepage.card.live.e("ec_na_mall", "ec_na_mall_live_cover", "ec_na_mall_live_avatar", "ec_na_mall_live_product", "ec_na_mall_live_redpack", "ec_na_mall_live_simple_product", "ec_na_mall_live_blur_cover");
        ECMallFeed r19 = this.b.a;
        g93.a r110 = r19.i0;
        com.bytedance.android.ec.hybrid.card.api.f r111 = r19.E1;
        ECMallFeed.e r112 = r19.B1;
        String r113 = r112.c;
        com.bytedance.android.ec.hybrid.list.e r114 = r112.z;
        if (r114 == null) goto L9;
        r12 = r114.a;
    L9:
        String r22 = r12;
        MutableLiveData<Float> r20 = r19.X0;
        LifecycleOwner r115 = r19.A1.s4();
        com.bytedance.android.shopping.api.mall.idl.c r21 = this.c;
        Integer r23 = this.b.a.D1;
        NativeLiveCard r24 = new NativeLiveCard(r4, r7, r8, r9, r10, r13, r15, r16, r18, r110, r111, r113, r22, r17, r20, r115, r21, new ECMallFeed$NativeCardInjector$inject$2$createViewHolder$1(this));
        String r25 = this.b.a.B();
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r24.r = r25;
        return r24;
    L5:
        r13 = null;
        goto L6
    }

    public ECMallFeed$NativeCardInjector$inject$2(ECMallFeed.n r1, com.bytedance.android.shopping.api.mall.idl.c r2, Class r3) {
        this.b = r1;
        this.c = r2;
        super(r3);
    }
}
