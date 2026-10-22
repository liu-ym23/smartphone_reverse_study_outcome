package com.larus.bmhome.social.page.datasource.event;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f314037a = null;

    static {
        f314037a = new AtomicInteger(0);
    }

    public static final String a(RefreshTraceSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        return r100.getTag() + '_' + System.currentTimeMillis() + '_' + f314037a.incrementAndGet();
    }

    public static final long b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "refreshTraceId");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L9;
        return -1;
    L9:
        List r111 = StringsKt.split$default(r110, new char[]{'_'}, false, 0, 6, null);
        if (r111.size() >= 3) goto L12;
        return -1;
    L12:
        Long r112 = StringsKt.toLongOrNull((String) ListProtector.get(r111, r111.size() - 2));
        if (r112 != null) goto L15;
        return -1;
    L15:
        return r112.longValue();
    L5:
        r100 = false;
        goto L7
    }
}
