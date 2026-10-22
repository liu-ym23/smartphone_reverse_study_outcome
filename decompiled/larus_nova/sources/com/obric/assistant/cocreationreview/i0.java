package com.obric.assistant.cocreationreview;

import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class i0 {
    public static final t5 a(l5 r100) {
        Intrinsics.checkNotNullParameter(r100, "moduleMeta");
        return new t5(true, "反馈已回流到" + r100.f387359b);
    }

    public static final long b(long r100) {
        Calendar r101 = Calendar.getInstance();
        r101.setTimeInMillis(r100);
        r101.set(11, 0);
        r101.set(12, 0);
        r101.set(13, 0);
        r101.set(14, 0);
        return r101.getTimeInMillis();
    }

    public static final a5 c(s5 r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        return new a5(r110.f387721b, r110.f387723d, r110.f387724e, r110.f387725f, true, System.currentTimeMillis(), r110.f387728i, r110.f387729j);
    }
}
