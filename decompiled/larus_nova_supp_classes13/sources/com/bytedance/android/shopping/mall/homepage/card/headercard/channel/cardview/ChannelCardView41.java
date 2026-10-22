package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.BigCardTitleView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R!\u0010\u000e\u001a\f\u0012\b\u0012\u00060\tR\u00020\u00000\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/ChannelCardView41;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/BigCardTitleView;", "f", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/BigCardTitleView;", "getTitleContainer", "()Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/BigCardTitleView;", "titleContainer", "", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/ChannelCardView41$a;", "g", "Ljava/util/List;", "getContentContainers", "()Ljava/util/List;", "contentContainers", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelCardView41 extends LinearLayout {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final BigCardTitleView f;
    public final List<a> g;

    public final class a extends LinearLayout {
        public final SimpleDraweeView a;
        public final TextView b;

        public a() {
            throw null;
        }

        public final TextView getPriceTextView() {
            return this.b;
        }

        public final SimpleDraweeView getProductSDView() {
            return this.a;
        }

        public a(ChannelCardView41 r6, Context r7) {
            Intrinsics.checkNotNullParameter(r7, "context");
            super(r7, null, 0);
            View r0 = new SimpleDraweeView(r7);
            this.a = r0;
            TextView r1 = new TextView(r7);
            r1.setTextColor(ContextCompat.getColor(r7, 2131106126));
            com.bytedance.android.ec.hybrid.a.c();
            Unit r8 = Unit.INSTANCE;
            this.b = r1;
            setOrientation(1);
            LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(r6.c, r6.d);
            r2.setMarginStart(r6.e);
            addView(r0, r2);
            LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-2, -2);
            r9.gravity = 1;
            addView(r1, r9);
        }
    }

    public ChannelCardView41(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChannelCardView41(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final List<a> getContentContainers() {
        return this.g;
    }

    public final BigCardTitleView getTitleContainer() {
        return this.f;
    }

    public ChannelCardView41(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        int r10 = c.a;
        int r11 = c.c(71, getContext(), true);
        this.a = r11;
        int r12 = c.c(1, getContext(), true);
        this.b = r12;
        int r1 = c.c(60, getContext(), true);
        this.c = r1;
        this.d = r1;
        this.e = c.c(5, getContext(), true);
        int r4 = 0;
        BigCardTitleView r2 = new BigCardTitleView(r7, null, 6, 0);
        this.f = r2;
        this.g = new ArrayList();
        setLayoutParams(new LinearLayout.LayoutParams(-1, c.c(90, getContext(), true)));
        setOrientation(0);
        setBackgroundColor(ContextCompat.getColor(r7, 2131106130));
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(r11, -1);
        r0.setMarginStart(r12);
        Unit r13 = Unit.INSTANCE;
        addView(r2, r0);
    L4:
        if (r4 >= 4) goto L6;
        a r14 = new a(this, r7);
        r14.setGravity(16);
        ((ArrayList) this.g).add(r14);
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(this.a, -1);
        r15.setMarginStart(this.b);
        Unit r3 = Unit.INSTANCE;
        addView(r14, r15);
        r4 = r4 + 1;
        goto L4
    }

    public /* synthetic */ ChannelCardView41(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
