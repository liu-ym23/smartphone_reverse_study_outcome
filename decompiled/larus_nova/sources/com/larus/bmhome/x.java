package com.larus.bmhome;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes25.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f317596a = null;

    static {
        f317596a = LazyKt.lazy(new w());
    }

    public static final IChatAzerothService a() {
        return (IChatAzerothService) f317596a.getValue();
    }
}
