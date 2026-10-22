package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Uri, d0> f247611a = null;

    static {
        f247611a = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final d0 a(t36.d r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Boolean r101 = (Boolean) new y36.a(r100, "enable_prefetch", Boolean.FALSE).f565862b;
        if (r101 == null) goto L5;
        boolean r102 = r101.booleanValue();
    L6:
        d0 r103 = new d0(r102, r100.c().get("prefetch_business"), r100);
        Intrinsics.areEqual(r100.c().get("__dev"), "1");
        return r103;
    L5:
        r102 = false;
        goto L6
    }
}
