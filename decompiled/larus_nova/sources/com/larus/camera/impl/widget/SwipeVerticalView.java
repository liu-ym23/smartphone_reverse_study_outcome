package com.larus.camera.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/camera/impl/widget/SwipeVerticalView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startX", "", "startY", "swipeListener", "Lcom/larus/camera/impl/widget/OnSwipeListener;", "setOnSwipeListener", "", "listener", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "isInMovingMode", "onTouchEvent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwipeVerticalView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f322882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f322883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f322884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f322885d;

    public static final class a {
    }

    static {
    }

    public SwipeVerticalView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SwipeVerticalView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        if (r101 == 0) goto L26;
        if (r101 != 1) goto L6;
        this.f322885d = false;
    L25:
        return super.onTouchEvent(r100);
    L6:
        if (r101 != 2) goto L25;
        float r102 = r100.getRawX() - this.f322882a;
        float r103 = r100.getRawY() - this.f322883b;
        if (Math.abs(r103) > Math.abs(r102)) goto L11;
    L22:
        return true;
    L11:
        if (this.f322885d == true) goto L22;
        if (r103 <= 20.0f) goto L18;
        this.f322885d = true;
        p r104 = this.f322884c;
        if (r104 == null) goto L22;
        r104.b();
        goto L22
    L18:
        if (r103 >= (-20.0f)) goto L22;
        this.f322885d = true;
        p r105 = this.f322884c;
        if (r105 == null) goto L22;
        r105.a();
        goto L22
    L26:
        this.f322882a = r100.getRawX();
        this.f322883b = r100.getRawY();
        this.f322885d = false;
        return true;
    }

    public final void setOnSwipeListener(p r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f322884c = r100;
    }

    public SwipeVerticalView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ SwipeVerticalView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
