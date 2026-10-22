package com.ss.android.lark.movable.selection;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.movable.selection.d f432766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f432767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewTreeObserverOnDrawListenerC5142b f432768c;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f432769a;

        public a(b r100) {
            this.f432769a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            b r102 = this.f432769a;
            Intrinsics.checkNotNull(r101);
            View r103 = r102.f432766a.getView();
            r103.getLocationOnScreen(r102.f432767b);
            MotionEvent r104 = MotionEvent.obtain(r101);
            r104.offsetLocation((r101.getRawX() - r102.f432767b[0]) - r101.getX(), (r101.getRawY() - r102.f432767b[1]) - r101.getY());
            boolean r105 = r103.dispatchTouchEvent(r104);     // Catch: Throwable -> L6
            r104.recycle();
            return r105;
        L6:
            th = move-exception;
            r104.recycle();
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.movable.selection.b$b, reason: collision with other inner class name */
    public static final class ViewTreeObserverOnDrawListenerC5142b implements ViewTreeObserver.OnDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f432770a;

        public ViewTreeObserverOnDrawListenerC5142b(b r100) {
            this.f432770a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            this.f432770a.invalidate();
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f432771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f432772b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            this.f432771a.removeOnAttachStateChangeListener(this);
            this.f432772b.f432766a.getView().getViewTreeObserver().addOnDrawListener(this.f432772b.f432768c);
        }

        public c(View r100, b r101) {
            this.f432771a = r100;
            this.f432772b = r101;
        }
    }

    public static final class d implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f432773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f432774b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            this.f432773a.removeOnAttachStateChangeListener(this);
            this.f432774b.f432766a.getView().getViewTreeObserver().removeOnDrawListener(this.f432774b.f432768c);
        }

        public d(View r100, b r101) {
            this.f432773a = r100;
            this.f432774b = r101;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        this.f432766a.setIsGhost(false);
        this.f432766a.getView().draw(r100);
        this.f432766a.setIsGhost(true);
    }

    public b(Context r100, com.ss.android.lark.movable.selection.d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, PlayerResolution.SDKKEY.ORIGIN);
        super(r100);
        this.f432766a = r101;
        this.f432767b = new int[2];
        ViewTreeObserverOnDrawListenerC5142b r102 = new ViewTreeObserverOnDrawListenerC5142b(this);
        this.f432768c = r102;
        if (isAttachedToWindow() == false) goto L5;
        r101.getView().getViewTreeObserver().addOnDrawListener(r102);
    L7:
        if (isAttachedToWindow() == true) goto L9;
        r101.getView().getViewTreeObserver().removeOnDrawListener(r102);
    L10:
        setOnTouchListener(new a(this));
        return;
    L9:
        addOnAttachStateChangeListener(new d(this, this));
        goto L10
    L5:
        addOnAttachStateChangeListener(new c(this, this));
        goto L7
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        View r102 = this.f432766a.getView();
        Integer r103 = Integer.valueOf(r102.getWidth());
        boolean r104 = true;
        if (r103.intValue() <= 0) goto L5;
        boolean r105 = true;
    L6:
        Integer r106 = null;
        if (r105 == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L12;
        int r107 = r103.intValue();
    L13:
        Integer r108 = Integer.valueOf(r102.getHeight());
        if (r108.intValue() > 0) goto L17;
        r104 = false;
    L17:
        if (r104 == false) goto L19;
        r106 = r108;
    L19:
        if (r106 == null) goto L21;
        int r109 = r106.intValue();
    L22:
        setMeasuredDimension(r107, r109);
        return;
    L21:
        r109 = r102.getMeasuredHeight();
        goto L22
    L12:
        r107 = r102.getMeasuredWidth();
        goto L13
    L5:
        r105 = false;
        goto L6
    }
}
