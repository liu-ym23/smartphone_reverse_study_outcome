package com.obric.assistant.oauto;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f390388a = null;

    static {
        f390388a = LazyKt.lazy(new a());
    }

    public static final IOAutoApi a() {
        return (IOAutoApi) f390388a.getValue();
    }
}
