package se9;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f541623a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Long, xe9.b> f541624b = null;

    static {
        f541623a = new AtomicLong(0);
        f541624b = new ConcurrentHashMap();
    }

    public static long a(cf9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "sendInfo");
        int r101 = a.f541622a;
        byte[] r102 = r100.f23548a;
        Intrinsics.checkNotNullParameter(r102, "array");
        Long r103 = StringsKt.toLongOrNull(new String(r102, Charsets.UTF_8));
        if (r103 != null) goto L7;
        return 0;
    L7:
        return r103.longValue();
    }
}
