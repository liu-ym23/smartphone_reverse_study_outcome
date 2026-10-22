package com.bytedance.android.shopping.store.utils;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t {
    public static final void a(View r5, Map<String, ? extends Object> r6, boolean r7, Set<String> r8, q r9, PageFinder r10, Function2<? super Map<String, String>, ? super Integer, Unit> r11, Function3<? super String, ? super String, ? super Map<String, String>, Unit> r12) {
        Intrinsics.checkNotNullParameter(r5, "target");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "pageFinder");
        Intrinsics.checkNotNullParameter(r12, "reportShow");
        u r13 = v.a(r6, null);
        int r1 = r13.a;
        String r2 = r13.b;
        String r3 = r13.g;
        if (r7 == false) goto L5;
        return;
    L5:
        if (r8 != null) goto L7;
    L9:
        if (r11 == null) goto L11;
        Unit r14 = (Unit) r11.invoke(r13.e, Integer.valueOf(r1));
    L11:
        Set<String> r15 = s.a;
        Map<String, String> r16 = r13.e;
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r2, "btm");
        Intrinsics.checkNotNullParameter(r10, "pageFinder");
        r12.invoke(r2 + "_i" + r1, r3, s.a(r16, r9, r2, r1, r10));
        if (r8 == null) goto L15;
        r8.add(r3);
        return;
    L15:
        return;
    L7:
        if (r8.contains(r3) != true) goto L9;
    }
}
