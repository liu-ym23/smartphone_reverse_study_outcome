package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0014J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J(\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0011H\u0014J\u0006\u0010\"\u001a\u00020\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingPanelScrollView;", "Landroid/widget/ScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onScrollChangedListener", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingPanelScrollView$OnScrollChangedListener;", "getOnScrollChangedListener", "()Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingPanelScrollView$OnScrollChangedListener;", "setOnScrollChangedListener", "(Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingPanelScrollView$OnScrollChangedListener;)V", "isFlingingToBottom", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onScrollChanged", "", "l", "t", "oldl", "oldt", "fling", "velocityY", "onOverScrolled", "scrollX", "scrollY", "clampedX", "clampedY", "stopFlingAndScrollToTop", "OnScrollChangedListener", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatingPanelScrollView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f460749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f460750b;

    public interface a {
        void a(FloatingPanelScrollView r100, int r101, int r102);
    }

    public FloatingPanelScrollView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FloatingPanelScrollView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final a getOnScrollChangedListener() {
        return this.f460749a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getActionMasked());
    L5:
        if (r101 == null) goto L11;
        if (r101.intValue() != 0) goto L11;
        this.f460750b = false;
    L11:
        return super.dispatchTouchEvent(r100);
    L4:
        r101 = null;
        goto L5
    }

    @Override // android.widget.ScrollView
    public final void fling(int r100) {
        super.fling(r100);
        if (r100 <= 0) goto L5;
        boolean r101 = true;
    L6:
        this.f460750b = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setOnScrollChangedListener(a r100) {
        this.f460749a = r100;
    }

    public FloatingPanelScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ FloatingPanelScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void onOverScrolled(int r100, int r101, boolean r102, boolean r103) {
        if (this.f460750b == true) goto L5;
    L7:
        super.onOverScrolled(r100, r101, r102, r103);
        return;
    L5:
        if (r101 >= getScrollY()) goto L7;
        super.onOverScrolled(r100, getScrollY(), r102, false);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        a r104 = this.f460749a;
        if (r104 == null) goto L6;
        r104.a(this, r101, r103);
        return;
    }
}
