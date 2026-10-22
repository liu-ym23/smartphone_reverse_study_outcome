package com.bytedance.android.shopping.card_list.manager;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final a a;
    public int b;
    public ViewTreeObserver c;
    public View d;
    public final ViewGroup e;
    public final Integer f;
    public final SlcRenderContext g;
    public final Function0<Unit> h;
    public final Function0<Unit> i;
    public final int j;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            d r0 = this.a;
            if (r0.d == null) goto L5;
        L9:
            View r1 = r0.d;
            if (r1 != null) goto L12;
        L14:
            Rect r2 = new Rect();
            r0.e.getWindowVisibleDisplayFrame(r2);
            int r3 = r2.bottom - r2.top;
            if (r3 == r0.b) goto L34;
            View r4 = r0.e.getRootView();
            if (r4 == null) goto L19;
            int r5 = r4.getHeight();
        L20:
            int r6 = r5 - r3;
            View r7 = r0.e.getChildAt(0);
            if (r7 == null) goto L23;
            int r8 = r7.getHeight();
        L25:
            if (r6 <= (r5 / 4)) goto L31;
            Integer r9 = r0.f;
            if (r9 == null) goto L29;
            int r10 = r9.intValue();
        L30:
            int r11 = ((r6 - r10) - r8) - r0.j;
            r0.e.setPadding(0, 0, 0, Math.max(0, r11));
            r0.h.invoke();
        L32:
            r0.e.requestLayout();
            r0.b = r3;
            return;
        L29:
            r10 = com.bytedance.android.shopping.extensions.b.b(64);
            goto L30
        L31:
            r0.e.setPadding(0, 0, 0, 0);
            r0.i.invoke();
            goto L32
        L23:
            r8 = 0;
            goto L25
        L19:
            r5 = r0.e.getHeight();
            goto L20
        L34:
            return;
        L12:
            if (r1.hasFocus() != true) goto L14;
            return;
        L5:
            if (r0.g == null) goto L7;
            View r12 = SlcRenderContext.f(r0.e, "search_input");
        L8:
            r0.d = r12;
            goto L9
        L7:
            r12 = null;
            goto L8
        }
    }

    public d(ViewGroup r2, Integer r3, SlcRenderContext r4, Function0<Unit> r5, Function0<Unit> r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "popUpContainer");
        Intrinsics.checkNotNullParameter(r5, "onPopupKeyBoardShow");
        Intrinsics.checkNotNullParameter(r6, "onPopupKeyBoardHide");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.a = new a(this);
    }
}
