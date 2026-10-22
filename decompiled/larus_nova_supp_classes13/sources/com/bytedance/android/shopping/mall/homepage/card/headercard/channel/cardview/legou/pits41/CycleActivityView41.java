package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCard;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECProductStruct;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.PriceStruct;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.BtmPositionResult;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.UtilsKt;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.e;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.f;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/legou/pits41/CycleActivityView41;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/util/BtmPositionResult;", "getBtmInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CycleActivityView41 extends ConstraintLayout {
    public static final Typeface k = null;
    public static final List<String> l = null;
    public final float a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final LinearLayout f;
    public long g;
    public com.bytedance.android.shopping.mall.homepage.card.headercard.a h;
    public com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a i;
    public com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.b j;

    public static final class a extends ViewOutlineProvider {
        public final /* synthetic */ CycleActivityView41 a;

        public a(CycleActivityView41 r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r7, Outline r8) {
            if (r7 != null) goto L4;
            return;
        L4:
            if (r8 == null) goto L7;
            r8.setRoundRect(0, 0, r7.getWidth(), r7.getHeight(), this.a.a);
            return;
        }
    }

    public static final class b {
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CycleActivityView41 a;
        public final /* synthetic */ ChannelVO b;

        public c(CycleActivityView41 r1, ChannelVO r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            this.a.T5(this.b, -1, System.currentTimeMillis());
            this.a.U5(this.b, -1);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ CycleActivityView41 b;
        public final /* synthetic */ ChannelVO c;

        public d(int r1, CycleActivityView41 r2, ChannelVO r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            this.b.T5(this.c, this.a, System.currentTimeMillis());
            this.b.U5(this.c, this.a);
        }
    }

    public CycleActivityView41(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CycleActivityView41(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public static Map S5() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("activity_name", "explosive_subsidy"), TuplesKt.to("module_id", "cycle_activity"), TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI"), TuplesKt.to("module_name", "万人团"), TuplesKt.to("product_type", "wanrentuan_card")});
    }

    static {
        com.bytedance.android.ec.hybrid.a.c();
        k = null;
        l = CollectionsKt.listOf(new String[]{"距结束", "已结束"});
    }

    private final BtmPositionResult getBtmInfo() {
        return new BtmPositionResult("c209853.d85698", null, null, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(ChannelVO r23, com.bytedance.android.shopping.mall.homepage.card.headercard.a r24) {
        Intrinsics.checkNotNullParameter(r23, "cycleActivityItem");
        Intrinsics.checkNotNullParameter(r24, "context");
        this.h = r24;
        this.i = new com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a(r24);
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        Map<String, String> r1 = UtilsKt.a(r23, true, -1);
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r2 = this.h;
        if (r2 == null) goto L38;
        BtmPositionResult r3 = getBtmInfo();
        if (r3 == null) goto L13;
        String r4 = r3.getBtm();
        if (r4 == null) goto L13;
    L14:
        LinkedHashMap r5 = new LinkedHashMap();
        if (this.i == null) goto L27;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r6 = this.h;
        if (r6 == null) goto L24;
        ECMallFeed r7 = r6.h;
        if (r7 == null) goto L24;
        ECMallFeed.f r8 = r7.A1;
        if (r8 == null) goto L24;
        Map<String, Object> r9 = r8.getGlobalProps();
        if (r9 == null) goto L24;
    L25:
        Map r10 = com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a.a(r23, r9);
        if (r10 == null) goto L27;
    L28:
        r5.putAll(r10);
        r5.putAll(r1);
        r5.putAll(S5());
        Unit r11 = Unit.INSTANCE;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r12 = this.h;
        if (r12 == null) goto L36;
        ECMallFeed r13 = r12.h;
        if (r13 == null) goto L36;
        ECMallFeed.f r14 = r13.A1;
        if (r14 == null) goto L36;
        Map<String, Object> r15 = r14.getGlobalProps();
        if (r15 == null) goto L36;
    L37:
        e.b(r2, "show_daogou_entrance", r4, r5, r15);
    L36:
        r15 = MapsKt.emptyMap();
    L24:
        r9 = MapsKt.emptyMap();
    L27:
        r10 = MapsKt.emptyMap();
    L13:
        r4 = "";
    L38:
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r16 = this.h;
        if (r16 == null) goto L46;
        BtmPositionResult r17 = getBtmInfo();
        if (r17 == null) goto L44;
        String r18 = r17.getBtm();
        if (r18 == null) goto L44;
    L45:
        e.b(r16, "marketing_show", r18, S5(), r16.h.A1.getGlobalProps());
    L44:
        r18 = "";
    L46:
        SimpleDraweeView r19 = findViewById(2131368512);
        int r20 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r19.setLayoutParams(new ConstraintLayout.LayoutParams(-1, com.bytedance.android.ec.hybrid.list.util.c.c(28, getContext(), true)));
        String r21 = r23.getTagUrl();
        if (r21 != null) goto L49;
        r21 = "";
    L49:
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r22 = this.h;
        if (r22 == null) goto L53;
        String r25 = r22.k;
        if (r25 == null) goto L53;
    L54:
        d0.c(r19, r21, r25);
        r19.setOnClickListener(new c(this, r23));
        SimpleDraweeView r26 = findViewById(2131368498);
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r27 = this.h;
        if (r27 == null) goto L58;
        String r28 = r27.k;
        if (r28 == null) goto L58;
    L59:
        d0.c(r26, "https://p3-piu.byteimg.com/tos-cn-i-8jisjyls3a/5d7fb9c7d56a4c12a5236693b084a4ef~tplv-8jisjyls3a-image.image", r28);
        Iterator r29 = CollectionsKt.listOf(new Integer[]{2131368503, 2131368501, 2131368499, 2131368502, 2131368500, 2131368505}).iterator();
    L61:
        if (r29.hasNext() == false) goto L63;
        AppCompatTextView r30 = findViewById(((Number) r29.next()).intValue());
        r30.setTypeface(k);
        int r31 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r30.setTextSize(0, com.bytedance.android.ec.hybrid.list.util.c.c(11, getContext(), true));
        t93.a.d(r30);
        goto L61
    L63:
        SimpleDraweeView r32 = findViewById(2131368504);
        int r33 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r32.setLayoutParams(new LinearLayout.LayoutParams(com.bytedance.android.ec.hybrid.list.util.c.c(10, getContext(), true), com.bytedance.android.ec.hybrid.list.util.c.c(10, getContext(), true)));
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r34 = this.h;
        if (r34 == null) goto L67;
        String r35 = r34.k;
        if (r35 == null) goto L67;
    L68:
        d0.c(r32, "https://lf3-static.bytednsdoc.com/obj/eden-cn/sshfteh7nuhpebps/duliduan/wanrentuan_right_jiantou.png", r35);
        Long r36 = r23.getLeftTime();
        if (r36 == null) goto L71;
        long r37 = r36.longValue();
    L72:
        this.g = r37;
        long r38 = 1000;
        com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.b r110 = new com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.b(this, this.g * r38, r38);
        this.j = r110;
        r110.start();
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(-1, -1);
        r111.weight = 1.0f;
        ChannelVO.Data r39 = r23.getData();
        if (r39 == null) goto L117;
        List<ECCommonCard> r40 = r39.getItems();
        if (r40 == null) goto L122;
        Iterator<T> r41 = r40.iterator();
        int r42 = 0;
    L78:
        if (r41.hasNext() == false) goto L123;
        Object r43 = r41.next();
        int r112 = r42 + 1;
        if (r42 >= 0) goto L82;
        CollectionsKt.throwIndexOverflow();
    L82:
        ECCommonCard r44 = (ECCommonCard) r43;
        if (r44 == null) goto L90;
        ECProductStruct r45 = r44.getProduct();
        if (r45 == null) goto L90;
        Object r46 = r45.getCover();
        if (r46 == null) goto L90;
        String r47 = l93.b.a(r46);
        if (r47 == null) goto L90;
    L92:
        if (r44 == null) goto L98;
        ECProductStruct r48 = r44.getProduct();
        if (r48 == null) goto L98;
        PriceStruct r113 = r48.getPrice();
        if (r113 == null) goto L98;
        String r49 = PriceStruct.getPromoPrice$default(r113, false, 0, 1, 3, null);
    L99:
        View r50 = LayoutInflater.from(getContext()).inflate(2131564667, null);
        SimpleDraweeView r51 = r50.findViewById(2131368506);
        ViewGroup.LayoutParams r52 = r51.getLayoutParams();
        int r114 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r52.width = com.bytedance.android.ec.hybrid.list.util.c.c(60, getContext(), true);
        r52.height = com.bytedance.android.ec.hybrid.list.util.c.c(60, getContext(), true);
        Unit r115 = Unit.INSTANCE;
        r51.setLayoutParams(r52);
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r53 = this.h;
        if (r53 == null) goto L103;
        String r54 = r53.k;
        if (r54 == null) goto L103;
    L104:
        d0.c(r51, r47, r54);
        AppCompatTextView r55 = r50.findViewById(2131368508);
        Typeface r56 = k;
        r55.setTypeface(r56);
        r55.setTextSize(0, com.bytedance.android.ec.hybrid.list.util.c.c(10, getContext(), true));
        t93.a.d(r55);
        AppCompatTextView r57 = r50.findViewById(2131368509);
        r57.setText(r49);
        r57.setTypeface(r56);
        r57.setTextSize(0, com.bytedance.android.ec.hybrid.list.util.c.c(14, getContext(), true));
        t93.a.d(r57);
        AppCompatTextView r58 = r50.findViewById(2131368507);
        r58.setTextSize(0, com.bytedance.android.ec.hybrid.list.util.c.c(9, getContext(), true));
        t93.a.d(r58);
        r50.setOnClickListener(new d(r42, this, r23));
        this.f.addView(r50, r111);
        com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r59 = this.i;
        if (r59 == null) goto L116;
        BtmPositionResult r60 = getBtmInfo();
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r61 = this.h;
        if (r61 == null) goto L114;
        ECMallFeed r62 = r61.h;
        if (r62 == null) goto L114;
        com.bytedance.android.shopping.api.mall.feed.e r63 = r62.A1;
        if (r63 == null) goto L114;
        Map<String, Object> r64 = r63.getGlobalProps();
        if (r64 == null) goto L114;
    L115:
        r59.c(r23, r60, r42, r64, S5());
    L114:
        r64 = MapsKt.emptyMap();
    L116:
        r42 = r112;
    L103:
        r54 = "ec_na_mall_header";
    L98:
        r49 = null;
    L90:
        r47 = "";
        goto L92
    L123:
        return;
    L122:
        return;
    L117:
        return;
    L71:
        r37 = 0;
    L67:
        r35 = "ec_na_mall_header";
    L58:
        r28 = "ec_na_mall_header";
    L53:
        r25 = "ec_na_mall_header";
        goto L54
    L5:
        if (r0.e != true) goto L7;
        goto L7
    }

    public final void U5(ChannelVO r7, int r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r0 = this.i;
        if (r0 == null) goto L17;
        BtmPositionResult r2 = getBtmInfo();
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r1 = this.h;
        if (r1 == null) goto L14;
        ECMallFeed r3 = r1.h;
        if (r3 == null) goto L14;
        com.bytedance.android.shopping.api.mall.feed.e r4 = r3.A1;
        if (r4 == null) goto L14;
        Map<String, Object> r5 = r4.getGlobalProps();
        if (r5 == null) goto L14;
    L15:
        r0.b(r7, r2, r8, r5, S5());
        return;
    L14:
        r5 = MapsKt.emptyMap();
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CycleActivityView41(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        int r5 = com.bytedance.android.ec.hybrid.list.util.c.a;
        this.a = com.bytedance.android.ec.hybrid.list.util.c.c(12, getContext(), true);
        View r6 = LayoutInflater.from(r2).inflate(2131564674, this);
        this.b = (TextView) r6.findViewById(2131368503);
        this.c = (TextView) r6.findViewById(2131368501);
        this.d = (TextView) r6.findViewById(2131368502);
        this.e = (TextView) r6.findViewById(2131368505);
        this.f = (LinearLayout) r6.findViewById(2131368511);
        r6.setOutlineProvider(new a(this));
        r6.setClipToOutline(true);
    }

    public final void T5(ChannelVO r9, int r10, long r11) {
        if (r9 != null) goto L4;
        return;
    L4:
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r0 = this.h;
        if (r0 == null) goto L12;
        int r1 = f.a;
        BtmPositionResult r2 = getBtmInfo();
        if (r2 == null) goto L9;
        String r3 = r2.getBtm();
    L10:
        f.a(r0, r9, r10, r3, r9.getBcm(), r0.h.A1.getGlobalProps(), r11);
        return;
    L9:
        r3 = null;
        goto L10
    }

    public /* synthetic */ CycleActivityView41(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
