package com.suite.lark.platform.component.widget_biz_dinghelper.helper.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0012J\u0016\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\nJ\u0014\u0010\u0017\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bJ\u0006\u0010\u001c\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\u0013J\u0006\u0010\u001f\u001a\u00020\u0013J>\u0010 \u001a\u00020\u001326\u0010!\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00130\u0011J\u0006\u0010$\u001a\u00020\u0013J\u0006\u0010%\u001a\u00020\u0013J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u001a\u0010'\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020\u0013H\u0002J\b\u0010)\u001a\u00020\u0013H\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\b\u0010+\u001a\u00020\u0013H\u0002J\b\u0010,\u001a\u00020\u0013H\u0002JD\u0010-\u001a\u00020\u0013*\u00020.26\u0010/\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00130\u0011H\u0002R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_dinghelper/helper/view/CardListLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "isExpanded", "()Z", "childrenOnClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "", "ellipsizeBottomPadding", "", "ellipsizeVerticalPadding", "addCardView", "view", "index", "views", "", "removeFirstCardView", "removeCardViewAt", BitableAnalytic.LinkSceneClickType.EXPAND, "ellipsize", "setChildrenOnClickListener", "listener", "Lkotlin/ParameterName;", "name", "removeChildrenOnClickListener", "onTransitionEnd", "removeCardView", "addCardViewInner", "onViewChanged", "ensureOnClickListener", "ensureChildrenVisibility", "calcAndSetEllipsize", "calcAndSetExpanded", "forEachChildrenIndex", "Landroid/view/ViewGroup;", "block", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Companion", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardListLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f460863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super Integer, ? super View, Unit> f460864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f460865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f460866d;

    public static final class a {
    }

    static {
    }

    public final void R5() {
        if (this.f460863a == false) goto L5;
        S5(this, CardListLayout$ensureChildrenVisibility$1.INSTANCE);
        return;
    L5:
        S5(this, CardListLayout$ensureChildrenVisibility$2.INSTANCE);
    }

    public final void T5() {
        if (this.f460863a == false) goto L5;
        S5(this, new CardListLayout$calcAndSetExpanded$1(this));
    L10:
        S5(this, new CardListLayout$ensureOnClickListener$1(this));
        R5();
        return;
    L5:
        View r100 = getChildAt(0);
        if (r100 == null) goto L8;
        final int r101 = r100.getId();
    L9:
        S5(this, new CardListLayout$calcAndSetEllipsize$1(r101, this));
        goto L10
    L8:
        r101 = -1;
        goto L9
    }

    public CardListLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f460865c = new UDDimension.Dp(8).toPixels(getContext());
        this.f460866d = new UDDimension.Dp(12).toPixels(getContext());
        setClipToPadding(false);
    }

    public final void setChildrenOnClickListener(Function2<? super Integer, ? super View, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f460864b = r100;
    }

    public CardListLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f460865c = new UDDimension.Dp(8).toPixels(getContext());
        this.f460866d = new UDDimension.Dp(12).toPixels(getContext());
        setClipToPadding(false);
    }

    public static void S5(ViewGroup r100, Function2 r101) {
        int r102 = r100.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke(Integer.valueOf(r103), r100.getChildAt(r103));
        r103 = r103 + 1;
        goto L3
    }

    public CardListLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f460865c = new UDDimension.Dp(8).toPixels(getContext());
        this.f460866d = new UDDimension.Dp(12).toPixels(getContext());
        setClipToPadding(false);
    }
}
