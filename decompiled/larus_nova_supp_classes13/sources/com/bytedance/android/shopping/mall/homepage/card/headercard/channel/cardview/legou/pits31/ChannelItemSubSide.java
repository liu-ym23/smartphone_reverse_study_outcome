package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelCID;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.facebook.drawee.view.SimpleDraweeView;
import gf3.a;
import gf3.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/legou/pits31/ChannelItemSubSide;", "Landroid/widget/LinearLayout;", "Lgf3/a;", "", "a", "I", "getIndex", "()I", "setIndex", "(I)V", "index", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "b", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "getChannel", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "setChannel", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;)V", "channel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelItemSubSide extends LinearLayout implements a {
    public int a;
    public ChannelVO b;
    public final SimpleDraweeView c;

    public ChannelItemSubSide(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChannelItemSubSide(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // gf3.a
    public final View i() {
        return this;
    }

    public ChannelVO getChannel() {
        return this.b;
    }

    @Override // gf3.a
    public int getIndex() {
        return this.a;
    }

    public void setChannel(ChannelVO r1) {
        this.b = r1;
    }

    public void setIndex(int r1) {
        this.a = r1;
    }

    public ChannelItemSubSide(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = -1;
        SimpleDraweeView r7 = new SimpleDraweeView(r4);
        this.c = r7;
        setOrientation(1);
        int r1 = c.a;
        addView(r7, new LinearLayout.LayoutParams(c.c(46, r4, true), c.c(46, r4, true)));
    }

    @Override // gf3.a
    public final void a(ChannelVO r6, com.bytedance.android.shopping.mall.homepage.card.headercard.a r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "channel");
        Intrinsics.checkNotNullParameter(r7, "mallContext");
        setChannel(r6);
        setIndex(r8);
        if (getChannel() == null) goto L33;
        if (r8 < 0) goto L34;
        ChannelVO r9 = getChannel();
        if (r9 == null) goto L10;
        String r10 = r9.getItemImageUrl(r8);
    L12:
        if (r10 != null) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == true) goto L20;
        d0.c(this.c, r10, r7.k);
    L20:
        View r11 = findViewById(2131375826);
        if (r11 == null) goto L23;
        removeView(r11);
    L23:
        ChannelVO r12 = getChannel();
        if (r12 == null) goto L26;
        String r13 = r12.getComponentId();
    L28:
        if (Intrinsics.areEqual(r13, ChannelCID.BRAND.getValue()) == false) goto L30;
        b r14 = new BrandLabelView(getContext(), null, 6, 0);
    L31:
        View r0 = r14.i();
        r0.setId(2131375826);
        Unit r15 = Unit.INSTANCE;
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-1, -2);
        r16.gravity = 17;
        int r2 = c.a;
        r16.topMargin = c.c(1, getContext(), true);
        addView(r0, r16);
        r14.s(getChannel(), r8);
        return;
    L30:
        r14 = new SinglePriceLabelView(getContext(), null, 6, 0);
        goto L31
    L26:
        r13 = null;
        goto L28
    L14:
        if (r10.length() == 0) goto L17;
        r3 = false;
        goto L18
    L10:
        r10 = null;
        goto L12
    L34:
        return;
    }

    public /* synthetic */ ChannelItemSubSide(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
