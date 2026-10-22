package com.ss.android.lark.keyboard.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/keyboard/widget/NestScrollFrameLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "targetView", "Landroid/view/ViewGroup;", "getTargetView", "()Landroid/view/ViewGroup;", "setTargetView", "(Landroid/view/ViewGroup;)V", "startX", "startY", LynxViewpagerItem.BIND_ON_ATTACH, "", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestScrollFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f431003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f431004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f431005c;

    public final ViewGroup getTargetView() {
        return this.f431003a;
    }

    public NestScrollFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L23;
        int r101 = r100.getAction();
        if (r101 == 0) goto L19;
        if (r101 != 1) goto L7;
    L16:
        ViewGroup r102 = this.f431003a;
        if (r102 == null) goto L23;
        r102.requestDisallowInterceptTouchEvent(false);
        goto L23
    L7:
        if (r101 != 2) goto L9;
        int r103 = (int) r100.getX();
        int r104 = (int) r100.getY();
        if (Math.abs(r103 - this.f431004b) <= Math.abs(r104 - this.f431005c)) goto L23;
        ViewGroup r105 = this.f431003a;
        if (r105 == null) goto L23;
        r105.requestDisallowInterceptTouchEvent(true);
        goto L23
    L9:
        if (r101 == 3) goto L16;
    L19:
        this.f431004b = (int) r100.getX();
        this.f431005c = (int) r100.getY();
        ViewGroup r106 = this.f431003a;
        if (r106 == null) goto L23;
        r106.requestDisallowInterceptTouchEvent(true);
    L23:
        return super.dispatchTouchEvent(r100);
    }

    public final void setTargetView(ViewGroup r100) {
        this.f431003a = r100;
    }

    public NestScrollFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, -1);
    }

    public NestScrollFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f431004b = -1;
        this.f431005c = -1;
    }
}
