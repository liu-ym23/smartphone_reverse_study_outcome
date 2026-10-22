package com.bytedance.ee.bear.middleground.comment.widget;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public final /* synthetic */ m a;

    public n(m r1) {
        this.a = r1;
    }

    public final Object a(com.ss.android.lark.coremd.impl.parse.i r12) {
        Intrinsics.checkNotNullParameter(r12, "it");
        v7b.s r0 = (v7b.a) ((v7b.s) r12.d).d;
        int r3 = -1;
        if ((r0 instanceof v7b.u) == false) goto L18;
        this.a.getClass();
        v7b.s r1 = r0;
    L5:
        if (r1 == null) goto L12;
        if ((r1 instanceof v7b.u) == false) goto L9;
    L10:
        r3 = r3 + 1;
    L11:
        r1 = r1.i();
        goto L5
    L9:
        if ((r1 instanceof v7b.c) == false) goto L11;
    L12:
        int r9 = RangesKt.coerceAtLeast(r3, 0);
        m r4 = this.a;
        String[] r2 = com.ss.android.lark.coremd.utils.d.a;
        v7b.q r5 = r12.d;
        Integer r6 = r5.j;
        if (r6 == null) goto L15;
        int r7 = r6.intValue();
    L36:
        return m.e(r4, com.ss.android.lark.coremd.utils.d.c(r7, r9), r12.d, r12.getContext(), r12.getTheme(), r9, true);
    L15:
        r7 = com.ss.android.lark.coremd.utils.d.b((v7b.u) r0, r5);
        goto L36
    L18:
        if ((r0 instanceof v7b.c) == false) goto L28;
        this.a.getClass();
    L20:
        if (r0 == null) goto L27;
        if ((r0 instanceof v7b.u) == false) goto L24;
    L25:
        r3 = r3 + 1;
    L26:
        r0 = r0.i();
        goto L20
    L24:
        if ((r0 instanceof v7b.c) == false) goto L26;
    L27:
        int r10 = RangesKt.coerceAtLeast(r3, 0);
        m r8 = this.a;
        r8.getClass();
        List<String> r11 = m.b;
        return m.e(r8, (String) ListProtector.get(r11, r10 % r11.size()), r12.d, r12.getContext(), r12.getTheme(), r10, false);
    L28:
        return null;
    }
}
