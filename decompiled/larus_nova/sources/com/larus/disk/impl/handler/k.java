package com.larus.disk.impl.handler;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes27.dex */
public final class k {
    public static final long b(PolarisFileWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        if (r100.exists() == true) goto L5;
        return 0;
    L5:
        Iterator r101 = SequencesKt.filter(FilesKt.walkTopDown(r100), new j()).iterator();
        long r102 = 0;
    L7:
        if (r101.hasNext() == false) goto L9;
        r102 = r102 + RangesKt.coerceAtLeast(com.larus.utils.r.r((File) r101.next()), 0);
        goto L7
    L9:
        return r102;
    }

    public static final void a(Function0<Long> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "getRemainingCleanableSize");
        Intrinsics.checkNotNullParameter(r101, "clearAction");
        long r102 = r100.invoke().longValue();
        r101.invoke();
        if (r102 > 0) goto L5;
        return;
    L5:
        long r103 = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
    L7:
        if (System.nanoTime() >= r103) goto L10;
        Thread.sleep(50);
        if (r100.invoke().longValue() > 0) goto L7;
        return;
    }
}
