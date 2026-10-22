package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31;

import android.animation.AnimatorSet;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.android.shopping.mall.widget.GradientCircleBorderView;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import gf3.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\u0003¢\u0006\u0004\b$\u0010%R\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006&"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/legou/pits31/ChannelItemLive;", "Landroid/widget/FrameLayout;", "Lgf3/a;", "", "a", "I", "getIndex", "()I", "setIndex", "(I)V", "index", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "b", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "getChannel", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "setChannel", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;)V", "channel", "Lcom/facebook/drawee/view/SimpleDraweeView;", "e", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getAvatarSdView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarSdView", "Landroidx/appcompat/widget/AppCompatTextView;", "f", "Landroidx/appcompat/widget/AppCompatTextView;", "getTagView", "()Landroidx/appcompat/widget/AppCompatTextView;", "tagView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelItemLive extends FrameLayout implements a {
    public int a;
    public ChannelVO b;
    public final GradientCircleBorderView c;
    public final GradientCircleBorderView d;
    public final SimpleDraweeView e;
    public final AppCompatTextView f;
    public AnimatorSet g;
    public AnimatorSet h;
    public AnimatorSet i;

    public ChannelItemLive(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChannelItemLive(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // gf3.a
    public final View i() {
        return this;
    }

    public final SimpleDraweeView getAvatarSdView() {
        return this.e;
    }

    public ChannelVO getChannel() {
        return this.b;
    }

    @Override // gf3.a
    public int getIndex() {
        return this.a;
    }

    public final AppCompatTextView getTagView() {
        return this.f;
    }

    public static void b(AnimatorSet r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        boolean r0 = r2.isStarted();
        boolean r1 = r2.isPaused();
        if (r0 == false) goto L9;
        if (r1 == true) goto L10;
        r2.pause();
        return;
    L10:
        return;
    }

    public static void c(AnimatorSet r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        boolean r0 = r2.isStarted();
        boolean r1 = r2.isPaused();
        if (r0 == false) goto L8;
        if (r1 == false) goto L10;
        r2.resume();
        return;
    L10:
        return;
    L8:
        r2.start();
    }

    public void setChannel(ChannelVO r1) {
        this.b = r1;
    }

    public void setIndex(int r1) {
        this.a = r1;
    }

    public ChannelItemLive(Context r22, AttributeSet r23, int r24) {
        Intrinsics.checkNotNullParameter(r22, "context");
        super(r22, r23, r24);
        this.a = -1;
        int r2 = c.a;
        int r11 = c.c(46, getContext(), true);
        int r12 = c.c(42, getContext(), true);
        int r13 = c.c(36, getContext(), true);
        GradientCircleBorderView r14 = new GradientCircleBorderView(r22, null, 6, 0);
        r14.setStrokeWidth(c.c(1, getContext(), true));
        r14.setStartColor(ContextCompat.getColor(r22, 2131106127));
        r14.setEndColor(ContextCompat.getColor(r22, 2131106101));
        Unit r5 = Unit.INSTANCE;
        this.c = r14;
        GradientCircleBorderView r6 = new GradientCircleBorderView(r22, null, 6, 0);
        r6.setStrokeWidth(c.c(2, getContext(), true));
        r6.setStartColor(ContextCompat.getColor(r22, 2131106127));
        r6.setEndColor(ContextCompat.getColor(r22, 2131106101));
        this.d = r6;
        View r7 = new SimpleDraweeView(r22);
        r7.setHierarchy(GenericDraweeHierarchyBuilder.newInstance(r22.getResources()).setRoundingParams(new RoundingParams().setRoundAsCircle(true)).build());
        this.e = r7;
        AppCompatTextView r4 = new AppCompatTextView(r22);
        BackgroundDrawable r3 = new BackgroundDrawable(r22, r23, false, 4, null);
        r3.setBgColor(ContextCompat.getColor(r22, 2131106121));
        r3.setStrokeWidth(c.c(Double.valueOf(0.5d), r22, true));
        r3.setCornerRadius(c.c(100, r22, true));
        r3.setStrokeColor(ContextCompat.getColor(r22, 2131106130));
        r3.invalidate();
        r4.setBackground(r3);
        r4.setTextColor(ColorProtector.parseColor("#C0161823"));
        ViewCompat.setPaddingRelative(r4, c.c(5, getContext(), true), c.c(1, getContext(), true), c.c(5, getContext(), true), 0);
        r4.setSingleLine();
        r4.setTextSize(0, c.c(9, getContext(), true));
        t93.a.d(r4);
        r4.setEllipsize(TextUtils.TruncateAt.END);
        this.f = r4;
        FrameLayout r1 = new FrameLayout(r22);
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(r11, r11);
        r8.gravity = 17;
        r1.addView(r14, r8);
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(r12, r12);
        r9.gravity = 17;
        r1.addView(r6, r9);
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(r13, r13);
        r10.gravity = 17;
        r1.addView(r7, r10);
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(-1, -2);
        r15.gravity = 1;
        addView(r1, r15);
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-2, -2);
        r16.gravity = 81;
        addView(r4, r16);
    }

    @Override // gf3.a
    public final void a(ChannelVO r5, com.bytedance.android.shopping.mall.homepage.card.headercard.a r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "channel");
        Intrinsics.checkNotNullParameter(r6, "mallContext");
        String r0 = r5.getItemImageUrl(r7);
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return;
    L11:
        d0.c(this.e, r0, r6.k);
        String r8 = r5.getItemTag(r7);
        if (r8 != null) goto L14;
    L17:
        if (r1 == true) goto L19;
        this.f.setText(r8);
        this.f.setVisibility(0);
        return;
    L19:
        this.f.setVisibility(8);
        return;
    L14:
        if (r8.length() == 0) goto L17;
        r1 = false;
        goto L17
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public /* synthetic */ ChannelItemLive(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
