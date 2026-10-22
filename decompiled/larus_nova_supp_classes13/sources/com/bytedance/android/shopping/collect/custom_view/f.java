package com.bytedance.android.shopping.collect.custom_view;

import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
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

    public f(RecyclerView r8) {
        this.b = r8;
        Field r0 = RecyclerView.class.getDeclaredField("mViewFlinger");     // Catch: Throwable -> L15
        r0.setAccessible(true);     // Catch: Throwable -> L15
        Object r9 = r0.get(r8);     // Catch: Throwable -> L15
        Field[] r1 = r9.getClass().getDeclaredFields();     // Catch: Throwable -> L15
        int r2 = r1.length;     // Catch: Throwable -> L15
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L13;
        Field r4 = r1[r3];     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(r4.getType(), OverScroller.class) == true) goto L7;
        r3 = r3 + 1;     // Catch: Throwable -> L15
        goto L4
    L7:
        r4.setAccessible(true);     // Catch: Throwable -> L15
        Object r10 = r4.get(r9);     // Catch: Throwable -> L15
        if ((r10 instanceof OverScroller) == true) goto L10;
        r10 = null;
    L10:
        this.a = (OverScroller) r10;     // Catch: Throwable -> L15
        return;
    L13:
        throw new NoSuchElementException("Array contains no element matching the predicate.");     // Catch: Throwable -> L15
    }
}
