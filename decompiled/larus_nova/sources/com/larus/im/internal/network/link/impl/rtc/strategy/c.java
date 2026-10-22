package com.larus.im.internal.network.link.impl.rtc.strategy;

import com.larus.im.internal.utils.TimerUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f349429a = null;

    static {
        f349429a = new ConcurrentHashMap();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter("media_service", "trigger");
        Long r101 = f349429a.get(r100);
        if (r101 == null) goto L6;
        long r102 = r101.longValue();
        Lazy r103 = TimerUtils.f350521a;
        TimerUtils.a(new RTCTokenPreloadDedupeState$releaseAfterTtl$1(r100, r102, "media_service", null));
        return;
    }
}
