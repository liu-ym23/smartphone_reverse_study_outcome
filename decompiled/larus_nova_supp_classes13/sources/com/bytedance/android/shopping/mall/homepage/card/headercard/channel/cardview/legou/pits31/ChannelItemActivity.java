package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/legou/pits31/ChannelItemActivity;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelItemActivity extends FrameLayout {
    public boolean a;
    public final SimpleDraweeView b;
    public final MiaoShaPriceLabelView c;

    public ChannelItemActivity(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChannelItemActivity(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public ChannelItemActivity(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        View r10 = new SimpleDraweeView(r7);
        this.b = r10;
        MiaoShaPriceLabelView r11 = new MiaoShaPriceLabelView(r7, null, 6, 0);
        this.c = r11;
        LinearLayout r0 = new LinearLayout(r7);
        int r1 = c.a;
        int r2 = c.c(63, r7, true);
        setVisibility(8);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        r3.gravity = 1;
        Unit r5 = Unit.INSTANCE;
        setLayoutParams(r3);
        r0.setOrientation(1);
        r0.setGravity(1);
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(r2, r2);
        r4.gravity = 1;
        r0.addView(r10, r4);
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-2, c.c(18, r7, true));
        r12.gravity = 1;
        r0.addView(r11, r12);
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        r13.gravity = 17;
        addView(r0, r13);
    }

    public /* synthetic */ ChannelItemActivity(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
