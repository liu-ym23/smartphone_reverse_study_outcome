package com.ss.android.lark.biz.im.extension.panel.drag.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\u0013J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u001aH\u0016J(\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Lcom/ss/android/lark/biz/im/extension/panel/drag/view/DragPanelContainerLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dependency", "Lcom/ss/android/lark/biz/im/extension/panel/drag/view/IPanelContainerDependency;", "disableTapDismiss", "", "getDisableTapDismiss", "()Z", "setDisableTapDismiss", "(Z)V", "setPanelDependency", "", "closePanelImmediately", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "onSizeChanged", "w", "h", "oldw", "oldh", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DragPanelContainerLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f410564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f410565b;

    public DragPanelContainerLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DragPanelContainerLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final boolean getDisableTapDismiss() {
        return this.f410565b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L13;
        a r102 = this.f410564a;
        if (r102 == null) goto L11;
        r102.onBackPressed();
    L11:
        return true;
    L13:
        return super.dispatchKeyEvent(r100);
    L5:
        if (r100.getKeyCode() != 4) goto L7;
        r101 = true;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        if (r101 == 0) goto L9;
        if (r101 != 1) goto L6;
    L8:
        getParent().requestDisallowInterceptTouchEvent(false);
    L11:
        return super.onInterceptTouchEvent(r100);
    L6:
        if (r101 == 3) goto L8;
    L9:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L11
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getAction() != 1) goto L9;
        getParent().requestDisallowInterceptTouchEvent(false);
        if (this.f410565b == true) goto L12;
        Log.i("DragPanelContainerLayout", "action up -> click");
        performClick();
        return true;
    L12:
        return super.onTouchEvent(r100);
    L9:
        if (r100.getAction() != 3) goto L12;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L12
    }

    public final void setDisableTapDismiss(boolean r100) {
        this.f410565b = r100;
    }

    public final void setPanelDependency(a r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        this.f410564a = r100;
    }

    public DragPanelContainerLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setFocusableInTouchMode(true);
        this.f410565b = FeatureGatingModule.getFeatureGatingService().isEnable("lark.knowledge_ai.mobile_disable_tap_dismiss");
    }

    public /* synthetic */ DragPanelContainerLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r101 == r103) goto L9;
        if (r103 == 0) goto L10;
        a r104 = this.f410564a;
        if (r104 == null) goto L11;
        r104.a();
        return;
    L11:
        return;
    L10:
        return;
    }
}
