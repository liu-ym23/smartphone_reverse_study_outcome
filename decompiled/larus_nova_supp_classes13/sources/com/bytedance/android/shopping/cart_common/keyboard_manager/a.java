package com.bytedance.android.shopping.cart_common.keyboard_manager;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements b {
    public final ViewTreeObserverOnGlobalLayoutListenerC0040a a;
    public int b;
    public ViewTreeObserver c;
    public int d;
    public final ViewGroup e;
    public final Integer f;
    public final Function0<Unit> g;
    public final Function0<Unit> h;
    public final int i;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.cart_common.keyboard_manager.a$a, reason: collision with other inner class name */
    public static final class ViewTreeObserverOnGlobalLayoutListenerC0040a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ a a;

        public ViewTreeObserverOnGlobalLayoutListenerC0040a(a r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            a r0 = this.a;
            r0.getClass();
            Rect r1 = new Rect();
            r0.e.getWindowVisibleDisplayFrame(r1);
            int r2 = r1.bottom - r1.top;
            if (r2 == r0.b) goto L14;
            int r3 = r0.d;
            int r4 = r3 - r2;
            if (r4 <= (r3 / 4)) goto L11;
            Integer r5 = r0.f;
            if (r5 == null) goto L9;
            int r6 = r5.intValue();
        L10:
            int r7 = (r4 - r6) - r0.i;
            r0.e.setPadding(0, 0, 0, Math.max(0, r7));
            Lazy r8 = CartCommonLog.a;
            CartCommonLog.a("NewCartStarter", CommonPopupKeyBoardManager$possiblyResizeChildOfContent$1.INSTANCE);
            r0.g.invoke();
        L12:
            r0.e.requestLayout();
            r0.b = r2;
            return;
        L9:
            r6 = com.bytedance.android.shopping.extensions.b.b(64);
            goto L10
        L11:
            r0.e.setPadding(0, 0, 0, 0);
            Lazy r9 = CartCommonLog.a;
            CartCommonLog.a("NewCartStarter", CommonPopupKeyBoardManager$possiblyResizeChildOfContent$2.INSTANCE);
            r0.h.invoke();
            goto L12
        }
    }

    @Override // com.bytedance.android.shopping.cart_common.keyboard_manager.b
    public final void onDetach() {
        ViewTreeObserver r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        this.c = null;
        return;
    L5:
        if (r0.isAlive() == false) goto L7;
        r0.removeOnGlobalLayoutListener(this.a);
        goto L7
    }

    public a(ViewGroup r2, Integer r3, Function0<Unit> r4, Function0<Unit> r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "popUpContainer");
        Intrinsics.checkNotNullParameter(r4, "onPopupKeyBoardShow");
        Intrinsics.checkNotNullParameter(r5, "onPopupKeyBoardHide");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.a = new ViewTreeObserverOnGlobalLayoutListenerC0040a(this);
    }
}
