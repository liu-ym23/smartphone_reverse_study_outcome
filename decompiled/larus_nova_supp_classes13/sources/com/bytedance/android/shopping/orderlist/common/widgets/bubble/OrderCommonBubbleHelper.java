package com.bytedance.android.shopping.orderlist.common.widgets.bubble;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonBubbleHelper {
    public static final /* synthetic */ int a = 0;

    public static final class a implements PopupWindow.OnDismissListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            Function0 r0 = this.a;
            if (r0 == null) goto L6;
            Unit r1 = (Unit) r0.invoke();
            return;
        }
    }

    static {
    }

    public static PopupWindow a(b r17, Function0 r18) {
        Intrinsics.checkNotNullParameter(r17, "info");
        Lazy r2 = OrderCommonLog.a;
        OrderCommonLog.c("OrderCommonBubbleHelper", OrderCommonBubbleHelper$showBubble$1.INSTANCE);
        BackgroundDrawable r4 = null;
        BubbleContainer r3 = new BubbleContainer(r17.getContext(), null, 6, 0);
        Rect r5 = new Rect();
        r17.f.getWindowVisibleDisplayFrame(r5);
        int[] r7 = new int[2];
        r17.f.getLocationOnScreen(r7);
        int[] r8 = new int[2];
        r17.f.getLocationInWindow(r8);
        int r9 = r7[0] - r8[0];
        int r10 = r7[1] - r8[1];
        r17.b.set(r5.left - r9, r5.top - r10, r5.right - r9, r5.bottom - r10);
        int r6 = r17.b.top + r17.m;
        View r11 = r17.n;
        if (r11 != null) goto L5;
        int r12 = Integer.MIN_VALUE;
    L6:
        int r13 = Math.max(r6, r12);
        int r14 = r17.b.bottom - r17.m;
        int[] r15 = new int[2];
        r17.f.getLocationInWindow(r15);
        int r16 = r15[0];
        Rect r19 = new Rect(r16, r15[1], r17.f.getWidth() + r16, r15[1] + r17.f.getHeight());
        int r20 = (r17.i + r17.l) + r17.m;
        int r110 = r19.top - r13;
        int r21 = r14 - r19.bottom;
        int r111 = com.bytedance.android.shopping.orderlist.common.widgets.bubble.a.a[r17.g.ordinal()];
        if (r111 == 1) goto L18;
        if (r111 != 2) goto L17;
        if (r21 < r20) goto L11;
        BubbleOrientation r22 = BubbleOrientation.BOTTOM;
    L25:
        r17.a = r22;
        if (r22 != BubbleOrientation.TOP) goto L28;
        Point r23 = r17.b();
        Point r24 = new Point(r23.x - ((r17.h + (r17.m * 2)) / 2), (r23.y - r17.i) - r17.l);
    L29:
        int r25 = RangesKt.coerceIn(r24.y, r13, RangesKt.coerceAtLeast(r14 - ((r17.i + r17.l) + (r17.m * 2)), r13));
        Rect r26 = r17.b;
        int r27 = r26.left;
        r17.c.set(RangesKt.coerceIn(r24.x, r27, RangesKt.coerceAtLeast(r26.right - (r17.h + (r17.m * 2)), r27)), r25);
        Intrinsics.checkNotNullParameter(r17, "info");
        BackgroundDrawable r1 = r3.d.getBackground();
        if ((r1 instanceof BackgroundDrawable) == false) goto L33;
        r4 = r1;
    L33:
        BackgroundDrawable r28 = r4;
        if (r28 == null) goto L37;
        r28.setCornerRadius(r17.j);
        r28.invalidateSelf();
    L37:
        if (r17.a != BubbleOrientation.BOTTOM) goto L39;
        r3.b.setVisibility(0);
        r3.c.setVisibility(8);
        BubbleContainer.a(r3.b, r17);
    L40:
        ViewGroup.LayoutParams r29 = r3.b.getLayoutParams();
        r29.width = r17.k;
        r29.height = r17.l;
        ViewGroup.LayoutParams r30 = r3.c.getLayoutParams();
        r30.width = r17.k;
        r30.height = r17.l;
        ViewGroup r31 = r3.a;
        int r32 = r17.m;
        r31.setPadding(r32, r32, r32, r32);
        r3.d.addView(r17.e);
        r3.e.setShadowRadius(Math.max(r17.m, r17.l));
        PopupWindow r33 = new PopupWindow(r3, -2, -2, true);
        r33.setBackgroundDrawable(new ColorDrawable(0));
        Point r34 = r17.c;
        View r0 = r17.f;
        int r35 = r34.x;
        int r36 = r34.y;
        if (PopupWindowLancet.hasSubWindowToken(r0) == false) goto L44;
    L50:
        r33.setOnDismissListener(new a(r18));
        return r33;
    L44:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r33) == false) goto L46;
        r33.showAtLocation(r0, 0, r35, r36);
        goto L50
    L46:
        OverlaySource r37 = PopupWindowLancet.resolveSource(r0);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r33, r0, r37, 0, r35, r36) == true) goto L50;
        r33.showAtLocation(r0, 0, r35, r36);
        PopupWindowLancet.trackAfterShow(r33, r37, r0);
        goto L50
    L39:
        r3.b.setVisibility(8);
        r3.c.setVisibility(0);
        BubbleContainer.a(r3.c, r17);
        goto L40
    L28:
        Point r38 = r17.a();
        r24 = new Point(r38.x - ((r17.h + (r17.m * 2)) / 2), r38.y);
        goto L29
    L11:
        if (r110 < r20) goto L13;
        r22 = BubbleOrientation.TOP;
        goto L25
    L13:
        if (r21 < r110) goto L15;
        r22 = BubbleOrientation.BOTTOM;
        goto L25
    L15:
        r22 = BubbleOrientation.TOP;
        goto L25
    L17:
        throw new NoWhenBranchMatchedException();
    L18:
        if (r110 < r20) goto L20;
        r22 = BubbleOrientation.TOP;
        goto L25
    L20:
        if (r21 < r20) goto L22;
        r22 = BubbleOrientation.BOTTOM;
        goto L25
    L22:
        if (r110 < r21) goto L24;
        r22 = BubbleOrientation.TOP;
        goto L25
    L24:
        r22 = BubbleOrientation.BOTTOM;
        goto L25
    L5:
        int[] r39 = new int[2];
        r11.getLocationInWindow(r39);
        r12 = r11.getHeight() + r39[1];
        goto L6
    }
}
