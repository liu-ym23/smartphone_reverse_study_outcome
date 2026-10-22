package com.bytedance.awemeopen.apps.framework.landscape;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import com.bytedance.android.shopping.yata.business.function.ScrollPosition;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final float a = 0.0f;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.landscape.a$a, reason: collision with other inner class name */
    public static final class C0097a extends AnimatorListenerAdapter {
        public final /* synthetic */ List<View> a;
        public final /* synthetic */ List<View> b;
        public final /* synthetic */ View c;
        public final /* synthetic */ int d;

        public final void a() {
            List<View> r0 = this.a;
            int r1 = this.d;
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            ((View) r2.next()).setVisibility(r1);
            goto L4
        L6:
            List<View> r3 = this.b;
            int r4 = this.d;
            Iterator<T> r5 = r3.iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            ((View) r5.next()).setVisibility(r4);
            goto L8
        L10:
            this.c.setVisibility(this.d);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
            a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0097a(List<? extends View> r1, List<? extends View> r2, View r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
        Resources r1 = Resources.getSystem();
        a = TypedValue.applyDimension(1, 120, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()));
    }

    public static void a(List r7, List r8, View r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r7, ScrollPosition.POSITION_TOP);
        Intrinsics.checkNotNullParameter(r8, ScrollPosition.POSITION_BOTTOM);
        Intrinsics.checkNotNullParameter(r9, "container");
        float r0 = 1.0f;
        if (r10 == false) goto L5;
        float r2 = 0.0f;
    L7:
        if (r10 == false) goto L9;
        int r4 = 8;
    L10:
        C0097a r5 = new C0097a(r7, r8, r9, r4);
        if (r10 == true) goto L14;
        r0 = 0.0f;
    L14:
        Iterator r11 = r7.iterator();
    L16:
        if (r11.hasNext() == false) goto L21;
        View r1 = (View) r11.next();
        if (r10 == true) goto L20;
        r1.setVisibility(0);
    L20:
        r1.animate().translationY(a * (-r0)).setListener(r5).start();
        goto L16
    L21:
        Iterator r12 = r8.iterator();
    L23:
        if (r12.hasNext() == false) goto L28;
        View r13 = (View) r12.next();
        if (r10 == true) goto L27;
        r13.setVisibility(0);
    L27:
        r13.animate().translationY(a * r0).setListener(r5).start();
        goto L23
    L28:
        if (r10 == true) goto L30;
        r9.setVisibility(0);
    L30:
        r9.animate().alpha(r2).setListener(r5).start();
        return;
    L9:
        r4 = 0;
        goto L10
    L5:
        r2 = 1.0f;
        goto L7
    }
}
