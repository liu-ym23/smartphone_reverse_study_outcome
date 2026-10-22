package com.bytedance.ies.xelement;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll;
import com.lynx.tasm.event.EventsListener;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
@LynxBehavior(isCreateAsync = true, tagName = {"x-nested-scroll-view", "nested-scroll-view"})
@LynxGeneratorName(packageName = "com.bytedance.ies.xelement.nested.scrollview")
public class LynxNestedScrollView extends AbsLynxUIScroll<AndroidNestedScrollView> implements AndroidNestedScrollView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f249644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f249645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f249646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f249647d;

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void M(LynxBaseUI r100, boolean r101, String r102, String r103) {
    }

    @Override // com.bytedance.ies.xelement.AndroidNestedScrollView.a
    public final void a() {
    }

    @Override // com.bytedance.ies.xelement.AndroidNestedScrollView.a
    public final void b() {
    }

    @Override // com.bytedance.ies.xelement.AndroidNestedScrollView.a
    public final void d() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBoundRectForOverflow() {
        return null;
    }

    @Override // com.bytedance.ies.xelement.AndroidNestedScrollView.a
    public final void onScrollStateChanged(int r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void scrollToIndex(int r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setLowerThreshole(int r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollLeft(int r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTop(int r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setUpperThreshole(int r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollX() {
        return ((AndroidNestedScrollView) this.mView).getHScrollView().getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollY() {
        return ((AndroidNestedScrollView) this.mView).getScrollY();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.k
    public final void invalidate() {
        ((AndroidNestedScrollView) this.mView).getLinearLayout().invalidate();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        int r100 = 0;
        if (((AndroidNestedScrollView) this.mView).getOrientation() != 0) goto L5;
        boolean r101 = true;
    L6:
        int r102 = getWidth();
        int r103 = getHeight();
    L8:
        if (r100 >= getChildCount()) goto L14;
        LynxBaseUI r104 = getChildAt(r100);
        if (r101 == false) goto L12;
        r102 = Math.max(r102, r104.getWidth() + r104.getLeft());
    L13:
        r100 = r100 + 1;
        goto L8
    L12:
        r103 = Math.max(r103, r104.getHeight() + r104.getTop());
        goto L13
    L14:
        AndroidNestedScrollView r105 = (AndroidNestedScrollView) this.mView;
        r105.f249574h = r103;
        r105.f249573g = r102;
        a r106 = r105.f249567a;
        if (r106 == null) goto L17;
        r106.requestLayout();
    L17:
        super.measure();
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r100 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r101 = this.mPaddingRight + this.mBorderRightWidth;
        int r102 = this.mPaddingTop + this.mBorderTopWidth;
        int r103 = this.mPaddingBottom + this.mBorderBottomWidth;
        ((AndroidNestedScrollView) this.mView).setPadding(r100, r102, r101, r103);
    }

    public LynxNestedScrollView(LynxContext r100) {
        super(r100, null);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void N(boolean r100) {
        if ((!r100) == false) goto L5;
        ((AndroidNestedScrollView) this.mView).setOrientation(1);
        return;
    L5:
        ((AndroidNestedScrollView) this.mView).setOrientation(0);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void O(boolean r100) {
        if (r100 == false) goto L4;
        ((AndroidNestedScrollView) this.mView).setOrientation(1);
        return;
    L4:
        ((AndroidNestedScrollView) this.mView).setOrientation(0);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        AndroidNestedScrollView r101 = new AndroidNestedScrollView(r100);
        r101.setOnScrollListener(new k(this));
        return r101;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        this.f249644a = false;
        this.f249645b = false;
        this.f249646c = false;
        if (r100.containsKey("scrolltolower") == false) goto L9;
        this.f249645b = true;
    L9:
        if (r100.containsKey("scrolltoupper") == false) goto L12;
        this.f249644a = true;
    L12:
        if (r100.containsKey(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL) == false) goto L15;
        this.f249646c = true;
    L15:
        if (this.f249645b == false) goto L17;
    L20:
        ((AndroidNestedScrollView) this.mView).setOnScrollListener(this);
        return;
    L17:
        if (this.f249644a == true) goto L20;
        if (this.f249646c == true) goto L20;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollBarEnable(boolean r100) {
        ((AndroidNestedScrollView) this.mView).setScrollBarEnable(Boolean.valueOf(r100).booleanValue());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("UIScrollView", e.getMessage());
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTap(boolean r100) {
        this.f249647d = r100;
    }

    public LynxNestedScrollView(LynxContext r100, Object r101) {
        super(r100, r101);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void drawChild(LynxFlattenUI r100, Canvas r101) {
        r100.draw(r101);
    }

    @Override // com.bytedance.ies.xelement.AndroidNestedScrollView.a
    public final void onScrollChanged(int r100, int r101, int r110, int r111) {
        if (this.f249646c == false) goto L6;
        P(r100, r101, r110, r111, GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);
    L6:
        if (r100 != r110) goto L21;
        if (r100 != 0) goto L21;
        if (r101 == 0) goto L10;
        View r102 = ((AndroidNestedScrollView) this.mView).getChildAt(0);
        if (r102 != null) goto L16;
        return;
    L16:
        if (r102.getMeasuredHeight() == (getScrollY() + ((AndroidNestedScrollView) this.mView).getMeasuredHeight())) goto L18;
        return;
    L18:
        if (this.f249645b == false) goto L42;
        P(r100, r101, r110, r111, "scrolltolower");
        return;
    L42:
        return;
    L10:
        if (this.f249644a == false) goto L41;
        P(r100, r101, r110, r111, "scrolltoupper");
        return;
    L41:
        return;
    L21:
        if (r101 != r111) goto L45;
        if (r101 != 0) goto L46;
        if (r100 == 0) goto L38;
        if (r100 <= 0) goto L28;
        if (r110 == 0) goto L38;
    L28:
        if (((AndroidNestedScrollView) this.mView).getHScrollView() == null) goto L47;
        View r103 = ((AndroidNestedScrollView) this.mView).getHScrollView().getChildAt(0);
        if (r103 != null) goto L32;
        return;
    L32:
        if (r100 == (r103.getMeasuredWidth() - ((AndroidNestedScrollView) this.mView).getMeasuredWidth())) goto L34;
        return;
    L34:
        if (this.f249645b == false) goto L50;
        P(r100, r101, r110, r111, "scrolltolower");
        return;
    L50:
        return;
    L47:
        return;
    L38:
        if (this.f249644a == false) goto L51;
        P(r100, r101, r110, r111, "scrolltoupper");
        return;
    L51:
        return;
    L46:
        return;
    }

    public final void P(int r110, int r111, int r112, int r113, String r114) {
        m7a.e r100 = new m7a.e(getSign(), r114);
        r100.d(r110, r111, ((AndroidNestedScrollView) this.mView).getContentHeight(), ((AndroidNestedScrollView) this.mView).getContentWidth(), r112 - r110, r113 - r111);
        if (getLynxContext() == null) goto L6;
        getLynxContext().getEventEmitter().sendCustomEvent(r100);
        return;
    }
}
