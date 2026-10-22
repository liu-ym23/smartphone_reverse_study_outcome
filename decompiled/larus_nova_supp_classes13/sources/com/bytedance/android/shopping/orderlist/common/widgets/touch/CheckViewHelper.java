package com.bytedance.android.shopping.orderlist.common.widgets.touch;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CheckViewHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(View r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r4, "ev");
        if (ECAppInfoService.e.i() == true) goto L5;
        return;
    L5:
        final View r0 = a(new Point((int) r4.getRawX(), (int) r4.getRawY()), r3, 1);
        final View r5 = a(new Point((int) r4.getRawX(), (int) r4.getRawY()), r3, -1);
        Lazy r6 = OrderCommonLog.a;
        OrderCommonLog.a("CheckViewHelper", new CheckViewHelper$debugCheck$1(r0, r5));
    }

    public static View a(Point r9, View r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "point");
        Intrinsics.checkNotNullParameter(r10, FreqActions.ACTION_VIEW);
        if ((r10 instanceof ViewGroup) == true) goto L5;
        return null;
    L5:
        Iterator r12 = com.bytedance.commerce.base.view.b.a(r10).iterator();
    L7:
        if (r12.hasNext() == false) goto L49;
        ViewPager2 r0 = (View) r12.next();
        if ((r0 instanceof ViewGroup) == false) goto L7;
        int[] r2 = new int[2];
        r0.getLocationOnScreen(r2);
        boolean r3 = false;
        int r4 = r2[0];
        int r5 = r2[1];
        int r6 = r0.getWidth() + r4;
        int r7 = r0.getHeight() + r5;
        int r8 = r9.x;
        if (r4 > r8) goto L19;
        if (r6 < r8) goto L19;
        int r13 = r9.y;
        if (r5 > r13) goto L19;
        if (r7 < r13) goto L19;
        boolean r14 = true;
    L20:
        if (r14 == false) goto L7;
        if ((r0 instanceof ViewPager2) == false) goto L44;
        ViewPager2 r15 = r0;
        if (r15.getOrientation() == 0) goto L26;
    L41:
        if (r3 == false) goto L44;
        return r0;
    L26:
        if (r15.isUserInputEnabled() == false) goto L41;
        RecyclerView.Adapter r16 = r15.getAdapter();
        if (r16 == null) goto L31;
        int r17 = r16.getItemCount();
    L32:
        int r18 = r15.getCurrentItem();
        if (r11 == (-1)) goto L39;
        if (r11 != 1) goto L41;
        if (r18 >= (r17 - 1)) goto L41;
    L40:
        r3 = true;
        goto L41
    L39:
        if (r18 <= 0) goto L41;
    L31:
        r17 = 0;
    L44:
        if (r0.canScrollHorizontally(r11) == true) goto L45;
        View r1 = a(r9, r0, r11);
        if (r1 == null) goto L7;
        return r1;
    L45:
        return r0;
    L19:
        r14 = false;
        goto L20
    L49:
        return null;
    }
}
