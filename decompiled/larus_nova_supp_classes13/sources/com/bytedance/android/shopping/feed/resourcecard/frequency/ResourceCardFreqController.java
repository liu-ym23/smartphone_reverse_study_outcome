package com.bytedance.android.shopping.feed.resourcecard.frequency;

import android.os.SystemClock;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sk.a;
import yd3.d;
import yd3.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ResourceCardFreqController {
    public static final Lazy a = null;

    public static int c() {
        return ((Number) a.getValue()).intValue();
    }

    static {
        a = LazyKt.lazy(ResourceCardFreqController$maxRecordSize$2.INSTANCE);
    }

    public static boolean a(p r4) {
        d r0 = null;
        if (r4 == null) goto L5;
        d r1 = r4.q();
    L6:
        a r3 = a.a;
        if (b(r1, new ResourceCardFreqController$canShow$1(r3)) == false) goto L13;
        if (r4 == null) goto L11;
        r0 = r4.c();
    L11:
        if (b(r0, new ResourceCardFreqController$canShow$2(r3)) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    public static void d(Integer r4) {
        if (r4 == null) goto L8;
        r4.intValue();
        a r0 = a.a;
        int r1 = r4.intValue();
        r0.getClass();
        List r2 = a.a(r1);
        if (r2.size() < c()) goto L6;
        ListProtector.remove(r2, 0);
    L6:
        r2.add(String.valueOf(SystemClock.elapsedRealtime()));
        int r5 = r4.intValue();
        Intrinsics.checkNotNullParameter(r2, "record");
        q.a.b("resource_card_click_freq_" + r5, r2);
        return;
    }

    public static boolean b(d r8, Function1 r9) {
        if (r8 == null) goto L29;
        Long r1 = r8.a();
        if (r1 == null) goto L30;
        long r2 = r1.longValue();
        Long r3 = r8.c();
        if (r3 == null) goto L31;
        long r4 = r3.longValue();
        Integer r10 = r8.b();
        if (r10 == null) goto L32;
        int r11 = r10.intValue();
        if (r2 >= 0) goto L13;
        return true;
    L13:
        if (r4 > 0) goto L15;
        return true;
    L15:
        if (c() <= 0) goto L37;
        long r5 = Math.min(r4, c());
        List r12 = (List) r9.invoke(Integer.valueOf(r11));
        if (r12.size() >= r5) goto L20;
        return true;
    L20:
        String r13 = (String) CollectionsKt.getOrNull(r12, r12.size() - ((int) r5));
        if (r13 == null) goto L35;
        Long r14 = StringsKt.toLongOrNull(r13);
        if (r14 != null) goto L25;
        return true;
    L25:
        if ((SystemClock.elapsedRealtime() - r14.longValue()) > r2) goto L38;
        return false;
    L38:
        return true;
    L35:
        return true;
    L37:
        return true;
    L32:
        return true;
    L31:
        return true;
    L30:
        return true;
    L29:
        return true;
    }
}
