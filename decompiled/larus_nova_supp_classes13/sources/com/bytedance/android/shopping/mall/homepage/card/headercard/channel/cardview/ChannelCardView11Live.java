package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.ChannelItemLive;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/ChannelCardView11Live;", "Landroid/widget/LinearLayout;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "a", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getTitleSdView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "titleSdView", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ChannelItemLive;", "b", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ChannelItemLive;", "getContentView", "()Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ChannelItemLive;", "contentView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelCardView11Live extends LinearLayout {
    public final SimpleDraweeView a;
    public final ChannelItemLive b;

    public ChannelCardView11Live(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChannelCardView11Live(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ChannelItemLive getContentView() {
        return this.b;
    }

    public final SimpleDraweeView getTitleSdView() {
        return this.a;
    }

    public ChannelCardView11Live(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        View r8 = new SimpleDraweeView(r5);
        this.a = r8;
        ChannelItemLive r9 = new ChannelItemLive(r5, null, 6, 0);
        this.b = r9;
        setClipChildren(false);
        int r1 = c.a;
        setLayoutParams(new LinearLayout.LayoutParams(-1, c.c(94, r5, true)));
        setOrientation(1);
        setBackgroundColor(ContextCompat.getColor(r5, 2131106130));
        addView(r8, new LinearLayout.LayoutParams(c.c(82, r5, true), c.c(24, r5, true)));
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(c.c(60, r5, true), c.c(60, r5, true));
        r10.topMargin = c.c(2, r5, true);
        r10.setMarginStart(c.c(15, r5, true));
        Unit r11 = Unit.INSTANCE;
        addView(r9, r10);
    }

    public /* synthetic */ ChannelCardView11Live(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
