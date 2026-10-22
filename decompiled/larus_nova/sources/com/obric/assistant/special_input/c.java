package com.obric.assistant.special_input;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f392713a = null;

    static {
        f392713a = LazyKt.lazy(new b());
    }

    public static final ISpecialInputTask a() {
        return (ISpecialInputTask) f392713a.getValue();
    }
}
