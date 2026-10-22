package com.ss.android.lark.movable.island;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.movable.MovableView;
import com.ss.android.lark.movable.utils.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import jsb.a;
import jsb.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&J\u0006\u0010'\u001a\u00020\u001aR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/movable/island/ScrollIsland;", "Landroid/widget/HorizontalScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "islandID", "getIslandID", "()I", "setIslandID", "(I)V", "innerMovableView", "Lcom/ss/android/lark/movable/MovableView;", "getInnerMovableView", "()Lcom/ss/android/lark/movable/MovableView;", "rootMovableView", "radius", "", "borderWidth", "borderDrawable", "Landroid/graphics/drawable/GradientDrawable;", "makeRoundCorner", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "setParentInfo", "updateSize", "info", "Lcom/ss/android/lark/movable/island/IslandInfo;", "triggerIslandRender", "renderData", "", "documentInfo", "Lcom/bytedance/lark/lark_markdown_render_android/MovableDocumentInfo;", "cleanup", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScrollIsland extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f432677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MovableView f432678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f432679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GradientDrawable f432680d;

    public ScrollIsland(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ScrollIsland(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final MovableView getInnerMovableView() {
        return this.f432678b;
    }

    public final int getIslandID() {
        return this.f432677a;
    }

    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101 == null) goto L11;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        r102.width = (int) r100.f500273d;
        r102.height = (int) r100.f500274e;
        r102.leftMargin = (int) r100.f500271b;
        r102.topMargin = (int) r100.f500272c;
        setLayoutParams(r102);
        MovableView r103 = this.f432678b;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L9;
        r104.width = (int) r100.f500275f;
        r104.height = (int) r100.f500276g;
        r103.setLayoutParams(r104);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        float r101 = getScrollX();
        float r102 = getScrollY();
        int r103 = r100.save();
        r100.translate(r101, r102);
        this.f432680d.setBounds(0, 0, r100.getWidth(), r100.getHeight());     // Catch: Throwable -> L6
        this.f432680d.draw(r100);     // Catch: Throwable -> L6
        r100.restoreToCount(r103);
        return;
    L6:
        th = move-exception;
        r100.restoreToCount(r103);
        throw th;
    }

    public final void setIslandID(int r100) {
        this.f432677a = r100;
    }

    public final void setParentInfo(MovableView r100) {
        MovableView r101 = this.f432678b;
        r101.f432578r = this;
        r101.f432579s = r100;
    }

    public ScrollIsland(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        MovableView r103 = new MovableView(r100, null);
        this.f432678b = r103;
        addView(r103);
        setClipChildren(false);
        setOutlineProvider(new c(this));
        setClipToOutline(true);
        setOverScrollMode(2);
        float r104 = e.a(8);
        this.f432679c = r104;
        int r105 = e.a(1);
        GradientDrawable r106 = new GradientDrawable();
        r106.setShape(0);
        r106.setCornerRadius(r104);
        r106.setStroke(r105, UDColorUtils.getColor(r100, R.color.line_border_card));
        r106.setColor(UDColorUtils.getColor(r100, android.R.color.transparent));
        this.f432680d = r106;
    }

    public /* synthetic */ ScrollIsland(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = android.R.attr.horizontalScrollViewStyle;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }
}
