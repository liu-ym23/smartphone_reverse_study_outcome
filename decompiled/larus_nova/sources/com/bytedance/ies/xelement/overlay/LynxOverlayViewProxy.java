package com.bytedance.ies.xelement.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.k;
import com.lynx.tasm.behavior.x0;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@LynxBehavior(isCreateAsync = false, tagName = {"x-overlay"})
@LynxGeneratorName(packageName = "com.bytedance.ies.xelement.overlay")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/xelement/overlay/LynxOverlayViewProxy;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/lynx/tasm/behavior/ui/view/a;", "Lcom/lynx/tasm/behavior/ui/d;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-overlay_release"}, k = 1, mv = {1, 6, 0})
public final class LynxOverlayViewProxy extends UIGroup<com.lynx.tasm.behavior.ui.view.a> implements com.lynx.tasm.behavior.ui.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxOverlayView f250200a;

    public static final class a {
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean isUserInteractionEnabled() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final int getChildCount() {
        return this.f250200a.getChildCount();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final List<LynxBaseUI> getChildren() {
        return this.f250200a.getChildren();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onAnimationUpdated() {
        this.f250200a.onAnimationUpdated();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDetach() {
        this.f250200a.onDetach();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        super.layout();
        this.f250200a.layout();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        super.measure();
        this.f250200a.measure();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final LynxUI<?> getTransitionUI() {
        return this.f250200a;
    }

    public LynxOverlayViewProxy(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void afterPropsUpdated(x0 r100) {
        this.f250200a.afterPropsUpdated(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new g(r100, this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final LynxBaseUI getChildAt(int r100) {
        return this.f250200a.getChildAt(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void insertView(LynxUI<?> r100) {
        this.f250200a.insertView(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r100) {
        this.f250200a.removeChild(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void removeView(LynxBaseUI r100) {
        this.f250200a.removeView(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setBackgroundColor(int r100) {
        this.f250200a.setBackgroundColor(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setParent(k r100) {
        super.setParent(r100);
        this.f250200a.setParent(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateExtraData(Object r100) {
        this.f250200a.updateExtraData(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateLayoutInfo(LynxBaseUI r100) {
        super.updateLayoutInfo(r100);
        this.f250200a.updateLayoutInfo(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updatePropertiesInterval(x0 r100) {
        this.f250200a.updatePropertiesInterval(r100);
    }

    public LynxOverlayViewProxy(LynxContext r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f250200a = new LynxOverlayView(r100, this);
        super.insertChild(this.f250200a, 0);
        DisplayMetrics r102 = new DisplayMetrics();
        Activity r103 = com.lynx.tasm.utils.a.getActivity(r100);
        if (r103 == null) goto L5;
        r103.getWindowManager().getDefaultDisplay().getMetrics(r102);
        return;
    L5:
        LLog.e("LynxOverlayViewProxy", "context is not Activity!");
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r100, int r101) {
        this.f250200a.insertChild(r100, r101);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final void insertDrawList(LynxBaseUI r100, LynxBaseUI r101) {
        this.f250200a.insertDrawList(r100, r101);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setSign(int r100, String r101) {
        super.setSign(r100, r101);
        this.f250200a.setSign(r100, r101);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean updateDrawingLayoutInfo(int r100, int r101, Rect r102) {
        super.updateDrawingLayoutInfo(r100, r101, r102);
        return this.f250200a.updateDrawingLayoutInfo(r100, r101, r102);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateLayout(int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, int r218, int r219, int r310, int r311, int r312, int r313, int r314, int r315, Rect r316) {
        super.updateLayout(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
        this.f250200a.updateLayout(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }
}
