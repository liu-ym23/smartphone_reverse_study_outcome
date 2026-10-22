package com.bytedance.android.shopping.mall.homepage.card;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.n;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$LayoutStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedConstraintLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.mall.homepage.card.live.BaseLiveViewHolder;
import com.bytedance.android.shopping.mall.homepage.card.video.NativeVideoCard;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/AbstractNativeCard;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbstractNativeCard extends BaseViewHolder {
    public static final /* synthetic */ int t = 0;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public String r;
    public float s;

    public abstract String q4();

    public abstract ECRoundedConstraintLayout r4();

    public abstract int s4();

    public final com.bytedance.android.shopping.mall.homepage.card.common.feedback.b t4() {
        return (com.bytedance.android.shopping.mall.homepage.card.common.feedback.b) this.p.getValue();
    }

    public final void v4() {
        ECRoundedConstraintLayout r2 = null;
        String r3 = null;
        Object r0 = U3("negfeedback", "neg_feedback_styles_new", null, null);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L86;
        Intrinsics.checkNotNullParameter(this, "$this$getFeedbackParamsForNewDislike");
        LinkedHashMap r10 = new LinkedHashMap();
        String r5 = "";
        if ((this instanceof NativeVideoCard) == false) goto L33;
        NativeVideoCard r4 = (NativeVideoCard) this;
        VideoCardData r6 = r4.O;
        if (r6 == null) goto L17;
        VideoCardData.Video r7 = r6.getVideo();
        if (r7 == null) goto L17;
        String r8 = r7.getItemId();
        if (r8 == null) goto L17;
    L18:
        r10.put("groupId", r8);
        r10.put("ecomType", "video");
        VideoCardData r9 = r4.O;
        if (r9 == null) goto L21;
        CommonData.Product r11 = r9.getProduct();
    L22:
        if (r11 == null) goto L24;
        String r12 = r11.getProductId();
    L25:
        VideoCardData r13 = r4.O;
        if (r13 == null) goto L28;
        String r14 = r13.rcPriorityFromProduct();
    L29:
        VideoCardData r15 = r4.O;
        if (r15 == null) goto L62;
        CommonData.CardCommon r16 = r15.getCardCommon();
    L64:
        if (r16 == null) goto L67;
        String r17 = r16.getResourceId();
        if (r17 == null) goto L67;
    L68:
        r10.put("resourceId", r17);
        if (r12 != null) goto L71;
        r12 = "";
    L71:
        r10.put("productId", r12);
        if (r14 == null) goto L75;
        r5 = r14;
    L75:
        r10.put("recommendInfo", r5);
        r10.put("index", Integer.valueOf(ToolsKt.g(this)));
        r10.put("logId", ToolsKt.l(this));
        r10.put("tabId", ToolsKt.r(this));
        r10.put("tabName", ToolsKt.s(this));
        ECHybridListItemVO r18 = ((BaseViewHolder) this).c;
        if (r18 == null) goto L82;
        n r19 = r18.o;
        if (r19 == null) goto L82;
        Map r20 = r19.f;
        if (r20 == null) goto L82;
        r10.putAll(r20);
    L82:
        r10.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        Pair[] r21 = new Pair[3];
        r21[0] = TuplesKt.to("position", Integer.valueOf(getAdapterPosition()));
        ECHybridListItemVO r22 = ((BaseViewHolder) this).c;
        if (r22 == null) goto L85;
        r3 = r22.d;
    L85:
        r21[1] = TuplesKt.to("cardId", r3);
        r21[2] = TuplesKt.to("cardType", q4());
        r10.putAll(MapsKt.mapOf(r21));
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.event.open_new_dislike", System.currentTimeMillis(), this.r, true, r10, false, 32));
        return;
    L67:
        r17 = "";
    L62:
        r16 = null;
        goto L64
    L28:
        r14 = null;
        goto L29
    L24:
        r12 = null;
        goto L25
    L21:
        r11 = null;
    L17:
        r8 = "";
        goto L18
    L33:
        if ((this instanceof BaseLiveViewHolder) == false) goto L63;
        BaseLiveViewHolder r23 = (BaseLiveViewHolder) this;
        LiveCardData r24 = r23.u;
        if (r24 == null) goto L40;
        LiveCardData.Live r25 = r24.getLive();
        if (r25 == null) goto L40;
        String r26 = r25.getRoomId();
        if (r26 == null) goto L40;
    L41:
        r10.put("roomId", r26);
        LiveCardData r27 = r23.u;
        if (r27 == null) goto L47;
        CommonData.User r28 = r27.getUser();
        if (r28 == null) goto L47;
        String r29 = r28.getId();
        if (r29 == null) goto L47;
    L48:
        r10.put("anchorId", r29);
        r10.put("ecomType", "live");
        LiveCardData r30 = r23.u;
        if (r30 == null) goto L51;
        CommonData.Product r31 = r30.getProduct();
    L52:
        if (r31 == null) goto L54;
        r12 = r31.getProductId();
    L55:
        LiveCardData r32 = r23.u;
        if (r32 == null) goto L58;
        r14 = r32.rcPriorityFromProduct();
    L59:
        LiveCardData r33 = r23.u;
        if (r33 == null) goto L62;
        r16 = r33.getCardCommon();
        goto L64
    L58:
        r14 = null;
        goto L59
    L54:
        r12 = null;
        goto L55
    L51:
        r31 = null;
    L47:
        r29 = "";
    L40:
        r26 = "";
        goto L41
    L63:
        r16 = null;
        r12 = null;
        r14 = null;
        goto L64
    L86:
        ECRoundedConstraintLayout r34 = (ECRoundedConstraintLayout) this.o.getValue();
        if ((r34 instanceof ViewGroup) == false) goto L90;
        r2 = r34;
    L90:
        if (r2 == null) goto L94;
        com.bytedance.android.shopping.mall.homepage.card.common.feedback.b r35 = t4();
        String r36 = this.r;
        Lazy r37 = ToolsKt.a;
        ConstraintLayout.LayoutParams r38 = new ConstraintLayout.LayoutParams(0, 0);
        r38.leftToLeft = 0;
        r38.rightToRight = 0;
        r38.topToTop = 0;
        r38.bottomToBottom = 0;
        r35.b(r36, r2, r38, this.s);
        return;
    L94:
        return;
    L5:
        if ((!Intrinsics.areEqual(r0, "null")) == false) goto L7;
        r1 = true;
        goto L8
    }

    public AbstractNativeCard(final View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.o = LazyKt.lazy(new AbstractNativeCard$container$2(this));
        this.p = LazyKt.lazy(new AbstractNativeCard$feedBackWidget$2(this));
        this.q = LazyKt.lazy(new AbstractNativeCard$feedBackButton$2(this, r2));
        this.r = "";
        this.s = 1.0f;
    }

    public final void u4(CommonModel$LayoutStyle r5) {
        ConstraintLayout.LayoutParams r0 = null;
        if (r5 == null) goto L5;
        String r1 = r5.getUrl();
    L6:
        int r2 = 0;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        b0.e((SimpleDraweeView) this.q.getValue());
    L16:
        if (r5 == null) goto L51;
        String r4 = r5.getUrl();
        if (r4 == null) goto L20;
        ((SimpleDraweeView) this.q.getValue()).setImageURI(r4);
    L20:
        ConstraintLayout.LayoutParams r6 = ((SimpleDraweeView) this.q.getValue()).getLayoutParams();
        if ((r6 instanceof ConstraintLayout.LayoutParams) == false) goto L24;
        r0 = r6;
    L24:
        ConstraintLayout.LayoutParams r7 = r0;
        if (r7 == null) goto L52;
        Integer r8 = r5.getWidth();
        if (r8 == null) goto L29;
        int r9 = r8.intValue();
    L30:
        ((ViewGroup.MarginLayoutParams) r7).width = r9;
        Integer r10 = r5.getHeight();
        if (r10 == null) goto L33;
        int r11 = r10.intValue();
    L34:
        ((ViewGroup.MarginLayoutParams) r7).height = r11;
        Integer r12 = r5.getRight();
        if (r12 == null) goto L37;
        int r13 = r12.intValue();
    L38:
        r7.setMarginEnd(r13);
        Integer r14 = r5.getLeft();
        if (r14 == null) goto L41;
        int r15 = r14.intValue();
    L42:
        r7.setMarginStart(r15);
        Integer r16 = r5.getTop();
        if (r16 == null) goto L45;
        int r17 = r16.intValue();
    L46:
        ((ViewGroup.MarginLayoutParams) r7).topMargin = r17;
        Integer r18 = r5.getBottom();
        if (r18 == null) goto L49;
        r2 = r18.intValue();
    L49:
        r7.setMarginStart(r2);
        ((SimpleDraweeView) this.q.getValue()).setLayoutParams(r7);
        return;
    L45:
        r17 = 0;
        goto L46
    L41:
        r15 = 0;
        goto L42
    L37:
        r13 = 0;
        goto L38
    L33:
        r11 = 0;
        goto L34
    L29:
        r9 = 0;
        goto L30
    L52:
        return;
    L51:
        return;
    L15:
        b0.n((SimpleDraweeView) this.q.getValue());
        goto L16
    L9:
        if (r1.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }
}
