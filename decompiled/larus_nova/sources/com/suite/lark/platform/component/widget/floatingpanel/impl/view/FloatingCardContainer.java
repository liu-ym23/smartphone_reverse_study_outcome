package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OneShotPreDrawListener;
import com.byted.cast.common.CastMonitor;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 V2\u00020\u0001:\u0002VWB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u001e\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)J2\u0010*\u001a\u00020+2\b\u0010%\u001a\u0004\u0018\u00010&2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010-2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0002J&\u0010.\u001a\u00020!2\u001e\u0010/\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0-0100J\u000e\u00102\u001a\u00020!2\u0006\u0010(\u001a\u00020)J\u0014\u00103\u001a\u00020!2\f\u00104\u001a\b\u0012\u0004\u0012\u00020)00J\u0006\u00105\u001a\u00020!J \u00106\u001a\u00020!2\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0002J\u0006\u00109\u001a\u00020!J\u0006\u0010:\u001a\u00020!J\b\u0010;\u001a\u00020!H\u0002J\u0006\u0010<\u001a\u00020!J\u0012\u0010=\u001a\u00020!2\b\b\u0002\u0010>\u001a\u00020\u001bH\u0002J\u0012\u0010?\u001a\u00020!2\b\b\u0002\u0010>\u001a\u00020\u001bH\u0002J\b\u0010@\u001a\u00020!H\u0002J\u0006\u0010A\u001a\u00020\u001bJ\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000700J\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000700J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000700J\u0018\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007H\u0014J\u0018\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0014J0\u0010K\u001a\u00020!2\u0006\u0010L\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0007H\u0014J\u0012\u0010Q\u001a\u00020\u001b2\b\u0010R\u001a\u0004\u0018\u00010SH\u0014J\u0012\u0010T\u001a\u00020S2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010U\u001a\u00020SH\u0014J\u0012\u0010T\u001a\u00020S2\b\u0010R\u001a\u0004\u0018\u00010SH\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006X"}, d2 = {"Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingCardContainer;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ellipsizeBottomMargin", "ellipsizedHorizontalMargin", "minCardHeight", "totalCreatedCardCount", "onFloatingCardClickListener", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/OnFloatingCardClickListener;", "getOnFloatingCardClickListener", "()Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/OnFloatingCardClickListener;", "setOnFloatingCardClickListener", "(Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/OnFloatingCardClickListener;)V", "onExpandStatusChangedListener", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingCardContainer$OnExpandStatusChangedListener;", "getOnExpandStatusChangedListener", "()Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingCardContainer$OnExpandStatusChangedListener;", "setOnExpandStatusChangedListener", "(Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingCardContainer$OnExpandStatusChangedListener;)V", "value", "", "isExpanded", "()Z", "setExpanded", "(Z)V", "bindToScrollView", "", "scrollView", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingPanelScrollView;", "addCard", "cardView", "Landroid/view/View;", "index", "id", "", "createAndAddWrapper", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingCardWrapperView;", "lazyCard", "Lkotlin/Function0;", "refreshCards", "viewItems", "", "Lkotlin/Pair;", "removeCard", "removeCards", "ids", "removeAllCards", "releaseWrappers", "condition", "Lkotlin/Function1;", BitableAnalytic.LinkSceneClickType.EXPAND, "collapse", "countCreatedCardCount", "lazyExpandCardList", "ensureChildrenStatus", "lazyUpdate", "ensureChildrenVisibility", "ensureChildrenTransform", "needAnimationOptimization", "getAnimExceptCardIds", "getCollapsedAnimExceptCardIds", "getOutOfScreenCardIds", "getChildDrawingOrder", "childCount", "drawingPosition", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "checkLayoutParams", "p", "Landroid/view/ViewGroup$LayoutParams;", "generateLayoutParams", "generateDefaultLayoutParams", "Companion", "OnExpandStatusChangedListener", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatingCardContainer extends ViewGroup {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f460727h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f460728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f460729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f460730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f460731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.suite.lark.platform.component.widget.floatingpanel.impl.view.e f460732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f460733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f460734g;

    public static final class a {
    }

    public interface b {
        void O9(boolean r100);
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatingCardContainer f460735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f460736b;

        public c(FloatingCardContainer r100, String r101) {
            this.f460735a = r100;
            this.f460736b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.suite.lark.platform.component.widget.floatingpanel.impl.view.e r101 = this.f460735a.getOnFloatingCardClickListener();
            if (r101 == null) goto L6;
            Intrinsics.checkNotNull(r100);
            r101.a(r100, this.f460736b);
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f460737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FloatingCardContainer f460738b;

        public d(View r100, FloatingCardContainer r101) {
            this.f460737a = r100;
            this.f460738b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FloatingCardContainer r100 = this.f460738b;     // Catch: Throwable -> L4
            int r101 = FloatingCardContainer.f460727h;     // Catch: Throwable -> L4
            r100.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatingCardContainer f460739a;

        public e(FloatingCardContainer r100) {
            this.f460739a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            FloatingCardContainer r109 = this.f460739a;
            int r110 = FloatingCardContainer.f460727h;
            r109.c(false);
        }
    }

    static {
    }

    public FloatingCardContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FloatingCardContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        setExpanded(false);
        if (getChildCount() <= 0) goto L6;
        c(false);
        requestLayout();
        return;
    }

    public final void f() {
        setExpanded(true);
        if (getChildCount() <= 0) goto L6;
        c(g());
        requestLayout();
        return;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        return (r100 - 1) - r101;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public final void d() {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        int r100 = 0;
        if (this.f460734g == false) goto L11;
        int r101 = getChildCount();
    L8:
        if (r100 >= r101) goto L21;
        View r102 = getChildAt(r100);
        r102.setScaleX(1.0f);
        r102.setScaleY(1.0f);
        r102.setTranslationY(0.0f);
        r100 = r100 + 1;
        goto L8
    L21:
        return;
    L11:
        if (getMeasuredWidth() != 0) goto L14;
        OneShotPreDrawListener.add(this, new d(this, this));
        return;
    L14:
        int r103 = getChildAt(0).getMeasuredHeight();
        int r104 = getChildCount();
    L15:
        if (r100 >= r104) goto L26;
        View r105 = getChildAt(r100);
        float r106 = Math.min(r100, 2);
        float r107 = (getMeasuredWidth() - ((this.f460729b * 2) * r106)) / getMeasuredWidth();
        if (r100 >= 3) goto L19;
        int r108 = Math.min(r103, r105.getMeasuredHeight());
    L20:
        r105.setScaleX(r107);
        r105.setScaleY(r107);
        r105.setTranslationY(((this.f460728a * r106) + (r108 / 2)) - ((r108 * r107) / 2));
        r100 = r100 + 1;
        goto L15
    L19:
        r108 = r105.getMeasuredHeight();
        goto L20
    }

    public final boolean g() {
        if (getChildCount() <= 15) goto L5;
        return true;
    L5:
        return false;
    }

    public final List<Integer> getAnimExceptCardIds() {
        if (g() == false) goto L5;
        ArrayList r100 = new ArrayList();
        int r101 = getChildCount();
        int r102 = 15;
    L7:
        if (r102 >= r101) goto L9;
        r100.add(Integer.valueOf(getChildAt(r102).getId()));
        r102 = r102 + 1;
        goto L7
    L9:
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<Integer> getCollapsedAnimExceptCardIds() {
        if (g() == false) goto L5;
        ArrayList r100 = new ArrayList();
        int r101 = getChildCount();
        int r102 = 4;
    L7:
        if (r102 >= r101) goto L9;
        r100.add(Integer.valueOf(getChildAt(r102).getId()));
        r102 = r102 + 1;
        goto L7
    L9:
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<Integer> getOutOfScreenCardIds() {
        if (g() == false) goto L30;
        int r100 = 3;
        if (getChildCount() <= 3) goto L30;
        ArrayList r101 = new ArrayList();
        int[] r102 = new int[2];
        getRootView().getLocationInWindow(r102);
        int r103 = r102[1];
        int r104 = getRootView().getHeight() + r103;
        int[] r105 = new int[2];
        int r106 = getChildCount();
        boolean r107 = false;
    L8:
        if (r100 >= r106) goto L28;
        View r108 = getChildAt(r100);
        if (r107 == false) goto L12;
        r101.add(Integer.valueOf(r108.getId()));
    L27:
        r100 = r100 + 1;
        goto L8
    L12:
        r108.getLocationInWindow(r105);
        int r110 = r105[1];
        int r111 = r108.getHeight() + r110;
        if (r103 > r110) goto L16;
        if (r110 >= r104) goto L16;
        boolean r112 = true;
    L17:
        if (r112 == true) goto L27;
        if (r103 > r111) goto L21;
        if (r111 >= r104) goto L21;
        boolean r113 = true;
    L22:
        if (r113 == true) goto L27;
        if (r110 <= r104) goto L26;
        r107 = true;
    L26:
        r101.add(Integer.valueOf(r108.getId()));
    L21:
        r113 = false;
    L16:
        r112 = false;
        goto L17
    L28:
        return r101;
    L30:
        return CollectionsKt.emptyList();
    }

    public final b getOnExpandStatusChangedListener() {
        return this.f460733f;
    }

    public final com.suite.lark.platform.component.widget.floatingpanel.impl.view.e getOnFloatingCardClickListener() {
        return this.f460732e;
    }

    private final void setExpanded(boolean r100) {
        if (this.f460734g != r100) goto L5;
        return;
    L5:
        this.f460734g = r100;
        if (r100 == false) goto L15;
        int r101 = 0;
        this.f460731d = 0;
        int r102 = getChildCount();
    L8:
        if (r101 >= r102) goto L15;
        View r103 = getChildAt(r101);
        if ((r103 instanceof com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) == false) goto L14;
        if (((com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r103).getChildCount() <= 0) goto L14;
        this.f460731d++;
    L14:
        r101 = r101 + 1;
    L15:
        b r104 = this.f460733f;
        if (r104 == null) goto L23;
        r104.O9(r100);
        return;
    }

    public final void c(boolean r100) {
        e(r100);
        d();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof ViewGroup.MarginLayoutParams;
    }

    public final void e(boolean r100) {
        if (this.f460734g == false) goto L10;
        if (r100 == false) goto L6;
        int r101 = 15;
    L7:
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L17;
        getChildAt(r102).setVisibility(0);
        r102 = r102 + 1;
        goto L8
    L17:
        return;
    L6:
        r101 = getChildCount();
        goto L7
    L10:
        int r103 = getChildCount();
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L22;
        View r105 = getChildAt(r104);
        if (r104 >= 3) goto L15;
        int r106 = 0;
    L16:
        r105.setVisibility(r106);
        r104 = r104 + 1;
        goto L11
    L15:
        r106 = 4;
        goto L16
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    public final void h(List<? extends Pair<String, ? extends Function0<? extends View>>> r110) {
        Intrinsics.checkNotNullParameter(r110, "viewItems");
        StringBuilder r100 = new StringBuilder("refreshCards: count: ");
        ArrayList r111 = (ArrayList) r110;
        r100.append(r111.size());
        Log.i("FloatingCardContainer", r100.toString());
        LinkedHashMap r101 = new LinkedHashMap();
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        View r104 = getChildAt(r103);
        if ((r104 instanceof com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) == false) goto L9;
        String r105 = ((com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r104).getCardId();
        if (r105 == null) goto L9;
        r101.put(r105, r104);
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        removeAllViews();
        if (r111.size() <= 15) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == false) goto L16;
        setExpanded(false);
    L16:
        Iterator r112 = r111.iterator();
    L18:
        if (r112.hasNext() == false) goto L29;
        Pair r107 = (Pair) r112.next();
        String r108 = (String) r107.component1();
        Function0<? extends View> r109 = (Function0) r107.component2();
        com.suite.lark.platform.component.widget.floatingpanel.impl.view.d r113 = (com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r101.remove(r108);
        if (r113 != null) goto L21;
        if (getChildCount() < 3) goto L27;
        if (r106 == false) goto L27;
        b(null, r109, getChildCount(), r108);
    L27:
        b(r109.invoke(), null, getChildCount(), r108);
        goto L18
    L21:
        addView(r113);
        goto L18
    L29:
        if ((!r101.isEmpty()) == false) goto L36;
        Iterator r114 = r101.entrySet().iterator();
    L32:
        if (r114.hasNext() == false) goto L34;
        ((com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) ((Map.Entry) r114.next()).getValue()).removeAllViews();
        goto L32
    L34:
        r101.clear();
    L36:
        if (getChildCount() <= 0) goto L59;
        requestLayout();
        View r115 = getChildAt(0);
        if (r115.isLaidOut() == true) goto L40;
    L42:
        r115.addOnLayoutChangeListener(new e(this));
        return;
    L40:
        if (r115.isLayoutRequested() == true) goto L42;
        c(false);
        return;
    L59:
        return;
    L13:
        r106 = false;
        goto L14
    }

    public final void i(Function1<? super com.suite.lark.platform.component.widget.floatingpanel.impl.view.d, Boolean> r100) {
        int r101 = getChildCount();
    L3:
        r101 = r101 - 1;
        if ((-1) >= r101) goto L12;
        View r102 = getChildAt(r101);
        if ((r102 instanceof com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) == false) goto L3;
        if (r100 != null) goto L9;
    L10:
        ((com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r102).removeAllViews();
        removeView(r102);
        goto L3
    L9:
        if (r100.invoke(r102).booleanValue() == false) goto L3;
    }

    public final void setOnExpandStatusChangedListener(b r100) {
        this.f460733f = r100;
    }

    public final void setOnFloatingCardClickListener(com.suite.lark.platform.component.widget.floatingpanel.impl.view.e r100) {
        this.f460732e = r100;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new ViewGroup.MarginLayoutParams(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = 0;
        int r102 = Integer.MAX_VALUE;
        if (this.f460734g == false) goto L11;
        int r103 = getChildCount();
        int r104 = 0;
        int r105 = Integer.MAX_VALUE;
    L5:
        if (r101 >= r103) goto L10;
        View r112 = getChildAt(r101);
        measureChildWithMargins(r112, r110, 0, r111, 0);
        if (r112.getMeasuredHeight() <= 0) goto L9;
        r105 = Math.min(r112.getMeasuredHeight(), r105);
    L9:
        r104 = r104 + r112.getMeasuredHeight();
        r101 = r101 + 1;
        goto L5
    L10:
        setMeasuredDimension(r100, r104);
    L20:
        this.f460730c = r105;
        return;
    L11:
        int r106 = getChildCount();
        int r107 = 0;
        int r108 = 0;
    L12:
        if (r107 >= r106) goto L19;
        View r113 = getChildAt(r107);
        measureChildWithMargins(r113, r110, 0, r111, 0);
        if (r113.getMeasuredHeight() <= 0) goto L16;
        r102 = Math.min(r113.getMeasuredHeight(), r102);
    L16:
        if (r107 != 0) goto L18;
        r108 = r113.getMeasuredHeight();
    L18:
        r107 = r107 + 1;
        goto L12
    L19:
        setMeasuredDimension(r100, r108 + (Math.max(0, Math.min(getChildCount(), 3) - 1) * this.f460728a));
        r105 = r102;
        goto L20
    }

    public FloatingCardContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f460728a = UIUtils.dp2px(r100, 8.0f);
        this.f460729b = UIUtils.dp2px(r100, 12.0f);
        setChildrenDrawingOrderEnabled(true);
    }

    public /* synthetic */ FloatingCardContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final com.suite.lark.platform.component.widget.floatingpanel.impl.view.d b(View r100, Function0<? extends View> r101, int r102, String r103) {
        com.suite.lark.platform.component.widget.floatingpanel.impl.view.d r104 = new com.suite.lark.platform.component.widget.floatingpanel.impl.view.d(getContext());
        r104.setCardId(r103);
        if (r100 == null) goto L5;
        r104.a(r100);
    L5:
        if (r101 != null) goto L7;
    L11:
        r104.setOnClickListener(new c(this, r103));
        addView(r104, r102, new ViewGroup.MarginLayoutParams(-1, -2));
        return r104;
    L7:
        if (r102 >= 15) goto L9;
        boolean r105 = true;
    L10:
        r104.c(r101, r105);
        goto L11
    L9:
        r105 = false;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.f460734g == false) goto L10;
        int r105 = getChildCount();
        int r106 = 0;
        int r107 = 0;
    L8:
        if (r106 >= r105) goto L17;
        View r108 = getChildAt(r106);
        r108.layout(0, r107, r108.getMeasuredWidth(), r108.getMeasuredHeight() + r107);
        r107 = r107 + r108.getMeasuredHeight();
        r106 = r106 + 1;
        goto L8
    L17:
        return;
    L10:
        int r109 = getChildAt(0).getMeasuredHeight();
        int r110 = getChildCount();
        int r111 = 0;
    L11:
        if (r111 >= r110) goto L22;
        View r112 = getChildAt(r111);
        if (r111 >= 3) goto L15;
        int r113 = Math.min(r109, r112.getMeasuredHeight());
    L16:
        r112.layout(0, r109 - r113, r112.getMeasuredWidth(), r109);
        r111 = r111 + 1;
        goto L11
    L15:
        r113 = r112.getMeasuredHeight();
        goto L16
    }
}
