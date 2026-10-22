package com.bytedance.locallife.live.experiment;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class LiveLocalLifeMultiThreadOPT {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f259494a = null;

    static {
        f259494a = LazyKt.lazy(LiveLocalLifeMultiThreadOPT$lazyValue$2.INSTANCE);
    }

    public static boolean b() {
        if (1 == ((Number) f259494a.getValue()).intValue()) goto L7;
        return false;
    L7:
        return true;
    }

    public static int a() {
        if (b() == false) goto L5;
        return 2;
    L5:
        return 0;
    }
}
