package com.bytedance.android.shopping.new_cart.container;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartSwipeNestRefreshLayoutV2;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartFooterRoundCornerHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(View r2, com.bytedance.android.shopping.new_cart.manager.c r3) {
        if (CartSettingUtils.a() == true) goto L5;
        return;
    L5:
        Object r0 = null;
        if (r2 == null) goto L8;
        View r4 = r2.findViewById(2131365248);
    L10:
        if ((r4 instanceof CartSwipeNestRefreshLayoutV2) == false) goto L13;
        r0 = r4;
    L13:
        CartSwipeNestRefreshLayoutV2 r1 = (CartSwipeNestRefreshLayoutV2) r0;
        if (r1 == null) goto L16;
        int r5 = r1.getFooterHeightForRoundCorner();
    L17:
        if (r5 <= 0) goto L21;
        if (r3 == null) goto L22;
        r3.a = r5;
        return;
    L22:
        return;
    L21:
        return;
    L16:
        r5 = 0;
        goto L17
    L8:
        r4 = null;
        goto L10
    }

    public static void a(View r7, com.bytedance.android.shopping.new_cart.components.f r8, final CartLinkedScrollViewV2 r9, final Function1 r10) {
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r10, "onFooterHeightReady");
        if (CartSettingUtils.a() == true) goto L5;
        return;
    L5:
        ConstraintLayout r0 = (ViewGroup) r7.findViewById(2131365249);
        if (r0 != null) goto L8;
        return;
    L8:
        Integer r2 = null;
        if ((r0 instanceof ConstraintLayout) == true) goto L11;
        ConstraintLayout r1 = null;
    L12:
        ConstraintLayout r3 = r1;
        int r4 = 0;
        if (r3 != null) goto L18;
        View r5 = r0.getChildAt(0);
        if ((r5 instanceof ConstraintLayout) == true) goto L17;
        r5 = null;
    L17:
        r3 = (ConstraintLayout) r5;
    L18:
        if (r3 != null) goto L20;
        return;
    L20:
        View r6 = r7.findViewById(2131365248);
        if (r6 != null) goto L23;
        return;
    L23:
        View r11 = r7.findViewById(2131365244);
        if (r11 != null) goto L27;
        return;
    L27:
        if (r6.getParent() == r3) goto L29;
        return;
    L29:
        if (r11.getParent() != r3) goto L60;
        ConstraintSet r12 = new ConstraintSet();
        r12.clone(r3);
        r12.connect(2131365248, 4, 0, 4);
        r12.applyTo(r3);
        r3.setClipChildren(false);
        boolean r13 = r6 instanceof CartSwipeNestRefreshLayoutV2;
        Object r14 = r6;
        if (r13 == true) goto L34;
        r14 = null;
    L34:
        final CartSwipeNestRefreshLayoutV2 r15 = (CartSwipeNestRefreshLayoutV2) r14;
        if (r15 == null) goto L37;
        r15.setFooterView(r11);
    L37:
        final Function1<Integer, Unit> r16 = new CartFooterRoundCornerHelper$apply$applyFooterHeight$1(r9, r15, r10);
        if (r8 == null) goto L42;
        Function1<Integer, Unit> r17 = new CartFooterRoundCornerHelper$apply$2(r16);
        Intrinsics.checkNotNullParameter(r17, "listener");
        ((ArrayList) r8.b).add(r17);
        int r18 = r8.c;
        if (r18 <= 0) goto L42;
        r17.invoke(Integer.valueOf(r18));
    L42:
        if (r8 == null) goto L55;
        Integer r19 = Integer.valueOf(r8.c);
        if (r19.intValue() <= 0) goto L46;
        boolean r110 = true;
    L47:
        if (r110 == false) goto L49;
        r2 = r19;
    L49:
        if (r2 == null) goto L52;
        int r20 = r2.intValue();
    L51:
        r4 = r20;
        goto L55
    L52:
        LinearLayout r21 = r8.d;
        if (r21 == null) goto L55;
        r20 = r21.getMeasuredHeight();
        goto L51
    L46:
        r110 = false;
    L55:
        if (r4 <= 0) goto L59;
        r16.invoke(Integer.valueOf(r4));
        return;
    L59:
        return;
    L60:
        return;
    L11:
        r1 = r0;
        goto L12
    }
}
