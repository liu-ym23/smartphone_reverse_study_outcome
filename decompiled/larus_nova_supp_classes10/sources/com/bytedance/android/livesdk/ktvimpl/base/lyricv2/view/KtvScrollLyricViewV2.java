package com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R6\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyricv2/view/KtvScrollLyricViewV2;", "Landroidx/recyclerview/widget/RecyclerView;", "", "getTopFadingEdgeStrength", "Lkotlin/Function2;", "", "", "c", "Lkotlin/jvm/functions/Function2;", "getOnSizeChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnSizeChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "onSizeChangedListener", "", "g", "Z", "getFadingEdgeEnable", "()Z", "setFadingEdgeEnable", "(Z)V", "fadingEdgeEnable", "h", "getTouchable", "setTouchable", "touchable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvScrollLyricViewV2 extends RecyclerView {
    public final Handler a;
    public final ArrayList<Function2<Integer, Integer, Unit>> b;
    public Function2<? super Integer, ? super Integer, Unit> c;
    public final a d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public RectF i;
    public final RectF j;
    public final RectF k;
    public final Paint l;

    public static final class a implements Runnable {
        public final /* synthetic */ KtvScrollLyricViewV2 a;

        public a(KtvScrollLyricViewV2 r1) {
            this.a = r1;
        }

        public final void a() {
            String r0 = "getSizeTask run w:" + this.a.getMeasuredWidth() + ", h:" + this.a.getMeasuredHeight();
            ALogger.i(bb0.b.b(), r0 + ", invoke class :KtvScrollLyricViewV2");
            Iterator<Function2<Integer, Integer, Unit>> r1 = this.a.b.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r1.next().invoke(Integer.valueOf(this.a.getMeasuredWidth()), Integer.valueOf(this.a.getMeasuredHeight()));
            goto L4
        L6:
            this.a.b.clear();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.clear();
    }

    public final boolean getFadingEdgeEnable() {
        return this.g;
    }

    public final Function2<Integer, Integer, Unit> getOnSizeChangedListener() {
        return this.c;
    }

    public final boolean getTouchable() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        int r0 = r9.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.draw(r9);
        RectF r1 = this.i;
        if (r1 == null) goto L16;
        this.j.setEmpty();
        this.k.setEmpty();
        if (r1.top <= 0) goto L8;
        RectF r2 = this.j;
        r2.left = 0.0f;
        r2.top = 0.0f;
        r2.right = r1.right;
        r2.bottom = r1.top;
    L8:
        if (r1.bottom >= getHeight()) goto L11;
        RectF r3 = this.k;
        r3.left = 0.0f;
        r3.top = r1.bottom;
        r3.right = r1.right;
        r3.bottom = getHeight();
    L11:
        if (this.j.isEmpty() == true) goto L14;
        r9.drawRect(this.j, this.l);
    L14:
        if (this.k.isEmpty() == true) goto L16;
        r9.drawRect(this.k, this.l);
    L16:
        r9.restoreToCount(r0);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.h == true) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(Function2<? super Integer, ? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "cb");
        int r0 = Math.max(getMeasuredWidth(), this.e);
        int r1 = Math.max(this.f, getMeasuredHeight());
        if (r0 > 0) goto L7;
        if (r1 > 0) goto L7;
        ALogger.i(bb0.b.b(), "post getSizeTask, invoke class :KtvScrollLyricViewV2");
        this.b.add(r4);
        return;
    L7:
        r4.invoke(Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()));
        if (getVisibility() == 0) goto L12;
        ALogger.e(bb0.b.b(), "KtvScrollLyricView visible state is invisible, invoke class :KtvScrollLyricViewV2");
        return;
    }

    public final void setFadingEdgeEnable(boolean r1) {
        this.g = r1;
    }

    public final void setOnSizeChangedListener(Function2<? super Integer, ? super Integer, Unit> r1) {
        this.c = r1;
    }

    public final void setTouchable(boolean r1) {
        this.h = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void smoothScrollToPosition(int r3) {
        final Context r1 = getContext();
        LinearSmoothScroller r0 = new AnonymousClass1(r1);
        r0.setTargetPosition(r3);
        RecyclerView.LayoutManager r4 = getLayoutManager();
        if ((r4 instanceof LinearLayoutManager) == true) goto L5;
        r4 = null;
    L5:
        LinearLayoutManager r5 = (LinearLayoutManager) r4;
        if (r5 == null) goto L9;
        r5.startSmoothScroll(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvScrollLyricViewV2(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.a = new Handler();
        this.b = new ArrayList();
        this.d = new a(this);
        this.g = true;
        this.h = true;
        this.j = new RectF();
        this.k = new RectF();
        Paint r5 = new Paint();
        r5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r5.setStyle(Paint.Style.FILL);
        r5.setAntiAlias(true);
        Unit r0 = Unit.INSTANCE;
        this.l = r5;
        setVerticalFadingEdgeEnabled(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r2, int r3, int r4, int r5) {
        super.onSizeChanged(r2, r3, r4, r5);
        this.a.removeCallbacks(this.d);
        if (this.g == false) goto L5;
        setFadingEdgeLength(r3 / 5);
    L5:
        String r6 = bb0.b.b();
        ALogger.i(r6, ("onSizeChanged w:" + r2 + ", h:" + r3) + ", invoke class :KtvScrollLyricViewV2");
        this.e = r2;
        this.f = r3;
        this.d.run();
        Function2<? super Integer, ? super Integer, Unit> r7 = this.c;
        if (r7 == null) goto L9;
        Unit r8 = (Unit) r7.invoke(Integer.valueOf(r2), Integer.valueOf(r3));
        return;
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
