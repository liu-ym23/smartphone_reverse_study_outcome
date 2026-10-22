package com.larus.common_ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/larus/common_ui/view/SlideDismissView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "touchSlop", "dismissOffset", "", "startX", "startY", "dismissCallback", "Lkotlin/Function0;", "", "getDismissCallback", "()Lkotlin/jvm/functions/Function0;", "setDismissCallback", "(Lkotlin/jvm/functions/Function0;)V", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlideDismissView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f328255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f328256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f328257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f328258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f328259e;

    public SlideDismissView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SlideDismissView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Function0<Unit> getDismissCallback() {
        return this.f328259e;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L5;
        this.f328257c = r100.getX();
        this.f328258d = r100.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L24:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (r101 != 1) goto L7;
    L21:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L24
    L7:
        if (r101 != 2) goto L9;
        float r102 = r100.getX() - this.f328257c;
        float r103 = r100.getY() - this.f328258d;
        if (Math.abs(r103) > this.f328255a) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L20;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L20:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L24
    L14:
        if (Math.abs(r103) <= Math.abs(r102)) goto L16;
        r104 = true;
        goto L17
    L9:
        if (r101 == 3) goto L21;
        goto L21
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getActionMasked() != 2) goto L21;
        float r101 = r100.getX() - this.f328257c;
        float r102 = r100.getY() - this.f328258d;
        if (Math.abs(r102) > this.f328255a) goto L7;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L19;
        Function0<Unit> r104 = this.f328259e;
        if (r104 == null) goto L18;
        r104.invoke();
    L18:
        return true;
    L19:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L21
    L7:
        if (Math.abs(r102) <= this.f328256b) goto L13;
        if (Math.abs(r102) <= Math.abs(r101)) goto L13;
        if (r102 <= 0.0f) goto L13;
        r103 = true;
    L21:
        return super.onTouchEvent(r100);
    }

    public final void setDismissCallback(Function0<Unit> r100) {
        this.f328259e = r100;
    }

    public SlideDismissView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328255a = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f328256b = 150.0f;
    }

    public /* synthetic */ SlideDismissView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
