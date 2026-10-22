package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements Runnable {
    public final /* synthetic */ OrderListTabLayout a;
    public final /* synthetic */ f b;
    public final /* synthetic */ com.bytedance.android.ecom.arch.slice.render.context.b c;
    public final /* synthetic */ a d;
    public final /* synthetic */ List e;

    public j(OrderListTabLayout r1, f r2, com.bytedance.android.ecom.arch.slice.render.context.b r3, a r4, List r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        int r0 = SlcDimensExtensionsKt.a(Integer.valueOf(this.b.f), this.c);
        int r1 = ((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight()) - r0;
        int r2 = 0;
        int r3 = RangesKt.coerceAtLeast(r1, 0);
        if (r3 > 0) goto L5;
        return;
    L5:
        int r4 = SlcDimensExtensionsKt.a(Integer.valueOf(this.d.c), this.c);
        int r5 = SlcDimensExtensionsKt.a(Integer.valueOf(this.d.d), this.c);
        int r6 = SlcDimensExtensionsKt.a(Integer.valueOf(this.d.b), this.c);
        List r7 = this.e;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L7:
        if (r9.hasNext() == false) goto L15;
        g r10 = (g) r9.next();
        OrderListTabLayout.a r11 = this.a.e(r10.d);
        if (r11 == null) goto L11;
        OrderListTabItemView r12 = r11.b;
    L12:
        if (r12 == null) goto L7;
        r8.add(r12);
        goto L7
    L11:
        r12 = null;
        goto L12
    L15:
        if (r8.isEmpty() == false) goto L17;
        return;
    L17:
        Iterator r13 = r8.iterator();
        int r14 = 0;
    L19:
        if (r13.hasNext() == false) goto L22;
        r14 = r14 + RangesKt.coerceAtLeast(((OrderListTabItemView) r13.next()).getWidth(), 0);
        goto L19
    L22:
        if (r8.size() <= 1) goto L24;
        int r15 = RangesKt.coerceAtLeast((((r3 - r14) - r4) - r5) / ((r8.size() - 1) * 2), r6 / 2);
    L25:
        Iterator r16 = r8.iterator();
    L27:
        if (r16.hasNext() == false) goto L45;
        Object r17 = r16.next();
        int r18 = r2 + 1;
        if (r2 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        ConstraintLayout r19 = (OrderListTabItemView) r17;
        if (r8.size() == 1) goto L35;
        if (r2 == 0) goto L35;
        int r20 = r15;
    L38:
        if (r8.size() != 1) goto L41;
    L42:
        int r21 = r5;
    L44:
        r19.setPadding(r20, r19.getPaddingTop(), r21, r19.getPaddingBottom());
        r2 = r18;
        goto L27
    L41:
        if (r2 == CollectionsKt.getLastIndex(r8)) goto L42;
        r21 = r15;
    L35:
        r20 = r4;
        goto L38
    L45:
        this.a.e = true;
        return;
    L24:
        r15 = 0;
        goto L25
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
