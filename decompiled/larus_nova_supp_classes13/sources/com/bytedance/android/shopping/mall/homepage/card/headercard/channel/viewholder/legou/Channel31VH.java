package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.legou;

import android.view.View;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.BtmData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.Common31ChannelCardLayout;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.ItemAnimationController;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.ChannelBaseVH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.BtmPositionResult;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.facebook.drawee.view.SimpleDraweeView;
import ef3.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/legou/Channel31VH;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/ChannelBaseVH;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ItemAnimationController$a;", "Lef3/b;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Channel31VH extends ChannelBaseVH implements ItemAnimationController.a, b {
    public static final /* synthetic */ int m = 0;
    public final SimpleDraweeView h;
    public final Set<Integer> i;
    public final List<ItemAnimationController> j;
    public final Common31ChannelCardLayout k;
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a l;

    public static final class a {
    }

    static {
    }

    @Override // ef3.b
    public final void onRelease() {
        Iterator<T> r0 = this.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ItemAnimationController) r0.next()).a();
        goto L4
    }

    @Override // ef3.b
    public final void p() {
        this.i.clear();
    }

    @Override // ef3.b
    public final void N2(View r2) {
        Intrinsics.checkNotNullParameter(r2, "cardView");
        Intrinsics.checkNotNullParameter(r2, "cardView");
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.ChannelBaseVH
    public final void T3(ChannelVO r7) {
        super.T3(r7);
        if (r7 != null) goto L5;
        return;
    L5:
        String r0 = r7.getTagUrl();
        int r1 = 0;
        if (r0 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L15;
        d0.c(this.h, r0, this.e.k);
    L15:
        Iterator<T> r3 = this.k.getProductContentList().iterator();
        int r4 = 0;
    L17:
        if (r3.hasNext() == false) goto L23;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        ((gf3.a) r5).a(r7, this.e, r4);
        r4 = r6;
        goto L17
    L23:
        if (this.e.e == true) goto L31;
        Iterator r8 = ((ArrayList) this.j).iterator();
    L26:
        if (r8.hasNext() == false) goto L38;
        Object r9 = r8.next();
        int r10 = r1 + 1;
        if (r1 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        ((ItemAnimationController) r9).b(r7, r1);
        r1 = r10;
        goto L26
    L38:
        return;
    L31:
        return;
    L8:
        if (r0.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.ItemAnimationController.a
    public final void L1(int r9, int r10) {
        ChannelVO r1 = this.a;
        if (r1 != null) goto L5;
        return;
    L5:
        gf3.a r0 = (gf3.a) CollectionsKt.getOrNull(this.k.getProductContentList(), r9);
        if (r0 == null) goto L8;
        r0.a(r1, this.e, r10);
    L8:
        if (r9 != r10) goto L10;
        return;
    L10:
        if (this.i.contains(Integer.valueOf(r10)) == true) goto L25;
        this.i.add(Integer.valueOf(r10));
        Integer r11 = r1.getOriginChannelCardFIndex();
        if (r11 == null) goto L14;
        int r12 = r11.intValue();
    L15:
        int r4 = r12 - 1;
        if (r4 < 0) goto L21;
        BtmData r2 = this.e.j;
        String r13 = r1.getComponentId();
        if (r13 != null) goto L20;
        r13 = "0";
    L20:
        BtmPositionResult r3 = com.bytedance.android.shopping.mall.homepage.card.headercard.util.b.a(r2, false, r4, r10, r13, 1);
    L22:
        this.l.c(r1, r3, r10, this.e.h.A1.getGlobalProps(), null);
        return;
    L21:
        r3 = new BtmPositionResult(null, null, null, 7, null);
        goto L22
    L14:
        r12 = 0;
        goto L15
    }

    @Override // ef3.b
    public final void Q0(boolean r5, Boolean r6, boolean r7) {
        ChannelVO r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        Lazy r1 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.f.b, "Channel21VH: " + r5 + ", isCacheData:" + r6 + ", isFirstShow:" + r7 + ", channel id: " + r0.getComponentId());
        if (Intrinsics.areEqual(r6, Boolean.FALSE) == false) goto L27;
        if (r5 == false) goto L23;
        ChannelVO.Data r8 = r0.getData();
        if (r8 != null) goto L11;
        return;
    L11:
        if (r8.getAnimation() == null) goto L35;
        Iterator r9 = ((ArrayList) this.j).iterator();
    L15:
        if (r9.hasNext() == false) goto L36;
        ItemAnimationController r10 = (ItemAnimationController) r9.next();
        CoroutineScope r11 = r10.a;
        if (r11 == null) goto L21;
        if (CoroutineScopeKt.isActive(r11) == true) goto L15;
    L21:
        r10.c();
        goto L15
    L36:
        return;
    L35:
        return;
    L23:
        Iterator r12 = ((ArrayList) this.j).iterator();
    L25:
        if (r12.hasNext() == false) goto L37;
        ((ItemAnimationController) r12.next()).a();
        goto L25
    L37:
        return;
    }

    public Channel31VH(Common31ChannelCardLayout r3, com.bytedance.android.shopping.mall.homepage.card.headercard.a r4, com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r5, final Function0<Boolean> r6) {
        Intrinsics.checkNotNullParameter(r3, "channelCardView");
        Intrinsics.checkNotNullParameter(r4, "mallContext");
        Intrinsics.checkNotNullParameter(r5, "action");
        super(r3, r4, r5);
        this.k = r3;
        this.l = r5;
        this.h = r3.getTitleSdView();
        this.i = new LinkedHashSet();
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r3.getProductContentList().iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        Object r0 = (gf3.a) r8.next();
        if (r0 == null) goto L9;
        r7.add(new ItemAnimationController(this, (View) r0));
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L10:
        Unit r9 = Unit.INSTANCE;
        this.j = r7;
        Iterator<T> r10 = this.k.getProductContentList().iterator();
    L12:
        if (r10.hasNext() == false) goto L20;
        final gf3.a r11 = (gf3.a) r10.next();
        if ((r11 instanceof View) == true) goto L16;
        Object r1 = null;
    L17:
        View r2 = (View) r1;
        if (r2 == null) goto L12;
        r2.setOnClickListener(new Channel31VH$$special$$inlined$forEach$lambda$1(r11, this, r6));
        goto L12
    L16:
        r1 = r11;
        goto L17
    L20:
        this.k.setOnClickListener(new AnonymousClass2(this, r6));
        r4.a(this);
        V3(this.h);
    }
}
