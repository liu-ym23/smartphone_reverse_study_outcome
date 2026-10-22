package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ i d;
        public final /* synthetic */ g e;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            Rect r0 = new Rect();
            if ((this.a.getParent() instanceof i) == false) goto L5;
            this.a.getHitRect(r0);
        L11:
            Rect r1 = new Rect(r0);
            int r2 = r0.top;
            int r3 = this.b;
            r0.top = r2 - r3;
            int r4 = this.c;
            if (r4 <= (r3 * 2)) goto L14;
            r0.bottom += r3 * 2;
        L15:
            this.d.setSeekBarTouchDelegate(new f(this.e));
            g r5 = this.e;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r0, "<set-?>");
            r5.b = r0;
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r5.a.setHasTouchDelegate(true);
            return;
        L14:
            r0.bottom += r4;
            goto L15
        L5:
            Object r6 = this.a.getParent();
            if ((r6 instanceof View) == false) goto L8;
            View r7 = (View) r6;
        L9:
            if (r7 == null) goto L11;
            r7.getHitRect(r0);
            goto L11
        L8:
            r7 = null;
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(CustomizedUISeekBar r1, int r2, int r3, i r4, g r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View, com.bytedance.awemeopen.apps.framework.base.view.seekbar.CustomizedUISeekBar] */
    public static boolean a(g r9, int r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r9, "manager");
        ViewParent r1 = null;
        if (r11 != null) goto L5;
    L13:
        Resources r3 = Resources.getSystem();
        int r12 = MathKt.roundToInt(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
    L14:
        int r5 = r12;
        ?? r4 = r9.a;
        ViewParent r13 = r4.getParent();
        View r6 = r4.getRootView();
    L15:
        if (r13 == null) goto L22;
        if (Intrinsics.areEqual(r13, r6) == true) goto L22;
        if ((r13 instanceof i) == false) goto L21;
        r1 = r13;
    L21:
        r13 = r13.getParent();
    L22:
        i r7 = (i) r1;
        if (r7 != null) goto L25;
        return false;
    L25:
        r4.getViewTreeObserver().addOnGlobalLayoutListener(new a(r4, r5, r10, r7, r9));
        return true;
    L5:
        if (r11.intValue() < 0) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == true) goto L11;
        r11 = null;
    L11:
        if (r11 == null) goto L13;
        r12 = r11.intValue();
        goto L14
    L7:
        r8 = false;
        goto L8
    }
}
