package com.bytedance.android.shopping.new_cart.components;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends com.bytedance.android.shopping.new_cart.components.a {
    public final List<Function1<Integer, Unit>> b;
    public int c;
    public final LinearLayout d;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            int r10 = r5 - r3;
            int r11 = com.bytedance.android.shopping.extensions.b.b(200);
            boolean r12 = true;
            if (CartSettingUtils.a() == false) goto L11;
            if (r10 == 0) goto L6;
        L7:
            if (1 > r10) goto L15;
            if (r11 < r10) goto L15;
        L16:
            if (r12 == false) goto L23;
            f r13 = this.a;
            if (r10 == r13.c) goto L25;
            r13.c = r10;
            Iterator r14 = ((ArrayList) r13.b).iterator();
        L21:
            if (r14.hasNext() == false) goto L26;
            ((Function1) r14.next()).invoke(Integer.valueOf(r10));
            goto L21
        L26:
            return;
        L25:
            return;
        L23:
            return;
        L15:
            r12 = false;
            goto L16
        L6:
            if (this.a.c > 0) goto L16;
        L11:
            if (1 > r10) goto L15;
            if (r11 < r10) goto L15;
            goto L15
        }
    }

    public final int n() {
        LinearLayout r1 = this.d;     // Catch: Throwable -> L13
        if (r1 == null) goto L17;
        View r2 = r1.getChildAt(r1.getChildCount() - 1);     // Catch: Throwable -> L13
        if (r2 == null) goto L8;
        Integer r3 = Integer.valueOf(r2.getMeasuredHeight());     // Catch: Throwable -> L13
    L9:
        if (r3 == null) goto L17;
        return r3.intValue();
    L8:
        r3 = null;
    L17:
        return com.bytedance.android.shopping.extensions.b.b(64);
    L14:
        return com.bytedance.android.shopping.extensions.b.b(64);
    }

    public f(CartObjectContainer r2, LinearLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        super(r2);
        this.d = r3;
        this.b = new ArrayList();
        if (r3 == null) goto L6;
        r3.addOnLayoutChangeListener(new a(this));
        return;
    }
}
