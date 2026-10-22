package com.larus.agents.impl.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.core.widget.NestedScrollView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/agents/impl/ui/OfficeTaskPreferenceScrollView;", "Landroidx/core/widget/NestedScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isParentLocked", "", "nestedScrollingBeforeGesture", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "lockParentForScrollableContent", "", "keepParentLocked", "releaseParentLock", "onDetachedFromWindow", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeTaskPreferenceScrollView extends NestedScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f286728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f286729b;

    public final void e() {
        if (this.f286728a == true) goto L5;
        return;
    L5:
        setNestedScrollingEnabled(this.f286729b);
        ViewParent r100 = getParent();
        if (r100 == null) goto L8;
        r100.requestDisallowInterceptTouchEvent(false);
    L8:
        this.f286728a = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        e();
        super.onDetachedFromWindow();
    }

    public OfficeTaskPreferenceScrollView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f286729b = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L5;
        e();
        if (canScrollVertically(-1) == false) goto L15;
    L18:
        boolean r102 = true;
    L19:
        this.f286728a = r102;
        if (r102 == false) goto L27;
        this.f286729b = isNestedScrollingEnabled();
        setNestedScrollingEnabled(false);
        if (this.f286728a == false) goto L27;
        ViewParent r103 = getParent();
        if (r103 == null) goto L27;
        r103.requestDisallowInterceptTouchEvent(true);
    L27:
        boolean r104 = super.dispatchTouchEvent(r100);
        int r105 = r100.getActionMasked();
        if (r105 != 1) goto L30;
    L32:
        e();
    L33:
        return r104;
    L30:
        if (r105 == 3) goto L32;
    L15:
        if (canScrollVertically(1) == true) goto L18;
        r102 = false;
        goto L19
    L5:
        if (r101 != 2) goto L27;
        if (this.f286728a == false) goto L27;
        ViewParent r106 = getParent();
        if (r106 == null) goto L27;
        r106.requestDisallowInterceptTouchEvent(true);
        goto L27
    }

    public OfficeTaskPreferenceScrollView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f286729b = true;
    }

    public OfficeTaskPreferenceScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f286729b = true;
    }
}
