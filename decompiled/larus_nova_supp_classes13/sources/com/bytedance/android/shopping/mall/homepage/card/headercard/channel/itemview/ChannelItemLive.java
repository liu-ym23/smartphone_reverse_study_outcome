package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.mall.widget.GradientCircleBorderView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import t93.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ChannelItemLive;", "Landroid/widget/FrameLayout;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "c", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getAvatarSdView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarSdView", "Landroidx/appcompat/widget/AppCompatTextView;", "d", "Landroidx/appcompat/widget/AppCompatTextView;", "getTagView", "()Landroidx/appcompat/widget/AppCompatTextView;", "tagView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelItemLive extends FrameLayout {
    public final GradientCircleBorderView a;
    public final GradientCircleBorderView b;
    public final SimpleDraweeView c;
    public final AppCompatTextView d;
    public AnimatorSet e;
    public AnimatorSet f;
    public AnimatorSet g;

    public ChannelItemLive(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChannelItemLive(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        Animator r1 = null;
        if (this.e != null) goto L11;
        Animator r0 = AnimatorInflater.loadAnimator(getContext(), 2130837535);
        if ((r0 instanceof AnimatorSet) == true) goto L7;
        r0 = null;
    L7:
        AnimatorSet r2 = (AnimatorSet) r0;
        this.e = r2;
        if (r2 == null) goto L11;
        r2.setTarget(this.a);
    L11:
        if (this.f != null) goto L19;
        Animator r3 = AnimatorInflater.loadAnimator(getContext(), 2130837536);
        if ((r3 instanceof AnimatorSet) == true) goto L15;
        r3 = null;
    L15:
        AnimatorSet r4 = (AnimatorSet) r3;
        this.f = r4;
        if (r4 == null) goto L19;
        r4.setTarget(this.b);
    L19:
        if (this.g != null) goto L27;
        Animator r5 = AnimatorInflater.loadAnimator(getContext(), 2130837534);
        if ((r5 instanceof AnimatorSet) == false) goto L24;
        r1 = r5;
    L24:
        AnimatorSet r6 = (AnimatorSet) r1;
        this.g = r6;
        if (r6 == null) goto L27;
        r6.setTarget(this.c);
    L27:
        c(this.f);
        c(this.e);
        c(this.g);
    }

    public final SimpleDraweeView getAvatarSdView() {
        return this.c;
    }

    public final AppCompatTextView getTagView() {
        return this.d;
    }

    public static void a(AnimatorSet r2) {
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

    public ChannelItemLive(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        int r15 = c.a;
        int r16 = c.c(54, getContext(), true);
        int r17 = c.c(46, getContext(), true);
        GradientCircleBorderView r2 = new GradientCircleBorderView(r12, null, 6, 0);
        r2.setStrokeWidth(c.c(1, getContext(), true));
        r2.setStartColor(ContextCompat.getColor(r12, 2131106127));
        r2.setEndColor(ContextCompat.getColor(r12, 2131106101));
        Unit r8 = Unit.INSTANCE;
        this.a = r2;
        GradientCircleBorderView r9 = new GradientCircleBorderView(r12, null, 6, 0);
        r9.setStrokeWidth(c.c(2, getContext(), true));
        r9.setStartColor(ContextCompat.getColor(r12, 2131106127));
        r9.setEndColor(ContextCompat.getColor(r12, 2131106101));
        this.b = r9;
        View r4 = new SimpleDraweeView(r12);
        r4.setHierarchy(GenericDraweeHierarchyBuilder.newInstance(r12.getResources()).setRoundingParams(new RoundingParams().setRoundAsCircle(true)).build());
        this.c = r4;
        AppCompatTextView r6 = new AppCompatTextView(r12);
        GradientDrawable r7 = new GradientDrawable();
        r7.setShape(0);
        r7.setColors(new int[]{ContextCompat.getColor(r12, 2131106129), ContextCompat.getColor(r12, 2131106126)});
        r7.setGradientType(0);
        r7.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        r7.setCornerRadius(c.c(100, getContext(), true));
        r7.setStroke(c.c(1, getContext(), true), ContextCompat.getColor(r12, 2131106130));
        r6.setBackground(r7);
        r6.setTextColor(ContextCompat.getColor(r12, 2131106130));
        ViewCompat.setPaddingRelative(r6, c.c(5, getContext(), true), c.c(1, getContext(), true), c.c(5, getContext(), true), 0);
        r6.setSingleLine();
        r6.setTextSize(0, c.c(10, getContext(), true));
        a.d(r6);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        this.d = r6;
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-1, -1);
        r18.gravity = 17;
        addView(r2, r18);
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(r16, r16);
        r19.gravity = 17;
        addView(r9, r19);
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(r17, r17);
        r110.gravity = 17;
        addView(r4, r110);
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-2, c.c(16, getContext(), true));
        r111.gravity = 81;
        addView(r6, r111);
    }

    public /* synthetic */ ChannelItemLive(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
