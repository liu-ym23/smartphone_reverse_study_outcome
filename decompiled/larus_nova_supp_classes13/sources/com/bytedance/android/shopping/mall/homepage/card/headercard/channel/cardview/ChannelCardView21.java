package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.ChannelItemProduct;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/ChannelCardView21;", "Landroid/widget/RelativeLayout;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "a", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getTitleSdView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "titleSdView", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ChannelItemProduct;", "b", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ChannelItemProduct;", "getLeftProductContent", "()Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ChannelItemProduct;", "leftProductContent", "c", "getRightProductContent", "rightProductContent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelCardView21 extends RelativeLayout {
    public final SimpleDraweeView a;
    public final ChannelItemProduct b;
    public final ChannelItemProduct c;

    public ChannelCardView21(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChannelCardView21(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ChannelItemProduct getLeftProductContent() {
        return this.b;
    }

    public final ChannelItemProduct getRightProductContent() {
        return this.c;
    }

    public final SimpleDraweeView getTitleSdView() {
        return this.a;
    }

    public ChannelCardView21(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        int r12 = c.a;
        int r13 = c.c(60, r9, true);
        SimpleDraweeView r0 = new SimpleDraweeView(r9);
        this.a = r0;
        AttributeSet r2 = null;
        int r3 = 6;
        int r4 = 0;
        ChannelItemProduct r1 = new ChannelItemProduct(r9, r2, r3, r4);
        this.b = r1;
        ChannelItemProduct r5 = new ChannelItemProduct(r9, r2, r3, r4);
        this.c = r5;
        setLayoutParams(new RelativeLayout.LayoutParams(-1, c.c(94, r9, true)));
        setBackgroundColor(ContextCompat.getColor(r9, 2131106130));
        r0.setId(ViewCompat.generateViewId());
        RelativeLayout.LayoutParams r6 = new RelativeLayout.LayoutParams(c.c(171, r9, true), c.c(24, r9, true));
        r6.addRule(20);
        r6.addRule(10);
        Unit r7 = Unit.INSTANCE;
        addView(r0, r6);
        RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(r13, r13);
        r8.addRule(20);
        r8.addRule(3, r0.getId());
        r8.setMarginStart(c.c(15, r9, true));
        r8.topMargin = c.c(2, r9, true);
        addView(r1, r8);
        RelativeLayout.LayoutParams r14 = new RelativeLayout.LayoutParams(r13, r13);
        r14.addRule(21);
        r14.addRule(3, r0.getId());
        r14.setMarginEnd(c.c(15, r9, true));
        r14.topMargin = c.c(2, r9, true);
        addView(r5, r14);
    }

    public /* synthetic */ ChannelCardView21(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
