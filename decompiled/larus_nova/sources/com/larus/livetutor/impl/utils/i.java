package com.larus.livetutor.impl.utils;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes30.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f356679a = null;

    static {
        f356679a = LazyKt.lazy(new h());
    }

    public static Keva a() {
        return (Keva) f356679a.getValue();
    }
}
