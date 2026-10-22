package com.bytedance.android.shopping.deepfeed.slice.view.customview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.bytedance.android.shopping.deepfeed.slice.view.list.DeepFeedSlcList;
import com.bytedance.android.shopping.deepfeed.weights.video.VideoProgressBar;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedSlcLongPressView extends SlcFlexElementView {
    public boolean e;
    public float f;
    public float g;
    public View h;
    public final Lazy i;
    public final a j;
    public SlcTemplateContext k;
    public Pair<String, ? extends Map<String, ? extends Object>> l;

    public static final class a implements Runnable {
        public final /* synthetic */ DeepFeedSlcLongPressView a;

        public a(DeepFeedSlcLongPressView r1) {
            this.a = r1;
        }

        public final void a() {
            DeepFeedSlcLongPressView r0 = this.a;
            if (r0.e == false) goto L5;
            return;
        L5:
            r0.e = true;
            View r1 = r0.h;
            if (r1 == null) goto L8;
            MotionEvent r2 = MotionEvent.obtain(0, 0, 3, r0.f, r0.g, 0);
            DeepFeedSlcLongPressView.g(r1, r2);
            r2.recycle();
        L8:
            DeepFeedSlcLongPressView r3 = this.a;
            Pair<String, ? extends Map<String, ? extends Object>> r4 = r3.l;
            if (r4 == null) goto L19;
            SlcTemplateContext r5 = r3.k;
            com.bytedance.android.shopping.deepfeed.slice.service.b r6 = null;
            Object r7 = null;
            if (r5 == null) goto L17;
            Object r8 = r5.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
            if ((r8 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == false) goto L16;
            r7 = r8;
        L16:
            r6 = (com.bytedance.android.shopping.deepfeed.slice.service.b) r7;
        L17:
            if (r6 == null) goto L19;
            r6.O((String) r4.getFirst(), (Map) r4.getSecond(), this.a);
        L19:
            this.a.performLongClick();
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

    private final int getTouchSlop() {
        return ((Number) this.i.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        removeCallbacks(this.j);
        this.h = null;
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepFeedSlcLongPressView(final Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.i = LazyKt.lazy(new DeepFeedSlcLongPressView$touchSlop$2(r4));
        this.j = new a(this);
        setClickable(true);
        setLongClickable(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r10) {
        boolean r0 = false;
        if (r10 != null) goto L5;
        return false;
    L5:
        int r1 = r10.getActionMasked();
        View r3 = null;
        Integer r4 = null;
        r3 = null;
        if (r1 == 0) goto L62;
        if (r1 != 1) goto L9;
    L53:
        removeCallbacks(this.j);
        if (this.e == true) goto L58;
        View r2 = this.h;
        if (r2 == null) goto L58;
        g(r2, r10);
    L58:
        ViewParent r11 = getParent();
        if (r11 == null) goto L61;
        r11.requestDisallowInterceptTouchEvent(false);
    L61:
        this.h = null;
        this.e = false;
    L84:
        return true;
    L9:
        if (r1 != 2) goto L11;
        float r5 = r10.getRawX() - this.f;
        float r6 = r10.getRawY() - this.g;
        if (((r5 * r5) + (r6 * r6)) <= (getTouchSlop() * getTouchSlop())) goto L17;
        removeCallbacks(this.j);
    L17:
        if (Math.abs(r5) <= getTouchSlop()) goto L49;
        if (Math.abs(r5) <= Math.abs(r6)) goto L49;
        RecyclerView r7 = this.h;
        if (r7 != null) goto L24;
    L44:
        if (r0 == false) goto L49;
        ViewParent r8 = getParent();
        if (r8 == null) goto L49;
        r8.requestDisallowInterceptTouchEvent(true);
        goto L49
    L24:
        if ((r7 instanceof DeepFeedSlcList) == false) goto L27;
    L43:
        r0 = true;
        goto L44
    L27:
        if ((r7 instanceof RecyclerView) == false) goto L40;
        RecyclerView.LayoutManager r9 = r7.getLayoutManager();
        if ((r9 instanceof LinearLayoutManager) == true) goto L31;
        r9 = null;
    L31:
        LinearLayoutManager r12 = (LinearLayoutManager) r9;
        if (r12 == null) goto L34;
        r4 = Integer.valueOf(r12.getOrientation());
    L34:
        if (r4 == null) goto L40;
        if (r4.intValue() == 0) goto L43;
    L40:
        if (r7.canScrollHorizontally(1) == true) goto L43;
        if (r7.canScrollHorizontally(-1) == false) goto L44;
    L49:
        if (this.e == true) goto L84;
        View r13 = this.h;
        if (r13 == null) goto L84;
        g(r13, r10);
        goto L84
    L11:
        if (r1 == 3) goto L53;
    L62:
        this.e = false;
        this.f = r10.getRawX();
        this.g = r10.getRawY();
        int r14 = (int) r10.getRawX();
        int r15 = (int) r10.getRawY();
        ViewParent r16 = getParent();
        if ((r16 instanceof ViewGroup) == true) goto L65;
        r16 = null;
    L65:
        ViewGroup r17 = (ViewGroup) r16;
        if (r17 == null) goto L81;
        int r18 = r17.getChildCount() - 1;
    L69:
        if (r18 < 0) goto L81;
        View r19 = r17.getChildAt(r18);
        if (r19 != this) goto L73;
        r0 = true;
    L80:
        r18 = r18 - 1;
        goto L69
    L73:
        if (r0 == false) goto L80;
        if (j(r19, r14, r15) == false) goto L80;
        View r20 = h(r19, r14, r15);
        if (r20 == null) goto L80;
        r3 = r20;
    L81:
        this.h = r3;
        removeCallbacks(this.j);
        postDelayed(this.j, ViewConfiguration.getLongPressTimeout());
        View r21 = this.h;
        if (r21 == null) goto L84;
        g(r21, r10);
        goto L84
    }

    public static void g(View r4, MotionEvent r5) {
        int[] r0 = new int[2];
        r4.getLocationOnScreen(r0);
        MotionEvent r1 = MotionEvent.obtain(r5);
        r1.setLocation(r5.getRawX() - r0[0], r5.getRawY() - r0[1]);
        r4.dispatchTouchEvent(r1);
        r1.recycle();
    }

    public static View h(View r6, int r7, int r8) {
        if (j(r6, r7, r8) == true) goto L5;
        return null;
    L5:
        View r0 = i(r6, r7, r8);
        if (r0 == null) goto L8;
        return r0;
    L8:
        boolean r2 = false;
        if ((r6 instanceof RecyclerView) == false) goto L11;
    L20:
        boolean r1 = true;
    L21:
        if (r1 == false) goto L24;
        return r6;
    L24:
        if ((r6 instanceof ViewGroup) == false) goto L32;
        ViewGroup r3 = (ViewGroup) r6;
        int r4 = r3.getChildCount() - 1;
    L26:
        if (r4 < 0) goto L32;
        View r5 = h(r3.getChildAt(r4), r7, r8);
        if (r5 != null) goto L29;
        r4 = r4 - 1;
        goto L26
    L29:
        return r5;
    L32:
        if (r6.isClickable() == false) goto L34;
    L37:
        r2 = true;
    L38:
        if (r2 == false) goto L41;
        return r6;
    L41:
        return null;
    L34:
        if (r6.isLongClickable() == true) goto L37;
        if (r6.hasOnClickListeners() == false) goto L38;
    L11:
        if (r6.canScrollHorizontally(1) == true) goto L20;
        if (r6.canScrollHorizontally(-1) == true) goto L20;
        if (r6.canScrollVertically(1) == true) goto L20;
        if (r6.canScrollVertically(-1) == true) goto L20;
        r1 = false;
        goto L21
    }

    public static View i(View r8, int r9, int r10) {
        Object r1 = null;
        if (j(r8, r9, r10) == true) goto L6;
        return null;
    L6:
        if ((r8 instanceof VideoProgressBar) == false) goto L31;
        VideoProgressBar r0 = (VideoProgressBar) r8;
        boolean r4 = false;
        if (r0.getVisibility() == 0) goto L10;
    L23:
        if (r4 == false) goto L31;
        ViewParent r11 = r0.getParent();
        if ((r11 instanceof View) == false) goto L29;
        r1 = r11;
    L29:
        return (View) r1;
    L10:
        if (r0.getAlpha() <= 0.0f) goto L23;
        if (r0.getWidth() <= 0) goto L23;
        if (r0.getHeight() <= 0) goto L23;
        int[] r3 = new int[2];
        r0.getLocationOnScreen(r3);
        int r5 = r3[0];
        int r6 = r0.getWidth() + r5;
        int r7 = r3[1] + r0.getHeight();
        int r12 = r7 - com.bytedance.android.shopping.extensions.b.a(15);
        if (r5 > r9) goto L23;
        if (r6 < r9) goto L23;
        if (r10 < r12) goto L23;
        if (r10 > r7) goto L23;
        r4 = true;
    L31:
        if ((r8 instanceof ViewGroup) == false) goto L38;
        ViewGroup r13 = (ViewGroup) r8;
        int r2 = r13.getChildCount() - 1;
    L33:
        if (r2 < 0) goto L38;
        View r14 = i(r13.getChildAt(r2), r9, r10);
        if (r14 != null) goto L36;
        r2 = r2 - 1;
        goto L33
    L36:
        return r14;
    L38:
        return null;
    }

    public static boolean j(View r4, int r5, int r6) {
        if (r4.getVisibility() == 0) goto L5;
        return false;
    L5:
        if (r4.getAlpha() > 0.0f) goto L7;
        return false;
    L7:
        if (r4.getWidth() > 0) goto L9;
        return false;
    L9:
        if (r4.getHeight() <= 0) goto L26;
        int[] r0 = new int[2];
        r4.getLocationOnScreen(r0);
        int r2 = r0[0];
        int r3 = r4.getWidth() + r2;
        if (r2 > r5) goto L27;
        if (r3 <= r5) goto L24;
        int r1 = r0[1];
        int r7 = r4.getHeight() + r1;
        if (r1 > r6) goto L28;
        if (r7 <= r6) goto L25;
        return true;
    L25:
        return false;
    L28:
        return false;
    L24:
        return false;
    L27:
        return false;
    L26:
        return false;
    }
}
