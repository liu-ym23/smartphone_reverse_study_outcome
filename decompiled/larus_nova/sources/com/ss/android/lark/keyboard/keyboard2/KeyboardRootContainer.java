package com.ss.android.lark.keyboard.keyboard2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fJ\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\r\u0010\u0018\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0019J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/keyboard/keyboard2/KeyboardRootContainer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastX", "", "lastY", "interceptClick", "", "touchSlop", "lastWidthMeasureSpec", "lastHeightMeasureSpec", "", "intercept", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "reMeasure", "reMeasure$keyboard_base_release", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardRootContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f429492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f429493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f429494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f429495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f429496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f429497f;

    public KeyboardRootContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public KeyboardRootContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public KeyboardRootContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getActionMasked());
    L5:
        if (r101 != null) goto L8;
    L10:
        if (r101 != null) goto L13;
    L21:
        return super.dispatchTouchEvent(r100);
    L13:
        if (r101.intValue() != 1) goto L21;
        double r102 = 2;
        float r103 = ((float) Math.pow(r100.getRawX() - this.f429492a, r102)) + ((float) Math.pow(r100.getRawY() - this.f429493b, r102));
        if (this.f429494c == false) goto L21;
        int r104 = this.f429495d;
        if (r103 >= (r104 * r104)) goto L21;
        Log.i(ObricActionBarTrackType.KEY_BOARD, "KeyboardRootContainer: intercept click");
        this.f429492a = 0.0f;
        this.f429493b = 0.0f;
        MotionEvent r105 = MotionEvent.obtain(r100);
        r105.setAction(3);
        super.dispatchTouchEvent(r105);
        return true;
    L8:
        if (r101.intValue() != 0) goto L10;
        this.f429492a = r100.getRawX();
        this.f429493b = r100.getRawY();
        goto L21
    L4:
        r101 = null;
        goto L5
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f429496e = r100;
        this.f429497f = r101;
    }

    public KeyboardRootContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f429495d = ViewConfiguration.get(r100).getScaledTouchSlop() * 3;
    }
}
