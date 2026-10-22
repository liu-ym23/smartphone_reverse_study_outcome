package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.google.android.material.card.MaterialCardView;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/GestureCardView;", "Lcom/google/android/material/card/MaterialCardView;", "Lcom/larus/common_ui/widget/ILastMotionView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastMotionX", "", "getLastMotionX", "()Ljava/lang/Float;", "lastMotionY", "getLastMotionY", "lastMotionGesture", "Lcom/larus/common_ui/widget/LastMotionViewDelegate;", "isLongPressTriggered", "", "handler", "Landroid/os/Handler;", "touchSlop", "lastDownX", "Ljava/lang/Float;", "lastDownY", "longPressRunnable", "Ljava/lang/Runnable;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GestureCardView extends MaterialCardView implements z19.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z19.r f304816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f304817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f304818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f304819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Float f304820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Float f304821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g0 f304822g;

    public static final class a {
    }

    static {
    }

    public GestureCardView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GestureCardView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // z19.j
    public Float getLastMotionX() {
        return this.f304816a.f569704a;
    }

    @Override // z19.j
    public Float getLastMotionY() {
        return this.f304816a.f569705b;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        this.f304820e = Float.valueOf(r100.getX());
        this.f304821f = Float.valueOf(r100.getY());
        this.f304817b = false;
        this.f304818c.postDelayed(this.f304822g, ViewConfiguration.getLongPressTimeout());
    L22:
        this.f304816a.a(r100);
        return this.f304817b;
    L5:
        if (r101 != 1) goto L7;
        this.f304820e = null;
        this.f304821f = null;
        this.f304818c.removeCallbacks(this.f304822g);
        goto L22
    L7:
        if (r101 != 2) goto L9;
        Float r102 = this.f304820e;
        Float r103 = this.f304821f;
        if (r102 != null) goto L15;
    L16:
        if (r103 == null) goto L22;
        if (Math.abs(r100.getY() - r103.floatValue()) <= this.f304819d) goto L22;
    L19:
        this.f304818c.removeCallbacks(this.f304822g);
        goto L22
    L15:
        if (Math.abs(r100.getX() - r102.floatValue()) > this.f304819d) goto L19;
    L9:
        if (r101 == 3) goto L11;
        FLogger.f375446a.d("SlopXXX", "event: " + r100.getAction() + ", x: " + r100.getX() + ", y: " + r100.getY());
        goto L22
    L11:
        this.f304818c.removeCallbacks(this.f304822g);
        goto L22
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.bmhome.chat.layout.widget.g0] */
    public GestureCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f304816a = new z19.r();
        this.f304818c = new Handler(Looper.getMainLooper());
        this.f304819d = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f304822g = new g0(this);
    }

    public /* synthetic */ GestureCardView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
