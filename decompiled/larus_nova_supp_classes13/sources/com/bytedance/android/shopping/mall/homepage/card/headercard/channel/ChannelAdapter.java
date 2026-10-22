package com.bytedance.android.shopping.mall.homepage.card.headercard.channel;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.BtmData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelCID;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelCardLayoutType;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.ReportAction$onChannelAreaShow$1;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.ChannelCardView11;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.ChannelCardView11Live;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.ChannelCardView21;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.ChannelCardView21Live;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.ChannelCardView41;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.ChannelItemLive;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.ChannelItemSubSide;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.Common31ChannelCardLayout;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.ChannelCardViewNew41;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.Channel11LiveVH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.Channel11VH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.Channel21LiveVH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.Channel21VH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.Channel41VH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.ChannelBaseVH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.legou.Channel31LiveVH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.legou.Channel31VH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.legou.ChannelNew41VH;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import ef3.b;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import kjc.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/ChannelAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/ChannelBaseVH;", "Lef3/b;", "EmptyViewHolder", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelAdapter extends ListAdapter<ChannelVO, ChannelBaseVH> implements b {
    public List<ChannelVO> a;
    public RecyclerView b;
    public final a c;
    public final Function0<Boolean> d;
    public final ChannelAdapter$clickHighlightSub$1 e;
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.a f;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/ChannelAdapter$EmptyViewHolder;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/ChannelBaseVH;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EmptyViewHolder extends ChannelBaseVH {
        public EmptyViewHolder(View r2, com.bytedance.android.shopping.mall.homepage.card.headercard.a r3, a r4) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "mallContext");
            Intrinsics.checkNotNullParameter(r4, "impressAction");
            super(r2, r3, r4);
        }
    }

    @Override // ef3.b
    public final void p() {
    }

    public final int getItemCount() {
        List<ChannelVO> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @Override // ef3.b
    public final void onRelease() {
        ECEventCenter.f("click_bubble_highlight_event", this.e);
    }

    public ChannelAdapter(com.bytedance.android.shopping.mall.homepage.card.headercard.a r4) {
        Intrinsics.checkNotNullParameter(r4, "mallContext");
        super(new ChannelDiffCallback());
        this.f = r4;
        this.c = new a(r4);
        c r0 = new c();
        if (5 != kjc.a.a()) goto L6;
        kjc.b r1 = r0.a;
        r1.a = new ChannelAdapter$$special$$inlined$call$lambda$1(this);
        r0.b = true;
    L6:
        if (r0.b == true) goto L8;
        r0.a.a = null;
    L8:
        this.d = (Function0) r0.a.a;
        ChannelAdapter$clickHighlightSub$1 r2 = new ChannelAdapter$clickHighlightSub$1(this);
        this.e = r2;
        r4.a(this);
        ECEventCenter.e("click_bubble_highlight_event", r2, r4.i);
    }

    @Override // ef3.b
    public final void N2(View r2) {
        Intrinsics.checkNotNullParameter(r2, "cardView");
        Intrinsics.checkNotNullParameter(r2, "cardView");
    }

    public final int getItemViewType(int r6) {
        List<ChannelVO> r0 = this.a;
        JSONObject r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = Integer.valueOf(r0.size());
    L6:
        if (r2 == null) goto L78;
        if (r2.intValue() <= r6) goto L78;
        List<ChannelVO> r3 = this.a;
        if (r3 == null) goto L76;
        ChannelVO r7 = (ChannelVO) ListProtector.get(r3, r6);
        if (r7 == null) goto L76;
        ChannelVO.Layout r4 = r7.getLayout();
        if (r4 == null) goto L17;
        Integer r5 = r4.getHSpan();
    L18:
        boolean r8 = true;
        if (r5 != null) goto L22;
    L48:
        if (r5 != null) goto L51;
    L57:
        if (r5 != null) goto L60;
    L66:
        if (r5 == null) goto L78;
        if (r5.intValue() != 1) goto L78;
        if (Intrinsics.areEqual(r7.getComponentId(), ChannelCID.LIVE_SQUARE.getValue()) == false) goto L74;
        return ChannelCardLayoutType.SINGLE_PIT_LIVE_CARD.getValue();
    L74:
        return ChannelCardLayoutType.SINGLE_PIT_CARD.getValue();
    L60:
        if (r5.intValue() != 3) goto L66;
        if (Intrinsics.areEqual(r7.getComponentId(), ChannelCID.LIVE_SQUARE.getValue()) == false) goto L65;
        return ChannelCardLayoutType.THREE_PITS_CARD_LIVE.getValue();
    L65:
        return ChannelCardLayoutType.THREE_PITS_CARD.getValue();
    L51:
        if (r5.intValue() != 2) goto L57;
        if (Intrinsics.areEqual(r7.getComponentId(), ChannelCID.LIVE_SQUARE.getValue()) == false) goto L56;
        return ChannelCardLayoutType.DOUBLE_PITS_LIVE_CARD.getValue();
    L56:
        return ChannelCardLayoutType.DOUBLE_PITS_CARD.getValue();
    L22:
        if (r5.intValue() != 4) goto L48;
        Intrinsics.checkNotNullParameter(r7, "$this$isLegouStyle41");
        Object r9 = r7.getExtra();
        if (r9 == null) goto L33;
        if ((r9 instanceof String) == false) goto L30;
        JSONObject r10 = k.c((String) r9);
    L28:
        r1 = r10;
        goto L33
    L30:
        if ((r9 instanceof JSONObject) == false) goto L33;
        r10 = (JSONObject) r9;
    L33:
        if (r1 != null) goto L35;
    L37:
        boolean r11 = false;
    L38:
        if (r11 == false) goto L42;
        Lazy r12 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == false) goto L42;
    L43:
        if (r8 == false) goto L47;
        return ChannelCardLayoutType.BIG_CARD_NEW_41.getValue();
    L47:
        return ChannelCardLayoutType.BIG_CARD.getValue();
    L42:
        r8 = false;
        goto L43
    L35:
        if (r1.optBoolean("new_style", false) != true) goto L37;
        r11 = true;
        goto L38
    L17:
        r5 = null;
    L76:
        return ChannelCardLayoutType.NONE.getValue();
    L78:
        return ChannelCardLayoutType.NONE.getValue();
    L5:
        r2 = null;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        ChannelBaseVH r5 = (ChannelBaseVH) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        List<ChannelVO> r0 = this.a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r4 >= r0.size()) goto L9;
        r5.T3((ChannelVO) ListProtector.get(r0, r4));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        if (r12 != ChannelCardLayoutType.SINGLE_PIT_CARD.getValue()) goto L6;
        int r13 = Channel11VH.j;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r14 = this.f;
        a r0 = this.c;
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r14, "mallContext");
        Intrinsics.checkNotNullParameter(r0, "action");
        return new Channel11VH(new ChannelCardView11(r11.getContext(), null, 6, 0), r14, r0);
    L6:
        if (r12 != ChannelCardLayoutType.SINGLE_PIT_LIVE_CARD.getValue()) goto L9;
        int r15 = Channel11LiveVH.j;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r16 = this.f;
        a r1 = this.c;
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r16, "mallContext");
        Intrinsics.checkNotNullParameter(r1, "action");
        return new Channel11LiveVH(new ChannelCardView11Live(r11.getContext(), null, 6, 0), r16, r1);
    L9:
        if (r12 != ChannelCardLayoutType.DOUBLE_PITS_CARD.getValue()) goto L12;
        int r17 = Channel21VH.m;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r18 = this.f;
        a r2 = this.c;
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r18, "mallContext");
        Intrinsics.checkNotNullParameter(r2, "action");
        return new Channel21VH(new ChannelCardView21(r11.getContext(), null, 6, 0), r18, r2);
    L12:
        if (r12 != ChannelCardLayoutType.DOUBLE_PITS_LIVE_CARD.getValue()) goto L15;
        int r19 = Channel21LiveVH.k;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r110 = this.f;
        a r3 = this.c;
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r110, "mallContext");
        Intrinsics.checkNotNullParameter(r3, "action");
        return new Channel21LiveVH(new ChannelCardView21Live(r11.getContext(), null, 6, 0), r110, r3);
    L15:
        if (r12 != ChannelCardLayoutType.THREE_PITS_CARD.getValue()) goto L21;
        int r111 = Channel31VH.m;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r112 = this.f;
        a r4 = this.c;
        Function0<Boolean> r8 = this.d;
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r112, "mallContext");
        Intrinsics.checkNotNullParameter(r4, "action");
        ChannelItemSubSide[] r5 = new ChannelItemSubSide[3];
        int r6 = 0;
    L17:
        if (r6 >= 3) goto L19;
        r5[r6] = new ChannelItemSubSide(r11.getContext(), null, 6, 0);
        r6 = r6 + 1;
        goto L17
    L19:
        List r7 = ArraysKt.toList(r5);
        Common31ChannelCardLayout r9 = new Common31ChannelCardLayout(r11.getContext(), null, 6, 0);
        r9.a(r7);
        return new Channel31VH(r9, r112, r4, r8);
    L21:
        if (r12 != ChannelCardLayoutType.THREE_PITS_CARD_LIVE.getValue()) goto L27;
        int r113 = Channel31LiveVH.k;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r114 = this.f;
        a r10 = this.c;
        Function0<Boolean> r20 = this.d;
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r114, "mallContext");
        Intrinsics.checkNotNullParameter(r10, "action");
        ChannelItemLive[] r21 = new ChannelItemLive[3];
        int r22 = 0;
    L23:
        if (r22 >= 3) goto L25;
        r21[r22] = new ChannelItemLive(r11.getContext(), null, 6, 0);
        r22 = r22 + 1;
        goto L23
    L25:
        List r23 = ArraysKt.toList(r21);
        Common31ChannelCardLayout r24 = new Common31ChannelCardLayout(r11.getContext(), null, 6, 0);
        r24.a(r23);
        return new Channel31LiveVH(r24, r114, r10, r20);
    L27:
        if (r12 != ChannelCardLayoutType.BIG_CARD.getValue()) goto L30;
        int r115 = Channel41VH.m;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r116 = this.f;
        a r25 = this.c;
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r116, "mallContext");
        Intrinsics.checkNotNullParameter(r25, "action");
        return new Channel41VH(new ChannelCardView41(r11.getContext(), null, 6, 0), r116, r25);
    L30:
        if (r12 != ChannelCardLayoutType.BIG_CARD_NEW_41.getValue()) goto L33;
        int r117 = ChannelNew41VH.l;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r118 = this.f;
        a r26 = this.c;
        Function0<Boolean> r27 = this.d;
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r118, "mallContext");
        Intrinsics.checkNotNullParameter(r26, "action");
        return new ChannelNew41VH(new ChannelCardViewNew41(r11.getContext(), null, 6, 0), r118, r26, r27);
    L33:
        return new EmptyViewHolder(new View(r11.getContext()), this.f, this.c);
    }

    @Override // ef3.b
    public final void Q0(boolean r3, Boolean r4, boolean r5) {
        if (r3 == true) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r4, Boolean.FALSE) == false) goto L9;
        if (r5 == false) goto L10;
        final Map<String, Object> r6 = this.f.h.A1.getGlobalProps();
        final BtmData r7 = this.f.j;
        final a r8 = this.c;
        final List<ChannelVO> r0 = this.a;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r6, "globalProps");
        Single.fromCallable(new ReportAction$onChannelAreaShow$1(r8, r0, r7, r6)).subscribeOn(Schedulers.single()).subscribe();
        return;
    L10:
        return;
    }
}
