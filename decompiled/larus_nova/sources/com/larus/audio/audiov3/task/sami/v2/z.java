package com.larus.audio.audiov3.task.sami.v2;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes24.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f288672a = null;

    static {
        f288672a = LazyKt.lazy(new y());
    }

    public static final SamiConnectionPoolImpl a() {
        return (SamiConnectionPoolImpl) f288672a.getValue();
    }
}
