package com.bytedance.android.shopping.new_cart.widgets.nest;

import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final /* synthetic */ int c = 0;
    public final OverScroller a;
    public final RecyclerView b;

    public static final class a {
    }

    static {
    }

    public final float a() {
        OverScroller r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.getStartY();
    L6:
        OverScroller r3 = this.a;
        if (r3 == null) goto L10;
        r1 = r3.getFinalY();
    L10:
        if ((r2 - r1) <= 0) goto L12;
        int r4 = -1;
    L13:
        OverScroller r5 = this.a;
        if (r5 == null) goto L16;
        float r6 = r5.getCurrVelocity();
    L18:
        return (r6 * r4) * 0.7f;
    L16:
        r6 = 0.0f;
        goto L18
    L12:
        r4 = 1;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public g(RecyclerView r9) {
        this.b = r9;
        Field r1 = RecyclerView.class.getDeclaredField("mViewFlinger");     // Catch: Throwable -> L14
        r1.setAccessible(true);     // Catch: Throwable -> L14
        Object r10 = r1.get(r9);     // Catch: Throwable -> L14
        Field[] r2 = r10.getClass().getDeclaredFields();     // Catch: Throwable -> L14
        int r3 = r2.length;     // Catch: Throwable -> L14
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L13;
        Field r5 = r2[r4];     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(r5.getType(), OverScroller.class) == true) goto L7;
        r4 = r4 + 1;     // Catch: Throwable -> L14
        goto L4
    L7:
        r5.setAccessible(true);     // Catch: Throwable -> L14
        Object r11 = r5.get(r10);     // Catch: Throwable -> L14
        if ((r11 instanceof OverScroller) == true) goto L10;
        r11 = null;
    L10:
        this.a = (OverScroller) r11;     // Catch: Throwable -> L14
        return;
    L13:
        throw new NoSuchElementException("Array contains no element matching the predicate.");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        bg3.a r6 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.j("RevHolder Reflect Error", th.getMessage() + ' ' + th.getClass().getName(), null, 12);
    }
}
