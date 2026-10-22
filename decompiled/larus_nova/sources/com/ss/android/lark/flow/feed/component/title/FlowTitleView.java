package com.ss.android.lark.flow.feed.component.title;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.larksuite.framework.ui.SpareLayout;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J0\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u00182\b\b\u0002\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020&J\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0018J\u0006\u0010+\u001a\u00020\u0018J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0014J\f\u0010/\u001a\u00020\u0018*\u000200H\u0002J\u0016\u00101\u001a\u00020\u001a2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\b\u00102\u001a\u00020\u001aH\u0002J\f\u00103\u001a\u00020&*\u000204H\u0002R\u001c\u0010\t\u001a\u00020\n8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/ss/android/lark/flow/feed/component/title/FlowTitleView;", "Lcom/larksuite/framework/ui/SpareLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "titleViewComponent", "Lcom/ss/android/lark/flow/feed/component/title/FlowTitleViewComponent;", "getTitleViewComponent", "()Lcom/ss/android/lark/flow/feed/component/title/FlowTitleViewComponent;", "setTitleViewComponent", "(Lcom/ss/android/lark/flow/feed/component/title/FlowTitleViewComponent;)V", "drawableTagComponents", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/feed/cardcomponent/title/feedtag/FeedTagComponent;", "Lkotlin/collections/ArrayList;", "customTagViews", "Landroid/view/View;", "titleFadeMask", "Landroid/graphics/drawable/GradientDrawable;", "isTitleFadeMaskVisible", "", "init", "", "addTitleView", "generateLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "bindTitleView", "titleText", "", PromotionProductPrivilegesStruct.TAGS, "", "Lcom/ss/android/lark/flow/feed/component/title/FlowFeedTag;", "isBoldDisplay", "titleTextSize", "", "updateTitleFadeMask", "backgroundColor", "setTitleFadeMaskVisible", "isVisible", "isTitleFadeMaskShowing", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "hasOverLengthText", "Landroid/widget/TextView;", "bindTags", "clearAllTags", "dp2px", "", "Companion", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowTitleView extends SpareLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f423351g = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f423352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<vdb.a> f423353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<View> f423354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GradientDrawable f423355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f423356f;

    public static final class a {
    }

    static {
        f423351g = UIHelper.dp2px(20.0f);
    }

    public final b getTitleViewComponent() {
        return this.f423352b;
    }

    public FlowTitleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        GradientDrawable r101 = this.f423355e;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f423356f == true) goto L8;
        return;
    L8:
        TextView r102 = getTitleViewComponent().c();
        int r103 = r102.getWidth();
        int r104 = f423351g;
        if (r103 > r104) goto L11;
        return;
    L11:
        Layout r105 = r102.getLayout();
        boolean r106 = false;
        if (r105 != null) goto L15;
    L20:
        if (r106 == true) goto L22;
        return;
    L22:
        r101.setBounds(RangesKt.coerceAtLeast(r102.getRight() - r104, r102.getLeft()), r102.getTop(), r102.getRight(), r102.getBottom());
        r101.draw(r100);
        return;
    L15:
        if (r105.getLineCount() <= 0) goto L20;
        if (r105.getLineWidth(0) <= ((r102.getWidth() - r102.getCompoundPaddingLeft()) - r102.getCompoundPaddingRight())) goto L20;
        r106 = true;
        goto L20
    }

    public final void setTitleFadeMaskVisible(boolean r100) {
        if (this.f423356f != r100) goto L5;
        return;
    L5:
        this.f423356f = r100;
        invalidate();
    }

    public final void setTitleViewComponent(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f423352b = r100;
    }

    public FlowTitleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0);
        this.f423352b = new b(getContext());
        this.f423353c = new ArrayList();
        this.f423354d = new ArrayList();
        this.f423356f = true;
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2);
        r102.gravity = 16;
        addView(getTitleViewComponent().c(), 0, r102);
    }
}
