package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010#J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/BasePanelView;", "Landroid/widget/FrameLayout;", "", "getBtmIdForProduct", "getProductBtm", "Lrd3/a;", "a", "Lrd3/a;", "getAnchorInflowFeedItem", "()Lrd3/a;", "setAnchorInflowFeedItem", "(Lrd3/a;)V", "anchorInflowFeedItem", "Lcom/bytedance/android/ec/model/inflowfeed/Promotion;", "b", "Lcom/bytedance/android/ec/model/inflowfeed/Promotion;", "getPromotion", "()Lcom/bytedance/android/ec/model/inflowfeed/Promotion;", "setPromotion", "(Lcom/bytedance/android/ec/model/inflowfeed/Promotion;)V", "promotion", "", "c", "Ljava/lang/Integer;", "getPos", "()Ljava/lang/Integer;", "setPos", "(Ljava/lang/Integer;)V", "pos", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BasePanelView extends FrameLayout {
    public rd3.a a;
    public Promotion b;
    public Integer c;
    public final Set<String> d;

    public BasePanelView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BasePanelView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final String getProductBtm() {
        rd3.a r0 = this.a;
        if (r0 == null) goto L7;
        yd3.p r1 = r0.i();
        if (r1 == null) goto L7;
        Integer r2 = Integer.valueOf(r1.getType());
    L8:
        if (r2 != null) goto L11;
    L13:
        if (r2 != null) goto L16;
    L18:
        if (r2 != null) goto L21;
    L23:
        if (r2 != null) goto L26;
    L29:
        return null;
    L26:
        if (r2.intValue() != 12) goto L29;
        return "a1.b7365.c870003.d993139";
    L21:
        if (r2.intValue() != 9) goto L23;
    L22:
        return "a1.b7365.c2695.d3104";
    L16:
        if (r2.intValue() != 7) goto L18;
    L11:
        if (r2.intValue() != 1) goto L13;
        return "a1.b7365.c87897.d116400";
    L7:
        r2 = null;
        goto L8
    }

    private final String getBtmIdForProduct() {
        String r0 = getProductBtm();
        if (r0 != null) goto L5;
        return null;
    L5:
        return BtmSDK.INSTANCE.obtainEventBtmParams(new BtmItemBuilder(r0, null, 2, null).withView(this).build());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        rd3.a r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        yd3.p r1 = r0.i();
        boolean r2 = true;
        if (r1 != null) goto L8;
    L10:
        Promotion r3 = this.b;
        if (r3 == null) goto L40;
        PromotionProductStruct r4 = r3.getPromotionInfo();
        if (r4 == null) goto L41;
        PromotionProductBaseStruct r5 = r4.getBaseInfo();
        if (r5 == null) goto L42;
        String r6 = r5.getProductId();
        if (r6 != null) goto L20;
        return;
    L20:
        if (this.d.contains(r6) == false) goto L22;
        return;
    L22:
        this.d.add(r6);
        com.bytedance.android.btm.api.model.d r7 = new com.bytedance.android.btm.api.model.d();
        String r8 = getProductBtm();
        String r9 = "";
        if (r8 != null) goto L25;
        r8 = "";
    L25:
        r7.a = r8;
        r7.b = PageFinder.via(this);
        int r10 = com.bytedance.android.shopping.feed.event.o.a;
        rd3.a r11 = this.a;
        Promotion r12 = this.b;
        Intrinsics.checkNotNullParameter(this, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r7, "btmModel");
        if (ld3.f.b() == false) goto L38;
        String r13 = r7.a;
        if (r13 == null) goto L31;
        r9 = r13;
    L31:
        com.bytedance.android.shopping.feed.event.k r14 = new com.bytedance.android.shopping.feed.event.k(r12, this, r11);
        if (r9.length() == 0) goto L35;
        r2 = false;
    L35:
        if (r2 == false) goto L37;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L37:
        com.bytedance.android.bst.api.d r15 = new com.bytedance.android.bst.api.d(this);
        r15.a = r9;
        r15.b = "show_product";
        r15.c = r12;
        r15.d = "like_shopping";
        r15.e = -1;
        r15.f = r14;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.a(r15);
        return;
    L38:
        String r16 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r7.a, Boolean.FALSE).withPageFinder(r7.b).build());
        FeedProductEventTracker r17 = FeedProductEventTracker.a;
        Context r18 = getContext();
        r17.getClass();
        FeedProductEventTracker.P(r18, r11, r12, r16, null);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L8:
        if (r1.getType() != 1) goto L10;
    }

    public final rd3.a getAnchorInflowFeedItem() {
        return this.a;
    }

    public final Integer getPos() {
        return this.c;
    }

    public final Promotion getPromotion() {
        return this.b;
    }

    public final void setAnchorInflowFeedItem(rd3.a r1) {
        this.a = r1;
    }

    public final void setPos(Integer r1) {
        this.c = r1;
    }

    public final void setPromotion(Promotion r1) {
        this.b = r1;
    }

    public void a(rd3.a r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "anchorInflowFeedItem");
        this.a = r2;
        yd3.p r4 = r2.i();
        if (r4 == null) goto L9;
        yd3.m r5 = r4.l();
        if (r5 == null) goto L9;
        List<Promotion> r6 = r5.h();
        if (r6 == null) goto L9;
        Promotion r7 = (Promotion) CollectionsKt.getOrNull(r6, r3);
    L10:
        this.b = r7;
        this.c = Integer.valueOf(r3);
        return;
    L9:
        r7 = null;
        goto L10
    }

    public BasePanelView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = new LinkedHashSet();
    }

    public /* synthetic */ BasePanelView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
