package com.bytedance.android.shopping.mall.feed;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.mall.homepage.card.video.NativeVideoCard;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeed$NativeCardInjector$inject$1 extends com.bytedance.android.ec.hybrid.list.ability.p0 {
    public final /* synthetic */ ECMallFeed.n b;
    public final /* synthetic */ com.bytedance.android.shopping.api.mall.idl.c c;

    public final BaseViewHolder n(ViewGroup r19) {
        Intrinsics.checkNotNullParameter(r19, "parent");
        ECMallFeed.n r2 = this.b;
        r19.getContext();
        Map<Integer, List<View>> r3 = com.bytedance.android.shopping.mall.homepage.opt.i.a;
        Pair r1 = ECMallFeed.n.a(r2, 2131564683, r19, "video");
        View r4 = (View) r1.component1();
        boolean r13 = ((Boolean) r1.component2()).booleanValue();
        ECMallFeed.e r5 = this.b.a.B1;
        boolean r6 = r5.l;
        Integer r7 = r5.s;
        com.bytedance.android.shopping.mall.homepage.card.live.e r8 = new com.bytedance.android.shopping.mall.homepage.card.live.e("ec_na_mall", "ec_na_mall_video_cover", "ec_na_mall_video_avatar", "ec_na_mall_video_product", 112);
        ECMallFeed r9 = this.b.a;
        g93.a r10 = r9.i0;
        com.bytedance.android.ec.hybrid.card.api.f r11 = r9.E1;
        ECMallFeed.e r12 = r9.B1;
        String r14 = r12.c;
        com.bytedance.android.ec.hybrid.list.e r15 = r12.z;
        if (r15 == null) goto L5;
        String r16 = r15.a;
    L6:
        String r17 = r16;
        Function0<Unit> r18 = new ECMallFeed$NativeCardInjector$inject$1$createViewHolder$1(this);
        ECMallFeed r20 = this.b.a;
        MutableLiveData<Float> r110 = r20.X0;
        LifecycleOwner r111 = r20.A1.s4();
        com.bytedance.android.shopping.api.mall.idl.c r21 = this.c;
        Integer r22 = this.b.a.D1;
        NativeVideoCard r23 = new NativeVideoCard(r4, r6, r7, r8, r10, r11, r14, r17, r18, r13, r110, r111, r21, new ECMallFeed$NativeCardInjector$inject$1$createViewHolder$2(this));
        String r24 = this.b.a.B();
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r23.r = r24;
        return r23;
    L5:
        r16 = null;
        goto L6
    }

    public ECMallFeed$NativeCardInjector$inject$1(ECMallFeed.n r1, com.bytedance.android.shopping.api.mall.idl.c r2, Class r3) {
        this.b = r1;
        this.c = r2;
        super(r3);
    }
}
