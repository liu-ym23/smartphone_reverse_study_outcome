package com.larus.agents.impl.experience;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class r {
    public static final t a(u r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = r110.c();
        if (r100 != null) goto L5;
    L38:
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        String r101 = r100;
    L8:
        if (r101 == null) goto L38;
        String r102 = r110.e();
        if (r102 != null) goto L13;
        return null;
    L13:
        String r103 = r110.b();
        if (r103 != null) goto L16;
        return null;
    L16:
        q r104 = r110.d();
        if (r104 != null) goto L19;
        return null;
    L19:
        String r105 = r104.getType();
        if (r105 != null) goto L22;
        return null;
    L22:
        Integer r106 = r104.b();
        if (r106 == null) goto L38;
        int r107 = r106.intValue();
        Long r108 = r104.a();
        if (r108 == null) goto L38;
        long r109 = r108.longValue();
        List<String> r111 = r104.c();
        if (r111 != null) goto L29;
        return null;
    L29:
        List r112 = CollectionsKt.filterNotNull(r111);
        if (r112.size() == r111.size()) goto L32;
        return null;
    L32:
        Boolean r113 = r110.a();
        if (r113 == null) goto L38;
        boolean r114 = r113.booleanValue();
        Long r115 = r110.f();
        if (r115 == null) goto L38;
        long r116 = r115.longValue();
        WorkExperienceSource.a r117 = WorkExperienceSource.Companion;
        Integer r118 = Integer.valueOf(r107);
        r117.getClass();
        return new t(r101, r102, r103, r105, WorkExperienceSource.a.a(r118), r109, r112, r114, r116);
    L7:
        r101 = null;
        goto L8
    }
}
