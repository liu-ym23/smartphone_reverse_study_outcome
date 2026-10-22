package com.bytedance.ee.bear.more.protocol3.panel;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static com.bytedance.ee.bear.more.protocol3.b a(String r1, e r2, x r3) {
        e0 r0 = r2.c(r1);
        if (r0 != null) goto L7;
        tt5.a.k("MorePanelComposer", "baseline factory missing for itemId=".concat(r1));
        return null;
    L7:
        return r0.a(r3, r2);
    }

    public static com.bytedance.ee.bear.more.protocol3.b b(o r5, e r6, x r7) {
        r r0 = r5.b;
        if (r0 != null) goto L6;
        return a(r5.a, r6, r7);
    L6:
        if ((r0 instanceof f0) == false) goto L14;
        String r1 = ((f0) r0).f;
        if (r1 != null) goto L10;
        r1 = r5.a;
    L10:
        if (r1 != null) goto L31;
        r1 = r5.a;
    L31:
        return a(r1, r6, r7);
    L14:
        if ((r0 instanceof c) == false) goto L28;
        c r2 = (c) r0;
        String r8 = r2.b;
        if (r8 != null) goto L18;
        r8 = r5.a;
    L18:
        q r3 = r2.c;
        if (r3 != null) goto L21;
        r3 = r5.c;
    L21:
        d r4 = r2.a;
        Intrinsics.checkNotNullParameter(r4, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r4, ThumbGlideUrl.SOURCE_TEMPLATE);
        if (r8 != null) goto L24;
        r8 = r5.a;
    L24:
        if (r3 != null) goto L32;
        tt5.a.d("MorePanelComposer", "custom factory missing delegate, itemId=" + r8);
        return null;
    L32:
        return new CustomMoreItem(r8, r4, r3, r7);
    L28:
        tt5.a.d("MorePanelComposer", "unsupported factory type=" + r0.getClass().getName() + ", itemId=" + r5.a);
        return null;
    }

    public static List c(MoreGroup r8, e r9, x r10, w r11) {
        List<m> r12 = r11.b;
        ArrayList r2 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L3:
        boolean r4 = false;
        if (r13.hasNext() == false) goto L10;
        Object r3 = r13.next();
        if (((m) r3).a != r8) goto L8;
        r4 = true;
    L8:
        if (r4 == false) goto L3;
        r2.add(r3);
        goto L3
    L10:
        ArrayList r14 = new ArrayList();
        Iterator r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L15;
        CollectionsKt.addAll(r14, ((m) r5.next()).b);
        goto L12
    L15:
        if (r14.isEmpty() == true) goto L17;
        ArrayList r6 = new ArrayList();
        Iterator r15 = r14.iterator();
    L20:
        if (r15.hasNext() == false) goto L29;
        o r7 = (o) r15.next();
        com.bytedance.ee.bear.more.protocol3.b r16 = b(r7, r9, r10);     // Catch: Throwable -> L27
        if (r16 != null) goto L24;
        tt5.a.k("MorePanelComposer", "skip itemId=" + r7.a + ", group=" + r8 + ", cannot resolve");     // Catch: Throwable -> L27
        goto L20
    L24:
        r6.add(r16);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        tt5.a.e("MorePanelComposer", "build item error, itemId=" + r7.a + ", group=" + r8, th, false);
        goto L20
    L29:
        return r6;
    L17:
        return CollectionsKt.emptyList();
    }

    public static com.bytedance.ee.bear.more.protocol3.c d(com.bytedance.ee.bear.more.protocol3.h r3, e r4, x r5, w r6) {
        Intrinsics.checkNotNullParameter(r3, "provider");
        Intrinsics.checkNotNullParameter(r4, "registry");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "config");
        tt5.a.h("MorePanelComposer", "compose, hostStyle=" + r6.a + ", groupCount=" + r6.b.size());
        final List r0 = c(MoreGroup.TOP, r4, r5, r6);
        final List r1 = c(MoreGroup.NORMAL, r4, r5, r6);
        final List r7 = c(MoreGroup.DANGER, r4, r5, r6);
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(r3, new MorePanelComposer$compose$1(r0, r1, r7));
    }
}
